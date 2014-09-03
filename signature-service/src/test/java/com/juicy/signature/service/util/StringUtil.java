package com.juicy.signature.service.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java正则表达式将回车换行换为逗号
 * 
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-26 创建
 *          </p>
 */
public class StringUtil {
	public static void replaceBlank() {
		Pattern p = Pattern.compile("\r|\n");
		String str = "13426082242\r\n15933776089*";
		System.out.println("before: " + str);
		Matcher m = p.matcher(str);
		String after = m.replaceAll(",");
		System.out.println("after: " + after);
	}

	public static void main(String[] args) {
		replaceBlank();
	}
}