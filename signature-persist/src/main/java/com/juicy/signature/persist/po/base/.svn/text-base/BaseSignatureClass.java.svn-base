package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SIGNATURE_CLASS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SIGNATURE_CLASS"
 */

public abstract class BaseSignatureClass  implements Serializable {

	public static String REF = "SignatureClass";
	public static String PROP_BASIS = "Basis";
	public static String PROP_NAME = "Name";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_PARENT_ID = "ParentId";
	public static String PROP_ID = "Id";


	// constructors
	public BaseSignatureClass () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSignatureClass (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSignatureClass (
		java.lang.Integer id,
		java.lang.Integer parentId,
		java.lang.Byte basis,
		boolean deleted) {

		this.setId(id);
		this.setParentId(parentId);
		this.setBasis(basis);
		this.setDeleted(deleted);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer parentId;
	private java.lang.String name;
	private java.lang.Byte basis;
	private boolean deleted;



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
	 * Return the value associated with the column: basis
	 */
	public java.lang.Byte getBasis () {
		return basis;
	}

	/**
	 * Set the value related to the column: basis
	 * @param basis the basis value
	 */
	public void setBasis (java.lang.Byte basis) {
		this.basis = basis;
	}



	/**
	 * Return the value associated with the column: deleted
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param deleted the deleted value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.SignatureClass)) return false;
		else {
			com.juicy.signature.persist.po.SignatureClass signatureClass = (com.juicy.signature.persist.po.SignatureClass) obj;
			if (null == this.getId() || null == signatureClass.getId()) return false;
			else return (this.getId().equals(signatureClass.getId()));
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