/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.CityDao;
import com.juicy.signature.persist.dao.HgCustomerDao;
import com.juicy.signature.persist.dao.StUsersDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.City;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.StUsers;
import com.juicy.signature.service.CityRuleFactory;
import com.juicy.signature.service.StatisticsManage;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;

/**
 * 统计管理Service接口实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          Nov 24, 2011 创建
 *          </p>
 */
public class StatisticsManageImpl implements StatisticsManage {

	private HgCustomerDao hgCustomerDao;

	private StUsersDao stUsersDao;

	private CityRuleFactory cityRuleFactory;

	private CityDao cityDao;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(StatisticsManageImpl.class);

	public Result handleViewAllCustomer(Date startTime, Date endTime,
			Integer customerStat, String loginName, String cityCode, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 如果根据城市地区查询，则对客户的城市区域归属进行处理
			HandleCityRule();

			Integer totalRecords = hgCustomerDao.findCountByStatAndCity(
					startTime, endTime, customerStat, loginName, cityCode);

			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<HgCustomer> customerList = (List<HgCustomer>) hgCustomerDao
					.findByStatAndCityForPage(startTime, endTime, customerStat,
							loginName, cityCode, offSet, pageSize);

			result.setSuccess(true);
			result.getModel().put("customerList", customerList);
			result.getModel().put("page", page);

		} catch (SignaturePersistException e) {
			logger.error("Unable to view all customer");
			throw new SignatureServiceException("Unable to view all customer",
					e);
		}

		return result;
	}

	public Result viewUserLogin(String loginName)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			StUsers user = stUsersDao.getByLoginName(loginName);

			result.setSuccess(true);
			result.getModel().put("user", user);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view user login");
			throw new SignatureServiceException("Unable to view user login", e);
		}

		return result;
	}

	public Result handleViewCustomerStatistics(Date startTime, Date endTime)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 对客户的城市区域归属进行处理
		HandleCityRule();

		try {

			List<Map<Integer, Integer>> statisticsList = new ArrayList<Map<Integer, Integer>>();

			List<City> cityList = cityDao.findAll();
			
			//未知城市
			City otherCity = new City();
			otherCity.setCityCode("0000");
			otherCity.setCityName("未知");
			cityList.add(otherCity);
			City allCity = new City();
			allCity.setCityCode(null);
			allCity.setCityName("所有");
			cityList.add(allCity);

			Iterator<City> it = cityList.iterator();

			while (it.hasNext()) {
				City city = it.next();
				
				Map<Integer, Integer> statisticsMap = new HashMap<Integer, Integer>();

				// 总数量
				Integer allCount = hgCustomerDao.findCountByStatAndCity(
						startTime, endTime, null, null, city.getCityCode());
				statisticsMap.put(0, allCount);

				// 各个状态的数量
				Integer sum = 0;
				for (int i = HgCustomer.ORDERED; i <= HgCustomer.EXPERIENCE_END; i++) {
					Integer count = hgCustomerDao.findCountByStatAndCity(
							startTime, endTime, i, null, city.getCityCode());
					statisticsMap.put(i, count);

					sum += count;
				}

				// 未知状态的数量
				statisticsMap.put(-1, (allCount - sum));

				statisticsList.add(statisticsMap);

			}

			result.setSuccess(true);
			result.getModel().put("cityList", cityList);
			result.getModel().put("statisticsList", statisticsList);

		} catch (SignaturePersistException e) {
			logger.error("Unable to view customer statistics ");
			throw new SignatureServiceException(
					"Unable to view customer statistics ", e);
		}

		return result;
	}

	public Result setCustomerStat(String customerName, Integer customerStat)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			HgCustomer customer = hgCustomerDao.getByCustomerName(customerName);

			customer.setCustomerStat(customerStat);
			Date now = new Date();
			customer.setEffectiveDate(now);
			customer.setUpdateTime(now);

			hgCustomerDao.update(customer);

			result.setSuccess(true);

		} catch (SignaturePersistException e) {
			logger.error("Unable to set customer stat ");
			throw new SignatureServiceException("Unable to set customer stat ",
					e);
		}

		return result;
	}

	/**
	 * 将HG_CUSTOMER表中的所有客户的城市信息进行处理
	 * 
	 */
	private void HandleCityRule() {
		try {
			List<HgCustomer> customerList = hgCustomerDao.findNoCode();

			while (customerList != null && customerList.size() > 0) {
				Iterator<HgCustomer> it = customerList.iterator();

				while (it.hasNext()) {
					HgCustomer customer = it.next();
					String customerName = customer.getCustomerName();

					if (customerName != null && customerName.length() >= 7) {
						String phone = customerName.substring(0, 7);

						City city = cityRuleFactory.getCity(phone);
						if (city != null) {
							customer.setCityCode(city.getCityCode());
							customer.setCityName(city.getCityName());
						} else {
							customer.setCityCode("0000");
							customer.setCityName("未知");
						}

					} else {
						customer.setCityCode("0000");
						customer.setCityName("未知");
					}

					hgCustomerDao.update(customer);

				}

				customerList = null;
				customerList = hgCustomerDao.findNoCode();
			}

		} catch (SignaturePersistException e) {
			logger.error("Unable to handle city rule ");
		}

	}

	public HgCustomerDao getHgCustomerDao() {
		return hgCustomerDao;
	}

	public void setHgCustomerDao(HgCustomerDao hgCustomerDao) {
		this.hgCustomerDao = hgCustomerDao;
	}

	public StUsersDao getStUsersDao() {
		return stUsersDao;
	}

	public void setStUsersDao(StUsersDao stUsersDao) {
		this.stUsersDao = stUsersDao;
	}

	public CityRuleFactory getCityRuleFactory() {
		return cityRuleFactory;
	}

	public void setCityRuleFactory(CityRuleFactory cityRuleFactory) {
		this.cityRuleFactory = cityRuleFactory;
	}

	public CityDao getCityDao() {
		return cityDao;
	}

	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}

}
