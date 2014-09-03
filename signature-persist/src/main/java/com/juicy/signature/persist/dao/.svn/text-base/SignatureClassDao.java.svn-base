/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.SignatureClass;

/**
 * SignatureClassDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-27 创建
 *          </p>
 *          <p>
 *          2011-08-03 增加分页查询的功能
 *          </p>
 */
public interface SignatureClassDao {

	/**
	 * 根据标识属性来加载SignatureClass实例
	 * 
	 * @param id
	 *            需要加载的SignatureClass实例的标识属性值
	 * @return 指定标识属性对应的SignatureClass实例
	 * @throws SignaturePersistException
	 */
	SignatureClass getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的SignatureClass实例
	 * 
	 * @param signatureClass
	 *            需要被持久化的SignatureClass实例
	 * @return SignatureClass实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(SignatureClass signatureClass)
			throws SignaturePersistException;

	/**
	 * 修改指定的SignatureClass实例
	 * 
	 * @param signatureClass
	 *            需要被修改的SignatureClass实例
	 * @throws SignaturePersistException
	 */
	void update(SignatureClass signatureClass) throws SignaturePersistException;

	/**
	 * 删除指定的SignatureClass实例
	 * 
	 * @param signatureClass
	 *            需要被删除的SignatureClass实例
	 * @throws SignaturePersistException
	 */
	void delete(SignatureClass signatureClass) throws SignaturePersistException;

	/**
	 * 根据标识属性删除SignatureClass实例
	 * 
	 * @param id
	 *            需要被删除的SignatureClass实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的SignatureClass实例
	 * 
	 * @return 数据库中全部的SignatureClass实例
	 * @throws SignaturePersistException
	 */
	List<SignatureClass> findAll() throws SignaturePersistException;

	/**
	 * 根据分类依据basis查找所有一级类目
	 * 
	 * @param basis
	 *            分类依据
	 * @return SignatureClass实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureClass> findAllFirstByBasis(Byte basis)
			throws SignaturePersistException;

	/**
	 * 根据分类依据basis查找所有二级类目
	 * 
	 * @param basis
	 *            分类依据
	 * @return SignatureClass实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureClass> findAllSecondByBasis(Byte basis)
			throws SignaturePersistException;

	/**
	 * 根据一级分类查找二级分类
	 * 
	 * @param firstId
	 *            一级分类ID
	 * @return SignatureClass实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureClass> findSecondForFirst(Integer firstId)
			throws SignaturePersistException;

	/**
	 * 根据分类依据一级分类ID查找包含有关键字keyWord的二级分类的数量
	 * 
	 * @param basis
	 *            分类依据标识
	 * @param firstClassId
	 *            一级分类ID
	 * @param keyWord
	 *            二级分类所包含的关键字
	 * @return 二级分类的数量
	 * @throws SignaturePersistException
	 */
	Integer findSecondCountByFirstId(Byte basis, Integer firstClassId,
			String keyWord) throws SignaturePersistException;

	/**
	 * 根据分类依据一级分类ID查找包含有关键字keyWord的二级分类
	 * 
	 * @param basis
	 *            分类依据标识
	 * @param firstClassId
	 *            一级分类ID
	 * @param keyWord
	 *            二级分类所包含的关键字
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return 二级分类对象List
	 * @throws SignaturePersistException
	 */
	List<SignatureClass> findSecondByFirstId(Byte basis, Integer firstClassId,
			String keyWord, Integer offSet, Integer pageSize)
			throws SignaturePersistException;

	/**
	 * 根据分类依据随机取得若干一级分类
	 * 
	 * @param basis 分类依据标识,如果为null表示不区分
	 * @param count 要取得的数量
	 * @return 一级分类对象List
	 * @throws SignaturePersistException
	 */
	List<SignatureClass> findFirstRandom(Byte basis,Integer count) throws SignaturePersistException;

}
