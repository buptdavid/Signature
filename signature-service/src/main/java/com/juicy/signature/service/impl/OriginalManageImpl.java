/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.RecommendDao;
import com.juicy.signature.persist.dao.SignatureClassDao;
import com.juicy.signature.persist.dao.SignatureOriginalDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.Recommend;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.OriginalManage;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;
import com.whirlycott.cache.Cache;
import com.whirlycott.cache.CacheException;
import com.whirlycott.cache.CacheManager;

/**
 * OriginalManage接口实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 31, 2011 创建
 *          </p>
 */
public class OriginalManageImpl implements OriginalManage {

	private SignatureClassDao signatureClassDao;

	private SignatureOriginalDao signatureOriginalDao;
	
	private RecommendDao recommendDao;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(OriginalManageImpl.class);

	public Result viewClass() throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			
			//获得Cache
			Cache cache = CacheManager.getInstance().getCache();
			//从缓存中取得数据
			List<SignatureClass> firstClassList = (List<SignatureClass>)cache.retrieve("firstOriginalClassManageList");
			List<SignatureClass> secondClassList = (List<SignatureClass>)cache.retrieve("secondOriginalClassManageList");
			
			//如果缓存中没有，则从数据库中取得
			if(firstClassList == null || secondClassList == null){
				// 签名盒分类来源的一级分类和二级分类
				firstClassList = signatureClassDao
						.findAllFirstByBasis(SignatureClass.ORIGINAL);
				secondClassList = signatureClassDao
						.findAllSecondByBasis(SignatureClass.ORIGINAL);

				// 对一二级分类进行互相赋值,比较麻烦，由于数据库没有外键
				if (firstClassList != null) {
					Iterator<SignatureClass> firstIt = firstClassList.iterator();
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
							SignatureClass firstClass = firstMap.get(parentId);
							secondClass.setFirstClass(firstClass);
							if (firstClass != null) {
								if (firstClass.getSecondClasses() == null) {
									List<SignatureClass> secondClasses = new ArrayList<SignatureClass>();
									secondClasses.add(secondClass);
									firstClass.setSecondClasses(secondClasses);
								} else {
									firstClass.getSecondClasses().add(secondClass);
								}
							}

						}
					}

				}
				
				//放入缓存中
				cache.store("firstOriginalClassManageList", firstClassList);
				cache.store("secondOriginalClassManageList", secondClassList);
			}

			result.setSuccess(true);
			result.getModel().put("firstClassList", firstClassList);
			result.getModel().put("secondClassList", secondClassList);

		} catch (SignaturePersistException e) {
			logger.error("Unable to view Classes for original from database", e);
			throw new SignatureServiceException(
					"Unable to view Classes for original from database", e);
		} catch (CacheException e) {
			logger.error("Unable to get Classes for original from cache", e);
			throw new SignatureServiceException(
					"Unable to get Classes for original from cache", e);
		}

		return result;
	}
	
	public Result viewSceondClass(Integer classId)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {
			List<SignatureClass> secondClassList = signatureClassDao.findSecondForFirst(classId);
			
			result.setSuccess(true);
			result.getModel().put("secondClassList", secondClassList);
			
		} catch (SignaturePersistException e) {
			logger.error("Unable to view second Classes for original from database", e);
			throw new SignatureServiceException(
					"Unable to view second Classes for original from database", e);
		}
		
		
		return result;
	}

	public Result createClass(SignatureClass signatureClass)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Integer parentId = signatureClass.getParentId();
			// 一级分类
			if (0 == parentId || parentId == null) {
				signatureClassDao.save(signatureClass);
			} else {
				// 二级分类
				SignatureClass parentClass = signatureClassDao
						.getById(parentId);
				if (parentClass != null) {
					signatureClassDao.save(signatureClass);
				} else {
					// 父类不存在,返回
					result.setRemark("没有设置一级分类");
					return result;
				}
			}
			
			//更新相应缓存
			updateCache();

			result.setSuccess(true);

		} catch (SignaturePersistException e) {
			logger.error("Unable to create Classes for original", e);
			throw new SignatureServiceException(
					"Unable to create Classes for original", e);
		}

		return result;
	}

	public Result deleteClass(SignatureClass signatureClass)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Integer parentId = signatureClass.getParentId();

			if (parentId == null || parentId == 0) {
				// 删除一级分类
				Integer classId = signatureClass.getId();
				// 查询其下的二级分类
				Integer count = signatureClassDao.findSecondCountByFirstId(
						SignatureClass.ORIGINAL, classId, null);
				if (count > 0) {
					result.setRemark("请先删除该类下的子类!");
					return result;
				} else {
					signatureClassDao.delete(signatureClass);
				}

			} else {
				// 删除二级分类
				signatureClassDao.delete(signatureClass);
			}

			//更新相应缓存
			updateCache();
			
			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to delete Classes for original", e);
			throw new SignatureServiceException(
					"Unable to delete Classes for original", e);
		} 
		
		return result;
	}

	public Result modifyClass(SignatureClass signatureClass)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer classId = signatureClass.getId();

		try {
			// 数据库中取得该对象
			SignatureClass signatureClass_1 = signatureClassDao
					.getById(classId);

			// 更新
			signatureClass_1.setBasis(signatureClass.getBasis());
			signatureClass_1.setName(signatureClass.getName());
			signatureClass_1.setParentId(signatureClass.getParentId());
			signatureClassDao.update(signatureClass_1);
			
			//更新相应缓存
			updateCache();

			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to modify Classes for original", e);
			throw new SignatureServiceException(
					"Unable to modify Classes for original", e);
		}

		return result;
	}

	public Result viewOriginal(SignatureClass signatureClass, Boolean publish,
			Byte auditStatus, Page page) throws SignatureServiceException {
		Result result = Result.createRestult();

		// 取得所有分类
		Result result_1 = this.viewClass();
		List<SignatureClass> firstClassList = null;
		List<SignatureClass> secondClassList = null;
		if (result_1.isSuccess()) {
			firstClassList = (List<SignatureClass>) result_1.getModel().get(
					"firstClassList");
			secondClassList = (List<SignatureClass>) result_1.getModel().get(
					"secondClassList");
		}

		try {
			//从数据中取得该类
			if(signatureClass != null){
				signatureClass = signatureClassDao.getById(signatureClass.getId());
			}
			
			List<SignatureOriginal> originalList = null;
			if (signatureClass != null && (signatureClass.getParentId() == null || signatureClass.getParentId() == 0)) {
				Integer parentId = signatureClass.getId();
				
				// 一级分类
				List<SignatureClass> secondClass = signatureClassDao
						.findSecondForFirst(parentId);
				List<Integer> classIdList = new ArrayList<Integer>();
				Iterator<SignatureClass> classIt = secondClass.iterator();
				while (classIt.hasNext()) {
					classIdList.add(classIt.next().getId());
				}

				Integer totalRecords = signatureOriginalDao
						.findCountByClassIdList(classIdList, publish,
								auditStatus);
				page = PageUtil.createPage(page, totalRecords);

				// 第一条记录索引和每页的记录数量
				Integer offSet = page.getBeginIndex();
				Integer pageSize = page.getEveryPage();

				// 分页取得签名
				originalList = signatureOriginalDao.findByClassIdList(
						classIdList, publish, auditStatus, offSet, pageSize);

			} else {
				// 二级分类
				Integer classId = signatureClass == null?null:signatureClass.getId();
				Integer totalRecords = signatureOriginalDao.findCountByClassId(
						classId, publish, auditStatus);
				page = PageUtil.createPage(page, totalRecords);

				// 第一条记录索引和每页的记录数量
				Integer offSet = page.getBeginIndex();
				Integer pageSize = page.getEveryPage();

				originalList = signatureOriginalDao.findByClassIdForPage(classId, publish, auditStatus, offSet, pageSize);
			}

			result.setSuccess(true);
			result.getModel().put("firstClassList", firstClassList);
			result.getModel().put("secondClassList", secondClassList);
			result.getModel().put("originalList", originalList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view original", e);
			throw new SignatureServiceException("Unable to view original", e);
		}

		return result;
	}
	
	public Result recommendOriginal(Integer originalId,Integer managerId)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {
			//取得该原创签名
			SignatureOriginal original = signatureOriginalDao.getById(originalId);
			
			Recommend recommend = new Recommend();			
			recommend.setContent(original.getContent());
			recommend.setCustomer(new HgCustomer(managerId));
			recommend.setIsDelete(false);
			recommend.setSource(SignatureClass.ORIGINAL);
			recommend.setTime(new Date());
			recommend.setForeignId(original.getId());
			
			//取得分类信息
			SignatureClass signatureClass = original.getSignatureClass();
			recommend.setClassId(signatureClass.getId());
			recommend.setClassName(signatureClass.getName());
			
			//父类分类信息
			Integer parentId = signatureClass.getParentId();
			if(parentId != null && parentId != 0 ){
				//取得父类分类
				SignatureClass parentClass = signatureClassDao.getById(parentId);
				recommend.setParentId(parentClass.getId());
				recommend.setParentName(parentClass.getName());
			}
			
			//保存推荐
			recommendDao.save(recommend);
			
			//置原签名推荐标志位
			original.setRecommend(true);
			signatureOriginalDao.update(original);
			
			//更新Cache
			Cache cache = CacheManager.getInstance().getCache();
			cache.remove("originalList");
			
			result.setSuccess(true);
			
		} catch (SignaturePersistException e) {
			logger.error("Unable to recommend original", e);
			throw new SignatureServiceException("Unable to recommends original", e);
		} catch (CacheException e) {
			logger.error("Unable to update originalList for cache", e);
			throw new SignatureServiceException(
					"Unable to update originalList for cache", e);
		}
		
		return result;
	}
	
	/**
	 * 清除缓存
	 * 
	 * @throws SignatureServiceException 
	 */
	private void updateCache() throws SignatureServiceException{
		
		try {
			//获得Cache,清除相应缓存
			Cache cache = CacheManager.getInstance().getCache();
			
			cache.remove("firstOriginalClassManageList");
			cache.remove("secondOriginalClassManageList");
			cache.remove("firstClassList_1");
			cache.remove("secondClassList_1");
		} catch (CacheException e) {
			logger.error("Unable to update firstOriginalClassManageList,secondOriginalClassManageList,firstClassList_1,secondClassList_1 for cache", e);
			throw new SignatureServiceException(
					"Unable to update firstOriginalClassManageList,secondOriginalClassManageList,firstClassList_1,secondClassList_1 for cache", e);
		}
		
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

	public RecommendDao getRecommendDao() {
		return recommendDao;
	}

	public void setRecommendDao(RecommendDao recommendDao) {
		this.recommendDao = recommendDao;
	}

	


}
