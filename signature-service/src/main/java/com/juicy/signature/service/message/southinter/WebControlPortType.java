/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.message.southinter;

/**
 * 
 * 
 * @author ·����
 * @version <p>
 *          2011-8-9 ����
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
