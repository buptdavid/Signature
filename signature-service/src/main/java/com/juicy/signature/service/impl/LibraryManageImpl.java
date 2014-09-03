/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
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
import com.juicy.signature.persist.dao.SignatureLibraryDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.Recommend;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.service.LibraryManage;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;
import com.whirlycott.cache.Cache;
import com.whirlycott.cache.CacheException;
import com.whirlycott.cache.CacheManager;

/**
 * LibraryManage�ӿ�ʵ����
 * 
 * @author ·����
 * @version <p>
 *          Oct 31, 2011 ����
 *          </p>
 */
public class LibraryManageImpl implements LibraryManage {

	private SignatureClassDao signatureClassDao;

	private SignatureLibraryDao signatureLibraryDao;
	
	private RecommendDao recommendDao;

	/** ��־��¼ */
	private static Log logger = LogFactory.getLog(LibraryManageImpl.class);

	public Result viewClass() throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// ���Cache
			Cache cache = CacheManager.getInstance().getCache();
			// �ӻ�����ȡ������
			List<SignatureClass> firstClassList = (List<SignatureClass>) cache
					.retrieve("firstLibraryClassManageList");
			List<SignatureClass> secondClassList = (List<SignatureClass>) cache
					.retrieve("secondLibraryClassManageList");

