/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgComboDetail;
import com.juicy.signature.persist.po.HgFirmParameter;
import com.juicy.signature.persist.po.MessageSend;

/**
 * HgFirmParameterDao�ӿ�
 * 
 * @author ·����
 * @version <p>
 *          Nov 25, 2011 ����
 *          </p>
 */
public interface HgFirmParameterDao {

	/**
	 * ���ݱ�ʶ����������HgFirmParameterʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�HgFirmParameterʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��HgFirmParameterʵ��
	 * @throws SignaturePersistException
	 */
	HgFirmParameter getById(Integer id) throws SignaturePersistException;

	/**
	 * �־û�ָ����HgFirmParameterʵ��
	 * 
	 * @param hgFirmParameter
	 *            ��Ҫ���־û���HgFirmParameterʵ��
	 * @return hgFirmParameter ʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(HgFirmParameter hgFirmParameter)
			throws SignaturePersistException;

	/**
	 * �޸�ָ����HgFirmParameterʵ��
	 * 
	 * @param hgFirmParameter
	 *            ��Ҫ���޸ĵ�HgFirmParameterʵ��
	 * @throws SignaturePersistException
	 */
	void update(HgFirmParameter hgFirmParameter)
			throws SignaturePersistException;

	/**
	 * ɾ��ָ����HgFirmParameterʵ��
	 * 
	 * @param hgFirmParameter
	 *            ��Ҫ��ɾ����HgFirmParameterʵ��
	 * @throws SignaturePersistException
	 */
	void delete(HgFirmParameter hgFirmParameter)
			throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ����ɾ��HgFirmParameterʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����HgFirmParameterʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * ��ѯ���ݿ���HgFirmParameterʵ��
	 * 
	 * @return ���ݿ��е�HgFirmParameterʵ��
	 * @throws SignaturePersistException
	 */
	HgFirmParameter findHgFirmParameter()
			throws SignaturePersistException;

}
