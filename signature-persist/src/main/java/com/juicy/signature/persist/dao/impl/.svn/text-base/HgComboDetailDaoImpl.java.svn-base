/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.juicy.signature.persist.dao.HgComboDetailDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgComboDetail;

/**
 * 
 *
 * @author 路卫杰
 * @version <p>Nov 25, 2011 创建</p>
 */
public class HgComboDetailDaoImpl extends JuicyHibernateDaoSupport implements
		HgComboDetailDao {

	public HgComboDetail getById(Integer id) throws SignaturePersistException {
		return (HgComboDetail)getHibernateTemplate().get(HgComboDetail.class, id);
	}

	public Integer save(HgComboDetail hgComboDetail)
			throws SignaturePersistException {
		Integer id = super.getMaxId(HgComboDetail.class.getName());
		hgComboDetail.setId(++id);

		return (Integer) getHibernateTemplate().save(hgComboDetail);
	}

	public void update(HgComboDetail hgComboDetail)
			throws SignaturePersistException {
		getHibernateTemplate().update(hgComboDetail);

	}

	public void delete(HgComboDetail hgComboDetail)
			throws SignaturePersistException {
		getHibernateTemplate().delete(hgComboDetail);

	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));

	}

	public HgComboDetail findHgComboDetail() throws SignaturePersistException {
		List<HgComboDetail> hgComboDetails = (List<HgComboDetail>) getHibernateTemplate().find(
				"from HgComboDetail");
		Iterator<HgComboDetail> it = hgComboDetails.iterator();
		//如果有则返回第一个（也只有一个）
		while(it.hasNext()){
			return it.next();
		}
		
		//如果没有则返回null
		return null;
	}

}
