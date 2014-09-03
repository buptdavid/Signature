/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.List;

import com.juicy.signature.persist.po.HgSpecialNumbers;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * 名单处理业务逻辑接口，包括黑名单，白名单和拒绝签名.
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-8 创建
 *          </p>
 */
public interface ListService {

	/**
	 * 更新数据库中黑白名单标识
	 * 
	 * @param user
	 *            用户基本信息实例
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result updateBlackWhite(User user) throws SignatureServiceException;

	/**
	 * 创建黑名单
	 * 
	 * @param hgSpecialNumbersList
	 *            黑名单对象List
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result createBlackList(List<HgSpecialNumbers> hgSpecialNumbersList)
			throws SignatureServiceException;

	/**
	 * 分页查询黑名单
	 * 
	 * @param user
	 *            用户基本信息实例对象
	 * @param page
	 *            分页信息Page实例对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getBlackList(User user, Page page)
			throws SignatureServiceException;

	/**
	 * 创建白名单
	 * 
	 * @param hgSpecialNumbersList
	 *            白名单对象List
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result createWhiteList(List<HgSpecialNumbers> hgSpecialNumbersList)
			throws SignatureServiceException;

	/**
	 * 分页获取用户的白名单
	 * 
	 * @param user
	 *            用户基本信息对象
	 * @param page
	 *            分页信息Page对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getWhiteList(User user, Page page)
			throws SignatureServiceException;

	/**
	 * 创建拒绝签名名单
	 * 
	 * @param user 用户基本信息实例对象
	 * @param hgSpecialNumbers 拒绝签名实例对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result createRefuseList(User user,HgSpecialNumbers hgSpecialNumbers)
			throws SignatureServiceException;

	/**
	 * 分页查询用户的拒绝签名名单
	 * 
	 * @param user
	 *            用户基本信息实例对象
	 * @param page
	 *            分页信息实例对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getRefuseList(User user, Page page)
			throws SignatureServiceException;

	/**
	 * 删除名单
	 * 
	 * @param hgSpecialNumbersIdList
	 *            HgSpecialNumbers实例对象ID List
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result deleteList(List<Integer> hgSpecialNumbersIdList)
			throws SignatureServiceException;

}
