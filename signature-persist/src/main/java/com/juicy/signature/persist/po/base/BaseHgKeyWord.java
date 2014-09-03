package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_KEY_WORD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_KEY_WORD"
 */

public abstract class BaseHgKeyWord  implements Serializable {

	public static String REF = "HgKeyWord";
	public static String PROP_KEY_WORD_NAME = "KeyWordName";
	public static String PROP_ID = "Id";
	public static String PROP_KEY_WORD_CONTENT = "KeyWordContent";


	// constructors
	public BaseHgKeyWord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgKeyWord (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgKeyWord (
		java.lang.Integer id,
		java.lang.String keyWordName,
		java.lang.String keyWordContent) {

		this.setId(id);
		this.setKeyWordName(keyWordName);
		this.setKeyWordContent(keyWordContent);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String keyWordName;
	private java.lang.String keyWordContent;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="KEY_WORD_ID"
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
	 * Return the value associated with the column: KEY_WORD_NAME
	 */
	public java.lang.String getKeyWordName () {
		return keyWordName;
	}

	/**
	 * Set the value related to the column: KEY_WORD_NAME
	 * @param keyWordName the KEY_WORD_NAME value
	 */
	public void setKeyWordName (java.lang.String keyWordName) {
		this.keyWordName = keyWordName;
	}



	/**
	 * Return the value associated with the column: KEY_WORD_CONTENT
	 */
	public java.lang.String getKeyWordContent () {
		return keyWordContent;
	}

	/**
	 * Set the value related to the column: KEY_WORD_CONTENT
	 * @param keyWordContent the KEY_WORD_CONTENT value
	 */
	public void setKeyWordContent (java.lang.String keyWordContent) {
		this.keyWordContent = keyWordContent;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgKeyWord)) return false;
		else {
			com.juicy.signature.persist.po.HgKeyWord hgKeyWord = (com.juicy.signature.persist.po.HgKeyWord) obj;
			if (null == this.getId() || null == hgKeyWord.getId()) return false;
			else return (this.getId().equals(hgKeyWord.getId()));
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