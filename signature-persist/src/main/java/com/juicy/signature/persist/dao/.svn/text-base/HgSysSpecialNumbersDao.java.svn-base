/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgSysSpecialNumbers;

/**
 * 系统黑白名单Dao
 *
 * @author 路卫杰
 * @version <p>Dec 29, 2011 创建</p>
 */
public interface HgSysSpecialNumbersDao {
	
	/**
	 * 根据标识属性来加载HgSysSpecialNumbers实例
	 * 
	 * @param id
	 *            需要加载的HgSysSpecialNumbers实例的标识属性值
	 * @return 指定标识属性对应的HgSysSpecialNumbers实例
	 * @throws SignaturePersistException
	 */
	HgSysSpecialNumbers getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的HgSysSpecialNumbers实例
	 * 
	 * @param hgSysSpecialNumbers
	 *            需要被持久化的HgSysSpecialNumbers实例
	 * @return HgSysSpecialNumbers实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(HgSysSpecialNumbers hgSysSpecialNumbers) throws SignaturePersistException;

	/**
	 * 修改指定的HgSysSpecialNumbers实例
	 * 
	 * @param hgSysSpecialNumbers
	 *            需要被修改的HgSysSpecialNumbers实例
	 * @throws SignaturePersistException
	 */
	void update(HgSysSpecialNumbers hgSysSpecialNumbers) throws SignaturePersistException;

	/**
	 * 删除指定的HgSysSpecialNumbers实例
	 * 
	 * @param hgSysSpecialNumbers
	 *            需要被删除的HgSysSpecialNumbers实例
	 * @throws SignaturePersistException
	 */
	void delete(HgSysSpecialNumbers hgSysSpecialNumbers) throws SignaturePersistException;

	/**
	 * 根据标识属性删除HgSysSpecialNumbers实例
	 * 
	 * @param id
	 *            需要被删除的HgSysSpecialNumbers实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的HgSysSpecialNumbers实例
	 * 
	 * @return 数据库中全部的HgSysSpecialNumbers实例
	 * @throws SignaturePersistException
	 */
	List<HgSysSpecialNumbers> findAll() throws SignaturePersistException;
	
	/**
	 * 根据号码查询HgSysSpecialNumbers实例数量
	 * 
	 * @param number
	 *            号码,如果不查询标题则置null或长度为0的字符串
	 * @return HgSysSpecialNumbers实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByNumber(String number) throws SignaturePersistException;

	/**
	 * 根据标题分页查询HgSysSpecialNumbers实例
	 * 
	 * @param number
	 *            号码,如果不查询标题则置null或长度为0的字符串
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return HgSysSpecialNumbers实例List
	 * @throws SignaturePersistException
	 */
	List<HgSysSpecialNumbers> findByNumberForPage(String number, int offSet, int pageSize)
			throws SignaturePersistException;

}
