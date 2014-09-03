package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_OWN_PHONE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_OWN_PHONE"
 */

public abstract class BaseHgOwnPhone  implements Serializable {

	public static String REF = "HgOwnPhone";
	public static String PROP_OWN_PHONE_ZONE = "OwnPhoneZone";
	public static String PROP_OWN_PHONE_TYPE = "OwnPhoneType";
	public static String PROP_CUSTOMER_ID = "CustomerId";
	public static String PROP_OWN_PHONE = "OwnPhone";
	public static String PROP_ID = "Id";


	// constructors
	public BaseHgOwnPhone () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgOwnPhone (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgOwnPhone (
		java.lang.Integer id,
		java.lang.Integer customerId,
		java.lang.String ownPhone) {

		this.setId(id);
		this.setCustomerId(customerId);
		this.setOwnPhone(ownPhone);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer customerId;
	private java.lang.String ownPhoneZone;
	private java.lang.String ownPhone;
	private java.lang.Integer ownPhoneType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="OWN_PHONE_ID"
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
	 * Return the value associated with the column: CUSTOMER_ID
	 */
	public java.lang.Integer getCustomerId () {
		return customerId;
	}

	/**
	 * Set the value related to the column: CUSTOMER_ID
	 * @param customerId the CUSTOMER_ID value
	 */
	public void setCustomerId (java.lang.Integer customerId) {
		this.customerId = customerId;
	}



	/**
	 * Return the value associated with the column: OWN_PHONE_ZONE
	 */
	public java.lang.String getOwnPhoneZone () {
		return ownPhoneZone;
	}

	/**
	 * Set the value related to the column: OWN_PHONE_ZONE
	 * @param ownPhoneZone the OWN_PHONE_ZONE value
	 */
	public void setOwnPhoneZone (java.lang.String ownPhoneZone) {
		this.ownPhoneZone = ownPhoneZone;
	}



	/**
	 * Return the value associated with the column: OWN_PHONE
	 */
	public java.lang.String getOwnPhone () {
		return ownPhone;
	}

	/**
	 * Set the value related to the column: OWN_PHONE
	 * @param ownPhone the OWN_PHONE value
	 */
	public void setOwnPhone (java.lang.String ownPhone) {
		this.ownPhone = ownPhone;
	}



	/**
	 * Return the value associated with the column: OWN_PHONE_TYPE
	 */
	public java.lang.Integer getOwnPhoneType () {
		return ownPhoneType;
	}

	/**
	 * Set the value related to the column: OWN_PHONE_TYPE
	 * @param ownPhoneType the OWN_PHONE_TYPE value
	 */
	public void setOwnPhoneType (java.lang.Integer ownPhoneType) {
		this.ownPhoneType = ownPhoneType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgOwnPhone)) return false;
		else {
			com.juicy.signature.persist.po.HgOwnPhone hgOwnPhone = (com.juicy.signature.persist.po.HgOwnPhone) obj;
			if (null == this.getId() || null == hgOwnPhone.getId()) return false;
			else return (this.getId().equals(hgOwnPhone.getId()));
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