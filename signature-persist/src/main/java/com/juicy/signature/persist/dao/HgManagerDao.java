/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */
package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgManager;

/**
 * HgManagerDao�ӿ�
 *
 * @author ·����
 * @version <p>2011-7-22 ����</p>
 */
public interface HgManagerDao {
	
	/**
	 * ���ݱ�ʶ����������HgManagerʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�HgManagerʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��HgManagerʵ��
	 * @throws SignaturePersistException
	 */
	HgManager getById(Integer id) throws SignaturePersistException;
	
	/**
	 * �־û�ָ����HgManagerʵ��
	 * 
	 * @param hgManager
	 *            ��Ҫ���־û���HgManagerʵ��
	 * @return hgManagerʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(HgManager HgManager) throws SignaturePersistException;
	
	/**
	 * �޸�ָ����HgManagerʵ��
	 * 
	 * @param HgManager
	 *            ��Ҫ���޸ĵ�HgManagerʵ��
	 * @throws SignaturePersistException
	 */
	void update(HgManager hgManager) throws SignaturePersistException;

	/**
	 * ɾ��ָ����HgManagerʵ��
	 * 
	 * @param hgManager
	 *            ��Ҫ��ɾ����HgManagerʵ��
	 * @throws SignaturePersistException
	 */
	void delete(HgManager hgManager) throws SignaturePersistException;
	
	/**
	 * ���ݱ�ʶ����ɾ��HgManagerʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����HgManagerʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;
	
	/**
	 * ��ѯȫ����HgManagerʵ��
	 * 
	 * @return ���ݿ���ȫ����HgManagerʵ��
	 * @throws SignaturePersistException
	 */
	List<HgManager> findAll() throws SignaturePersistException;
	
}
