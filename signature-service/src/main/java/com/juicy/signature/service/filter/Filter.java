/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.filter;

import java.util.List;

import com.juicy.signature.service.exception.SignatureServiceException;

/**
 * �ؼ��ֹ��˽ӿ�
 * 
 * @author ·����
 * @version <p>
 *          2011-8-10 ����
 *          </p>
 */
public interface Filter {
	/**
	 * ���content�а��������д�
	 * 
	 * @param content
	 *            Ҫ��������
	 * @return ���Ľ����������򷵻ذ��������д�,������д��Զ��ŷָ������򷵻�null
	 */
	public String contain(String content);

	/**
	 * �����ڴ��е��������д�
	 * 
	 * @param keyWordList
	 *            Ҫ���ӵ����д��б�
	 * @throws SignatureServiceException 
	 */
	public void addKeyWords(List<String> keyWordList) throws SignatureServiceException;

	/**
	 * ɾ���ڴ��е�ĳ�����д�
	 * 
	 * @param keyWordList
	 *            Ҫɾ�������д��б�
	 * @throws SignatureServiceException 
	 */
	public void deleteKeyWords(List<String> keyWordList) throws SignatureServiceException;
}
