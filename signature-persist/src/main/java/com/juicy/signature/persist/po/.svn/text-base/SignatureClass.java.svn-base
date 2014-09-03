package com.juicy.signature.persist.po;

import java.util.List;

import com.juicy.signature.persist.po.base.BaseSignatureClass;

public class SignatureClass extends BaseSignatureClass {
	private static final long serialVersionUID = 1L;
	
	/** 原创情景签名 */
	public static final Byte ORIGINAL = 1;

	/** 签名宝库 */
	public static final Byte LIBRARY = 2;
	
	/** 所包含的二级分类 */
	private List<SignatureClass> secondClasses;

	/** 所属于的一级分类 */
	private SignatureClass firstClass;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public SignatureClass () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public SignatureClass (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public SignatureClass (
		java.lang.Integer id,
		java.lang.Integer parentId,
		java.lang.Byte basis,
		boolean deleted) {

		super (
			id,
			parentId,
			basis,
			deleted);
	}

	/* [CONSTRUCTOR MARKER END] */
	
	public List<SignatureClass> getSecondClasses() {
		return secondClasses;
	}

	public void setSecondClasses(List<SignatureClass> secondClasses) {
		this.secondClasses = secondClasses;
	}

	public SignatureClass getFirstClass() {
		return firstClass;
	}

	public void setFirstClass(SignatureClass firstClass) {
		this.firstClass = firstClass;
	}
	
	

}