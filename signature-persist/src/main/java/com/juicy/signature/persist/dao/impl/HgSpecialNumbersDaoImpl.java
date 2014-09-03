/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.persist.dao.HgSpecialNumbersDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgSpecialNumbers;

/**
 * HgSpecialNumbersDao�ӿ�ʵ����
 * 
 * @author ·����
 * @version <p>
 *          2011-7-29 ����
 *          </p>
 */
public class HgSpecialNumbersDaoImpl extends JuicyHibernateDaoSupport implements
		HgSpecialNumbersDao {

	public HgSpecialNumbers getById(Integer id)
			throws SignaturePersistException {
		return (HgSpecialNumbers) getHibernateTemplate().get(
				HgSpecialNumbers.class, id);
	}

	public synchronized Integer save(HgSpecialNumbers hgSpecialNumbers)
			throws SignaturePersistException {
		Integer id = super.getMaxId(HgSpecialNumbers.class.getName());
		hgSpecialNumbers.setId(++id);
		return (Integer) getHibernateTemplate().save(hgSpecialNumbers);
	}

	public void update(HgSpecialNumbers hgSpecialNumbers)
			throws SignaturePersistException {
		getHibernateTemplate().update(hgSpecialNumbers);
	}

	public void delete(HgSpecialNumbers hgSpecialNumbers)
			throws SignaturePersistException {
		getHibernateTemplate().delete(hgSpecialNumbers);
	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));
	}

	public List<HgSpecialNumbers> findAll() throws SignaturePersistException {
		return (List<HgSpecialNumbers>) getHibernateTemplate().find(
				"from HgSpecialNumbers");
	}

	public List<HgSpecialNumbers> findByCustomerId(Integer customerId,
			Integer numberType) throws SignaturePersistException {
		Object[] values = { customerId, numberType };
		return (List<HgSpecialNumbers>) getHibernateTemplate()
				.find("from HgSpecialNumbers where CUSTOMER_ID = ? and SPECIAL_NUMBER_TYPE = ?",
						values);
	}

	public Integer findCountByCustomerId(Integer customerId, Integer numberType)
			throws SignaturePersistException {
		// customerId����Ϊ��
		if (customerId == null) {
			return 0;
		}

		String sql = "select count(*) from HgSpecialNumbers where CUSTOMER_ID = ?";

		// ��ѯ�������Ͱ�����
		if (numberType == null) {
			sql += " and ( SPECIAL_NUMBER_TYPE = " + HgSpecialNumbers.BLACKLIST
					+ " or SPECIAL_NUMBER_TYPE = " + HgSpecialNumbers.WHITELIST
					+ ")";
			return super.getCount(sql, customerId);
		} else {// ֻ��ѯnumberType���͵�����
			sql += " and SPECIAL_NUMBER_TYPE = ?";
			Object[] values = { customerId, numberType };
			return super.getCount(sql, values);
		}
	}

	public List<HgSpecialNumbers> findByCustomerIdForPage(Integer customerId,
			Integer numberType, int offSet, int pageSize)
			throws SignaturePersistException {
		// customerId����Ϊ��
		if (customerId == null) {
			return new ArrayList<HgSpecialNumbers>();
		}

		String sql = "from HgSpecialNumbers where CUSTOMER_ID = ?";

		// ��ѯ�������Ͱ�����
		if (numberType == null) {
			sql += " and ( SPECIAL_NUMBER_TYPE = " + HgSpecialNumbers.BLACKLIST
					+ " or SPECIAL_NUMBER_TYPE = " + HgSpecialNumbers.WHITELIST
					+ ") order by id desc";
			return super.findByPage(sql, customerId, offSet, pageSize);
		} else {// ֻ��ѯnumberType���͵�����
			sql += " and SPECIAL_NUMBER_TYPE = ?  order by id desc";
			Object[] values = { customerId, numberType };
			return super.findByPage(sql, values, offSet, pageSize);
		}
	}

	public List<HgSpecialNumbers> findByNumber(String number, Integer numberType)
			throws SignaturePersistException {
		Object[] values = { number, numberType };
		return (List<HgSpecialNumbers>) getHibernateTemplate()
				.find("from HgSpecialNumbers where SPECIAL_NUMBER = ? and SPECIAL_NUMBER_TYPE = ?",
						values);
	}

	public Integer findCountByNumber(String number, Integer numberType)
			throws SignaturePersistException {
		// �Բ��������ж�
		if (number == null || number.trim().length() == 0 || numberType == null) {
			return 0;
		}

		String sql = "select count(*) from HgSpecialNumbers where SPECIAL_NUMBER = ? and SPECIAL_NUMBER_TYPE = ?";

		Object[] values = { number, numberType };

		return super.getCount(sql, values);
	}

	public List<HgSpecialNumbers> findByNumberForPage(String number,
			Integer numberType, int offSet, int pageSize)
			throws SignaturePersistException {
		// �Բ��������ж�
		if (number == null || number.trim().length() == 0 || numberType == null) {
			return new ArrayList<HgSpecialNumbers>();
		}

		String sql = "from HgSpecialNumbers where SPECIAL_NUMBER = ? and SPECIAL_NUMBER_TYPE = ?  order by id desc";
		
		Object[] values = { number, numberType };
		
		return super.findByPage(sql, values, offSet, pageSize);
	}

}
