package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_SPECIAL_NUMBERS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_SPECIAL_NUMBERS"
 */

public abstract class BaseHgSpecialNumbers  implements Serializable {

	public static String REF = "HgSpecialNumbers";
	public static String PROP_SPECIAL_NUMBER_CERATEDATE = "SpecialNumberCeratedate";
	public static String PROP_CUSTOMER_ID = "CustomerId";
	public static String PROP_SPECIAL_NUMBER_TYPE = "SpecialNumberType";
	public static String PROP_ID = "Id";
	public static String PROP_SHIELD_PERIOD = "ShieldPeriod";
	public static String PROP_REMARK = "Remark";
	public static String PROP_SPECIAL_NUMBER = "SpecialNumber";


	// constructors
	public BaseHgSpecialNumbers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgSpecialNumbers (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgSpecialNumbers (
		java.lang.Integer id,
		java.lang.String specialNumber,
		java.lang.Integer specialNumberType) {

		this.setId(id);
		this.setSpecialNumber(specialNumber);
		this.setSpecialNumberType(specialNumberType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer customerId;
	private java.lang.String specialNumber;
	private java.lang.Integer specialNumberType;
	private java.lang.Integer shieldPeriod;
	private java.util.Date specialNumberCeratedate;
	private java.lang.String remark;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="SPECIAL_NUMBER_ID"
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
	 * Return the value associated with the column: SPECIAL_NUMBER
	 */
	public java.lang.String getSpecialNumber () {
		return specialNumber;
	}

	/**
	 * Set the value related to the column: SPECIAL_NUMBER
	 * @param specialNumber the SPECIAL_NUMBER value
	 */
	public void setSpecialNumber (java.lang.String specialNumber) {
		this.specialNumber = specialNumber;
	}



	/**
	 * Return the value associated with the column: SPECIAL_NUMBER_TYPE
	 */
	public java.lang.Integer getSpecialNumberType () {
		return specialNumberType;
	}

	/**
	 * Set the value related to the column: SPECIAL_NUMBER_TYPE
	 * @param specialNumberType the SPECIAL_NUMBER_TYPE value
	 */
	public void setSpecialNumberType (java.lang.Integer specialNumberType) {
		this.specialNumberType = specialNumberType;
	}



	/**
	 * Return the value associated with the column: SHIELD_PERIOD
	 */
	public java.lang.Integer getShieldPeriod () {
		return shieldPeriod;
	}

	/**
	 * Set the value related to the column: SHIELD_PERIOD
	 * @param shieldPeriod the SHIELD_PERIOD value
	 */
	public void setShieldPeriod (java.lang.Integer shieldPeriod) {
		this.shieldPeriod = shieldPeriod;
	}



	/**
	 * Return the value associated with the column: SPECIAL_NUMBER_CERATEDATE
	 */
	public java.util.Date getSpecialNumberCeratedate () {
		return specialNumberCeratedate;
	}

	/**
	 * Set the value related to the column: SPECIAL_NUMBER_CERATEDATE
	 * @param specialNumberCeratedate the SPECIAL_NUMBER_CERATEDATE value
	 */
	public void setSpecialNumberCeratedate (java.util.Date specialNumberCeratedate) {
		this.specialNumberCeratedate = specialNumberCeratedate;
	}



	/**
	 * Return the value associated with the column: REMARK
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: REMARK
	 * @param remark the REMARK value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgSpecialNumbers)) return false;
		else {
			com.juicy.signature.persist.po.HgSpecialNumbers hgSpecialNumbers = (com.juicy.signature.persist.po.HgSpecialNumbers) obj;
			if (null == this.getId() || null == hgSpecialNumbers.getId()) return false;
			else return (this.getId().equals(hgSpecialNumbers.getId()));
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