/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao.impl;

import java.util.List;

import com.juicy.signature.persist.dao.HgManagerDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgManager;

/**
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-22 创建
 *          </p>
 */
public class HgManagerDaoImpl extends JuicyHibernateDaoSupport implements
		HgManagerDao {

	public HgManager getById(Integer id) throws SignaturePersistException {
		return (HgManager) getHibernateTemplate().get(HgManager.class, id);
	}

	public synchronized Integer save(HgManager hgManager) throws SignaturePersistException {
		// 获得最大的主键ID
		Integer id = super.getMaxId(HgManager.class.getName());
		hgManager.setId(++id);
		return (Integer) getHibernateTemplate().save(hgManager);
	}

	public void update(HgManager hgManager) throws SignaturePersistException {
		getHibernateTemplate().update(hgManager);

	}

	public void delete(HgManager hgManager) throws SignaturePersistException {
		getHibernateTemplate().delete(hgManager);
	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(getById(id));
	}

	public List<HgManager> findAll() throws SignaturePersistException {
		return (List<HgManager>) getHibernateTemplate().find("from HgManager");
	}

}
