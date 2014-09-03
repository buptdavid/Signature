/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.action.base.ListBaseAction;
import com.juicy.signature.persist.po.HgSpecialNumbers;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 管理拒绝签名Action，包括添加，删除，查看
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-1 创建
 *          </p>
 */
public class ManageRefuseAction extends ListBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 3744764717906822383L;

	/** 查询到的拒绝签名对象列表 */
	private List<HgSpecialNumbers> specialNumbers;

	/** 基本分页信息Page对象 */
	private Page page;

	/** 要删除的拒绝签名ID列表 */
	private List<Integer> cb;

	/** 要增加的拒绝签名对象 */
	private HgSpecialNumbers specialNumber;

	/** 操作结果信息 */
	private String message;

	/**
	 * 增加拒绝签名
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 进行操作
		Result result = listService.createRefuseList(user,specialNumber);

		// 设置结果
		if (result.isSuccess()) {
			message = getText("createResult.success1");			
		}else{
			message = result.getRemark();
		}

		return SUCCESS;
	}

	/**
	 * 显示拒绝签名
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception {
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		if (page == null) {
			page = new Page();
		}

		// 查询
		Result result = listService.getRefuseList(user, page);

		// 设置结果
		specialNumbers = (List<HgSpecialNumbers>) result.getModel().get(
				"refuseList");
		page = (Page) result.getModel().get("page");

		return SUCCESS;
	}

	/**
	 * 删除拒绝签名
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String delete() throws Exception {
		// 执行删除操作
		Result result = listService.deleteList(cb);

		if (result.isSuccess()) {
			message = getText("deleteRefuse.success");
		}

		return SUCCESS;
	}

	public List<HgSpecialNumbers> getSpecialNumbers() {
		return specialNumbers;
	}

	public void setSpecialNumbers(List<HgSpecialNumbers> specialNumbers) {
		this.specialNumbers = specialNumbers;
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

	public HgSpecialNumbers getSpecialNumber() {
		return specialNumber;
	}

	public void setSpecialNumber(HgSpecialNumbers specialNumber) {
		this.specialNumber = specialNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
