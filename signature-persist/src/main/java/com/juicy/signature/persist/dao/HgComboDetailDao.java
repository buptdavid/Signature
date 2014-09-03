/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgComboDetail;

/**
 * HgComboDetailDao�ӿ�
 *
 * @author ·����
 * @version <p>Nov 25, 2011 ����</p>
 */
public interface HgComboDetailDao {
	
	/**
	 * ���ݱ�ʶ����������HgComboDetailʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�HgComboDetailʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��HgComboDetailʵ��
	 * @throws SignaturePersistException
	 */
	HgComboDetail getById(Integer id) throws SignaturePersistException;

	/**
	 * �־û�ָ����HgComboDetailʵ��
	 * 
	 * @param hgComboDetail
	 *            ��Ҫ���־û���HgComboDetailʵ��
	 * @return hgComboDetail ʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(HgComboDetail hgComboDetail) throws SignaturePersistException;

	/**
	 * �޸�ָ����HgComboDetailʵ��
	 * 
	 * @param hgComboDetail
	 *            ��Ҫ���޸ĵ�HgComboDetailʵ��
	 * @throws SignaturePersistException
	 */
	void update(HgComboDetail hgComboDetail) throws SignaturePersistException;

	/**
	 * ɾ��ָ����HgComboDetailʵ��
	 * 
	 * @param hgComboDetail
	 *            ��Ҫ��ɾ����HgComboDetailʵ��
	 * @throws SignaturePersistException
	 */
	void delete(HgComboDetail hgComboDetail) throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ����ɾ��HgComboDetailʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����HgComboDetailʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;
	
	/**
	 * ��ѯ���ݿ���HgComboDetailʵ��
	 * 
	 * @return ���ݿ��е�HgComboDetailʵ��
	 * @throws SignaturePersistException
	 */
	HgComboDetail findHgComboDetail() throws SignaturePersistException;

}
