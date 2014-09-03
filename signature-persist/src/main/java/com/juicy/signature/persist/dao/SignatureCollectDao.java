/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.SignatureCollect;

/**
 * SignatureCollectDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-28 创建
 *          </p>
 *          <p>
 *          2011-08-03 增加分页查询的功能
 *          </p>
 */
public interface SignatureCollectDao {

	/**
	 * 根据标识属性来加载SignatureCollect实例
	 * 
	 * @param id
	 *            需要加载的SignatureCollect实例的标识属性值
	 * @return 指定标识属性对应的SignatureCollect实例
	 * @throws SignaturePersistException
	 */
	SignatureCollect getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的SignatureCollect实例
	 * 
	 * @param signatureCollect
	 *            需要被持久化的SignatureCollect实例
	 * @return SignatureCollect实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(SignatureCollect signatureCollect)
			throws SignaturePersistException;

	/**
	 * 修改指定的SignatureCollect实例
	 * 
	 * @param signatureCollect
	 *            需要被修改的SignatureCollect实例
	 * @throws SignaturePersistException
	 */
	void update(SignatureCollect signatureCollect)
			throws SignaturePersistException;

	/**
	 * 删除指定的SignatureCollect实例
	 * 
	 * @param signatureCollect
	 *            需要被删除的SignatureCollect实例
	 * @throws SignaturePersistException
	 */
	void delete(SignatureCollect signatureCollect)
			throws SignaturePersistException;

	/**
	 * 根据标识属性删除SignatureCollect实例
	 * 
	 * @param id
	 *            需要被删除的SignatureCollect实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的SignatureCollect实例
	 * 
	 * @return 数据库中全部的SignatureCollect实例
	 * @throws SignaturePersistException
	 */
	List<SignatureCollect> findAll() throws SignaturePersistException;

	/**
	 * 根据customerId和classId查询SignatureCollect实例数量
	 * 
	 * @param customerId
	 *            客户ID
	 * @param classId
	 *            分类ID
	 * @return SignatureCollect实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByCustomerIdAndClassId(Integer customerId, Integer classId)
			throws SignaturePersistException;

	/**
	 * 根据customerId和classId分页查询SignatureCollect实例
	 * 
	 * @param customerId
	 *            客户ID
	 * @param classId
	 *            分类ID,如果查询全部，则置null
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return SignatureCollect实例
	 * @throws SignaturePersistException
	 */
	List<SignatureCollect> findByCustomerIdAndClassIdForPage(
			Integer customerId, Integer classId, int offSet, int pageSize)
			throws SignaturePersistException;

	/**
	 * 根据customerId查询签名宝库SignatureCollect实例
	 * 
	 * @param customerId
	 *            客户ID
	 * @return SignatureCollect实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureCollect> findLibraryByCustomerId(Integer customerId)
			throws SignaturePersistException;

	/**
	 * 根据customerId查询签名宝库SignatureCollect实例数量
	 * 
	 * @param customerId
	 *            客户ID
	 * @return SignatureCollect实例数量
	 * @throws SignaturePersistException
	 */
	Integer findLibraryCountByCustomerId(Integer customerId)
			throws SignaturePersistException;

	/**
	 * 根据customerId分页查询签名宝库SignatureCollect实例
	 * 
	 * @param customerId
	 *            客户ID
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return SignatureCollect实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureCollect> findLibraryByCustomerIdForPage(Integer customerId,
			int offSet, int pageSize) throws SignaturePersistException;

	/**
	 * 根据customerId和父分类ID查询签名宝库SignatureCollect实例数量,如果keyWord不为空，
	 * 则实例中的分类名称应该包含keyWord
	 * 
	 * @param customerId
	 *            客户ID
	 * @param parentId
	 *            父分类ID
	 * @param keyWord
	 *            二级分类所包含的关键字
	 * @return SignatureCollect实例数量
	 * @throws SignaturePersistException
	 */
	Integer findLibraryCountByCustomerIdAndParent(Integer customerId,
			Integer parentId, String keyWord) throws SignaturePersistException;

	/**
	 * 根据customerId和父分类ID查询签名宝库SignatureCollect实例,如果keyWord不为空，
	 * 则实例中的分类名称应该包含keyWord
	 * 
	 * @param customerId
	 *            客户ID
	 * @param parentId
	 *            父分类ID
	 * @param keyWord
	 *            二级分类所包含的关键字
	 * @param offSet
	 *            第一条记录索引,该参数没用
	 * @param pageSize
	 *            每页记录数量，该参数没用
	 * @return SignatureCollect实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureCollect> findLibraryByCustomerIdAndParentForPage(
			Integer customerId, Integer parentId, String keyWord, int offSet,
			int pageSize) throws SignaturePersistException;

	/**
	 * 根据customerId查询原创SignatureCollect实例
	 * 
	 * @param customerId
	 *            客户ID
	 * @return SignatureCollect实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureCollect> findOriginalByCustomerId(Integer customerId)
			throws SignaturePersistException;

	/**
	 * 根据customerId查询原创SignatureCollect实例数量
	 * 
	 * @param customerId
	 *            客户ID
	 * @return SignatureCollect实例数量
	 * @throws SignaturePersistException
	 */
	Integer findOriginalCountByCustomerId(Integer customerId)
			throws SignaturePersistException;

	/**
	 * 根据customerId分页查询原创SignatureCollect实例
	 * 
	 * @param customerId
	 *            客户ID
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return SignatureCollect实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureCollect> findOriginalByCustomerIdForPage(Integer customerId,
			int offSet, int pageSize) throws SignaturePersistException;
}
