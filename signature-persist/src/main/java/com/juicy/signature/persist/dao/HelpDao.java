/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Help;

/**
 * HelpDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public interface HelpDao {

	/**
	 * 保存帮助信息
	 * 
	 * @param help
	 *            帮助信息Help实例对象
	 * @return Help实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(Help help) throws SignaturePersistException;

	/**
	 * 获得帮助信息
	 * 
	 * @return Help实例对象
	 * @throws SignaturePersistException
	 */
	Help getHelp() throws SignaturePersistException;

	/**
	 * 保存或更新帮助信息
	 * 
	 * @param content
	 * @throws SignaturePersistException
	 */
	void saveOrUpdate(String content) throws SignaturePersistException;

}
