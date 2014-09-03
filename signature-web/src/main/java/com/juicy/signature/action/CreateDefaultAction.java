/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import com.juicy.signature.action.base.RuleBaseAction;
import com.juicy.signature.persist.po.HgDiyInfo;
import com.juicy.signature.persist.po.HgSendrule;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 修改默认签名规则,包括通过用户输入签名和通过签名宝库
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-12 创建 2011-08-25 增加设置默认签名方法setDefault
 *          </p>
 */
public class CreateDefaultAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 2114968168900231334L;

	/** 用户的签名内容 */
	private String content;

	/** 签名宝库（盒）ID */
	private Integer classId;

	/** 签名宝库签名内容ID */
	private Integer libraryId;

	/** 原创签名ID */
	private Integer originalId;

	/** 签名盒中签名的内容 */
	private String libraryContent;

	/** json序列化返回成功与否信息 */
	private boolean success;

	/*** json序列化返回的信息,或者是非AJAX请求返回的信息 */
	private String message;

	/**
	 * 通过用户自己输入的签名修改默认签名规则
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 用户的CustomerId,和loginName
		Integer customerId = user.getCustomerId();

		// 生成HgDiyInfo对象
		HgDiyInfo diyInfo = new HgDiyInfo();
		diyInfo.setMessageTypeId(HgDiyInfo.FLASH);
		diyInfo.setCustomerId(customerId);
		diyInfo.setDiyInfoContent(content);
		// 是否使用标志
		diyInfo.setDiyInfoCurType(HgDiyInfo.USED);

		// 是否来源于原创签名
		if (originalId != null) {
			SignatureOriginal original = new SignatureOriginal();
			original.setId(originalId);
			diyInfo.setOriginal(original);
		}

		// 生成HgSendrule对象
		HgSendrule hgSendrule = new HgSendrule();
		hgSendrule.setCustomerId(customerId);
		hgSendrule.setDiyInfo(diyInfo);

		Result result = ruleService.modifyDefaultRule(hgSendrule);
		if (result.isSuccess()) {
			// 创建成功
			this.setMessage(getText("createDefault.success"));
		} else {
			// 创建失败
			this.setMessage(getText("createDefault.fail") + result.getRemark());
		}

		return SUCCESS;

	}

	/**
	 * 通过签名宝库修改签名规则
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String createByLibrary() throws Exception {
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 用户的CustomerId,和loginName
		Integer customerId = user.getCustomerId();

		// 签名宝库（盒）对象
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setId(classId);

		// 签名宝库SignatureLibrary对象
		SignatureLibrary library = new SignatureLibrary();
		library.setId(libraryId);
		library.setSignatureClass(signatureClass);

		// 生成用户自定义信息HgDiyInfo对象
		HgDiyInfo diyInfo = new HgDiyInfo();
		diyInfo.setCustomerId(customerId);
		diyInfo.setDiyInfoContent(libraryContent);
		diyInfo.setLibrary(library);

		// 生成HgSendrule对象
		HgSendrule hgSendrule = new HgSendrule();
		hgSendrule.setCustomerId(customerId);
		hgSendrule.setDiyInfo(diyInfo);

		Result result = ruleService.modifyDefaultRule(hgSendrule);
		if (result.isSuccess()) {
			// 创建成功
			this.setMessage(getText("createDefault.success"));
			return SUCCESS;
		} else {
			// 创建失败
			this.setMessage(getText("createDefault.fail") + result.getRemark());
			return ERROR;
		}

	}

	/**
	 * 采用AJAX方法将已有的签名设置为用户默认签名规则
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String setDefault() throws Exception {
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 用户的CustomerId,和loginName
		Integer customerId = user.getCustomerId();

		// 生成HgDiyInfo对象
		HgDiyInfo diyInfo = new HgDiyInfo();
		diyInfo.setMessageTypeId(HgDiyInfo.FLASH);
		diyInfo.setCustomerId(customerId);
		diyInfo.setDiyInfoContent(content);
		// 如果libraryID不为空，则设置library
		if (libraryId != null) {
			SignatureLibrary library = new SignatureLibrary();
			library.setId(libraryId);
			diyInfo.setLibrary(library);
		}

		// 如果originalID不为空，则设置original
		if (originalId != null) {
			SignatureOriginal original = new SignatureOriginal();
			original.setId(originalId);
			diyInfo.setOriginal(original);
		}

		// 是否使用标志
		diyInfo.setDiyInfoCurType(HgDiyInfo.USED);

		// 生成HgSendrule对象
		HgSendrule hgSendrule = new HgSendrule();
		hgSendrule.setCustomerId(customerId);
		hgSendrule.setDiyInfo(diyInfo);

		// 执行业务逻辑操作
		Result result = ruleService.modifyDefaultRule(hgSendrule);

		// 根据成功与否返回结果
		if (result.isSuccess()) {
			this.setSuccess(true);
			this.setMessage(getText("setDefault.success"));
		} else {
			this.setSuccess(false);
			this.setMessage(getText("createDefault.fail") + result.getRemark());
		}

		return SUCCESS;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryContent() {
		return libraryContent;
	}

	public void setLibraryContent(String libraryContent) {
		this.libraryContent = libraryContent;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getOriginalId() {
		return originalId;
	}

	public void setOriginalId(Integer originalId) {
		this.originalId = originalId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
