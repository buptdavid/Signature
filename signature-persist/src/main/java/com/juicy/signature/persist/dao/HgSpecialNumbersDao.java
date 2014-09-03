/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgSpecialNumbers;

/**
 * HgSpecialNumbersDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public interface HgSpecialNumbersDao {

	/**
	 * 根据标识属性来加载HgSpecialNumbers实例
	 * 
	 * @param id
	 *            需要加载的HgSpecialNumbers实例的标识属性值
	 * @return 指定标识属性对应的HgSpecialNumbers实例
	 * @throws SignaturePersistException
	 */
	HgSpecialNumbers getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的HgSpecialNumbers实例
	 * 
	 * @param hgSpecialNumbers
	 *            需要被持久化的HgSpecialNumbers实例
	 * @return HgSpecialNumbers实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(HgSpecialNumbers hgSpecialNumbers)
			throws SignaturePersistException;

	/**
	 * 修改指定的HgSpecialNumbers实例
	 * 
	 * @param hgSpecialNumbers
	 *            需要被修改的HgSpecialNumbers实例
	 * @throws SignaturePersistException
	 */
	void update(HgSpecialNumbers hgSpecialNumbers)
			throws SignaturePersistException;

	/**
	 * 删除指定的HgSpecialNumbers实例
	 * 
	 * @param hgSpecialNumbers
	 *            需要被删除的HgSpecialNumbers实例
	 * @throws SignaturePersistException
	 */
	void delete(HgSpecialNumbers hgSpecialNumbers)
			throws SignaturePersistException;

	/**
	 * 根据标识属性删除HgSpecialNumbers实例
	 * 
	 * @param id
	 *            需要被删除的HgSpecialNumbers实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的HgSpecialNumbers实例
	 * 
	 * @return 数据库中全部的HgSpecialNumbers实例
	 * @throws SignaturePersistException
	 */
	List<HgSpecialNumbers> findAll() throws SignaturePersistException;

	/**
	 * 根据客户Id和特殊号码类型查找
	 * 
	 * @param customerId
	 *            客户ID
	 * @param numberType
	 *            特殊号码的类型.1:黑名单;2:白名单;3:拒接名单
	 * @return HgSpecialNumbers实例List
	 */
	List<HgSpecialNumbers> findByCustomerId(Integer customerId,
			Integer numberType) throws SignaturePersistException;

	/**
	 * 根据客户Id和特殊号码类型查找HgSpecialNumbers实例对象数量
	 * 
	 * @param customerId
	 *            客户ID
	 * @param numberType
	 *            特殊号码的类型.1:黑名单;2:白名单;3:拒接名单
	 * @return 符合条件的HgSpecialNumbers实例对象数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByCustomerId(Integer customerId, Integer numberType)
			throws SignaturePersistException;

	/**
	 * 根据客户Id和特殊号码类型分页查找HgSpecialNumbers实例对象
	 * 
	 * @param customerId 客户ID
	 * @param numberType 特殊号码类型
	 * @param offSet 第一条记录索引
	 * @param pageSize 每页记录数量
	 * @return HgSpecialNumbers实例对象List
	 * @throws SignaturePersistException
	 */
	List<HgSpecialNumbers> findByCustomerIdForPage(Integer customerId,
			Integer numberType, int offSet, int pageSize)
			throws SignaturePersistException;

	/**
	 * 根据特殊号码和特殊号码类型查找
	 * 
	 * @param number
	 *            特殊号码
	 * @param numberType
	 *            特殊号码类型
	 * 
	 * @return HgSpecialNumbers实例List
	 * @throws SignaturePersistException
	 */
	List<HgSpecialNumbers> findByNumber(String number, Integer numberType)
			throws SignaturePersistException;

	/**
	 * 根据特殊号码和特殊号码类型查找HgSpecialNumbers实例对象数量
	 * 
	 * @param number
	 *            特殊号码
	 * @param numberType
	 *            特殊号码类型
	 * @return 符合条件的HgSpecialNumbers实例对象数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByNumber(String number, Integer numberType)
			throws SignaturePersistException;

	/**
	 * 根据特殊号码和特殊号码类型分页查找HgSpecialNumbers实例List
	 * 
	 * @param number 特殊号码
	 * @param numberType 特殊号码类型
	 * @param offSet 第一条记录索引
	 * @param pageSize 每页记录数量
	 * @return HgSpecialNumbers实例List
	 * @throws SignaturePersistException
	 */
	List<HgSpecialNumbers> findByNumberForPage(String number,
			Integer numberType, int offSet, int pageSize)
			throws SignaturePersistException;

}
