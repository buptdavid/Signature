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
 * 客户相关的管理Service
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-26 创建
 *          </p>
 */
public interface CustomerService {

	/**
	 * 定时检查客户的体验是否过期，如果过期则置位为已过期。
	 * 
	 * @return  Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result checkExperience() throws SignatureServiceException;

	/**
	 * 分页显示客户
	 * 
	 * @param startTime 开始时间,如果为null表示没有开始时间
	 * @param endTime 结束时间，如果为null表示没有结束时间
	 * @param customerStat 客户订购状态，如果为null表示所有客户
	 * @param page 分页信息对象
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result view(Date startTime, Date endTime,Integer customerStat, Page page)
			throws SignatureServiceException;
	
	/**
	 * 统计一定时间段内生效的客户数量
	 * 
	 * @param startTime 开始时间,如果为null表示没有开始时间
	 * @param endTime 结束时间，如果为null表示没有结束时间
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result statistic(Date startTime, Date endTime) throws SignatureServiceException;

}
