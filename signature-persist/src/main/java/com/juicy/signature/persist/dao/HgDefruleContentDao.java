/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgDefruleContent;

/**
 * HgDefruleContentDao�ӿ�
 *
 * @author ·����
 * @version <p>Dec 30, 2011 ����</p>
 */
public interface HgDefruleContentDao {
	
	/**
	 * ����Ĭ��ǩ��
	 * 
	 * @param hgDefruleContent
	 *            Ĭ��ǩ�� HgDefruleContentʵ������
	 * @return HgDefruleContentʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save( HgDefruleContent  hgDefruleContent) throws SignaturePersistException;

	/**
	 * ���Ĭ��ǩ��
	 * 
	 * @return  HgDefruleContentʵ������
	 * @throws SignaturePersistException
	 */
	 HgDefruleContent getDefruleContent() throws SignaturePersistException;

	/**
	 * ��������Ĭ��ǩ��
	 * 
	 * @param defContent Ĭ��ǩ��
	 * @throws SignaturePersistException
	 */
	void saveOrUpdate(String defContent) throws SignaturePersistException;
	
	/**
	 * ����Ĭ��ǩ��
	 * 
	 * @param hgDefruleContent HgDefruleContentʵ������
	 * @throws SignaturePersistException
	 */
	void update(HgDefruleContent  hgDefruleContent) throws SignaturePersistException;

}
