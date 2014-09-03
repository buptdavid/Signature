/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.persist.dao.SignatureCollectDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.SignatureCollect;

/**
 * SignatureCollectDao接口实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-28 创建
 *          </p>
 *          <p>
 *          2011-08-03 增加分页查询的功能
 *          </p>
 */
public class SignatureCollectDaoImpl extends JuicyHibernateDaoSupport implements
		SignatureCollectDao {

	public SignatureCollect getById(Integer id)
			throws SignaturePersistException {
		return (SignatureCollect) getHibernateTemplate().get(
				SignatureCollect.class, id);
	}

	public synchronized Integer save(SignatureCollect signatureCollect)
			throws SignaturePersistException {
		Integer id = super.getMaxId(SignatureCollect.class.getName());
		signatureCollect.setId(++id);

		return (Integer) getHibernateTemplate().save(signatureCollect);
	}

	public void update(SignatureCollect signatureCollect)
			throws SignaturePersistException {
		getHibernateTemplate().update(signatureCollect);
	}

	public void delete(SignatureCollect signatureCollect)
			throws SignaturePersistException {
		getHibernateTemplate().delete(signatureCollect);
	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));
	}

	public List<SignatureCollect> findAll() throws SignaturePersistException {
		return (List<SignatureCollect>) getHibernateTemplate().find(
				"from SignatureCollect");
	}

	public Integer findCountByCustomerIdAndClassId(Integer customerId,
			Integer classId) throws SignaturePersistException {
		// customerId不能为null
		if (customerId == null) {
			return 0;
		}

		String sql = "select count(*) from SignatureCollect where customer_id = ?";

		if (classId == null) {
			return super.getCount(sql, customerId);
		} else {
			sql += " and class_id = ?";
			Object[] values = { customerId, classId };
			return super.getCount(sql, values);
		}

	}

	public List<SignatureCollect> findByCustomerIdAndClassIdForPage(
			Integer customerId, Integer classId, int offSet, int pageSize)
			throws SignaturePersistException {
		// customerId不能为null
		if (customerId == null) {
			return new ArrayList<SignatureCollect>();
		}

		String sql = "from SignatureCollect where customer_id = ?";

		if (classId == null) {
			sql += " order by id desc";
			return super.findByPage(sql, customerId, offSet, pageSize);
		} else {
			sql += " and class_id = ? order by id desc";
			Object[] values = { customerId, classId };

			return super.findByPage(sql, values, offSet, pageSize);
		}
	}

	public List<SignatureCollect> findLibraryByCustomerId(Integer customerId)
			throws SignaturePersistException {
		return (List<SignatureCollect>) getHibernateTemplate()
				.find("from SignatureCollect where library_id != null and customer_id = ?",
						customerId);

	}

	public Integer findLibraryCountByCustomerId(Integer customerId)
			throws SignaturePersistException {
		// customerId不能为空
		if (customerId == null) {
			return 0;
		}
		String sql = "select count(*) from SignatureCollect where library_id != null and customer_id = ?";

		return super.getCount(sql, customerId);
	}

	public List<SignatureCollect> findLibraryByCustomerIdForPage(
			Integer customerId, int offSet, int pageSize)
			throws SignaturePersistException {
		// customerId不能为空
		if (customerId == null) {
			return new ArrayList<SignatureCollect>();
		}

		String sql = "from SignatureCollect where library_id != null and customer_id = ?";

		return super.findByPage(sql, customerId, offSet, pageSize);
	}

	public Integer findLibraryCountByCustomerIdAndParent(Integer customerId,
			Integer parentId, String keyWord)
			throws SignaturePersistException {
		// customerId不能为空
		if (customerId == null) {
			return 0;
		}

		List<Object> objectList = new ArrayList<Object>();
		objectList.add(customerId);

		String sql = "select count(distinct class_id) from SignatureCollect where library_id != null and customer_id = ?";
		if (parentId != null) {
			sql += " and parent_class_id = ?";
			objectList.add(parentId);
		}

		if (keyWord != null && keyWord.length() > 0) {
			sql += " and class_name like ?";
			keyWord = "%" + keyWord + "%";
			objectList.add(keyWord);
		}

		Object[] values = objectList.toArray();
		
//		if (isSignature != null) {
//			if (isSignature.equals(true)) {
//				sql += " and content != null";
//			} else {
//				sql += " and content == null";
//			}
//		}

		return super.getCount(sql, values);
	}

	public List<SignatureCollect> findLibraryByCustomerIdAndParentForPage(
			Integer customerId, Integer parentId, String keyWord,int offSet, int pageSize)
			throws SignaturePersistException {
		// customerId不能为空
		if (customerId == null) {
			return new ArrayList<SignatureCollect>();
		}

		List<Object> objectList = new ArrayList<Object>();
		objectList.add(customerId);

		String sql = "from SignatureCollect where library_id != null and customer_id = ?";
		if (parentId != null) {
			sql += " and parent_class_id = ?";
			objectList.add(parentId);
		}

		if (keyWord != null && keyWord.length() > 0) {
			sql += " and class_name like ?";
			keyWord = "%" + keyWord + "%";
			objectList.add(keyWord);
		}

		Object[] values = objectList.toArray();

//		sql += " group by class_id";
		
//		if (isSignature != null) {
//			if (isSignature.equals(true)) {
//				sql += " and content != null";
//			} else {
//				sql += " and content == null";
//			}
//		}

		// 返回
		return super.findByHql(sql, values);
	}

	public List<SignatureCollect> findOriginalByCustomerId(Integer customerId)
			throws SignaturePersistException {
		return (List<SignatureCollect>) getHibernateTemplate()
				.find("from SignatureCollect where original_id != null and customer_id = ?",
						customerId);
	}

	public Integer findOriginalCountByCustomerId(Integer customerId)
			throws SignaturePersistException {
		// customerId不能为空
		if (customerId == null) {
			return 0;
		}

		String sql = "select count(id) from SignatureCollect where original_id != null and customer_id = ?";

		return super.getCount(sql, customerId);
	}

	public List<SignatureCollect> findOriginalByCustomerIdForPage(
			Integer customerId, int offSet, int pageSize)
			throws SignaturePersistException {
		// customerId不能为空
		if (customerId == null) {
			return new ArrayList<SignatureCollect>();
		}

		String sql = "from SignatureCollect where original_id != null and customer_id = ?";

		return super.findByPage(sql, customerId, offSet, pageSize);
	}

}
