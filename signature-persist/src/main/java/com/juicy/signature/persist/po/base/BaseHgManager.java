package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_MANAGER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_MANAGER"
 */

public abstract class BaseHgManager  implements Serializable {

	public static String REF = "HgManager";
	public static String PROP_MANAGER_TYPE = "ManagerType";
	public static String PROP_MANAGER_NAME = "ManagerName";
	public static String PROP_REGION_ID = "RegionId";
	public static String PROP_MANAGER_MOBILENUMBER = "ManagerMobilenumber";
	public static String PROP_ID = "Id";
	public static String PROP_MANAGER_EMAIL = "ManagerEmail";
	public static String PROP_USER_ID = "UserId";


	// constructors
	public BaseHgManager () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgManager (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgManager (
		java.lang.Integer id,
		java.lang.Integer regionId,
		java.lang.Integer userId,
		java.lang.Integer managerType) {

		this.setId(id);
		this.setRegionId(regionId);
		this.setUserId(userId);
		this.setManagerType(managerType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String managerEmail;
	private java.lang.String managerMobilenumber;
	private java.lang.String managerName;
	private java.lang.Integer managerType;
	private java.lang.Integer regionId;
	private java.lang.Integer userId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="MANAGER_ID"
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
	 * Return the value associated with the column: MANAGER_EMAIL
	 */
	public java.lang.String getManagerEmail () {
		return managerEmail;
	}

	/**
	 * Set the value related to the column: MANAGER_EMAIL
	 * @param managerEmail the MANAGER_EMAIL value
	 */
	public void setManagerEmail (java.lang.String managerEmail) {
		this.managerEmail = managerEmail;
	}



	/**
	 * Return the value associated with the column: MANAGER_MOBILENUMBER
	 */
	public java.lang.String getManagerMobilenumber () {
		return managerMobilenumber;
	}

	/**
	 * Set the value related to the column: MANAGER_MOBILENUMBER
	 * @param managerMobilenumber the MANAGER_MOBILENUMBER value
	 */
	public void setManagerMobilenumber (java.lang.String managerMobilenumber) {
		this.managerMobilenumber = managerMobilenumber;
	}



	/**
	 * Return the value associated with the column: MANAGER_NAME
	 */
	public java.lang.String getManagerName () {
		return managerName;
	}

	/**
	 * Set the value related to the column: MANAGER_NAME
	 * @param managerName the MANAGER_NAME value
	 */
	public void setManagerName (java.lang.String managerName) {
		this.managerName = managerName;
	}



	/**
	 * Return the value associated with the column: MANAGER_TYPE
	 */
	public java.lang.Integer getManagerType () {
		return managerType;
	}

	/**
	 * Set the value related to the column: MANAGER_TYPE
	 * @param managerType the MANAGER_TYPE value
	 */
	public void setManagerType (java.lang.Integer managerType) {
		this.managerType = managerType;
	}



	/**
	 * Return the value associated with the column: REGION_ID
	 */
	public java.lang.Integer getRegionId () {
		return regionId;
	}

	/**
	 * Set the value related to the column: REGION_ID
	 * @param regionId the REGION_ID value
	 */
	public void setRegionId (java.lang.Integer regionId) {
		this.regionId = regionId;
	}



	/**
	 * Return the value associated with the column: USER_ID
	 */
	public java.lang.Integer getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param userId the USER_ID value
	 */
	public void setUserId (java.lang.Integer userId) {
		this.userId = userId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgManager)) return false;
		else {
			com.juicy.signature.persist.po.HgManager hgManager = (com.juicy.signature.persist.po.HgManager) obj;
			if (null == this.getId() || null == hgManager.getId()) return false;
			else return (this.getId().equals(hgManager.getId()));
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