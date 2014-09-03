/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.juicy.signature.persist.dao.HgDefruleContentDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgDefruleContent;

/**
 * HgDefruleContentDao�ӿ�ʵ����
 *
 * @author ·����
 * @version <p>Dec 30, 2011 ����</p>
 */
public class HgDefruleContentDaoImpl extends JuicyHibernateDaoSupport implements
		HgDefruleContentDao {

	public synchronized Integer save(HgDefruleContent hgDefruleContent)
			throws SignaturePersistException {
		Integer id = super.getMaxId(HgDefruleContent.class.getName());
		hgDefruleContent.setId(++id);
		return (Integer) getHibernateTemplate().save(hgDefruleContent);
	}

	public HgDefruleContent getDefruleContent() throws SignaturePersistException {
		List<HgDefruleContent> list = getHibernateTemplate().find("from HgDefruleContent");
		Iterator<HgDefruleContent> it = list.iterator();

		HgDefruleContent hgDefruleContent = null;
		if (it.hasNext()) {
			hgDefruleContent = it.next();
		}

		return hgDefruleContent;
	}

	public void saveOrUpdate(String defContent) throws SignaturePersistException {
		HgDefruleContent hgDefruleContent = this.getDefruleContent();

		// ���helpΪ������б��棬������и���
		if (hgDefruleContent == null) {
			HgDefruleContent newHgDefruleContent = new HgDefruleContent();
			newHgDefruleContent.setDefcontent(defContent);
			this.save(newHgDefruleContent);
		} else {
			hgDefruleContent.setDefcontent(defContent);
			getHibernateTemplate().update(hgDefruleContent);
		}

	}

	public void update(HgDefruleContent hgDefruleContent)
			throws SignaturePersistException {
		getHibernateTemplate().update(hgDefruleContent);
		
	}

}
