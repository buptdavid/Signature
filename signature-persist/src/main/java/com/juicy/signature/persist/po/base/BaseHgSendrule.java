package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_SENDRULE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_SENDRULE"
 */

public abstract class BaseHgSendrule  implements Serializable {

	public static String REF = "HgSendrule";
	public static String PROP_SENDRULE_ENDDATE = "SendruleEnddate";
	public static String PROP_SENDRULE_SENDPERIODDATE = "SendruleSendperioddate";
	public static String PROP_WEEKS_SHOW = "WeeksShow";
	public static String PROP_DIY_INFO = "DiyInfo";
	public static String PROP_SENDRULE_NAME = "SendruleName";
	public static String PROP_IS_DEFAULT = "IsDefault";
	public static String PROP_SENDRULE_SENDPERIODTIME = "SendruleSendperiodtime";
	public static String PROP_SENDRULE_WEEKS = "SendruleWeeks";
	public static String PROP_SENDRULE_IF_FLOWCONTROL = "SendruleIfFlowcontrol";
	public static String PROP_CUSTOMER_ID = "CustomerId";
	public static String PROP_MESSAGE_TYPE_ID = "MessageTypeId";
	public static String PROP_CUSTOMER_GROUP_ID = "CustomerGroupId";
	public static String PROP_SENDRULE_SENDCOUNT = "SendruleSendcount";
	public static String PROP_CALLED_NUMBERS = "CalledNumbers";
	public static String PROP_SENDRULE_SM_DELAY = "SendruleSmDelay";
	public static String PROP_SENDRULE_CONTROLTYPE = "SendruleControltype";
	public static String PROP_SENDRULE_STARTDATE = "SendruleStartdate";
	public static String PROP_CALLING_NUMBERS = "CallingNumbers";
	public static String PROP_CALLING_NUNBER_TYPE = "CallingNunberType";
	public static String PROP_SENDRULE_STATE = "SendruleState";
	public static String PROP_SENDRULE_CALL_STATE = "SendruleCallState";
	public static String PROP_SENDRULE_CREATETIME = "SendruleCreatetime";
	public static String PROP_SENDRULE_FLOWCONTROL = "SendruleFlowcontrol";
	public static String PROP_SENDRULE_DESCRIPT = "SendruleDescript";
	public static String PROP_ID = "Id";
	public static String PROP_SENDRULE_SM_INTERVAL = "SendruleSmInterval";


