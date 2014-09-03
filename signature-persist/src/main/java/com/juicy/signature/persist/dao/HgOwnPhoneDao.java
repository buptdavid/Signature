/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgOwnPhone;

/**
 * HgOwnPhoneDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public interface HgOwnPhoneDao {

	/**
	 * 根据标识属性来加载HgOwnPhone实例
	 * 
	 * @param id
	 *            需要加载的HgOwnPhone实例的标识属性值
	 * @return 指定标识属性对应的HgOwnPhone实例
	 * @throws SignaturePersistException
	 */
	HgOwnPhone getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的HgOwnPhone实例
	 * 
	 * @param hgOwnPhone
	 *            需要被持久化的HgOwnPhone实例
	 * @return HgOwnPhone实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(HgOwnPhone hgOwnPhone) throws SignaturePersistException;

	/**
	 * 修改指定的HgOwnPhone实例
	 * 
	 * @param hgOwnPhone
	 *            需要被修改的HgOwnPhone实例
	 * @throws SignaturePersistException
	 */
	void update(HgOwnPhone hgOwnPhone) throws SignaturePersistException;

	/**
	 * 删除指定的HgOwnPhone实例
	 * 
	 * @param hgOwnPhone
	 *            需要被删除的HgOwnPhone实例
	 * @throws SignaturePersistException
	 */
	void delete(HgOwnPhone hgOwnPhone) throws SignaturePersistException;

	/**
	 * 根据标识属性删除HgOwnPhone实例
	 * 
	 * @param id
	 *            需要被删除的HgOwnPhone实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的HgOwnPhone实例
	 * 
	 * @return 数据库中全部的HgOwnPhone实例
	 * @throws SignaturePersistException
	 */
	List<HgOwnPhone> findAll() throws SignaturePersistException;

	/**
	 * 根据客户customerId查询HgOwnPhone实例
	 * 
	 * @param customerId
	 *            客户Id
	 * @return HgOwnPhone实例
	 * @throws SignaturePersistException
	 */
	HgOwnPhone findByCustomerId(Integer customerId) throws SignaturePersistException;

	/**
	 * 根据区号查询HgOwnPhone实例
	 * 
	 * @param ownPhoneZone
	 *            区号
	 * @return HgOwnPhone实例List
	 * @throws SignaturePersistException
	 */
	List<HgOwnPhone> findByZone(String zone) throws SignaturePersistException;

	/**
	 * 根据号码查询HgOwnPhone实例
	 * 
	 * @param phone
	 *            号码
	 * @return HgOwnPhone实例
	 * @throws SignaturePersistException
	 */
	HgOwnPhone findByPhone(String phone) throws SignaturePersistException;
}
