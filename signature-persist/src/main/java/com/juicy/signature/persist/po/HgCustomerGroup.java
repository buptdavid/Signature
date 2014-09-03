package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseHgCustomerGroup;



public class HgCustomerGroup extends BaseHgCustomerGroup {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HgCustomerGroup () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HgCustomerGroup (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HgCustomerGroup (
		java.lang.Integer id,
		java.lang.String customerGroupName,
		java.lang.Integer customerGroupType) {

		super (
			id,
			customerGroupName,
			customerGroupType);
	}

/*[CONSTRUCTOR MARKER END]*/


}