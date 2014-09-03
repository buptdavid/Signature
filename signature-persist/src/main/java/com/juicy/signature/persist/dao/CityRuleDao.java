/**
 * Copyright @ 2011-2012 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.CityRule;

/**
 * CityRuleDao接口
 *
 * @author 路卫杰
 * @version <p>Feb 29, 2012 创建</p>
 */
public interface CityRuleDao {
	
	/**
	 * 根据标识属性来加载CityRule实例
	 * 
	 * @param id
	 *            需要加载的CityRule实例的标识属性值
	 * @return 指定标识属性对应的CityRule实例
	 * @throws SignaturePersistException
	 */
	CityRule getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的CityRule实例
	 * 
	 * @param cityRule
	 *            需要被持久化的CityRule实例
	 * @return CityRule实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(CityRule cityRule) throws SignaturePersistException;

	/**
	 * 修改指定的CityRule实例
	 * 
	 * @param cityRule
	 *            需要被修改的CityRule实例
	 * @throws SignaturePersistException
	 */
	void update(CityRule cityRule) throws SignaturePersistException;

	/**
	 * 删除指定的CityRule实例
	 * 
	 * @param cityRule
	 *            需要被删除的CityRule实例
	 * @throws SignaturePersistException
	 */
	void delete(CityRule cityRule) throws SignaturePersistException;

	/**
	 * 根据标识属性删除CityRule实例
	 * 
	 * @param id
	 *            需要被删除的CityRule实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的CityRule实例
	 * 
	 * @return 数据库中全部的CityRule实例
	 * @throws SignaturePersistException
	 */
	List<CityRule> findAll() throws SignaturePersistException;
}
