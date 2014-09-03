/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.message.southinter;

/**
 * 
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-9 创建
 *          </p>
 */
public interface WebControlPortType extends java.rmi.Remote {

	/**
	 * Service definition of function ns__sendsms
	 */
	public int sendsms(SmsReq req) throws java.rmi.RemoteException;

	/**
	 * Service definition of function ns__stopTask
	 */
	public int stopTask(TaskReq req) throws java.rmi.RemoteException;
}
