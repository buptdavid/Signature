/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgManager;

/**
 * HgManagerDao接口
 *
 * @author 路卫杰
 * @version <p>2011-7-22 创建</p>
 */
public interface HgManagerDao {
	
	/**
	 * 根据标识属性来加载HgManager实例
	 * 
	 * @param id
	 *            需要加载的HgManager实例的标识属性值
	 * @return 指定标识属性对应的HgManager实例
	 * @throws SignaturePersistException
	 */
	HgManager getById(Integer id) throws SignaturePersistException;
	
	/**
	 * 持久化指定的HgManager实例
	 * 
	 * @param hgManager
	 *            需要被持久化的HgManager实例
	 * @return hgManager实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(HgManager HgManager) throws SignaturePersistException;
	
	/**
	 * 修改指定的HgManager实例
	 * 
	 * @param HgManager
	 *            需要被修改的HgManager实例
	 * @throws SignaturePersistException
	 */
	void update(HgManager hgManager) throws SignaturePersistException;

	/**
	 * 删除指定的HgManager实例
	 * 
	 * @param hgManager
	 *            需要被删除的HgManager实例
	 * @throws SignaturePersistException
	 */
	void delete(HgManager hgManager) throws SignaturePersistException;
	
	/**
	 * 根据标识属性删除HgManager实例
	 * 
	 * @param id
	 *            需要被删除的HgManager实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;
	
	/**
	 * 查询全部的HgManager实例
	 * 
	 * @return 数据库中全部的HgManager实例
	 * @throws SignaturePersistException
	 */
	List<HgManager> findAll() throws SignaturePersistException;
	
}
