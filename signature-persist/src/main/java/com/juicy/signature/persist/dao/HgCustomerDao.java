/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao;

import java.util.Date;
import java.util.List;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;

/**
 * HgCustomerDao接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-25 创建
 *          </p>
 *          <p>
 *          2011-11-07 增加方法findCountByStat，findByStatForPage
 *          </p>
 */
public interface HgCustomerDao {

	/**
	 * 根据标识属性来加载HgCustomer实例
	 * 
	 * @param id
	 *            需要加载的HgCustomer实例的标识属性值
	 * @return 指定标识属性对应的HgCustomer实例
	 * @throws SignaturePersistException
	 */
	HgCustomer getById(Integer id) throws SignaturePersistException;

	/**
	 * 持久化指定的HgCustomer实例
	 * 
	 * @param hgCustomer
	 *            需要被持久化的HgCustomer实例
	 * @return hgCustomer实例被持久化后的标识属性值
	 * @throws SignaturePersistException
	 */
	Integer save(HgCustomer hgCustomer) throws SignaturePersistException;

	/**
	 * 修改指定的HgCustomer实例
	 * 
	 * @param hgCustomer
	 *            需要被修改的HgCustomer实例
	 * @throws SignaturePersistException
	 */
	void update(HgCustomer hgCustomer) throws SignaturePersistException;

	/**
	 * 删除指定的HgCustomer实例
	 * 
	 * @param hgCustomer
	 *            需要被删除的HgCustomer实例
	 * @throws SignaturePersistException
	 */
	void delete(HgCustomer hgCustomer) throws SignaturePersistException;

	/**
	 * 根据标识属性删除HgCustomer实例
	 * 
	 * @param id
	 *            需要被删除的HgCustomer实例的标识属性值
	 * @throws SignaturePersistException
	 */
	void delete(Integer id) throws SignaturePersistException;

	/**
	 * 查询全部的HgCustomer实例
	 * 
	 * @return 数据库中全部的HgCustomer实例
	 * @throws SignaturePersistException
	 */
	List<HgCustomer> findAll() throws SignaturePersistException;

	/**
	 * 根据UserId查询HgCustomer实例
	 * 
	 * @param userId
	 *            用户ID
	 * 
	 * @return 查询到的HgCustomer实例
	 * @throws SignaturePersistException
	 */
	HgCustomer getByUserId(Integer userId) throws SignaturePersistException;

	/**
	 * 根据客户的订购业务状态查找用户
	 * 
	 * @param customerStat
	 *            客户的订购状态
	 * @return 查询到的HgCustomer实例List
	 * @throws SignaturePersistException
	 */
	List<HgCustomer> findByStat(Integer customerStat)
			throws SignaturePersistException;
	
	/**
	 * 根据客户名称（手机号）查询HgCustomer实例对象
	 * 
	 * @param customerName
	 *            客户名称（手机号）
	 * @return HgCustomer实例对象
	 * @throws SignaturePersistException
	 */
	HgCustomer getByCustomerName(String customerName)
			throws SignaturePersistException;
		
	/**
	 * 查询时间范围内customerStat订购状态的客户数量
	 * 
	 * @param startTime
	 *            开始时间,如果为null表示没有开始时间
	 * @param endTime
	 *            结束时间，如果为null表示没有结束时间
	 * @param customerStat
	 *            客户订购状态，如果为null则不考虑
	 * @param customerName
	 * 			  客户手机号码,如果为null则不考虑
	 * @return 客户数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByStat(Date startTime, Date endTime, Integer customerStat, String customerName)
			throws SignaturePersistException;

	/**
	 * 分页查询时间范围内customerStat订购状态的客户
	 * 
	 * @param startTime 开始时间,如果为null表示没有开始时间
	 * @param endTime  结束时间，如果为null表示没有结束时间
	 * @param customerStat
	 *            客户订购状态，如果为null则不考虑
	 * @param customerName
	 * 			  客户手机号码，如果为null则不考虑
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return 查询的HgCustomer实例对象List
	 * @throws SignaturePersistException
	 */
	List<HgCustomer> findByStatForPage(Date startTime, Date endTime,
			Integer customerStat, String customerName, int offSet, int pageSize)
			throws SignaturePersistException;
	
	
	/**
	 * 查询时间范围内customerStat订购状态的客户数量
	 * 
	 * @param startTime
	 *            开始时间,如果为null表示没有开始时间
	 * @param endTime
	 *            结束时间，如果为null表示没有结束时间
	 * @param customerStat
	 *            客户订购状态，如果为null则不考虑
	 * @param customerName
	 * 			  客户手机号码,如果为null则不考虑
	 * @param cityCode 城市编号
	 * @return 客户数量
	 * @throws SignaturePersistException
	 */
	Integer findCountByStatAndCity(Date startTime, Date endTime, Integer customerStat, String customerName, String cityCode)
			throws SignaturePersistException;

	/**
	 * 分页查询时间范围内customerStat订购状态的客户
	 * 
	 * @param startTime 开始时间,如果为null表示没有开始时间
	 * @param endTime  结束时间，如果为null表示没有结束时间
	 * @param customerStat
	 *            客户订购状态，如果为null则不考虑
	 * @param customerName
	 * 			  客户手机号码，如果为null则不考虑
	 * @param cityCode 城市编号
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页记录数量
	 * @return 查询的HgCustomer实例对象List
	 * @throws SignaturePersistException
	 */
	List<HgCustomer> findByStatAndCityForPage(Date startTime, Date endTime,
			Integer customerStat, String customerName, String cityCode , int offSet, int pageSize)
			throws SignaturePersistException;
	
	/**
	 * 查找没有城市区号的HgCustomer对象
	 * 
	 * @return 没有城市区号的HgCustomer对象
	 * @throws SignaturePersistException
	 */
	List<HgCustomer> findNoCode() throws SignaturePersistException;

}
