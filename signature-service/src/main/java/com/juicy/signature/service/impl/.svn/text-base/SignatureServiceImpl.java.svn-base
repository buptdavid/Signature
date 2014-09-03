/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.SignatureClassDao;
import com.juicy.signature.persist.dao.SignatureCollectDao;
import com.juicy.signature.persist.dao.SignatureLibraryDao;
import com.juicy.signature.persist.dao.SignatureOriginalDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Portal;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureCollect;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.SignatureService;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.filter.Filter;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.juicy.signature.service.util.ParameterUtil;
import com.whirlycott.cache.Cache;
import com.whirlycott.cache.CacheException;
import com.whirlycott.cache.CacheManager;

/**
 * SignatureService实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-4 创建
 *          </p>
 */
public class SignatureServiceImpl implements SignatureService {

	private SignatureClassDao signatureClassDao;

	private SignatureOriginalDao signatureOriginalDao;

	private SignatureLibraryDao signatureLibraryDao;

	private SignatureCollectDao signatureCollectDao;

	private Filter filter;

	private ParameterUtil parameterUtil;

	/** 每天可创建的原创签名的最大数量,默认为30 */
	private Integer maxCountOriginal;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(SignatureServiceImpl.class);

	public Result createClasses(SignatureClass signatureClass)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 保存
			signatureClassDao.save(signatureClass);

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("signatureClass", signatureClass);
		} catch (SignaturePersistException e) {
			logger.error("Unable to create class: " + signatureClass.getName(),
					e);
			throw new SignatureServiceException("Unable to create class: "
					+ signatureClass.getName(), e);
		}

		return result;
	}

	public Result modifyClasses(SignatureClass signatureClass)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer classId = signatureClass.getId();

		try {
			SignatureClass signatureClass2 = signatureClassDao.getById(classId);
			Byte basis = signatureClass.getBasis();
			if (basis != null) {
				signatureClass2.setBasis(basis);
			}

			String name = signatureClass.getName();
			if (name != null) {
				signatureClass2.setName(name);
			}

			Integer parentId = signatureClass.getParentId();
			if (parentId != null) {
				signatureClass2.setParentId(parentId);
			}

			signatureClassDao.update(signatureClass2);

			// 返回到结果
			result.setSuccess(true);
			result.getModel().put("signatureClass", signatureClass2);

		} catch (SignaturePersistException e) {
			logger.error("Unable to modify class ", e);
			throw new SignatureServiceException("Unable to modify class ", e);
		}

		return result;
	}

	public Result deleteClasses(SignatureClass signatureClass)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 取出该分类
			Integer id = signatureClass.getId();
			SignatureClass signatureClass2 = signatureClassDao.getById(id);

			// 取得父类ID
			Integer parentId = signatureClass2.getParentId();

			// 如果为二级分类，则直接删除
			if (parentId != 0) {
				signatureClassDao.delete(signatureClass2);

				// 要返回的结果
				result.setSuccess(true);
			} else {// 删除一级分类
				// 查询该一级分类的二级分类
				List<SignatureClass> secondClassList = signatureClassDao
						.findSecondForFirst(id);

				// 如果没有二级分类，则可以删除，否则不能删除
				if (secondClassList.size() == 0) {
					signatureClassDao.delete(signatureClass2);

					// 要返回的结果
					result.setSuccess(true);
				} else {
					// 不能删除，即删除失败
					result.setRemark("该分类下含有二级分类!");
				}
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to delete class: " + signatureClass.getName(),
					e);
			throw new SignatureServiceException("Unable to delete class: "
					+ signatureClass.getName(), e);
		}

		return result;
	}

	public Result getClassesByBasis(Byte basis, Byte firstOrSecondOrAll)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			List<SignatureClass> firstClassList = null;
			List<SignatureClass> secondClassList = null;

			// 获得Cache
			Cache cache = CacheManager.getInstance().getCache();

			if (firstOrSecondOrAll.equals(SignatureService.FIRST)) {
				firstClassList = signatureClassDao.findAllFirstByBasis(basis);
			} else if (firstOrSecondOrAll.equals(SignatureService.SECOND)) {
				secondClassList = signatureClassDao.findAllSecondByBasis(basis);
			} else if (firstOrSecondOrAll.equals(SignatureService.ALL)) {
				// 取出缓存数据
				firstClassList = (List<SignatureClass>) cache
						.retrieve("firstClassList_" + basis);
				secondClassList = (List<SignatureClass>) cache
						.retrieve("secondClassList_" + basis);
				// 如果缓存中不存在，则从数据库中查询
				if (firstClassList == null || secondClassList == null) {
					firstClassList = signatureClassDao
							.findAllFirstByBasis(basis);
					secondClassList = signatureClassDao
							.findAllSecondByBasis(basis);

					// 对一二级分类进行互相赋值,比较麻烦，由于数据库没有外键
					if (firstClassList != null) {
						Iterator<SignatureClass> firstIt = firstClassList
								.iterator();
						Map<Integer, SignatureClass> firstMap = new HashMap<Integer, SignatureClass>();
						while (firstIt.hasNext()) {
							SignatureClass firstClass = firstIt.next();
							firstMap.put(firstClass.getId(), firstClass);
						}

						if (secondClassList != null) {
							Iterator<SignatureClass> secondIt = secondClassList
									.iterator();
							while (secondIt.hasNext()) {
								SignatureClass secondClass = secondIt.next();
								Integer parentId = secondClass.getParentId();
								SignatureClass firstClass = firstMap
										.get(parentId);
								secondClass.setFirstClass(firstClass);
								if (firstClass != null) {
									if (firstClass.getSecondClasses() == null) {
										List<SignatureClass> secondClasses = new ArrayList<SignatureClass>();
										secondClasses.add(secondClass);
										firstClass
												.setSecondClasses(secondClasses);
									} else {
										firstClass.getSecondClasses().add(
												secondClass);
									}
								}

							}
						}

					}

					// 将结果放入缓存
					cache.store("firstClassList_" + basis, firstClassList);
					cache.store("secondClassList_" + basis, secondClassList);
				}

			}

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("firstClassList", firstClassList);
			result.getModel().put("secondClassList", secondClassList);
			result.getModel().put("maxCountOriginal",
					this.getMaxCountOriginal());

		} catch (SignaturePersistException e) {
			logger.error("Unable to get Classes for basis: " + basis, e);
			throw new SignatureServiceException(
					"Unable to get Classes for basis: " + basis, e);
		} catch (CacheException e) {
			logger.error(
					"Unable to get Classes from cache for basis: " + basis, e);
			throw new SignatureServiceException(
					"Unable to get Classes from cache for basis: " + basis, e);
		}
		return result;
	}

	public Result getSecondClassesByFirst(Integer firstClassId)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			List<SignatureClass> secondClassList = signatureClassDao
					.findSecondForFirst(firstClassId);

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("secondClassList", secondClassList);
		} catch (SignaturePersistException e) {
			logger.error("Unable to get second classes by first: "
					+ firstClassId, e);
			throw new SignatureServiceException(
					"Unable to get second classes by first: " + firstClassId, e);
		}

		return result;
	}

	public Result getLibraryClasses(Integer firstClassId, String keyWord,
			Page page) throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			List<SignatureClass> firstClassList = signatureClassDao
					.findAllFirstByBasis(SignatureClass.LIBRARY);

			Integer totalRecords = signatureClassDao.findSecondCountByFirstId(
					SignatureClass.LIBRARY, firstClassId, keyWord);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			// 二级分类
			List<SignatureClass> secondClassList = signatureClassDao
					.findSecondByFirstId(SignatureClass.LIBRARY, firstClassId,
							keyWord, offSet, pageSize);

			// 对一二级分类进行互相赋值,比较麻烦，由于数据库没有外键
			Iterator<SignatureClass> firstIt = firstClassList.iterator();
			Map<Integer, SignatureClass> firstMap = new HashMap<Integer, SignatureClass>();
			while (firstIt.hasNext()) {
				SignatureClass firstClass = firstIt.next();
				firstMap.put(firstClass.getId(), firstClass);
			}

			Iterator<SignatureClass> secondIt = secondClassList.iterator();
			while (secondIt.hasNext()) {
				SignatureClass secondClass = secondIt.next();
				Integer parentId = secondClass.getParentId();
				SignatureClass firstClass = firstMap.get(parentId);
				secondClass.setFirstClass(firstClass);
			}

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("firstClassList", firstClassList);
			result.getModel().put("secondClassList", secondClassList);
			result.getModel().put("page", page);

		} catch (SignaturePersistException e) {
			logger.error("Unable to get library classes", e);
			throw new SignatureServiceException(
					"Unable to get library classes", e);
		}

		return result;
	}

	public Result getLibrarySignature(Integer secondClassId, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 数据库中取得该对象
			SignatureClass signatureClass = signatureClassDao
					.getById(secondClassId);
			// 设置父类
			Integer parentId = signatureClass.getParentId();
			signatureClass.setFirstClass(signatureClassDao.getById(parentId));

			// 取得该签名盒中签名总数量,并新生成Page对象
			Integer totalRecords = signatureLibraryDao.findCountByClassId(
					secondClassId, null);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<SignatureLibrary> signatureLibraryList = signatureLibraryDao
					.findByClassIdForPage(secondClassId, offSet, pageSize, null);

			// 返回结果
			result.setSuccess(true);
			result.getModel().put("signatureClass", signatureClass);
			result.getModel().put("signatureLibraryList", signatureLibraryList);
			result.getModel().put("page", page);

		} catch (SignaturePersistException e) {
			logger.error("Unable to get library signature by library id:"
					+ secondClassId, e);
			throw new SignatureServiceException(
					"Unable to get library signature by library id:"
							+ secondClassId, e);
		}
		return result;
	}

	public Result createOriginal(SignatureOriginal signatureOriginal)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 获得当天零时的时间
			Calendar calender = Calendar.getInstance();
			calender.set(calender.get(Calendar.YEAR),
					calender.get(Calendar.MONTH),
					calender.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			Date date = calender.getTime();

			// 如果
			Integer count = signatureOriginalDao.findCountForTime(
					signatureOriginal.getCustomer().getId(), date);
			if (count >= this.getMaxCountOriginal()) {
				logger.info("超过了原创签名每日创建最大值");
				result.setRemark("-->您今天创建的数量超过了" + this.getMaxCountOriginal()
						+ "条");
				return result;
			}

			// 对内容进行敏感词过滤审核
			String content = signatureOriginal.getContent();
			if (filter.contain(content) == null) {
				// 审核通过
				signatureOriginal.setAuditStatus(SignatureOriginal.PASSAUDIT);
			} else {
				// 审核未通过
				signatureOriginal.setAuditStatus(SignatureOriginal.UNPASSAUDIT);
			}

			// 替代回车换行
			content = content.replace("\r\n", "");
			signatureOriginal.setContent(content);

			// 设置创建时间,修改时间和推荐状态
			Date currentTime = new Date();
			signatureOriginal.setGmtTime(currentTime);
			signatureOriginal.setMdfTime(currentTime);
			signatureOriginal.setRecommend(false);

			signatureOriginalDao.save(signatureOriginal);

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("signatureOriginal", signatureOriginal);
		} catch (SignaturePersistException e) {
			logger.error("Unable to create original", e);
			throw new SignatureServiceException("Unable to create original", e);
		}

		return result;
	}

	public Result modifyOriginal(SignatureOriginal signatureOriginal)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer originalId = signatureOriginal.getId();

		try {
			// 取得数据库相应记录，依次判断更新
			SignatureOriginal signatureOriginal2 = signatureOriginalDao
					.getById(originalId);

			Byte auditStatus = signatureOriginal.getAuditStatus();
			if (auditStatus != null) {
				signatureOriginal2.setAuditStatus(auditStatus);
			}

			String content = signatureOriginal.getContent();
			if (content != null) {
				// 敏感词过滤审核
				if (filter.contain(content) == null) {
					// 审核通过
					signatureOriginal2
							.setAuditStatus(SignatureOriginal.PASSAUDIT);
				} else {
					// 审核未通过
					signatureOriginal2
							.setAuditStatus(SignatureOriginal.UNPASSAUDIT);
				}
				signatureOriginal2.setContent(content);
			}

			SignatureClass signatureClass = signatureOriginal
					.getSignatureClass();
			if (signatureClass != null) {
				signatureOriginal2.setSignatureClass(signatureClass);
			}

			// 设置更新时间
			Date currentTime = new Date();
			signatureOriginal.setMdfTime(currentTime);

			// 更新
			signatureOriginalDao.update(signatureOriginal2);

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("signatureOriginal", signatureOriginal);

		} catch (SignaturePersistException e) {
			logger.error("Unable to modify original class", e);
			throw new SignatureServiceException(
					"Unable to modify original class", e);
		}

		return result;
	}

	public Result deleteOriginal(List<Integer> originalIdList)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 循环删除
		Iterator<Integer> it = originalIdList.iterator();
		try {
			while (it.hasNext()) {
				Integer signatureId = it.next();
				signatureOriginalDao.delete(signatureId);

				// 要返回的结果
				result.setSuccess(true);
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to delete original signature", e);
			throw new SignatureServiceException(
					"Unable to delete original signature", e);
		}

		return result;
	}

	public Result getOriginal(User user, String content, Byte auditStatud,
			Page page) throws SignatureServiceException {
		Result result = Result.createRestult();
		Integer customerId = user.getCustomerId();

		try {
			// 取得该用户原创签名的数量,并新生成Page对象
			Integer totalRecords = signatureOriginalDao.findCountByCustomerId(
					customerId, null, auditStatud, content);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<SignatureOriginal> signatureOriginalList = signatureOriginalDao
					.findByCustomerIdForPage(customerId, null, auditStatud,
							content, offSet, pageSize);

			// 要返回的结果
			result.setSuccess(true);
			result.getModel().put("signatureOriginalList",
					signatureOriginalList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to get original for user: " + user.getLoginName(),
					e);
			throw new SignatureServiceException(
					"Unable to get original for user: " + user.getLoginName(),
					e);
		}

		return result;
	}

	public Result createLibrary(SignatureLibrary signatureLibrary)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			signatureLibraryDao.save(signatureLibrary);

			// 要返回的结果
			result.setSuccess(true);
			result.getModel().put("signatureLibrary", signatureLibrary);
		} catch (SignaturePersistException e) {
			logger.error("Unable to create library", e);
			throw new SignatureServiceException("Unable to create library", e);
		}

		return result;
	}

	public Result modifyLibrary(SignatureLibrary signatureLibrary)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer libraryId = signatureLibrary.getId();

		try {
			// 取得
			SignatureLibrary signatureLibrary2 = signatureLibraryDao
					.getById(libraryId);

			signatureLibrary2.setContent(signatureLibrary.getContent());
			signatureLibrary2.setSignatureClass(signatureLibrary
					.getSignatureClass());

			// 更新
			signatureLibraryDao.update(signatureLibrary2);

			// 要返回的结果
			result.setSuccess(true);
			result.getModel().put("signatureLibrary", signatureLibrary2);
		} catch (SignaturePersistException e) {
			logger.error("Unable to modify library", e);
			throw new SignatureServiceException("Unable to modify library", e);
		}

		return result;
	}

	public Result deleteLibrary(List<SignatureLibrary> signatureLibraryList)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Iterator<SignatureLibrary> it = signatureLibraryList.iterator();

		try {
			// 循环遍历删除
			while (it.hasNext()) {
				SignatureLibrary signatureLibrary = it.next();
				signatureLibraryDao.delete(signatureLibrary);
			}

			// 要返回的结果
			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to delete library", e);
			throw new SignatureServiceException("Unable to delete library", e);
		}
		return result;
	}

	public Result getLibrary(SignatureClass signatureClass, String content,
			Page page) throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer parentId = signatureClass.getParentId();

		try {
			List<SignatureLibrary> signatureLibraryList;
			// 查询一级分类的签名
			if (parentId == 0) {
				// 查询该分类下的二级分类
				Iterator<SignatureClass> it = signatureClassDao
						.findSecondForFirst(signatureClass.getId()).iterator();

				// 取得classIdList
				List<Integer> classIdList = new ArrayList<Integer>();
				while (it.hasNext()) {
					Integer classId = it.next().getId();
					classIdList.add(classId);
				}

				// 将一级分类的ID加入
				classIdList.add(signatureClass.getId());

				// 查询总数量,并生成新Page对象
				Integer totalRecords = signatureLibraryDao
						.findCountByClassIdList(classIdList, content);
				page = PageUtil.createPage(page, totalRecords);

				// 第一条记录索引和每页的记录数量
				Integer offSet = page.getBeginIndex();
				Integer pageSize = page.getEveryPage();

				signatureLibraryList = signatureLibraryDao
						.findByClassIdListForPage(classIdList, offSet,
								pageSize, content);

			} else {
				// 查询二级分类的签名
				Integer classId = signatureClass.getId();

				// 查询总数量，并生成新Page对象
				Integer totalRecords = signatureLibraryDao.findCountByClassId(
						classId, content);
				page = PageUtil.createPage(page, totalRecords);

				// 第一条记录索引和每页的记录数量
				Integer offSet = page.getBeginIndex();
				Integer pageSize = page.getEveryPage();

				signatureLibraryList = signatureLibraryDao
						.findByClassIdForPage(classId, offSet, pageSize,
								content);
			}

			// 返回到结果
			result.setSuccess(true);
			result.getModel().put("signatureLibraryList", signatureLibraryList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to get library for class: "
							+ signatureClass.getName(), e);
			throw new SignatureServiceException(
					"Unable to get library for class: "
							+ signatureClass.getName(), e);
		}

		return result;
	}

	public Result getLibrary(String content, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 查询总数量，并新生成Page对象
			Integer totalRecords = signatureLibraryDao.findCount(content);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();
			List<SignatureLibrary> signatureLibrarieList = signatureLibraryDao
					.findForPage(offSet, pageSize, content);

			result.setSuccess(true);
			result.getModel()
					.put("signatureLibraryList", signatureLibrarieList);
			result.getModel().put("page", page);

		} catch (SignaturePersistException e) {
			logger.error("Unable to get Library for page by content: "
					+ content, e);
			throw new SignatureServiceException(
					"Unable to get Library for page by content: " + content, e);
		}

		return result;
	}

	public Result createCollect(SignatureCollect signatureCollect)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 保存
		try {
			Integer classId = signatureCollect.getClassId();
			String className = null;
			Integer parentClassId = 0;
			String parentClassName = null;
			if (classId != null) {
				SignatureClass signatureClass = signatureClassDao
						.getById(classId);
				className = signatureClass.getName();

				Integer parentId = signatureClass.getParentId();
				if (parentId > 0) {
					SignatureClass parentClass = signatureClassDao
							.getById(parentId);
					parentClassId = parentClass.getId();
					parentClassName = parentClass.getName();
				}
			}

			// 设置类的信息
			signatureCollect.setClassName(className);
			signatureCollect.setParentClassId(parentClassId);
			signatureCollect.setParentClassName(parentClassName);

			// 设置时间
			Date currentTime = new Date();
			signatureCollect.setCollectTime(currentTime);

			signatureCollectDao.save(signatureCollect);

			// 返回的结果
			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to create collect", e);
			throw new SignatureServiceException("Unable to create collect", e);
		}

		return result;
	}

	public Result modifyCollect(SignatureCollect signatureCollect)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer collectId = signatureCollect.getId();

		try {
			// 取得该对象并依次判断更新
			SignatureCollect signatureCollect2 = signatureCollectDao
					.getById(collectId);

			Integer classId = signatureCollect.getClassId();
			if (classId != null) {
				signatureCollect2.setClassId(classId);
			}

			String className = signatureCollect.getClassName();
			if (className != null) {
				signatureCollect2.setClassName(className);
			}

			String content = signatureCollect.getContent();
			if (content != null) {
				signatureCollect2.setContent(content);
			}

			signatureCollectDao.update(signatureCollect2);

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("signatureCollect", signatureCollect2);

		} catch (SignaturePersistException e) {
			logger.error("Unable to modify collect", e);
			throw new SignatureServiceException("Unable to modify collect", e);
		}

		return result;
	}

	public Result deleteCollect(List<Integer> collectIdList)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Iterator<Integer> it = collectIdList.iterator();

		// 循环删除
		while (it.hasNext()) {
			Integer collectId = it.next();
			try {
				signatureCollectDao.delete(collectId);

				// 返回的结果
				result.setSuccess(true);
			} catch (SignaturePersistException e) {
				logger.error("Unable to delete collect", e);
				throw new SignatureServiceException("Unable to delete collect",
						e);
			}
		}

		return result;
	}

	public Result getCollect(User user, SignatureClass signatureClass, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer customerId = user.getCustomerId();
		Integer classId = null;
		if (signatureClass != null) {
			classId = signatureClass.getId();
		}

		try {
			Integer totalRecords = signatureCollectDao
					.findCountByCustomerIdAndClassId(customerId, classId);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();
			List<SignatureCollect> signatureCollectList = signatureCollectDao
					.findByCustomerIdAndClassIdForPage(customerId, classId,
							offSet, pageSize);

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("signatureCollectList", signatureCollectList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to get collect", e);
			throw new SignatureServiceException("Unable to get collect", e);
		}

		return result;
	}

	public Result getCollectLibrary(User user, Integer firstClassId,
			String keyWord, Page page) throws SignatureServiceException {
		Result result = Result.createRestult();

		// 客户ID
		Integer customerId = user.getCustomerId();

		try {
			// 取得所有签名宝库（盒）一级分类
			List<SignatureClass> signatureClassList = signatureClassDao
					.findAllFirstByBasis(SignatureClass.LIBRARY);

			// 查询记录总数并新生成Page对象
			Integer totalRecords = signatureCollectDao
					.findLibraryCountByCustomerIdAndParent(customerId,
							firstClassId, keyWord);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();
			Integer currentPage = page.getCurrentPage();

			// 查询,offSet和pageSize没有用
			List<SignatureCollect> signatureCollectListLoad = signatureCollectDao
					.findLibraryByCustomerIdAndParentForPage(customerId,
							firstClassId, keyWord, offSet, pageSize);

			// signatureCollectListLoad.
			// Set s = new HashSet();
			// s.

			// 遍历所有对象，根据classId不同进行分组封装
			Map<Integer, SignatureCollect> signatureCollectMap = new HashMap<Integer, SignatureCollect>();
			Iterator<SignatureCollect> it = signatureCollectListLoad.iterator();
			while (it.hasNext()) {
				SignatureCollect signatureCollect = it.next();
				Integer classId = signatureCollect.getClassId();
				signatureCollectMap.put(classId, signatureCollect);
			}

			// 取得所有对象
			Collection<SignatureCollect> signatureCollects = signatureCollectMap
					.values();

			// 模拟分页取得对象列表
			Integer toIndex = (currentPage * pageSize) - 1;
			if (toIndex > totalRecords) {
				toIndex = totalRecords;
			}
			Object[] signatureCollectObjects = signatureCollects.toArray();
			List<SignatureCollect> signatureCollectList = new ArrayList<SignatureCollect>();
			for (int i = offSet; i < toIndex; i++) {
				signatureCollectList
						.add((SignatureCollect) signatureCollectObjects[i]);
			}

			// 返回结果
			result.setSuccess(true);
			result.getModel().put("signatureClassList", signatureClassList);
			result.getModel().put("signatureCollectList", signatureCollectList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to get collect library for user: "
							+ user.getLoginName(), e);
			throw new SignatureServiceException(
					"Unable to get collect library for user: "
							+ user.getLoginName(), e);
		}

		return result;
	}

	public Result getOriginalByClass(SignatureClass signatureClass,
			Byte auditStatus, Boolean publish, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer parentId = signatureClass.getParentId();

		try {
			List<SignatureOriginal> originalList;

			// 二级分类
			if (parentId == 0) {
				// 查找该一级分类下的二级分类
				List<SignatureClass> secondClassList = signatureClassDao
						.findSecondForFirst(signatureClass.getId());

				List<Integer> classIdList = new ArrayList<Integer>();
				// 加上一级分类ID
				classIdList.add(signatureClass.getId());
				Iterator<SignatureClass> it = secondClassList.iterator();
				while (it.hasNext()) {
					classIdList.add(it.next().getId());
				}

				// 总数量
				Integer totalRecords = signatureOriginalDao
						.findCountByClassIdList(classIdList, publish,
								auditStatus);
				page = PageUtil.createPage(page, totalRecords);

				// 第一条记录索引和每页的记录数量
				Integer offSet = page.getBeginIndex();
				Integer pageSize = page.getEveryPage();

				// 查找
				originalList = signatureOriginalDao.findByClassIdList(
						classIdList, publish, auditStatus, offSet, pageSize);

			} else {
				Integer classId = signatureClass.getId();
				// 总数量
				Integer totalRecords = signatureOriginalDao.findCountByClassId(
						classId, publish, auditStatus);

				page = PageUtil.createPage(page, totalRecords);

				// 第一条记录索引和每页的记录数量
				Integer offSet = page.getBeginIndex();
				Integer pageSize = page.getEveryPage();

				originalList = signatureOriginalDao.findByClassIdForPage(
						classId, publish, auditStatus, offSet, pageSize);

			}

			result.setSuccess(true);
			result.getModel().put("signatureOriginalList", originalList);
			result.getModel().put("page", page);

		} catch (SignaturePersistException e) {
			logger.error("Unable to get original for classId: "
					+ signatureClass.getId(), e);
			throw new SignatureServiceException(
					"Unable to get original for classId: "
							+ signatureClass.getId(), e);
		}

		return result;
	}

	public Result getOriginal(String content, Boolean publish,
			Byte auditStatus, Page page) throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 取得原创签名的数量,并新生成Page对象
			Integer totalRecords = signatureOriginalDao.findCountByContent(
					content, publish, auditStatus);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<SignatureOriginal> signatureOriginalList = signatureOriginalDao
					.findByContentForPage(content, publish, auditStatus,
							offSet, pageSize);

			// 要返回的结果
			result.setSuccess(true);
			result.getModel().put("signatureOriginalList",
					signatureOriginalList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to search original", e);
			throw new SignatureServiceException("Unable to search original", e);
		}

		return result;

	}

	public SignatureClassDao getSignatureClassDao() {
		return signatureClassDao;
	}

	public void setSignatureClassDao(SignatureClassDao signatureClassDao) {
		this.signatureClassDao = signatureClassDao;
	}

	public SignatureOriginalDao getSignatureOriginalDao() {
		return signatureOriginalDao;
	}

	public void setSignatureOriginalDao(
			SignatureOriginalDao signatureOriginalDao) {
		this.signatureOriginalDao = signatureOriginalDao;
	}

	public SignatureLibraryDao getSignatureLibraryDao() {
		return signatureLibraryDao;
	}

	public void setSignatureLibraryDao(SignatureLibraryDao signatureLibraryDao) {
		this.signatureLibraryDao = signatureLibraryDao;
	}

	public SignatureCollectDao getSignatureCollectDao() {
		return signatureCollectDao;
	}

	public void setSignatureCollectDao(SignatureCollectDao signatureCollectDao) {
		this.signatureCollectDao = signatureCollectDao;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public Integer getMaxCountOriginal() throws SignatureServiceException {
		Portal portal = (Portal) parameterUtil.getParameter("portal");

		if (portal != null) {
			return portal.getMaxCountOriginal();
		} else {
			return maxCountOriginal;
		}

	}

	public void setMaxCountOriginal(Integer maxCountOriginal) {
		this.maxCountOriginal = maxCountOriginal;
	}

	public ParameterUtil getParameterUtil() {
		return parameterUtil;
	}

	public void setParameterUtil(ParameterUtil parameterUtil) {
		this.parameterUtil = parameterUtil;
	}

}
