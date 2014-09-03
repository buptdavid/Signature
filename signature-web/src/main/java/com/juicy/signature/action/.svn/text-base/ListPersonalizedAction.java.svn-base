/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
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
 * 分页显示个性化签名
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-25 创建
 *          </p>
 */
public class ListPersonalizedAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -6722537386476660704L;

	/** 封装默认签名List */
	private List<HgSendrule> personalizes;

	/** 分页信息对象 */
	private Page page;
	
	/** chain调用传递的message信息 */
	private String message;

	/**
	 * 分页显示个性化签名
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

		// 执行业务逻辑操作查询
		Result result = ruleService.getPersonalizedRule(user, page);

		// 设置结果
		personalizes = (List<HgSendrule>) result.getModel().get(
				"hgSendruleList");
		page = (Page) result.getModel().get("page");

		// 返回
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
