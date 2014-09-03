package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_REGIONCODE_REFLECT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_REGIONCODE_REFLECT"
 */

public abstract class BaseHgRegioncodeReflect  implements Serializable {

	public static String REF = "HgRegioncodeReflect";
	public static String PROP_BSC_MSC_BIT = "BscMscBit";
	public static String PROP_PROTOCOL_TYPE = "ProtocolType";
	public static String PROP_ID = "Id";
	public static String PROP_REGIONCODE_NAME = "RegioncodeName";
	public static String PROP_REGIONCODE = "Regioncode";


	// constructors
	public BaseHgRegioncodeReflect () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgRegioncodeReflect (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String regioncodeName;
	private java.lang.String bscMscBit;
	private java.lang.String regioncode;
	private java.lang.Integer protocolType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="REGIONCODE_ID"
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
	 * Return the value associated with the column: REGIONCODE_NAME
	 */
	public java.lang.String getRegioncodeName () {
		return regioncodeName;
	}

	/**
	 * Set the value related to the column: REGIONCODE_NAME
	 * @param regioncodeName the REGIONCODE_NAME value
	 */
	public void setRegioncodeName (java.lang.String regioncodeName) {
		this.regioncodeName = regioncodeName;
	}



	/**
	 * Return the value associated with the column: BSC_MSC_BIT
	 */
	public java.lang.String getBscMscBit () {
		return bscMscBit;
	}

	/**
	 * Set the value related to the column: BSC_MSC_BIT
	 * @param bscMscBit the BSC_MSC_BIT value
	 */
	public void setBscMscBit (java.lang.String bscMscBit) {
		this.bscMscBit = bscMscBit;
	}



	/**
	 * Return the value associated with the column: REGIONCODE
	 */
	public java.lang.String getRegioncode () {
		return regioncode;
	}

	/**
	 * Set the value related to the column: REGIONCODE
	 * @param regioncode the REGIONCODE value
	 */
	public void setRegioncode (java.lang.String regioncode) {
		this.regioncode = regioncode;
	}



	/**
	 * Return the value associated with the column: PROTOCOL_TYPE
	 */
	public java.lang.Integer getProtocolType () {
		return protocolType;
	}

	/**
	 * Set the value related to the column: PROTOCOL_TYPE
	 * @param protocolType the PROTOCOL_TYPE value
	 */
	public void setProtocolType (java.lang.Integer protocolType) {
		this.protocolType = protocolType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgRegioncodeReflect)) return false;
		else {
			com.juicy.signature.persist.po.HgRegioncodeReflect hgRegioncodeReflect = (com.juicy.signature.persist.po.HgRegioncodeReflect) obj;
			if (null == this.getId() || null == hgRegioncodeReflect.getId()) return false;
			else return (this.getId().equals(hgRegioncodeReflect.getId()));
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