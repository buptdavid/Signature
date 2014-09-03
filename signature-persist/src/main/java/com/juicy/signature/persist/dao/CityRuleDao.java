/**
 * Copyright @ 2011-2012 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.CityRule;

/**
 * CityRuleDao�ӿ�
 *
 * @author ·����
 * @version <p>Feb 29, 2012 ����</p>
 */
public interface CityRuleDao {
	
	/**
	 * ���ݱ�ʶ����������CityRuleʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�CityRuleʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��CityRuleʵ��
	 * @throws SignaturePersistException
	 */
	CityRule getById(Integer id) throws SignaturePersistException;

	/**
	 * �־û�ָ����CityRuleʵ��
	 * 
	 * @param cityRule
	 *            ��Ҫ���־û���CityRuleʵ��
	 * @return CityRuleʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(CityRule cityRule) throws SignaturePersistException;

	/**
	 * �޸�ָ����CityRuleʵ��
	 * 
	 * @param cityRule
	 *            ��Ҫ���޸ĵ�CityRuleʵ��
	 * @throws SignaturePersistException
	 */
	void update(CityRule cityRule) throws SignaturePersistException;

	/**
	 * ɾ��ָ����CityRuleʵ��
	 * 
	 * @param cityRule
	 *            ��Ҫ��ɾ����CityRuleʵ��
	 * @throws SignaturePersistException
	 */
	void delete(CityRule cityRule) throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ����ɾ��CityRuleʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����CityRuleʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * ��ѯȫ����CityRuleʵ��
	 * 
	 * @return ���ݿ���ȫ����CityRuleʵ��
	 * @throws SignaturePersistException
	 */
	List<CityRule> findAll() throws SignaturePersistException;
}
