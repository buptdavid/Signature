/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgSendrule;

/**
 * 签名策略Dao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-26 创建
 *          </p>
 *          <p>
 *          2011-08-03 增加分页查询的功能
 *          </p>
 */
public interface HgSendruleDao {

	/**
	 * 根据标识属性来加载HgSendrule实例
	 * 
	 * @param id
	 *            需要加载的HgSendrule实例的标识属性值
	 * @return 指定标识属性对应的HgSendrule实例
	 * @throws SignaturePersistException
	 */
	HgSendrule getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的HgSendrule实例
	 * 
	 * @param hgSendrule
	 *            需要被持久化的HgSendrule实例
	 * @return hgSendrule实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(HgSendrule hgSendrule) throws SignaturePersistException;

	/**
	 * 修改指定的HgSendrule实例
	 * 
	 * @param hgSendrule
	 *            需要被修改的HgSendrule实例
	 * @throws SignaturePersistException
	 */
	void update(HgSendrule hgSendrule) throws SignaturePersistException;

	/**
	 * 删除指定的HgSendrule实例
	 * 
	 * @param hgSendrule
	 *            需要被删除的HgSendrule实例
	 * @throws SignaturePersistException
	 */
	void delete(HgSendrule hgSendrule) throws SignaturePersistException;

	/**
	 * 根据标识属性删除HgSendrule实例
	 * 
	 * @param id
	 *            需要被删除的HgSendrule实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的HgSendrule实例
	 * 
	 * @return 数据库中全部的HgSendrule实例
	 * @throws SignaturePersistException
	 */
	List<HgSendrule> findAll() throws SignaturePersistException;

	/**
	 * 根据calledNumbers查询HgSendrule默认策略实例
	 * 
	 * @param calledNumbers
	 *            被叫用户手机号码
	 * 
	 * @return 查询到的HgSendrule实例
	 * @throws SignaturePersistException
	 */
	HgSendrule getDefaultByCalledNumbers(String calledNumbers) throws SignaturePersistException;

	/**
	 * 根据calledNumbers查询HgSendrule个性化策略实例
	 * 
	 * @param calledNumbers
	 *            被叫用户手机号码
	 * 
	 * @return 查询到的HgSendrule实例List
	 * @throws SignaturePersistException
	 */
	List<HgSendrule> getPersonalizeByCalledNumbers(String calledNumbers) throws SignaturePersistException;

	/**
	 * 根据calledNumbers查询HgSendrule个性化策略实例的数量
	 * 
	 * @param calledNumbers
	 *            被叫手机号码
	 * @return 个性化策略实例的数量
	 * @throws SignaturePersistException
	 */
	Integer getPersonalizeCountByCalledNumbers(String calledNumbers) throws SignaturePersistException;

	/**
	 * 根据calledNumbers分页查询HgSendrule个性化策略实例
	 * 
	 * @param calledNumbers
	 *            被叫用户手机号码
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return 查询到的HgSendrule实例List
	 * @throws SignaturePersistException
	 */
	List<HgSendrule> getPersonalizeByCalledNumbersForPage(String calledNumbers,
			int offSet, int pageSize) throws SignaturePersistException;

	/**
	 * 根据customerId查询HgSendrule默认策略实例
	 * 
	 * @param customerId
	 *            被叫用户的客户ID
	 * 
	 * @return 查询到的HgSendrule实例
	 * @throws SignaturePersistException
	 */
	HgSendrule getDefaultByCustomerId(Integer customerId) throws SignaturePersistException;

	/**
	 * 根据customerId查询HgSendrule个性化策略实例
	 * 
	 * @param customerId
	 *            被叫用户的客户ID
	 * 
	 * @return 查询到的HgSendrule实例List
	 * @throws SignaturePersistException
	 */
	List<HgSendrule> getPersonalizeByCustomerId(Integer customerId) throws SignaturePersistException;

	/**
	 * 根据customerId查询HgSendrule个性化策略实例的数量
	 * 
	 * @param customerId
	 *            被叫用户的客户ID
	 * 
	 * @return 个性化策略实例的数量
	 * @throws SignaturePersistException
	 */
	Integer getPersonalizeCountByCustomerId(Integer customerId) throws SignaturePersistException;

	/**
	 * 根据customerId分页查询HgSendrule个性化策略实例
	 * 
	 * @param customerId
	 *            被叫用户的客户ID
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return 查询到的HgSendrule实例List
	 * @throws SignaturePersistException
	 */
	List<HgSendrule> getPersonalizeByCustomerIdForPage(Integer customerId,
			int offSet, int pageSize) throws SignaturePersistException;

}
