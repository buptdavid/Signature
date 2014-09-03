/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action.authority;

import java.util.Map;

import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ����û���¼�����������ڽ�δ��¼�û���¼ǰ�ķ���URL�����û�Session��
 * 
 * @author ·����
 * @version <p>
 *          2011-9-8 ����
 *          </p>
 *  @deprecated
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	/** serialVersionUID */
	private static final long serialVersionUID = -3392143981157773782L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡSession�е�User����
		User user = (User) ctx.getSession().get("user");
		
		//����û�δ��¼���򽫷���URL����session��
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
