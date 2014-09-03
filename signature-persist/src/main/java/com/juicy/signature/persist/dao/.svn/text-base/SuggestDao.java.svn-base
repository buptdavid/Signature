/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Suggest;

/**
 * 用户建议SuggestDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-11 创建
 *          </p>
 */
public interface SuggestDao {

	/**
	 * 根据标识属性来加载Suggest实例
	 * 
	 * @param id
	 *            需要加载的Suggest实例的标识属性值
	 * @return 指定标识属性对应的Suggest实例
	 * @throws SignaturePersistException
	 */
	Suggest getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的Suggest实例
	 * 
	 * @param suggest
	 *            需要被持久化的Suggest实例
	 * @return Suggest实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(Suggest suggest) throws SignaturePersistException;

	/**
	 * 修改指定的Suggest实例
	 * 
	 * @param suggest
	 *            需要被修改的Suggest实例
	 * @throws SignaturePersistException
	 */
	void update(Suggest suggest) throws SignaturePersistException;

	/**
	 * 删除指定的Suggest实例
	 * 
	 * @param suggest
	 *            需要被删除的Suggest实例
	 * @throws SignaturePersistException
	 */
	void delete(Suggest suggest) throws SignaturePersistException;

	/**
	 * 根据标识属性删除Suggest实例
	 * 
	 * @param id
	 *            需要被删除的Suggest实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的Suggest实例
	 * 
	 * @return 数据库中全部的Suggest实例
	 * @throws SignaturePersistException
	 */
	List<Suggest> findAll() throws SignaturePersistException;

	/**
	 * 根据标题查询Suggest实例数量
	 * 
	 * @param title
	 *            标题,如果不查询标题则置null或长度为0的字符串
	 * @return Suggest实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByTitle(String title) throws SignaturePersistException;

	/**
	 * 根据标题分页查询Suggest实例
	 * 
	 * @param title
	 *            标题,如果不查询标题则置null或长度为0的字符串
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return Suggest实例List
	 * @throws SignaturePersistException
	 */
	List<Suggest> findByTitleForPage(String title, int offSet, int pageSize)
			throws SignaturePersistException;

}
