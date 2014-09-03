package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the RECOMMEND table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="RECOMMEND"
 */

public abstract class BaseRecommend  implements Serializable {

	public static String REF = "Recommend";
	public static String PROP_CUSTOMER = "Customer";
	public static String PROP_PARENT_NAME = "ParentName";
	public static String PROP_CLASS_ID = "ClassId";
	public static String PROP_SOURCE = "Source";
	public static String PROP_PARENT_ID = "ParentId";
	public static String PROP_TIME = "Time";
	public static String PROP_IS_DELETE = "IsDelete";
	public static String PROP_ID = "Id";
	public static String PROP_CONTENT = "Content";
	public static String PROP_FOREIGN_ID = "ForeignId";
	public static String PROP_CLASS_NAME = "ClassName";


	// constructors
	public BaseRecommend () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRecommend (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRecommend (
		java.lang.Integer id,
		com.juicy.signature.persist.po.HgCustomer customer) {

		this.setId(id);
		this.setCustomer(customer);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String content;
	private byte source;
	private java.util.Date time;
	private boolean isDelete;
	private java.lang.Integer classId;
	private java.lang.String className;
	private java.lang.Integer parentId;
	private java.lang.String parentName;
	private java.lang.Integer foreignId;

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
	 * Return the value associated with the column: content
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: content
	 * @param content the content value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}



	/**
	 * Return the value associated with the column: source
	 */
	public byte getSource () {
		return source;
	}

	/**
	 * Set the value related to the column: source
	 * @param source the source value
	 */
	public void setSource (byte source) {
		this.source = source;
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
	 * Return the value associated with the column: class_id
	 */
	public java.lang.Integer getClassId () {
		return classId;
	}

	/**
	 * Set the value related to the column: class_id
	 * @param classId the class_id value
	 */
	public void setClassId (java.lang.Integer classId) {
		this.classId = classId;
	}



	/**
	 * Return the value associated with the column: class_name
	 */
	public java.lang.String getClassName () {
		return className;
	}

	/**
	 * Set the value related to the column: class_name
	 * @param className the class_name value
	 */
	public void setClassName (java.lang.String className) {
		this.className = className;
	}



	/**
	 * Return the value associated with the column: parent_id
	 */
	public java.lang.Integer getParentId () {
		return parentId;
	}

	/**
	 * Set the value related to the column: parent_id
	 * @param parentId the parent_id value
	 */
	public void setParentId (java.lang.Integer parentId) {
		this.parentId = parentId;
	}



	/**
	 * Return the value associated with the column: parent_name
	 */
	public java.lang.String getParentName () {
		return parentName;
	}

	/**
	 * Set the value related to the column: parent_name
	 * @param parentName the parent_name value
	 */
	public void setParentName (java.lang.String parentName) {
		this.parentName = parentName;
	}



	/**
	 * Return the value associated with the column: foreign_id
	 */
	public java.lang.Integer getForeignId () {
		return foreignId;
	}

	/**
	 * Set the value related to the column: foreign_id
	 * @param foreignId the foreign_id value
	 */
	public void setForeignId (java.lang.Integer foreignId) {
		this.foreignId = foreignId;
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
		if (!(obj instanceof com.juicy.signature.persist.po.Recommend)) return false;
		else {
			com.juicy.signature.persist.po.Recommend recommend = (com.juicy.signature.persist.po.Recommend) obj;
			if (null == this.getId() || null == recommend.getId()) return false;
			else return (this.getId().equals(recommend.getId()));
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