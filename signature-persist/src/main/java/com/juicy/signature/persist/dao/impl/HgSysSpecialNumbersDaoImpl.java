/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.List;

import com.juicy.signature.persist.dao.HgSysSpecialNumbersDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgSysSpecialNumbers;

/**
 * 系统黑白名单Dao实现类
 *
 * @author 路卫杰
 * @version <p>Dec 29, 2011 创建</p>
 */
public class HgSysSpecialNumbersDaoImpl extends JuicyHibernateDaoSupport
		implements HgSysSpecialNumbersDao {

	public HgSysSpecialNumbers getById(Integer id)
			throws SignaturePersistException {
		return (HgSysSpecialNumbers) getHibernateTemplate().get(HgSysSpecialNumbers.class, id);
	}

	public Integer save(HgSysSpecialNumbers hgSysSpecialNumbers)
			throws SignaturePersistException {
		Integer id = super.getMaxId(HgSysSpecialNumbers.class.getName());
		hgSysSpecialNumbers.setId(++id);
		return (Integer) getHibernateTemplate().save(hgSysSpecialNumbers);
	}

	public void update(HgSysSpecialNumbers hgSysSpecialNumbers)
			throws SignaturePersistException {
		getHibernateTemplate().update(hgSysSpecialNumbers);

	}

	public void delete(HgSysSpecialNumbers hgSysSpecialNumbers)
			throws SignaturePersistException {
		getHibernateTemplate().delete(hgSysSpecialNumbers);

	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));

	}

	public List<HgSysSpecialNumbers> findAll() throws SignaturePersistException {
		return (List<HgSysSpecialNumbers>) getHibernateTemplate().find("from HgSysSpecialNumbers");
	}

	public Integer findCountByNumber(String number)
			throws SignaturePersistException {
		String sql = "select count(id) from HgSysSpecialNumbers";

		if (number != null && number.length() > 0) {
			sql += " where SYS_SPECIAL_NUMBER = ?";
			return super.getCount(sql, number);
		} else {
			return super.getCount(sql);
		}
	}

	public List<HgSysSpecialNumbers> findByNumberForPage(String number,
			int offSet, int pageSize) throws SignaturePersistException {
		String sql = "from HgSysSpecialNumbers";

		if (number != null && number.length() > 0) {
			sql += " where SYS_SPECIAL_NUMBER = ? order by SPECIAL_NUMBER_CERATEDATE desc";
			return super.findByPage(sql, number, offSet, pageSize);
		} else {
			sql += " order by SPECIAL_NUMBER_CERATEDATE desc";
			return super.findByPage(sql, offSet, pageSize);
		}
	}

}
