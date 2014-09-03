/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.util.List;

import com.juicy.signature.action.base.SignatureManageBaseAction;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.service.result.Result;

/**
 * 签名分类管理Action
 * 
 * @author 路卫杰
 * @version <p>
 *          Nov 17, 2011 创建
 *          </p>
 */
public class ClassManageAction extends SignatureManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 签名分类对象List */
	private List<SignatureClass> signatureClasses;

	/** 分类依据 */
	private Byte basis;

	/** 要处理的类的ID */
	private Integer classId;

	/** 要处理的类的父类ID */
	private Integer parentId;

	/** 要显示二级分类的一级分类的名称 */
	private String className;

	/** 处理后的消息 */
	private String message;
	
	/** 分类级别 */
	private Integer classType;

	/**
	 * 更新分类(暂时无用)
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {

		return SUCCESS;
	}

	/**
	 * 显示一级分类
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String viewFirst() throws Exception {
		Result result = null;
		if (SignatureClass.ORIGINAL.equals(basis)) {
			result = originalManage.viewClass();
		} else {
			result = libraryManage.viewClass();
		}

		if (result.isSuccess()) {
			signatureClasses = (List<SignatureClass>) result.getModel().get(
					"firstClassList");
		}

		return SUCCESS;
	}

	/**
	 * 显示二级分类
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String viewSecond() throws Exception {
		Result result = null;
		if (SignatureClass.ORIGINAL.equals(basis)) {
			result = originalManage.viewSceondClass(classId);
		} else {
			result = libraryManage.viewSceondClass(classId);
		}

		if (result.isSuccess()) {
			signatureClasses = (List<SignatureClass>) result.getModel().get(
					"secondClassList");
		}

		return SUCCESS;
	}

	/**
	 * 删除分类
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String delete() throws Exception {
		SignatureClass deleteClass = new SignatureClass();
		deleteClass.setId(classId);
		deleteClass.setParentId(parentId);

		Result result = null;
		if (SignatureClass.ORIGINAL.equals(basis)) {
			result = originalManage.deleteClass(deleteClass);
		} else {
			result = libraryManage.deleteClass(deleteClass);
		}

		if (result.isSuccess()) {
			this.setMessage(getText("manage.deleteClass.success"));
		} else {
			// 失败原因
			this.setMessage(result.getRemark());
		}

		return SUCCESS;
	}

	/**
	 * 显示添加分类
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewAdd() throws Exception {
		Result result = null;

		if (SignatureClass.ORIGINAL.equals(basis)) {
			result = originalManage.viewClass();
		} else {
			result = libraryManage.viewClass();
		}
		
		if(result.isSuccess()){
			signatureClasses = (List<SignatureClass>)result.getModel().get("firstClassList");
		}
		
		return SUCCESS;
	}
	
	/**
	 * 保存分类
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		SignatureClass addClass = new SignatureClass();
		
		if(classType.equals(0)){
			//添加一级分类
			addClass.setParentId(0);
		}else{
			//添加二级分类
			addClass.setParentId(parentId);
		}
		
		addClass.setBasis(basis);
		addClass.setName(className);
		
		Result result = null;
		if(SignatureClass.ORIGINAL.equals(basis)){
			result = originalManage.createClass(addClass);
		}else{
			result = libraryManage.createClass(addClass);
		}
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.addClass.success"));
		}else{
			this.setMessage(result.getRemark());
		}
		
		return SUCCESS;
	}
	
	/**
	 * 显示更新分类
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewUpdate() throws Exception {
		Result result = null;

		if (SignatureClass.ORIGINAL.equals(basis)) {
			result = originalManage.viewClass();
		} else {
			result = libraryManage.viewClass();
		}
		
		if(result.isSuccess()){
			signatureClasses = (List<SignatureClass>)result.getModel().get("firstClassList");
		}

		return SUCCESS;
	}
	
	/**
	 * 更新分类
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String update() throws Exception{
		SignatureClass updateClass = new SignatureClass();
		
		if(classType.equals(0)){
			//更新一级分类
			updateClass.setParentId(0);
		}else{
			//更新二级分类
			updateClass.setParentId(parentId);
		}
		
		updateClass.setId(classId);
		updateClass.setBasis(basis);
		updateClass.setName(className);
		
		Result result = null;
		if(SignatureClass.ORIGINAL.equals(basis)){
			result = originalManage.modifyClass(updateClass);
		}else{
			result = libraryManage.modifyClass(updateClass);
		}
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.updateClass.success"));
		}else{
			this.setMessage(getText("manage.updateClass.fail"));
		}
		
		return SUCCESS;
	}

	public List<SignatureClass> getSignatureClasses() {
		return signatureClasses;
	}

	public void setSignatureClasses(List<SignatureClass> signatureClasses) {
		this.signatureClasses = signatureClasses;
	}

	public Byte getBasis() {
		return basis;
	}

	public void setBasis(Byte basis) {
		this.basis = basis;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getClassType() {
		return classType;
	}

	public void setClassType(Integer classType) {
		this.classType = classType;
	}
	
	

}
