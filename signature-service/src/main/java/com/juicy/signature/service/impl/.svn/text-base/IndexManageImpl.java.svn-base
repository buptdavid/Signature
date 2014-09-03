/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.ActivityDao;
import com.juicy.signature.persist.dao.RecommendDao;
import com.juicy.signature.persist.dao.SignatureClassDao;
import com.juicy.signature.persist.dao.SignatureLibraryDao;
import com.juicy.signature.persist.dao.SignatureOriginalDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Activity;
import com.juicy.signature.persist.po.Recommend;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.IndexManage;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;
import com.whirlycott.cache.Cache;
import com.whirlycott.cache.CacheException;
import com.whirlycott.cache.CacheManager;

/**
 * IndexManage接口实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 28, 2011 创建
 *          </p>
 */
public class IndexManageImpl implements IndexManage {

	ActivityDao activityDao;

	RecommendDao recommendDao;

	private SignatureLibraryDao signatureLibraryDao;

	private SignatureOriginalDao signatureOriginalDao;

	private SignatureClassDao signatureClassDao;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(IndexManageImpl.class);

	public Result viewActivity() throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			List<Activity> activities = activityDao
					.findActivityByIndex(Integer.MAX_VALUE);

			result.setSuccess(true);
			result.getModel().put("activities", activities);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view activity");
			throw new SignatureServiceException("Unable to view activity", e);
		}

		return result;
	}

	public Result cancelIndex(List<Integer> activities)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Iterator<Integer> it = activities.iterator();
			while (it.hasNext()) {
				Integer activityId = it.next();
				// 取得该对象并置首页不显示标志位
				Activity activity = activityDao.getById(activityId);
				activity.setIsIndex(false);
				activityDao.update(activity);
				result.setSuccess(true);
			}

			// 更新相应缓存
			Cache cache = CacheManager.getInstance().getCache();
			cache.remove("activityList");

		} catch (SignaturePersistException e) {
			logger.error("Unable to cancel index");
			throw new SignatureServiceException("Unable to cancel index", e);
		} catch (CacheException e) {
			logger.error("Unable to update activityList for cache", e);
			throw new SignatureServiceException(
					"Unable to update activityList for cache", e);
		}

		return result;
	}

	public Result deleteActivity(List<Integer> activities)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Iterator<Integer> it = activities.iterator();
			while (it.hasNext()) {
				Integer activityId = it.next();
				activityDao.deleteFlag(activityId);

				result.setSuccess(true);
			}

			// 更新相应缓存
			Cache cache = CacheManager.getInstance().getCache();
			cache.remove("activityList");

		} catch (SignaturePersistException e) {
			logger.error("Unable to delete activity");
			throw new SignatureServiceException("Unable to delete activity", e);
		} catch (CacheException e) {
			logger.error("Unable to update activityList for cache", e);
			throw new SignatureServiceException(
					"Unable to update activityList for cache", e);
		}

		return result;
	}

	public Result viewLibrary(Boolean isDelete, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 总数量
			Integer totalRecords = recommendDao.findCount(null,
					Recommend.SOURCE_LIBRARY, false);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			// 分页取得结果
			List<Recommend> libraries = recommendDao.findForPage(null,
					Recommend.SOURCE_LIBRARY, false, offSet, pageSize);

			// 结果
			result.setSuccess(true);
			result.getModel().put("libraries", libraries);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view library");
			throw new SignatureServiceException("Unable to view library", e);
		}

		return result;
	}

	public Result deleteLibrary(List<Integer> libraries)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Iterator<Integer> it = libraries.iterator();
			while (it.hasNext()) {
				Integer libraryId = it.next();
				
				Recommend recommend = recommendDao.getById(libraryId);
				
				// 置删除标志位
				recommendDao.deleteFlag(recommend);
				
				// 更新原签名的推荐标志位
				Integer foreignId = recommend.getForeignId();				
				if(foreignId != null){
					SignatureLibrary library = signatureLibraryDao.getById(foreignId);
					library.setRecommend(false);
					signatureLibraryDao.update(library);
				}
			}
			

			// 更新相应缓存
			Cache cache = CacheManager.getInstance().getCache();
			cache.remove("wonderfulList_1");
			cache.remove("wonderfulList_2");
			
			result.setSuccess(true);

		} catch (SignaturePersistException e) {
			logger.error("Unable to delete library");
			throw new SignatureServiceException("Unable to delete library", e);
		} catch (CacheException e) {
			logger.error(
					"Unable to update wonderfulList_1 or wonderfulList_2 for cache",
					e);
			throw new SignatureServiceException(
					"Unable to update wonderfulList_1 or wonderfulList_2 for cache",
					e);
		}

		return result;
	}

	public Result viewHotTopic(Page page) throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 获得Cache
			Cache cache = CacheManager.getInstance().getCache();

			// 热门话题（随机原创情景类）
			List<SignatureClass> classList = (List<SignatureClass>) cache
					.retrieve("classList");
			if (classList == null) {

				classList = signatureClassDao.findFirstRandom(
						SignatureClass.ORIGINAL, 11);

				cache.store("classList", classList);
			}

			// 伪造页面参数
			page.setTotalCount(11);
			page.setTotalPage(1);

			result.setSuccess(true);
			result.getModel().put("classList", classList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to get hot topic from dabase");
			throw new SignatureServiceException(
					"Unable to get hot topic from dabase", e);
		} catch (CacheException e) {
			logger.error("Unable to get hot topic from cache", e);
			throw new SignatureServiceException(
					"Unable to get rank hot topic cache", e);
		}

		return result;
	}

	public Result deleteHotTopic(List<Integer> hotTopics)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		try {
			// 获得Cache
			Cache cache = CacheManager.getInstance().getCache();
			
			cache.remove("classList");
			
			result.setSuccess(true);
		} catch (CacheException e) {
			logger.error("Unable to delete hot topic from cache", e);
			throw new SignatureServiceException(
					"Unable to delete hot topic from cache", e);
		}

		return result;
	}

	public Result viewOriginal(Boolean isDelete, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 总数量
			Integer totalRecords = recommendDao.findCount(null,
					Recommend.SOURCE_ORIGINAL, false);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			// 分页取得结果
			List<Recommend> originals = recommendDao.findForPage(null,
					Recommend.SOURCE_ORIGINAL, false, offSet, pageSize);

			// 结果
			result.setSuccess(true);
			result.getModel().put("originals", originals);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view original");
			throw new SignatureServiceException("Unable to view original", e);
		}

		return result;
	}

	public Result deleteOriginal(List<Integer> originals)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Iterator<Integer> it = originals.iterator();
			while (it.hasNext()) {
				Integer originalId = it.next();
				Recommend recommend = recommendDao.getById(originalId);				
				// 置删除标志位
				recommendDao.deleteFlag(recommend);
				
				//置原签名推荐标志位
				Integer foreignId = recommend.getForeignId();
				if(foreignId != null){
					SignatureOriginal original = signatureOriginalDao.getById(foreignId);
					original.setRecommend(false);
					
					signatureOriginalDao.update(original);
				}

				
			}

			// 更新相应缓存
			Cache cache = CacheManager.getInstance().getCache();
			cache.remove("originalList");
			
			result.setSuccess(true);

		} catch (SignaturePersistException e) {
			logger.error("Unable to delete original");
			throw new SignatureServiceException("Unable to delete original", e);
		} catch (CacheException e) {
			logger.error("Unable to update originalList for cache", e);
			throw new SignatureServiceException(
					"Unable to update originalList for cache", e);
		}

		return result;
	}

	public Result viewLibraryRecommend(Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		try {
			// 获得Cache
			Cache cache = CacheManager.getInstance().getCache();

			// 推荐签名盒(随机签名盒签名)
			List<SignatureLibrary> libraryList = (List<SignatureLibrary>) cache
					.retrieve("libraryList");
			if (libraryList == null) {

				libraryList = signatureLibraryDao.findRandom(5);

				cache.store("libraryList", libraryList);
			}

			// 伪造页面参数
			page.setTotalCount(10);
			page.setTotalPage(1);

			result.setSuccess(true);
			result.getModel().put("libraryList", libraryList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to get library recommend from dabase");
			throw new SignatureServiceException(
					"Unable to get library recommend from dabase", e);
		} catch (CacheException e) {
			logger.error("Unable to get library recommend from cache", e);
			throw new SignatureServiceException(
					"Unable to get library recommend from cache", e);
		}

		return result;
	}

	public Result deleteLibraryRecommend(List<Integer> libraries)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 获得Cache
			Cache cache = CacheManager.getInstance().getCache();
			// 清除缓存
			cache.remove("libraryList");

			result.setSuccess(true);
		} catch (CacheException e) {
			logger.error("Unable to delete library recommend from cache", e);
			throw new SignatureServiceException(
					"Unable to delete library recommend from cache", e);
		}

		return result;
	}

	public Result viewRank(Page page) throws SignatureServiceException {
		Result result = Result.createRestult();
		try {
			// 获得Cache
			Cache cache = CacheManager.getInstance().getCache();

			// 今日排行榜(随机签名盒签名)
			List<SignatureOriginal> originalRankList = (List<SignatureOriginal>) cache
					.retrieve("originalRankList");
			if (originalRankList == null) {

				originalRankList = signatureOriginalDao.findRandom(true,
						SignatureOriginal.PASSAUDIT, 10);

				cache.store("originalRankList", originalRankList);
			}

			// 伪造页面参数
			page.setTotalCount(10);
			page.setTotalPage(1);

			result.setSuccess(true);
			result.getModel().put("originalRankList", originalRankList);
			result.getModel().put("page", page);

		} catch (SignaturePersistException e) {
			logger.error("Unable to get rank from dabase");
			throw new SignatureServiceException(
					"Unable to get rank from dabase", e);
		} catch (CacheException e) {
			logger.error("Unable to get rank from cache", e);
			throw new SignatureServiceException(
					"Unable to get rank from cache", e);
		}

		return result;
	}

	public Result deleteRank(List<Integer> originals)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 获得Cache
			Cache cache = CacheManager.getInstance().getCache();

			cache.remove("originalRankList");

			result.setSuccess(true);
		} catch (CacheException e) {
			logger.error("Unable to delete rank from cache", e);
			throw new SignatureServiceException(
					"Unable to delete rank from cache", e);
		}

		return result;
	}

	public ActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	public RecommendDao getRecommendDao() {
		return recommendDao;
	}

	public void setRecommendDao(RecommendDao recommendDao) {
		this.recommendDao = recommendDao;
	}

	public SignatureLibraryDao getSignatureLibraryDao() {
		return signatureLibraryDao;
	}

	public void setSignatureLibraryDao(SignatureLibraryDao signatureLibraryDao) {
		this.signatureLibraryDao = signatureLibraryDao;
	}

	public SignatureOriginalDao getSignatureOriginalDao() {
		return signatureOriginalDao;
	}

	public void setSignatureOriginalDao(
			SignatureOriginalDao signatureOriginalDao) {
		this.signatureOriginalDao = signatureOriginalDao;
	}

	public SignatureClassDao getSignatureClassDao() {
		return signatureClassDao;
	}

	public void setSignatureClassDao(SignatureClassDao signatureClassDao) {
		this.signatureClassDao = signatureClassDao;
	}

}
