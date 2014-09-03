package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the st_users table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="st_users"
 */

public abstract class BaseStUsers  implements Serializable {

	public static String REF = "StUsers";
	public static String PROP_ENABLED = "Enabled";
	public static String PROP_PHONE = "Phone";
	public static String PROP_LOGIN_NAME = "LoginName";
	public static String PROP_VERIFY_CODE = "VerifyCode";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_VERIFY_INVALIDE_TIME = "VerifyInvalideTime";
	public static String PROP_USER_PASSWORDKEY3 = "UserPasswordkey3";
	public static String PROP_USER_PASSWORDQUESTION1 = "UserPasswordquestion1";
	public static String PROP_USER_PASSWORDKEY2 = "UserPasswordkey2";
	public static String PROP_USER_PASSWORDQUESTION2 = "UserPasswordquestion2";
	public static String PROP_USER_PASSWORDQUESTION3 = "UserPasswordquestion3";
	public static String PROP_USER_PASSWORDKEY1 = "UserPasswordkey1";
	public static String PROP_IF_INI_USER = "IfIniUser";
	public static String PROP_LAST_LOGIN_TIME = "LastLoginTime";
	public static String PROP_MANAGER = "Manager";
	public static String PROP_PWD_MODI_TIME = "PwdModiTime";
	public static String PROP_USER_TYPE = "UserType";
	public static String PROP_OPTLOCK = "Optlock";
	public static String PROP_DEPT_ID = "DeptId";
	public static String PROP_CREATOR = "Creator";
	public static String PROP_NAME = "Name";
	public static String PROP_LOGIN_COUNT = "LoginCount";
	public static String PROP_EMAIL = "Email";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";
	public static String PROP_REMARK = "Remark";
	public static String PROP_USER_PERIOD_OF_VALIDITY = "UserPeriodOfValidity";
	public static String PROP_REGION_CODE = "RegionCode";


