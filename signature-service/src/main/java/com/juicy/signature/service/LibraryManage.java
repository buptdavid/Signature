/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.List;

import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 签名盒管理Service接口
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 27, 2011 创建
 *          </p>
 */
public interface LibraryManage {

	/**
	 * 显示所有签名盒类
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
	public Result viewSceondClass(Integer classId)
			throws SignatureServiceException;

	/**
	 * 创建签名盒类
	 * 
	 * @param signatureClass
	 *            SignatureClass实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result createClass(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * 删除签名盒类
	 * 
	 * @param signatureClass
	 *            SignatureClass实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result deleteClass(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * 修改签名盒类
	 * 
	 * @param signatureClass
	 *            SignatureClass实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result modifyClass(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * 分页显示签名盒签名
	 * 
	 * @param signatureClass
	 *            要显示的签名所属的签名盒分类
	 * @param page
	 *            分页对象
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewLibrary(SignatureClass signatureClass, Page page)
			throws SignatureServiceException;

	/**
	 * 创建签名盒签名
	 * 
	 * @param library
	 *            SignatureLibrary实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result createLibrary(SignatureLibrary library)
			throws SignatureServiceException;

	/**
	 * 删除签名盒签名
	 * 
	 * @param libraries
	 *            要删除的签名盒签名的ID的List
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result deleteLibrary(List<Integer> libraries)
			throws SignatureServiceException;

	/**
	 * 修改签名盒签名
	 * 
	 * @param library
	 *            SignatureLibrary实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result modifyLibrary(SignatureLibrary library)
			throws SignatureServiceException;

	/**
	 * 推荐签名盒签名
	 * 
	 * @param libraryId 签名盒签名ID
	 * @param managerId 管理员ID
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result recommendLibrary(Integer libraryId, Integer managerId)
			throws SignatureServiceException;

}
