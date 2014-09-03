/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action.base;

import com.juicy.signature.service.LibraryManage;
import com.juicy.signature.service.OriginalManage;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �龰ǩ����ǩ���й���Base Action
 *
 * @author ·����
 * @version <p>Nov 17, 2011 ����</p>
 */
public class SignatureManageBaseAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** ע��OriginalManage���� */
	protected OriginalManage originalManage;
	
	/** ע��LibraryManage���� */
	protected LibraryManage libraryManage;

	public OriginalManage getOriginalManage() {
		return originalManage;
	}

	public void setOriginalManage(OriginalManage originalManage) {
		this.originalManage = originalManage;
	}

	public LibraryManage getLibraryManage() {
		return libraryManage;
	}

	public void setLibraryManage(LibraryManage libraryManage) {
		this.libraryManage = libraryManage;
	}
	
	

}
