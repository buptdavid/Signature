/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.service;

import java.util.Date;
import java.util.Random;


/**
 * 随机类，包括生成不相同的手机号码，不相同的账号。
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-25 创建
 *          </p>
 */
public class RandomUtil {

	/**
	 * 生成不相同的手机号码，其实就是当前时间的毫秒数除以100，恰好为11位的数字
	 * 
	 * @return 不相同的手机号码
	 */
	public static String getRandomMobile() {
		// 当前线程暂停100ms，防止出现重复的号码
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date date = new Date();
		Long current = date.getTime();

		current /= 100;

		String mobile = String.valueOf(current);

		return mobile;
	}

	/**
	 * 生成指定长度的字符串
	 * 
	 * @param length
	 *            字符串的长度
	 * 
	 * @return 指定长度的字符串
	 */
	public static String getRandomString(int length) {
		String baseString = "abcdefghijklmnopqrstuvwxyz0123456789";

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

	/**
	 * 生成随机正整数
	 * 
	 * @return 随机的正整数
	 */
	public static Integer getRandomInteger() {
		Random random = new Random();

		Integer randomInteger = 0;

		do {
			randomInteger = random.nextInt(Integer.MAX_VALUE);
		} while (randomInteger == 0);

		return randomInteger;
	}

	/**
	 * 生成随机一级分类
	 * 
	 * @return 随机的一级分类
	 */
	public static String getFirstCLass() {
		String[] firsts = { "节日彩印", "轻松心情", "人生语录", "关怀祝福", "商务彩印" };

		Random random = new Random();

		Integer randomInteger = random.nextInt(firsts.length);

		return firsts[randomInteger];
	}

	/**
	 * 生成随机二级分类
	 * 
	 * @return 随机的一级分类
	 */
	public static String getSecondCLass() {
		String[] seconds = { "七夕情人节", "八一建军节", "七一建党节", "大热天时", "励志篇", "感悟篇",
				"流行作家篇", "朋友祝福", "拳拳亲情", "天气关怀", "生活贴士", "企业家语录" };

		Random random = new Random();

		Integer randomInteger = random.nextInt(seconds.length);

		return seconds[randomInteger];
	}

	/**
	 * 生成随机的签名
	 * 
	 * @return 随机的签名
	 */
	public static String getRandomSignature() {
		String[] signatures = { "伟人之所以伟大，是因为他与别人共处逆境时，别人失去了信心，他却下决心实现自己的目标。",
				"正在上班，待会再约我！", "每天都要做重复的三件事，想你，等你，爱你~！", "辛勤的园丁正在浇灌祖国的花朵~",
				"主人让我通知你，他正在吃饭，稍后回复你电话。", "电话不要催，酒杯对对碰，舞裙翩翩飞~",
				"因在旅游，可能不便接听电话，请原谅。", "久没联系了，赶紧打我电话吧。",
				"食不言，寝不语。我正在吃饭，不方便接电话，不好意思。", "欢迎大家拨打我的电话。" };
		Random random = new Random();

		Integer randomInteger = random.nextInt(signatures.length);

		return signatures[randomInteger];
	}

	/**
	 * 测试本类
	 */
	public static void main(String[] args) {
		// for (int i = 0; i < 10; i++) {
		// System.out.println(RandomUtil.getRandomMobile());
		// }

		for (int i = 0; i < 10; i++) {
			System.out.println(RandomUtil.getSecondCLass());
		}

	}

}
