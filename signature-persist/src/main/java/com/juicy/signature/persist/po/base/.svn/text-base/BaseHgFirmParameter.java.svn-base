package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_FIRM_PARAMETER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_FIRM_PARAMETER"
 */

public abstract class BaseHgFirmParameter  implements Serializable {

	public static String REF = "HgFirmParameter";
	public static String PROP_FIRM_PARAMETER_VALUE = "FirmParameterValue";
	public static String PROP_CUSTOMER_ID = "CustomerId";
	public static String PROP_FIRM_PARAMETER_NAME = "FirmParameterName";
	public static String PROP_ID = "Id";
	public static String PROP_FIRM_PARAMETER_STRING = "FirmParameterString";


	// constructors
	public BaseHgFirmParameter () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgFirmParameter (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgFirmParameter (
		java.lang.Integer id,
		java.lang.String firmParameterString,
		java.lang.Integer firmParameterValue) {

		this.setId(id);
		this.setFirmParameterString(firmParameterString);
		this.setFirmParameterValue(firmParameterValue);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer customerId;
	private java.lang.String firmParameterName;
	private java.lang.String firmParameterString;
	private java.lang.Integer firmParameterValue;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="FIRM_PARAMETER_ID"
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
	 * Return the value associated with the column: FIRM_PARAMETER_NAME
	 */
	public java.lang.String getFirmParameterName () {
		return firmParameterName;
	}

	/**
	 * Set the value related to the column: FIRM_PARAMETER_NAME
	 * @param firmParameterName the FIRM_PARAMETER_NAME value
	 */
	public void setFirmParameterName (java.lang.String firmParameterName) {
		this.firmParameterName = firmParameterName;
	}



	/**
	 * Return the value associated with the column: FIRM_PARAMETER_STRING
	 */
	public java.lang.String getFirmParameterString () {
		return firmParameterString;
	}

	/**
	 * Set the value related to the column: FIRM_PARAMETER_STRING
	 * @param firmParameterString the FIRM_PARAMETER_STRING value
	 */
	public void setFirmParameterString (java.lang.String firmParameterString) {
		this.firmParameterString = firmParameterString;
	}



	/**
	 * Return the value associated with the column: FIRM_PARAMETER_VALUE
	 */
	public java.lang.Integer getFirmParameterValue () {
		return firmParameterValue;
	}

	/**
	 * Set the value related to the column: FIRM_PARAMETER_VALUE
	 * @param firmParameterValue the FIRM_PARAMETER_VALUE value
	 */
	public void setFirmParameterValue (java.lang.Integer firmParameterValue) {
		this.firmParameterValue = firmParameterValue;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgFirmParameter)) return false;
		else {
			com.juicy.signature.persist.po.HgFirmParameter hgFirmParameter = (com.juicy.signature.persist.po.HgFirmParameter) obj;
			if (null == this.getId() || null == hgFirmParameter.getId()) return false;
			else return (this.getId().equals(hgFirmParameter.getId()));
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