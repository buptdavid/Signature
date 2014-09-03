/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.random;

import java.util.Random;

/**
 * �������������֤��
 * 
 * @author ·����
 * @version <p>
 *          2011-8-1 ����
 *          </p>
 */
public class RandomCode {
	/** Ĭ�ϳ��� */
	public static final Integer DEFAULLENGTH = 4;

	/** ������ַ��� */
	public static final String baseString = "0123456789";

	/**
	 * ����Ĭ�ϳ��ȵ���֤��
	 * 
	 * @return Ĭ�ϳ��ȵ��ַ���
	 */
	public static String getRandomCode() {
		// �������
		Random random = new Random();

		// ��������ַ���
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < DEFAULLENGTH; i++) {
			int number = random.nextInt(baseString.length());
			sb.append(baseString.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * ����ָ�����ȵ���֤��
	 * 
	 * @param length
	 *            �ַ����ĳ���
	 * 
	 * @return ָ�����ȵ��ַ���
	 */
	public static String getRandomCode(int length) {
		// �������
		Random random = new Random();

		// ��������ַ���
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(baseString.length());
			sb.append(baseString.charAt(number));
		}
		return sb.toString();
	}
}
