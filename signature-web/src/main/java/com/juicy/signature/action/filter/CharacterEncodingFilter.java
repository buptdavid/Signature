/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
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
 * ���������
 * 
 * @author ·����
 * @version <p>
 *          2011-9-15 ����
 *          </p>
 */
public class CharacterEncodingFilter implements Filter {

	/** FilterConfig���� */
	protected FilterConfig filterConfig = null;
	
	/** ���� */
	protected String encoding = "";

	/**
	 * ����
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
	 * ����
	 * 
	 */
	public void destroy() {
		filterConfig = null;
		encoding = null;
	}

	/**
	 * ��ʼ��
	 * 
	 * @param filterConfig
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");

	}
}
