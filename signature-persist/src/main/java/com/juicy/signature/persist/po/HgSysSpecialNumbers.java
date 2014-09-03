package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseHgSysSpecialNumbers;



public class HgSysSpecialNumbers extends BaseHgSysSpecialNumbers {
	private static final long serialVersionUID = 1L;
	
	/** ϵͳ��������ʶ */
	public static final Integer BLACK = 1;
	
	/** ϵͳ��������ʶ */
	public static final Integer WHITE = 2;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HgSysSpecialNumbers () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HgSysSpecialNumbers (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HgSysSpecialNumbers (
		java.lang.Integer id,
		java.lang.String sysSpecialNumber) {

		super (
			id,
			sysSpecialNumber);
	}

/*[CONSTRUCTOR MARKER END]*/


}