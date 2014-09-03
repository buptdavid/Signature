/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.List;

import com.juicy.signature.persist.po.HgSendrule;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * 签名规则业务逻辑接口，包括修改默认签名规则，增加个性化签名规则等
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-1 创建
 *          </p>
 */
public interface RuleService {

	/**
	 * 创建默认签名
	 * 
	 * @param user
	 *            用户的基本信息对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	@Deprecated
	public Result createDefaultRule(User user) throws SignatureServiceException;

	/**
	 * 取得默认签名
	 * 
	 * @param user
	 *            用户的基本信息对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getDefaultRule(User user) throws SignatureServiceException;

	/**
	 * 分页取得默认签名
	 * 
	 * @param user
	 *            用户的基本信息对象
	 * @param page
	 *            分页信息Page对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getDefaultRule(User user, Page page)
			throws SignatureServiceException;

	/**
	 * 更改默认签名
	 * 
	 * @param hgSendrule
	 *            HgSendrule对象
	 * @param content
	 *            修改的签名
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result modifyDefaultRule(HgSendrule hgSendrule)
			throws SignatureServiceException;

	/**
	 * 创建个性化签名所要展示的视图
	 * 
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result viewCreatePersonalizedRule() throws SignatureServiceException;

	/**
	 * 创建个性化签名
	 * 
	 * @param hgSendrule
	 *            HgSendrule对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result createPersonalizedRule(HgSendrule hgSendrule)
			throws SignatureServiceException;

	/**
	 * 取得个性化签名
	 * 
	 * @param user
	 *            用户的基本信息对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	@Deprecated
	public Result getPersonalizedRule(User user)
			throws SignatureServiceException;

	/**
	 * 分页取得用户的个性化签名
	 * 
	 * @param user
	 *            用户的基本信息对象
	 * @param pager
	 *            分页信息对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getPersonalizedRule(User user, Page page)
			throws SignatureServiceException;

	/**
	 * 根据个性化规则ID取得该个性化规则
	 * 
	 * @param id
	 *            个性化规则ID
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getPersonalizedRule(Integer id)
			throws SignatureServiceException;

	/**
	 * 修改个性化签名
	 * 
	 * @param hgSendrule
	 *            HgSendrule对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result modifyPersonalizedRule(HgSendrule hgSendrule)
			throws SignatureServiceException;

	/**
	 * 删除个性化签名
	 * 
	 * @param hgSendrules
	 *            多个HgSendrule对象List
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result deletePersonalizedRule(List<Integer> sendruleIdList)
			throws SignatureServiceException;

}
