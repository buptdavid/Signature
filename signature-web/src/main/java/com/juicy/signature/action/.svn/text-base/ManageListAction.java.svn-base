/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.juicy.signature.action.base.ListBaseAction;
import com.juicy.signature.persist.po.HgSpecialNumbers;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 黑白名单和拒绝签名Action
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-31 创建
 *          </p>
 */
public class ManageListAction extends ListBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1170422598369553152L;

	/** 查询到的黑名单或者白名单 */
	private List<HgSpecialNumbers> specialNumbers;

	/** 要删除的黑白名单ID列表 */
	private List<Integer> cb;

	/** 启用黑白名单的类型，1为黑名单，2为白名单 */
	private Integer specialNumberType;

	/** 黑名单数量 */
	private Integer blackNum;

	/** 白名单数量 */
	private Integer whiteNum;

	/** 可设置的黑白名单最大数量 */
	private Integer maxNum;

	/** 基本分页信息Page对象 */
	private Page page;

	/** 操作结果信息 */
	private String message;

	/**
	 * 增加黑白名单
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 客户ID
		Integer customerId = user.getCustomerId();
		Integer specialNumberType = user.getSpecialNumberType();

		// 循环设置customerId
		Iterator<HgSpecialNumbers> it = specialNumbers.iterator();

		// 新HgSpecialNumbers对象列表
		List<HgSpecialNumbers> hgSpecialNumbersList = new ArrayList<HgSpecialNumbers>();
		while (it.hasNext()) {
			HgSpecialNumbers specialNumber = it.next();

			String number = specialNumber.getSpecialNumber();
			if (number != null && number.length() > 0) {
				specialNumber.setCustomerId(customerId);
				hgSpecialNumbersList.add(specialNumber);
			}

		}

		Result result = null;
		if (specialNumberType.equals(HgSpecialNumbers.BLACKLIST)) {
			result = listService.createBlackList(hgSpecialNumbersList);
		} else {
			result = listService.createWhiteList(hgSpecialNumbersList);
		}

		// 设置结果
		if (result.isSuccess()) {
			String mes = (String) result.getModel().get("message");
			if (mes == null) {
				message = getText("createBlackWhite.success1");
			} else {
				message = mes + getText("createBlackWhite.success2");
			}

		} else {
			message = result.getRemark();
		}

		return SUCCESS;
	}

	/**
	 * 显示管理黑白名单的方法
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

		// 黑白名单设置类型
		specialNumberType = user.getSpecialNumberType();

		Result result = null;
		if (specialNumberType.equals(1)) {
			// 黑名单查询
			result = listService.getBlackList(user, page);
			specialNumbers = (List<HgSpecialNumbers>) result.getModel().get(
					"blackList");
		} else {
			// 白名单查询
			result = listService.getWhiteList(user, page);
			specialNumbers = (List<HgSpecialNumbers>) result.getModel().get(
					"whiteList");
		}

		// 设置结果
		page = (Page) result.getModel().get("page");
		blackNum = (Integer) result.getModel().get("blackNum");
		whiteNum = (Integer) result.getModel().get("whiteNum");
		maxNum = (Integer) result.getModel().get("maxNum");

		return SUCCESS;
	}

	/**
	 * 设置黑白名单标识
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String set() throws Exception {
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 从session中取得黑白名单标识并进行更换
		Integer specialNumberType = user.getSpecialNumberType();
		if (specialNumberType.equals(HgSpecialNumbers.BLACKLIST)) {
			user.setSpecialNumberType(HgSpecialNumbers.WHITELIST);
		} else {
			user.setSpecialNumberType(HgSpecialNumbers.BLACKLIST);
		}

		// 更新数据库中的黑白名单标识
		Result result = listService.updateBlackWhite(user);

		if (result.isSuccess()) {
			// 更新session中的黑白名单标识
			ctx.getSession().put("user", user);

			if (specialNumberType.equals(HgSpecialNumbers.BLACKLIST)) {
				this.setMessage(getText("setWhite.success"));
			} else {
				this.setMessage(getText("setBlack.success"));
			}

		} else {
			if (specialNumberType.equals(HgSpecialNumbers.BLACKLIST)) {
				this.setMessage(getText("setWhite.success"));
			} else {
				this.setMessage(getText("setBlack.success"));
			}
		}

		return SUCCESS;
	}

	/**
	 * 删除黑白名单
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String delete() throws Exception {
		// 进行删除操作
		Result result = listService.deleteList(cb);

		if (result.isSuccess()) {
			message = getText("deleteBlackWhite.success");
		}

		return SUCCESS;

	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<HgSpecialNumbers> getSpecialNumbers() {
		return specialNumbers;
	}

	public void setSpecialNumbers(List<HgSpecialNumbers> specialNumbers) {
		this.specialNumbers = specialNumbers;
	}

	public Integer getBlackNum() {
		return blackNum;
	}

	public void setBlackNum(Integer blackNum) {
		this.blackNum = blackNum;
	}

	public Integer getWhiteNum() {
		return whiteNum;
	}

	public void setWhiteNum(Integer whiteNum) {
		this.whiteNum = whiteNum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}

	public Integer getSpecialNumberType() {
		return specialNumberType;
	}

	public void setSpecialNumberType(Integer specialNumberType) {
		this.specialNumberType = specialNumberType;
	}

	public List<Integer> getCb() {
		return cb;
	}

	public void setCb(List<Integer> cb) {
		this.cb = cb;
	}

}
