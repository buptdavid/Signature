package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HG_DIY_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HG_DIY_INFO"
 */

public abstract class BaseHgDiyInfo  implements Serializable {

	public static String REF = "HgDiyInfo";
	public static String PROP_FLAG = "Flag";
	public static String PROP_IS_DEFAULT = "IsDefault";
	public static String PROP_DIY_INFO_CONTENT = "DiyInfoContent";
	public static String PROP_ORIGINAL = "Original";
	public static String PROP_DIY_INFO_NAME = "DiyInfoName";
	public static String PROP_DIY_INFO_LANG_TYPE = "DiyInfoLangType";
	public static String PROP_FOLDERNAME = "Foldername";
	public static String PROP_LIBRARY_CLASS_NAME = "LibraryClassName";
	public static String PROP_CUSTOMER_ID = "CustomerId";
	public static String PROP_LIBRARY = "Library";
	public static String PROP_DIY_INFO_PAGES = "DiyInfoPages";
	public static String PROP_DIY_INFO_CUR_TYPE = "DiyInfoCurType";
	public static String PROP_DIY_INFO_CREATETIME = "DiyInfoCreatetime";
	public static String PROP_LIBRARY_CLASS_ID = "LibraryClassId";
	public static String PROP_MESSAGE_TYPE_ID = "MessageTypeId";
	public static String PROP_DIY_INFO_CANEDIT = "DiyInfoCanedit";
	public static String PROP_FOLDERZIP = "Folderzip";
	public static String PROP_ID = "Id";


