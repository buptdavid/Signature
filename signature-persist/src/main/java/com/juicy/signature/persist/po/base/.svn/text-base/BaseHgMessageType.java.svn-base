package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_MESSAGE_TYPE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_MESSAGE_TYPE"
 */

public abstract class BaseHgMessageType  implements Serializable {

	public static String REF = "HgMessageType";
	public static String PROP_MESSAGE_TYPE_UNIT = "MessageTypeUnit";
	public static String PROP_MESSAGE_TYPE_CODE = "MessageTypeCode";
	public static String PROP_ID = "Id";
	public static String PROP_MESSAGE_TYPE_NAME = "MessageTypeName";


	// constructors
	public BaseHgMessageType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgMessageType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgMessageType (
		java.lang.Integer id,
		java.lang.String messageTypeName) {

		this.setId(id);
		this.setMessageTypeName(messageTypeName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String messageTypeName;
	private java.lang.String messageTypeCode;
	private java.lang.String messageTypeUnit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="MESSAGE_TYPE_ID"
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
	 * Return the value associated with the column: MESSAGE_TYPE_NAME
	 */
	public java.lang.String getMessageTypeName () {
		return messageTypeName;
	}

	/**
	 * Set the value related to the column: MESSAGE_TYPE_NAME
	 * @param messageTypeName the MESSAGE_TYPE_NAME value
	 */
	public void setMessageTypeName (java.lang.String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}



	/**
	 * Return the value associated with the column: MESSAGE_TYPE_CODE
	 */
	public java.lang.String getMessageTypeCode () {
		return messageTypeCode;
	}

	/**
	 * Set the value related to the column: MESSAGE_TYPE_CODE
	 * @param messageTypeCode the MESSAGE_TYPE_CODE value
	 */
	public void setMessageTypeCode (java.lang.String messageTypeCode) {
		this.messageTypeCode = messageTypeCode;
	}



	/**
	 * Return the value associated with the column: MESSAGE_TYPE_UNIT
	 */
	public java.lang.String getMessageTypeUnit () {
		return messageTypeUnit;
	}

	/**
	 * Set the value related to the column: MESSAGE_TYPE_UNIT
	 * @param messageTypeUnit the MESSAGE_TYPE_UNIT value
	 */
	public void setMessageTypeUnit (java.lang.String messageTypeUnit) {
		this.messageTypeUnit = messageTypeUnit;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgMessageType)) return false;
		else {
			com.juicy.signature.persist.po.HgMessageType hgMessageType = (com.juicy.signature.persist.po.HgMessageType) obj;
			if (null == this.getId() || null == hgMessageType.getId()) return false;
			else return (this.getId().equals(hgMessageType.getId()));
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