/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.action.base.IndexManageBaseAction;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 签名盒推荐管理Action
 *
 * @author 路卫杰
 * @version <p>Nov 17, 2011 创建</p>
 */
public class LibraryRecommendAction extends IndexManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 签名盒推荐对象 */
	private List<SignatureLibrary> libraryRecommends;
	
	/** 分页对象 */
	private Page page;
	
	/** 要处理的签名盒推荐ID */
	private Integer recommendId;
	
	/** 处理后的消息 */
	private String message;
	
	/**
	 * 签名盒推荐处理操作
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		List<Integer> recommendIds = new ArrayList<Integer>();
		recommendIds.add(recommendId);
		
		Result result = indexManage.deleteLibraryRecommend(recommendIds);
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.deleteLibraryRecommend.success"));
		}else{
			this.setMessage(getText("manage.deleteLibraryRecommend.fail"));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 显示签名盒推荐
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception{
		if(page == null){
			page = new Page();
		}
		
		Result result = indexManage.viewLibraryRecommend(page);
		
		if(result.isSuccess()){
			libraryRecommends = (List<SignatureLibrary>)result.getModel().get("libraryList");
			page = (Page)result.getModel().get("page");
		}
		
		return SUCCESS;
	}

	public List<SignatureLibrary> getLibraryRecommends() {
		return libraryRecommends;
	}

	public void setLibraryRecommends(List<SignatureLibrary> libraryRecommends) {
		this.libraryRecommends = libraryRecommends;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}


	public Integer getRecommendId() {
		return recommendId;
	}

	public void setRecommendId(Integer recommendId) {
		this.recommendId = recommendId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
