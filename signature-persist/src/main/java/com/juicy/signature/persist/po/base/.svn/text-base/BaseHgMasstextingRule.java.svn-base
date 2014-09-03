package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_MASSTEXTING_RULE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_MASSTEXTING_RULE"
 */

public abstract class BaseHgMasstextingRule  implements Serializable {

	public static String REF = "HgMasstextingRule";
	public static String PROP_MASSTEXT_RULE_CREATETIME = "MasstextRuleCreatetime";
	public static String PROP_MASSTEXT_RULE_SENDTIME = "MasstextRuleSendtime";
	public static String PROP_MASSTEXT_RULE_SENDTYPE = "MasstextRuleSendtype";
	public static String PROP_MASSTEXT_RULE_FLOWS = "MasstextRuleFlows";
	public static String PROP_MASSTEXT_RULENAME = "MasstextRulename";
	public static String PROP_MASSTEXT_RULE_IS_CONTROL = "MasstextRuleIsControl";
	public static String PROP_MASSTEXT_RULE_PRIORITY = "MasstextRulePriority";
	public static String PROP_MASSTEXT_RULE_STATE = "MasstextRuleState";
	public static String PROP_MASSTEXT_RULE_SENDNUM = "MasstextRuleSendnum";
	public static String PROP_DIY_INFO_ID = "DiyInfoId";
	public static String PROP_CUSTOMER_ID = "CustomerId";
	public static String PROP_MESSAGE_TYPE_ID = "MessageTypeId";
	public static String PROP_CUSTOMER_GROUP_ID = "CustomerGroupId";
	public static String PROP_ID = "Id";


