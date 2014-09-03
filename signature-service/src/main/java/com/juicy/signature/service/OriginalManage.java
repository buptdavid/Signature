/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service;

import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * �龰ԭ��ǩ������Service�ӿ�
 * 
 * @author ·����
 * @version <p>
 *          Oct 27, 2011 ����
 *          </p>
 */
public interface OriginalManage {

	/**
	 * ��ʾ�龰ԭ��ǩ����
	 * 
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewClass() throws SignatureServiceException;
	
	/**
	 * ����һ������ID������ʾ��������
	 * 
	 * @param classId
	 * @return
	 * @throws SignatureServiceException
	 */
	public Result viewSceondClass(Integer classId) throws SignatureServiceException;

	/**
	 * �����龰ԭ��ǩ����
	 * 
	 * @param signatureClass
	 *            �龰ԭ��ǩ����ʵ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result createClass(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * ɾ���龰ԭ��ǩ����
	 * 
	 * @param signatureClass
	 *            �龰ԭ��ǩ����ʵ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result deleteClass(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * �޸��龰ԭ��ǩ����
	 * 
	 * @param signatureClass
	 *            �龰ԭ��ǩ����ʵ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result modifyClass(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * ��ҳ��ʾĳ�龰���ԭ��ǩ��
	 * 
	 * @param signatureClass
	 *            �龰ԭ��ǩ����ʵ��,���Ϊnull����������з���
	 * @param page
	 *            ��ҳʵ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewOriginal(SignatureClass signatureClass,Boolean publish,Byte auditStatus, Page page)
			throws SignatureServiceException;
	
	/**
	 * �Ƽ�ԭ��ǩ��
	 * 
	 * @param originalId ԭ��ǩ��ID
	 * @param managerId ����ԱID
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result recommendOriginal(Integer originalId,Integer managerId) throws SignatureServiceException;

}
