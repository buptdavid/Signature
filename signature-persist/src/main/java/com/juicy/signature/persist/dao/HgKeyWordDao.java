/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgKeyWord;

/**
 * HgKeyWordDao�ӿ�
 * 
 * @author ·����
 * @version <p>
 *          2011-8-10 ����
 *          </p>
 */
public interface HgKeyWordDao {

	/**
	 * ���ݱ�ʶ����������HgKeyWordʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�HgKeyWordʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��HgKeyWordʵ��
	 * @throws SignaturePersistException
	 */
	HgKeyWord getById(Integer id) throws SignaturePersistException;

	/**
	 * �־û�ָ����HgKeyWordʵ��
	 * 
	 * @param hgKeyWord
	 *            ��Ҫ���־û���HgKeyWordʵ��
	 * @return HgKeyWordʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(HgKeyWord hgKeyWord) throws SignaturePersistException;

	/**
	 * �޸�ָ����HgKeyWordʵ��
	 * 
	 * @param hgKeyWord
	 *            ��Ҫ���޸ĵ�HgKeyWordʵ��
	 * @throws SignaturePersistException
	 */
	void update(HgKeyWord hgKeyWord) throws SignaturePersistException;

	/**
	 * ɾ��ָ����HgKeyWordʵ��
	 * 
	 * @param hgKeyWord
	 *            ��Ҫ��ɾ����HgKeyWordʵ��
	 * @throws SignaturePersistException
	 */
	void delete(HgKeyWord hgKeyWord) throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ����ɾ��HgKeyWordʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����HgKeyWordʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * ��ѯȫ����HgKeyWordʵ��
	 * 
	 * @return ���ݿ���ȫ����HgKeyWordʵ��
	 * @throws SignaturePersistException
	 */
	List<HgKeyWord> findAll() throws SignaturePersistException;

	/**
	 * ���ݹؼ��ֲ�ѯHgKeyWordʵ������
	 * 
	 * @param content
	 *            �ؼ�������
	 * @return HgKeyWordʵ������
	 * @throws SignaturePersistException
	 */
	Integer findCountByContent(String content) throws SignaturePersistException;

	/**
	 * ���ݹؼ��ַ�ҳ��ѯHgKeyWordʵ��
	 * 
	 * @param content
	 *            �ؼ�������
	 * @param offSet
	 *            ��һ����¼����
	 * @param pageSize
	 *            ÿҳ��¼����
	 * @return HgKeyWordʵ��List
	 * @throws SignaturePersistException
	 */
	List<HgKeyWord> findByContentForPage(String content, int offSet, int pageSize)
			throws SignaturePersistException;
	
	/**
	 * ��������content��ȫ��ѯHgKeyWordʵ��
	 * 
	 * @param content ����
	 * @return HgKeyWordʵ��List
	 * @throws SignaturePersistException
	 */
	List<HgKeyWord> findBycontent(String content) throws SignaturePersistException;
}
