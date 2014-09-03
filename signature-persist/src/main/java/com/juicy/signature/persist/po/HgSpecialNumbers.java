package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseHgSpecialNumbers;

public class HgSpecialNumbers extends BaseHgSpecialNumbers {
	private static final long serialVersionUID = 1L;

	/** ������ */
	public static final Integer BLACKLIST = 1;

	/** ������ */
	public static final Integer WHITELIST = 2;

	/** �ܾ�ǩ�� */
	public static final Integer REFUSELIST = 3;
	
	/** Customer���ƣ��ֻ��ţ�����Ϊû����������Բ��ò����� */
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