/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 *
 * @author 路卫杰
 * @version <p>2011-8-26 创建</p>
 */
public class DateFormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat sdf  =   new  SimpleDateFormat( "HH:mm" );		
		try {
			Date d = sdf.parse("15:30");
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
