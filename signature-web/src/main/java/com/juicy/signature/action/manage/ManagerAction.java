/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import com.juicy.signature.action.base.UserBaseAction;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * ����ԱAction
 * 
 * @author ·����
 * @version <p>
 *          Nov 15, 2011 ����
 *          </p>
 */
public class ManagerAction extends UserBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 7265186699066260790L;

	/** ����Ա��¼�˺� */
	private String loginName;

	/** ����Ա��¼���� */
	private String password;

	/** ��֤�� */
	private String checkCode;

	/** json���л����سɹ������Ϣ */
	private boolean success;

	/*** json���л����ص���Ϣ */
	private String message;

	/**
	 * ͨ��������е�¼
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е���֤��checkCode����
		String checkCode_2 = (String) ctx.getSession().get("checkCode");

		// ��֤����֤ͨ��
		 if (checkCode_2.equalsIgnoreCase(checkCode)) {
			Result result = userService.loginForManager(loginName, password);

			// �û�����������֤�ɹ�
			if (result.isSuccess()) {
				this.setSuccess(true);
				this.setMessage(getText("login.success"));

				// ���û�������ϢUser�������Session��
				User user = (User) result.getModel().get("user");
				ctx.getSession().put("user", user);
			} else {
				// �û�����������֤ʧ��
				this.setSuccess(false);
				this.setMessage(getText("login.password.fail"));
			}

		} else {
			// ��֤����֤δͨ��
			this.setSuccess(false);
			this.setMessage(getText("checkCode.fail"));
		}

		return SUCCESS;
	}

	/**
	 * ����Ա�˳�Action
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String logout() throws Exception {
		// Session���Ƴ�User����
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().remove("user");
		
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
