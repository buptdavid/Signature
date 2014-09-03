package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SIGNATURE_ORIGINAL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SIGNATURE_ORIGINAL"
 */

public abstract class BaseSignatureOriginal  implements Serializable {

	public static String REF = "SignatureOriginal";
	public static String PROP_CUSTOMER = "Customer";
	public static String PROP_RECOMMEND = "Recommend";
	public static String PROP_AUDIT_STATUS = "AuditStatus";
	public static String PROP_PUBLISH = "Publish";
	public static String PROP_SIGNATURE_CLASS = "SignatureClass";
	public static String PROP_GMT_TIME = "GmtTime";
	public static String PROP_ID = "Id";
	public static String PROP_CONTENT = "Content";
	public static String PROP_MDF_TIME = "MdfTime";


	// constructors
	public BaseSignatureOriginal () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSignatureOriginal (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSignatureOriginal (
		java.lang.Integer id,
		com.juicy.signature.persist.po.HgCustomer customer,
		java.lang.Boolean publish,
		java.lang.Byte auditStatus,
		java.lang.Boolean recommend,
		java.util.Date gmtTime) {

		this.setId(id);
		this.setCustomer(customer);
		this.setPublish(publish);
		this.setAuditStatus(auditStatus);
		this.setRecommend(recommend);
		this.setGmtTime(gmtTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String content;
	private java.lang.Boolean publish;
	private java.lang.Byte auditStatus;
	private java.lang.Boolean recommend;
	private java.util.Date gmtTime;
	private java.util.Date mdfTime;

	// many to one
	private com.juicy.signature.persist.po.SignatureClass signatureClass;
	private com.juicy.signature.persist.po.HgCustomer customer;

	// collections
	private java.util.Set<com.juicy.signature.persist.po.HgDiyInfo> hgDiyInfos;



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
	 * Return the value associated with the column: is_publish
	 */
	public java.lang.Boolean isPublish () {
		return publish;
	}

	/**
	 * Set the value related to the column: is_publish
	 * @param publish the is_publish value
	 */
	public void setPublish (java.lang.Boolean publish) {
		this.publish = publish;
	}



	/**
	 * Return the value associated with the column: audit_status
	 */
	public java.lang.Byte getAuditStatus () {
		return auditStatus;
	}

	/**
	 * Set the value related to the column: audit_status
	 * @param auditStatus the audit_status value
	 */
	public void setAuditStatus (java.lang.Byte auditStatus) {
		this.auditStatus = auditStatus;
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
	 * Return the value associated with the column: gmt_time
	 */
	public java.util.Date getGmtTime () {
		return gmtTime;
	}

	/**
	 * Set the value related to the column: gmt_time
	 * @param gmtTime the gmt_time value
	 */
	public void setGmtTime (java.util.Date gmtTime) {
		this.gmtTime = gmtTime;
	}



	/**
	 * Return the value associated with the column: mdf_time
	 */
	public java.util.Date getMdfTime () {
		return mdfTime;
	}

	/**
	 * Set the value related to the column: mdf_time
	 * @param mdfTime the mdf_time value
	 */
	public void setMdfTime (java.util.Date mdfTime) {
		this.mdfTime = mdfTime;
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



	/**
	 * Return the value associated with the column: HgDiyInfos
	 */
	public java.util.Set<com.juicy.signature.persist.po.HgDiyInfo> getHgDiyInfos () {
		return hgDiyInfos;
	}

	/**
	 * Set the value related to the column: HgDiyInfos
	 * @param hgDiyInfos the HgDiyInfos value
	 */
	public void setHgDiyInfos (java.util.Set<com.juicy.signature.persist.po.HgDiyInfo> hgDiyInfos) {
		this.hgDiyInfos = hgDiyInfos;
	}

	public void addToHgDiyInfos (com.juicy.signature.persist.po.HgDiyInfo hgDiyInfo) {
		if (null == getHgDiyInfos()) setHgDiyInfos(new java.util.TreeSet<com.juicy.signature.persist.po.HgDiyInfo>());
		getHgDiyInfos().add(hgDiyInfo);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.SignatureOriginal)) return false;
		else {
			com.juicy.signature.persist.po.SignatureOriginal signatureOriginal = (com.juicy.signature.persist.po.SignatureOriginal) obj;
			if (null == this.getId() || null == signatureOriginal.getId()) return false;
			else return (this.getId().equals(signatureOriginal.getId()));
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