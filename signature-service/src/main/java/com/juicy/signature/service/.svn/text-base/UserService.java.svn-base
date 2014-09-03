/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import com.juicy.signature.persist.po.StUsers;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * 用户账号相关的Service，包括登录，注销等
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public interface UserService {

	/**
	 * 采用密码登陆的方法
	 * 
	 * @param loginName
	 *            用户名
	 * @param password
	 *            密码
	 * @return Result实例对象
	 */
	public Result loginByPassword(String loginName, String password)
			throws SignatureServiceException;

	/**
	 * 采用短信验证码登陆的方法
	 * 
	 * @param loginName
	 *            用户名
	 * @param verfityCode
	 *            短信验证码
	 * @return Result实例对象
	 */
	public Result loginByVerfityCode(String loginName, String verfityCode)
			throws SignatureServiceException;

	/**
	 * 生成短信验证码
	 * 
	 * @param loginName
	 *            用户名
	 * @return Result实例对象
	 */
	public Result createVerfityCode(String loginName)
			throws SignatureServiceException;

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 *            要修改的StUsers对象
	 * @return Result实例对象
	 */
	public Result modifyInformation(StUsers user)
			throws SignatureServiceException;

	/**
	 * 修改用户密码
	 * 
	 * @param loginName
	 *            用户名
	 * @param newPassword
	 *            新密码
	 * @return Result实例对象
	 */
	public Result modifyPassword(String loginName, String newPassword)
			throws SignatureServiceException;

	/**
	 * 更改黑白名单
	 * 
	 * @param user
	 *            用户基本信息实例对象
	 * @param specialNumberType
	 *            黑白名单标识 1为黑名单，2为白名单
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result modifyList(User user, Integer specialNumberType)
			throws SignatureServiceException;

	/**
	 * 获得用户信息
	 * 
	 * @param user
	 *            用户基本信息实例对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getUser(User user) throws SignatureServiceException;

	/**
	 * 更改客户业务状态
	 * 
	 * @param user
	 *            用户基本信息实例对象
	 * @param customerStat
	 *            客户业务状态
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result modifyBusiness(User user, Integer customerStat)
			throws SignatureServiceException;

	/**
	 * 取得用户的客户信息
	 * 
	 * @param user
	 *            用户基本信息实例对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getCustomer(User user) throws SignatureServiceException;
	
	/**
	 * 管理员登陆
	 * 
	 * @param loginName 管理员账号
	 * @param password 管理员密码
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result loginForManager(String loginName,String password) throws SignatureServiceException;
}
