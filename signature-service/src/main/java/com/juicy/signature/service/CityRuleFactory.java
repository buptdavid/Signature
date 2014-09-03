/**
 * Copyright @ 2011-2012 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.Map;

import com.juicy.signature.persist.po.City;

/**
 * ���к����Ciyt�����Ӧ��Factory
 * 
 * @author ·����
 * @version <p>
 *          2012-2-29 ����
 *          </p>
 */
public interface CityRuleFactory {

	/**
	 * ���ݺ�����City����
	 * 
	 * @param phone
	 *            ����code
	 * @return ���������ĳ�������
	 */
	public City getCity(String phone);

	/**
	 * ���City����
	 * 
	 * @param phone
	 *           �ֻ���
	 * @param city
	 * 			  City����
	 */
	public void addCity(String phone, City city);

	/**
	 * ������г�����Ϣ
	 * 
	 * @return ������Ϣ
	 */
	public Map<String, City> getCityMap();

	/**
	 * ����City
	 * 
	 * @param city
	 *            ������Ϣ����
	 */
	public void addCityMap(Map<String, City> cityMap);

	/**
	 * �Ƴ�City����
	 * 
	 * @param cityCode
	 *            Ҫ�Ƴ��ĳ���Code
	 */
	public void removeCity(String phone);

}
