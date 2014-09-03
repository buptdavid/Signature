/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.juicy.signature.persist.dao.HgDiyInfoDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgDiyInfo;

/**
 * HgDiyInfoDao实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-27 创建
 *          </p>
 *          <p>
 *          2011-08-03 增加分页查询的功能
 *          </p>
 */
public class HgDiyInfoDaoImpl extends JuicyHibernateDaoSupport implements
		HgDiyInfoDao {

	public HgDiyInfo getById(Integer id) throws SignaturePersistException {
		return (HgDiyInfo) getHibernateTemplate().get(HgDiyInfo.class, id);
	}

	public synchronized Integer save(HgDiyInfo hgDiyInfo) throws SignaturePersistException {
		Integer id = super.getMaxId(HgDiyInfo.class.getName());
		hgDiyInfo.setId(++id);
		return (Integer) getHibernateTemplate().save(hgDiyInfo);
	}

	public void update(HgDiyInfo hgDiyInfo) throws SignaturePersistException {
		getHibernateTemplate().update(hgDiyInfo);
	}

	public void delete(HgDiyInfo hgDiyInfo) throws SignaturePersistException {
		getHibernateTemplate().delete(hgDiyInfo);
	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));
	}

	public List<HgDiyInfo> findAll() throws SignaturePersistException {
		return (List<HgDiyInfo>) getHibernateTemplate().find("from HgDiyInfo");
	}

	public List<HgDiyInfo> findByCustomerId(Integer customerId)
			throws SignaturePersistException {
		return (List<HgDiyInfo>) getHibernateTemplate().find(
				"from HgDiyInfo where CUSTOMER_ID = ?", customerId);
	}

	public Integer findCountByCustomerId(Integer customerId)
			throws SignaturePersistException {
		if (customerId == null) {
			return 0;
		}

		String sql = "select count(id) from HgDiyInfo where CUSTOMER_ID = ?";

		return super.getCount(sql, customerId);
	}

	public List<HgDiyInfo> findByCustomerIdForPage(Integer customerId,
			int offSet, int pageSize) throws SignaturePersistException {
		// customerId不能为空
		if (customerId == null) {
			return new ArrayList<HgDiyInfo>();
		}

		String sql = "from HgDiyInfo where CUSTOMER_ID = ? order by DIY_INFO_CREATETIME desc";

		return super.findByPage(sql, customerId, offSet, pageSize);
	}

	public Integer findCountByCustomerId(Integer customerId, Byte isDefault)
			throws SignaturePersistException {
		// customerId和isDefault都不能为null
		if (customerId == null || isDefault == null) {
			return 0;
		}

		String sql = "select count(id) from HgDiyInfo where CUSTOMER_ID = ? and IS_DEFAULT = ?";

		Object[] values = { customerId, isDefault };

		return super.getCount(sql, values);
	}

	public List<HgDiyInfo> findByCustomerIdForPage(Integer customerId,
			Byte isDefault, int offSet, int pageSize)
			throws SignaturePersistException {
		// customerId和isDefault不能为空
		if (customerId == null || isDefault == null) {
			return new ArrayList<HgDiyInfo>();
		}

		String sql = "from HgDiyInfo where CUSTOMER_ID = ? and IS_DEFAULT = ?  order by DIY_INFO_CREATETIME desc";
		Object[] values = { customerId, isDefault };

		return super.findByPage(sql, values, offSet, pageSize);
	}

	public Integer findCountDefaultForTime(Integer customerId,Date date)
			throws SignaturePersistException {
		//customerId不能为空
		if(customerId == null){
			return 0;
		}
		
		String sql = "select count(id) from HgDiyInfo where CUSTOMER_ID = ?";
		
		if(date != null){
			sql += " and DIY_INFO_CREATETIME > ?";
			Object[] values = {customerId,date};
			return super.getCount(sql, values);
		}else{
			return super.getCount(sql, customerId);
		}
	}

	public Integer updateContent(String preContent, String content)
			throws SignaturePersistException {
		// 计算要更新的记录数量
		String sql_1 = "select count(id) from HgDiyInfo where DIY_INFO_CONTENT = ?";
		Integer amount = super.getCount(sql_1, preContent);
		
		//更新
		String sql ="update HgDiyInfo set DIY_INFO_CONTENT = ? where DIY_INFO_CONTENT = ?";
		String[] values = {content, preContent};
		
		super.executeUpdate(sql, values);
		
		
		return amount;
		
	}

}
