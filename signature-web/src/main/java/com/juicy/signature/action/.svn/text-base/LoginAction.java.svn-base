/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import com.juicy.signature.action.base.UserBaseAction;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户登录Action，包括通过密码登录和通过短信随机码登录
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-12 创建
 *          </p>
 */
public class LoginAction extends UserBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 3111078708271521948L;

	/** 用户登录账号 */
	private String loginName;

	/** 用户登录密码 */
	private String password;

	/** 验证码 */
	private String checkCode;

	/** json序列化返回成功与否信息 */
	private boolean success;

	/*** json序列化返回的信息 */
	private String message;

	/**
	 * 通过密码进行登录
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的验证码checkCode属性
		String checkCode2 = (String) ctx.getSession().get("checkCode");

		// 验证码验证通过
		if (checkCode2.equalsIgnoreCase(checkCode)) {		
			Result result = userService.loginByPassword(loginName, password);

			// 用户名和密码验证成功
			if (result.isSuccess()) {
				this.setSuccess(true);
				this.setMessage(getText("login.success"));

				// 将用户基本信息User对象放入Session中
				User user = (User) result.getModel().get("user");
				ctx.getSession().put("user", user);
			} else {
				// 用户名和密码验证失败
				this.setSuccess(false);
				this.setMessage(getText("login.password.fail"));
			}

		} else {
			// 验证码验证未通过
			this.setSuccess(false);
			this.setMessage(getText("checkCode.fail"));
		}

		return SUCCESS;
	}

	/**
	 * 通过短信随机码进行登录
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String loginByCode() throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();

		// 获取HttpSession中的验证码checkCode属性
		String checkCode2 = (String) ctx.getSession().get("checkCode");

		// 验证码验证通过
		if (checkCode2.equalsIgnoreCase(checkCode)) {
			Result result = userService.loginByVerfityCode(loginName, password);

			// 短信随机码验证成功
			if (result.isSuccess()) {
				this.setSuccess(true);
				this.setMessage(getText("login.success"));

				// 将用户基本信息User对象放入Session中
				User user = (User) result.getModel().get("user");
				ctx.getSession().put("user", user);
				// 设置需要修改密码
				ctx.getSession().put("isPassword", true);
			} else {
				// 短信随机码验证失败
				this.setSuccess(false);
				this.setMessage(getText("login.code.fail"));
			}

		} else {
			// 验证码验证未通过
			this.setSuccess(false);
			this.setMessage(getText("checkCode.fail"));
		}

		return SUCCESS;
	}

	/**
	 * 判断是否登录，并进行相应操作
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String checkSession() throws Exception {
		// 创建ActionContext实例,并获得Session中的User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 判断是否登录
		if (user == null) {
			this.setSuccess(false);
		} else {
			this.setSuccess(true);
		}

		return SUCCESS;
	}

	/**
	 * 管理员登录
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String loginForManager() throws Exception{
		
		return SUCCESS;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