			// ���������û�У�������ݿ���ȡ��
			if (firstClassList == null || secondClassList == null) {
				// ǩ���з�����Դ��һ������Ͷ�������
				firstClassList = signatureClassDao
						.findAllFirstByBasis(SignatureClass.LIBRARY);
				secondClassList = signatureClassDao
						.findAllSecondByBasis(SignatureClass.LIBRARY);

				// ��һ����������л��ำֵ,�Ƚ��鷳���������ݿ�û�����
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
							SignatureClass firstClass = firstMap.get(parentId);
							secondClass.setFirstClass(firstClass);
							if (firstClass != null) {
								if (firstClass.getSecondClasses() == null) {
									List<SignatureClass> secondClasses = new ArrayList<SignatureClass>();
									secondClasses.add(secondClass);
									firstClass.setSecondClasses(secondClasses);
								} else {
									firstClass.getSecondClasses().add(
											secondClass);
								}
							}

						}
					}

				}
				
				//���뻺����
				cache.store("firstLibraryClassManageList", firstClassList);
				cache.store("secondLibraryClassManageList", secondClassList);
			}

			result.setSuccess(true);
			result.getModel().put("firstClassList", firstClassList);
			result.getModel().put("secondClassList", secondClassList);

		} catch (SignaturePersistException e) {
			logger.error("Unable to view Classes for library from database", e);
			throw new SignatureServiceException(
					"Unable to view Classes for library from database", e);
		} catch (CacheException e) {
			logger.error("Unable to get Classes for library from cache", e);
			throw new SignatureServiceException(
					"Unable to get Classes for library from cache", e);
		}

		return result;
	}

	public Result viewSceondClass(Integer classId)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			List<SignatureClass> secondClassList = signatureClassDao
					.findSecondForFirst(classId);

			result.setSuccess(true);
			result.getModel().put("secondClassList", secondClassList);

		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to view second Classes for library from database",
					e);
			throw new SignatureServiceException(
					"Unable to view second Classes for library from database",
					e);
		}

		return result;
	}

	public Result createClass(SignatureClass signatureClass)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Integer parentId = signatureClass.getParentId();
			// һ������
			if (0 == parentId || parentId == null) {
				signatureClassDao.save(signatureClass);
			} else {
				// ��������
				SignatureClass parentClass = signatureClassDao
						.getById(parentId);
				if (parentClass != null) {
					signatureClassDao.save(signatureClass);
				} else {
					// ���಻����,����
					result.setRemark("û������һ������");
					return result;
				}
			}
			
			//������Ӧ����
			updateCache();

			result.setSuccess(true);

		} catch (SignaturePersistException e) {
			logger.error("Unable to create Classes for library", e);
			throw new SignatureServiceException(
					"Unable to create Classes for library", e);
		} 
		
		return result;
	}

	public Result deleteClass(SignatureClass signatureClass)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Integer parentId = signatureClass.getParentId();

			if (parentId == null || parentId == 0) {
				// ɾ��һ������
				Integer classId = signatureClass.getId();
				// ��ѯ���µĶ�������
				Integer count = signatureClassDao.findSecondCountByFirstId(
						SignatureClass.LIBRARY, classId, null);
				if (count > 0) {
					result.setRemark("����ɾ�������µ�����!");
					return result;
				} else {
					signatureClassDao.delete(signatureClass);
				}

			} else {
				// ɾ����������
				signatureClassDao.delete(signatureClass);
			}

			//������Ӧ����
			updateCache();
			
			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to delete Classes for library", e);
			throw new SignatureServiceException(
					"Unable to delete Classes for library", e);
		}

		return result;
	}

	public Result modifyClass(SignatureClass signatureClass)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer classId = signatureClass.getId();

		try {
			// ���ݿ���ȡ�øö���
			SignatureClass signatureClass_1 = signatureClassDao
					.getById(classId);

			// ����
			signatureClass_1.setBasis(signatureClass.getBasis());
			signatureClass_1.setName(signatureClass.getName());
			signatureClass_1.setParentId(signatureClass.getParentId());
			signatureClassDao.update(signatureClass_1);
			
			//������Ӧ����
			updateCache();

			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to modify Classes for library", e);
			throw new SignatureServiceException(
					"Unable to modify Classes for library", e);
		}

		return result;
	}

	public Result viewLibrary(SignatureClass signatureClass, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// ȡ�����з���
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
			//��������ȡ�ø���
			if(signatureClass != null){
				signatureClass = signatureClassDao.getById(signatureClass.getId());
			}
			
			List<SignatureLibrary> libraryList = null;
			if (signatureClass != null && (signatureClass.getParentId() == null || signatureClass.getParentId() == 0)) {
				Integer parentId = signatureClass.getId();
				
				// һ������
				List<SignatureClass> secondClass = signatureClassDao
						.findSecondForFirst(parentId);
				List<Integer> classIdList = new ArrayList<Integer>();
				Iterator<SignatureClass> classIt = secondClass.iterator();
				while (classIt.hasNext()) {
					classIdList.add(classIt.next().getId());
				}

				Integer totalRecords = signatureLibraryDao
						.findCountByClassIdList(classIdList, null);
				page = PageUtil.createPage(page, totalRecords);

				// ��һ����¼������ÿҳ�ļ�¼����
				Integer offSet = page.getBeginIndex();
				Integer pageSize = page.getEveryPage();

				// ��ҳȡ��ǩ��
				libraryList = signatureLibraryDao.findByClassIdListForPage(
						classIdList, offSet, pageSize, null);

			} else {
				// ��������
				Integer classId = signatureClass == null ? null : signatureClass.getId();
				Integer totalRecords = signatureLibraryDao.findCountByClassId(
						classId, null);
				page = PageUtil.createPage(page, totalRecords);

				// ��һ����¼������ÿҳ�ļ�¼����
				Integer offSet = page.getBeginIndex();
				Integer pageSize = page.getEveryPage();

				libraryList = signatureLibraryDao.findByClassIdForPage(classId,
						offSet, pageSize, null);
			}

			result.setSuccess(true);
			result.getModel().put("firstClassList", firstClassList);
			result.getModel().put("secondClassList", secondClassList);
			result.getModel().put("libraryList", libraryList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view library", e);
			throw new SignatureServiceException("Unable to view library", e);
		}

		return result;
	}

	public Result createLibrary(SignatureLibrary library)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			//����س�����
			String content = library.getContent();
			content = content.replace("\r\n", "");
			library.setContent(content);
			
			signatureLibraryDao.save(library);

			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to create library", e);
			throw new SignatureServiceException("Unable to create library", e);
		}

		return result;
	}

	public Result deleteLibrary(List<Integer> libraries)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Iterator<Integer> it = libraries.iterator();
			while (it.hasNext()) {
				Integer id = it.next();
				signatureLibraryDao.delete(id);
			}

			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to delete library", e);
			throw new SignatureServiceException("Unable to delete library", e);
		}

		return result;
	}

	public Result modifyLibrary(SignatureLibrary library)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer libraryId = library.getId();
		try {
			//����س�����
			String content = library.getContent();
			content = content.replace("\r\n", "");
			library.setContent(content);
			
			
			SignatureLibrary signatureLibrary_1 = signatureLibraryDao
					.getById(libraryId);
			
			signatureLibrary_1.setContent(library.getContent());
			signatureLibrary_1.setSignatureClass(library.getSignatureClass());

			signatureLibraryDao.update(signatureLibrary_1);

			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to modify library", e);
			throw new SignatureServiceException("Unable to modify library", e);
		}

		return result;
	}
	
	public Result recommendLibrary(Integer libraryId, Integer managerId)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {
			//ȡ�ø�ǩ����ǩ��
			SignatureLibrary library = signatureLibraryDao.getById(libraryId);
			
			Recommend recommend = new Recommend();			
			recommend.setContent(library.getContent());
			recommend.setCustomer(new HgCustomer(managerId));
			recommend.setIsDelete(false);
			recommend.setSource(SignatureClass.LIBRARY);
			recommend.setTime(new Date());
			recommend.setForeignId(library.getId());
			
			//ȡ�÷�����Ϣ
			SignatureClass signatureClass = library.getSignatureClass();
			recommend.setClassId(signatureClass.getId());
			recommend.setClassName(signatureClass.getName());
			
			//���������Ϣ
			Integer parentId = signatureClass.getParentId();
			if(parentId != null && parentId != 0 ){
				//ȡ�ø������
				SignatureClass parentClass = signatureClassDao.getById(parentId);
				recommend.setParentId(parentClass.getId());
				recommend.setParentName(parentClass.getName());
			}
			
			recommendDao.save(recommend);
			
			//��ԭǩ�����Ƽ���־λ
			library.setRecommend(true);
			signatureLibraryDao.update(library);
			
			//����Cache
			Cache cache = CacheManager.getInstance().getCache();
			cache.remove("wonderfulList_1");
			cache.remove("wonderfulList_2");
			
			result.setSuccess(true);
			
		} catch (SignaturePersistException e) {
			logger.error("Unable to recommend original", e);
			throw new SignatureServiceException("Unable to recommends original", e);
		} catch (CacheException e) {
			logger.error("Unable to update wonderfulList_1 wonderfulList_2 for cache", e);
			throw new SignatureServiceException(
					"Unable to update wonderfulList_1 wonderfulList_2 for cache", e);
		}
		
		return result;
	}
	
	
	/**
	 * �������
	 * 
	 * @throws SignatureServiceException 
	 */
	private void updateCache() throws SignatureServiceException{
		try {
			//���Cache,�����Ӧ����
			Cache cache = CacheManager.getInstance().getCache();
			
			cache.remove("firstLibraryClassManageList");
			cache.remove("secondLibraryClassManageList");
			cache.remove("firstClassList_2");
			cache.remove("secondClassList_2");
		} catch (CacheException e) {
			logger.error("Unable to update firstLibraryClassManageList,secondLibraryClassManageList,firstClassList_2,secondClassList_2 for cache", e);
			throw new SignatureServiceException(
					"Unable to update firstLibraryClassManageList,secondLibraryClassManageList,firstClassList_2,secondClassList_2 for cache", e);
		}
		
	}
	
	

	public SignatureClassDao getSignatureClassDao() {
		return signatureClassDao;
	}

	public void setSignatureClassDao(SignatureClassDao signatureClassDao) {
		this.signatureClassDao = signatureClassDao;
	}

	public SignatureLibraryDao getSignatureLibraryDao() {
		return signatureLibraryDao;
	}

	public void setSignatureLibraryDao(SignatureLibraryDao signatureLibraryDao) {
		this.signatureLibraryDao = signatureLibraryDao;
	}

	public RecommendDao getRecommendDao() {
		return recommendDao;
	}

	public void setRecommendDao(RecommendDao recommendDao) {
		this.recommendDao = recommendDao;
	}

	

}
