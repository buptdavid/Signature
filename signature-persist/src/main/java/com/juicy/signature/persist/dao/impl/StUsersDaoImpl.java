/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.juicy.signature.persist.dao.StUsersDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.StUsers;

/**
 * StUsersDao接口实现类
 * 
 * @author 路卫杰
 * @version 2011.07.20 创建类
 */
public class StUsersDaoImpl extends JuicyHibernateDaoSupport implements
		StUsersDao {

	public StUsers getById(Integer id) throws SignaturePersistException {
		return (StUsers) getHibernateTemplate().get(StUsers.class, id);
	}

	public synchronized Integer save(StUsers stUsers) throws SignaturePersistException {
		// 取得最大的主键ID
		Integer id = super.getMaxId(StUsers.class.getName());
		stUsers.setId(++id);
		return (Integer) getHibernateTemplate().save(stUsers);
	}

	public void update(StUsers stUsers) throws SignaturePersistException {
		getHibernateTemplate().update(stUsers);
	}

	public void delete(StUsers stUsers) throws SignaturePersistException {
		getHibernateTemplate().delete(stUsers);
	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(getById(id));
	}

	public List<StUsers> findAll() throws SignaturePersistException {
		return (List<StUsers>) getHibernateTemplate().find("from StUsers");
	}

	public StUsers getByLoginName(String loginName) throws SignaturePersistException {
		List<StUsers> list = (List<StUsers>)getHibernateTemplate().find("from StUsers where login_name = ?" , loginName);
		Iterator<StUsers> it = list.iterator();
		
		StUsers stUsers = null;
		
		if (it.hasNext()) {
			stUsers = it.next();
		}

		return stUsers;
	}

	public StUsers getByLoginNameForType(String loginName, Integer userType)
			throws SignaturePersistException {
		// loginName不能为空
		if(loginName == null){
			return null;
}
		
		List<Object> valueList = new ArrayList<Object>();
		valueList.add(loginName);
		
		String sql = "from StUsers where login_name = ?";
		
		if(userType != null){
			sql += " and USER_TYPE = ?";
			valueList.add(userType);
		}
		
		Object[] values = valueList.toArray();
		
		List<StUsers> list = (List<StUsers> )super.findByHql(sql, values);		
		Iterator<StUsers> it = list.iterator();
		
		StUsers stUsers = null;		
		if (it.hasNext()) {
			stUsers = it.next();
		}

		return stUsers;
	}

}
