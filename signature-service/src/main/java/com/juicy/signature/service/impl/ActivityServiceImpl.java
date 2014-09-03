/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.ActivityDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Activity;
import com.juicy.signature.service.ActivityService;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.result.Result;
import com.whirlycott.cache.Cache;
import com.whirlycott.cache.CacheException;
import com.whirlycott.cache.CacheManager;

/**
 * �Service�ӿ�ʵ����
 *
 * @author ·����
 * @version <p>Nov 2, 2011 ����</p>
 */
public class ActivityServiceImpl implements ActivityService {
	
	private ActivityDao activityDao;

	/** ��־��¼ */
	private static Log logger = LogFactory.getLog(ActivityServiceImpl.class);
	
	public Result viewAll(Integer showCount, Integer recommendCount, Integer wonderfulCount)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {
			//���Cache,���ӻ�����ȡ������
			Cache cache = CacheManager.getInstance().getCache();			
			List<Activity> showList = (List<Activity>)cache.retrieve("showList");	
			List<Activity> recommendList = (List<Activity>)cache.retrieve("recommendList");
			List<Activity> wonderfulActivityList = (List<Activity>)cache.retrieve("wonderfulActivityList");
			
			// ��������в����ڣ�������ݿ���ȡ��
			if(showList == null){
				showList = activityDao.findActivityByIndex(3);
				//��������뻺��
				cache.store("showList", showList);
			}
			if(recommendList == null){
				recommendList = activityDao.findActivityRandom(false, null, 6);
				//��������뻺��
				cache.store("recommendList", recommendList);
			}
			if(wonderfulActivityList == null){
				wonderfulActivityList = activityDao.findActivityRandom(false, null, 6);
				//��������뻺��
				cache.store("wonderfulActivityList", wonderfulActivityList);
			}
			
			result.setSuccess(true);
			result.getModel().put("showList", showList);
			result.getModel().put("recommendList", recommendList);
			result.getModel().put("wonderfulActivityList", wonderfulActivityList);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view all activity");
			throw new SignatureServiceException("Unable to view all activity", e);
		} catch (CacheException e) {
			logger.error("Unable to get all view from cache", e);
			throw new SignatureServiceException(
					"Unable to get all view from cache", e);
		}
		
		return result;
	}

	public Result view(Integer activityId) throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {
			Activity activity = activityDao.getById(activityId);
			
			result.setSuccess(true);
			result.getModel().put("activity", activity);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view activity");
			throw new SignatureServiceException("Unable to view activity", e);
		}
		
		return result;
	}

	public ActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}
	
	

}
