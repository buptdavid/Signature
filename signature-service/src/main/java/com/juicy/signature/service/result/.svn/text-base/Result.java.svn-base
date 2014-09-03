/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 业务逻辑类处理结果封装类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public class Result implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -8122240145304390427L;

	/** 是否成功，true为成功，false为失败 */
	private boolean isSuccess;

	/** Map类型的结果封装对象 */
	private Map<String, Object> model = new HashMap<String,Object>();

	/** 备注，主要用于失败的原因 */
	private String remark;

	/**
	 * 默认构造方法,默认isSuccess是false
	 */
	Result() {
		this.isSuccess = false;
	}

	/**
	 * 带参数的构造方法
	 * 
	 * @param isSuccess
	 *            是否成功标志
	 */
	Result(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * 创建一个Result对象,默认isSuccess是false
	 * 
	 * @return Result对象实例
	 */
	public static Result createRestult() {
		return new Result();
	}

	/**
	 * 创建一个指定isSuccess值的Result对象
	 * 
	 * @param isSuccess
	 *            是否成功标志
	 * @return Result对象实例
	 */
	public static Result createRestult(boolean isSuccess) {
		return new Result(isSuccess);
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
