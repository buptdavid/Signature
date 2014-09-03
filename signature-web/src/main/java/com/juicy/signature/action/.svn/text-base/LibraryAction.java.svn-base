/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.Iterator;
import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.service.SignatureService;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 签名盒（宝库）Action
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-5 创建
 *          </p>
 */
public class LibraryAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 8599514455655066179L;

	/** 签名宝库一级分类 */
	private List<SignatureClass> firstClasses;

	/** 要查找的分类ID */
	private Integer signatureClassId;

	/** 要查找的分类名称 */
	private String className;

	/** 一级分类还是二级分类,1表示一级分类，2表示二级分类 */
	private Integer firstOrSecond;

	/** 签名宝库签名 */
	private List<SignatureLibrary> librarys;

	/** 原创情景签名分页信息实例 */
	private Page page;

	/**
	 * 显示所有签名宝库签名的方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		Result result = signatureService.getClassesByBasis(
				SignatureClass.LIBRARY, SignatureService.ALL);

		if (result.isSuccess()) {
			firstClasses = (List<SignatureClass>) result.getModel().get(
					"firstClassList");
		}

		if (page == null) {
			page = new Page();
		}

		if (firstClasses != null) {
			Iterator<SignatureClass> it = firstClasses.iterator();
			if (it.hasNext()) {
				signatureClassId = it.next().getId();
				className = it.next().getName();
			}
		}

		return SUCCESS;
	}

	/**
	 * 根据分类显示签名宝库签名的方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception {
		if (page == null) {
			page = new Page();
		}

		if (signatureClassId != null) {
			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(signatureClassId);

			// 如果firstOrSecond为空或者等于1，则设置一级分类
			if (firstOrSecond == null || firstOrSecond.equals(1)) {
				signatureClass.setParentId(0);
			} else {
				signatureClass.setParentId(1);
			}

			Result result = signatureService.getLibrary(signatureClass, null,
					page);

			if (result.isSuccess()) {
				librarys = (List<SignatureLibrary>) result.getModel().get(
						"signatureLibraryList");
				page = (Page) result.getModel().get("page");
			}
		}

		return SUCCESS;
	}

	public List<SignatureClass> getFirstClasses() {
		return firstClasses;
	}

	public void setFirstClasses(List<SignatureClass> firstClasses) {
		this.firstClasses = firstClasses;
	}

	public Integer getSignatureClassId() {
		return signatureClassId;
	}

	public void setSignatureClassId(Integer signatureClassId) {
		this.signatureClassId = signatureClassId;
	}

	public Integer getFirstOrSecond() {
		return firstOrSecond;
	}

	public void setFirstOrSecond(Integer firstOrSecond) {
		this.firstOrSecond = firstOrSecond;
	}

	public List<SignatureLibrary> getLibrarys() {
		return librarys;
	}

	public void setLibrarys(List<SignatureLibrary> librarys) {
		this.librarys = librarys;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
