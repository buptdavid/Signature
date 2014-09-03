/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.action.base.IndexManageBaseAction;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 热门话题管理Action
 *
 * @author 路卫杰
 * @version <p>Nov 17, 2011 创建</p>
 */
public class HotTopicAction extends IndexManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 热门话题 */
	private List<SignatureClass> hotTopics;
	
	/** 分页对象 */
	private Page page;
	
	/** 要处理的热门话题ID */
	private Integer hotTopicId;
	
	/** 处理后的消息 */
	private String message;

	
	/**
	 * 热门话题处理操作
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		List<Integer> hotTopicIds = new ArrayList<Integer>();
		hotTopicIds.add(hotTopicId);
		
		Result result = indexManage.deleteHotTopic(hotTopicIds);
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.deleteHotTopic.success"));
		}else{
			this.setMessage(getText("manage.deleteHotTopic.fail"));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 显示热门话题
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception{
		if(page == null){
			page = new Page();
		}
		
		Result result = indexManage.viewHotTopic(page);
		
		if(result.isSuccess()){
			hotTopics = (List<SignatureClass>)result.getModel().get("classList");
			page = (Page)result.getModel().get("page");
		}
		
		return SUCCESS;
	}
	
	public List<SignatureClass> getHotTopics() {
		return hotTopics;
	}

	public void setHotTopics(List<SignatureClass> hotTopics) {
		this.hotTopics = hotTopics;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getHotTopicId() {
		return hotTopicId;
	}

	public void setHotTopicId(Integer hotTopicId) {
		this.hotTopicId = hotTopicId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
