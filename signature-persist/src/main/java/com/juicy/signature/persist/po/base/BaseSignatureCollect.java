package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SIGNATURE_COLLECT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SIGNATURE_COLLECT"
 */

public abstract class BaseSignatureCollect  implements Serializable {

	public static String REF = "SignatureCollect";
	public static String PROP_CUSTOMER = "Customer";
	public static String PROP_CLASS_ID = "ClassId";
	public static String PROP_LIBRARY_ID = "LibraryId";
	public static String PROP_COLLECT_TIME = "CollectTime";
	public static String PROP_PARENT_CLASS_NAME = "ParentClassName";
	public static String PROP_ID = "Id";
	public static String PROP_PARENT_CLASS_ID = "ParentClassId";
	public static String PROP_ORIGINAL_ID = "OriginalId";
	public static String PROP_CONTENT = "Content";
	public static String PROP_CLASS_NAME = "ClassName";


	// constructors
	public BaseSignatureCollect () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSignatureCollect (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSignatureCollect (
		java.lang.Integer id,
		com.juicy.signature.persist.po.HgCustomer customer,
		java.util.Date collectTime) {

		this.setId(id);
		this.setCustomer(customer);
		this.setCollectTime(collectTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer classId;
	private java.lang.String className;
	private java.util.Date collectTime;
	private java.lang.String content;
	private java.lang.Integer libraryId;
	private java.lang.Integer originalId;
	private java.lang.Integer parentClassId;
	private java.lang.String parentClassName;

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
	 * Return the value associated with the column: collect_time
	 */
	public java.util.Date getCollectTime () {
		return collectTime;
	}

	/**
	 * Set the value related to the column: collect_time
	 * @param collectTime the collect_time value
	 */
	public void setCollectTime (java.util.Date collectTime) {
		this.collectTime = collectTime;
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
	 * Return the value associated with the column: library_id
	 */
	public java.lang.Integer getLibraryId () {
		return libraryId;
	}

	/**
	 * Set the value related to the column: library_id
	 * @param libraryId the library_id value
	 */
	public void setLibraryId (java.lang.Integer libraryId) {
		this.libraryId = libraryId;
	}



	/**
	 * Return the value associated with the column: original_id
	 */
	public java.lang.Integer getOriginalId () {
		return originalId;
	}

	/**
	 * Set the value related to the column: original_id
	 * @param originalId the original_id value
	 */
	public void setOriginalId (java.lang.Integer originalId) {
		this.originalId = originalId;
	}



	/**
	 * Return the value associated with the column: parent_class_id
	 */
	public java.lang.Integer getParentClassId () {
		return parentClassId;
	}

	/**
	 * Set the value related to the column: parent_class_id
	 * @param parentClassId the parent_class_id value
	 */
	public void setParentClassId (java.lang.Integer parentClassId) {
		this.parentClassId = parentClassId;
	}



	/**
	 * Return the value associated with the column: parent_class_name
	 */
	public java.lang.String getParentClassName () {
		return parentClassName;
	}

	/**
	 * Set the value related to the column: parent_class_name
	 * @param parentClassName the parent_class_name value
	 */
	public void setParentClassName (java.lang.String parentClassName) {
		this.parentClassName = parentClassName;
	}



	/**
	 * Return the value associated with the column: customer_id
	 */
	public com.juicy.signature.persist.po.HgCustomer getCustomer () {
		return customer;
	}

	/**
	 * Set the value related to the column: customer_id
	 * @param customer the customer_id value
	 */
	public void setCustomer (com.juicy.signature.persist.po.HgCustomer customer) {
		this.customer = customer;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.SignatureCollect)) return false;
		else {
			com.juicy.signature.persist.po.SignatureCollect signatureCollect = (com.juicy.signature.persist.po.SignatureCollect) obj;
			if (null == this.getId() || null == signatureCollect.getId()) return false;
			else return (this.getId().equals(signatureCollect.getId()));
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