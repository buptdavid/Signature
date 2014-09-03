/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.RuleBaseAction;
import com.juicy.signature.persist.po.HgSendrule;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * ��ҳ��ʾ���Ի�ǩ��
 * 
 * @author ·����
 * @version <p>
 *          2011-8-25 ����
 *          </p>
 */
public class ListPersonalizedAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -6722537386476660704L;

	/** ��װĬ��ǩ��List */
	private List<HgSendrule> personalizes;

	/** ��ҳ��Ϣ���� */
	private Page page;
	
	/** chain���ô��ݵ�message��Ϣ */
	private String message;

	/**
	 * ��ҳ��ʾ���Ի�ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// ����ActionContextʵ��,����ȡSession��User����
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// ����״ν���������һ��Page����
		if (page == null) {
			page = new Page();
		}

		// ִ��ҵ���߼�������ѯ
		Result result = ruleService.getPersonalizedRule(user, page);

		// ���ý��
		personalizes = (List<HgSendrule>) result.getModel().get(
				"hgSendruleList");
		page = (Page) result.getModel().get("page");

		// ����
		return SUCCESS;
	}

	public List<HgSendrule> getPersonalizes() {
		return personalizes;
	}

	public void setPersonalizes(List<HgSendrule> personalizes) {
		this.personalizes = personalizes;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
