/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.util.List;

import com.juicy.signature.action.base.SignatureManageBaseAction;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 原创签名管理Action
 * 
 * @author 路卫杰
 * @version <p>
 *          Nov 18, 2011 创建
 *          </p>
 */
public class OriginalManageAction extends SignatureManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 原创签名List */
	private List<SignatureOriginal> originals;

	/** 分页信息类 */
	private Page page;

	/** 分类 */
	List<SignatureClass> classes;

	/** 要查找的分类ID */
	private Integer classId;

	/** 要处理的原创签名ID */
	private Integer originalId;

	/** 处理结果信息 */
	private String message;

	/**
	 * 显示原创签名
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if (page == null) {
			page = new Page();
		}

		SignatureClass signatureClass = null;
		if (classId != null && classId != 0) {
			signatureClass = new SignatureClass();
			signatureClass.setId(classId);
		}

		Result result = originalManage.viewOriginal(signatureClass, true, null,
				page);

		if (result.isSuccess()) {
			classes = (List<SignatureClass>) result.getModel().get(
					"firstClassList");
			originals = (List<SignatureOriginal>) result.getModel().get(
					"originalList");
			page = (Page) result.getModel().get("page");
		}

		return SUCCESS;
	}

	/**
	 * 推荐原创签名
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String recommend() throws Exception {
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");
		Integer customerId = user.getCustomerId();
		
		Result result = originalManage.recommendOriginal(originalId, customerId);

		if(result.isSuccess()){
			this.setMessage(getText("manage.recommend.success"));
		}else{
			this.setMessage(getText("manage.recommend.fail"));
		}
		
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

	public List<SignatureClass> getClasses() {
		return classes;
	}

	public void setClasses(List<SignatureClass> classes) {
		this.classes = classes;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getOriginalId() {
		return originalId;
	}

	public void setOriginalId(Integer originalId) {
		this.originalId = originalId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
