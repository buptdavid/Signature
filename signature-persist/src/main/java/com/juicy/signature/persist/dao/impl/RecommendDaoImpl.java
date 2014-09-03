/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.persist.dao.RecommendDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Recommend;
import com.juicy.signature.persist.po.SignatureClass;

/**
 * RecommendDao接口实现类
 *
 * @author 路卫杰
 * @version <p>Oct 28, 2011 创建</p>
 */
public class RecommendDaoImpl extends JuicyHibernateDaoSupport implements
		RecommendDao {

	public Recommend getById(Integer id) throws SignaturePersistException {
		return (Recommend)getHibernateTemplate().get(Recommend.class, id);
	}

	public Integer save(Recommend recommend) throws SignaturePersistException {
		Integer id = super.getMaxId(Recommend.class.getName());
		recommend.setId(++id);
		
		return (Integer) getHibernateTemplate().save(recommend);
	}

	public void update(Recommend recommend) throws SignaturePersistException {
		getHibernateTemplate().update(recommend);

	}

	public void delete(Recommend recommend) throws SignaturePersistException {
		getHibernateTemplate().delete(recommend);

	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));

	}

	public void deleteFlag(Recommend recommend)
			throws SignaturePersistException {
		//数据库中取得该实例并置删除标志位
		Recommend recommend_1 = this.getById(recommend.getId());
		recommend_1.setIsDelete(true);
				
		//更新
		this.update(recommend_1);

	}

	public void deleteFlag(Integer id) throws SignaturePersistException {
		//数据库中取得该实例并置删除标志位
		Recommend recommend_1 = this.getById(id);
		recommend_1.setIsDelete(true);
				
		//更新
		this.update(recommend_1);

	}

	public List<Recommend> findAll() throws SignaturePersistException {
		return (List<Recommend>) getHibernateTemplate().find(
				"from Recommend");
	}

	public Integer findCount(SignatureClass signatureClass, Byte source,
			Boolean isDelete) throws SignaturePersistException {
		String sql = "select count(id) from Recommend where 1 = 1";
		
		List<Object> objectList = new ArrayList<Object>();
		
		if(signatureClass != null){
			Integer classId = signatureClass.getId();
			sql += " and class_id = ?";
			
			objectList.add(classId);
		}
		
		if(source != null){
			sql += " and source = ?";
			objectList.add(source);
		}
		
		if(isDelete != null){
			sql += " and is_delete = ?";
			objectList.add(isDelete);
		}
		
		Object[] values = objectList.toArray();
		
		return super.getCount(sql, values);		
	}

	public List<Recommend> findForPage(SignatureClass signatureClass,
			Byte source, Boolean isDelete, int offSet, int pageSize)
			throws SignaturePersistException {
		String sql = "from Recommend where 1 = 1";
		
		List<Object> objectList = new ArrayList<Object>();
		
		if(signatureClass != null){
			Integer classId = signatureClass.getId();
			sql += " and class_id = ?";
			
			objectList.add(classId);
		}
		
		if(source != null){
			sql += " and source = ?";
			objectList.add(source);
		}
		
		if(isDelete != null){
			sql += " and is_delete = ?";
			objectList.add(isDelete);
		}
		
		sql += " order by time desc";
		
		Object[] values = objectList.toArray();
		
		return super.findByPage(sql, values, offSet, pageSize);
	}

	public List<Recommend> findBySource(Byte source, Integer count)
			throws SignaturePersistException {
		
		String sql = "from Recommend where is_delete = 0";
				
		if(source != null){
			sql += " and source = ?";
		}
		
		sql += " order by time desc";
								
		return (List<Recommend>)super.findByPage(sql, source, 0, count);		
	}

}
