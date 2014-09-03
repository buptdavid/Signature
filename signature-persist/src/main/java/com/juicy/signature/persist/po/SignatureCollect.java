package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseSignatureCollect;



public class SignatureCollect extends BaseSignatureCollect {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public SignatureCollect () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public SignatureCollect (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public SignatureCollect (
		java.lang.Integer id,
		com.juicy.signature.persist.po.HgCustomer customer,
		java.util.Date collectTime) {

		super (
			id,
			customer,
			collectTime);
	}

/*[CONSTRUCTOR MARKER END]*/


}