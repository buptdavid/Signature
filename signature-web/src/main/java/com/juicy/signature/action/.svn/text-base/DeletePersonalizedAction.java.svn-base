/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.RuleBaseAction;
import com.juicy.signature.service.result.Result;

/**
 * 删除个性化签名Action
 *
 * @author 路卫杰
 * @version <p>2011-8-29 创建</p>
 */
public class DeletePersonalizedAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1061545480848444773L;
	
	/** 要删除的个性化签名ID */
	private List<Integer> cb;
	
	/** 删除操作后的信息 */
	private String message;
	
	/**
	 * 删除用户个性化签名方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		
		//进行删除
		Result result = ruleService.deletePersonalizedRule(cb);
		
		//设置结果
		if(result.isSuccess()){
			this.setMessage(getText("deletePersonalized.success"));
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
