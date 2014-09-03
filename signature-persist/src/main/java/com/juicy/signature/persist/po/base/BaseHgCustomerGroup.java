package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_CUSTOMER_GROUP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_CUSTOMER_GROUP"
 */

public abstract class BaseHgCustomerGroup  implements Serializable {

	public static String REF = "HgCustomerGroup";
	public static String PROP_CUSTOMER_GROUP_DESCRIPT = "CustomerGroupDescript";
	public static String PROP_CUSTOMER_ID = "CustomerId";
	public static String PROP_CUSTOMER_GROUP_USED = "CustomerGroupUsed";
	public static String PROP_CUSTOMER_GROUP_TYPE = "CustomerGroupType";
	public static String PROP_ID = "Id";
	public static String PROP_CUSTOMER_GROUP_STRING = "CustomerGroupString";
	public static String PROP_CUSTOMER_GROUP_CONDITION = "CustomerGroupCondition";
	public static String PROP_CUSTOMER_GROUP_NAME = "CustomerGroupName";


	// constructors
	public BaseHgCustomerGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgCustomerGroup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgCustomerGroup (
		java.lang.Integer id,
		java.lang.String customerGroupName,
		java.lang.Integer customerGroupType) {

		this.setId(id);
		this.setCustomerGroupName(customerGroupName);
		this.setCustomerGroupType(customerGroupType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer customerId;
	private java.lang.String customerGroupName;
	private java.lang.Integer customerGroupType;
	private java.lang.String customerGroupDescript;
	private java.lang.String customerGroupCondition;
	private java.lang.String customerGroupString;
	private java.lang.Integer customerGroupUsed;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="CUSTOMER_GROUP_ID"
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
	 * Return the value associated with the column: CUSTOMER_GROUP_NAME
	 */
	public java.lang.String getCustomerGroupName () {
		return customerGroupName;
	}

	/**
	 * Set the value related to the column: CUSTOMER_GROUP_NAME
	 * @param customerGroupName the CUSTOMER_GROUP_NAME value
	 */
	public void setCustomerGroupName (java.lang.String customerGroupName) {
		this.customerGroupName = customerGroupName;
	}



	/**
	 * Return the value associated with the column: CUSTOMER_GROUP_TYPE
	 */
	public java.lang.Integer getCustomerGroupType () {
		return customerGroupType;
	}

	/**
	 * Set the value related to the column: CUSTOMER_GROUP_TYPE
	 * @param customerGroupType the CUSTOMER_GROUP_TYPE value
	 */
	public void setCustomerGroupType (java.lang.Integer customerGroupType) {
		this.customerGroupType = customerGroupType;
	}



	/**
	 * Return the value associated with the column: CUSTOMER_GROUP_DESCRIPT
	 */
	public java.lang.String getCustomerGroupDescript () {
		return customerGroupDescript;
	}

	/**
	 * Set the value related to the column: CUSTOMER_GROUP_DESCRIPT
	 * @param customerGroupDescript the CUSTOMER_GROUP_DESCRIPT value
	 */
	public void setCustomerGroupDescript (java.lang.String customerGroupDescript) {
		this.customerGroupDescript = customerGroupDescript;
	}



	/**
	 * Return the value associated with the column: CUSTOMER_GROUP_CONDITION
	 */
	public java.lang.String getCustomerGroupCondition () {
		return customerGroupCondition;
	}

	/**
	 * Set the value related to the column: CUSTOMER_GROUP_CONDITION
	 * @param customerGroupCondition the CUSTOMER_GROUP_CONDITION value
	 */
	public void setCustomerGroupCondition (java.lang.String customerGroupCondition) {
		this.customerGroupCondition = customerGroupCondition;
	}



	/**
	 * Return the value associated with the column: CUSTOMER_GROUP_STRING
	 */
	public java.lang.String getCustomerGroupString () {
		return customerGroupString;
	}

	/**
	 * Set the value related to the column: CUSTOMER_GROUP_STRING
	 * @param customerGroupString the CUSTOMER_GROUP_STRING value
	 */
	public void setCustomerGroupString (java.lang.String customerGroupString) {
		this.customerGroupString = customerGroupString;
	}



	/**
	 * Return the value associated with the column: CUSTOMER_GROUP_USED
	 */
	public java.lang.Integer getCustomerGroupUsed () {
		return customerGroupUsed;
	}

	/**
	 * Set the value related to the column: CUSTOMER_GROUP_USED
	 * @param customerGroupUsed the CUSTOMER_GROUP_USED value
	 */
	public void setCustomerGroupUsed (java.lang.Integer customerGroupUsed) {
		this.customerGroupUsed = customerGroupUsed;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgCustomerGroup)) return false;
		else {
			com.juicy.signature.persist.po.HgCustomerGroup hgCustomerGroup = (com.juicy.signature.persist.po.HgCustomerGroup) obj;
			if (null == this.getId() || null == hgCustomerGroup.getId()) return false;
			else return (this.getId().equals(hgCustomerGroup.getId()));
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