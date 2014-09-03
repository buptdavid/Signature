/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action.base;

import com.juicy.signature.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �û�����Action
 * 
 * @author ·����
 * @version <p>
 *          2011-8-12 ����
 *          </p>
 */
public class UserBaseAction extends ActionSupport {
	/** serialVersionUID */
	private static final long serialVersionUID = -2387492906412804386L;

	/** ע��UserService���� */
	protected UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
