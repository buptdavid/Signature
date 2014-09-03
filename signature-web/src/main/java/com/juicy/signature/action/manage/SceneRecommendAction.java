/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.action.base.IndexManageBaseAction;
import com.juicy.signature.persist.po.Recommend;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 情景签名推荐Action
 *
 * @author 路卫杰
 * @version <p>Nov 16, 2011 创建</p>
 */
public class SceneRecommendAction extends IndexManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 分页基本信息对象 */
	private Page page;

	/** 情景签名 */
	private List<Recommend> originals;
	
	/** 要删除的情景签名ID */	
	private Integer originalId;
	
	/** 删除后的提示信息 */
	private String message;
	
	/**
	 * 删除(取消)情景签名首页显示
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		
		List<Integer> originalIds = new ArrayList<Integer>();
		originalIds.add(originalId);
		
		Result result = indexManage.deleteOriginal(originalIds);

		if(result.isSuccess()){
			this.setMessage(getText("manage.deleteScene.success"));
		}else{
			this.setMessage(getText("manage.deleteScene.fail"));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 显示精彩签名(签名盒或签名地带推荐签名)
	 * 
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception {
		// 如果Page对象为空，则new一个对象
		if (page == null) {
			page = new Page();
		}

		Result result = indexManage.viewOriginal(false, page);
		
		if(result.isSuccess()){
			originals = (List<Recommend>)result.getModel().get("originals");
			page = (Page)result.getModel().get("page");
		}

		return SUCCESS;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Recommend> getOriginals() {
		return originals;
	}

	public void setOriginals(List<Recommend> originals) {
		this.originals = originals;
	}

	public Integer getOriginalId() {
		return originalId;
	}

	public void setOriginalId(Integer originalId) {
		this.originalId = originalId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
