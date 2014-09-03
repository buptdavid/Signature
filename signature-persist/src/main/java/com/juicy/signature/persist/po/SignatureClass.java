package com.juicy.signature.persist.po;

import java.util.List;

import com.juicy.signature.persist.po.base.BaseSignatureClass;

public class SignatureClass extends BaseSignatureClass {
	private static final long serialVersionUID = 1L;
	
	/** ԭ���龰ǩ�� */
	public static final Byte ORIGINAL = 1;

	/** ǩ������ */
	public static final Byte LIBRARY = 2;
	
	/** �������Ķ������� */
	private List<SignatureClass> secondClasses;

	/** �����ڵ�һ������ */
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