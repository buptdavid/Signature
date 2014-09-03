/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.juicy.signature.persist.dao.ActivityDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Activity;

/**
 * ActivityDao实现类
 *
 * @author 路卫杰
 * @version <p>Oct 28, 2011 创建</p>
 */
public class ActivityDaoImpl extends JuicyHibernateDaoSupport implements ActivityDao {

	public Activity getById(Integer id) throws SignaturePersistException {
		return (Activity)getHibernateTemplate().get(Activity.class, id);
	}

	public Integer save(Activity activity) throws SignaturePersistException {
		Integer id = super.getMaxId(Activity.class.getName());
		activity.setId(++id);

		return (Integer) getHibernateTemplate().save(activity);
	}

	public void update(Activity activity) throws SignaturePersistException {
		getHibernateTemplate().update(activity);

	}

	public void delete(Activity activity) throws SignaturePersistException {
		getHibernateTemplate().delete(activity);

	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));

	}
	
	public void deleteFlag(Activity activity) throws SignaturePersistException {
		//数据库中取得该实例并置删除标志位
		Activity activity_1 = this.getById(activity.getId());
		activity_1.setIsDelete(true);
		
		//更新
		this.update(activity_1);
		
	}

	public void deleteFlag(Integer id) throws SignaturePersistException {
		//数据库中取得该实例并置删除标志位
		Activity activity_1 = this.getById(id);
		activity_1.setIsDelete(true);
		
		//更新
		this.update(activity_1);
	}

	public List<Activity> findAll() throws SignaturePersistException {
		return (List<Activity>) getHibernateTemplate().find(
				"from Activity");
	}

	public Integer findCount(Date startTime, Date endTime, Boolean isDelete)
			throws SignaturePersistException {
		String sql = "select count(id) from Activity where 1=1";
		
		List<Object> objectList = new ArrayList<Object>();
		
		if(startTime != null){
			sql += " and start_time > ?";
			objectList.add(startTime);
		}
		
		if(endTime != null){
			sql += " and end_time < ?";
			objectList.add(endTime);
		}
		
		if(isDelete != null){
			sql += " and is_delete = ?";
			objectList.add(isDelete);
		}
		
		Object[] values = objectList.toArray();
		
		return super.getCount(sql, values);		
	}

	public List<Activity> findForPage(Date startTime, Date endTime,
			Boolean isDelete, int offSet, int pageSize)
			throws SignaturePersistException {
		String sql = "from Activity where 1=1";
		
		List<Object> objectList = new ArrayList<Object>();
		
		if(startTime != null){
			sql += " and start_time > ?";
			objectList.add(startTime);
		}
		
		if(endTime != null){
			sql += " and end_time < ?";
			objectList.add(endTime);
		}
		
		if(isDelete != null){
			sql += " and is_delete = ?";
			objectList.add(isDelete);
		}
		
		sql += " order by id desc";
		
		Object[] values = objectList.toArray();
		
		return super.findByPage(sql, values, offSet, pageSize);
	}

	public List<Activity> findActivityByIndex(Integer count)
			throws SignaturePersistException {
		String sql = "from Activity where is_delete = 0 and is_index = 1 order by id desc";
		
		return (List<Activity>)super.findByPage(sql, 0, count);
		
	}

	public List<Activity> findActivityRandom(Boolean isDelete, Boolean isIndex,
			Integer count) throws SignaturePersistException {
		String sql = "from Activity where 1 = 1";
		
		List<Object> valueList = new ArrayList<Object>();
		
		if(isDelete != null){
			sql += " and is_delete = ?";
			valueList.add(isDelete);
		}
		
		if(isIndex != null){
			sql += " and is_index = ?";
			valueList.add(isIndex);
		}
		
		sql += " order by newid()";
		
		Object[] values = valueList.toArray();
		
		return super.findByPage(sql, values, 0, count);
				
	}

	
	
}
