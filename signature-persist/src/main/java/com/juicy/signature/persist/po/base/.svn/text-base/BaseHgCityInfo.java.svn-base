package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_CITY_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_CITY_INFO"
 */

public abstract class BaseHgCityInfo  implements Serializable {

	public static String REF = "HgCityInfo";
	public static String PROP_CITY_NAME = "CityName";
	public static String PROP_CITY_ZONE_CODE = "CityZoneCode";
	public static String PROP_ID = "Id";


	// constructors
	public BaseHgCityInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgCityInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgCityInfo (
		java.lang.Integer id,
		java.lang.String cityName,
		java.lang.String cityZoneCode) {

		this.setId(id);
		this.setCityName(cityName);
		this.setCityZoneCode(cityZoneCode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String cityName;
	private java.lang.String cityZoneCode;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="CITY_ID"
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
	 * Return the value associated with the column: CITY_NAME
	 */
	public java.lang.String getCityName () {
		return cityName;
	}

	/**
	 * Set the value related to the column: CITY_NAME
	 * @param cityName the CITY_NAME value
	 */
	public void setCityName (java.lang.String cityName) {
		this.cityName = cityName;
	}



	/**
	 * Return the value associated with the column: CITY_ZONE_CODE
	 */
	public java.lang.String getCityZoneCode () {
		return cityZoneCode;
	}

	/**
	 * Set the value related to the column: CITY_ZONE_CODE
	 * @param cityZoneCode the CITY_ZONE_CODE value
	 */
	public void setCityZoneCode (java.lang.String cityZoneCode) {
		this.cityZoneCode = cityZoneCode;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgCityInfo)) return false;
		else {
			com.juicy.signature.persist.po.HgCityInfo hgCityInfo = (com.juicy.signature.persist.po.HgCityInfo) obj;
			if (null == this.getId() || null == hgCityInfo.getId()) return false;
			else return (this.getId().equals(hgCityInfo.getId()));
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