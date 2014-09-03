/**
 * Copyright @ 2011-2012 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import com.juicy.signature.action.base.SystemManageBaseAction;
import com.juicy.signature.persist.po.HgDefruleContent;
import com.juicy.signature.service.result.Result;

/**
 * �ַ�Ĭ��ǩ�����Action
 *
 * @author ·����
 * @version <p>Jan 12, 2012 ����</p>
 */
public class GroupManageAction extends SystemManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** �ַ���һ��Ĭ��ǩ�� */
	private String currentContent;
	
	/** Ҫ�޸ĵ�Ĭ��ǩ�� */
	private String content;
	
	
	/**
	 * �޸ľַ�Ĭ��ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		
		Result result = systemManage.modifyGroupContent(content);
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.modifyGroup.success") + result.getModel().get("amount"));
		}else{
			this.setMessage(result.getRemark());
		}
		
		return SUCCESS;
	}
	
	/**
	 * ��ʾ�޸ľַ�Ĭ��ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String viewUpdateGroup() throws Exception{
		Result result = systemManage.viewDefaultContent();
		if(result.isSuccess()){
			HgDefruleContent hgDefruleContent = (HgDefruleContent)result.getModel().get("defaultContent");
			currentContent = hgDefruleContent.getPreContent();
		}
		
		return SUCCESS;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCurrentContent() {
		return currentContent;
	}

	public void setCurrentContent(String currentContent) {
		this.currentContent = currentContent;
	}


}
