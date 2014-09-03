/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.List;

import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureCollect;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * 签名内容业务逻辑接口，包括添加修改原创签名，添加修改签名宝库等
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-3 创建
 *          </p>
 */
public interface SignatureService {
	/** 所有分类 */
	public static final Byte ALL = 0;

	/** 第一级分类 */
	public static final Byte FIRST = 1;

	/** 第二级分类 */
	public static final Byte SECOND = 2;

	/**
	 * 创建一个签名分类
	 * 
	 * @param signatureClass
	 *            签名分类对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result createClasses(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * 修改一个签名分类
	 * 
	 * @param signatureClass
	 *            签名分类对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result modifyClasses(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * 删除一个签名分类
	 * 
	 * @param signatureClass
	 *            签名分类对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result deleteClasses(SignatureClass signatureClass)
			throws SignatureServiceException;

	/**
	 * 根据分类依据和一二级分类取得分类
	 * 
	 * @param basis
	 *            分类依据标识
	 * @param firstOrSecondOrAll
	 *            返回第几分类：0，全部；1，一级分类；2，二级分类
	 * @return Result实例对象
	 */
	public Result getClassesByBasis(Byte basis, Byte firstOrSecondOrAll)
			throws SignatureServiceException;

	/**
	 * 根据第一级分类ID获得第二级分类
	 * 
	 * @param firstClassId
	 *            第一级分类ID
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getSecondClassesByFirst(Integer firstClassId)
			throws SignatureServiceException;

	/**
	 * 分页显示签名宝库的二级分类（签名盒名称）信息
	 * 
	 * @param firstClassId一级分类ID
	 * @param keyWord
	 *            二级分类（签名盒名称）关键字
	 * @param page
	 *            分页基本信息
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getLibraryClasses(Integer firstClassId, String keyWord,
			Page page) throws SignatureServiceException;

	/**
	 * 分页显示签名宝库中的签名
	 * 
	 * @param secondClassId
	 *            二级分类ID（签名盒ID）
	 * @param page
	 *            分页基本信息
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getLibrarySignature(Integer secondClassId, Page page)
			throws SignatureServiceException;

	/**
	 * 创建一个原创签名
	 * 
	 * @param signatureOriginal
	 *            原创签名对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result createOriginal(SignatureOriginal signatureOriginal)
			throws SignatureServiceException;

	/**
	 * 修改一个原创签名
	 * 
	 * @param signatureOriginal
	 *            原创签名对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result modifyOriginal(SignatureOriginal signatureOriginal)
			throws SignatureServiceException;

	/**
	 * 删除若干原创签名
	 * 
	 * @param originalIdList
	 *            原创签名对象ID列表
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result deleteOriginal(List<Integer> originalIdList)
			throws SignatureServiceException;

	/**
	 * 分页取得用户的原创签名
	 * 
	 * @param user
	 *            用户的基本信息对象
	 * @param content
	 *            签名内容
	 * @param auditStatus
	 *            审核状态：0表示未审核，1表示审核通过，2表示审核未通过
	 * @param page
	 *            分页信息对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getOriginal(User user, String content, Byte auditStatus,
			Page page) throws SignatureServiceException;

	/**
	 * 创建一个签名宝库
	 * 
	 * @param signatureLibrary
	 *            签名宝库对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result createLibrary(SignatureLibrary signatureLibrary)
			throws SignatureServiceException;

	/**
	 * 修改一个签名宝库
	 * 
	 * @param signatureLibrary
	 *            签名宝库对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result modifyLibrary(SignatureLibrary signatureLibrary)
			throws SignatureServiceException;

	/**
	 * 删除若干签名宝库
	 * 
	 * @param signatureLibraryList
	 *            签名宝库对象列表
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result deleteLibrary(List<SignatureLibrary> signatureLibraryList)
			throws SignatureServiceException;

	/**
	 * 分页取得某一分类的签名宝库中的签名
	 * 
	 * @param signatureClass
	 *            签名分类对象
	 * @param content
	 *            签名内容
	 * @param page
	 *            分页信息对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getLibrary(SignatureClass signatureClass, String content,
			Page page) throws SignatureServiceException;

	/**
	 * 分页取得所有签名宝库中的签名
	 * 
	 * @param content
	 *            签名内容
	 * @param page
	 *            分页信息对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getLibrary(String content, Page page)
			throws SignatureServiceException;

	/**
	 * 创建一个签名收藏
	 * 
	 * @param signatureCollect
	 *            签名收藏对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result createCollect(SignatureCollect signatureCollect)
			throws SignatureServiceException;

	/**
	 * 修改一个签名收藏
	 * 
	 * @param signatureCollect
	 *            签名收藏对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result modifyCollect(SignatureCollect signatureCollect)
			throws SignatureServiceException;

	/**
	 * 删除若干签名收藏
	 * 
	 * @param collectIdList
	 *            签名收藏对象ID列表
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result deleteCollect(List<Integer> collectIdList)
			throws SignatureServiceException;

	/**
	 * 分页取得用户某类的签名收藏
	 * 
	 * @param user
	 *            用户基本信息对象
	 * @param signatureClass
	 *            签名分类对象,如果为null则表示所有
	 * @param page
	 *            分页信息对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getCollect(User user, SignatureClass signatureClass, Page page)
			throws SignatureServiceException;

	/**
	 * 分页显示用户收藏中的签名盒(宝库)
	 * 
	 * @param user
	 *            用户基本信息对象
	 * @param firstClassId
	 *            一级分类ID
	 * @param keyWord
	 *            签名盒（二级分类）中包含的关键字
	 * @param page
	 *            分页信息对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getCollectLibrary(User user, Integer firstClassId,
			String keyWord, Page page) throws SignatureServiceException;

	/**
	 * 根据分类分页查找原创情景签名
	 * 
	 * @param signatureClass
	 *            分类信息
	 * @param auditStatus
	 *            审核状态
	 * @param publish
	 *            是否公开
	 * @param page
	 *            分页信息对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getOriginalByClass(SignatureClass signatureClass,
			Byte auditStatus, Boolean publish, Page page)
			throws SignatureServiceException;

	/**
	 * 根据关键字content分页查找原创签名
	 * 
	 * @param content
	 *            关键字
	 * @param publish 是否公开，如果不考虑则置空
	 * @param auditStatus 审核状态，如果不考虑则置空
	 * @param page
	 *            分页基本信息对象
	 * @return Result实例对象
	 * @throws SignatureServiceException
	 */
	public Result getOriginal(String content, Boolean publish,
			Byte auditStatus, Page page) throws SignatureServiceException;

}
