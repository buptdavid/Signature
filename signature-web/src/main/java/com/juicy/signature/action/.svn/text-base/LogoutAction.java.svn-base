/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import com.juicy.signature.action.base.UserBaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户推出Action
 *
 * @author 路卫杰
 * @version <p>2011-8-18 创建</p>
 */
public class LogoutAction extends UserBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -2757064622610087212L;
	
	/** json序列化返回成功与否信息 */
	private boolean success; 
	
	/**
	 * 退出操作
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		//Session中移除User对象
		ActionContext ctx = ActionContext.getContext();		
		ctx.getSession().remove("user");
		
		//设置json序列化属性
		this.setSuccess(true);
		
		return SUCCESS;		
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	

}
