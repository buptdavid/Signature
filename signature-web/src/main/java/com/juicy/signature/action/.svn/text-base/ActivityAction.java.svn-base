/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.ActivityBaseAction;
import com.juicy.signature.persist.po.Activity;
import com.juicy.signature.service.result.Result;

/**
 * 活动Action
 *
 * @author 路卫杰
 * @version <p>Nov 1, 2011 创建</p>
 */
public class ActivityAction extends ActivityBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -8593726841293435749L;
	
	/** 展示活动列表 */
	private List<Activity> showList;
	
	/** 推荐活动列表 */
	private List<Activity> recommendList;
	
	/** 精彩列表 */
	private List<Activity> wonderfulActivityList;
	
	/** 活动ID */
	private Integer activityId;
	
	/** 活动 */
	private Activity activity;
	
	/**
	 * 展示所有活动
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	@Override
	public String execute() throws Exception {
		
		Result result = activityService.viewAll(3, 6, 6);
		
		if(result.isSuccess()){
			showList = (List<Activity>)result.getModel().get("showList");
			recommendList = (List<Activity>)result.getModel().get("recommendList");
			wonderfulActivityList = (List<Activity>)result.getModel().get("wonderfulActivityList");
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 显示某一个活动
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception{
		
		Result result = activityService.view(activityId);
		
		if(result.isSuccess()){
			activity = (Activity)result.getModel().get("activity");
		}
		
		return SUCCESS;
	}

	public Activity getActivity() {
		return activity;
	}


	public void setActivity(Activity activity) {
		this.activity = activity;
	}


	public List<Activity> getShowList() {
		return showList;
	}


	public void setShowList(List<Activity> showList) {
		this.showList = showList;
	}


	public List<Activity> getRecommendList() {
		return recommendList;
	}


	public void setRecommendList(List<Activity> recommendList) {
		this.recommendList = recommendList;
	}


	public Integer getActivityId() {
		return activityId;
	}


	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}


	public List<Activity> getWonderfulActivityList() {
		return wonderfulActivityList;
	}


	public void setWonderfulActivityList(List<Activity> wonderfulActivityList) {
		this.wonderfulActivityList = wonderfulActivityList;
	}
	
	

}
