/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;


import com.juicy.signature.action.base.UserBaseAction;
import com.juicy.signature.service.result.Result;

/**
 * 为用户生成发送短信随机码
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-12 创建
 *          </p>
 */
public class SendCodeAction extends UserBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 4004986330281835158L;

	/** 用户登录账号 */
	private String loginName;

	/** json序列化返回成功与否信息 */
	private boolean success;

	/*** json序列化返回的信息 */
	private String message;

	/**
	 * 生成并发送短信随机码
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 生成并发送短信随机码
		Result result = userService.createVerfityCode(loginName);

		// 判断操作是否成功，并进行相应设置
		if (result.isSuccess()) {
			success = true;
			message = getText("sendCode.success");
		} else {
			success = false;
			message = result.getRemark();
		}

		// 返回
		return SUCCESS;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
