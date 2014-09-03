/**
 * Copyright @ 2011-2012 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import com.juicy.signature.action.base.SystemManageBaseAction;
import com.juicy.signature.persist.po.HgDefruleContent;
import com.juicy.signature.service.result.Result;

/**
 * 局方默认签名相关Action
 *
 * @author 路卫杰
 * @version <p>Jan 12, 2012 创建</p>
 */
public class GroupManageAction extends SystemManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 局方上一次默认签名 */
	private String currentContent;
	
	/** 要修改的默认签名 */
	private String content;
	
	
	/**
	 * 修改局方默认签名
	 * 
	 * @return 结果字符串
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
	 * 显示修改局方默认签名
	 * 
	 * @return 结果字符串
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
