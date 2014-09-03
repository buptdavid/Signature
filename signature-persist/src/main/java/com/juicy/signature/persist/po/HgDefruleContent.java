package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseHgDefruleContent;



public class HgDefruleContent extends BaseHgDefruleContent {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HgDefruleContent () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HgDefruleContent (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HgDefruleContent (
		java.lang.Integer id,
		java.lang.String defcontent) {

		super (
			id,
			defcontent);
	}

/*[CONSTRUCTOR MARKER END]*/


}