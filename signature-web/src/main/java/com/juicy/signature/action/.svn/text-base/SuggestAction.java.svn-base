/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import com.juicy.signature.action.base.SuggestBaseAction;
import com.juicy.signature.persist.po.Suggest;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 意见Action
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-1 创建
 *          </p>
 */
public class SuggestAction extends SuggestBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -7286832379739944508L;

	/** 意见Suggest对象 */
	private Suggest suggest;

	/** 操作结果信息 */
	private String message;

	/**
	 * 增加意见方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");
		
		Result result = suggestService.createSuggest(user, suggest);
		
		if(result.isSuccess()){
			message = getText("submitSuggest.suggest");
		}

		return SUCCESS;
	}

	public Suggest getSuggest() {
		return suggest;
	}

	public void setSuggest(Suggest suggest) {
		this.suggest = suggest;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
