package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseRecommend;



public class Recommend extends BaseRecommend {
	private static final long serialVersionUID = 1L;
	
	/** ԭ���龰ǩ����Դ */
	public static final Byte SOURCE_ORIGINAL = 1;
	
	/** ǩ������Դ */
	public static final Byte SOURCE_LIBRARY = 2;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Recommend () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Recommend (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Recommend (
		java.lang.Integer id,
		com.juicy.signature.persist.po.HgCustomer customer) {

		super (
			id,
			customer);
	}

/*[CONSTRUCTOR MARKER END]*/


}