	// constructors
	public BaseHgMasstextingRule () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgMasstextingRule (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgMasstextingRule (
		java.lang.Integer id,
		java.lang.String masstextRulename,
		java.lang.Integer masstextRuleState,
		boolean masstextRuleIsControl,
		java.util.Date masstextRuleCreatetime) {

		this.setId(id);
		this.setMasstextRulename(masstextRulename);
		this.setMasstextRuleState(masstextRuleState);
		this.setMasstextRuleIsControl(masstextRuleIsControl);
		this.setMasstextRuleCreatetime(masstextRuleCreatetime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer diyInfoId;
	private java.lang.Integer messageTypeId;
	private java.lang.Integer customerId;
	private java.lang.Integer customerGroupId;
	private java.lang.String masstextRulename;
	private java.lang.Integer masstextRuleState;
	private java.lang.Integer masstextRuleSendnum;
	private boolean masstextRuleIsControl;
	private java.lang.Integer masstextRuleFlows;
	private java.util.Date masstextRuleCreatetime;
	private java.lang.Integer masstextRuleSendtype;
	private java.util.Date masstextRuleSendtime;
	private java.lang.Integer masstextRulePriority;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="MASSTEXT_RULEID"
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
	 * Return the value associated with the column: DIY_INFO_ID
	 */
	public java.lang.Integer getDiyInfoId () {
		return diyInfoId;
	}

	/**
	 * Set the value related to the column: DIY_INFO_ID
	 * @param diyInfoId the DIY_INFO_ID value
	 */
	public void setDiyInfoId (java.lang.Integer diyInfoId) {
		this.diyInfoId = diyInfoId;
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
	 * Return the value associated with the column: MASSTEXT_RULENAME
	 */
	public java.lang.String getMasstextRulename () {
		return masstextRulename;
	}

	/**
	 * Set the value related to the column: MASSTEXT_RULENAME
	 * @param masstextRulename the MASSTEXT_RULENAME value
	 */
	public void setMasstextRulename (java.lang.String masstextRulename) {
		this.masstextRulename = masstextRulename;
	}



	/**
	 * Return the value associated with the column: MASSTEXT_RULE_STATE
	 */
	public java.lang.Integer getMasstextRuleState () {
		return masstextRuleState;
	}

	/**
	 * Set the value related to the column: MASSTEXT_RULE_STATE
	 * @param masstextRuleState the MASSTEXT_RULE_STATE value
	 */
	public void setMasstextRuleState (java.lang.Integer masstextRuleState) {
		this.masstextRuleState = masstextRuleState;
	}



	/**
	 * Return the value associated with the column: MASSTEXT_RULE_SENDNUM
	 */
	public java.lang.Integer getMasstextRuleSendnum () {
		return masstextRuleSendnum;
	}

	/**
	 * Set the value related to the column: MASSTEXT_RULE_SENDNUM
	 * @param masstextRuleSendnum the MASSTEXT_RULE_SENDNUM value
	 */
	public void setMasstextRuleSendnum (java.lang.Integer masstextRuleSendnum) {
		this.masstextRuleSendnum = masstextRuleSendnum;
	}



	/**
	 * Return the value associated with the column: MASSTEXT_RULE_IS_CONTROL
	 */
	public boolean isMasstextRuleIsControl () {
		return masstextRuleIsControl;
	}

	/**
	 * Set the value related to the column: MASSTEXT_RULE_IS_CONTROL
	 * @param masstextRuleIsControl the MASSTEXT_RULE_IS_CONTROL value
	 */
	public void setMasstextRuleIsControl (boolean masstextRuleIsControl) {
		this.masstextRuleIsControl = masstextRuleIsControl;
	}



	/**
	 * Return the value associated with the column: MASSTEXT_RULE_FLOWS
	 */
	public java.lang.Integer getMasstextRuleFlows () {
		return masstextRuleFlows;
	}

	/**
	 * Set the value related to the column: MASSTEXT_RULE_FLOWS
	 * @param masstextRuleFlows the MASSTEXT_RULE_FLOWS value
	 */
	public void setMasstextRuleFlows (java.lang.Integer masstextRuleFlows) {
		this.masstextRuleFlows = masstextRuleFlows;
	}



	/**
	 * Return the value associated with the column: MASSTEXT_RULE_CREATETIME
	 */
	public java.util.Date getMasstextRuleCreatetime () {
		return masstextRuleCreatetime;
	}

	/**
	 * Set the value related to the column: MASSTEXT_RULE_CREATETIME
	 * @param masstextRuleCreatetime the MASSTEXT_RULE_CREATETIME value
	 */
	public void setMasstextRuleCreatetime (java.util.Date masstextRuleCreatetime) {
		this.masstextRuleCreatetime = masstextRuleCreatetime;
	}



	/**
	 * Return the value associated with the column: MASSTEXT_RULE_SENDTYPE
	 */
	public java.lang.Integer getMasstextRuleSendtype () {
		return masstextRuleSendtype;
	}

	/**
	 * Set the value related to the column: MASSTEXT_RULE_SENDTYPE
	 * @param masstextRuleSendtype the MASSTEXT_RULE_SENDTYPE value
	 */
	public void setMasstextRuleSendtype (java.lang.Integer masstextRuleSendtype) {
		this.masstextRuleSendtype = masstextRuleSendtype;
	}



	/**
	 * Return the value associated with the column: MASSTEXT_RULE_SENDTIME
	 */
	public java.util.Date getMasstextRuleSendtime () {
		return masstextRuleSendtime;
	}

	/**
	 * Set the value related to the column: MASSTEXT_RULE_SENDTIME
	 * @param masstextRuleSendtime the MASSTEXT_RULE_SENDTIME value
	 */
	public void setMasstextRuleSendtime (java.util.Date masstextRuleSendtime) {
		this.masstextRuleSendtime = masstextRuleSendtime;
	}



	/**
	 * Return the value associated with the column: MASSTEXT_RULE_PRIORITY
	 */
	public java.lang.Integer getMasstextRulePriority () {
		return masstextRulePriority;
	}

	/**
	 * Set the value related to the column: MASSTEXT_RULE_PRIORITY
	 * @param masstextRulePriority the MASSTEXT_RULE_PRIORITY value
	 */
	public void setMasstextRulePriority (java.lang.Integer masstextRulePriority) {
		this.masstextRulePriority = masstextRulePriority;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgMasstextingRule)) return false;
		else {
			com.juicy.signature.persist.po.HgMasstextingRule hgMasstextingRule = (com.juicy.signature.persist.po.HgMasstextingRule) obj;
			if (null == this.getId() || null == hgMasstextingRule.getId()) return false;
			else return (this.getId().equals(hgMasstextingRule.getId()));
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