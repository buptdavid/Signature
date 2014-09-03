/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.List;

import com.juicy.signature.persist.po.Suggest;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * �û�����Service�ӿ�
 * 
 * @author ·����
 * @version <p>
 *          2011-8-11 ����
 *          </p>
 */
public interface SuggestService {

	/**
	 * ����һ���û�����
	 * 
	 * @param user
	 *            �û�������Ϣ����
	 * @param suggest
	 *            Suggestʵ������
	 * @return Resultʵ������
	 * @throws SignatureServiceException
	 */
	public Result createSuggest(User user, Suggest suggest)
			throws SignatureServiceException;

	/**
	 * ɾ�����ɽ���
	 * 
	 * @param suggestList
	 *            Suggestʵ��List
	 * @return Resultʵ������
	 * @throws SignatureServiceException
	 */
	public Result deleteSuggest(List<Suggest> suggestList)
			throws SignatureServiceException;

	/**
	 * ��ҳȡ����title��صĽ���
	 * 
	 * @param title
	 *            �������
	 * @param page
	 *            ��ҳ��ϢPage����
	 * @return Resultʵ������
	 * @throws SignatureServiceException
	 */
	public Result viewSuggest(String title, Page page)
			throws SignatureServiceException;

}
