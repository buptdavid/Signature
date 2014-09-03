/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.juicy.signature.persist.dao.PortalDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Portal;

/**
 * PortalDao接口实现类
 *
 * @author 路卫杰
 * @version <p>Nov 25, 2011 创建</p>
 */
public class PortalDaoImpl extends JuicyHibernateDaoSupport implements
		PortalDao {

	public Portal getById(Integer id) throws SignaturePersistException {
		return (Portal)getHibernateTemplate().get(Portal.class, id);
	}

	public Integer save(Portal portal) throws SignaturePersistException {
		Integer id = super.getMaxId(Portal.class.getName());
		portal.setId(++id);

		return (Integer) getHibernateTemplate().save(portal);
	}

	public void update(Portal portal) throws SignaturePersistException {
		getHibernateTemplate().update(portal);
	}

	public void delete(Portal portal) throws SignaturePersistException {
		getHibernateTemplate().delete(portal);

	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));

	}

	public Portal findPortal() throws SignaturePersistException {
		List<Portal> portals = (List<Portal>) getHibernateTemplate().find(
				"from Portal");
		Iterator<Portal> it = portals.iterator();
		//如果有则返回第一个（也只有一个）
		while(it.hasNext()){
			return it.next();
		}
		
		//如果没有则返回null
		return null;
	}

}
