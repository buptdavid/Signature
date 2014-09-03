/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.Date;

import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 统计管理Service接口
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 27, 2011 创建
 *          </p>
 */
public interface StatisticsManage {

	/**
	 * 根据时间和状态显示所有客户
	 * 
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param customerStat 业务状态
	 * @param loginName 用户登录账号手机号
	 * @param cityCode 城市编号
	 * @param page 分页对象
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result handleViewAllCustomer(Date startTime, Date endTime,
			Integer customerStat,String loginName,String cityCode, Page page) throws SignatureServiceException;

	/**
	 * 显示用户登录情况
	 * 
	 * @param loginName 用户账号
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewUserLogin(String loginName)
			throws SignatureServiceException;

	/**
	 * 显示客户状态统计
	 * 
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result handleViewCustomerStatistics(Date startTime,Date endTime) throws SignatureServiceException;
	
	/**
	 * 置用户的业务状态
	 * 
	 * @param customerName 用户账号
	 * @param customerStat 用户状态
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result setCustomerStat(String customerName, Integer customerStat) throws SignatureServiceException;

}
