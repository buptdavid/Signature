/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.Date;
import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.SignatureOriginal;

/**
 * SignatureOriginalDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-27 创建
 *          </p>
 *          <p>
 *          2011-08-03 增加分页查询的功能
 *          </p>
 */
public interface SignatureOriginalDao {

	/**
	 * 根据标识属性来加载SignatureOriginal实例
	 * 
	 * @param id
	 *            需要加载的SignatureOriginal实例的标识属性值
	 * @return 指定标识属性对应的SignatureOriginal实例
	 * @throws SignaturePersistException
	 */
	SignatureOriginal getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的SignatureOriginal实例
	 * 
	 * @param signatureOriginal
	 *            需要被持久化的SignatureOriginal实例
	 * @return SignatureOriginal实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(SignatureOriginal signatureOriginal)
			throws SignaturePersistException;

	/**
	 * 修改指定的SignatureOriginal实例
	 * 
	 * @param signatureOriginal
	 *            需要被修改的SignatureOriginal实例
	 * @throws SignaturePersistException
	 */
	void update(SignatureOriginal signatureOriginal)
			throws SignaturePersistException;

	/**
	 * 删除指定的SignatureOriginal实例
	 * 
	 * @param signatureOriginal
	 *            需要被删除的SignatureOriginal实例
	 * @throws SignaturePersistException
	 */
	void delete(SignatureOriginal signatureOriginal)
			throws SignaturePersistException;

	/**
	 * 根据标识属性删除SignatureOriginal实例
	 * 
	 * @param id
	 *            需要被删除的SignatureOriginal实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的SignatureOriginal实例
	 * 
	 * @return 数据库中全部的SignatureOriginal实例
	 * @throws SignaturePersistException
	 */
	List<SignatureOriginal> findAll() throws SignaturePersistException;

