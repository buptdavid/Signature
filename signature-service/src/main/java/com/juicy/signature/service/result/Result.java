/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ҵ���߼��ദ������װ��
 * 
 * @author ·����
 * @version <p>
 *          2011-7-29 ����
 *          </p>
 */
public class Result implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -8122240145304390427L;

	/** �Ƿ�ɹ���trueΪ�ɹ���falseΪʧ�� */
	private boolean isSuccess;

	/** Map���͵Ľ����װ���� */
	private Map<String, Object> model = new HashMap<String,Object>();

	/** ��ע����Ҫ����ʧ�ܵ�ԭ�� */
	private String remark;

	/**
	 * Ĭ�Ϲ��췽��,Ĭ��isSuccess��false
	 */
	Result() {
		this.isSuccess = false;
	}

	/**
	 * �������Ĺ��췽��
	 * 
	 * @param isSuccess
	 *            �Ƿ�ɹ���־
	 */
	Result(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * ����һ��Result����,Ĭ��isSuccess��false
	 * 
	 * @return Result����ʵ��
	 */
	public static Result createRestult() {
		return new Result();
	}

	/**
	 * ����һ��ָ��isSuccessֵ��Result����
	 * 
	 * @param isSuccess
	 *            �Ƿ�ɹ���־
	 * @return Result����ʵ��
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
