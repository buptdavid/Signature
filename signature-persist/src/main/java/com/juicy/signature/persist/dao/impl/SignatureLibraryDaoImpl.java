/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.persist.dao.SignatureLibraryDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.SignatureLibrary;

/**
 * SignatureLibraryDaoʵ����
 * 
 * @author ·����
 * @version <p>
 *          2011-7-28 ����
 *          </p>
 *          <p>
 *          2011-08-03 ���ӷ�ҳ��ѯ�Ĺ���
 *          </p>
 */
public class SignatureLibraryDaoImpl extends JuicyHibernateDaoSupport implements
		SignatureLibraryDao {

	public SignatureLibrary getById(Integer id)
			throws SignaturePersistException {
		return (SignatureLibrary) getHibernateTemplate().get(
				SignatureLibrary.class, id);
	}

	public synchronized Integer save(SignatureLibrary signatureLibrary)
			throws SignaturePersistException {
		Integer id = super.getMaxId(SignatureLibrary.class.getName());
		signatureLibrary.setId(++id);

		//���Ƽ�״̬Ϊ���Ƽ�false
		signatureLibrary.setRecommend(false);

		return (Integer) getHibernateTemplate().save(signatureLibrary);
	}

	public void update(SignatureLibrary signatureLibrary)
			throws SignaturePersistException {
		getHibernateTemplate().update(signatureLibrary);
	}

	public void delete(SignatureLibrary signatureLibrary)
			throws SignaturePersistException {
		// ����HgDiyInfo�е�LIBRARY_IDΪnull
		Integer libraryId = signatureLibrary.getId();
		String hql = "update HgDiyInfo set LIBRARY_ID = null where LIBRARY_ID = ?";
		super.executeUpdate(hql, libraryId);

		getHibernateTemplate().delete(signatureLibrary);
	}

	public void delete(Integer id) throws SignaturePersistException {
		// ����HgDiyInfo�е�LIBRARY_IDΪnull
		String hql = "update HgDiyInfo set LIBRARY_ID = null where LIBRARY_ID = ?";
		super.executeUpdate(hql, id);

		getHibernateTemplate().delete(this.getById(id));
	}

	public List<SignatureLibrary> findAll() throws SignaturePersistException {
		return (List<SignatureLibrary>) getHibernateTemplate().find(
				"from SignatureLibrary");
	}

	public List<SignatureLibrary> findByClassId(Integer classId)
			throws SignaturePersistException {
		// classId������Ϊ��
		if (classId == null) {
			return new ArrayList<SignatureLibrary>();
		}

		return (List<SignatureLibrary>) getHibernateTemplate().find(
				"from SignatureLibrary where class_id = ?", classId);

	}

	public Integer findCountByClassId(Integer classId, String content)
			throws SignaturePersistException {
		String sql = "select count(id) from SignatureLibrary where 1 = 1";
		
		List<Object> valueList = new ArrayList<Object>();
		if(classId != null){
			sql += " and class_id = ?";
			valueList.add(classId);
		}

		if (content != null && content.length() != 0) {
			sql += " and content like ?";
			content = "%" + content + "%";
			valueList.add(content);
		} 

		Object[] values = valueList.toArray();
		
			return super.getCount(sql, values);
		
		}

	public List<SignatureLibrary> findByClassIdForPage(Integer classId,
			int offSet, int pageSize, String content)
			throws SignaturePersistException {
		String sql = "from SignatureLibrary where 1 = 1";
		
		List<Object> valueList = new ArrayList<Object>();
		if(classId != null){
			sql += " and class_id = ?";
			valueList.add(classId);
		}

		if (content != null && content.length() != 0) {
			sql += " and content like ?";
			content = "%" + content + "%";
			valueList.add(content);
		} 
		//����
		sql += " order by id desc";

		Object[] values = valueList.toArray();
		
		return (List<SignatureLibrary>) super.findByPage(sql, values, offSet, pageSize);
		}

	public List<SignatureLibrary> findByClassIdList(List<Integer> classIdList)
			throws SignaturePersistException {
		// classIdList�б�����ֵ
		if (classIdList == null || classIdList.size() == 0) {
			return new ArrayList<SignatureLibrary>();
		}

		String sql = "from SignatureLibrary where class_id = ?";

		for (int i = 1; i < classIdList.size(); i++) {
			sql += " or class_id = ? ";
		}

		Object[] values = classIdList.toArray();

		return (List<SignatureLibrary>) getHibernateTemplate()
				.find(sql, values);
	}

	public Integer findCountByClassIdList(List<Integer> classIdList,
			String content) throws SignaturePersistException {
		// classIdList�б�����ֵ
		if (classIdList == null || classIdList.size() == 0) {
			return 0;
		}

		String sql = "select count(id) from SignatureLibrary where ( class_id = ?";

		for (int i = 1; i < classIdList.size(); i++) {
			sql += " or class_id = ? ";
		}

		sql += " )";

		List<Object> objectList = new ArrayList<Object>();
		objectList.addAll(classIdList);

		// content�ж�
		if (content != null && content.length() != 0) {
			sql += " and content like ?";
			content = "%" + content + "%";
			objectList.add(content);
		}

		Object[] values = objectList.toArray();

		return super.getCount(sql, values);
	}

	public List<SignatureLibrary> findByClassIdListForPage(
			List<Integer> classIdList, int offSet, int pageSize, String content)
			throws SignaturePersistException {
		// classIdList�б�����ֵ
		if (classIdList == null || classIdList.size() == 0) {
			return new ArrayList<SignatureLibrary>();
		}

		String sql = "from SignatureLibrary where ( class_id = ?";

		for (int i = 1; i < classIdList.size(); i++) {
			sql += " or class_id = ? ";
		}

		sql += " )";

		List<Object> objectList = new ArrayList<Object>();
		objectList.addAll(classIdList);

		// content�ж�
		if (content != null && content.length() != 0) {
			sql += " and content like ?";
			content = "%" + content + "%";
			objectList.add(content);
		}

		sql += " order by id desc";

		Object[] values = objectList.toArray();

		return super.findByPage(sql, values, offSet, pageSize);
	}

	public Integer findCount(String content) throws SignaturePersistException {
		// content����Ϊ��
		if (content == null || content.length() == 0) {
			return 0;
		}

		String sql = "select count(id) from SignatureLibrary where content like ?";
		content = "%" + content + "%";

		return super.getCount(sql, content);
	}

	public List<SignatureLibrary> findForPage(int offSet, int pageSize,
			String content) throws SignaturePersistException {
		// content����Ϊ��
		if (content == null || content.length() == 0) {
			return new ArrayList<SignatureLibrary>();
		}

		String sql = "from SignatureLibrary where content like ?";
		content = "%" + content + "%";
		
		sql += " order by id desc";

		return super.findByPage(sql, content, offSet, pageSize);
	}

	public List<SignatureLibrary> findRandom(Integer count)
			throws SignaturePersistException {
		String sql = "from SignatureLibrary order by newid()";
		
		return (List<SignatureLibrary>)super.findByPage(sql, 0, count);
		
}
}
