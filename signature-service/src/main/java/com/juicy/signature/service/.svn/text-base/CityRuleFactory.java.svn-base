/**
 * Copyright @ 2011-2012 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.Map;

import com.juicy.signature.persist.po.City;

/**
 * 城市号码和Ciyt对象对应的Factory
 * 
 * @author 路卫杰
 * @version <p>
 *          2012-2-29 创建
 *          </p>
 */
public interface CityRuleFactory {

	/**
	 * 根据号码获得City对象
	 * 
	 * @param phone
	 *            城市code
	 * @return 符合条件的城市名称
	 */
	public City getCity(String phone);

	/**
	 * 添加City对象
	 * 
	 * @param phone
	 *           手机号
	 * @param city
	 * 			  City对象
	 */
	public void addCity(String phone, City city);

	/**
	 * 获得所有城市信息
	 * 
	 * @return 城市信息
	 */
	public Map<String, City> getCityMap();

	/**
	 * 加入City
	 * 
	 * @param city
	 *            城市信息对象
	 */
	public void addCityMap(Map<String, City> cityMap);

	/**
	 * 移除City对象
	 * 
	 * @param cityCode
	 *            要移除的城市Code
	 */
	public void removeCity(String phone);

}
