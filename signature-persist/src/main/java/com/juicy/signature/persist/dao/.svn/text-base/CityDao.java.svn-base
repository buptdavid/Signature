/**
 * Copyright @ 2011-2012 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.City;

/**
 * CityDao接口
 *
 * @author 路卫杰
 * @version <p>Feb 29, 2012 创建</p>
 */
public interface CityDao {
	
	/**
	 * 根据标识属性来加载City实例
	 * 
	 * @param id
	 *            需要加载的City实例的标识属性值
	 * @return 指定标识属性对应的City实例
	 * @throws SignaturePersistException
	 */
	City getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的City实例
	 * 
	 * @param city
	 *            需要被持久化的City实例
	 * @return City实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(City city) throws SignaturePersistException;

	/**
	 * 修改指定的City实例
	 * 
	 * @param city
	 *            需要被修改的City实例
	 * @throws SignaturePersistException
	 */
	void update(City city) throws SignaturePersistException;

	/**
	 * 删除指定的City实例
	 * 
	 * @param city
	 *            需要被删除的City实例
	 * @throws SignaturePersistException
	 */
	void delete(City city) throws SignaturePersistException;

	/**
	 * 根据标识属性删除City实例
	 * 
	 * @param id
	 *            需要被删除的City实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的City实例
	 * 
	 * @return 数据库中全部的City实例
	 * @throws SignaturePersistException
	 */
	List<City> findAll() throws SignaturePersistException;

}
