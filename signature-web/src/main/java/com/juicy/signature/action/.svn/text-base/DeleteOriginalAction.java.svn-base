/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.service.result.Result;

/**
 * 删除原创签名Action
 *
 * @author 路卫杰
 * @version <p>2011-8-29 创建</p>
 */
public class DeleteOriginalAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -2522079039599962063L;
	
	/** 要删除的原创签名ID列表,取名cb是为了兼容页面js代码 */
	private List<Integer> cb;
	
	/** 删除后的信息 */
	private String message;
	
	/**
	 * 删除用户原创签名方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		
		//进行业务逻辑删除操作
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
