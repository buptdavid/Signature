/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import com.juicy.signature.action.base.UserBaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * �û��Ƴ�Action
 *
 * @author ·����
 * @version <p>2011-8-18 ����</p>
 */
public class LogoutAction extends UserBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -2757064622610087212L;
	
	/** json���л����سɹ������Ϣ */
	private boolean success; 
	
	/**
	 * �˳�����
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		//Session���Ƴ�User����
		ActionContext ctx = ActionContext.getContext();		
		ctx.getSession().remove("user");
		
		//����json���л�����
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
