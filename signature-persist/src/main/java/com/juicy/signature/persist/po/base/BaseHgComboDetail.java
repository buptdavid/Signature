package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_COMBO_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_COMBO_DETAIL"
 */

public abstract class BaseHgComboDetail  implements Serializable {

	public static String REF = "HgComboDetail";
	public static String PROP_COMBO_MSG_RATE = "ComboMsgRate";
	public static String PROP_MESSAGE_TYPE_ID = "MessageTypeId";
	public static String PROP_ID = "Id";
	public static String PROP_COMBO_MSG_NUMBER = "ComboMsgNumber";
	public static String PROP_COMBO_RULE_TYPE = "ComboRuleType";


	// constructors
	public BaseHgComboDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgComboDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgComboDetail (
		java.lang.Integer id,
		java.lang.Integer messageTypeId,
		java.lang.Integer comboRuleType,
		java.lang.Integer comboMsgNumber) {

		this.setId(id);
		this.setMessageTypeId(messageTypeId);
		this.setComboRuleType(comboRuleType);
		this.setComboMsgNumber(comboMsgNumber);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer messageTypeId;
	private java.lang.Integer comboRuleType;
	private java.lang.Integer comboMsgNumber;
	private float comboMsgRate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="COMBO_ID"
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
	 * Return the value associated with the column: MESSAGE_TYPE_ID
	 */
	public java.lang.Integer getMessageTypeId () {
		return messageTypeId;
	}

	/**
	 * Set the value related to the column: MESSAGE_TYPE_ID
	 * @param messageTypeId the MESSAGE_TYPE_ID value
	 */
	public void setMessageTypeId (java.lang.Integer messageTypeId) {
		this.messageTypeId = messageTypeId;
	}



	/**
	 * Return the value associated with the column: COMBO_RULE_TYPE
	 */
	public java.lang.Integer getComboRuleType () {
		return comboRuleType;
	}

	/**
	 * Set the value related to the column: COMBO_RULE_TYPE
	 * @param comboRuleType the COMBO_RULE_TYPE value
	 */
	public void setComboRuleType (java.lang.Integer comboRuleType) {
		this.comboRuleType = comboRuleType;
	}



	/**
	 * Return the value associated with the column: COMBO_MSG_NUMBER
	 */
	public java.lang.Integer getComboMsgNumber () {
		return comboMsgNumber;
	}

	/**
	 * Set the value related to the column: COMBO_MSG_NUMBER
	 * @param comboMsgNumber the COMBO_MSG_NUMBER value
	 */
	public void setComboMsgNumber (java.lang.Integer comboMsgNumber) {
		this.comboMsgNumber = comboMsgNumber;
	}



	/**
	 * Return the value associated with the column: COMBO_MSG_RATE
	 */
	public float getComboMsgRate () {
		return comboMsgRate;
	}

	/**
	 * Set the value related to the column: COMBO_MSG_RATE
	 * @param comboMsgRate the COMBO_MSG_RATE value
	 */
	public void setComboMsgRate (float comboMsgRate) {
		this.comboMsgRate = comboMsgRate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgComboDetail)) return false;
		else {
			com.juicy.signature.persist.po.HgComboDetail hgComboDetail = (com.juicy.signature.persist.po.HgComboDetail) obj;
			if (null == this.getId() || null == hgComboDetail.getId()) return false;
			else return (this.getId().equals(hgComboDetail.getId()));
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