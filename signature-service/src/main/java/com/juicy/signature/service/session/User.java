/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.session;

import java.io.Serializable;
import java.util.Date;

/**
 * ��¼�ɹ������Session�еĵ�¼�������.
 * 
 * @author ·����
 * @version <p>
 *          2011-8-1 ����
 *          </p>
 */
public class User implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -6509229135663612544L;

	/** ��¼�û����û�ID */
	private Integer userId;

	/** ��¼�û��Ŀͻ�ID */
	private Integer customerId;

	/** ��¼�û����ֻ����� */
	private String loginName;
	
	/** �û��ǳ� */
	private String userNick;

	/** �ϴε�¼��ʱ�� */
	private Date lastLoginTime;

	/** ��¼���� */
	private Integer loginCount;
	
	/** �û��ĺڰ��������ã�1Ϊ��������2Ϊ������ */
	private Integer specialNumberType;
	
	/** ҵ��״̬ */
	private Integer customerStat;

	/** �û����� */
	private Integer userType;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getSpecialNumberType() {
		return specialNumberType;
	}

	public void setSpecialNumberType(Integer specialNumberType) {
		this.specialNumberType = specialNumberType;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public Integer getCustomerStat() {
		return customerStat;
	}

	public void setCustomerStat(Integer customerStat) {
		this.customerStat = customerStat;
	}
	
	public Integer getUserType() {
		return userType;
	}
	
	public void setUserType(Integer userType) {
		this.userType = userType;
	}

}
