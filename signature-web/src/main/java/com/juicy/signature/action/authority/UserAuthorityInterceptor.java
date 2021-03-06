/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.authority;

import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 用户登录权限拦截器
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-12 创建
 *          </p>
 */
public class UserAuthorityInterceptor extends AbstractInterceptor {

	/** serialVersionUID */
	private static final long serialVersionUID = 2130392090033680060L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();

		// 获取Session中的User对象
		User user = (User) ctx.getSession().get("user");

		// 如果user不为空，则用户已登录，否则转向用户登录
		if (user != null) {
			return invocation.invoke();
		} else {
			return Action.LOGIN;
		}
	}

}