	/**
	 * 根据分类ClassId,isPublish和auditStatus查询SignatureOriginal实例
	 * 
	 * @param classId
	 *            分类Id
	 * @param publish
	 *            是否公开
	 * @param auditStatus
	 *            审核状态
	 * @param content
	 *            签名内容
	 * @return SignatureOriginal实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureOriginal> findByCustomerId(Integer customerId,
			Boolean publish, Byte auditStatus, String content)
			throws SignaturePersistException;

	/**
	 * 查询根据分类ClassId,isPublish和auditStatus查询SignatureOriginal实例的数量
	 * 
	 * @param customerId
	 *            客户ID
	 * @param publish
	 *            是否公开
	 * @param auditStatus
	 *            审核状态
	 * @param content
	 *            签名内容
	 * @return SignatureOriginal实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByCustomerId(Integer customerId, Boolean publish,
			Byte auditStatus, String content) throws SignaturePersistException;

	/**
	 * 根据分类customerId,isPublish和auditStatus分页查询SignatureOriginal实例
	 * 
	 * @param customerId
	 *            客户ID
	 * @param publish
	 *            是否公开
	 * @param auditStatus
	 *            审核状态
	 * @param content
	 *            签名内容
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return SignatureOriginal实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureOriginal> findByCustomerIdForPage(Integer customerId,
			Boolean publish, Byte auditStatus, String content, int offSet,
			int pageSize) throws SignaturePersistException;

	/**
	 * 根据分类ClassId,isPublish和auditStatus查询SignatureOriginal实例
	 * 
	 * @param classId
	 *            分类Id,如果为null,则查找所有分类
	 * @param publish
	 *            是否公开
	 * @param auditStatus
	 *            审核状态
	 * @return SignatureOriginal实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureOriginal> findByClassId(Integer classId, Boolean publish,
			Byte auditStatus) throws SignaturePersistException;

	/**
	 * 查询根据分类ClassId,isPublish和auditStatus查询SignatureOriginal实例的数量
	 * 
	 * @param classId
	 *            分类Id,如果为null,则查找所有分类
	 * @param publish
	 *            是否公开
	 * @param auditStatus
	 *            审核状态
	 * @return SignatureOriginal实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByClassId(Integer classId, Boolean publish,
			Byte auditStatus) throws SignaturePersistException;

	/**
	 * 根据分类ClassId,isPublish和auditStatus分页查询SignatureOriginal实例
	 * 
	 * @param classId
	 *            分类Id,如果为null，则表示查找所有分类
	 * @param publish
	 *            是否公开
	 * @param auditStatus
	 *            审核状态
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return SignatureOriginal实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureOriginal> findByClassIdForPage(Integer classId,
			Boolean publish, Byte auditStatus, int offSet, int pageSize)
			throws SignaturePersistException;

	/**
	 * 根据多个分类ClassId查询SignatureOriginal实例
	 * 
	 * @param classIdList
	 *            多个分类IDList
	 * @param publish
	 *            是否公开
	 * @param auditStatus
	 *            审核状态
	 * @return SignatureOriginal实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureOriginal> findByClassIdList(List<Integer> classIdList,
			Boolean publish, Byte auditStatus) throws SignaturePersistException;

	/**
	 * 根据多个分类ClassId查询SignatureOriginal实例的数量
	 * 
	 * @param classIdList
	 *            多个分类IDList
	 * @param publish
	 *            是否公开
	 * @param auditStatus
	 *            审核状态
	 * @return SignatureOriginal实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByClassIdList(List<Integer> classIdList, Boolean publish,
			Byte auditStatus) throws SignaturePersistException;

	/**
	 * 根据多个分类ClassId查询SignatureOriginal实例
	 * 
	 * @param classIdList
	 *            多个分类IDList
	 * @param publish
	 *            是否公开
	 * @param auditStatus
	 *            审核状态
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return SignatureOriginal实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureOriginal> findByClassIdList(List<Integer> classIdList,
			Boolean publish, Byte auditStatus, int offSet, int pageSize)
			throws SignaturePersistException;

	/**
	 * 搜索含有content内容的签名
	 * 
	 * @param content
	 *            签名内容
	 * @return SignatureOriginal实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureOriginal> findByContent(String content)
			throws SignaturePersistException;

	/**
	 * 搜索含有content内容的签名的数量
	 * 
	 * @param content
	 *            签名内容
	 * @param publish
	 *            是否公开，如果不考虑则置空
	 * @param auditStatus
	 *            审核状态，如果不考虑则置空
	 * @return SignatureOriginal实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByContent(String content, Boolean publish, Byte auditStatus)
			throws SignaturePersistException;

	/**
	 * 分页搜索含有content内容的签名
	 * 
	 * @param content
	 *            签名内容
	 * @param publish
	 *            是否公开，如果不考虑则置空
	 * @param auditStatus
	 *            审核状态，如果不考虑则置空
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return SignatureOriginal实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureOriginal> findByContentForPage(String content,
			Boolean publish, Byte auditStatus, int offSet, int pageSize)
			throws SignaturePersistException;
	
	/**
	 * 查询客户date时间以来创建的原创签名的数量，如果date为null则查询该客户所有原创签名的数量
	 * 
	 * @param customerId 客户ID
	 * @param date 查询时间点
	 * @return 客户date时间以来创建的原创签名的数量
	 * @throws SignaturePersistException
	 */
	Integer findCountForTime(Integer customerId,Date date) throws SignaturePersistException;

	
	/**
	 * 取得最新提交的原创签名
	 * 
	 * @param publish 是否公开，true表示公开，false表示不公开，null表示不区分
	 * @param auditStatus 审核状态，null表示不考虑
	 * @param count 需要的数量
	 * @return 原创签名List
	 * @throws SignaturePersistException
	 */
	List<SignatureOriginal> findNew(Boolean publish,Byte auditStatus,Integer count) throws SignaturePersistException;

	/**
	 * 随机取得若干原创签名
	 * 
	 * @param publish 是否公开，true表示公开，false表示不公开，null表示不区分
	 * @param auditStatus 审核状态，null表示不考虑
	 * @param count 需要的数量
	 * @return 原创签名List
	 * @throws SignaturePersistException
	 */
	List<SignatureOriginal> findRandom(Boolean publish,Byte auditStatus,Integer count) throws SignaturePersistException;
	
}
