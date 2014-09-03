/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.SignatureService;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 原创情景签名Action
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-5 创建
 *          </p>
 */
public class OriginalAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1462374257409689908L;

	/** 原创情景一级分类 */
	private List<SignatureClass> firstClasses;

	/** 要查找的分类ID */
	private Integer signatureClassId;

	/** 要查找的分类名称 */
	private String className;

	/** 一级分类还是二级分类,1表示一级分类，2表示二级分类 */
	private Integer firstOrSecond;

	/** 原创情景签名 */
	private List<SignatureOriginal> originals;

	/** 原创情景签名分页信息实例 */
	private Page page;

	/**
	 * 显示所有公开的原创情景签名分类的方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		Result result = signatureService.getClassesByBasis(
				SignatureClass.ORIGINAL, SignatureService.ALL);

		if (result.isSuccess()) {
			firstClasses = (List<SignatureClass>) result.getModel().get(
					"firstClassList");

			if (firstClasses != null && signatureClassId == null && className == null) {
				
				SignatureClass class_ = firstClasses.get(0);
				if(class_ != null){
					signatureClassId = class_.getId();
					className = class_.getName();
				}
			}
		}

		return SUCCESS;
	}

	/**
	 * 根据分类显示原创情景签名的方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception {
		if (page == null) {
			page = new Page();
		}

		if(signatureClassId != null){
			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(signatureClassId);

			if (firstOrSecond != null && firstOrSecond.equals(1)) {
				signatureClass.setParentId(0);
			}else{
				signatureClass.setParentId(1);
			}

			Result result = signatureService.getOriginalByClass(signatureClass,
					SignatureOriginal.PASSAUDIT, true, page);

			if (result.isSuccess()) {
				originals = (List<SignatureOriginal>) result.getModel().get(
						"signatureOriginalList");
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

	public List<SignatureOriginal> getOriginals() {
		return originals;
	}

	public void setOriginals(List<SignatureOriginal> originals) {
		this.originals = originals;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
