/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.StUsers;

/**
 * StusersDao接口
 * 
 * @author 路卫杰
 * @version 2011.07.22 创建类
 */
public interface StUsersDao {
	/**
	 * 根据标识属性来加载StUsers实例
	 * 
	 * @param id
	 *            需要加载的StUsers实例的标识属性值
	 * @return 指定标识属性对应的StUsers实例
	 * @throws SignaturePersistException
	 */
	StUsers getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的StUsers实例
	 * 
	 * @param stUsers
	 *            需要被持久化的StUsers实例
	 * @return stUsers实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(StUsers stUsers) throws SignaturePersistException;

	/**
	 * 修改指定的StUsers实例
	 * 
	 * @param stUsers
	 *            需要被修改的StUsers实例
	 * @throws SignaturePersistException
	 */
	void update(StUsers stUsers) throws SignaturePersistException;

	/**
	 * 删除指定的StUsers实例
	 * 
	 * @param stUsers
	 *            需要被删除的StUsers实例
	 * @throws SignaturePersistException
	 */
	void delete(StUsers stUsers) throws SignaturePersistException;

	/**
	 * 根据标识属性删除StUsers实例
	 * 
	 * @param id
	 *            需要被删除的StUsers实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的StUsers实例
	 * 
	 * @return 数据库中全部的StUsers实例
	 * @throws SignaturePersistException
	 */
	List<StUsers> findAll() throws SignaturePersistException;

	/**
	 * 根据登录名称查询StUsers实例
	 * 
	 * @param loginName 登录名
	 * @return 查询的StUsers实例
	 * @throws SignaturePersistException
	 */
	StUsers getByLoginName(String loginName) throws SignaturePersistException;

	/**
	 * 根据登录名称和用户类型查询StUsers实例
	 * 
	 * @param loginName 登录名
	 * @param userType 用户类型,如果为null则不考虑
	 * @return 查询的StUsers实例
	 * @throws SignaturePersistException
	 */
	StUsers getByLoginNameForType(String loginName, Integer userType) throws SignaturePersistException;

}
