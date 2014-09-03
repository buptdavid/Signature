/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.service.result.Result;

/**
 * ɾ��ԭ��ǩ��Action
 *
 * @author ·����
 * @version <p>2011-8-29 ����</p>
 */
public class DeleteOriginalAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -2522079039599962063L;
	
	/** Ҫɾ����ԭ��ǩ��ID�б�,ȡ��cb��Ϊ�˼���ҳ��js���� */
	private List<Integer> cb;
	
	/** ɾ�������Ϣ */
	private String message;
	
	/**
	 * ɾ���û�ԭ��ǩ������
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		
		//����ҵ���߼�ɾ������
		Result result = signatureService.deleteOriginal(cb);
		
		if(result.isSuccess() == true){
			this.setMessage(getText("deleteOriginal_success"));
		}
		
		return SUCCESS;
	}
	
	public List<Integer> getCb() {
		return cb;
	}

	public void setCb(List<Integer> cb) {
		this.cb = cb;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
