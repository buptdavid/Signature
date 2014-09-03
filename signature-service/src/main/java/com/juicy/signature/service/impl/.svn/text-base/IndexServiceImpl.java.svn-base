/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.ArrayList;
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
import com.juicy.signature.service.IndexService;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.result.Result;
import com.whirlycott.cache.Cache;
import com.whirlycott.cache.CacheException;
import com.whirlycott.cache.CacheManager;

/**
 * 首页展示Service实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 31, 2011 创建
 *          </p>
 */
public class IndexServiceImpl implements IndexService {

	private RecommendDao recommendDao;

	private ActivityDao activityDao;
	
	private SignatureClassDao signatureClassDao;
	
	private SignatureOriginalDao signatureOriginalDao;
	
	private SignatureLibraryDao signatureLibraryDao;
	
	/** 日志记录 */
	private static Log logger = LogFactory.getLog(IndexServiceImpl.class);

	public Result view() throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {	
			//获得Cache
			Cache cache = CacheManager.getInstance().getCache();
			
			// 首页活动			
			List<Activity> activityList = (List<Activity>)cache.retrieve("activityList");			
			//如果缓存中不存在，则从数据库中查询
			if(activityList == null){
				activityList = activityDao.findActivityByIndex(5);
				
				//将结果放入缓存
				cache.store("activityList", activityList);
			}
			
			
			//精彩签名（签名盒）
			List<Recommend> wonderfulList_1 = (List<Recommend>)cache.retrieve("wonderfulList_1");
			List<Recommend> wonderfulList_2 = (List<Recommend>)cache.retrieve("wonderfulList_2");
			if(wonderfulList_1 == null || wonderfulList_2 == null){
				List<Recommend> wonderfulList = recommendDao.findBySource(Recommend.SOURCE_LIBRARY, 10);
				
				//将wonderfulList分解为两个
				wonderfulList_1 = new ArrayList<Recommend>();
				wonderfulList_2 = new ArrayList<Recommend>();
				Iterator<Recommend> wonderfulIt = wonderfulList.iterator();
				int i = 0;
				while(wonderfulIt.hasNext()){
					if(i < 5){
						wonderfulList_1.add(wonderfulIt.next());
					}else{
						wonderfulList_2.add(wonderfulIt.next());
					}
					i++;
				}
				
				//将结果放入缓存
				cache.store("wonderfulList_1", wonderfulList_1);
				cache.store("wonderfulList_2", wonderfulList_2);
			}
			
				
			
			//情景签名推荐
			List<Recommend> originalList = (List<Recommend>)cache.retrieve("originalList");
			if(originalList == null){
				originalList = recommendDao.findBySource(Recommend.SOURCE_ORIGINAL, 5);				
				cache.store("originalList", originalList);				
			}
			
			//热门话题（随机原创情景类）			
			List<SignatureClass> classList = (List<SignatureClass>)cache.retrieve("classList");
			if(classList == null){
				classList = signatureClassDao.findFirstRandom(SignatureClass.ORIGINAL, 11);
				cache.store("classList", classList);	
			}
					
			
			//推荐签名盒(随机签名盒签名)
			List<SignatureLibrary> libraryList = (List<SignatureLibrary>)cache.retrieve("libraryList");
			if(libraryList == null){
				libraryList = signatureLibraryDao.findRandom(5);
				cache.store("libraryList", libraryList);
			}
			
			
			//今日排行榜(随机签名盒签名)
			List<SignatureOriginal> originalRankList = (List<SignatureOriginal>)cache.retrieve("originalRankList");
			if(originalRankList == null){
				originalRankList = signatureOriginalDao.findRandom(true, SignatureOriginal.PASSAUDIT, 10);
				cache.store("originalRankList", originalRankList);
			}
					
			
			//最新提交签名			
			List<SignatureOriginal> newOriginalList = (List<SignatureOriginal>)cache.retrieve("newOriginalList");
			if(newOriginalList == null){
				newOriginalList = signatureOriginalDao.findNew(true, SignatureOriginal.PASSAUDIT, 10);
				cache.store("newOriginalList", newOriginalList);
			}
			
			
			result.setSuccess(true);
			result.getModel().put("activityList", activityList);
			result.getModel().put("wonderfulList_1", wonderfulList_1);
			result.getModel().put("wonderfulList_2", wonderfulList_2);
			result.getModel().put("originalList", originalList);
			result.getModel().put("classList", classList);
			result.getModel().put("libraryList", libraryList);
			result.getModel().put("originalRankList", originalRankList);
			result.getModel().put("newOriginalList", newOriginalList);
			
		} catch (SignaturePersistException e) {
			logger.error("Unable to view index");
			throw new SignatureServiceException("Unable to view index", e);
		} catch (CacheException e) {
			logger.error("Unable to get index from cache", e);
			throw new SignatureServiceException(
					"Unable to get index from cache", e);
		}
		
				
		return result;
	}

	public RecommendDao getRecommendDao() {
		return recommendDao;
	}

	public void setRecommendDao(RecommendDao recommendDao) {
		this.recommendDao = recommendDao;
	}

	public ActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	public SignatureOriginalDao getSignatureOriginalDao() {
		return signatureOriginalDao;
	}

	public void setSignatureOriginalDao(SignatureOriginalDao signatureOriginalDao) {
		this.signatureOriginalDao = signatureOriginalDao;
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

		
	
}
