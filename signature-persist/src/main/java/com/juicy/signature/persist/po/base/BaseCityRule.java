package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CITY_RULE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CITY_RULE"
 */

public abstract class BaseCityRule  implements Serializable {

	public static String REF = "CityRule";
	public static String PROP_PHONE = "Phone";
	public static String PROP_CITY_NAME = "CityName";
	public static String PROP_ID = "Id";
	public static String PROP_CITY_CODE = "CityCode";


	// constructors
	public BaseCityRule () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCityRule (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String cityCode;
	private java.lang.String cityName;
	private java.lang.String phone;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="id"
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
	 * Return the value associated with the column: city_code
	 */
	public java.lang.String getCityCode () {
		return cityCode;
	}

	/**
	 * Set the value related to the column: city_code
	 * @param cityCode the city_code value
	 */
	public void setCityCode (java.lang.String cityCode) {
		this.cityCode = cityCode;
	}



	/**
	 * Return the value associated with the column: city_name
	 */
	public java.lang.String getCityName () {
		return cityName;
	}

	/**
	 * Set the value related to the column: city_name
	 * @param cityName the city_name value
	 */
	public void setCityName (java.lang.String cityName) {
		this.cityName = cityName;
	}



	/**
	 * Return the value associated with the column: phone
	 */
	public java.lang.String getPhone () {
		return phone;
	}

	/**
	 * Set the value related to the column: phone
	 * @param phone the phone value
	 */
	public void setPhone (java.lang.String phone) {
		this.phone = phone;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.CityRule)) return false;
		else {
			com.juicy.signature.persist.po.CityRule cityRule = (com.juicy.signature.persist.po.CityRule) obj;
			if (null == this.getId() || null == cityRule.getId()) return false;
			else return (this.getId().equals(cityRule.getId()));
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