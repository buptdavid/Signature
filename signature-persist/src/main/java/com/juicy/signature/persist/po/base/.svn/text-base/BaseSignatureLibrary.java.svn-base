package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SIGNATURE_LIBRARY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SIGNATURE_LIBRARY"
 */

public abstract class BaseSignatureLibrary  implements Serializable {

	public static String REF = "SignatureLibrary";
	public static String PROP_RECOMMEND = "Recommend";
	public static String PROP_SIGNATURE_CLASS = "SignatureClass";
	public static String PROP_ID = "Id";
	public static String PROP_CONTENT = "Content";


	// constructors
	public BaseSignatureLibrary () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSignatureLibrary (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSignatureLibrary (
		java.lang.Integer id,
		java.lang.Boolean recommend) {

		this.setId(id);
		this.setRecommend(recommend);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String content;
	private java.lang.Boolean recommend;

	// many to one
	private com.juicy.signature.persist.po.SignatureClass signatureClass;



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
	 * Return the value associated with the column: is_recommend
	 */
	public java.lang.Boolean isRecommend () {
		return recommend;
	}

	/**
	 * Set the value related to the column: is_recommend
	 * @param recommend the is_recommend value
	 */
	public void setRecommend (java.lang.Boolean recommend) {
		this.recommend = recommend;
	}



	/**
	 * Return the value associated with the column: class_id
	 */
	public com.juicy.signature.persist.po.SignatureClass getSignatureClass () {
		return signatureClass;
	}

	/**
	 * Set the value related to the column: class_id
	 * @param signatureClass the class_id value
	 */
	public void setSignatureClass (com.juicy.signature.persist.po.SignatureClass signatureClass) {
		this.signatureClass = signatureClass;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.SignatureLibrary)) return false;
		else {
			com.juicy.signature.persist.po.SignatureLibrary signatureLibrary = (com.juicy.signature.persist.po.SignatureLibrary) obj;
			if (null == this.getId() || null == signatureLibrary.getId()) return false;
			else return (this.getId().equals(signatureLibrary.getId()));
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