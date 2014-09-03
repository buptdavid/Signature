/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.Date;
import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgDiyInfo;

/**
 * HgDiyInfoDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-27 创建
 *          </p>
 *          <p>
 *          2011-08-03 增加分页查询的功能
 *          </p>
 *          <p>
 *          2011-10-11 增加查询客户某时间后的默认签名自定义信息数量方法findCountDefaultForTime
 *          </p>
 */
public interface HgDiyInfoDao {

	/**
	 * 根据标识属性来加载HgDiyInfo实例
	 * 
	 * @param id
	 *            需要加载的HgDiyInfo实例的标识属性值
	 * @return 指定标识属性对应的HgDiyInfo实例
	 * @throws SignaturePersistException
	 */
	HgDiyInfo getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的HgDiyInfo实例
	 * 
	 * @param hgDiyInfo
	 *            需要被持久化的HgDiyInfo实例
	 * @return HgDiyInfo实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(HgDiyInfo hgDiyInfo) throws SignaturePersistException;

	/**
	 * 修改指定的HgDiyInfo实例
	 * 
	 * @param hgDiyInfo
	 *            需要被修改的HgDiyInfo实例
	 * @throws SignaturePersistException
	 */
	void update(HgDiyInfo hgDiyInfo) throws SignaturePersistException;

	/**
	 * 删除指定的HgDiyInfo实例
	 * 
	 * @param hgDiyInfo
	 *            需要被删除的HgDiyInfo实例
	 * @throws SignaturePersistException
	 */
	void delete(HgDiyInfo hgDiyInfo) throws SignaturePersistException;

	/**
	 * 根据标识属性删除HgDiyInfo实例
	 * 
	 * @param id
	 *            需要被删除的HgDiyInfo实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的HgDiyInfo实例
	 * 
	 * @return 数据库中全部的HgDiyInfo实例
	 * @throws SignaturePersistException
	 */
	List<HgDiyInfo> findAll() throws SignaturePersistException;

	/**
	 * 根据顾客ID查询HgDiyInfo实例
	 * 
	 * @param customerId
	 *            客户ID
	 * @return HgDiyInfo实例List
	 * @throws SignaturePersistException
	 */
	List<HgDiyInfo> findByCustomerId(Integer customerId)
			throws SignaturePersistException;

	/**
	 * 根据客户ID查询HgDiyInfo实例数量
	 * 
	 * @param customerId
	 *            客户ID
	 * @return HgDiyInfo实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByCustomerId(Integer customerId)
			throws SignaturePersistException;

	/**
	 * 根据客户ID分页查询HgDiyInfo实例
	 * 
	 * @param customerId
	 *            客户ID
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return HgDiyInfo实例List
	 * @throws SignaturePersistException
	 */
	List<HgDiyInfo> findByCustomerIdForPage(Integer customerId, int offSet,
			int pageSize) throws SignaturePersistException;

	/**
	 * 根据客户ID和是否默认签名标志查询HgDiyInfo实例
	 * 
	 * @param customerId
	 *            客户ID
	 * @param isDefault
	 *            是否默认签名。0：不是；1：是
	 * @return HgDiyInfo实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByCustomerId(Integer customerId, Byte isDefault)
			throws SignaturePersistException;

	/**
	 * 根据客户ID和是否默认签名标志分页查询HgDiyInfo实例
	 * 
	 * @param customerId
	 *            客户ID
	 * @param isDefault
	 *            是否默认签名。0：不是；1：是
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return HgDiyInfo实例List
	 * @throws SignaturePersistException
	 */
	List<HgDiyInfo> findByCustomerIdForPage(Integer customerId, Byte isDefault,
			int offSet, int pageSize) throws SignaturePersistException;
	
	/**
	 * 查询客户date时间以来默认签名的自定义信息的数量，如果date为null则查询该客户所有默认签名自定义信息数量
	 * 
	 * @param customerId 客户ID
	 * @param date 查询时间点
	 * @return date时间以来默认签名的自定义信息的数量
	 * @throws SignaturePersistException
	 */
	Integer findCountDefaultForTime(Integer customerId,Date date) throws SignaturePersistException;
	
	/**
	 * 将默认签名为preContent的修改为签名content
	 * 
	 * @param preContent 被修改的签名
	 * @param content 需要修改成的签名
	 * @return 更改的记录数量
	 * @throws SignaturePersistException
	 */
	Integer updateContent(String preContent, String content) throws SignaturePersistException;

}
