/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import com.juicy.signature.action.base.UserBaseAction;
import com.juicy.signature.persist.po.StUsers;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户信息Action，包括更新用户基本信息，修改密码
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-1 创建
 *          </p>
 */
public class UserAction extends UserBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -8086007307767108635L;

	/** 用户基本信息实例 */
	private StUsers stUser;

	/** 操作结果信息 */
	private String message;

	/** 要修改的密码 */
	private String password;

	/**
	 * 更新用户信息
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 设置userId和loginName
		stUser.setId(user.getUserId());
		stUser.setLoginName(user.getLoginName());

		// 更新
		Result result = userService.modifyInformation(stUser);

		if (result.isSuccess()) {
			stUser = (StUsers) result.getModel().get("user");
			message = getText("updateUser.success");

			// 更新Session中的user
			String userNick = user.getUserNick();
			String name = stUser.getName();
			if (!userNick.equals(name)) {
				user.setUserNick(name);
				ctx.getSession().put("user", user);
			}
		}

		return SUCCESS;
	}

	/**
	 * 显示用户基本信息
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		Result result = userService.getUser(user);
		if (result.isSuccess()) {
			stUser = (StUsers) result.getModel().get("user");
		}

		return SUCCESS;
	}

	/**
	 * 修改密码
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String updatePassword() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		String loginName = user.getLoginName();

		// 更新密码
		Result result = userService.modifyPassword(loginName, password);
		if (result.isSuccess()) {
			message = getText("updatePassword.success");
			//设置无需修改密码
			ctx.getSession().remove("isPassword");
		}

		return SUCCESS;
	}

	public StUsers getStUser() {
		return stUser;
	}

	public void setStUser(StUsers stUser) {
		this.stUser = stUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
