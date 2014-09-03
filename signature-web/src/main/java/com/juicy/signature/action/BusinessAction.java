/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import com.juicy.signature.action.base.UserBaseAction;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户业务Action，包括业务暂停，业务开启
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-2 创建
 *          </p>
 */
public class BusinessAction extends UserBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -4037721885630324824L;

	/** 当前用户的业务状态 */
	private Integer customerStat;

	/** 操作结果信息 */
	private String message;

	/**
	 * 业务暂停方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 执行暂停操作
		Result result = userService.modifyBusiness(user,
				HgCustomer.PAUSE_ORDERED);

		if (result.isSuccess()) {
			// 更新Session
			user.setCustomerStat(HgCustomer.PAUSE_ORDERED);
			ctx.getSession().put("user", user);

			message = getText("pauseBusiness.success");
		} else {
			message = getText("pauseBusiness.fail");
		}

		return SUCCESS;
	}

	/**
	 * 业务重新启动方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String restart() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 执行暂停操作
		Result result = userService.modifyBusiness(user, HgCustomer.ORDERED);

		if (result.isSuccess()) {
			// 更新Session
			user.setCustomerStat(HgCustomer.ORDERED);
			ctx.getSession().put("user", user);

			message = getText("restartBusiness.success");
		} else {
			message = getText("restartBusiness.fail");
		}

		return SUCCESS;
	}

	/**
	 * 显示启动暂停业务
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");
		
		Result result = userService.getCustomer(user);
		
		if(result.isSuccess()){
			HgCustomer hgCustomer = (HgCustomer)result.getModel().get("hgCustomer");
			
			customerStat = hgCustomer.getCustomerStat();
			
			//如果和Session中的customerStat不一致，则同步session中的customerStat
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
