package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_SENDLOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_SENDLOG"
 */

public abstract class BaseHgSendlog  implements Serializable {

	public static String REF = "HgSendlog";
	public static String PROP_SENDRULE_ID = "SendruleId";
	public static String PROP_CALLED_NUMBER = "CalledNumber";
	public static String PROP_RECEIVERNUMBER = "Receivernumber";
	public static String PROP_RESPONSE_TIME = "ResponseTime";
	public static String PROP_CALLING_TIME = "CallingTime";
	public static String PROP_RECEIVE_TIME = "ReceiveTime";
	public static String PROP_SENDRESULT = "Sendresult";
	public static String PROP_CALLING_HLR = "CallingHlr";
	public static String PROP_CALLING_IMSI = "CallingImsi";
	public static String PROP_CUSTOMER_ID = "CustomerId";
	public static String PROP_SM_SUBMIT_TIME = "SmSubmitTime";
	public static String PROP_LAC = "Lac";
	public static String PROP_ID = "Id";
	public static String PROP_CI = "Ci";


	// constructors
	public BaseHgSendlog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgSendlog (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer customerId;
	private java.lang.Integer sendruleId;
	private java.util.Date callingTime;
	private java.util.Date smSubmitTime;
	private java.util.Date responseTime;
	private java.util.Date receiveTime;
	private java.lang.String receivernumber;
	private java.lang.Integer sendresult;
	private java.lang.String callingImsi;
	private java.lang.String callingHlr;
	private java.lang.String calledNumber;
	private java.lang.Integer lac;
	private java.lang.Integer ci;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="SENDLOG_ID"
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
	 * Return the value associated with the column: SENDRULE_ID
	 */
	public java.lang.Integer getSendruleId () {
		return sendruleId;
	}

	/**
	 * Set the value related to the column: SENDRULE_ID
	 * @param sendruleId the SENDRULE_ID value
	 */
	public void setSendruleId (java.lang.Integer sendruleId) {
		this.sendruleId = sendruleId;
	}



	/**
	 * Return the value associated with the column: CALLING_TIME
	 */
	public java.util.Date getCallingTime () {
		return callingTime;
	}

	/**
	 * Set the value related to the column: CALLING_TIME
	 * @param callingTime the CALLING_TIME value
	 */
	public void setCallingTime (java.util.Date callingTime) {
		this.callingTime = callingTime;
	}



	/**
	 * Return the value associated with the column: SM_SUBMIT_TIME
	 */
	public java.util.Date getSmSubmitTime () {
		return smSubmitTime;
	}

	/**
	 * Set the value related to the column: SM_SUBMIT_TIME
	 * @param smSubmitTime the SM_SUBMIT_TIME value
	 */
	public void setSmSubmitTime (java.util.Date smSubmitTime) {
		this.smSubmitTime = smSubmitTime;
	}



	/**
	 * Return the value associated with the column: RESPONSE_TIME
	 */
	public java.util.Date getResponseTime () {
		return responseTime;
	}

	/**
	 * Set the value related to the column: RESPONSE_TIME
	 * @param responseTime the RESPONSE_TIME value
	 */
	public void setResponseTime (java.util.Date responseTime) {
		this.responseTime = responseTime;
	}



	/**
	 * Return the value associated with the column: RECEIVE_TIME
	 */
	public java.util.Date getReceiveTime () {
		return receiveTime;
	}

	/**
	 * Set the value related to the column: RECEIVE_TIME
	 * @param receiveTime the RECEIVE_TIME value
	 */
	public void setReceiveTime (java.util.Date receiveTime) {
		this.receiveTime = receiveTime;
	}



	/**
	 * Return the value associated with the column: RECEIVERNUMBER
	 */
	public java.lang.String getReceivernumber () {
		return receivernumber;
	}

	/**
	 * Set the value related to the column: RECEIVERNUMBER
	 * @param receivernumber the RECEIVERNUMBER value
	 */
	public void setReceivernumber (java.lang.String receivernumber) {
		this.receivernumber = receivernumber;
	}



	/**
	 * Return the value associated with the column: SENDRESULT
	 */
	public java.lang.Integer getSendresult () {
		return sendresult;
	}

	/**
	 * Set the value related to the column: SENDRESULT
	 * @param sendresult the SENDRESULT value
	 */
	public void setSendresult (java.lang.Integer sendresult) {
		this.sendresult = sendresult;
	}



	/**
	 * Return the value associated with the column: CALLING_IMSI
	 */
	public java.lang.String getCallingImsi () {
		return callingImsi;
	}

	/**
	 * Set the value related to the column: CALLING_IMSI
	 * @param callingImsi the CALLING_IMSI value
	 */
	public void setCallingImsi (java.lang.String callingImsi) {
		this.callingImsi = callingImsi;
	}



	/**
	 * Return the value associated with the column: CALLING_HLR
	 */
	public java.lang.String getCallingHlr () {
		return callingHlr;
	}

	/**
	 * Set the value related to the column: CALLING_HLR
	 * @param callingHlr the CALLING_HLR value
	 */
	public void setCallingHlr (java.lang.String callingHlr) {
		this.callingHlr = callingHlr;
	}



	/**
	 * Return the value associated with the column: CALLED_NUMBER
	 */
	public java.lang.String getCalledNumber () {
		return calledNumber;
	}

	/**
	 * Set the value related to the column: CALLED_NUMBER
	 * @param calledNumber the CALLED_NUMBER value
	 */
	public void setCalledNumber (java.lang.String calledNumber) {
		this.calledNumber = calledNumber;
	}



	/**
	 * Return the value associated with the column: LAC
	 */
	public java.lang.Integer getLac () {
		return lac;
	}

	/**
	 * Set the value related to the column: LAC
	 * @param lac the LAC value
	 */
	public void setLac (java.lang.Integer lac) {
		this.lac = lac;
	}



	/**
	 * Return the value associated with the column: CI
	 */
	public java.lang.Integer getCi () {
		return ci;
	}

	/**
	 * Set the value related to the column: CI
	 * @param ci the CI value
	 */
	public void setCi (java.lang.Integer ci) {
		this.ci = ci;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgSendlog)) return false;
		else {
			com.juicy.signature.persist.po.HgSendlog hgSendlog = (com.juicy.signature.persist.po.HgSendlog) obj;
			if (null == this.getId() || null == hgSendlog.getId()) return false;
			else return (this.getId().equals(hgSendlog.getId()));
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