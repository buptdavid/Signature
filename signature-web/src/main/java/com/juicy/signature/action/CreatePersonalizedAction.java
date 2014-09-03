/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * 创建个性化签名,包括通过用户输入签名和通过签名盒（宝库）
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-25 创建
 *          </p>
 */
public class CreatePersonalizedAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 478981149884488687L;

	/** HgSendrule实例对象 */
	private HgSendrule sendrule;

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

	/*** json序列化返回的信息,或者是非AJAX请求返回的信息 */
	private String message;

	/** Pattern对象，利用正则表达式将手机号码中的回车换行替代为逗号 */
	private final Pattern pattern = Pattern.compile("\r\n");

	/**
	 * 通过用户自己输入的签名创建个性化签名规则
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 用户的CustomerId和loginName,进行设置
		Integer customerId = user.getCustomerId();
		sendrule.setCustomerId(customerId);

		HgDiyInfo diyInfo = new HgDiyInfo();
		// 签名内容设置customerId
		diyInfo.setCustomerId(customerId);
		// 设置签名
		diyInfo.setDiyInfoContent(content);

		// 是否来源于原创签名
		if (originalId != null) {
			SignatureOriginal original = new SignatureOriginal();
			original.setId(originalId);
			diyInfo.setOriginal(original);
		}
		
		//设置HgDiyInfo对象
		sendrule.setDiyInfo(diyInfo);

		// 将主叫手机号码中的回车换行转换为逗号
		String callingNumbers = sendrule.getCallingNumbers();
		Matcher m = pattern.matcher(callingNumbers);
		callingNumbers = m.replaceAll(",");
		sendrule.setCallingNumbers(callingNumbers);

		// 执行业务逻辑创建
		Result result = ruleService.createPersonalizedRule(sendrule);

		if (result.isSuccess()) {
			// 创建成功
			this.setMessage(getText("createPersonalized.success"));
		} else {
			// 创建失败
			this.setMessage(result.getRemark());
		}
		
		// 返回
		return SUCCESS;
	}

	/**
	 * 通过签名宝库创建个性化签名规则
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String createByLibrary() throws Exception {
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 用户的CustomerId和loginName,进行设置
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

		// 设置HgSendrule对象的相应属性
		sendrule.setCustomerId(customerId);
		sendrule.setDiyInfo(diyInfo);

		// 将主叫手机号码中的回车换行转换为逗号
		String callingNumbers = sendrule.getCallingNumbers();
		Matcher m = pattern.matcher(callingNumbers);
		callingNumbers = m.replaceAll(",");
		sendrule.setCallingNumbers(callingNumbers);

		// 执行业务逻辑创建
		Result result = ruleService.createPersonalizedRule(sendrule);

		if (result.isSuccess()) {
			// 创建成功
			this.setMessage(getText("createPersonalized.success"));
		} else {
			// 创建失败
			this.setMessage(result.getRemark());
		}

		// 返回
		return SUCCESS;
	}

	public String getLibraryContent() {
		return libraryContent;
	}

	public void setLibraryContent(String libraryContent) {
		this.libraryContent = libraryContent;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HgSendrule getSendrule() {
		return sendrule;
	}

	public void setSendrule(HgSendrule sendrule) {
		this.sendrule = sendrule;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	public Integer getOriginalId() {
		return originalId;
	}

	public void setOriginalId(Integer originalId) {
		this.originalId = originalId;
	}

}
