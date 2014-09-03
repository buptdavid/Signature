/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service;

import com.juicy.signature.persist.po.StUsers;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * �û��˺���ص�Service��������¼��ע����
 * 
 * @author ·����
 * @version <p>
 *          2011-7-29 ����
 *          </p>
 */
public interface UserService {

	/**
	 * ���������½�ķ���
	 * 
	 * @param loginName
	 *            �û���
	 * @param password
	 *            ����
	 * @return Resultʵ������
	 */
	public Result loginByPassword(String loginName, String password)
			throws SignatureServiceException;

	/**
	 * ���ö�����֤���½�ķ���
	 * 
	 * @param loginName
	 *            �û���
	 * @param verfityCode
	 *            ������֤��
	 * @return Resultʵ������
	 */
	public Result loginByVerfityCode(String loginName, String verfityCode)
			throws SignatureServiceException;

	/**
	 * ���ɶ�����֤��
	 * 
	 * @param loginName
	 *            �û���
	 * @return Resultʵ������
	 */
	public Result createVerfityCode(String loginName)
			throws SignatureServiceException;

	/**
	 * �޸��û���Ϣ
	 * 
	 * @param user
	 *            Ҫ�޸ĵ�StUsers����
	 * @return Resultʵ������
	 */
	public Result modifyInformation(StUsers user)
			throws SignatureServiceException;

	/**
	 * �޸��û�����
	 * 
	 * @param loginName
	 *            �û���
	 * @param newPassword
	 *            ������
	 * @return Resultʵ������
	 */
	public Result modifyPassword(String loginName, String newPassword)
			throws SignatureServiceException;

	/**
	 * ���ĺڰ�����
	 * 
	 * @param user
	 *            �û�������Ϣʵ������
	 * @param specialNumberType
	 *            �ڰ�������ʶ 1Ϊ��������2Ϊ������
	 * @return Resultʵ������
	 * @throws SignatureServiceException
	 */
	public Result modifyList(User user, Integer specialNumberType)
			throws SignatureServiceException;

	/**
	 * ����û���Ϣ
	 * 
	 * @param user
	 *            �û�������Ϣʵ������
	 * @return Resultʵ������
	 * @throws SignatureServiceException
	 */
	public Result getUser(User user) throws SignatureServiceException;

	/**
	 * ���Ŀͻ�ҵ��״̬
	 * 
	 * @param user
	 *            �û�������Ϣʵ������
	 * @param customerStat
	 *            �ͻ�ҵ��״̬
	 * @return Resultʵ������
	 * @throws SignatureServiceException
	 */
	public Result modifyBusiness(User user, Integer customerStat)
			throws SignatureServiceException;

	/**
	 * ȡ���û��Ŀͻ���Ϣ
	 * 
	 * @param user
	 *            �û�������Ϣʵ������
	 * @return Resultʵ������
	 * @throws SignatureServiceException
	 */
	public Result getCustomer(User user) throws SignatureServiceException;
	
	/**
	 * ����Ա��½
	 * 
	 * @param loginName ����Ա�˺�
	 * @param password ����Ա����
	 * @return Resultʵ������
	 * @throws SignatureServiceException
	 */
	public Result loginForManager(String loginName,String password) throws SignatureServiceException;
}
