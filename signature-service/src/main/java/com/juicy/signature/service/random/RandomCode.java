/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.random;

import java.util.Random;

/**
 * 生成随机短信验证码
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-1 创建
 *          </p>
 */
public class RandomCode {
	/** 默认长度 */
	public static final Integer DEFAULLENGTH = 4;

	/** 随机的字符串 */
	public static final String baseString = "0123456789";

	/**
	 * 生成默认长度的验证码
	 * 
	 * @return 默认长度的字符串
	 */
	public static String getRandomCode() {
		// 随机对象
		Random random = new Random();

		// 生成随机字符串
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < DEFAULLENGTH; i++) {
			int number = random.nextInt(baseString.length());
			sb.append(baseString.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 生成指定长度的验证码
	 * 
	 * @param length
	 *            字符串的长度
	 * 
	 * @return 指定长度的字符串
	 */
	public static String getRandomCode(int length) {
		// 随机对象
		Random random = new Random();

		// 生成随机字符串
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(baseString.length());
			sb.append(baseString.charAt(number));
		}
		return sb.toString();
	}
}
