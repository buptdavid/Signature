/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import com.juicy.signature.action.base.RuleBaseAction;
import com.juicy.signature.service.result.Result;

/**
 * 显示设置个性化签名，包括来源于默认签名，原创签名
 *
 * @author 路卫杰
 * @version <p>2011-8-30 创建</p>
 */
public class ViewPersonalizedAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -7850262841119500286L;
	
	/** 签名内容 */
	private String content;
	
	/** 可设置的个性化签名规则的最大数量 */
	private Integer maxPersonalizeCount;
	
	/**
	 * 显示设置个性化签名方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		Result result = ruleService.viewCreatePersonalizedRule();
		
		if(result.isSuccess()){
			maxPersonalizeCount = (Integer)result.getModel().get("maxPersonalizeCount");
		}
		return SUCCESS;		
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getMaxPersonalizeCount() {
		return maxPersonalizeCount;
	}

	public void setMaxPersonalizeCount(Integer maxPersonalizeCount) {
		this.maxPersonalizeCount = maxPersonalizeCount;
	}
	
	
	
}
