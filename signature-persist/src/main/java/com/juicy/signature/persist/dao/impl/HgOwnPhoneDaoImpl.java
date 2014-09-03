/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.juicy.signature.persist.dao.HgOwnPhoneDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgOwnPhone;

/**
 * HgOwnPhoneDao接口实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public class HgOwnPhoneDaoImpl extends JuicyHibernateDaoSupport implements
		HgOwnPhoneDao {

	public HgOwnPhone getById(Integer id) throws SignaturePersistException {
		return (HgOwnPhone) getHibernateTemplate().get(HgOwnPhone.class, id);
	}

	public synchronized Integer save(HgOwnPhone hgOwnPhone) throws SignaturePersistException {
		Integer id = super.getMaxId(HgOwnPhone.class.getName());
		hgOwnPhone.setId(++id);

		return (Integer) getHibernateTemplate().save(hgOwnPhone);
	}

	public void update(HgOwnPhone hgOwnPhone) throws SignaturePersistException {
		getHibernateTemplate().update(hgOwnPhone);
	}

	public void delete(HgOwnPhone hgOwnPhone) throws SignaturePersistException {
		getHibernateTemplate().delete(hgOwnPhone);
	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));
	}

	public List<HgOwnPhone> findAll() throws SignaturePersistException {
		return (List<HgOwnPhone>) getHibernateTemplate()
				.find("from HgOwnPhone");
	}

	public HgOwnPhone findByCustomerId(Integer customerId)
			throws SignaturePersistException {
		List<HgOwnPhone> list = (List<HgOwnPhone>) getHibernateTemplate().find(
				"from HgOwnPhone where CUSTOMER_ID = ?", customerId);
		Iterator<HgOwnPhone> it = list.iterator();

		HgOwnPhone hgOwnPhone = null;
		while (it.hasNext()) {
			hgOwnPhone = it.next();
		}

		return hgOwnPhone;
	}

	public List<HgOwnPhone> findByZone(String zone)
			throws SignaturePersistException {
		return (List<HgOwnPhone>) getHibernateTemplate().find(
				"from HgOwnPhone where OWN_PHONE_ZONE = ?", zone);
	}

	public HgOwnPhone findByPhone(String phone)
			throws SignaturePersistException {
		List<HgOwnPhone> list = (List<HgOwnPhone>) getHibernateTemplate().find(
				"from HgOwnPhone where OWN_PHONE = ?", phone);
		Iterator<HgOwnPhone> it = list.iterator();

		HgOwnPhone hgOwnPhone = null;
		while (it.hasNext()) {
			hgOwnPhone = it.next();
		}

		return hgOwnPhone;
	}

}
