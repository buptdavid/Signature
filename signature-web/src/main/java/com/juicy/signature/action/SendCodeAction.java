/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;


import com.juicy.signature.action.base.UserBaseAction;
import com.juicy.signature.service.result.Result;

/**
 * Ϊ�û����ɷ��Ͷ��������
 * 
 * @author ·����
 * @version <p>
 *          2011-8-12 ����
 *          </p>
 */
public class SendCodeAction extends UserBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 4004986330281835158L;

	/** �û���¼�˺� */
	private String loginName;

	/** json���л����سɹ������Ϣ */
	private boolean success;

	/*** json���л����ص���Ϣ */
	private String message;

	/**
	 * ���ɲ����Ͷ��������
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// ���ɲ����Ͷ��������
		Result result = userService.createVerfityCode(loginName);

		// �жϲ����Ƿ�ɹ�����������Ӧ����
		if (result.isSuccess()) {
			success = true;
			message = getText("sendCode.success");
		} else {
			success = false;
			message = result.getRemark();
		}

		// ����
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
