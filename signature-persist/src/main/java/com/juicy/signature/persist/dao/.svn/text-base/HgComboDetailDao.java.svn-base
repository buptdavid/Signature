/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgComboDetail;

/**
 * HgComboDetailDao接口
 *
 * @author 路卫杰
 * @version <p>Nov 25, 2011 创建</p>
 */
public interface HgComboDetailDao {
	
	/**
	 * 根据标识属性来加载HgComboDetail实例
	 * 
	 * @param id
	 *            需要加载的HgComboDetail实例的标识属性值
	 * @return 指定标识属性对应的HgComboDetail实例
	 * @throws SignaturePersistException
	 */
	HgComboDetail getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的HgComboDetail实例
	 * 
	 * @param hgComboDetail
	 *            需要被持久化的HgComboDetail实例
	 * @return hgComboDetail 实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(HgComboDetail hgComboDetail) throws SignaturePersistException;

	/**
	 * 修改指定的HgComboDetail实例
	 * 
	 * @param hgComboDetail
	 *            需要被修改的HgComboDetail实例
	 * @throws SignaturePersistException
	 */
	void update(HgComboDetail hgComboDetail) throws SignaturePersistException;

	/**
	 * 删除指定的HgComboDetail实例
	 * 
	 * @param hgComboDetail
	 *            需要被删除的HgComboDetail实例
	 * @throws SignaturePersistException
	 */
	void delete(HgComboDetail hgComboDetail) throws SignaturePersistException;

	/**
	 * 根据标识属性删除HgComboDetail实例
	 * 
	 * @param id
	 *            需要被删除的HgComboDetail实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;
	
	/**
	 * 查询数据库中HgComboDetail实例
	 * 
	 * @return 数据库中的HgComboDetail实例
	 * @throws SignaturePersistException
	 */
	HgComboDetail findHgComboDetail() throws SignaturePersistException;

}
