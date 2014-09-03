package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_INTERACT_MSG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_INTERACT_MSG"
 */

public abstract class BaseHgInteractMsg  implements Serializable {

	public static String REF = "HgInteractMsg";
	public static String PROP_CUSTOMER_ID = "CustomerId";
	public static String PROP_INTERACT_STRING = "InteractString";
	public static String PROP_ID = "Id";
	public static String PROP_INTERACT_MSGNAME = "InteractMsgname";
	public static String PROP_INTERACT_CONTENT = "InteractContent";


	// constructors
	public BaseHgInteractMsg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgInteractMsg (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgInteractMsg (
		java.lang.Integer id,
		java.lang.Integer customerId,
		java.lang.String interactString,
		java.lang.String interactMsgname,
		java.lang.String interactContent) {

		this.setId(id);
		this.setCustomerId(customerId);
		this.setInteractString(interactString);
		this.setInteractMsgname(interactMsgname);
		this.setInteractContent(interactContent);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer customerId;
	private java.lang.String interactString;
	private java.lang.String interactMsgname;
	private java.lang.String interactContent;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="INTERACT_MSGID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: CUSTOMER_ID
	 */
	public java.lang.Integer getCustomerId () {
		return customerId;
	}

	/**
	 * Set the value related to the column: CUSTOMER_ID
	 * @param customerId the CUSTOMER_ID value
	 */
	public void setCustomerId (java.lang.Integer customerId) {
		this.customerId = customerId;
	}



	/**
	 * Return the value associated with the column: INTERACT_STRING
	 */
	public java.lang.String getInteractString () {
		return interactString;
	}

	/**
	 * Set the value related to the column: INTERACT_STRING
	 * @param interactString the INTERACT_STRING value
	 */
	public void setInteractString (java.lang.String interactString) {
		this.interactString = interactString;
	}



	/**
	 * Return the value associated with the column: INTERACT_MSGNAME
	 */
	public java.lang.String getInteractMsgname () {
		return interactMsgname;
	}

	/**
	 * Set the value related to the column: INTERACT_MSGNAME
	 * @param interactMsgname the INTERACT_MSGNAME value
	 */
	public void setInteractMsgname (java.lang.String interactMsgname) {
		this.interactMsgname = interactMsgname;
	}



	/**
	 * Return the value associated with the column: INTERACT_CONTENT
	 */
	public java.lang.String getInteractContent () {
		return interactContent;
	}

	/**
	 * Set the value related to the column: INTERACT_CONTENT
	 * @param interactContent the INTERACT_CONTENT value
	 */
	public void setInteractContent (java.lang.String interactContent) {
		this.interactContent = interactContent;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgInteractMsg)) return false;
		else {
			com.juicy.signature.persist.po.HgInteractMsg hgInteractMsg = (com.juicy.signature.persist.po.HgInteractMsg) obj;
			if (null == this.getId() || null == hgInteractMsg.getId()) return false;
			else return (this.getId().equals(hgInteractMsg.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}