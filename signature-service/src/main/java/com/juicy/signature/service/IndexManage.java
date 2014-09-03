/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.List;

import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * ��ҳ����Service�ӿ�
 * 
 * @author ·����
 * @version <p>
 *          Oct 27, 2011 ����
 *          </p>
 */
public interface IndexManage {

	/**
	 * ��ʾ�
	 * 
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewActivity() throws SignatureServiceException;

	/**
	 * ȡ�����ҳ��ʾ
	 * 
	 * @param activities
	 *            �ID��List
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result cancelIndex(List<Integer> activities)
			throws SignatureServiceException;

	/**
	 * ɾ���
	 * 
	 * @param activities
	 *            �ID��List
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result deleteActivity(List<Integer> activities)
			throws SignatureServiceException;

	/**
	 * ��ҳ��ʾ����ǩ��
	 * 
	 * @param isDelete
	 *            �Ƿ�ɾ����0��ʾδɾ����1��ʾɾ��,null��ʾȫ��
	 * @param page
	 *            ��ҳ����
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewLibrary(Boolean isDelete, Page page)
			throws SignatureServiceException;

	/**
	 * ɾ������ǩ��
	 * 
	 * @param libraries
	 *            ����ǩ��ID��List
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result deleteLibrary(List<Integer> libraries)
			throws SignatureServiceException;
	
	/**
	 * ��ҳ��ʾ���Ż���(���ǩ������)
	 * 
	 * @param page ��ҳ����
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewHotTopic(Page page) throws SignatureServiceException;
	
	/**
	 * ɾ�����Ż��⣨�ӻ����������
	 * 
	 * @param hotTopics Ҫɾ�������Ż���ID��List
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result deleteHotTopic(List<Integer> hotTopics) throws SignatureServiceException;
	

	/**
	 * ��ҳ��ʾ�龰ǩ���Ƽ�
	 * 
	 * @param isDelete
	 *            �Ƿ�ɾ����0��ʾδɾ����1��ʾɾ��,null��ʾȫ��
	 * @param page
	 *            ��ҳ����
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewOriginal(Boolean isDelete, Page page)
			throws SignatureServiceException;

	/**
	 * ɾ���龰ǩ���Ƽ�(�������)
	 * 
	 * @param originals
	 *            �龰ǩ���Ƽ�ID��List
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result deleteOriginal(List<Integer> originals)
			throws SignatureServiceException;
	
	/**
	 * ��ʾ�Ƽ�ǩ����(���ǩ����ǩ��)
	 * 
	 * @param page ��ҳ����
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewLibraryRecommend(Page page) throws SignatureServiceException;
	
	/**
	 * ɾ���Ƽ�ǩ����
	 * 
	 * @param libraries ǩ����ǩ���Ƽ�ID List
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result deleteLibraryRecommend(List<Integer> libraries) throws SignatureServiceException;
	
	/**
	 * ��ҳ��ʾ�������а�(���ǩ����ǩ��)
	 * 
	 * @param page
	 *            ��ҳ����
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewRank(Page page) throws SignatureServiceException;
	
	/**
	 * ɾ�����а�(�������)
	 * 
	 * @return
	 * @throws SignatureServiceException
	 */
	public Result deleteRank(List<Integer> originals) throws SignatureServiceException;

}
