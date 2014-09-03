/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action.base;

import com.juicy.signature.service.ActivityManage;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��������Action
 *
 * @author ·����
 * @version <p>Nov 21, 2011 ����</p>
 */
public class ActivityManageBaseAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** ActivityManage */
	protected ActivityManage activityManage;

	public ActivityManage getActivityManage() {
		return activityManage;
	}

	public void setActivityManage(ActivityManage activityManage) {
		this.activityManage = activityManage;
	}
	

}
