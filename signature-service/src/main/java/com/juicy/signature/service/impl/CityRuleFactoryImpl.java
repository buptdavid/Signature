/**
 * Copyright @ 2011-2012 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.CityRuleDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.City;
import com.juicy.signature.persist.po.CityRule;
import com.juicy.signature.service.CityRuleFactory;

/**
 * ���ж�Ӧ����Factory
 *
 * @author ·����
 * @version <p>Feb 29, 2012 ����</p>
 */
public class CityRuleFactoryImpl implements CityRuleFactory {
	
	/** ����Map���� */
	private Map<String,City> cityMap = new HashMap<String,City>();
	
	/** CityRuleDao */
	private CityRuleDao cityRuleDao;
	
	/** ��־��¼ */
	private static Log logger = LogFactory.getLog(CityRuleFactoryImpl.class);
	


	public City getCity(String phone) {
		return this.cityMap.get(phone);
		
	}


	public void addCity(String phone, City city) {
		this.cityMap.put(phone, city);
		
	}


	public Map<String, City> getCityMap() {
		return cityMap;
		
	}


	public void addCityMap(Map<String, City> cityMap) {
		this.cityMap.putAll(cityMap);
		
	}


	public void removeCity(String phone) {
		this.cityMap.remove(phone);
	}
	


	public CityRuleDao getCityRuleDao() {
		return cityRuleDao;
	}


	/**
	 * ���س��ж���
	 * 
	 * @param cityRuleDao
	 */
	public void setCityRuleDao(CityRuleDao cityRuleDao) {
		this.cityRuleDao = cityRuleDao;
		
		try {
			List<CityRule> cityRuleList = cityRuleDao.findAll();
			Iterator<CityRule> it = cityRuleList.iterator();
			
			while(it.hasNext()){
				CityRule cityRule = it.next();
				
				City city = new City();
				city.setCityCode(cityRule.getCityCode());
				city.setCityName(cityRule.getCityName());
				
				cityMap.put(cityRule.getPhone(), city);
				
			}
			
		} catch (SignaturePersistException e) {
			
			logger.error("Unable to set CityRuleDao !");
		}
	}
	
	
	

}
