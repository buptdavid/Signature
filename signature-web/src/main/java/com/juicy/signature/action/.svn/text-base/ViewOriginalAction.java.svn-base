/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 显示用户的原创签名Action
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-24 创建
 *          </p>
 */
public class ViewOriginalAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -6376154507294518924L;

	/** 查询关键字 */
	private String keyWord;

	/** 用户原创签名List */
	private List<SignatureOriginal> originals;

	/** 用户审核状态 */
	private Byte auditStatus;

	/** 分页信息对象 */
	private Page page;
	
	/** chain调用传递的message信息 */
	private String message;

	/**
	 * 显示用户的原创签名方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 如果page对象为空，则new一个对象
		if (page == null) {
			page = new Page();
		}

		// 业务逻辑操作
		Result result = signatureService.getOriginal(user, keyWord,
				auditStatus, page);

		// 为结果赋值
		originals = (List<SignatureOriginal>) result.getModel().get(
				"signatureOriginalList");
		page = (Page) result.getModel().get("page");

		// 返回
		return SUCCESS;
	}

	public List<SignatureOriginal> getOriginals() {
		return originals;
	}

	public void setOriginals(List<SignatureOriginal> originals) {
		this.originals = originals;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Byte getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
