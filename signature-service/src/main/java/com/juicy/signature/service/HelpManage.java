/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.result.Result;

/**
 * 帮助管理HelpManage接口
 *
 * @author 路卫杰
 * @version <p>Oct 31, 2011 创建</p>
 */
public interface HelpManage {
	
	/**
	 * 展示帮助信息
	 * 
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result view() throws SignatureServiceException;
	
	/**
	 * 修改帮助信息
	 * 
	 * @param content 要修改的帮助信息内容
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result modify(String content) throws SignatureServiceException;

}
