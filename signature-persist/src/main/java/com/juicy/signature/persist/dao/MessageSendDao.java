/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.MessageSend;

/**
 * MessageSendDao�ӿ�
 *
 * @author ·����
 * @version <p>Nov 25, 2011 ����</p>
 */
public interface MessageSendDao {
	
	/**
	 * ���ݱ�ʶ����������MessageSendʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�MessageSendʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��MessageSendʵ��
	 * @throws SignaturePersistException
	 */
	MessageSend getById(Integer id) throws SignaturePersistException;

	/**
	 * �־û�ָ����MessageSendʵ��
	 * 
	 * @param messageSend
	 *            ��Ҫ���־û���MessageSendʵ��
	 * @return messageSend ʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(MessageSend messageSend) throws SignaturePersistException;

	/**
	 * �޸�ָ����MessageSendʵ��
	 * 
	 * @param messageSend
	 *            ��Ҫ���޸ĵ�MessageSendʵ��
	 * @throws SignaturePersistException
	 */
	void update(MessageSend messageSend) throws SignaturePersistException;

	/**
	 * ɾ��ָ����MessageSendʵ��
	 * 
	 * @param messageSend
	 *            ��Ҫ��ɾ����MessageSendʵ��
	 * @throws SignaturePersistException
	 */
	void delete(MessageSend messageSend) throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ����ɾ��MessageSendʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����MessageSendʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;
	
	/**
	 * ��ѯ���ݿ���MessageSendʵ��
	 * 
	 * @return ���ݿ��е�MessageSendʵ��
	 * @throws SignaturePersistException
	 */
	MessageSend findMessageSend() throws SignaturePersistException;
	
}
