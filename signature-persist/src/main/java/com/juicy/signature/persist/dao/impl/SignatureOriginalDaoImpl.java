/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.juicy.signature.persist.dao.SignatureOriginalDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.SignatureOriginal;

/**
 * SignatureOriginalDao实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-27 创建
 *          </p>
 *          <p>
 *          2011-08-03 增加分页查询的功能
 *          </p>
 */
public class SignatureOriginalDaoImpl extends JuicyHibernateDaoSupport
		implements SignatureOriginalDao {

	public SignatureOriginal getById(Integer id)
			throws SignaturePersistException {
		return (SignatureOriginal) getHibernateTemplate().get(
				SignatureOriginal.class, id);
	}

	public synchronized Integer save(SignatureOriginal signatureOriginal)
			throws SignaturePersistException {
		// 获得最大主键ID
		Integer id = super.getMaxId(SignatureOriginal.class.getName());
		signatureOriginal.setId(++id);
		
		//置推荐状态为不推荐false
		signatureOriginal.setRecommend(false);
		
		return (Integer) getHibernateTemplate().save(signatureOriginal);
	}

	public void update(SignatureOriginal signatureOriginal)
			throws SignaturePersistException {
		getHibernateTemplate().update(signatureOriginal);
	}

	public void delete(SignatureOriginal signatureOriginal)
			throws SignaturePersistException {
		// 先置HgDiyInfo中的ORIGINAL_ID为null
		Integer originalId = signatureOriginal.getId();
		String hql = "update HgDiyInfo set ORIGINAL_ID = null where ORIGINAL_ID = ?";
		super.executeUpdate(hql, originalId);

		getHibernateTemplate().delete(signatureOriginal);
	}

	public void delete(Integer id) throws SignaturePersistException {
		// 先置HgDiyInfo中的ORIGINAL_ID为null
		String hql = "update HgDiyInfo set ORIGINAL_ID = null where ORIGINAL_ID = ?";
		super.executeUpdate(hql, id);

		getHibernateTemplate().delete(this.getById(id));
	}

	public List<SignatureOriginal> findAll() throws SignaturePersistException {
		return (List<SignatureOriginal>) getHibernateTemplate().find(
				"from SignatureOriginal");
	}

	public List<SignatureOriginal> findByClassId(Integer classId,
			Boolean publish, Byte auditStatus) throws SignaturePersistException {

		String sql = "from SignatureOriginal where 1 = 1";
		
		List<Object> valueList = new ArrayList<Object>();
		if(classId != null){
			sql += " and class_id = ?";
		valueList.add(classId);
		}

		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}
		//倒序
		sql += " order by mdf_time desc";

		Object[] values = valueList.toArray();

		return (List<SignatureOriginal>) getHibernateTemplate().find(sql,
				values);
	}

	public Integer findCountByClassId(Integer classId, Boolean publish,
			Byte auditStatus) throws SignaturePersistException {
		String sql = "select count(id) from SignatureOriginal where 1 = 1";

		List<Object> valueList = new ArrayList<Object>();
		
		if(classId != null){
			sql += " and class_id = ?";
		valueList.add(classId);
		}


		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}

		Object[] values = valueList.toArray();

		return super.getCount(sql, values);
	}

	public List<SignatureOriginal> findByClassIdForPage(Integer classId,
			Boolean publish, Byte auditStatus, int offSet, int pageSize)
			throws SignaturePersistException {
		String sql = "from SignatureOriginal where 1 = 1";

		List<Object> valueList = new ArrayList<Object>();
		
		if(classId != null){
			sql += " and class_id = ?";
		valueList.add(classId);
		}


		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}

		sql += " order by mdf_time desc";
		
		Object[] values = valueList.toArray();

		return super.findByPage(sql, values, offSet, pageSize);
	}

	public List<SignatureOriginal> findByClassIdList(List<Integer> classIdList,
			Boolean publish, Byte auditStatus) throws SignaturePersistException {
		// classIdList不能为null或长度为0
		if (classIdList == null || classIdList.size() == 0) {
			return new ArrayList<SignatureOriginal>();
		}

		String sql = "from SignatureOriginal where (class_id = ?";

		List<Object> valueList = new ArrayList<Object>();
		valueList.addAll(classIdList);

		for (int i = 1; i < classIdList.size(); i++) {
			sql += " or class_id = ?";
		}

		sql += ")";

		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}

		Object[] values = valueList.toArray();

		return (List<SignatureOriginal>) getHibernateTemplate().find(sql,
				values);
	}

	public Integer findCountByClassIdList(List<Integer> classIdList,
			Boolean publish, Byte auditStatus) throws SignaturePersistException {
		// classIdList不能为null或长度为0
		if (classIdList == null || classIdList.size() == 0) {
			return 0;
		}

		String sql = "select count(id) from SignatureOriginal where (class_id = ?";

		List<Object> valueList = new ArrayList<Object>();
		valueList.addAll(classIdList);

		for (int i = 1; i < classIdList.size(); i++) {
			sql += " or class_id = ?";
		}

		sql += ")";

		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}

		Object[] values = valueList.toArray();

		return super.getCount(sql, values);
	}

	public List<SignatureOriginal> findByClassIdList(List<Integer> classIdList,
			Boolean publish, Byte auditStatus, int offSet, int pageSize)
			throws SignaturePersistException {
		// classIdList不能为null或长度为0
		if (classIdList == null || classIdList.size() == 0) {
			return new ArrayList<SignatureOriginal>();
		}

		String sql = "from SignatureOriginal where (class_id = ?";

		List<Object> valueList = new ArrayList<Object>();
		valueList.addAll(classIdList);

		for (int i = 1; i < classIdList.size(); i++) {
			sql += " or class_id = ?";
		}

		sql += ")";

		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}

		sql += " order by mdf_time desc";

		Object[] values = valueList.toArray();

		return super.findByPage(sql, values, offSet, pageSize);
	}

	public List<SignatureOriginal> findByCustomerId(Integer customerId,
			Boolean publish, Byte auditStatus, String content)
			throws SignaturePersistException {
		// customerId不能为空
		if (customerId == null) {
			return new ArrayList<SignatureOriginal>();
		}

		String sql = "from SignatureOriginal where customer_id = ?";
		List<Object> valueList = new ArrayList<Object>();
		valueList.add(customerId);

		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}

		if (content != null && content.length() > 0) {
			sql += " and content like ?";
			content = "%" + content + "%";
			valueList.add(content);
		}

		Object[] values = valueList.toArray();

		return (List<SignatureOriginal>) getHibernateTemplate().find(sql,
				values);
	}

	public Integer findCountByCustomerId(Integer customerId, Boolean publish,
			Byte auditStatus, String content) throws SignaturePersistException {
		// customerId不能为空
		if (customerId == null) {
			return 0;
		}

		String sql = "select count(id) from SignatureOriginal where customer_id = ?";
		List<Object> valueList = new ArrayList<Object>();
		valueList.add(customerId);

		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}

		if (content != null && content.length() > 0) {
			sql += " and content like ?";
			content = "%" + content + "%";
			valueList.add(content);
		}

		Object[] values = valueList.toArray();

		return super.getCount(sql, values);
	}

	public List<SignatureOriginal> findByCustomerIdForPage(Integer customerId,
			Boolean publish, Byte auditStatus, String content, int offSet,
			int pageSize) throws SignaturePersistException {
		// customerId不能为空
		if (customerId == null) {
			return new ArrayList<SignatureOriginal>();
		}

		String sql = "from SignatureOriginal where customer_id = ?";
		List<Object> valueList = new ArrayList<Object>();
		valueList.add(customerId);

		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}

		if (content != null && content.length() > 0) {
			sql += " and content like ?";
			content = "%" + content + "%";
			valueList.add(content);
		}

		sql += " order by gmt_time desc";

		Object[] values = valueList.toArray();

		return super.findByPage(sql, values, offSet, pageSize);
	}

	public List<SignatureOriginal> findByContent(String content)
			throws SignaturePersistException {
		content = "%" + content + "%";
		return (List<SignatureOriginal>) getHibernateTemplate().find(
				"from SignatureOriginal where content like ?", content);
	}

	public Integer findCountByContent(String content, Boolean publish,
			Byte auditStatus) throws SignaturePersistException {
		// content不能为空
		if (content == null || content.trim().length() == 0) {
			return 0;
		}

		String sql = "select count(id) from SignatureOriginal where content like ?";
		content = "%" + content + "%";

		List<Object> valueList = new ArrayList<Object>();
		valueList.add(content);

		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}

		Object[] values = valueList.toArray();

		return super.getCount(sql, values);
	}

	public List<SignatureOriginal> findByContentForPage(String content,
			Boolean publish, Byte auditStatus, int offSet, int pageSize)
			throws SignaturePersistException {
		// content不能为空
		if (content == null || content.trim().length() == 0) {
			return new ArrayList<SignatureOriginal>();
		}

		String sql = "from SignatureOriginal where content like ?";
		content = "%" + content + "%";

		List<Object> valueList = new ArrayList<Object>();
		valueList.add(content);

		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}

		sql += " order by gmt_time desc";

		Object[] values = valueList.toArray();

		return super.findByPage(sql, values, offSet, pageSize);
	}

	public Integer findCountForTime(Integer customerId, Date date)
			throws SignaturePersistException {
		// customerId不能为空
		if (customerId == null) {
			return 0;
		}

		String sql = "select count(id) from SignatureOriginal where customer_id = ?";

		if (date != null) {
			sql += " and gmt_time > ?";
			Object[] values = { customerId, date };
			return super.getCount(sql, values);
		} else {
			return super.getCount(sql, customerId);
		}
	}

	public List<SignatureOriginal> findNew(Boolean publish, Byte auditStatus,
			Integer count) throws SignaturePersistException {
		String sql = "from SignatureOriginal where 1 = 1";

		List<Object> valueList = new ArrayList<Object>();

		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}

		Object[] values = valueList.toArray();

		return (List<SignatureOriginal>) super.findByPage(sql, values, 0, count);

	}

	public List<SignatureOriginal> findRandom(Boolean publish,
			Byte auditStatus, Integer count) throws SignaturePersistException {
		String sql = "from SignatureOriginal where 1 = 1";

		List<Object> valueList = new ArrayList<Object>();

		if (publish != null) {
			sql += " and is_publish = ?";
			valueList.add(publish);
		}

		if (auditStatus != null) {
			sql += " and audit_status = ?";
			valueList.add(auditStatus);
		}
		
		sql += " order by newid()";

		Object[] values = valueList.toArray();

		return (List<SignatureOriginal>) super.findByPage(sql, values, 0, count);
	}

}
