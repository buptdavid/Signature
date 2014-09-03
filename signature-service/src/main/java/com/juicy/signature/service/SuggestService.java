/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.List;

import com.juicy.signature.persist.po.Suggest;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * 用户建议Service接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-11 创建
 *          </p>
 */
public interface SuggestService {

	/**
	 * 创建一个用户建议
	 * 
	 * @param user
	 *            用户基本信息对象
	 * @param suggest
	 *            Suggest实例对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result createSuggest(User user, Suggest suggest)
			throws SignatureServiceException;

	/**
	 * 删除若干建议
	 * 
	 * @param suggestList
	 *            Suggest实例List
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result deleteSuggest(List<Suggest> suggestList)
			throws SignatureServiceException;

	/**
	 * 分页取得与title相关的建议
	 * 
	 * @param title
	 *            建议标题
	 * @param page
	 *            分页信息Page对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result viewSuggest(String title, Page page)
			throws SignatureServiceException;

}
