/**
 * Copyright @ 2011-2012 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.List;

import com.juicy.signature.persist.dao.CityRuleDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.CityRule;

/**
 * CityRuleDao接口实现类
 *
 * @author 路卫杰
 * @version <p>Feb 29, 2012 创建</p>
 */
public class CityRuleDaoImpl extends JuicyHibernateDaoSupport implements
		CityRuleDao {

	public CityRule getById(Integer id) throws SignaturePersistException {
		return (CityRule) getHibernateTemplate().get(CityRule.class, id);
	}

	public Integer save(CityRule cityRule) throws SignaturePersistException {
		Integer id = super.getMaxId(CityRule.class.getName());
		cityRule.setId(++id);
		return (Integer) getHibernateTemplate().save(cityRule);
	}

	public void update(CityRule cityRule) throws SignaturePersistException {
		getHibernateTemplate().update(cityRule);

	}

	public void delete(CityRule cityRule) throws SignaturePersistException {
		getHibernateTemplate().delete(cityRule);

	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));

	}

	public List<CityRule> findAll() throws SignaturePersistException {
		return (List<CityRule>) getHibernateTemplate().find("from CityRule");
	}

}
