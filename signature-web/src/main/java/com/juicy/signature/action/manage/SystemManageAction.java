/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import com.juicy.signature.action.base.SystemManageBaseAction;
import com.juicy.signature.persist.po.HgComboDetail;
import com.juicy.signature.persist.po.HgDefruleContent;
import com.juicy.signature.persist.po.HgFirmParameter;
import com.juicy.signature.persist.po.MessageSend;
import com.juicy.signature.persist.po.Portal;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * ϵͳ��������Action
 * 
 * @author ·����
 * @version <p>
 *          Nov 25, 2011 ����
 *          </p>
 */
public class SystemManageAction extends SystemManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Portal portal;

	private MessageSend messageSend;

	private HgComboDetail hgComboDetail;

	private HgFirmParameter hgFirmParameter;
	
	private HgDefruleContent defaultContent;

	/**
	 * ��ʾ�Ż�����
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {

		Result result = systemManage.viewPortalParameter();

		if (result.isSuccess()) {
			portal = (Portal) result.getModel().get("portal");
		}

		return SUCCESS;
	}

	/**
	 * �����Ż�����
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String savePortalParameter() throws Exception {
		// ���ù���ԱID
		// ����ActionContextʵ��,����Session��ȡ���û�������ϢUser����
		 ActionContext ctx = ActionContext.getContext();
		 User user = (User) ctx.getSession().get("user");
		 Integer customerId = user.getCustomerId();

		 portal.setManagerId(customerId);

		Result result = systemManage.savePortalParameter(portal);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.saveSystemParameter.success"));
		} else {
			this.setMessage(getText("manage.saveSystemParameter.fail"));
		}

		return SUCCESS;
	}

	/**
	 * ��ʾ��Ϣ���Ͳ���
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String viewMessageSend() throws Exception {

		Result result = systemManage.viewMessageSend();

		if (result.isSuccess()) {
			messageSend = (MessageSend) result.getModel().get("messageSend");
			hgComboDetail = (HgComboDetail) result.getModel().get(
					"hgComboDetail");
			hgFirmParameter = (HgFirmParameter) result.getModel().get(
					"hgFirmParameter");
		}

		return SUCCESS;
	}

	/**
	 * ������Ϣ���Ͳ���
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String saveMessageSend() throws Exception {
		// ���ù���ԱID
		// ����ActionContextʵ��,����Session��ȡ���û�������ϢUser����
		 ActionContext ctx = ActionContext.getContext();
		 User user = (User) ctx.getSession().get("user");
		 Integer customerId = user.getCustomerId();

		messageSend.setManagerId(customerId);

		Result result = systemManage.saveMessageSend(messageSend,
				hgComboDetail, hgFirmParameter);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.saveSystemParameter.success"));
		} else {
			this.setMessage(getText("manage.saveSystemParameter.fail"));
		}

		return SUCCESS;
	}
	
	/**
	 * ��ʾϵͳĬ��ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String viewDefaultContent() throws Exception{
		
		Result result = systemManage.viewDefaultContent();
		
		if(result.isSuccess()){
			defaultContent = (HgDefruleContent)result.getModel().get("defaultContent");
		}
		
		return SUCCESS;
	}
	
	/**
	 * ����ϵͳĬ��ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String saveDefaultContent() throws Exception{
		
		Result result = systemManage.saveDefaultContent(defaultContent);
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.saveDefaulContent.success"));
		}else{
			this.setMessage(getText("manage.saveDefaulContent.fail"));
		}
		
		return SUCCESS;
	}
	

	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}

	public MessageSend getMessageSend() {
		return messageSend;
	}

	public void setMessageSend(MessageSend messageSend) {
		this.messageSend = messageSend;
	}

	public HgComboDetail getHgComboDetail() {
		return hgComboDetail;
	}

	public void setHgComboDetail(HgComboDetail hgComboDetail) {
		this.hgComboDetail = hgComboDetail;
	}

	public HgFirmParameter getHgFirmParameter() {
		return hgFirmParameter;
	}

	public void setHgFirmParameter(HgFirmParameter hgFirmParameter) {
		this.hgFirmParameter = hgFirmParameter;
	}

	public HgDefruleContent getDefaultContent() {
		return defaultContent;
	}

	public void setDefaultContent(HgDefruleContent defaultContent) {
		this.defaultContent = defaultContent;
	}

}
