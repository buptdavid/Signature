/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.List;

import com.juicy.signature.persist.po.HgKeyWord;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * ������˹���Service
 * 
 * @author ·����
 * @version <p>
 *          Oct 27, 2011 ����
 *          </p>
 */
public interface AuditManage {

	/**
	 * ��ҳչʾ�ؼ���
	 * 
	 * @param content
	 *            ƥ������
	 * @param page
	 *            ��ҳPageʵ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewKeyWord(String content, Page page)
			throws SignatureServiceException;

	/**
	 * ��ӹؼ���
	 * 
	 * @param keyword
	 *            �ؼ��ֶ���
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result createKeyWord(HgKeyWord keyword)
			throws SignatureServiceException;

	/**
	 * ɾ���ؼ���
	 * 
	 * @param keyWords
	 *            �ؼ���List
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result deleteKeyWord(List<HgKeyWord> keyWords)
			throws SignatureServiceException;

	/**
	 * �޸Ĺؼ���
	 * 
	 * @param keyword
	 *            �ؼ���HgKeyWordʵ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result modifyKeyWord(HgKeyWord keyword)
			throws SignatureServiceException;

	/**
	 * �������״̬��ҳ��ʾԭ��ǩ��
	 * 
	 * @param auditStatus ���״̬
	 * @param page ��ҳ��Ϣ����
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewOriginal(Byte auditStatus, Page page)
			throws SignatureServiceException;

	/**
	 * ����ԭ��ǩ�������״̬
	 * 
	 * @param originalIds ԭ��ǩ��ID�б� 
	 * @param auditStatus ���״̬
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result setAuditStatus(List<Integer> originalIds,Byte auditStatus) throws SignatureServiceException;

}
