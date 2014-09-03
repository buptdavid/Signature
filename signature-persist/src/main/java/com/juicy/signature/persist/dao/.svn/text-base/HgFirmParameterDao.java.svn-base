/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgComboDetail;
import com.juicy.signature.persist.po.HgFirmParameter;
import com.juicy.signature.persist.po.MessageSend;

/**
 * HgFirmParameterDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          Nov 25, 2011 创建
 *          </p>
 */
public interface HgFirmParameterDao {

	/**
	 * 根据标识属性来加载HgFirmParameter实例
	 * 
	 * @param id
	 *            需要加载的HgFirmParameter实例的标识属性值
	 * @return 指定标识属性对应的HgFirmParameter实例
	 * @throws SignaturePersistException
	 */
	HgFirmParameter getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的HgFirmParameter实例
	 * 
	 * @param hgFirmParameter
	 *            需要被持久化的HgFirmParameter实例
	 * @return hgFirmParameter 实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(HgFirmParameter hgFirmParameter)
			throws SignaturePersistException;

	/**
	 * 修改指定的HgFirmParameter实例
	 * 
	 * @param hgFirmParameter
	 *            需要被修改的HgFirmParameter实例
	 * @throws SignaturePersistException
	 */
	void update(HgFirmParameter hgFirmParameter)
			throws SignaturePersistException;

	/**
	 * 删除指定的HgFirmParameter实例
	 * 
	 * @param hgFirmParameter
	 *            需要被删除的HgFirmParameter实例
	 * @throws SignaturePersistException
	 */
	void delete(HgFirmParameter hgFirmParameter)
			throws SignaturePersistException;

	/**
	 * 根据标识属性删除HgFirmParameter实例
	 * 
	 * @param id
	 *            需要被删除的HgFirmParameter实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询数据库中HgFirmParameter实例
	 * 
	 * @return 数据库中的HgFirmParameter实例
	 * @throws SignaturePersistException
	 */
	HgFirmParameter findHgFirmParameter()
			throws SignaturePersistException;

}
