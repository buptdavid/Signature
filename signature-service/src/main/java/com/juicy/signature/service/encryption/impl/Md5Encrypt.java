/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.encryption.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.juicy.signature.service.encryption.Encrypt;

/**
 * 采用MD5加密算法实现Encrypt接口的方法类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public class Md5Encrypt implements Encrypt {

	public String encode(String plaintext) {
		// 确定计算方法
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sun.misc.BASE64Encoder base64en = new sun.misc.BASE64Encoder();

		// 加密后的字符串
		String ciphertext = null;
		try {
			ciphertext = base64en
					.encode(md5.digest(plaintext.getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 返回密文
		return ciphertext;
	}

	public boolean check(String plaintext, String ciphertext) {
		// 任意一个为空，则返回false
		if (plaintext == null || ciphertext == null) {
			return false;
		}

		// 如果明文加密后和密文相同，则返回true，否则返回false
		if (ciphertext.equals(this.encode(plaintext))) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 测试本类
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		String plaintext = "123456";
		
		Encrypt encrypt = new Md5Encrypt();
		String ciphertext = encrypt.encode(plaintext);
		System.out.println(ciphertext);
		
		System.out.println(encrypt.check(plaintext, ciphertext));
	}

}
