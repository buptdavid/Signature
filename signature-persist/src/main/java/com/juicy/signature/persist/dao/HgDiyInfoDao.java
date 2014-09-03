/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.Date;
import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgDiyInfo;

/**
 * HgDiyInfoDao�ӿ�
 * 
 * @author ·����
 * @version <p>
 *          2011-7-27 ����
 *          </p>
 *          <p>
 *          2011-08-03 ���ӷ�ҳ��ѯ�Ĺ���
 *          </p>
 *          <p>
 *          2011-10-11 ���Ӳ�ѯ�ͻ�ĳʱ����Ĭ��ǩ���Զ�����Ϣ��������findCountDefaultForTime
 *          </p>
 */
public interface HgDiyInfoDao {

	/**
	 * ���ݱ�ʶ����������HgDiyInfoʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�HgDiyInfoʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��HgDiyInfoʵ��
	 * @throws SignaturePersistException
	 */
	HgDiyInfo getById(Integer id) throws SignaturePersistException;

	/**
	 * �־û�ָ����HgDiyInfoʵ��
	 * 
	 * @param hgDiyInfo
	 *            ��Ҫ���־û���HgDiyInfoʵ��
	 * @return HgDiyInfoʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(HgDiyInfo hgDiyInfo) throws SignaturePersistException;

	/**
	 * �޸�ָ����HgDiyInfoʵ��
	 * 
	 * @param hgDiyInfo
	 *            ��Ҫ���޸ĵ�HgDiyInfoʵ��
	 * @throws SignaturePersistException
	 */
	void update(HgDiyInfo hgDiyInfo) throws SignaturePersistException;

	/**
	 * ɾ��ָ����HgDiyInfoʵ��
	 * 
	 * @param hgDiyInfo
	 *            ��Ҫ��ɾ����HgDiyInfoʵ��
	 * @throws SignaturePersistException
	 */
	void delete(HgDiyInfo hgDiyInfo) throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ����ɾ��HgDiyInfoʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����HgDiyInfoʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * ��ѯȫ����HgDiyInfoʵ��
	 * 
	 * @return ���ݿ���ȫ����HgDiyInfoʵ��
	 * @throws SignaturePersistException
	 */
	List<HgDiyInfo> findAll() throws SignaturePersistException;

	/**
	 * ���ݹ˿�ID��ѯHgDiyInfoʵ��
	 * 
	 * @param customerId
	 *            �ͻ�ID
	 * @return HgDiyInfoʵ��List
	 * @throws SignaturePersistException
	 */
	List<HgDiyInfo> findByCustomerId(Integer customerId)
			throws SignaturePersistException;

	/**
	 * ���ݿͻ�ID��ѯHgDiyInfoʵ������
	 * 
	 * @param customerId
	 *            �ͻ�ID
	 * @return HgDiyInfoʵ������
	 * @throws SignaturePersistException
	 */
	Integer findCountByCustomerId(Integer customerId)
			throws SignaturePersistException;

	/**
	 * ���ݿͻ�ID��ҳ��ѯHgDiyInfoʵ��
	 * 
	 * @param customerId
	 *            �ͻ�ID
	 * @param offSet
	 *            ��һ����¼����
	 * @param pageSize
	 *            ÿҳ��¼����
	 * @return HgDiyInfoʵ��List
	 * @throws SignaturePersistException
	 */
	List<HgDiyInfo> findByCustomerIdForPage(Integer customerId, int offSet,
			int pageSize) throws SignaturePersistException;

	/**
	 * ���ݿͻ�ID���Ƿ�Ĭ��ǩ����־��ѯHgDiyInfoʵ��
	 * 
	 * @param customerId
	 *            �ͻ�ID
	 * @param isDefault
	 *            �Ƿ�Ĭ��ǩ����0�����ǣ�1����
	 * @return HgDiyInfoʵ������
	 * @throws SignaturePersistException
	 */
	Integer findCountByCustomerId(Integer customerId, Byte isDefault)
			throws SignaturePersistException;

	/**
	 * ���ݿͻ�ID���Ƿ�Ĭ��ǩ����־��ҳ��ѯHgDiyInfoʵ��
	 * 
	 * @param customerId
	 *            �ͻ�ID
	 * @param isDefault
	 *            �Ƿ�Ĭ��ǩ����0�����ǣ�1����
	 * @param offSet
	 *            ��һ����¼����
	 * @param pageSize
	 *            ÿҳ��¼����
	 * @return HgDiyInfoʵ��List
	 * @throws SignaturePersistException
	 */
	List<HgDiyInfo> findByCustomerIdForPage(Integer customerId, Byte isDefault,
			int offSet, int pageSize) throws SignaturePersistException;
	
	/**
	 * ��ѯ�ͻ�dateʱ������Ĭ��ǩ�����Զ�����Ϣ�����������dateΪnull���ѯ�ÿͻ�����Ĭ��ǩ���Զ�����Ϣ����
	 * 
	 * @param customerId �ͻ�ID
	 * @param date ��ѯʱ���
	 * @return dateʱ������Ĭ��ǩ�����Զ�����Ϣ������
	 * @throws SignaturePersistException
	 */
	Integer findCountDefaultForTime(Integer customerId,Date date) throws SignaturePersistException;
	
	/**
	 * ��Ĭ��ǩ��ΪpreContent���޸�Ϊǩ��content
	 * 
	 * @param preContent ���޸ĵ�ǩ��
	 * @param content ��Ҫ�޸ĳɵ�ǩ��
	 * @return ���ĵļ�¼����
	 * @throws SignaturePersistException
	 */
	Integer updateContent(String preContent, String content) throws SignaturePersistException;

}
