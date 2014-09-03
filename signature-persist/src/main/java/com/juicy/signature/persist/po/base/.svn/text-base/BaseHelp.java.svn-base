package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HELP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HELP"
 */

public abstract class BaseHelp  implements Serializable {

	public static String REF = "Help";
	public static String PROP_HELP_CONTENT = "HelpContent";
	public static String PROP_ID = "Id";


	// constructors
	public BaseHelp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHelp (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String helpContent;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="HELP_ID"
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
	 * Return the value associated with the column: HELP_CONTENT
	 */
	public java.lang.String getHelpContent () {
		return helpContent;
	}

	/**
	 * Set the value related to the column: HELP_CONTENT
	 * @param helpContent the HELP_CONTENT value
	 */
	public void setHelpContent (java.lang.String helpContent) {
		this.helpContent = helpContent;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.Help)) return false;
		else {
			com.juicy.signature.persist.po.Help help = (com.juicy.signature.persist.po.Help) obj;
			if (null == this.getId() || null == help.getId()) return false;
			else return (this.getId().equals(help.getId()));
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