/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.juicy.signature.persist.dao.HgSendruleDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgSendrule;

/**
 * HgSendruleDao实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-26 创建
 *          </p>
 *          <p>
 *          2011-08-03 增加分页查询的功能
 *          </p>
 */
public class HgSendruleDaoImpl extends JuicyHibernateDaoSupport implements
		HgSendruleDao {

	public HgSendrule getById(Integer id) throws SignaturePersistException {
		return (HgSendrule) getHibernateTemplate().get(HgSendrule.class, id);
	}

	public synchronized Integer save(HgSendrule hgSendrule) throws SignaturePersistException {
		Integer id = super.getMaxId(HgSendrule.class.getName());
		hgSendrule.setId(++id);
		return (Integer) getHibernateTemplate().save(hgSendrule);
	}

	public void update(HgSendrule hgSendrule) throws SignaturePersistException {
		getHibernateTemplate().update(hgSendrule);
	}

	public void delete(HgSendrule hgSendrule) throws SignaturePersistException {
		getHibernateTemplate().delete(hgSendrule);

	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));
	}

	public List<HgSendrule> findAll() throws SignaturePersistException {
		return (List<HgSendrule>) getHibernateTemplate()
				.find("from HgSendrule order by SENDRULE_CREATETIME desc");
	}

	public HgSendrule getDefaultByCalledNumbers(String calledNumbers)
			throws SignaturePersistException {
		List<HgSendrule> list = getHibernateTemplate().find(
				"from HgSendrule where IS_DEFAULT = 1 and CALLED_NUMBERS = ?",
				calledNumbers);
		Iterator<HgSendrule> it = list.iterator();

		HgSendrule hgSendrule = null;
		if (it.hasNext()) {
			hgSendrule = it.next();
		}

		return hgSendrule;
	}

	public List<HgSendrule> getPersonalizeByCalledNumbers(String calledNumbers)
			throws SignaturePersistException {
		List<HgSendrule> list = getHibernateTemplate().find(
				"from HgSendrule where IS_DEFAULT = 0 and CALLED_NUMBERS = ?  order by SENDRULE_CREATETIME desc",
				calledNumbers);
		return list;
	}

	public Integer getPersonalizeCountByCalledNumbers(String calledNumbers)
			throws SignaturePersistException {
		String hql = "select count(id) from HgSendrule where CALLED_NUMBERS = ?";
		return super.getCount(hql, calledNumbers);
	}

	public List<HgSendrule> getPersonalizeByCalledNumbersForPage(
			String calledNumbers, int offSet, int pageSize)
			throws SignaturePersistException {
		String hql = "from HgSendrule where IS_DEFAULT = 0 and CALLED_NUMBERS = ?  order by SENDRULE_CREATETIME desc";
		return (List<HgSendrule>) super.findByPage(hql, calledNumbers, offSet,
				pageSize);
	}

	public HgSendrule getDefaultByCustomerId(Integer customerId)
			throws SignaturePersistException {
		List<HgSendrule> list = getHibernateTemplate().find(
				"from HgSendrule where IS_DEFAULT = 1 and CUSTOMER_ID = ?",
				customerId);
		Iterator<HgSendrule> it = list.iterator();

		HgSendrule hgSendrule = null;
		if (it.hasNext()) {
			hgSendrule = it.next();
		}

		return hgSendrule;
	}

	public List<HgSendrule> getPersonalizeByCustomerId(Integer customerId)
			throws SignaturePersistException {
		List<HgSendrule> list = getHibernateTemplate().find(
				"from HgSendrule where IS_DEFAULT = 0 and CUSTOMER_ID = ?  order by SENDRULE_CREATETIME desc",
				customerId);
		return list;
	}

	public Integer getPersonalizeCountByCustomerId(Integer customerId)
			throws SignaturePersistException {
		String hql = "select count(id) from HgSendrule where IS_DEFAULT = 0 and CUSTOMER_ID = ?";
		return super.getCount(hql, customerId);
	}

	public List<HgSendrule> getPersonalizeByCustomerIdForPage(
			Integer customerId, int offSet, int pageSize)
			throws SignaturePersistException {
		String hql = "from HgSendrule where IS_DEFAULT = 0 and CUSTOMER_ID = ? order by SENDRULE_CREATETIME desc";
		return (List<HgSendrule>) super.findByPage(hql, customerId, offSet,
				pageSize);
	}

}
