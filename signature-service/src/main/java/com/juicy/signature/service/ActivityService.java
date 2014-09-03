/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.result.Result;

/**
 * 活动Service接口
 * 
 * @author 路卫杰
 * @version <p>
 *          Nov 1, 2011 创建
 *          </p>
 */
public interface ActivityService {

	/**
	 * 显示所有展示在页面的活动
	 * 
	 * @param showCount 展示活动的数量
	 * @param recommendCount 推荐活动的数量
	 * @param wonderfulCount 精彩活动的数量
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewAll(Integer showCount, Integer recommendCount, Integer wonderfulCount)
			throws SignatureServiceException;

	/**
	 * 取得某个活动
	 * 
	 * @param activityId 活动ID
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result view(Integer activityId) throws SignatureServiceException;

}
