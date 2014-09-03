/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.session;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录成功后放入Session中的登录对象的类.
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-1 创建
 *          </p>
 */
public class User implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -6509229135663612544L;

	/** 登录用户的用户ID */
	private Integer userId;

	/** 登录用户的客户ID */
	private Integer customerId;

	/** 登录用户的手机号码 */
	private String loginName;
	
	/** 用户昵称 */
	private String userNick;

	/** 上次登录的时间 */
	private Date lastLoginTime;

	/** 登录次数 */
	private Integer loginCount;
	
	/** 用户的黑白名单设置，1为黑名单，2为白名单 */
	private Integer specialNumberType;
	
	/** 业务状态 */
	private Integer customerStat;

	/** 用户类型 */
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
