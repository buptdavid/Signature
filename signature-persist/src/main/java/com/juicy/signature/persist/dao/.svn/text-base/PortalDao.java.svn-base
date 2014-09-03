/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;


import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Portal;

/**
 * PortalDao接口
 *
 * @author 路卫杰
 * @version <p>Nov 25, 2011 创建</p>
 */
public interface PortalDao {
	
	/**
	 * 根据标识属性来加载Portal实例
	 * 
	 * @param id
	 *            需要加载的Portal实例的标识属性值
	 * @return 指定标识属性对应的Portal实例
	 * @throws SignaturePersistException
	 */
	Portal getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的Portal实例
	 * 
	 * @param portal
	 *            需要被持久化的Portal实例
	 * @return portal 实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(Portal portal) throws SignaturePersistException;

	/**
	 * 修改指定的Portal实例
	 * 
	 * @param portal
	 *            需要被修改的Portal实例
	 * @throws SignaturePersistException
	 */
	void update(Portal portal) throws SignaturePersistException;

	/**
	 * 删除指定的Portal实例
	 * 
	 * @param portal
	 *            需要被删除的Portal实例
	 * @throws SignaturePersistException
	 */
	void delete(Portal portal) throws SignaturePersistException;

	/**
	 * 根据标识属性删除Portal实例
	 * 
	 * @param id
	 *            需要被删除的Portal实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;
	
	/**
	 * 查询数据库中Portal实例
	 * 
	 * @return 数据库中的Portal实例
	 * @throws SignaturePersistException
	 */
	Portal findPortal() throws SignaturePersistException;

}
