package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseHgFirmParameter;



public class HgFirmParameter extends BaseHgFirmParameter {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HgFirmParameter () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HgFirmParameter (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HgFirmParameter (
		java.lang.Integer id,
		java.lang.String firmParameterString,
		java.lang.Integer firmParameterValue) {

		super (
			id,
			firmParameterString,
			firmParameterValue);
	}

/*[CONSTRUCTOR MARKER END]*/


}