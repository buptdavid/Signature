/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.Date;
import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Activity;

/**
 * ActivityDao�ӿ�
 * 
 * @author ·����
 * @version <p>
 *          Oct 28, 2011 ����
 *          </p>
 */
public interface ActivityDao {

	/**
	 * ���ݱ�ʶ����������Activityʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Activityʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��HgCustomerʵ��
	 * @throws SignaturePersistException
	 */
	Activity getById(Integer id) throws SignaturePersistException;

	/**
	 * �־û�ָ����Activityʵ��
	 * 
	 * @param activity
	 *            ��Ҫ���־û���Activityʵ��
	 * @return activity ʵ�����־û���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	Integer save(Activity activity) throws SignaturePersistException;

	/**
	 * �޸�ָ����Activityʵ��
	 * 
	 * @param activity
	 *            ��Ҫ���޸ĵ�Activityʵ��
	 * @throws SignaturePersistException
	 */
	void update(Activity activity) throws SignaturePersistException;

	/**
	 * ɾ��ָ����Activityʵ��
	 * 
	 * @param activity
	 *            ��Ҫ��ɾ����Activityʵ��
	 * @throws SignaturePersistException
	 */
	void delete(Activity activity) throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ����ɾ��Activityʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Activityʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * ָ����Activityʵ����ɾ����־λ
	 * 
	 * @param activity
	 *            ��Ҫ��ɾ����Activityʵ��
	 * @throws SignaturePersistException
	 */
	void deleteFlag(Activity activity) throws SignaturePersistException;

	/**
	 * ���ݱ�ʶ������Activityʵ����ɾ����־λ
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Activityʵ���ı�ʶ����ֵ
	 * @throws SignaturePersistException
	 */
	void deleteFlag(Integer id) throws SignaturePersistException;

	/**
	 * ��ѯȫ����Activityʵ��
	 * 
	 * @return ���ݿ���ȫ����Activityʵ��
	 * @throws SignaturePersistException
	 */
	List<Activity> findAll() throws SignaturePersistException;

	/**
	 * ���ݿ�ʼʱ��,����ʱ�估�Ƿ�ɾ����ѯ�ʵ������
	 * 
	 * @param startTime
	 *            ���ʼʱ��,���Ϊnull��ʾû�п�ʼʱ��
	 * @param endTime
	 *            �����ʱ�䣬���Ϊnull��ʾû�н���ʱ��
	 * @param isDelete
	 *            �Ƿ�ɾ�������Ϊnull��ʾ����
	 * @return �ʵ������
	 * @throws SignaturePersistException
	 */
	Integer findCount(Date startTime, Date endTime, Boolean isDelete)
			throws SignaturePersistException;

	/**
	 * ���ݿ�ʼʱ��,����ʱ�估�Ƿ�ɾ����ҳ��ѯSignatureCollectʵ��
	 * 
	 * @param startTime
	 *            ���ʼʱ��,���Ϊnull��ʾû�п�ʼʱ��
	 * @param endTime
	 *            �����ʱ�䣬���Ϊnull��ʾû�н���ʱ��
	 * @param isDelete
	 *            �Ƿ�ɾ�������Ϊnull��ʾ����
	 * @param offSet
	 *            ��һ����¼����
	 * @param pageSize
	 *            ÿҳ��¼����
	 * @return �ʵ��List
	 * @throws SignaturePersistException
	 */
	List<Activity> findForPage(Date startTime, Date endTime, Boolean isDelete,
			int offSet, int pageSize) throws SignaturePersistException;

	/**
	 * ȡ��չʾ����ҳ�Ļ
	 * 
	 * @param count
	 *            ȡ�õ�����
	 * @return �ʵ��List
	 * @throws SignaturePersistException
	 */
	List<Activity> findActivityByIndex(Integer count)
			throws SignaturePersistException;

	/**
	 * ���ȡ�����ɻ
	 * 
	 * @param isDelete �Ƿ�ɾ�������Ϊnull��ʾ������
	 * @param isIndex �Ƿ�չʾ��ҳ�����Ϊnull��ʾ������
	 * @param count �������
	 * @return �ʵ��List
	 * @throws SignaturePersistException
	 */
	List<Activity> findActivityRandom(Boolean isDelete, Boolean isIndex,
			Integer count) throws SignaturePersistException;

}
