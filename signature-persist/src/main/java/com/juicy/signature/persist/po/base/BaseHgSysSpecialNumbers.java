package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_SYS_SPECIAL_NUMBERS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_SYS_SPECIAL_NUMBERS"
 */

public abstract class BaseHgSysSpecialNumbers  implements Serializable {

	public static String REF = "HgSysSpecialNumbers";
	public static String PROP_SYS_SPECIAL_NUMBER = "SysSpecialNumber";
	public static String PROP_SPECIAL_NUMBER_CERATEDATE = "SpecialNumberCeratedate";
	public static String PROP_ID = "Id";
	public static String PROP_SHIELD_PERIOD = "ShieldPeriod";
	public static String PROP_SYS_SPECIAL_NUMBERTYPE = "SysSpecialNumbertype";


	// constructors
	public BaseHgSysSpecialNumbers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgSysSpecialNumbers (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgSysSpecialNumbers (
		java.lang.Integer id,
		java.lang.String sysSpecialNumber) {

		this.setId(id);
		this.setSysSpecialNumber(sysSpecialNumber);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sysSpecialNumber;
	private java.lang.Integer sysSpecialNumbertype;
	private java.lang.Integer shieldPeriod;
	private java.util.Date specialNumberCeratedate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="SYS_SPECIAL_NUMBERID"
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
	 * Return the value associated with the column: SYS_SPECIAL_NUMBER
	 */
	public java.lang.String getSysSpecialNumber () {
		return sysSpecialNumber;
	}

	/**
	 * Set the value related to the column: SYS_SPECIAL_NUMBER
	 * @param sysSpecialNumber the SYS_SPECIAL_NUMBER value
	 */
	public void setSysSpecialNumber (java.lang.String sysSpecialNumber) {
		this.sysSpecialNumber = sysSpecialNumber;
	}



	/**
	 * Return the value associated with the column: SYS_SPECIAL_NUMBERTYPE
	 */
	public java.lang.Integer getSysSpecialNumbertype () {
		return sysSpecialNumbertype;
	}

	/**
	 * Set the value related to the column: SYS_SPECIAL_NUMBERTYPE
	 * @param sysSpecialNumbertype the SYS_SPECIAL_NUMBERTYPE value
	 */
	public void setSysSpecialNumbertype (java.lang.Integer sysSpecialNumbertype) {
		this.sysSpecialNumbertype = sysSpecialNumbertype;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgSysSpecialNumbers)) return false;
		else {
			com.juicy.signature.persist.po.HgSysSpecialNumbers hgSysSpecialNumbers = (com.juicy.signature.persist.po.HgSysSpecialNumbers) obj;
			if (null == this.getId() || null == hgSysSpecialNumbers.getId()) return false;
			else return (this.getId().equals(hgSysSpecialNumbers.getId()));
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