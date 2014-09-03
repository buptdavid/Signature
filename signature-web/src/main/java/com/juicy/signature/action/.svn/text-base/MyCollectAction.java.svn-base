/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.SignatureCollect;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 我的收藏Action，包括收藏，显示，删除等操作
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-31 创建
 *          </p>
 */
public class MyCollectAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -7877021879869070658L;

	/** 要显示的我的收藏SignatureCollect对象列表 */
	private List<SignatureCollect> collects;

	/** 要删除的收藏签名ID列表,取名cb是为了兼容页面js代码 */
	private List<Integer> cb;

	/** 分页显示收藏的分页信息Page对象 */
	private Page page;

	/** 操作后的信息 */
	private String message;

	/** JSON参数 */
	private boolean success;

	/** 收藏签名的classId */
	private Integer classId;
	
	/** 收藏签名的content */
	private String content;
	
	/** 收藏签名的libraryId */
	private Integer libraryId;
	
	/** 收藏签名的originalId */
	private Integer originalId;
	
	/**
	 * 进行收藏的方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		SignatureCollect collect = new SignatureCollect();
		
		// 设置客户对象
		Integer customerId = user.getCustomerId();
		HgCustomer customer = new HgCustomer();
		customer.setId(customerId);
		collect.setCustomer(customer);
		//设置相应参数
		collect.setClassId(classId);
		collect.setContent(content);
		collect.setLibraryId(libraryId);
		collect.setOriginalId(originalId);

		// 保存
		Result result = signatureService.createCollect(collect);

		if(result.isSuccess()){
			this.setSuccess(true);
			this.setMessage(getText("saveCollect.success"));
		}else{
			this.setSuccess(false);
			this.setMessage(getText("saveCollect.fail"));
		}

		return SUCCESS;
	}

	/**
	 * 显示我的收藏方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception {
		if (page == null) {
			page = new Page();
		}

		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 进行查询
		Result result = signatureService.getCollect(user, null, page);

		// 设置结果
		collects = (List<SignatureCollect>) result.getModel().get(
				"signatureCollectList");
		page = (Page) result.getModel().get("page");

		// 返回
		return SUCCESS;
	}

	/**
	 * 删除我的签名收藏
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String delete() throws Exception {
		// 删除
		Result result = signatureService.deleteCollect(cb);

		// 设置结果
		if (result.isSuccess() == true) {
			this.setMessage(getText("deleteCollect_success"));
		}

		// 返回
		return SUCCESS;
	}

	public List<SignatureCollect> getCollects() {
		return collects;
	}

	public void setCollects(List<SignatureCollect> collects) {
		this.collects = collects;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
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

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	public Integer getOriginalId() {
		return originalId;
	}

	public void setOriginalId(Integer originalId) {
		this.originalId = originalId;
	}
	
	

}
