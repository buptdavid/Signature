/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.persist.dao.SignatureClassDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.SignatureClass;

/**
 * SignatureClassDao实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-27 创建
 *          </p>
 *          <p>
 *          2011-11-24 将删除全部改为修改标志位
 *          </p>
 */
public class SignatureClassDaoImpl extends JuicyHibernateDaoSupport implements
		SignatureClassDao {

	public SignatureClass getById(Integer id) throws SignaturePersistException {
		return (SignatureClass) getHibernateTemplate().get(
				SignatureClass.class, id);
	}

	public synchronized Integer save(SignatureClass signatureClass)
			throws SignaturePersistException {
		// 获得最大主键ID
		Integer id = super.getMaxId(SignatureClass.class.getName());
		signatureClass.setId(++id);

		signatureClass.setDeleted(false);
		return (Integer) getHibernateTemplate().save(signatureClass);
	}

	public void update(SignatureClass signatureClass)
			throws SignaturePersistException {
		getHibernateTemplate().update(signatureClass);
	}

	public void delete(SignatureClass signatureClass)
			throws SignaturePersistException {
//		getHibernateTemplate().delete(signatureClass);
		//修改删除为置删除标志位
		SignatureClass signatureClass_1 = this.getById(signatureClass.getId());
		signatureClass_1.setDeleted(true);
		this.update(signatureClass_1);
	}

	public void delete(Integer id) throws SignaturePersistException {
		//getHibernateTemplate().delete(this.getById(id));
		//修改删除为置删除标志位
		SignatureClass signatureClass_1 = this.getById(id);
		signatureClass_1.setDeleted(true);
		this.update(signatureClass_1);
	}

	public List<SignatureClass> findAll() throws SignaturePersistException {
		return (List<SignatureClass>) getHibernateTemplate().find(
				"from SignatureClass where deleted = 0");
	}

	public List<SignatureClass> findAllFirstByBasis(Byte basis)
			throws SignaturePersistException {
		return (List<SignatureClass>) getHibernateTemplate().find(
				"from SignatureClass where parent_id = 0 and basis = ? and deleted = 0", basis);
	}

	public List<SignatureClass> findAllSecondByBasis(Byte basis)
			throws SignaturePersistException {
		return (List<SignatureClass>) getHibernateTemplate()
				.find("from SignatureClass where parent_id != 0 and basis = ? and deleted = 0",
						basis);
	}

	public List<SignatureClass> findSecondForFirst(Integer firstId)
			throws SignaturePersistException {
		return (List<SignatureClass>) getHibernateTemplate().find(
				"from SignatureClass where parent_id = ? and deleted = 0", firstId);
	}

	public Integer findSecondCountByFirstId(Byte basis, Integer firstClassId,
			String keyWord) throws SignaturePersistException {
		List<Object> objectList = new ArrayList<Object>();

		String sql = "select count(id) from SignatureClass where parent_id != 0 and basis = ? and deleted = 0";
		objectList.add(basis);

		// firstClassId不为空
		if (firstClassId != null) {
			sql += " and parent_id = ?";
			objectList.add(firstClassId);
		}

		// keyWord不为空
		if (keyWord != null && keyWord.length() > 0) {
			sql += " and name like ?";
			keyWord = "%" + keyWord + "%";
			objectList.add(keyWord);
		}

		Object[] values = objectList.toArray();

		return super.getCount(sql, values);
	}

	public List<SignatureClass> findSecondByFirstId(Byte basis,
			Integer firstClassId, String keyWord, Integer offSet,
			Integer pageSize) throws SignaturePersistException {
		List<Object> objectList = new ArrayList<Object>();

		String sql = "from SignatureClass where parent_id != 0 and basis = ? and deleted = 0";
		objectList.add(basis);

		// firstClassId不为空
		if (firstClassId != null) {
			sql += " and parent_id = ?";
			objectList.add(firstClassId);
		}

		// keyWord不为空
		if (keyWord != null && keyWord.length() > 0) {
			sql += " and name like ?";
			keyWord = "%" + keyWord + "%";
			objectList.add(keyWord);
		}

		Object[] values = objectList.toArray();

		return super.findByPage(sql, values, offSet, pageSize);
	}

	public List<SignatureClass> findFirstRandom(Byte basis,Integer count)
			throws SignaturePersistException {
		String sql = "from SignatureClass where parent_id = 0 and deleted = 0";
		
		if(basis != null){
			sql += " and basis = ?";
}
		
		sql += " order by newid()";
		
		return (List<SignatureClass>)super.findByPage(sql, basis, 0, count);		
		
	}

}
