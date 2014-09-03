/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.base;

import com.juicy.signature.service.ActivityService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 活动基本Action
 *
 * @author 路卫杰
 * @version <p>Nov 1, 2011 创建</p>
 */
public class ActivityBaseAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = -2824289880964977655L;
	
	protected ActivityService activityService;

	public ActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}

}
