/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.Date;
import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Activity;

/**
 * ActivityDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 28, 2011 创建
 *          </p>
 */
public interface ActivityDao {

	/**
	 * 根据标识属性来加载Activity实例
	 * 
	 * @param id
	 *            需要加载的Activity实例的标识属性值
	 * @return 指定标识属性对应的HgCustomer实例
	 * @throws SignaturePersistException
	 */
	Activity getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的Activity实例
	 * 
	 * @param activity
	 *            需要被持久化的Activity实例
	 * @return activity 实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(Activity activity) throws SignaturePersistException;

	/**
	 * 修改指定的Activity实例
	 * 
	 * @param activity
	 *            需要被修改的Activity实例
	 * @throws SignaturePersistException
	 */
	void update(Activity activity) throws SignaturePersistException;

	/**
	 * 删除指定的Activity实例
	 * 
	 * @param activity
	 *            需要被删除的Activity实例
	 * @throws SignaturePersistException
	 */
	void delete(Activity activity) throws SignaturePersistException;

	/**
	 * 根据标识属性删除Activity实例
	 * 
	 * @param id
	 *            需要被删除的Activity实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 指定的Activity实例置删除标志位
	 * 
	 * @param activity
	 *            需要被删除的Activity实例
	 * @throws SignaturePersistException
	 */
	void deleteFlag(Activity activity) throws SignaturePersistException;

	/**
	 * 根据标识属性置Activity实例的删除标志位
	 * 
	 * @param id
	 *            需要被删除的Activity实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void deleteFlag(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的Activity实例
	 * 
	 * @return 数据库中全部的Activity实例
	 * @throws SignaturePersistException
	 */
	List<Activity> findAll() throws SignaturePersistException;

	/**
	 * 根据开始时间,结束时间及是否删除查询活动实例数量
	 * 
	 * @param startTime
	 *            活动开始时间,如果为null表示没有开始时间
	 * @param endTime
	 *            活动结束时间，如果为null表示没有结束时间
	 * @param isDelete
	 *            是否删除，如果为null表示忽略
	 * @return 活动实例数量
	 * @throws SignaturePersistException
	 */
	Integer findCount(Date startTime, Date endTime, Boolean isDelete)
			throws SignaturePersistException;

	/**
	 * 根据开始时间,结束时间及是否删除分页查询SignatureCollect实例
	 * 
	 * @param startTime
	 *            活动开始时间,如果为null表示没有开始时间
	 * @param endTime
	 *            活动结束时间，如果为null表示没有结束时间
	 * @param isDelete
	 *            是否删除，如果为null表示忽略
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return 活动实例List
	 * @throws SignaturePersistException
	 */
	List<Activity> findForPage(Date startTime, Date endTime, Boolean isDelete,
			int offSet, int pageSize) throws SignaturePersistException;

	/**
	 * 取得展示在首页的活动
	 * 
	 * @param count
	 *            取得的数量
	 * @return 活动实例List
	 * @throws SignaturePersistException
	 */
	List<Activity> findActivityByIndex(Integer count)
			throws SignaturePersistException;

	/**
	 * 随机取得若干活动
	 * 
	 * @param isDelete 是否删除，如果为null表示不考虑
	 * @param isIndex 是否展示首页，如果为null表示不考虑
	 * @param count 活动的数量
	 * @return 活动实例List
	 * @throws SignaturePersistException
	 */
	List<Activity> findActivityRandom(Boolean isDelete, Boolean isIndex,
			Integer count) throws SignaturePersistException;

}
