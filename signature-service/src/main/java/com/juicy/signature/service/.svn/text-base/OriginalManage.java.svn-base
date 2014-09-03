/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 情景原创签名管理Service接口
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 27, 2011 创建
 *          </p>
 */
public interface OriginalManage {

	/**
	 * 显示情景原创签名类
	 * 
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewClass() throws SignatureServiceException;
	
	/**
	 * 根据一级分类ID查找显示二级分类
	 * 
	 * @param classId
	 * @return
	 * @throws SignatureServiceException
	 */
	public Result viewSceondClass(Integer classId) throws SignatureServiceException;

	/**
	 * 创建情景原创签名类
	 * 
	 * @param signatureClass
	 *            情景原创签名类实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result createClass(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * 删除情景原创签名类
	 * 
	 * @param signatureClass
	 *            情景原创签名类实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result deleteClass(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * 修改情景原创签名类
	 * 
	 * @param signatureClass
	 *            情景原创签名类实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result modifyClass(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * 分页显示某情景类得原创签名
	 * 
	 * @param signatureClass
	 *            情景原创签名类实例,如果为null，则查找所有分类
	 * @param page
	 *            分页实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewOriginal(SignatureClass signatureClass,Boolean publish,Byte auditStatus, Page page)
			throws SignatureServiceException;
	
	/**
	 * 推荐原创签名
	 * 
	 * @param originalId 原创签名ID
	 * @param managerId 管理员ID
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result recommendOriginal(Integer originalId,Integer managerId) throws SignatureServiceException;

}
