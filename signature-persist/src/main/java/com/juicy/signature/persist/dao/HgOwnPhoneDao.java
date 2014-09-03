/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgOwnPhone;

/**
 * HgOwnPhoneDao�ӿ�
 * 
 * @author ·����
 * @version <p>
 *          2011-7-29 ����
 *          </p>
 */
public interface HgOwnPhoneDao {

	/**
	 * ���ݱ�ʶ����������HgOwnPhoneʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�HgOwnPhoneʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��HgOwnPhoneʵ��
	 * @throws SignaturePersistException
	 */
	HgOwnPhone getById(Integer id) throws SignaturePersistException;

	/**
	 * �־û�ָ����HgOwnPhoneʵ��
	 * 
	 * @param hgOwnPhone
	 *            ��Ҫ���־û���HgOwnPhoneʵ��
	 * @return HgOwnPhoneʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(HgOwnPhone hgOwnPhone) throws SignaturePersistException;

	/**
	 * �޸�ָ����HgOwnPhoneʵ��
	 * 
	 * @param hgOwnPhone
	 *            ��Ҫ���޸ĵ�HgOwnPhoneʵ��
	 * @throws SignaturePersistException
	 */
	void update(HgOwnPhone hgOwnPhone) throws SignaturePersistException;

	/**
	 * ɾ��ָ����HgOwnPhoneʵ��
	 * 
	 * @param hgOwnPhone
	 *            ��Ҫ��ɾ����HgOwnPhoneʵ��
	 * @throws SignaturePersistException
	 */
	void delete(HgOwnPhone hgOwnPhone) throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ����ɾ��HgOwnPhoneʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����HgOwnPhoneʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * ��ѯȫ����HgOwnPhoneʵ��
	 * 
	 * @return ���ݿ���ȫ����HgOwnPhoneʵ��
	 * @throws SignaturePersistException
	 */
	List<HgOwnPhone> findAll() throws SignaturePersistException;

	/**
	 * ���ݿͻ�customerId��ѯHgOwnPhoneʵ��
	 * 
	 * @param customerId
	 *            �ͻ�Id
	 * @return HgOwnPhoneʵ��
	 * @throws SignaturePersistException
	 */
	HgOwnPhone findByCustomerId(Integer customerId) throws SignaturePersistException;

	/**
	 * �������Ų�ѯHgOwnPhoneʵ��
	 * 
	 * @param ownPhoneZone
	 *            ����
	 * @return HgOwnPhoneʵ��List
	 * @throws SignaturePersistException
	 */
	List<HgOwnPhone> findByZone(String zone) throws SignaturePersistException;

	/**
	 * ���ݺ����ѯHgOwnPhoneʵ��
	 * 
	 * @param phone
	 *            ����
	 * @return HgOwnPhoneʵ��
	 * @throws SignaturePersistException
	 */
	HgOwnPhone findByPhone(String phone) throws SignaturePersistException;
}
