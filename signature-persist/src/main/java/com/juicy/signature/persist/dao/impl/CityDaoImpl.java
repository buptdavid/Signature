/**
 * Copyright @ 2011-2012 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.List;

import com.juicy.signature.persist.dao.CityDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.City;

/**
 * CityDao接口实现类
 *
 * @author 路卫杰
 * @version <p>Feb 29, 2012 创建</p>
 */
public class CityDaoImpl extends JuicyHibernateDaoSupport implements CityDao {

	public City getById(Integer id) throws SignaturePersistException {
		return (City) getHibernateTemplate().get(City.class, id);
	}

	public Integer save(City city) throws SignaturePersistException {
		Integer id = super.getMaxId(City.class.getName());
		city.setId(++id);
		return (Integer) getHibernateTemplate().save(city);
	}

	public void update(City city) throws SignaturePersistException {
		getHibernateTemplate().update(city);

	}

	public void delete(City city) throws SignaturePersistException {
		getHibernateTemplate().delete(city);

	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));

	}

	public List<City> findAll() throws SignaturePersistException {
		return (List<City>) getHibernateTemplate().find("from City");
	}

}
