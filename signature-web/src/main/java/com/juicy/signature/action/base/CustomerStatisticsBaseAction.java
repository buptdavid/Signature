/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action.base;

import com.juicy.signature.service.StatisticsManage;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �û�ͳ�ƻ���Action
 *
 * @author ·����
 * @version <p>Nov 24, 2011 ����</p>
 */
public class CustomerStatisticsBaseAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	protected StatisticsManage statisticsManage;
	
	/** ���������Ϣ */
	private String message;

	public StatisticsManage getStatisticsManage() {
		return statisticsManage;
	}

	public void setStatisticsManage(StatisticsManage statisticsManage) {
		this.statisticsManage = statisticsManage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
