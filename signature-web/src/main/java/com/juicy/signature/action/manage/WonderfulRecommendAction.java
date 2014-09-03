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
 * 精彩签名推荐Action
 * 
 * @author 路卫杰
 * @version <p>
 *          Nov 16, 2011 创建
 *          </p>
 */
public class WonderfulRecommendAction extends IndexManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 2374643462854330792L;

	/** 分页基本信息对象 */
	private Page page;

	/** 精彩签名 */
	private List<Recommend> libraries;
	
	/** 要删除的精彩签名ID */
	private Integer libraryId;
	
	/** 删除后的提示信息 */
	private String message;

	/**
	 * 取消精彩签名推荐首页显示
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		
		List<Integer> libraryIds = new ArrayList<Integer>();
		libraryIds.add(libraryId);
		
		Result result = indexManage.deleteLibrary(libraryIds);
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.deleteWonderful.success"));
		}else{
			this.setMessage(getText("manage.deleteWonderful.fail"));
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

		Result result = indexManage.viewLibrary(false, page);
		
		if(result.isSuccess()){
			libraries = (List<Recommend>)result.getModel().get("libraries");
			page = (Page)result.getModel().get("page");
		}

		return SUCCESS;
	}


	public List<Recommend> getLibraries() {
		return libraries;
	}

	public void setLibraries(List<Recommend> libraries) {
		this.libraries = libraries;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
