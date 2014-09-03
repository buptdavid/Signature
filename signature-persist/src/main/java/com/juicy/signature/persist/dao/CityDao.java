/**
 * Copyright @ 2011-2012 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.City;

/**
 * CityDao�ӿ�
 *
 * @author ·����
 * @version <p>Feb 29, 2012 ����</p>
 */
public interface CityDao {
	
	/**
	 * ���ݱ�ʶ����������Cityʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Cityʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Cityʵ��
	 * @throws SignaturePersistException
	 */
	City getById(Integer id) throws SignaturePersistException;

	/**
	 * �־û�ָ����Cityʵ��
	 * 
	 * @param city
	 *            ��Ҫ���־û���Cityʵ��
	 * @return Cityʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(City city) throws SignaturePersistException;

	/**
	 * �޸�ָ����Cityʵ��
	 * 
	 * @param city
	 *            ��Ҫ���޸ĵ�Cityʵ��
	 * @throws SignaturePersistException
	 */
	void update(City city) throws SignaturePersistException;

	/**
	 * ɾ��ָ����Cityʵ��
	 * 
	 * @param city
	 *            ��Ҫ��ɾ����Cityʵ��
	 * @throws SignaturePersistException
	 */
	void delete(City city) throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ����ɾ��Cityʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Cityʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * ��ѯȫ����Cityʵ��
	 * 
	 * @return ���ݿ���ȫ����Cityʵ��
	 * @throws SignaturePersistException
	 */
	List<City> findAll() throws SignaturePersistException;

}
