package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseStUsers;



public class StUsers extends BaseStUsers {
	private static final long serialVersionUID = 1L;
	
	/** 普通用户 */
	public static final int ORDINARY = 0;
	
	/** 管理员 */
	public static final int MANAGER = 1;
	
/*[CONSTRUCTOR MARKER BEGIN]*/
	public StUsers () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StUsers (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StUsers (
		java.lang.Integer id,
		java.lang.String loginName,
		java.lang.String password,
		boolean ifIniUser,
		java.lang.Integer userPeriodOfValidity,
		java.lang.Integer userType) {

		super (
			id,
			loginName,
			password,
			ifIniUser,
			userPeriodOfValidity,
			userType);
	}

/*[CONSTRUCTOR MARKER END]*/


}