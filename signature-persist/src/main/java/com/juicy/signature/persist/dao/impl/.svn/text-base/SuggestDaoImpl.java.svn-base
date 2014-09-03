/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.List;

import com.juicy.signature.persist.dao.SuggestDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Suggest;

/**
 * 用户建议SuggestDao实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-11 创建
 *          </p>
 */
public class SuggestDaoImpl extends JuicyHibernateDaoSupport implements
		SuggestDao {

	public Suggest getById(Integer id) throws SignaturePersistException {
		return (Suggest) getHibernateTemplate().get(Suggest.class, id);
	}

	public synchronized Integer save(Suggest suggest) throws SignaturePersistException {
		Integer id = super.getMaxId(Suggest.class.getName());
		suggest.setId(++id);
		return (Integer) getHibernateTemplate().save(suggest);
	}

	public void update(Suggest suggest) throws SignaturePersistException {
		getHibernateTemplate().update(suggest);
	}

	public void delete(Suggest suggest) throws SignaturePersistException {
		getHibernateTemplate().delete(suggest);
	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));
	}

	public List<Suggest> findAll() throws SignaturePersistException {
		return (List<Suggest>) getHibernateTemplate().find("from Suggest");
	}

	public Integer findCountByTitle(String title)
			throws SignaturePersistException {
		String sql = "select count(id) from Suggest";

		if (title != null && title.length() > 0) {
			sql += " where title like ? or content like ?";
			title = "%" + title + "%";
			String values[] = {title,title};
			return super.getCount(sql, values);
		} else {
			return super.getCount(sql);
		}
	}

	public List<Suggest> findByTitleForPage(String title, int offSet,
			int pageSize) throws SignaturePersistException {
		String sql = "from Suggest";

		if (title != null && title.length() > 0) {
			sql += " where title like ? or content like ? order by time desc";
			title = "%" + title + "%";
			String values[] = {title,title};
			return super.findByPage(sql, values, offSet, pageSize);
		} else {
			sql += " order by time desc";
			return super.findByPage(sql, offSet, pageSize);
		}
	}

}
