/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgSysSpecialNumbers;

/**
 * ϵͳ�ڰ�����Dao
 *
 * @author ·����
 * @version <p>Dec 29, 2011 ����</p>
 */
public interface HgSysSpecialNumbersDao {
	
	/**
	 * ���ݱ�ʶ����������HgSysSpecialNumbersʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�HgSysSpecialNumbersʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��HgSysSpecialNumbersʵ��
	 * @throws SignaturePersistException
	 */
	HgSysSpecialNumbers getById(Integer id) throws SignaturePersistException;

	/**
	 * �־û�ָ����HgSysSpecialNumbersʵ��
	 * 
	 * @param hgSysSpecialNumbers
	 *            ��Ҫ���־û���HgSysSpecialNumbersʵ��
	 * @return HgSysSpecialNumbersʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(HgSysSpecialNumbers hgSysSpecialNumbers) throws SignaturePersistException;

	/**
	 * �޸�ָ����HgSysSpecialNumbersʵ��
	 * 
	 * @param hgSysSpecialNumbers
	 *            ��Ҫ���޸ĵ�HgSysSpecialNumbersʵ��
	 * @throws SignaturePersistException
	 */
	void update(HgSysSpecialNumbers hgSysSpecialNumbers) throws SignaturePersistException;

	/**
	 * ɾ��ָ����HgSysSpecialNumbersʵ��
	 * 
	 * @param hgSysSpecialNumbers
	 *            ��Ҫ��ɾ����HgSysSpecialNumbersʵ��
	 * @throws SignaturePersistException
	 */
	void delete(HgSysSpecialNumbers hgSysSpecialNumbers) throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ����ɾ��HgSysSpecialNumbersʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����HgSysSpecialNumbersʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * ��ѯȫ����HgSysSpecialNumbersʵ��
	 * 
	 * @return ���ݿ���ȫ����HgSysSpecialNumbersʵ��
	 * @throws SignaturePersistException
	 */
	List<HgSysSpecialNumbers> findAll() throws SignaturePersistException;
	
	/**
	 * ���ݺ����ѯHgSysSpecialNumbersʵ������
	 * 
	 * @param number
	 *            ����,�������ѯ��������null�򳤶�Ϊ0���ַ���
	 * @return HgSysSpecialNumbersʵ������
	 * @throws SignaturePersistException
	 */
	Integer findCountByNumber(String number) throws SignaturePersistException;

	/**
	 * ���ݱ����ҳ��ѯHgSysSpecialNumbersʵ��
	 * 
	 * @param number
	 *            ����,�������ѯ��������null�򳤶�Ϊ0���ַ���
	 * @param offSet
	 *            ��һ����¼����
	 * @param pageSize
	 *            ÿҳ��¼����
	 * @return HgSysSpecialNumbersʵ��List
	 * @throws SignaturePersistException
	 */
	List<HgSysSpecialNumbers> findByNumberForPage(String number, int offSet, int pageSize)
			throws SignaturePersistException;

}
