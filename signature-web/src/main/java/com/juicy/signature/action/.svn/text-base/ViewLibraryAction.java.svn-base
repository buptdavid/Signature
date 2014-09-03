/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 显示签名盒Action
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-22 创建
 *          </p>
 */
public class ViewLibraryAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -4601463316040807590L;

	/** 分页基本信息对象 */
	private Page page;

	/** 一级分类ID */
	private Integer firstClassId;

	/** 搜索关键字 */
	private String keyWord;

	/** 签名宝库一级分类结果 */
	private List<SignatureClass> firstClasses;

	/** 签名宝库二级分类结果 */
	private List<SignatureClass> secondClasses;

	/**
	 * 显示签名盒方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 如果Page对象为空，则new一个对象
		if (page == null) {
			page = new Page();
		}

		Result result = signatureService.getLibraryClasses(firstClassId,
				keyWord, page);

		// 对结果进行处理
		firstClasses = (List<SignatureClass>) result.getModel().get(
				"firstClassList");
		secondClasses = (List<SignatureClass>) result.getModel().get(
				"secondClassList");
		page = (Page) result.getModel().get("page");
		return SUCCESS;

	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getFirstClassId() {
		return firstClassId;
	}

	public void setFirstClassId(Integer firstClassId) {
		this.firstClassId = firstClassId;
	}

	public List<SignatureClass> getFirstClasses() {
		return firstClasses;
	}

	public void setFirstClasses(List<SignatureClass> firstClasses) {
		this.firstClasses = firstClasses;
	}

	public List<SignatureClass> getSecondClasses() {
		return secondClasses;
	}

	public void setSecondClasses(List<SignatureClass> secondClasses) {
		this.secondClasses = secondClasses;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

}
