package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ACTIVITY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ACTIVITY"
 */

public abstract class BaseActivity  implements Serializable {

	public static String REF = "Activity";
	public static String PROP_CUSTOMER = "Customer";
	public static String PROP_MANAGER_ID = "ManagerId";
	public static String PROP_CUSTOMERS = "Customers";
	public static String PROP_IS_DELETE = "IsDelete";
	public static String PROP_INDEX_IMAGE = "IndexImage";
	public static String PROP_REGULATION = "Regulation";
	public static String PROP_NAME = "Name";
	public static String PROP_DETAIL = "Detail";
	public static String PROP_THEME = "Theme";
	public static String PROP_TIME = "Time";
	public static String PROP_IS_INDEX = "IsIndex";
	public static String PROP_IMAGE = "Image";
	public static String PROP_ID = "Id";
	public static String PROP_END_TIME = "EndTime";
	public static String PROP_START_TIME = "StartTime";
	public static String PROP_REMARK = "Remark";


	// constructors
	public BaseActivity () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseActivity (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer managerId;
	private java.lang.String name;
	private java.lang.String theme;
	private java.util.Date startTime;
	private java.util.Date endTime;
	private java.lang.String customers;
	private java.lang.String detail;
	private java.lang.String regulation;
	private java.lang.String image;
	private java.lang.String remark;
	private java.util.Date time;
	private boolean isDelete;
	private boolean isIndex;
	private java.lang.String indexImage;

	// many to one
	private com.juicy.signature.persist.po.HgCustomer customer;



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
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: theme
	 */
	public java.lang.String getTheme () {
		return theme;
	}

	/**
	 * Set the value related to the column: theme
	 * @param theme the theme value
	 */
	public void setTheme (java.lang.String theme) {
		this.theme = theme;
	}



	/**
	 * Return the value associated with the column: start_time
	 */
	public java.util.Date getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: start_time
	 * @param startTime the start_time value
	 */
	public void setStartTime (java.util.Date startTime) {
		this.startTime = startTime;
	}



	/**
	 * Return the value associated with the column: end_time
	 */
	public java.util.Date getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: end_time
	 * @param endTime the end_time value
	 */
	public void setEndTime (java.util.Date endTime) {
		this.endTime = endTime;
	}



	/**
	 * Return the value associated with the column: customers
	 */
	public java.lang.String getCustomers () {
		return customers;
	}

	/**
	 * Set the value related to the column: customers
	 * @param customers the customers value
	 */
	public void setCustomers (java.lang.String customers) {
		this.customers = customers;
	}



	/**
	 * Return the value associated with the column: detail
	 */
	public java.lang.String getDetail () {
		return detail;
	}

	/**
	 * Set the value related to the column: detail
	 * @param detail the detail value
	 */
	public void setDetail (java.lang.String detail) {
		this.detail = detail;
	}



	/**
	 * Return the value associated with the column: regulation
	 */
	public java.lang.String getRegulation () {
		return regulation;
	}

	/**
	 * Set the value related to the column: regulation
	 * @param regulation the regulation value
	 */
	public void setRegulation (java.lang.String regulation) {
		this.regulation = regulation;
	}



	/**
	 * Return the value associated with the column: image
	 */
	public java.lang.String getImage () {
		return image;
	}

	/**
	 * Set the value related to the column: image
	 * @param image the image value
	 */
	public void setImage (java.lang.String image) {
		this.image = image;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: time
	 */
	public java.util.Date getTime () {
		return time;
	}

	/**
	 * Set the value related to the column: time
	 * @param time the time value
	 */
	public void setTime (java.util.Date time) {
		this.time = time;
	}



	/**
	 * Return the value associated with the column: is_delete
	 */
	public boolean isIsDelete () {
		return isDelete;
	}

	/**
	 * Set the value related to the column: is_delete
	 * @param isDelete the is_delete value
	 */
	public void setIsDelete (boolean isDelete) {
		this.isDelete = isDelete;
	}



	/**
	 * Return the value associated with the column: is_index
	 */
	public boolean getIsIndex () {
		return isIndex;
	}

	/**
	 * Set the value related to the column: is_index
	 * @param isIndex the is_index value
	 */
	public void setIsIndex (boolean isIndex) {
		this.isIndex = isIndex;
	}



	/**
	 * Return the value associated with the column: index_image
	 */
	public java.lang.String getIndexImage () {
		return indexImage;
	}

	/**
	 * Set the value related to the column: index_image
	 * @param indexImage the index_image value
	 */
	public void setIndexImage (java.lang.String indexImage) {
		this.indexImage = indexImage;
	}



	/**
	 * Return the value associated with the column: manager_id
	 */
	public com.juicy.signature.persist.po.HgCustomer getCustomer () {
		return customer;
	}

	/**
	 * Set the value related to the column: manager_id
	 * @param customer the manager_id value
	 */
	public void setCustomer (com.juicy.signature.persist.po.HgCustomer customer) {
		this.customer = customer;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.Activity)) return false;
		else {
			com.juicy.signature.persist.po.Activity activity = (com.juicy.signature.persist.po.Activity) obj;
			if (null == this.getId() || null == activity.getId()) return false;
			else return (this.getId().equals(activity.getId()));
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