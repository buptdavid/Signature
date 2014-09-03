package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseHgSpecialNumbers;

public class HgSpecialNumbers extends BaseHgSpecialNumbers {
	private static final long serialVersionUID = 1L;

	/** 黑名单 */
	public static final Integer BLACKLIST = 1;

	/** 白名单 */
	public static final Integer WHITELIST = 2;

	/** 拒绝签名 */
	public static final Integer REFUSELIST = 3;
	
	/** Customer名称（手机号），因为没有外键，所以不得不增加 */
	private String customerName;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public HgSpecialNumbers () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HgSpecialNumbers (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HgSpecialNumbers (
		java.lang.Integer id,
		java.lang.String specialNumber,
		java.lang.Integer specialNumberType) {

		super (
			id,
			specialNumber,
			specialNumberType);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/* [CONSTRUCTOR MARKER END] */
	
	

}