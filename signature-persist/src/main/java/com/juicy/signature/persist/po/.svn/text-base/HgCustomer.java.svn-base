package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseHgCustomer;



public class HgCustomer extends BaseHgCustomer {
	private static final long serialVersionUID = 1L;
	
	/** 为了兼容以前的数据库表，特为没用的但又不得不设置的字段设置的默认值 */
	public static Integer UNUSEDID = -1;
	
	/** 订购业务状态 */
	public static final Integer ORDERED = 1;
	
	/** 退订业务状态 */
	public static final Integer QUIT_ORDERED = 2;
	
	/** 暂停业务状态 */
	public static final Integer PAUSE_ORDERED = 3;
	
	/** 过期业务状态*/
	public static final Integer EXPIRED_ORDERED = 4;

	/** 免费体验业务状态 */
	public static final Integer EXPERIENCE = 6;
	
	/** 免费体验结束业务状态 */
	public static final Integer EXPERIENCE_END = 7;
	
/*[CONSTRUCTOR MARKER BEGIN]*/
	public HgCustomer () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HgCustomer (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HgCustomer (
		java.lang.Integer id,
		java.lang.Integer customerManagerId,
		java.lang.Integer userId,
		java.lang.Integer comboId,
		java.lang.Integer regionId,
		java.lang.String customerName,
		java.lang.Integer customerType) {

		super (
			id,
			customerManagerId,
			userId,
			comboId,
			regionId,
			customerName,
			customerType);
	}

/*[CONSTRUCTOR MARKER END]*/


}