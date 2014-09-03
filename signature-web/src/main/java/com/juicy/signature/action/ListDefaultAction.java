/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.RuleBaseAction;
import com.juicy.signature.persist.po.HgDiyInfo;
import com.juicy.signature.persist.po.HgSendrule;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * ��ҳչʾĬ��ǩ��
 * 
 * @author ·����
 * @version <p>
 *          2011-8-12 ����
 *          </p>
 */
public class ListDefaultAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 4318475743916544670L;

	/** ��װĬ��ǩ��List */
	private List<HgSendrule> defaultRules;

	/** ��ǰ���õ�ǩ�� */
	private HgDiyInfo currentDiyInfo;

	/** ��ҳ��Ϣ���� */
	private Page page;
	
	//ÿ������õ�Ĭ��ǩ�������ֵ
	private Integer maxDefaultCount;

	/**
	 * ��ҳչʾĬ��ǩ��
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

		// ��ҳ��ȡ��ʷĬ��ǩ��
		Result result = ruleService.getDefaultRule(user, page);

		// ��ʷĬ��ǩ��
		defaultRules = (List<HgSendrule>) result.getModel().get(
				"defaultRuleList");
		// ��ǰǩ��
		currentDiyInfo = (HgDiyInfo) result.getModel().get("currentDiyInfo");
		maxDefaultCount = (Integer)result.getModel().get("maxDefaultCount");
		// ��ҳ��Ϣ
		page = (Page) result.getModel().get("page");

		// ����
		return SUCCESS;
	}

	public List<HgSendrule> getDefaultRules() {
		return defaultRules;
	}

	public void setDefaultRules(List<HgSendrule> defaultRules) {
		this.defaultRules = defaultRules;
	}

	public HgDiyInfo getCurrentDiyInfo() {
		return currentDiyInfo;
	}

	public void setCurrentDiyInfo(HgDiyInfo currentDiyInfo) {
		this.currentDiyInfo = currentDiyInfo;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getMaxDefaultCount() {
		return maxDefaultCount;
	}

	public void setMaxDefaultCount(Integer maxDefaultCount) {
		this.maxDefaultCount = maxDefaultCount;
	}
	
	

}
