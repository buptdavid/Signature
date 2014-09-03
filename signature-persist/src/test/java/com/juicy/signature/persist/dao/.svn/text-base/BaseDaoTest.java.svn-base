/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 路卫杰
 * 
 */
public class BaseDaoTest {
	/** 私有静态ApplicationContext对象实例 */
	private static ApplicationContext ctx;

	/**
	 * 返回ApplicationContext对象
	 */
	public static synchronized ApplicationContext getInstance() {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("signature-persist.xml");
		}

		return ctx;
	}

}
