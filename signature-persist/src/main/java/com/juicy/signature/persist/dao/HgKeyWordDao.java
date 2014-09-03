/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgKeyWord;

/**
 * HgKeyWordDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-10 创建
 *          </p>
 */
public interface HgKeyWordDao {

	/**
	 * 根据标识属性来加载HgKeyWord实例
	 * 
	 * @param id
	 *            需要加载的HgKeyWord实例的标识属性值
	 * @return 指定标识属性对应的HgKeyWord实例
	 * @throws SignaturePersistException
	 */
	HgKeyWord getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的HgKeyWord实例
	 * 
	 * @param hgKeyWord
	 *            需要被持久化的HgKeyWord实例
	 * @return HgKeyWord实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(HgKeyWord hgKeyWord) throws SignaturePersistException;

	/**
	 * 修改指定的HgKeyWord实例
	 * 
	 * @param hgKeyWord
	 *            需要被修改的HgKeyWord实例
	 * @throws SignaturePersistException
	 */
	void update(HgKeyWord hgKeyWord) throws SignaturePersistException;

	/**
	 * 删除指定的HgKeyWord实例
	 * 
	 * @param hgKeyWord
	 *            需要被删除的HgKeyWord实例
	 * @throws SignaturePersistException
	 */
	void delete(HgKeyWord hgKeyWord) throws SignaturePersistException;

	/**
	 * 根据标识属性删除HgKeyWord实例
	 * 
	 * @param id
	 *            需要被删除的HgKeyWord实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的HgKeyWord实例
	 * 
	 * @return 数据库中全部的HgKeyWord实例
	 * @throws SignaturePersistException
	 */
	List<HgKeyWord> findAll() throws SignaturePersistException;

	/**
	 * 根据关键字查询HgKeyWord实例数量
	 * 
	 * @param content
	 *            关键字内容
	 * @return HgKeyWord实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByContent(String content) throws SignaturePersistException;

	/**
	 * 根据关键字分页查询HgKeyWord实例
	 * 
	 * @param content
	 *            关键字内容
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return HgKeyWord实例List
	 * @throws SignaturePersistException
	 */
	List<HgKeyWord> findByContentForPage(String content, int offSet, int pageSize)
			throws SignaturePersistException;
	
	/**
	 * 根据内容content完全查询HgKeyWord实例
	 * 
	 * @param content 内容
	 * @return HgKeyWord实例List
	 * @throws SignaturePersistException
	 */
	List<HgKeyWord> findBycontent(String content) throws SignaturePersistException;
}
