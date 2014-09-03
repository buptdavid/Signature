/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
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
 * 分页展示默认签名
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-12 创建
 *          </p>
 */
public class ListDefaultAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 4318475743916544670L;

	/** 封装默认签名List */
	private List<HgSendrule> defaultRules;

	/** 当前所用的签名 */
	private HgDiyInfo currentDiyInfo;

	/** 分页信息对象 */
	private Page page;
	
	//每天可设置的默认签名的最大值
	private Integer maxDefaultCount;

	/**
	 * 分页展示默认签名
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 如果首次进入则生成一个Page对象
		if (page == null) {
			page = new Page();
		}

		// 分页获取历史默认签名
		Result result = ruleService.getDefaultRule(user, page);

		// 历史默认签名
		defaultRules = (List<HgSendrule>) result.getModel().get(
				"defaultRuleList");
		// 当前签名
		currentDiyInfo = (HgDiyInfo) result.getModel().get("currentDiyInfo");
		maxDefaultCount = (Integer)result.getModel().get("maxDefaultCount");
		// 分页信息
		page = (Page) result.getModel().get("page");

		// 返回
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
