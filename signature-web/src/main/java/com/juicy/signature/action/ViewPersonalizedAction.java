/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import com.juicy.signature.action.base.RuleBaseAction;
import com.juicy.signature.service.result.Result;

/**
 * ��ʾ���ø��Ի�ǩ����������Դ��Ĭ��ǩ����ԭ��ǩ��
 *
 * @author ·����
 * @version <p>2011-8-30 ����</p>
 */
public class ViewPersonalizedAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -7850262841119500286L;
	
	/** ǩ������ */
	private String content;
	
	/** �����õĸ��Ի�ǩ�������������� */
	private Integer maxPersonalizeCount;
	
	/**
	 * ��ʾ���ø��Ի�ǩ������
	 * 
	 * @return ����ַ���
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
