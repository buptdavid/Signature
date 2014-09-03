/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgSpecialNumbers;

/**
 * HgSpecialNumbersDao�ӿ�
 * 
 * @author ·����
 * @version <p>
 *          2011-7-29 ����
 *          </p>
 */
public interface HgSpecialNumbersDao {

	/**
	 * ���ݱ�ʶ����������HgSpecialNumbersʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�HgSpecialNumbersʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��HgSpecialNumbersʵ��
	 * @throws SignaturePersistException
	 */
	HgSpecialNumbers getById(Integer id) throws SignaturePersistException;

	/**
	 * �־û�ָ����HgSpecialNumbersʵ��
	 * 
	 * @param hgSpecialNumbers
	 *            ��Ҫ���־û���HgSpecialNumbersʵ��
	 * @return HgSpecialNumbersʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(HgSpecialNumbers hgSpecialNumbers)
			throws SignaturePersistException;

	/**
	 * �޸�ָ����HgSpecialNumbersʵ��
	 * 
	 * @param hgSpecialNumbers
	 *            ��Ҫ���޸ĵ�HgSpecialNumbersʵ��
	 * @throws SignaturePersistException
	 */
	void update(HgSpecialNumbers hgSpecialNumbers)
			throws SignaturePersistException;

	/**
	 * ɾ��ָ����HgSpecialNumbersʵ��
	 * 
	 * @param hgSpecialNumbers
	 *            ��Ҫ��ɾ����HgSpecialNumbersʵ��
	 * @throws SignaturePersistException
	 */
	void delete(HgSpecialNumbers hgSpecialNumbers)
			throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ����ɾ��HgSpecialNumbersʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����HgSpecialNumbersʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * ��ѯȫ����HgSpecialNumbersʵ��
	 * 
	 * @return ���ݿ���ȫ����HgSpecialNumbersʵ��
	 * @throws SignaturePersistException
	 */
	List<HgSpecialNumbers> findAll() throws SignaturePersistException;

	/**
	 * ���ݿͻ�Id������������Ͳ���
	 * 
	 * @param customerId
	 *            �ͻ�ID
	 * @param numberType
	 *            ������������.1:������;2:������;3:�ܽ�����
	 * @return HgSpecialNumbersʵ��List
	 */
	List<HgSpecialNumbers> findByCustomerId(Integer customerId,
			Integer numberType) throws SignaturePersistException;

	/**
	 * ���ݿͻ�Id������������Ͳ���HgSpecialNumbersʵ����������
	 * 
	 * @param customerId
	 *            �ͻ�ID
	 * @param numberType
	 *            ������������.1:������;2:������;3:�ܽ�����
	 * @return ����������HgSpecialNumbersʵ����������
	 * @throws SignaturePersistException
	 */
	Integer findCountByCustomerId(Integer customerId, Integer numberType)
			throws SignaturePersistException;

	/**
	 * ���ݿͻ�Id������������ͷ�ҳ����HgSpecialNumbersʵ������
	 * 
	 * @param customerId �ͻ�ID
	 * @param numberType �����������
	 * @param offSet ��һ����¼����
	 * @param pageSize ÿҳ��¼����
	 * @return HgSpecialNumbersʵ������List
	 * @throws SignaturePersistException
	 */
	List<HgSpecialNumbers> findByCustomerIdForPage(Integer customerId,
			Integer numberType, int offSet, int pageSize)
			throws SignaturePersistException;

	/**
	 * ����������������������Ͳ���
	 * 
	 * @param number
	 *            �������
	 * @param numberType
	 *            �����������
	 * 
	 * @return HgSpecialNumbersʵ��List
	 * @throws SignaturePersistException
	 */
	List<HgSpecialNumbers> findByNumber(String number, Integer numberType)
			throws SignaturePersistException;

	/**
	 * ����������������������Ͳ���HgSpecialNumbersʵ����������
	 * 
	 * @param number
	 *            �������
	 * @param numberType
	 *            �����������
	 * @return ����������HgSpecialNumbersʵ����������
	 * @throws SignaturePersistException
	 */
	Integer findCountByNumber(String number, Integer numberType)
			throws SignaturePersistException;

	/**
	 * ����������������������ͷ�ҳ����HgSpecialNumbersʵ��List
	 * 
	 * @param number �������
	 * @param numberType �����������
	 * @param offSet ��һ����¼����
	 * @param pageSize ÿҳ��¼����
	 * @return HgSpecialNumbersʵ��List
	 * @throws SignaturePersistException
	 */
	List<HgSpecialNumbers> findByNumberForPage(String number,
			Integer numberType, int offSet, int pageSize)
			throws SignaturePersistException;

}
