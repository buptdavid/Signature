package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PORTAL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PORTAL"
 */

public abstract class BasePortal  implements Serializable {

	public static String REF = "Portal";
	public static String PROP_MANAGER_ID = "ManagerId";
	public static String PROP_MAX_NUM = "MaxNum";
	public static String PROP_GMT_TIME = "GmtTime";
	public static String PROP_EXPERIENCE_DAY = "ExperienceDay";
	public static String PROP_MAX_DEFAULT_COUNT = "MaxDefaultCount";
	public static String PROP_MAX_PERSONALIZE_COUNT = "MaxPersonalizeCount";
	public static String PROP_ID = "Id";
	public static String PROP_MDF_TIME = "MdfTime";
	public static String PROP_MAX_COUNT_ORIGINAL = "MaxCountOriginal";


	// constructors
	public BasePortal () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePortal (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer maxDefaultCount;
	private java.lang.Integer maxPersonalizeCount;
	private java.lang.Integer maxNum;
	private java.lang.Integer experienceDay;
	private java.lang.Integer maxCountOriginal;
	private java.lang.Integer managerId;
	private java.util.Date mdfTime;
	private java.util.Date gmtTime;



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
	 * Return the value associated with the column: max_default_count
	 */
	public java.lang.Integer getMaxDefaultCount () {
		return maxDefaultCount;
	}

	/**
	 * Set the value related to the column: max_default_count
	 * @param maxDefaultCount the max_default_count value
	 */
	public void setMaxDefaultCount (java.lang.Integer maxDefaultCount) {
		this.maxDefaultCount = maxDefaultCount;
	}



	/**
	 * Return the value associated with the column: max_personalize_count
	 */
	public java.lang.Integer getMaxPersonalizeCount () {
		return maxPersonalizeCount;
	}

	/**
	 * Set the value related to the column: max_personalize_count
	 * @param maxPersonalizeCount the max_personalize_count value
	 */
	public void setMaxPersonalizeCount (java.lang.Integer maxPersonalizeCount) {
		this.maxPersonalizeCount = maxPersonalizeCount;
	}



	/**
	 * Return the value associated with the column: max_num
	 */
	public java.lang.Integer getMaxNum () {
		return maxNum;
	}

	/**
	 * Set the value related to the column: max_num
	 * @param maxNum the max_num value
	 */
	public void setMaxNum (java.lang.Integer maxNum) {
		this.maxNum = maxNum;
	}



	/**
	 * Return the value associated with the column: experience_day
	 */
	public java.lang.Integer getExperienceDay () {
		return experienceDay;
	}

	/**
	 * Set the value related to the column: experience_day
	 * @param experienceDay the experience_day value
	 */
	public void setExperienceDay (java.lang.Integer experienceDay) {
		this.experienceDay = experienceDay;
	}



	/**
	 * Return the value associated with the column: max_count_original
	 */
	public java.lang.Integer getMaxCountOriginal () {
		return maxCountOriginal;
	}

	/**
	 * Set the value related to the column: max_count_original
	 * @param maxCountOriginal the max_count_original value
	 */
	public void setMaxCountOriginal (java.lang.Integer maxCountOriginal) {
		this.maxCountOriginal = maxCountOriginal;
	}



	/**
	 * Return the value associated with the column: manager_id
	 */
	public java.lang.Integer getManagerId () {
		return managerId;
	}

	/**
	 * Set the value related to the column: manager_id
	 * @param managerId the manager_id value
	 */
	public void setManagerId (java.lang.Integer managerId) {
		this.managerId = managerId;
	}



	/**
	 * Return the value associated with the column: mdf_time
	 */
	public java.util.Date getMdfTime () {
		return mdfTime;
	}

	/**
	 * Set the value related to the column: mdf_time
	 * @param mdfTime the mdf_time value
	 */
	public void setMdfTime (java.util.Date mdfTime) {
		this.mdfTime = mdfTime;
	}



	/**
	 * Return the value associated with the column: gmt_time
	 */
	public java.util.Date getGmtTime () {
		return gmtTime;
	}

	/**
	 * Set the value related to the column: gmt_time
	 * @param gmtTime the gmt_time value
	 */
	public void setGmtTime (java.util.Date gmtTime) {
		this.gmtTime = gmtTime;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.Portal)) return false;
		else {
			com.juicy.signature.persist.po.Portal portal = (com.juicy.signature.persist.po.Portal) obj;
			if (null == this.getId() || null == portal.getId()) return false;
			else return (this.getId().equals(portal.getId()));
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