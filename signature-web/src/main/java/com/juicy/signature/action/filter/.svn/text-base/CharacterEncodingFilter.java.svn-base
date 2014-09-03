/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤器
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-15 创建
 *          </p>
 */
public class CharacterEncodingFilter implements Filter {

	/** FilterConfig对象 */
	protected FilterConfig filterConfig = null;
	
	/** 编码 */
	protected String encoding = "";

	/**
	 * 过滤
	 * 
	 * @param servletRequest
	 * @param servletResponse
	 * @param filterChain
	 */
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		if (encoding != null)
			servletRequest.setCharacterEncoding(encoding);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	/**
	 * 销毁
	 * 
	 */
	public void destroy() {
		filterConfig = null;
		encoding = null;
	}

	/**
	 * 初始化
	 * 
	 * @param filterConfig
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");

	}
}
