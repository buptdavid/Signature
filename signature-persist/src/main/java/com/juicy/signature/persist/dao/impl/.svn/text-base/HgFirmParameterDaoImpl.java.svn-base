/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.juicy.signature.persist.dao.HgFirmParameterDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgFirmParameter;

/**
 * HgFirmParameterDao接口实现类
 *
 * @author 路卫杰
 * @version <p>Nov 25, 2011 创建</p>
 */
public class HgFirmParameterDaoImpl extends JuicyHibernateDaoSupport implements
		HgFirmParameterDao {

	public HgFirmParameter getById(Integer id) throws SignaturePersistException {
		return (HgFirmParameter)getHibernateTemplate().get(HgFirmParameter.class, id);
	}

	public Integer save(HgFirmParameter hgFirmParameter)
			throws SignaturePersistException {
		Integer id = super.getMaxId(HgFirmParameter.class.getName());
		hgFirmParameter.setId(++id);

		return (Integer) getHibernateTemplate().save(hgFirmParameter);
	}

	public void update(HgFirmParameter hgFirmParameter)
			throws SignaturePersistException {
		getHibernateTemplate().update(hgFirmParameter);

	}

	public void delete(HgFirmParameter hgFirmParameter)
			throws SignaturePersistException {
		getHibernateTemplate().delete(hgFirmParameter);

	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));

	}

	public HgFirmParameter findHgFirmParameter()
			throws SignaturePersistException {
		List<HgFirmParameter> hgFirmParameters = (List<HgFirmParameter>) getHibernateTemplate().find(
				"from HgFirmParameter");
		Iterator<HgFirmParameter> it = hgFirmParameters.iterator();
		//如果有则返回第一个（也只有一个）
		while(it.hasNext()){
			return it.next();
		}
		
		//如果没有则返回null
		return null;
	}

}
