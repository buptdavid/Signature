package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseHgDiyInfo;

public class HgDiyInfo extends BaseHgDiyInfo {
	private static final long serialVersionUID = 1L;

	/** ���Ի�ǩ�� */
	public static final Byte PERSONALIZED = 0;

	/** Ĭ��ǩ�� */
	public static final Byte DEFAULT = 1;

	/** ���� */
	public static final Integer FLASH = 3;

	/** δʹ�ñ�ʶ */
	public static final Integer UNUSED = 1;

	/** ʹ�ñ�ʶ */
	public static final Integer USED = 2;
	
	/** ʹ��ǩ����ǩ����ʶ */
	public static final Byte USESINGLE = 0;
	
	/** ʹ��ǩ�������ǩ�� */
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