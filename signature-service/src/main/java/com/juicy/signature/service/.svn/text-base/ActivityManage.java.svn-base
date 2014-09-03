/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.Date;
import java.util.List;

import com.juicy.signature.persist.po.Activity;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 优惠活动管理Service接口
 *
 * @author 路卫杰
 * @version <p>Oct 27, 2011 创建</p>
 */
public interface ActivityManage {
	
	/**
	 * 显示活动
	 * 
	 * @param startTime 活动开始时间，如果为null表示没有开始时间
	 * @param endTime 活动结束时间，如果为null表示没有结束时间
	 * @param isDelete 是否删除，0表示未删除，1表示删除,null表示全部
	 * @param page 分页对象
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewActivity(Date startTime, Date endTime, Boolean isDelete,Page page) throws SignatureServiceException;
	
	/**
	 * 创建活动
	 * 
	 * @param activity Activity活动实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result createActivity(Activity activity) throws SignatureServiceException;
	
	/**
	 * 删除活动
	 * 
	 * @param activities 要删除的活动ID的List
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result deleteActivity(List<Integer> activities) throws SignatureServiceException;
	
	/**
	 * 取消删除活动
	 * 
	 * @param activities 要取消删除的活动ID的List
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result undeleteActivity(List<Integer> activities) throws SignatureServiceException;
	
	/**
	 * 显示修改活动
	 * 
	 * @param activityId 活动ID
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewModify(Integer activityId) throws SignatureServiceException;
	
	/**
	 * 修改活动
	 * 
	 * @param activity 要修改的Activity活动实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result modifyActivity(Activity activity) throws SignatureServiceException;
	
	/**
	 * 设置为首页展示
	 * 
	 * @param activity 要设置为首页展示的Activity活动实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result setIndex(Activity activity) throws SignatureServiceException;
	
	/**
	 * 取消首页展示
	 * 
	 * @param activity 要取消首页显示的Activity活动实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result cancelIndex(Activity activity) throws SignatureServiceException;
	
	

}
