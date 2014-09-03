/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Help;

/**
 * HelpDao�ӿ�
 * 
 * @author ·����
 * @version <p>
 *          2011-7-29 ����
 *          </p>
 */
public interface HelpDao {

	/**
	 * ���������Ϣ
	 * 
	 * @param help
	 *            ������ϢHelpʵ������
	 * @return Helpʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(Help help) throws SignaturePersistException;

	/**
	 * ��ð�����Ϣ
	 * 
	 * @return Helpʵ������
	 * @throws SignaturePersistException
	 */
	Help getHelp() throws SignaturePersistException;

	/**
	 * �������°�����Ϣ
	 * 
	 * @param content
	 * @throws SignaturePersistException
	 */
	void saveOrUpdate(String content) throws SignaturePersistException;

}
