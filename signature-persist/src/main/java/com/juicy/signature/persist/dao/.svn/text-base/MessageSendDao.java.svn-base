/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.MessageSend;

/**
 * MessageSendDao接口
 *
 * @author 路卫杰
 * @version <p>Nov 25, 2011 创建</p>
 */
public interface MessageSendDao {
	
	/**
	 * 根据标识属性来加载MessageSend实例
	 * 
	 * @param id
	 *            需要加载的MessageSend实例的标识属性值
	 * @return 指定标识属性对应的MessageSend实例
	 * @throws SignaturePersistException
	 */
	MessageSend getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的MessageSend实例
	 * 
	 * @param messageSend
	 *            需要被持久化的MessageSend实例
	 * @return messageSend 实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(MessageSend messageSend) throws SignaturePersistException;

	/**
	 * 修改指定的MessageSend实例
	 * 
	 * @param messageSend
	 *            需要被修改的MessageSend实例
	 * @throws SignaturePersistException
	 */
	void update(MessageSend messageSend) throws SignaturePersistException;

	/**
	 * 删除指定的MessageSend实例
	 * 
	 * @param messageSend
	 *            需要被删除的MessageSend实例
	 * @throws SignaturePersistException
	 */
	void delete(MessageSend messageSend) throws SignaturePersistException;

	/**
	 * 根据标识属性删除MessageSend实例
	 * 
	 * @param id
	 *            需要被删除的MessageSend实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;
	
	/**
	 * 查询数据库中MessageSend实例
	 * 
	 * @return 数据库中的MessageSend实例
	 * @throws SignaturePersistException
	 */
	MessageSend findMessageSend() throws SignaturePersistException;
	
}
