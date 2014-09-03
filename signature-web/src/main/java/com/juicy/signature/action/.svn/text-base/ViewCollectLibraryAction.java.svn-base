/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureCollect;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 显示用户收藏中的签名盒
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-24 创建
 *          </p>
 */
public class ViewCollectLibraryAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -6194147870269157677L;

	/** 一级分类ID */
	private Integer firstClassId;

	/** 所有签名盒（宝库）的一级分类 */
	private List<SignatureClass> firstClasses;

	/** 搜索到的用户收藏 */
	private List<SignatureCollect> collects;

	/** 签名盒名称所包含的关键字 */
	private String keyWord;

	/** 分页基本信息对象 */
	private Page page;

	/**
	 * 显示用户收藏中的签名盒方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 如果page对象为空，则new一个对象
		if (page == null) {
			page = new Page();
		}

		// 进行操作
		Result result = signatureService.getCollectLibrary(user, firstClassId,
				keyWord, page);

		// 设置返回结果
		firstClasses = (List<SignatureClass>) result.getModel().get(
				"signatureClassList");
		collects = (List<SignatureCollect>) result.getModel().get(
				"signatureCollectList");
		page = (Page) result.getModel().get("page");

		// 返回
		return SUCCESS;

	}

	public Integer getFirstClassId() {
		return firstClassId;
	}

	public void setFirstClassId(Integer firstClassId) {
		this.firstClassId = firstClassId;
	}

	public List<SignatureCollect> getCollects() {
		return collects;
	}

	public void setCollects(List<SignatureCollect> collects) {
		this.collects = collects;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public List<SignatureClass> getFirstClasses() {
		return firstClasses;
	}

	public void setFirstClasses(List<SignatureClass> firstClasses) {
		this.firstClasses = firstClasses;
	}

}
