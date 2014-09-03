/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.List;

import com.juicy.signature.persist.po.HgKeyWord;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 内容审核管理Service
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 27, 2011 创建
 *          </p>
 */
public interface AuditManage {

	/**
	 * 分页展示关键字
	 * 
	 * @param content
	 *            匹配内容
	 * @param page
	 *            分页Page实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewKeyWord(String content, Page page)
			throws SignatureServiceException;

	/**
	 * 添加关键字
	 * 
	 * @param keyword
	 *            关键字对象
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result createKeyWord(HgKeyWord keyword)
			throws SignatureServiceException;

	/**
	 * 删除关键字
	 * 
	 * @param keyWords
	 *            关键字List
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result deleteKeyWord(List<HgKeyWord> keyWords)
			throws SignatureServiceException;

	/**
	 * 修改关键字
	 * 
	 * @param keyword
	 *            关键字HgKeyWord实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result modifyKeyWord(HgKeyWord keyword)
			throws SignatureServiceException;

	/**
	 * 根据审核状态分页显示原创签名
	 * 
	 * @param auditStatus 审核状态
	 * @param page 分页信息对象
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewOriginal(Byte auditStatus, Page page)
			throws SignatureServiceException;

	/**
	 * 设置原创签名的审核状态
	 * 
	 * @param originalIds 原创签名ID列表 
	 * @param auditStatus 审核状态
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result setAuditStatus(List<Integer> originalIds,Byte auditStatus) throws SignatureServiceException;

}
