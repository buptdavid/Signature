/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.result.Result;

/**
 * 首页展示Service
 *
 * @author 路卫杰
 * @version <p>Oct 27, 2011 创建</p>
 */
public interface IndexService {
	
	/**
	 * 展示首页
	 * 
	 * @return
	 * @throws SignatureServiceException
	 */
	public Result view() throws SignatureServiceException;

}