	// constructors
	public BaseHgSendrule () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgSendrule (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgSendrule (
		java.lang.Integer id,
		java.lang.Integer customerId,
		java.lang.String sendruleName,
		java.lang.Integer sendruleIfFlowcontrol,
		java.lang.Integer sendruleCallState) {

		this.setId(id);
		this.setCustomerId(customerId);
		this.setSendruleName(sendruleName);
		this.setSendruleIfFlowcontrol(sendruleIfFlowcontrol);
		this.setSendruleCallState(sendruleCallState);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String calledNumbers;
	private java.lang.String callingNumbers;
	private java.lang.Integer callingNunberType;
	private java.lang.Integer customerGroupId;
	private java.lang.Integer customerId;
	private java.lang.Integer isDefault;
	private java.lang.Integer messageTypeId;
	private java.lang.Integer sendruleCallState;
	private java.lang.Integer sendruleControltype;
	private java.util.Date sendruleCreatetime;
	private java.lang.String sendruleDescript;
	private java.util.Date sendruleEnddate;
	private java.lang.Integer sendruleFlowcontrol;
	private java.lang.Integer sendruleIfFlowcontrol;
	private java.lang.String sendruleName;
	private java.lang.Integer sendruleSendcount;
	private java.lang.String sendruleSendperioddate;
	private java.lang.String sendruleSendperiodtime;
	private java.lang.Integer sendruleSmDelay;
	private java.lang.Integer sendruleSmInterval;
	private java.util.Date sendruleStartdate;
	private java.lang.Integer sendruleState;
	private java.lang.String sendruleWeeks;
	private java.lang.String weeksShow;

	// many to one
	private com.juicy.signature.persist.po.HgDiyInfo diyInfo;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="SENDRULE_ID"
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
	 * Return the value associated with the column: CALLED_NUMBERS
	 */
	public java.lang.String getCalledNumbers () {
		return calledNumbers;
	}

	/**
	 * Set the value related to the column: CALLED_NUMBERS
	 * @param calledNumbers the CALLED_NUMBERS value
	 */
	public void setCalledNumbers (java.lang.String calledNumbers) {
		this.calledNumbers = calledNumbers;
	}



	/**
	 * Return the value associated with the column: CALLING_NUMBERS
	 */
	public java.lang.String getCallingNumbers () {
		return callingNumbers;
	}

	/**
	 * Set the value related to the column: CALLING_NUMBERS
	 * @param callingNumbers the CALLING_NUMBERS value
	 */
	public void setCallingNumbers (java.lang.String callingNumbers) {
		this.callingNumbers = callingNumbers;
	}



	/**
	 * Return the value associated with the column: CALLING_NUNBER_TYPE
	 */
	public java.lang.Integer getCallingNunberType () {
		return callingNunberType;
	}

	/**
	 * Set the value related to the column: CALLING_NUNBER_TYPE
	 * @param callingNunberType the CALLING_NUNBER_TYPE value
	 */
	public void setCallingNunberType (java.lang.Integer callingNunberType) {
		this.callingNunberType = callingNunberType;
	}



	/**
	 * Return the value associated with the column: CUSTOMER_GROUP_ID
	 */
	public java.lang.Integer getCustomerGroupId () {
		return customerGroupId;
	}

	/**
	 * Set the value related to the column: CUSTOMER_GROUP_ID
	 * @param customerGroupId the CUSTOMER_GROUP_ID value
	 */
	public void setCustomerGroupId (java.lang.Integer customerGroupId) {
		this.customerGroupId = customerGroupId;
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
	 * Return the value associated with the column: IS_DEFAULT
	 */
	public java.lang.Integer getIsDefault () {
		return isDefault;
	}

	/**
	 * Set the value related to the column: IS_DEFAULT
	 * @param isDefault the IS_DEFAULT value
	 */
	public void setIsDefault (java.lang.Integer isDefault) {
		this.isDefault = isDefault;
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
	 * Return the value associated with the column: SENDRULE_CALL_STATE
	 */
	public java.lang.Integer getSendruleCallState () {
		return sendruleCallState;
	}

	/**
	 * Set the value related to the column: SENDRULE_CALL_STATE
	 * @param sendruleCallState the SENDRULE_CALL_STATE value
	 */
	public void setSendruleCallState (java.lang.Integer sendruleCallState) {
		this.sendruleCallState = sendruleCallState;
	}



	/**
	 * Return the value associated with the column: SENDRULE_CONTROLTYPE
	 */
	public java.lang.Integer getSendruleControltype () {
		return sendruleControltype;
	}

	/**
	 * Set the value related to the column: SENDRULE_CONTROLTYPE
	 * @param sendruleControltype the SENDRULE_CONTROLTYPE value
	 */
	public void setSendruleControltype (java.lang.Integer sendruleControltype) {
		this.sendruleControltype = sendruleControltype;
	}



	/**
	 * Return the value associated with the column: SENDRULE_CREATETIME
	 */
	public java.util.Date getSendruleCreatetime () {
		return sendruleCreatetime;
	}

	/**
	 * Set the value related to the column: SENDRULE_CREATETIME
	 * @param sendruleCreatetime the SENDRULE_CREATETIME value
	 */
	public void setSendruleCreatetime (java.util.Date sendruleCreatetime) {
		this.sendruleCreatetime = sendruleCreatetime;
	}



	/**
	 * Return the value associated with the column: SENDRULE_DESCRIPT
	 */
	public java.lang.String getSendruleDescript () {
		return sendruleDescript;
	}

	/**
	 * Set the value related to the column: SENDRULE_DESCRIPT
	 * @param sendruleDescript the SENDRULE_DESCRIPT value
	 */
	public void setSendruleDescript (java.lang.String sendruleDescript) {
		this.sendruleDescript = sendruleDescript;
	}



	/**
	 * Return the value associated with the column: SENDRULE_ENDDATE
	 */
	public java.util.Date getSendruleEnddate () {
		return sendruleEnddate;
	}

	/**
	 * Set the value related to the column: SENDRULE_ENDDATE
	 * @param sendruleEnddate the SENDRULE_ENDDATE value
	 */
	public void setSendruleEnddate (java.util.Date sendruleEnddate) {
		this.sendruleEnddate = sendruleEnddate;
	}



	/**
	 * Return the value associated with the column: SENDRULE_FLOWCONTROL
	 */
	public java.lang.Integer getSendruleFlowcontrol () {
		return sendruleFlowcontrol;
	}

	/**
	 * Set the value related to the column: SENDRULE_FLOWCONTROL
	 * @param sendruleFlowcontrol the SENDRULE_FLOWCONTROL value
	 */
	public void setSendruleFlowcontrol (java.lang.Integer sendruleFlowcontrol) {
		this.sendruleFlowcontrol = sendruleFlowcontrol;
	}



	/**
	 * Return the value associated with the column: SENDRULE_IF_FLOWCONTROL
	 */
	public java.lang.Integer getSendruleIfFlowcontrol () {
		return sendruleIfFlowcontrol;
	}

	/**
	 * Set the value related to the column: SENDRULE_IF_FLOWCONTROL
	 * @param sendruleIfFlowcontrol the SENDRULE_IF_FLOWCONTROL value
	 */
	public void setSendruleIfFlowcontrol (java.lang.Integer sendruleIfFlowcontrol) {
		this.sendruleIfFlowcontrol = sendruleIfFlowcontrol;
	}



	/**
	 * Return the value associated with the column: SENDRULE_NAME
	 */
	public java.lang.String getSendruleName () {
		return sendruleName;
	}

	/**
	 * Set the value related to the column: SENDRULE_NAME
	 * @param sendruleName the SENDRULE_NAME value
	 */
	public void setSendruleName (java.lang.String sendruleName) {
		this.sendruleName = sendruleName;
	}



	/**
	 * Return the value associated with the column: SENDRULE_SENDCOUNT
	 */
	public java.lang.Integer getSendruleSendcount () {
		return sendruleSendcount;
	}

	/**
	 * Set the value related to the column: SENDRULE_SENDCOUNT
	 * @param sendruleSendcount the SENDRULE_SENDCOUNT value
	 */
	public void setSendruleSendcount (java.lang.Integer sendruleSendcount) {
		this.sendruleSendcount = sendruleSendcount;
	}



	/**
	 * Return the value associated with the column: SENDRULE_SENDPERIODDATE
	 */
	public java.lang.String getSendruleSendperioddate () {
		return sendruleSendperioddate;
	}

	/**
	 * Set the value related to the column: SENDRULE_SENDPERIODDATE
	 * @param sendruleSendperioddate the SENDRULE_SENDPERIODDATE value
	 */
	public void setSendruleSendperioddate (java.lang.String sendruleSendperioddate) {
		this.sendruleSendperioddate = sendruleSendperioddate;
	}



	/**
	 * Return the value associated with the column: SENDRULE_SENDPERIODTIME
	 */
	public java.lang.String getSendruleSendperiodtime () {
		return sendruleSendperiodtime;
	}

	/**
	 * Set the value related to the column: SENDRULE_SENDPERIODTIME
	 * @param sendruleSendperiodtime the SENDRULE_SENDPERIODTIME value
	 */
	public void setSendruleSendperiodtime (java.lang.String sendruleSendperiodtime) {
		this.sendruleSendperiodtime = sendruleSendperiodtime;
	}



	/**
	 * Return the value associated with the column: SENDRULE_SM_DELAY
	 */
	public java.lang.Integer getSendruleSmDelay () {
		return sendruleSmDelay;
	}

	/**
	 * Set the value related to the column: SENDRULE_SM_DELAY
	 * @param sendruleSmDelay the SENDRULE_SM_DELAY value
	 */
	public void setSendruleSmDelay (java.lang.Integer sendruleSmDelay) {
		this.sendruleSmDelay = sendruleSmDelay;
	}



	/**
	 * Return the value associated with the column: SENDRULE_SM_INTERVAL
	 */
	public java.lang.Integer getSendruleSmInterval () {
		return sendruleSmInterval;
	}

	/**
	 * Set the value related to the column: SENDRULE_SM_INTERVAL
	 * @param sendruleSmInterval the SENDRULE_SM_INTERVAL value
	 */
	public void setSendruleSmInterval (java.lang.Integer sendruleSmInterval) {
		this.sendruleSmInterval = sendruleSmInterval;
	}



	/**
	 * Return the value associated with the column: SENDRULE_STARTDATE
	 */
	public java.util.Date getSendruleStartdate () {
		return sendruleStartdate;
	}

	/**
	 * Set the value related to the column: SENDRULE_STARTDATE
	 * @param sendruleStartdate the SENDRULE_STARTDATE value
	 */
	public void setSendruleStartdate (java.util.Date sendruleStartdate) {
		this.sendruleStartdate = sendruleStartdate;
	}



	/**
	 * Return the value associated with the column: SENDRULE_STATE
	 */
	public java.lang.Integer getSendruleState () {
		return sendruleState;
	}

	/**
	 * Set the value related to the column: SENDRULE_STATE
	 * @param sendruleState the SENDRULE_STATE value
	 */
	public void setSendruleState (java.lang.Integer sendruleState) {
		this.sendruleState = sendruleState;
	}



	/**
	 * Return the value associated with the column: SENDRULE_WEEKS
	 */
	public java.lang.String getSendruleWeeks () {
		return sendruleWeeks;
	}

	/**
	 * Set the value related to the column: SENDRULE_WEEKS
	 * @param sendruleWeeks the SENDRULE_WEEKS value
	 */
	public void setSendruleWeeks (java.lang.String sendruleWeeks) {
		this.sendruleWeeks = sendruleWeeks;
	}



	/**
	 * Return the value associated with the column: WEEKS_SHOW
	 */
	public java.lang.String getWeeksShow () {
		return weeksShow;
	}

	/**
	 * Set the value related to the column: WEEKS_SHOW
	 * @param weeksShow the WEEKS_SHOW value
	 */
	public void setWeeksShow (java.lang.String weeksShow) {
		this.weeksShow = weeksShow;
	}



	/**
	 * Return the value associated with the column: DIY_INFO_ID
	 */
	public com.juicy.signature.persist.po.HgDiyInfo getDiyInfo () {
		return diyInfo;
	}

	/**
	 * Set the value related to the column: DIY_INFO_ID
	 * @param diyInfo the DIY_INFO_ID value
	 */
	public void setDiyInfo (com.juicy.signature.persist.po.HgDiyInfo diyInfo) {
		this.diyInfo = diyInfo;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgSendrule)) return false;
		else {
			com.juicy.signature.persist.po.HgSendrule hgSendrule = (com.juicy.signature.persist.po.HgSendrule) obj;
			if (null == this.getId() || null == hgSendrule.getId()) return false;
			else return (this.getId().equals(hgSendrule.getId()));
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