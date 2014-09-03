package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_DEFRULE_CONTENT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_DEFRULE_CONTENT"
 */

public abstract class BaseHgDefruleContent  implements Serializable {

	public static String REF = "HgDefruleContent";
	public static String PROP_PRE_CONTENT = "PreContent";
	public static String PROP_ID = "Id";
	public static String PROP_DESCR = "Descr";
	public static String PROP_DEFCONTENT = "Defcontent";


	// constructors
	public BaseHgDefruleContent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgDefruleContent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgDefruleContent (
		java.lang.Integer id,
		java.lang.String defcontent) {

		this.setId(id);
		this.setDefcontent(defcontent);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String defcontent;
	private java.lang.String descr;
	private java.lang.String preContent;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="ID"
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
	 * Return the value associated with the column: DEFCONTENT
	 */
	public java.lang.String getDefcontent () {
		return defcontent;
	}

	/**
	 * Set the value related to the column: DEFCONTENT
	 * @param defcontent the DEFCONTENT value
	 */
	public void setDefcontent (java.lang.String defcontent) {
		this.defcontent = defcontent;
	}



	/**
	 * Return the value associated with the column: DESCR
	 */
	public java.lang.String getDescr () {
		return descr;
	}

	/**
	 * Set the value related to the column: DESCR
	 * @param descr the DESCR value
	 */
	public void setDescr (java.lang.String descr) {
		this.descr = descr;
	}



	/**
	 * Return the value associated with the column: pre_content
	 */
	public java.lang.String getPreContent () {
		return preContent;
	}

	/**
	 * Set the value related to the column: pre_content
	 * @param preContent the pre_content value
	 */
	public void setPreContent (java.lang.String preContent) {
		this.preContent = preContent;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgDefruleContent)) return false;
		else {
			com.juicy.signature.persist.po.HgDefruleContent hgDefruleContent = (com.juicy.signature.persist.po.HgDefruleContent) obj;
			if (null == this.getId() || null == hgDefruleContent.getId()) return false;
			else return (this.getId().equals(hgDefruleContent.getId()));
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