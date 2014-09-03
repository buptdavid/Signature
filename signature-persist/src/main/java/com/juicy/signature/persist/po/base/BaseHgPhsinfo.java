package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_PHSINFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_PHSINFO"
 */

public abstract class BaseHgPhsinfo  implements Serializable {

	public static String REF = "HgPhsinfo";
	public static String PROP_PHS_USERNUMBER = "PhsUsernumber";
	public static String PROP_ID = "Id";


	// constructors
	public BaseHgPhsinfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgPhsinfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgPhsinfo (
		java.lang.Integer id,
		java.lang.String phsUsernumber) {

		this.setId(id);
		this.setPhsUsernumber(phsUsernumber);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String phsUsernumber;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="PHS_USERID"
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
	 * Return the value associated with the column: PHS_USERNUMBER
	 */
	public java.lang.String getPhsUsernumber () {
		return phsUsernumber;
	}

	/**
	 * Set the value related to the column: PHS_USERNUMBER
	 * @param phsUsernumber the PHS_USERNUMBER value
	 */
	public void setPhsUsernumber (java.lang.String phsUsernumber) {
		this.phsUsernumber = phsUsernumber;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgPhsinfo)) return false;
		else {
			com.juicy.signature.persist.po.HgPhsinfo hgPhsinfo = (com.juicy.signature.persist.po.HgPhsinfo) obj;
			if (null == this.getId() || null == hgPhsinfo.getId()) return false;
			else return (this.getId().equals(hgPhsinfo.getId()));
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