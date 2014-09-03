/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.SignatureLibrary;

/**
 * SignatureLibraryDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-28 创建
 *          </p>
 *          <p>
 *          2011-08-03 增加分页查询的功能
 *          </p>
 */
public interface SignatureLibraryDao {

	/**
	 * 根据标识属性来加载SignatureLibrary实例
	 * 
	 * @param id
	 *            需要加载的SignatureLibrary实例的标识属性值
	 * @return 指定标识属性对应的SignatureLibrary实例
	 * @throws SignaturePersistException
	 */
	SignatureLibrary getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的SignatureLibrary实例
	 * 
	 * @param signatureLibrary
	 *            需要被持久化的SignatureOriginal实例
	 * @return SignatureLibrary实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(SignatureLibrary signatureLibrary)
			throws SignaturePersistException;

	/**
	 * 修改指定的SignatureLibrary实例
	 * 
	 * @param signatureLibrary
	 *            需要被修改的SignatureLibrary实例
	 * @throws SignaturePersistException
	 */
	void update(SignatureLibrary signatureLibrary)
			throws SignaturePersistException;

	/**
	 * 删除指定的SignatureLibrary实例
	 * 
	 * @param signatureLibrary
	 *            需要被删除的SignatureLibrary实例
	 * @throws SignaturePersistException
	 */
	void delete(SignatureLibrary signatureLibrary)
			throws SignaturePersistException;

	/**
	 * 根据标识属性删除SignatureLibrary实例
	 * 
	 * @param id
	 *            需要被删除的SignatureLibrary实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的SignatureLibrary实例
	 * 
	 * @return 数据库中全部的SignatureLibrary实例
	 * @throws SignaturePersistException
	 */
	List<SignatureLibrary> findAll() throws SignaturePersistException;

	/**
	 * 根据分类ClassId查询SignatureLibrary实例
	 * 
	 * @param classId
	 *            分类ID
	 * @return SignatureLibrary实例
	 * @throws SignaturePersistException
	 */
	List<SignatureLibrary> findByClassId(Integer classId)
			throws SignaturePersistException;

	/**
	 * 根据分类ClassId查询SignatureLibrary实例数量
	 * 
	 * @param classId
	 *            分类ID,如果为null，则查找所有类
	 * @param content
	 *            签名内容
	 * @return SignatureLibrary实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByClassId(Integer classId, String content)
			throws SignaturePersistException;

	/**
	 * 根据分类ClassId分页查询SignatureLibrary实例
	 * 
	 * @param classId
	 *            分类ID,如果为null，则查找所有类
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @param content
	 *            签名内容
	 * @return SignatureLibrary实例
	 * @throws SignaturePersistException
	 */
	List<SignatureLibrary> findByClassIdForPage(Integer classId, int offSet,
			int pageSize, String content) throws SignaturePersistException;

	/**
	 * 根据多个分类ClassId查询SignatureLibrary实例
	 * 
	 * @param classIdList
	 *            多个分类IDList
	 * @return SignatureLibrary实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureLibrary> findByClassIdList(List<Integer> classIdList)
			throws SignaturePersistException;

	/**
	 * 根据多个分类ClassId查询SignatureLibrary实例数量
	 * 
	 * @param classIdList
	 *            多个分类IDList
	 * @param content
	 *            签名内容
	 * @return SignatureLibrary实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByClassIdList(List<Integer> classIdList, String content)
			throws SignaturePersistException;

	/**
	 * 根据多个分类ClassId分页查询SignatureLibrary实例
	 * 
	 * @param classIdList
	 *            多个分类IDList
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @param content
	 *            签名内容
	 * @return SignatureLibrary实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureLibrary> findByClassIdListForPage(List<Integer> classIdList,
			int offSet, int pageSize, String content)
			throws SignaturePersistException;

	/**
	 * 查询包含content内容的SignatureLibrary实例对象数量
	 * 
	 * @param content
	 *            签名内容
	 * @return SignatureLibrary实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCount(String content) throws SignaturePersistException;

	/**
	 * 查询包含content内容的SignatureLibrary实例对象
	 * 
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @param content
	 *            签名内容
	 * @return SignatureLibrary实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureLibrary> findForPage(int offSet, int pageSize, String content)
			throws SignaturePersistException;

	/**
	 * 随机查询若干签名盒签名
	 * 
	 * @param 签名盒签名的数量
	 * @return SignatureLibrary实例List
	 * @throws SignaturePersistException
	 */
	List<SignatureLibrary> findRandom(Integer count) throws SignaturePersistException;

}
