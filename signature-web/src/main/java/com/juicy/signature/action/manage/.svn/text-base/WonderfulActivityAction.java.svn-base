/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.action.base.IndexManageBaseAction;
import com.juicy.signature.persist.po.Activity;
import com.juicy.signature.service.result.Result;

/**
 * 精彩活动管理Action
 *
 * @author 路卫杰
 * @version <p>Nov 16, 2011 创建</p>
 */
public class WonderfulActivityAction extends IndexManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 精彩活动 */
	private List<Activity> activities;
	
	/** 要取消首页显示的精彩活动ID */
	private Integer activityId;
	
	/** 提示消息 */
	private String message;
	
	/**
	 * 取消精彩活动首页显示
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		List<Integer> activityIds = new ArrayList<Integer>();
		activityIds.add(activityId);
		
		Result result = indexManage.cancelIndex(activityIds);
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.cancelIndex.success"));
		}else{
			this.setMessage(getText("manage.cancelIndex.fail"));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 显示精彩活动
	 * 
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception{
		
		Result result = indexManage.viewActivity();
		
		if(result.isSuccess()){
			activities = (List<Activity>)result.getModel().get("activities");
		}
		
		return SUCCESS;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
