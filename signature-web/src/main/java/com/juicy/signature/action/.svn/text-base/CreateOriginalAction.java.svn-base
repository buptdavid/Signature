/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.SignatureService;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 创建原创签名Action,包括创建原创签名和显示创建签名
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-28 创建
 *          </p>
 */
public class CreateOriginalAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -3449231425313892498L;

	/** 要创建的原创签名 */
	private SignatureOriginal original;

	/** 原创签名的所有分类 */
	private List<SignatureClass> classes;

	/** 创建结果信息 */
	private String message;
	
	/** 每天可创建的原创签名的最大数量 */
	private Integer maxCountOriginal;

	/**
	 * 创建原创签名方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 新生成一个HgCustomer对象
		HgCustomer customer = new HgCustomer();
		customer.setId(user.getCustomerId());

		// 设置customerId
		original.setCustomer(customer);

		// 如果publish为null则置false
		if (original.isPublish() == null) {
			original.setPublish(false);
		}

		Result result = signatureService.createOriginal(original);
		if (result.isSuccess() == true) {
			this.setMessage(getText("createOriginal.success"));
		} else {
			this.setMessage(getText("createOriginal.fail") + result.getRemark());
		}

		return SUCCESS;

	}

	/**
	 * 显示创建默认签名
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception {

		// 取得所有分类
		Result result = signatureService.getClassesByBasis(
				SignatureClass.ORIGINAL, SignatureService.ALL);
		// 设置结果
		classes = (List<SignatureClass>) result.getModel()
				.get("firstClassList");
		maxCountOriginal = (Integer) result.getModel().get("maxCountOriginal");

		// 返回
		return SUCCESS;
	}

	public SignatureOriginal getOriginal() {
		return original;
	}

	public void setOriginal(SignatureOriginal original) {
		this.original = original;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<SignatureClass> getClasses() {
		return classes;
	}

	public void setClasses(List<SignatureClass> classes) {
		this.classes = classes;
	}

	public Integer getMaxCountOriginal() {
		return maxCountOriginal;
	}

	public void setMaxCountOriginal(Integer maxCountOriginal) {
		this.maxCountOriginal = maxCountOriginal;
	}
	
	

}
