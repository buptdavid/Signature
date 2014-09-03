/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 业务逻辑层测试基类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-1 创建
 *          </p>
 */
public class BaseServiceTest {
	/** 私有静态ApplicationContext对象实例 */
	private static ApplicationContext ctx;

//	Class<T> target;

	public BaseServiceTest() {
		ctx = getInstance();

//		// 取得T的类的名字
//		Object array = Array.newInstance(getGenericType(0), 100);
//		String tName = array.getClass().getSimpleName();
//
//		// 将首字母小写（目前看这段代码效率不高，以后重构希望效率更高）
//		String startString = tName.substring(0, 1);
//		startString = startString.toLowerCase();
//		String endString = tName.substring(1, tName.length());
//		tName = startString + endString;
//		tName = tName.substring(0, tName.length()-2);
//
//		target = (Class<T>) ctx.getBean
//				(tName);
	}

	/**
	 * 返回ApplicationContext对象
	 */
	public static synchronized ApplicationContext getInstance() {
		if (ctx == null) {
			String[] springConfigFiles = { "signature-service.xml",
					"signature-persist.xml" };
			ctx = new ClassPathXmlApplicationContext(springConfigFiles);
		}

		return ctx;
	}

	public static ApplicationContext getCtx() {
		return ctx;
	}

	public static void setCtx(ApplicationContext ctx) {
		BaseServiceTest.ctx = ctx;
	}

	/**
	 * 取得T的类型
	 * 
	 * @param index
	 * @return
	 */
//	public Class getGenericType(int index) {
//		Type genType = getClass().getGenericSuperclass();
//		if (!(genType instanceof ParameterizedType)) {
//			return Object.class;
//		}
//		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
//		if (index >= params.length || index < 0) {
//			throw new RuntimeException("Index outof bounds");
//		}
//		if (!(params[index] instanceof Class)) {
//			return Object.class;
//		}
//		return (Class) params[index];
//	}

}
