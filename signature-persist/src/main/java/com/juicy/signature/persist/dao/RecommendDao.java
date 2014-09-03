/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Recommend;
import com.juicy.signature.persist.po.SignatureClass;

/**
 * RecommendDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 28, 2011 创建
 *          </p>
 */
public interface RecommendDao {

	/**
	 * 根据标识属性来加载Recommend实例
	 * 
	 * @param id
	 *            需要加载的Recommend实例的标识属性值
	 * @return 指定标识属性对应的Recommend实例
	 * @throws SignaturePersistException
	 */
	Recommend getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的Recommend实例
	 * 
	 * @param recommend
	 *            需要被持久化的Recommend实例
	 * @return recommend 实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(Recommend recommend) throws SignaturePersistException;

	/**
	 * 修改指定的Recommend实例
	 * 
	 * @param recommend
	 *            需要被修改的Recommend实例
	 * @throws SignaturePersistException
	 */
	void update(Recommend recommend) throws SignaturePersistException;

	/**
	 * 删除指定的Recommend实例
	 * 
	 * @param recommend
	 *            需要被删除的Recommend实例
	 * @throws SignaturePersistException
	 */
	void delete(Recommend recommend) throws SignaturePersistException;

	/**
	 * 根据标识属性删除Recommend实例
	 * 
	 * @param id
	 *            需要被删除的Recommend实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 指定的Recommend实例置删除标志位
	 * 
	 * @param recommend
	 *            需要被删除的Recommend实例
	 * @throws SignaturePersistException
	 */
	void deleteFlag(Recommend recommend) throws SignaturePersistException;

	/**
	 * 根据标识属性置Recommend实例的删除标志位
	 * 
	 * @param id
	 *            需要被删除的Recommend实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void deleteFlag(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的Recommend实例
	 * 
	 * @return 数据库中全部的Recommend实例
	 * @throws SignaturePersistException
	 */
	List<Recommend> findAll() throws SignaturePersistException;

	/**
	 * 根据分类,来源及是否删除查询推荐实例数量
	 * 
	 * @param signatureClass
	 *            分类
	 * @param source
	 *            来源，1: 原创情景来源，2: 签名宝库来源，null：表示不区别
	 * @param isDelete
	 *            是否删除，是否删除，如果为null表示忽略
	 * @return 推荐实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCount(SignatureClass signatureClass, Byte source,
			Boolean isDelete) throws SignaturePersistException;

	/**
	 * 根据分类,来源及是否删除分页查询推荐实例
	 * 
	 * @param signatureClass
	 *            分类
	 * @param source
	 *            来源，1: 原创情景来源，2: 签名宝库来源，null：表示不区别
	 * @param isDelete
	 *            是否删除，是否删除，如果为null表示忽略
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return 推荐实例List
	 * @throws SignaturePersistException
	 */
	List<Recommend> findForPage(SignatureClass signatureClass, Byte source,
			Boolean isDelete, int offSet, int pageSize)
			throws SignaturePersistException;
	
	/**
	 * 根据推荐来源查询
	 * 
	 * @param source 推荐来源，1: 原创情景来源；2: 签名宝库来源,如果为null则表示不区分
	 * @param count 需要的数量,如果为null则取得所有
	 * @return 推荐实例List
	 * @throws SignaturePersistException
	 */
	List<Recommend> findBySource(Byte source,Integer count) throws SignaturePersistException;
}
