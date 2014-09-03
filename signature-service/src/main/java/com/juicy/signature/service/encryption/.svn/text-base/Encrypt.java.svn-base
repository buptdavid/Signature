/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.encryption;

/**
 * 对密码进行加密和验证接口
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public interface Encrypt {

	/**
	 * 对字符串进行加密
	 * 
	 * @param plaintext
	 *            需要加密的字符串明文
	 * @return 进行加密后的密文
	 */
	public String encode(String plaintext);

	/**
	 * 判断明文和密文是否一致
	 * 
	 * @param plaintext
	 *            明文
	 * 
	 * @param ciphertext
	 *            密文
	 * @return 是否一致的结果，true表示一致，false表示不一致
	 */
	public boolean check(String plaintext, String ciphertext);

}
