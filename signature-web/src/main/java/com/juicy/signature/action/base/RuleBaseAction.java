/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.base;

import com.juicy.signature.service.RuleService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户签名规则基类Action
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-12 创建
 *          </p>
 */
public class RuleBaseAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = -505610073593716350L;

	/** 注入RuleService对象 */
	protected RuleService ruleService;

	public RuleService getRuleService() {
		return ruleService;
	}

	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}

}
