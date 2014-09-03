/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import com.juicy.signature.action.base.UserBaseAction;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * �û�ҵ��Action������ҵ����ͣ��ҵ����
 * 
 * @author ·����
 * @version <p>
 *          2011-9-2 ����
 *          </p>
 */
public class BusinessAction extends UserBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -4037721885630324824L;

	/** ��ǰ�û���ҵ��״̬ */
	private Integer customerStat;

	/** ���������Ϣ */
	private String message;

	/**
	 * ҵ����ͣ����
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// ����ActionContextʵ��,����ȡSession��User����
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// ִ����ͣ����
		Result result = userService.modifyBusiness(user,
				HgCustomer.PAUSE_ORDERED);

		if (result.isSuccess()) {
			// ����Session
			user.setCustomerStat(HgCustomer.PAUSE_ORDERED);
			ctx.getSession().put("user", user);

			message = getText("pauseBusiness.success");
		} else {
			message = getText("pauseBusiness.fail");
		}

		return SUCCESS;
	}

	/**
	 * ҵ��������������
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String restart() throws Exception {
		// ����ActionContextʵ��,����ȡSession��User����
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// ִ����ͣ����
		Result result = userService.modifyBusiness(user, HgCustomer.ORDERED);

		if (result.isSuccess()) {
			// ����Session
			user.setCustomerStat(HgCustomer.ORDERED);
			ctx.getSession().put("user", user);

			message = getText("restartBusiness.success");
		} else {
			message = getText("restartBusiness.fail");
		}

		return SUCCESS;
	}

	/**
	 * ��ʾ������ͣҵ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String view() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");
		
		Result result = userService.getCustomer(user);
		
		if(result.isSuccess()){
			HgCustomer hgCustomer = (HgCustomer)result.getModel().get("hgCustomer");
			
			customerStat = hgCustomer.getCustomerStat();
			
			//�����Session�е�customerStat��һ�£���ͬ��session�е�customerStat
			if(customerStat != null && !customerStat.equals(user.getCustomerStat())){
				user.setCustomerStat(customerStat);				
				ctx.getSession().put("user", user);
			}
			
		}

		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCustomerStat() {
		return customerStat;
	}

	public void setCustomerStat(Integer customerStat) {
		this.customerStat = customerStat;
	}

}
