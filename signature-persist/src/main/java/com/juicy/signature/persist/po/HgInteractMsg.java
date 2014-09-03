package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseHgInteractMsg;



public class HgInteractMsg extends BaseHgInteractMsg {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HgInteractMsg () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HgInteractMsg (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HgInteractMsg (
		java.lang.Integer id,
		java.lang.Integer customerId,
		java.lang.String interactString,
		java.lang.String interactMsgname,
		java.lang.String interactContent) {

		super (
			id,
			customerId,
			interactString,
			interactMsgname,
			interactContent);
	}

/*[CONSTRUCTOR MARKER END]*/


}