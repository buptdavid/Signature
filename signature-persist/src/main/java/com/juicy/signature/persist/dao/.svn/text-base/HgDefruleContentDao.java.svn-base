/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgDefruleContent;

/**
 * HgDefruleContentDao接口
 *
 * @author 路卫杰
 * @version <p>Dec 30, 2011 创建</p>
 */
public interface HgDefruleContentDao {
	
	/**
	 * 保存默认签名
	 * 
	 * @param hgDefruleContent
	 *            默认签名 HgDefruleContent实例对象
	 * @return HgDefruleContent实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save( HgDefruleContent  hgDefruleContent) throws SignaturePersistException;

	/**
	 * 获得默认签名
	 * 
	 * @return  HgDefruleContent实例对象
	 * @throws SignaturePersistException
	 */
	 HgDefruleContent getDefruleContent() throws SignaturePersistException;

	/**
	 * 保存或更新默认签名
	 * 
	 * @param defContent 默认签名
	 * @throws SignaturePersistException
	 */
	void saveOrUpdate(String defContent) throws SignaturePersistException;
	
	/**
	 * 更新默认签名
	 * 
	 * @param hgDefruleContent HgDefruleContent实例对象
	 * @throws SignaturePersistException
	 */
	void update(HgDefruleContent  hgDefruleContent) throws SignaturePersistException;

}
