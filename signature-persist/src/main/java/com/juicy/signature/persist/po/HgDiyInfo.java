package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseHgDiyInfo;

public class HgDiyInfo extends BaseHgDiyInfo {
	private static final long serialVersionUID = 1L;

	/** 个性化签名 */
	public static final Byte PERSONALIZED = 0;

	/** 默认签名 */
	public static final Byte DEFAULT = 1;

	/** 闪信 */
	public static final Integer FLASH = 3;

	/** 未使用标识 */
	public static final Integer UNUSED = 1;

	/** 使用标识 */
	public static final Integer USED = 2;
	
	/** 使用签名盒签名标识 */
	public static final Byte USESINGLE = 0;
	
	/** 使用签名盒随机签名 */
	public static final Byte USELIBRARY = 1;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public HgDiyInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HgDiyInfo (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HgDiyInfo (
		java.lang.Integer id,
		java.lang.Integer customerId,
		java.lang.Integer messageTypeId,
		java.lang.Integer diyInfoCurType,
		java.lang.Byte flag) {

		super (
			id,
			customerId,
			messageTypeId,
			diyInfoCurType,
			flag);
	}

	/* [CONSTRUCTOR MARKER END] */

}