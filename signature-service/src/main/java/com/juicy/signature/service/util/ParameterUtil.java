/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.util;

import com.juicy.signature.service.exception.SignatureServiceException;

/**
 * 取得系统参数接口(从数据库或缓存中)
 *
 * @author 路卫杰
 * @version <p>Nov 28, 2011 创建</p>
 */
public interface ParameterUtil {
	
	/**
	 * 根据参数名称获得参数值
	 * 
	 * @param parameterName 参数名称 
	 * @return 参数值
	 * @throws SignatureServiceException
	 */
	public Object getParameter(String parameterName)  throws SignatureServiceException;

}
