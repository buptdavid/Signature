/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.juicy.signature.persist.dao.HgCustomerDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;

/**
 * HgCustomerDao实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-25 创建
 *          </p>
 */
public class HgCustomerDaoImpl extends JuicyHibernateDaoSupport implements
		HgCustomerDao {

	public HgCustomer getById(Integer id) throws SignaturePersistException {
		return (HgCustomer) getHibernateTemplate().get(HgCustomer.class, id);
	}

	public synchronized Integer save(HgCustomer hgCustomer)
			throws SignaturePersistException {
		// 取得最大的主键ID
		Integer id = super.getMaxId(HgCustomer.class.getName());
		hgCustomer.setId(++id);
		return (Integer) getHibernateTemplate().save(hgCustomer);
	}

	public void update(HgCustomer hgCustomer) throws SignaturePersistException {
		getHibernateTemplate().update(hgCustomer);
	}

	public void delete(HgCustomer hgCustomer) throws SignaturePersistException {
		getHibernateTemplate().delete(hgCustomer);
	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));
	}

	public List<HgCustomer> findAll() throws SignaturePersistException {
		return (List<HgCustomer>) getHibernateTemplate()
				.find("from HgCustomer");
	}

	public HgCustomer getByUserId(Integer userId)
			throws SignaturePersistException {
		List<HgCustomer> list = getHibernateTemplate().find(
				"from HgCustomer where USER_ID = ?", userId);
		Iterator<HgCustomer> it = list.iterator();

		HgCustomer hgCustomer = null;

		if (it.hasNext()) {
			hgCustomer = it.next();
		}

		return hgCustomer;
	}

	public List<HgCustomer> findByStat(Integer customerStat)
			throws SignaturePersistException {
		// customerStat不能为空
		if (customerStat == null) {
			return new ArrayList<HgCustomer>();
		}

		//执行并返回
		return (List<HgCustomer>) getHibernateTemplate().find(
				"from HgCustomer where CUSTOMER_STAT =?", customerStat);

	}

	public HgCustomer getByCustomerName(String customerName)
			throws SignaturePersistException {
		//检查参数
		if(customerName == null || customerName.trim().length() == 0){
			return null;
		}
		
		List<HgCustomer> list = getHibernateTemplate().find(
				"from HgCustomer where CUSTOMER_NAME = ?", customerName);
		
		Iterator<HgCustomer> it = list.iterator();		
		HgCustomer hgCustomer = null;
		if (it.hasNext()) {
			hgCustomer = it.next();
		}

		//返回
		return hgCustomer;
	}

	public Integer findCountByStat(Date startTime, Date endTime,
			Integer customerStat, String customerName) throws SignaturePersistException {
		String sql = "select count(id) from HgCustomer where 1 = 1";
		
		List<Object> valueList = new ArrayList<Object>();
		
		if(startTime != null){
			sql += " and UPDATE_TIME > ?";
			valueList.add(startTime);
		}
		
		if(endTime != null){
			sql += " and UPDATE_TIME < ?";
			valueList.add(endTime);
		}
		
		if(customerStat != null){
			sql += " and CUSTOMER_STAT = ?";
			valueList.add(customerStat);
		}
		
		if(customerName != null){
			sql += " and CUSTOMER_NAME = ?";
			valueList.add(customerName);
		}
		
		Object[] values = valueList.toArray();
		
		return super.getCount(sql, values);
		
	}

	public List<HgCustomer> findByStatForPage(Date startTime, Date endTime,
			Integer customerStat, String customerName, int offSet, int pageSize)
			throws SignaturePersistException {
		String sql = "from HgCustomer where 1 = 1";
		
		List<Object> valueList = new ArrayList<Object>();
		
		if(startTime != null){
			sql += " and UPDATE_TIME > ?";
			valueList.add(startTime);
		}
		
		if(endTime != null){
			sql += " and UPDATE_TIME < ?";
			valueList.add(endTime);
		}
		
		if(customerStat != null){
			sql += " and CUSTOMER_STAT = ?";
			valueList.add(customerStat);
		}
		
		if(customerName != null){
			sql += " and CUSTOMER_NAME = ?";
			valueList.add(customerName);
		}
		
		sql += " order by UPDATE_TIME desc";
		
		Object[] values = valueList.toArray();
		
		return super.findByPage(sql, values, offSet, pageSize);
	}
	
	
	public Integer findCountByStatAndCity(Date startTime, Date endTime,
			Integer customerStat, String customerName, String cityCode) throws SignaturePersistException {
		String sql = "select count(id) from HgCustomer where 1 = 1";
		
		List<Object> valueList = new ArrayList<Object>();
		
		if(startTime != null){
			sql += " and UPDATE_TIME > ?";
			valueList.add(startTime);
		}
		
		if(endTime != null){
			sql += " and UPDATE_TIME < ?";
			valueList.add(endTime);
		}
		
		if(customerStat != null){
			sql += " and CUSTOMER_STAT = ?";
			valueList.add(customerStat);
		}
		
		if(customerName != null){
			sql += " and CUSTOMER_NAME = ?";
			valueList.add(customerName);
		}
		
		if(cityCode != null){
			sql += " and city_code = ?";
			valueList.add(cityCode);
		}
		
		Object[] values = valueList.toArray();
		
		return super.getCount(sql, values);
		
	}

	public List<HgCustomer> findByStatAndCityForPage(Date startTime, Date endTime,
			Integer customerStat, String customerName, String cityCode, int offSet, int pageSize)
			throws SignaturePersistException {
		String sql = "from HgCustomer where 1 = 1";
		
		List<Object> valueList = new ArrayList<Object>();
		
		if(startTime != null){
			sql += " and UPDATE_TIME > ?";
			valueList.add(startTime);
		}
		
		if(endTime != null){
			sql += " and UPDATE_TIME < ?";
			valueList.add(endTime);
		}
		
		if(customerStat != null){
			sql += " and CUSTOMER_STAT = ?";
			valueList.add(customerStat);
		}
		
		if(customerName != null){
			sql += " and CUSTOMER_NAME = ?";
			valueList.add(customerName);
		}
		
		if(cityCode != null){
			sql += " and city_code = ?";
			valueList.add(cityCode);
		}
		
		sql += " order by UPDATE_TIME desc";
		
		Object[] values = valueList.toArray();
		
		return super.findByPage(sql, values, offSet, pageSize);
	}

	public List<HgCustomer> findNoCode() throws SignaturePersistException {
		
//		return (List<HgCustomer>) getHibernateTemplate()
//				.find("from HgCustomer where city_code = null ");
		
		String sql = "from HgCustomer where city_code = null ";
		
		return (List<HgCustomer>)super.findByPage(sql, 0, 100);
	}
}
