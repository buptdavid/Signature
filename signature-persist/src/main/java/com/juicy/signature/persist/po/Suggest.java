package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseSuggest;



public class Suggest extends BaseSuggest {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Suggest () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Suggest (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Suggest (
		java.lang.Integer id,
		java.lang.String title) {

		super (
			id,
			title);
	}

/*[CONSTRUCTOR MARKER END]*/


}