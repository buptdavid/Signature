/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.filter;

import java.util.List;

import com.juicy.signature.service.exception.SignatureServiceException;

/**
 * 关键字过滤接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-10 创建
 *          </p>
 */
public interface Filter {
	/**
	 * 检查content中包含的敏感词
	 * 
	 * @param content
	 *            要检查的内容
	 * @return 检查的结果。如果有则返回包含的敏感词,多个敏感词以逗号分隔，否则返回null
	 */
	public String contain(String content);

	/**
	 * 增加内存中的若干敏感词
	 * 
	 * @param keyWordList
	 *            要增加的敏感词列表
	 * @throws SignatureServiceException 
	 */
	public void addKeyWords(List<String> keyWordList) throws SignatureServiceException;

	/**
	 * 删除内存中的某个敏感词
	 * 
	 * @param keyWordList
	 *            要删除的敏感词列表
	 * @throws SignatureServiceException 
	 */
	public void deleteKeyWords(List<String> keyWordList) throws SignatureServiceException;
}
