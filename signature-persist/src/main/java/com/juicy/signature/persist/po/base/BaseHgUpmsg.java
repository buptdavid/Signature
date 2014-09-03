package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_UPMSG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_UPMSG"
 */

public abstract class BaseHgUpmsg  implements Serializable {

	public static String REF = "HgUpmsg";
	public static String PROP_UPMSG_STR = "UpmsgStr";
	public static String PROP_UPMSG_DES = "UpmsgDes";
	public static String PROP_UPMSG_ACTION_CODE = "UpmsgActionCode";


	// constructors
	public BaseHgUpmsg () {
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.Integer upmsgActionCode;
	private java.lang.String upmsgStr;
	private java.lang.String upmsgDes;






	/**
	 * Return the value associated with the column: UPMSG_ACTION_CODE
	 */
	public java.lang.Integer getUpmsgActionCode () {
		return upmsgActionCode;
	}

	/**
	 * Set the value related to the column: UPMSG_ACTION_CODE
	 * @param upmsgActionCode the UPMSG_ACTION_CODE value
	 */
	public void setUpmsgActionCode (java.lang.Integer upmsgActionCode) {
		this.upmsgActionCode = upmsgActionCode;
	}



	/**
	 * Return the value associated with the column: UPMSG_STR
	 */
	public java.lang.String getUpmsgStr () {
		return upmsgStr;
	}

	/**
	 * Set the value related to the column: UPMSG_STR
	 * @param upmsgStr the UPMSG_STR value
	 */
	public void setUpmsgStr (java.lang.String upmsgStr) {
		this.upmsgStr = upmsgStr;
	}



	/**
	 * Return the value associated with the column: UPMSG_DES
	 */
	public java.lang.String getUpmsgDes () {
		return upmsgDes;
	}

	/**
	 * Set the value related to the column: UPMSG_DES
	 * @param upmsgDes the UPMSG_DES value
	 */
	public void setUpmsgDes (java.lang.String upmsgDes) {
		this.upmsgDes = upmsgDes;
	}







	public String toString () {
		return super.toString();
	}


}