	// constructors
	public BaseHgDiyInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHgDiyInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHgDiyInfo (
		java.lang.Integer id,
		java.lang.Integer customerId,
		java.lang.Integer messageTypeId,
		java.lang.Integer diyInfoCurType,
		java.lang.Byte flag) {

		this.setId(id);
		this.setCustomerId(customerId);
		this.setMessageTypeId(messageTypeId);
		this.setDiyInfoCurType(diyInfoCurType);
		this.setFlag(flag);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer customerId;
	private java.lang.Integer messageTypeId;
	private java.lang.String diyInfoName;
	private java.lang.Integer diyInfoCurType;
	private java.util.Date diyInfoCreatetime;
	private java.lang.Integer diyInfoLangType;
	private java.lang.String diyInfoContent;
	private java.lang.Integer diyInfoPages;
	private java.lang.Integer diyInfoCanedit;
	private java.lang.String foldername;
	private java.lang.String folderzip;
	private java.lang.Byte isDefault;
	private java.lang.Byte flag;
	private java.lang.Integer libraryClassId;
	private java.lang.String libraryClassName;

	// many to one
	private com.juicy.signature.persist.po.SignatureOriginal original;
	private com.juicy.signature.persist.po.SignatureLibrary library;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="DIY_INFO_ID"
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
	 * Return the value associated with the column: MESSAGE_TYPE_ID
	 */
	public java.lang.Integer getMessageTypeId () {
		return messageTypeId;
	}

	/**
	 * Set the value related to the column: MESSAGE_TYPE_ID
	 * @param messageTypeId the MESSAGE_TYPE_ID value
	 */
	public void setMessageTypeId (java.lang.Integer messageTypeId) {
		this.messageTypeId = messageTypeId;
	}



	/**
	 * Return the value associated with the column: DIY_INFO_NAME
	 */
	public java.lang.String getDiyInfoName () {
		return diyInfoName;
	}

	/**
	 * Set the value related to the column: DIY_INFO_NAME
	 * @param diyInfoName the DIY_INFO_NAME value
	 */
	public void setDiyInfoName (java.lang.String diyInfoName) {
		this.diyInfoName = diyInfoName;
	}



	/**
	 * Return the value associated with the column: DIY_INFO_CUR_TYPE
	 */
	public java.lang.Integer getDiyInfoCurType () {
		return diyInfoCurType;
	}

	/**
	 * Set the value related to the column: DIY_INFO_CUR_TYPE
	 * @param diyInfoCurType the DIY_INFO_CUR_TYPE value
	 */
	public void setDiyInfoCurType (java.lang.Integer diyInfoCurType) {
		this.diyInfoCurType = diyInfoCurType;
	}



	/**
	 * Return the value associated with the column: DIY_INFO_CREATETIME
	 */
	public java.util.Date getDiyInfoCreatetime () {
		return diyInfoCreatetime;
	}

	/**
	 * Set the value related to the column: DIY_INFO_CREATETIME
	 * @param diyInfoCreatetime the DIY_INFO_CREATETIME value
	 */
	public void setDiyInfoCreatetime (java.util.Date diyInfoCreatetime) {
		this.diyInfoCreatetime = diyInfoCreatetime;
	}



	/**
	 * Return the value associated with the column: DIY_INFO_LANG_TYPE
	 */
	public java.lang.Integer getDiyInfoLangType () {
		return diyInfoLangType;
	}

	/**
	 * Set the value related to the column: DIY_INFO_LANG_TYPE
	 * @param diyInfoLangType the DIY_INFO_LANG_TYPE value
	 */
	public void setDiyInfoLangType (java.lang.Integer diyInfoLangType) {
		this.diyInfoLangType = diyInfoLangType;
	}



	/**
	 * Return the value associated with the column: DIY_INFO_CONTENT
	 */
	public java.lang.String getDiyInfoContent () {
		return diyInfoContent;
	}

	/**
	 * Set the value related to the column: DIY_INFO_CONTENT
	 * @param diyInfoContent the DIY_INFO_CONTENT value
	 */
	public void setDiyInfoContent (java.lang.String diyInfoContent) {
		this.diyInfoContent = diyInfoContent;
	}



	/**
	 * Return the value associated with the column: DIY_INFO_PAGES
	 */
	public java.lang.Integer getDiyInfoPages () {
		return diyInfoPages;
	}

	/**
	 * Set the value related to the column: DIY_INFO_PAGES
	 * @param diyInfoPages the DIY_INFO_PAGES value
	 */
	public void setDiyInfoPages (java.lang.Integer diyInfoPages) {
		this.diyInfoPages = diyInfoPages;
	}



	/**
	 * Return the value associated with the column: DIY_INFO_CANEDIT
	 */
	public java.lang.Integer getDiyInfoCanedit () {
		return diyInfoCanedit;
	}

	/**
	 * Set the value related to the column: DIY_INFO_CANEDIT
	 * @param diyInfoCanedit the DIY_INFO_CANEDIT value
	 */
	public void setDiyInfoCanedit (java.lang.Integer diyInfoCanedit) {
		this.diyInfoCanedit = diyInfoCanedit;
	}



	/**
	 * Return the value associated with the column: FOLDERNAME
	 */
	public java.lang.String getFoldername () {
		return foldername;
	}

	/**
	 * Set the value related to the column: FOLDERNAME
	 * @param foldername the FOLDERNAME value
	 */
	public void setFoldername (java.lang.String foldername) {
		this.foldername = foldername;
	}



	/**
	 * Return the value associated with the column: FOLDERZIP
	 */
	public java.lang.String getFolderzip () {
		return folderzip;
	}

	/**
	 * Set the value related to the column: FOLDERZIP
	 * @param folderzip the FOLDERZIP value
	 */
	public void setFolderzip (java.lang.String folderzip) {
		this.folderzip = folderzip;
	}



	/**
	 * Return the value associated with the column: IS_DEFAULT
	 */
	public java.lang.Byte getIsDefault () {
		return isDefault;
	}

	/**
	 * Set the value related to the column: IS_DEFAULT
	 * @param isDefault the IS_DEFAULT value
	 */
	public void setIsDefault (java.lang.Byte isDefault) {
		this.isDefault = isDefault;
	}



	/**
	 * Return the value associated with the column: FLAG
	 */
	public java.lang.Byte getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: FLAG
	 * @param flag the FLAG value
	 */
	public void setFlag (java.lang.Byte flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: LIBRARY_CLASS_ID
	 */
	public java.lang.Integer getLibraryClassId () {
		return libraryClassId;
	}

	/**
	 * Set the value related to the column: LIBRARY_CLASS_ID
	 * @param libraryClassId the LIBRARY_CLASS_ID value
	 */
	public void setLibraryClassId (java.lang.Integer libraryClassId) {
		this.libraryClassId = libraryClassId;
	}



	/**
	 * Return the value associated with the column: LIBRARY_CLASS_NAME
	 */
	public java.lang.String getLibraryClassName () {
		return libraryClassName;
	}

	/**
	 * Set the value related to the column: LIBRARY_CLASS_NAME
	 * @param libraryClassName the LIBRARY_CLASS_NAME value
	 */
	public void setLibraryClassName (java.lang.String libraryClassName) {
		this.libraryClassName = libraryClassName;
	}



	/**
	 * Return the value associated with the column: ORIGINAL_ID
	 */
	public com.juicy.signature.persist.po.SignatureOriginal getOriginal () {
		return original;
	}

	/**
	 * Set the value related to the column: ORIGINAL_ID
	 * @param original the ORIGINAL_ID value
	 */
	public void setOriginal (com.juicy.signature.persist.po.SignatureOriginal original) {
		this.original = original;
	}



	/**
	 * Return the value associated with the column: LIBRARY_ID
	 */
	public com.juicy.signature.persist.po.SignatureLibrary getLibrary () {
		return library;
	}

	/**
	 * Set the value related to the column: LIBRARY_ID
	 * @param library the LIBRARY_ID value
	 */
	public void setLibrary (com.juicy.signature.persist.po.SignatureLibrary library) {
		this.library = library;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgDiyInfo)) return false;
		else {
			com.juicy.signature.persist.po.HgDiyInfo hgDiyInfo = (com.juicy.signature.persist.po.HgDiyInfo) obj;
			if (null == this.getId() || null == hgDiyInfo.getId()) return false;
			else return (this.getId().equals(hgDiyInfo.getId()));
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