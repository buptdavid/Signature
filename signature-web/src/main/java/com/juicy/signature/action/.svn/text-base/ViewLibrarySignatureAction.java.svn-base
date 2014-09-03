/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
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
 * 显示签名盒中签名内容
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-23 创建
 *          </p>
 */
public class ViewLibrarySignatureAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 查询的签名盒对象 */
	private SignatureClass library;
	
	/** 分页信息对象 */
	private Page page;
	
	/** 该签名盒中的签名对象 */
	private List<SignatureLibrary> signatures;
	
	/**
	 * 显示签名盒中签名内容方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		//如果page为空，增new一个
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
