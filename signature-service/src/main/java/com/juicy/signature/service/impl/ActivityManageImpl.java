/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.ActivityDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Activity;
import com.juicy.signature.service.ActivityManage;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;
import com.whirlycott.cache.Cache;
import com.whirlycott.cache.CacheException;
import com.whirlycott.cache.CacheManager;

/**
 * ActivityManage接口实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 28, 2011 创建
 *          </p>
 */
public class ActivityManageImpl implements ActivityManage {

	ActivityDao activityDao;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(ActivityManageImpl.class);

	public Result viewActivity(Date startTime, Date endTime, Boolean isDelete,
			Page page) throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 总数量
			Integer totalRecords = activityDao.findCount(startTime, endTime,
					isDelete);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			// 数据库取得结果
			List<Activity> activities = activityDao.findForPage(startTime,
					endTime, isDelete, offSet, pageSize);

			// 返回结果
			result.setSuccess(true);
			result.getModel().put("activities", activities);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view activity");
			throw new SignatureServiceException("Unable to view activity", e);
		}

		return result;
	}

	public Result createActivity(Activity activity)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 保存
			activityDao.save(activity);
			
			// 返回结果
			result.setSuccess(true);
			
			//更新缓存
			Cache cache = CacheManager.getInstance().getCache();
			cache.remove("activityList");
			cache.remove("showList");
			cache.remove("recommendList");
			cache.remove("wonderfulActivityList");
			
		} catch (SignaturePersistException e) {
			logger.error("Unable to create activity");
			throw new SignatureServiceException("Unable to create activity", e);
		} catch (CacheException e) {
			logger.error("Unable to update activity from Cache");
			throw new SignatureServiceException("Unable to update activity from Cache", e);
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
				//置删除标志位
				activityDao.deleteFlag(activityId);
				
				result.setSuccess(true);
				
				//更新缓存
				Cache cache = CacheManager.getInstance().getCache();
				cache.remove("activityList");
				cache.remove("showList");
				cache.remove("recommendList");
				cache.remove("wonderfulActivityList");
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to delete activity");
			throw new SignatureServiceException("Unable to delete activity", e);
		} catch (CacheException e) {
			logger.error("Unable to update activity from Cache");
			throw new SignatureServiceException("Unable to update activity from Cache", e);
		}

		return result;
	}
	
	public Result undeleteActivity(List<Integer> activities)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Iterator<Integer> it = activities.iterator();
			while (it.hasNext()) {
				Integer activityId = it.next();
				//数据库取得数据
				Activity activity_1 = activityDao.getById(activityId);
				//置删除标志位
				activity_1.setIsDelete(false);
				
				activityDao.update(activity_1);
				
				result.setSuccess(true);
				
				//更新缓存
				Cache cache = CacheManager.getInstance().getCache();
				cache.remove("activityList");
				cache.remove("showList");
				cache.remove("recommendList");
				cache.remove("wonderfulActivityList");
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to undelete activity");
			throw new SignatureServiceException("Unable to undelete activity", e);
		} catch (CacheException e) {
			logger.error("Unable to update activity from Cache");
			throw new SignatureServiceException("Unable to update activity from Cache", e);
		}

		return result;
	}
	
	public Result viewModify(Integer activityId)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {
			Activity activity = activityDao.getById(activityId);
			
			result.setSuccess(true);
			result.getModel().put("activity", activity);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view modify activity");
			throw new SignatureServiceException("Unable to view modify activity", e);
		}
		
		return result;
	}

	public Result modifyActivity(Activity activity)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {
			Activity activity_1 = activityDao.getById(activity.getId());
			
			activity_1.setCustomers(activity.getCustomers());
			activity_1.setCustomer(activity.getCustomer());
			activity_1.setName(activity.getName());
			activity_1.setDetail(activity.getDetail());
			activity_1.setEndTime(activity.getEndTime());
			activity_1.setRegulation(activity.getRegulation());
			activity_1.setRemark(activity.getRemark());
			activity_1.setStartTime(activity.getStartTime());
			activity_1.setTheme(activity.getTheme());
//			activity_1.setIsIndex(activity.getIsIndex());
			
			if(activity.getImage() != null){
				activity_1.setImage(activity.getImage());
			}
			
//			//如果首页显示，则设置首页图片
//			if(activity.getIsIndex()){
//				activity_1.setIndexImage(activity.getIndexImage());
//			}
			
			activityDao.update(activity_1);
			
			result.setSuccess(true);
			
			//更新缓存
			Cache cache = CacheManager.getInstance().getCache();
			cache.remove("activityList");
			cache.remove("showList");
			cache.remove("recommendList");
			cache.remove("wonderfulActivityList");
		} catch (SignaturePersistException e) {
			logger.error("Unable to delete activity");
			throw new SignatureServiceException("Unable to delete activity", e);
		} catch (CacheException e) {
			logger.error("Unable to update activity from Cache");
			throw new SignatureServiceException("Unable to update activity from Cache", e);
		}
		
		return result;
	}

	public Result setIndex(Activity activity) throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {
			Activity activity_1 = activityDao.getById(activity.getId());
			
			activity_1.setIsIndex(true);
			activity_1.setIndexImage(activity.getIndexImage());
			activity_1.setCustomer(activity.getCustomer());
			activityDao.update(activity_1);
			
			result.setSuccess(true);
			
			//更新缓存
			Cache cache = CacheManager.getInstance().getCache();
			cache.remove("activityList");
			cache.remove("showList");
			cache.remove("recommendList");
			cache.remove("wonderfulActivityList");
			
		} catch (SignaturePersistException e) {
			logger.error("Unable to set activity to index");
			throw new SignatureServiceException("Unable to set activity to index", e);
		} catch (CacheException e) {
			logger.error("Unable to update activity from Cache");
			throw new SignatureServiceException("Unable to update activity from Cache", e);
		}
		
		return result;
	}
	
	public Result cancelIndex(Activity activity)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {
			Activity activity_1 = activityDao.getById(activity.getId());
			
			activity_1.setIsIndex(false);
			activity_1.setCustomer(activity.getCustomer());
			activityDao.update(activity_1);
			
			result.setSuccess(true);
			
			//更新缓存
			Cache cache = CacheManager.getInstance().getCache();
			cache.remove("activityList");
			cache.remove("showList");
			cache.remove("recommendList");
			cache.remove("wonderfulActivityList");
			
		} catch (SignaturePersistException e) {
			logger.error("Unable to cancel activity to index");
			throw new SignatureServiceException("Unable to cancel activity to index", e);
		} catch (CacheException e) {
			logger.error("Unable to update activity from Cache");
			throw new SignatureServiceException("Unable to update activity from Cache", e);
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
