/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.authority;

import java.util.Map;

import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 检查用户登录拦截器，用于将未登录用户登录前的访问URL放入用户Session中
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-8 创建
 *          </p>
 *  @deprecated
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	/** serialVersionUID */
	private static final long serialVersionUID = -3392143981157773782L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取Session中的User对象
		User user = (User) ctx.getSession().get("user");
		
		//如果用户未登录，则将访问URL放入session中
		if(user == null){
			Map<String,Object> parameMap = ctx.getParameters();
			String requestUrl = (String)parameMap.get("requestUrl");
			if(requestUrl != null){
				ctx.getSession().put("requestUrl", requestUrl);
			}
			
		}
		
		return invocation.invoke();
	}

}
