/**
 * Copyright @ 2011-2012 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.City;
import com.juicy.signature.persist.po.CityRule;

/**
 * ������й���
 * 
 * @author ·����
 * @version <p>
 *          2012-3-8 ����
 *          </p>
 */
public class CityTest {

	ApplicationContext ctx;

	private CityDao cityDao;

	private CityRuleDao cityRuleDao;

	private Map<String, String> cityMap;

	private BufferedReader reader;

	private String fileName = "D:/H.txt";

	public void prepare() throws SignaturePersistException {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("signature-persist.xml");
		}
		
		cityDao = (CityDao) ctx.getBean("cityDao");
		cityRuleDao = (CityRuleDao) ctx.getBean("cityRuleDao");
	}

	public void loadRule() throws SignaturePersistException {
		this.prepare();
		this.loadCity();
		this.LoadRuleFile();

		String record = null;
		try {
			record = reader.readLine();
			
			int count = 0;

			while (record != null) {
				count ++;
				String[] recordArray = record.split("\t");
				
				System.out.println(recordArray[0]);

				for (int i = 0; i < recordArray.length; i++) {
					CityRule cityRule = new CityRule();
					cityRule.setPhone(recordArray[0]);
					cityRule.setCityCode(recordArray[2]);
					cityRule.setCityName(cityMap.get(recordArray[2]));
					
					cityRuleDao.save(cityRule);

				}

				record = reader.readLine();
			}
			
			System.out.println("����¼�� " + count);
		} catch (IOException e) {
			System.out.println("��ȡ����");
		}

	}

	/**
	 * �������code�����ƶ�ӦMap
	 * 
	 * @throws SignaturePersistException
	 */
	public void loadCity() throws SignaturePersistException {
		List<City> cityList = cityDao.findAll();
		Iterator<City> it = cityList.iterator();

		cityMap = new HashMap<String, String>();
		while (it.hasNext()) {
			City city = it.next();
			cityMap.put(city.getCityCode(), city.getCityName());
		}
	}

	/**
	 * �����ļ�
	 * 
	 * @throws SignaturePersistException
	 */
	public void LoadRuleFile() throws SignaturePersistException {
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName)));
		} catch (FileNotFoundException e) {
			System.out.println("�ļ���ȡ����!");
		}
	}
	
	
	/**
	 * @param args
	 * @throws SignaturePersistException 
	 */
	public static void main(String[] args) throws SignaturePersistException {
		CityTest test = new CityTest();
		
		System.out.println("Begin!");
		
		test.loadRule();
		
		System.out.println("OK!");

	}

}
