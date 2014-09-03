package com.juicy.signature.service;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间测试
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-12-23 创建
 *          </p>
 */
public class DateTest {
	
	static int day = 30;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Calendar ca = Calendar.getInstance();
		
		ca.setTime(new Date());
		
		Date now = ca.getTime();
		
		ca.add(Calendar.DAY_OF_MONTH, -31);
		Date pas = ca.getTime();
		
		System.out.println("pas: " + pas);
		System.out.println("now: " + now);
		
		long effectiveMilliSeconds = pas.getTime();
		long currentMilliSeconds = now.getTime();
		long dayLong = day;
		
		long experienceMilliSeconds = dayLong * 24	* 60 * 60 * 1000L; 
		
		if ((effectiveMilliSeconds + experienceMilliSeconds) < currentMilliSeconds) {
			System.out.println("免费体验结束");
		}else{
			System.out.println("免费体验继续");
		}

	}

}
