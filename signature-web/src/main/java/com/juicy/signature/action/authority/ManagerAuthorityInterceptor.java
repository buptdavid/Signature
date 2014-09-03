/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.authority;

import com.juicy.signature.persist.po.StUsers;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 管理员登录管理后台权限拦截器
 * 
 * @author 路卫杰
 * @version <p>
 *          Nov 9, 2011 创建
 *          </p>
 */
public class ManagerAuthorityInterceptor extends AbstractInterceptor {

	/** serialVersionUID */
	private static final long serialVersionUID = 4872372507652956725L;
	
	/** 管理员登录 */
	public static final String MANAGELOGIN = "manageLogin";

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();

		// 获取Session中的User对象
		User manager = (User) ctx.getSession().get("user");

		// 如果manager不为空且userType标志位管理员，则表明管理员已登录，否则转向管理员登录
		if (manager != null && StUsers.MANAGER == manager.getUserType()) {
			return invocation.invoke();
		} else {
			return MANAGELOGIN;
		}
	}

}
