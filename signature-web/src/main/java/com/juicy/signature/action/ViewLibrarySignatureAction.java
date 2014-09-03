/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * ��ʾǩ������ǩ������
 * 
 * @author ·����
 * @version <p>
 *          2011-8-23 ����
 *          </p>
 */
public class ViewLibrarySignatureAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** ��ѯ��ǩ���ж��� */
	private SignatureClass library;
	
	/** ��ҳ��Ϣ���� */
	private Page page;
	
	/** ��ǩ�����е�ǩ������ */
	private List<SignatureLibrary> signatures;
	
	/**
	 * ��ʾǩ������ǩ�����ݷ���
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		//���pageΪ�գ���newһ��
		if(page == null){
			page = new Page();
		}
		
		Integer libraryId = library.getId();
		Result result = signatureService.getLibrarySignature(libraryId, page);
		
		library = (SignatureClass)result.getModel().get("signatureClass");
		signatures = (List<SignatureLibrary>)result.getModel().get("signatureLibraryList");
		page = (Page)result.getModel().get("page");
				
		return SUCCESS;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public SignatureClass getLibrary() {
		return library;
	}

	public void setLibrary(SignatureClass library) {
		this.library = library;
	}

	public List<SignatureLibrary> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<SignatureLibrary> signatures) {
		this.signatures = signatures;
	}

		
}
