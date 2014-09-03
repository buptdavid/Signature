/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.HgCustomerDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.Portal;
import com.juicy.signature.service.CustomerService;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.util.ParameterUtil;

/**
 * 客户相关的Service实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-26 创建
 *          </p>
 */
public class CustomerServiceImpl implements CustomerService {

	/** 可免费体验业务的天数,默认为30天 */
	private Integer experienceDay;

	HgCustomerDao hgCustomerDao;

	private ParameterUtil parameterUtil;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(CustomerServiceImpl.class);

	public Result checkExperience() throws SignatureServiceException {
		Result result = Result.createRestult();

		logger.info("Timer start:定时检查免费体验用户有效期检查业务逻辑开始......");

		try {
			// 取得所有体验用户
			List<HgCustomer> hgCustomerList = hgCustomerDao
					.findByStat(HgCustomer.EXPERIENCE);
			Iterator<HgCustomer> it = hgCustomerList.iterator();

			// 统计更新状态的客户数量
			int num = 0;
			
			//用long型，防止数值溢出出问题
			long dayLong = this.getExperienceDay();
			
			// 可免费体验的毫秒数
			long experienceMilliSeconds = dayLong * 24	* 60 * 60 * 1000L;
			
			// 当前时间
			Date currentTime = new Date();
			long currentMilliSeconds = currentTime.getTime();

			// 遍历检查体验是否过期
			while (it.hasNext()) {
				HgCustomer hgCustomer = it.next();
				// 生效时间
				Date effectiveDate = hgCustomer.getEffectiveDate();
				long effectiveMilliSeconds = effectiveDate.getTime();

				// 如果超过了免费体验期则更新订购状态
				if ((effectiveMilliSeconds + experienceMilliSeconds) < currentMilliSeconds) {
					hgCustomer.setCustomerStat(HgCustomer.EXPERIENCE_END);
					// 订购状态更新时间
					hgCustomer.setUpdateTime(new Date());
					hgCustomerDao.update(hgCustomer);
					num++;
					logger.info("Timer customer: 客户ID： " + hgCustomer.getId() + " 客户电话： "
							+ hgCustomer.getCustomerName());
				}

			}

			logger.info("Timer total: 更新状态的客户数量为： " + num);
			logger.info("Timer end: 定时检查免费体验用户有效期检查业务逻辑结束");

			result.setSuccess(true);

		} catch (SignaturePersistException e) {
			logger.error("Timer fail: 定时检查免费体验用户有效期检查业务逻辑执行失败,执行时间: " + new Date(), e);
			throw new SignatureServiceException(
					"定时检查免费体验用户有效期检查业务逻辑执行失败,执行时间: " + new Date(), e);
		}

		// 返回
		return result;
	}

	public Result view(Date startTime, Date endTime, Integer customerStat,
			Page page) throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 总数量
			Integer totalRecords = hgCustomerDao.findCountByStat(startTime,
					endTime, customerStat, null);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			// 查询结果
			List<HgCustomer> customerList = hgCustomerDao.findByStatForPage(
					startTime, endTime, customerStat, null, offSet, pageSize);

			result.setSuccess(true);
			result.getModel().put("customerList", customerList);

		} catch (SignaturePersistException e) {
			logger.error("Unable to view customer ", e);
			throw new SignatureServiceException("Unable to view customer ", e);
		}

		return result;
	}

	public Result statistic(Date startTime, Date endTime)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Map<String, Integer> statisticMap = new HashMap<String, Integer>();
			Integer count;

			// 订购状态用户统计
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.ORDERED, null);
			statisticMap.put("订购用户", count);

			// 退订状态用户统计
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.QUIT_ORDERED, null);
			statisticMap.put("退订用户", count);

			// 暂停状态用户统计
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.PAUSE_ORDERED, null);
			statisticMap.put("暂停用户", count);

			// 业务过期状态用户统计
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.EXPIRED_ORDERED, null);
			statisticMap.put("业务过期用户", count);

			// 免费体验状态用户统计
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.EXPERIENCE, null);
			statisticMap.put("免费体验用户", count);

			// 免费体验结束状态用户统计
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.EXPERIENCE_END, null);
			statisticMap.put("免费体验结束用户", count);

			result.setSuccess(true);
			result.getModel().put("statisticMap", statisticMap);

		} catch (SignaturePersistException e) {
			logger.error("Unable to statistic customer ", e);
			throw new SignatureServiceException(
					"Unable to statistic customer ", e);
		}

		return result;
	}

	public HgCustomerDao getHgCustomerDao() {
		return hgCustomerDao;
	}

	public void setHgCustomerDao(HgCustomerDao hgCustomerDao) {
		this.hgCustomerDao = hgCustomerDao;
	}

	public Integer getExperienceDay() throws SignatureServiceException {

		Portal portal = (Portal) parameterUtil.getParameter("portal");

		if (portal != null) {
			return portal.getExperienceDay();
		} else {
		return experienceDay;
	}

	}

	public void setExperienceDay(Integer experienceDay) {
		this.experienceDay = experienceDay;
	}

	public ParameterUtil getParameterUtil() {
		return parameterUtil;
}

	public void setParameterUtil(ParameterUtil parameterUtil) {
		this.parameterUtil = parameterUtil;
	}
	
	

}
