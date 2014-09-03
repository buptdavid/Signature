/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.Iterator;
import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.service.SignatureService;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * ǩ���У����⣩Action
 * 
 * @author ·����
 * @version <p>
 *          2011-9-5 ����
 *          </p>
 */
public class LibraryAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 8599514455655066179L;

	/** ǩ������һ������ */
	private List<SignatureClass> firstClasses;

	/** Ҫ���ҵķ���ID */
	private Integer signatureClassId;

	/** Ҫ���ҵķ������� */
	private String className;

	/** һ�����໹�Ƕ�������,1��ʾһ�����࣬2��ʾ�������� */
	private Integer firstOrSecond;

	/** ǩ������ǩ�� */
	private List<SignatureLibrary> librarys;

	/** ԭ���龰ǩ����ҳ��Ϣʵ�� */
	private Page page;

	/**
	 * ��ʾ����ǩ������ǩ���ķ���
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		Result result = signatureService.getClassesByBasis(
				SignatureClass.LIBRARY, SignatureService.ALL);

		if (result.isSuccess()) {
			firstClasses = (List<SignatureClass>) result.getModel().get(
					"firstClassList");
		}

		if (page == null) {
			page = new Page();
		}

		if (firstClasses != null) {
			Iterator<SignatureClass> it = firstClasses.iterator();
			if (it.hasNext()) {
				signatureClassId = it.next().getId();
				className = it.next().getName();
			}
		}

		return SUCCESS;
	}

	/**
	 * ���ݷ�����ʾǩ������ǩ���ķ���
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String view() throws Exception {
		if (page == null) {
			page = new Page();
		}

		if (signatureClassId != null) {
			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(signatureClassId);

			// ���firstOrSecondΪ�ջ��ߵ���1��������һ������
			if (firstOrSecond == null || firstOrSecond.equals(1)) {
				signatureClass.setParentId(0);
			} else {
				signatureClass.setParentId(1);
			}

			Result result = signatureService.getLibrary(signatureClass, null,
					page);

			if (result.isSuccess()) {
				librarys = (List<SignatureLibrary>) result.getModel().get(
						"signatureLibraryList");
				page = (Page) result.getModel().get("page");
			}
		}

		return SUCCESS;
	}

	public List<SignatureClass> getFirstClasses() {
		return firstClasses;
	}

	public void setFirstClasses(List<SignatureClass> firstClasses) {
		this.firstClasses = firstClasses;
	}

	public Integer getSignatureClassId() {
		return signatureClassId;
	}

	public void setSignatureClassId(Integer signatureClassId) {
		this.signatureClassId = signatureClassId;
	}

	public Integer getFirstOrSecond() {
		return firstOrSecond;
	}

	public void setFirstOrSecond(Integer firstOrSecond) {
		this.firstOrSecond = firstOrSecond;
	}

	public List<SignatureLibrary> getLibrarys() {
		return librarys;
	}

	public void setLibrarys(List<SignatureLibrary> librarys) {
		this.librarys = librarys;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
