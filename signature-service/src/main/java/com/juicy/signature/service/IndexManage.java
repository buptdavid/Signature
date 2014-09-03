/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.List;

import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 首页管理Service接口
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 27, 2011 创建
 *          </p>
 */
public interface IndexManage {

	/**
	 * 显示活动
	 * 
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewActivity() throws SignatureServiceException;

	/**
	 * 取消活动首页显示
	 * 
	 * @param activities
	 *            活动ID的List
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result cancelIndex(List<Integer> activities)
			throws SignatureServiceException;

	/**
	 * 删除活动
	 * 
	 * @param activities
	 *            活动ID的List
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result deleteActivity(List<Integer> activities)
			throws SignatureServiceException;

	/**
	 * 分页显示精彩签名
	 * 
	 * @param isDelete
	 *            是否删除，0表示未删除，1表示删除,null表示全部
	 * @param page
	 *            分页对象
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewLibrary(Boolean isDelete, Page page)
			throws SignatureServiceException;

	/**
	 * 删除精彩签名
	 * 
	 * @param libraries
	 *            精彩签名ID的List
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result deleteLibrary(List<Integer> libraries)
			throws SignatureServiceException;
	
	/**
	 * 分页显示热门话题(随机签名分类)
	 * 
	 * @param page 分页对象
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewHotTopic(Page page) throws SignatureServiceException;
	
	/**
	 * 删除热门话题（从缓存中清除）
	 * 
	 * @param hotTopics 要删除的热门话题ID的List
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result deleteHotTopic(List<Integer> hotTopics) throws SignatureServiceException;
	

	/**
	 * 分页显示情景签名推荐
	 * 
	 * @param isDelete
	 *            是否删除，0表示未删除，1表示删除,null表示全部
	 * @param page
	 *            分页对象
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewOriginal(Boolean isDelete, Page page)
			throws SignatureServiceException;

	/**
	 * 删除情景签名推荐(清除缓存)
	 * 
	 * @param originals
	 *            情景签名推荐ID的List
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result deleteOriginal(List<Integer> originals)
			throws SignatureServiceException;
	
	/**
	 * 显示推荐签名盒(随机签名盒签名)
	 * 
	 * @param page 分页对象
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewLibraryRecommend(Page page) throws SignatureServiceException;
	
	/**
	 * 删除推荐签名盒
	 * 
	 * @param libraries 签名盒签名推荐ID List
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result deleteLibraryRecommend(List<Integer> libraries) throws SignatureServiceException;
	
	/**
	 * 分页显示今日排行榜(随机签名盒签名)
	 * 
	 * @param page
	 *            分页对象
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewRank(Page page) throws SignatureServiceException;
	
	/**
	 * 删除排行榜(清除缓存)
	 * 
	 * @return
	 * @throws SignatureServiceException
	 */
	public Result deleteRank(List<Integer> originals) throws SignatureServiceException;

}
