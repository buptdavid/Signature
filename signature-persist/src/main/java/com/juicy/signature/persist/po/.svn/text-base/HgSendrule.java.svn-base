package com.juicy.signature.persist.po;

import com.juicy.signature.persist.po.base.BaseHgSendrule;

public class HgSendrule extends BaseHgSendrule implements Cloneable{
	private static final long serialVersionUID = 1L;

	/** 个性化签名 */
	public static final Integer PERSONALIZED = 0;

	/** 默认签名 */
	public static final Integer DEFAULT = 1;
	
	/** 默认签名 */
	public static String DEFAULTRULE = "默认签名";

	/** 按天设置 */
	public static String DAYRULE = "按天设置";

	/** 按周设置 */
	public static String WEEKRULE = "按周设置";	

	/* [CONSTRUCTOR MARKER BEGIN] */
	public HgSendrule () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HgSendrule (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HgSendrule (
		java.lang.Integer id,
		java.lang.Integer customerId,
		java.lang.String sendruleName,
		java.lang.Integer sendruleIfFlowcontrol,
		java.lang.Integer sendruleCallState) {

		super (
			id,
			customerId,
			sendruleName,
			sendruleIfFlowcontrol,
			sendruleCallState);
	}

	/* [CONSTRUCTOR MARKER END] */

	/**
	 * 克隆操作,只是浅复制
	 * 
	 * @return 自身对象的一个副本
	 * @throws CloneNotSupportedException
	 */
	public HgSendrule clone() {
		// 先调用父类的克隆方法进行克隆操作
		HgSendrule hgSendrule = null;
		try {
			hgSendrule = (HgSendrule) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return hgSendrule;
	}
	
	

}