	// constructors
	public BaseStUsers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStUsers (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStUsers (
		java.lang.Integer id,
		java.lang.String loginName,
		java.lang.String password,
		boolean ifIniUser,
		java.lang.Integer userPeriodOfValidity,
		java.lang.Integer userType) {

		this.setId(id);
		this.setLoginName(loginName);
		this.setPassword(password);
		this.setIfIniUser(ifIniUser);
		this.setUserPeriodOfValidity(userPeriodOfValidity);
		this.setUserType(userType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String loginName;
	private java.lang.String password;
	private java.lang.Integer enabled;
	private boolean ifIniUser;
	private java.lang.Integer userPeriodOfValidity;
	private java.util.Date pwdModiTime;
	private java.lang.String userPasswordquestion1;
	private java.lang.String userPasswordkey1;
	private java.lang.String userPasswordquestion2;
	private java.lang.String userPasswordkey2;
	private java.lang.String userPasswordquestion3;
	private java.lang.String userPasswordkey3;
	private java.lang.Integer userType;
	private java.lang.String email;
	private java.lang.String phone;
	private java.lang.Integer deptId;
	private java.lang.String regionCode;
	private java.lang.Integer creator;
	private java.util.Date createTime;
	private java.lang.Integer manager;
	private java.lang.Integer optlock;
	private java.util.Date lastLoginTime;
	private java.lang.Integer loginCount;
	private java.lang.String verifyCode;
	private java.util.Date verifyInvalideTime;
	private java.lang.String remark;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="user_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: login_name
	 */
	public java.lang.String getLoginName () {
		return loginName;
	}

	/**
	 * Set the value related to the column: login_name
	 * @param loginName the login_name value
	 */
	public void setLoginName (java.lang.String loginName) {
		this.loginName = loginName;
	}



	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: enabled
	 */
	public java.lang.Integer getEnabled () {
		return enabled;
	}

	/**
	 * Set the value related to the column: enabled
	 * @param enabled the enabled value
	 */
	public void setEnabled (java.lang.Integer enabled) {
		this.enabled = enabled;
	}



	/**
	 * Return the value associated with the column: IF_INI_USER
	 */
	public boolean isIfIniUser () {
		return ifIniUser;
	}

	/**
	 * Set the value related to the column: IF_INI_USER
	 * @param ifIniUser the IF_INI_USER value
	 */
	public void setIfIniUser (boolean ifIniUser) {
		this.ifIniUser = ifIniUser;
	}



	/**
	 * Return the value associated with the column: USER_PERIOD_OF_VALIDITY
	 */
	public java.lang.Integer getUserPeriodOfValidity () {
		return userPeriodOfValidity;
	}

	/**
	 * Set the value related to the column: USER_PERIOD_OF_VALIDITY
	 * @param userPeriodOfValidity the USER_PERIOD_OF_VALIDITY value
	 */
	public void setUserPeriodOfValidity (java.lang.Integer userPeriodOfValidity) {
		this.userPeriodOfValidity = userPeriodOfValidity;
	}



	/**
	 * Return the value associated with the column: pwd_modi_time
	 */
	public java.util.Date getPwdModiTime () {
		return pwdModiTime;
	}

	/**
	 * Set the value related to the column: pwd_modi_time
	 * @param pwdModiTime the pwd_modi_time value
	 */
	public void setPwdModiTime (java.util.Date pwdModiTime) {
		this.pwdModiTime = pwdModiTime;
	}



	/**
	 * Return the value associated with the column: USER_PASSWORDQUESTION1
	 */
	public java.lang.String getUserPasswordquestion1 () {
		return userPasswordquestion1;
	}

	/**
	 * Set the value related to the column: USER_PASSWORDQUESTION1
	 * @param userPasswordquestion1 the USER_PASSWORDQUESTION1 value
	 */
	public void setUserPasswordquestion1 (java.lang.String userPasswordquestion1) {
		this.userPasswordquestion1 = userPasswordquestion1;
	}



	/**
	 * Return the value associated with the column: USER_PASSWORDKEY1
	 */
	public java.lang.String getUserPasswordkey1 () {
		return userPasswordkey1;
	}

	/**
	 * Set the value related to the column: USER_PASSWORDKEY1
	 * @param userPasswordkey1 the USER_PASSWORDKEY1 value
	 */
	public void setUserPasswordkey1 (java.lang.String userPasswordkey1) {
		this.userPasswordkey1 = userPasswordkey1;
	}



	/**
	 * Return the value associated with the column: USER_PASSWORDQUESTION2
	 */
	public java.lang.String getUserPasswordquestion2 () {
		return userPasswordquestion2;
	}

	/**
	 * Set the value related to the column: USER_PASSWORDQUESTION2
	 * @param userPasswordquestion2 the USER_PASSWORDQUESTION2 value
	 */
	public void setUserPasswordquestion2 (java.lang.String userPasswordquestion2) {
		this.userPasswordquestion2 = userPasswordquestion2;
	}



	/**
	 * Return the value associated with the column: USER_PASSWORDKEY2
	 */
	public java.lang.String getUserPasswordkey2 () {
		return userPasswordkey2;
	}

	/**
	 * Set the value related to the column: USER_PASSWORDKEY2
	 * @param userPasswordkey2 the USER_PASSWORDKEY2 value
	 */
	public void setUserPasswordkey2 (java.lang.String userPasswordkey2) {
		this.userPasswordkey2 = userPasswordkey2;
	}



	/**
	 * Return the value associated with the column: USER_PASSWORDQUESTION3
	 */
	public java.lang.String getUserPasswordquestion3 () {
		return userPasswordquestion3;
	}

	/**
	 * Set the value related to the column: USER_PASSWORDQUESTION3
	 * @param userPasswordquestion3 the USER_PASSWORDQUESTION3 value
	 */
	public void setUserPasswordquestion3 (java.lang.String userPasswordquestion3) {
		this.userPasswordquestion3 = userPasswordquestion3;
	}



	/**
	 * Return the value associated with the column: USER_PASSWORDKEY3
	 */
	public java.lang.String getUserPasswordkey3 () {
		return userPasswordkey3;
	}

	/**
	 * Set the value related to the column: USER_PASSWORDKEY3
	 * @param userPasswordkey3 the USER_PASSWORDKEY3 value
	 */
	public void setUserPasswordkey3 (java.lang.String userPasswordkey3) {
		this.userPasswordkey3 = userPasswordkey3;
	}



	/**
	 * Return the value associated with the column: USER_TYPE
	 */
	public java.lang.Integer getUserType () {
		return userType;
	}

	/**
	 * Set the value related to the column: USER_TYPE
	 * @param userType the USER_TYPE value
	 */
	public void setUserType (java.lang.Integer userType) {
		this.userType = userType;
	}



	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: phone
	 */
	public java.lang.String getPhone () {
		return phone;
	}

	/**
	 * Set the value related to the column: phone
	 * @param phone the phone value
	 */
	public void setPhone (java.lang.String phone) {
		this.phone = phone;
	}



	/**
	 * Return the value associated with the column: dept_id
	 */
	public java.lang.Integer getDeptId () {
		return deptId;
	}

	/**
	 * Set the value related to the column: dept_id
	 * @param deptId the dept_id value
	 */
	public void setDeptId (java.lang.Integer deptId) {
		this.deptId = deptId;
	}



	/**
	 * Return the value associated with the column: region_code
	 */
	public java.lang.String getRegionCode () {
		return regionCode;
	}

	/**
	 * Set the value related to the column: region_code
	 * @param regionCode the region_code value
	 */
	public void setRegionCode (java.lang.String regionCode) {
		this.regionCode = regionCode;
	}



	/**
	 * Return the value associated with the column: creator
	 */
	public java.lang.Integer getCreator () {
		return creator;
	}

	/**
	 * Set the value related to the column: creator
	 * @param creator the creator value
	 */
	public void setCreator (java.lang.Integer creator) {
		this.creator = creator;
	}



	/**
	 * Return the value associated with the column: create_time
	 */
	public java.util.Date getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: create_time
	 * @param createTime the create_time value
	 */
	public void setCreateTime (java.util.Date createTime) {
		this.createTime = createTime;
	}



	/**
	 * Return the value associated with the column: manager
	 */
	public java.lang.Integer getManager () {
		return manager;
	}

	/**
	 * Set the value related to the column: manager
	 * @param manager the manager value
	 */
	public void setManager (java.lang.Integer manager) {
		this.manager = manager;
	}



	/**
	 * Return the value associated with the column: optlock
	 */
	public java.lang.Integer getOptlock () {
		return optlock;
	}

	/**
	 * Set the value related to the column: optlock
	 * @param optlock the optlock value
	 */
	public void setOptlock (java.lang.Integer optlock) {
		this.optlock = optlock;
	}



	/**
	 * Return the value associated with the column: last_login_time
	 */
	public java.util.Date getLastLoginTime () {
		return lastLoginTime;
	}

	/**
	 * Set the value related to the column: last_login_time
	 * @param lastLoginTime the last_login_time value
	 */
	public void setLastLoginTime (java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}



	/**
	 * Return the value associated with the column: login_count
	 */
	public java.lang.Integer getLoginCount () {
		return loginCount;
	}

	/**
	 * Set the value related to the column: login_count
	 * @param loginCount the login_count value
	 */
	public void setLoginCount (java.lang.Integer loginCount) {
		this.loginCount = loginCount;
	}



	/**
	 * Return the value associated with the column: verify_code
	 */
	public java.lang.String getVerifyCode () {
		return verifyCode;
	}

	/**
	 * Set the value related to the column: verify_code
	 * @param verifyCode the verify_code value
	 */
	public void setVerifyCode (java.lang.String verifyCode) {
		this.verifyCode = verifyCode;
	}



	/**
	 * Return the value associated with the column: verify_invalide_time
	 */
	public java.util.Date getVerifyInvalideTime () {
		return verifyInvalideTime;
	}

	/**
	 * Set the value related to the column: verify_invalide_time
	 * @param verifyInvalideTime the verify_invalide_time value
	 */
	public void setVerifyInvalideTime (java.util.Date verifyInvalideTime) {
		this.verifyInvalideTime = verifyInvalideTime;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.StUsers)) return false;
		else {
			com.juicy.signature.persist.po.StUsers stUsers = (com.juicy.signature.persist.po.StUsers) obj;
			if (null == this.getId() || null == stUsers.getId()) return false;
			else return (this.getId().equals(stUsers.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}