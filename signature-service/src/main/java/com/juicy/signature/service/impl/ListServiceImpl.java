/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.HgCustomerDao;
import com.juicy.signature.persist.dao.HgSpecialNumbersDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.HgSpecialNumbers;
import com.juicy.signature.persist.po.Portal;
import com.juicy.signature.service.ListService;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.juicy.signature.service.util.ParameterUtil;

/**
 * 名单处理业务逻辑接口实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-8 创建
 *          </p>
 */
public class ListServiceImpl implements ListService {

	HgSpecialNumbersDao hgSpecialNumbersDao;

	HgCustomerDao hgCustomerDao;

	/** 可设置最多的黑白名单数量,默认100 */
	private Integer maxNum;

	/** 默认有效期的月数 */
	private Integer shieldPeriod = 10000;

	private ParameterUtil parameterUtil;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(ListServiceImpl.class);

	public Result updateBlackWhite(User user) throws SignatureServiceException {
		Result result = Result.createRestult();

		// 用户ID
		Integer userId = user.getUserId();

		try {
			// 取得客户HgCustomer实例
			HgCustomer hgCustomer = hgCustomerDao.getByUserId(userId);

			// 设置specialNumberType
			Integer specialNumberType = user.getSpecialNumberType();
			hgCustomer.setSpecialNumberType(specialNumberType);

			// 更新
			hgCustomerDao.update(hgCustomer);

			// 设置结果
			result.setSuccess(true);

		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to update black white flag for user: "
							+ user.getLoginName(), e);
			throw new SignatureServiceException(
					"Unable to update black white flag for user: "
							+ user.getLoginName(), e);
		}

		// 返回
		return result;
	}

	public Result createBlackList(List<HgSpecialNumbers> hgSpecialNumbersList)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 客户ID
			Integer customerId = hgSpecialNumbersList.get(0).getCustomerId();

			// 判断已有的黑白名单数量是否已经超过的最大数量，如果超过，则返回
			Integer blackNum = hgSpecialNumbersDao.findCountByCustomerId(
					customerId, HgSpecialNumbers.BLACKLIST);
			Integer whiteNum = hgSpecialNumbersDao.findCountByCustomerId(
					customerId, HgSpecialNumbers.WHITELIST);
			if ((blackNum + whiteNum) >= this.getMaxNum()) {
				result.setRemark("失败：您的黑白名单设置总数量已经超过了" + this.getMaxNum() + "个");

				return result;
			}

			// 取得设置黑名单的所有号码
			List<HgSpecialNumbers> hgSpecialNumbersLoad = hgSpecialNumbersDao
					.findByCustomerId(customerId, HgSpecialNumbers.BLACKLIST);
			String numbersLoad = "";
			Iterator<HgSpecialNumbers> itLoad = hgSpecialNumbersLoad.iterator();
			while (itLoad.hasNext()) {
				HgSpecialNumbers hgSpecialNumberLoad = itLoad.next();
				numbersLoad += hgSpecialNumberLoad.getSpecialNumber();
			}

			// 循环设置黑名单标识和设置时间,并保存
			Iterator<HgSpecialNumbers> it = hgSpecialNumbersList.iterator();
			String message = "";
			while (it.hasNext()) {
				HgSpecialNumbers hgSpecialNumber = it.next();

				// 判断是否已经保存某号码,如果已经保存则无需保存
				String number = hgSpecialNumber.getSpecialNumber();
				if (numbersLoad.indexOf(number) >= 0) {
					message += number + " ";
				} else {
					hgSpecialNumber
							.setSpecialNumberType(HgSpecialNumbers.BLACKLIST);
					Date currentTime = new Date();
					hgSpecialNumber.setSpecialNumberCeratedate(currentTime);
					hgSpecialNumber.setShieldPeriod(shieldPeriod);

					hgSpecialNumbersDao.save(hgSpecialNumber);
				}

			}

			// 返回的结果
			result.setSuccess(true);
			if (message.length() > 0) {
				result.getModel().put("message", message);
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to create black list", e);
			throw new SignatureServiceException("Unable to create black list",
					e);
		}

		return result;
	}

	public Result getBlackList(User user, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer customerId = user.getCustomerId();

		try {
			// 取得该用户黑名单的数量,并新生成Page对象
			Integer totalRecords = hgSpecialNumbersDao.findCountByCustomerId(
					customerId, HgSpecialNumbers.BLACKLIST);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<HgSpecialNumbers> hgSpecialNumbersList = hgSpecialNumbersDao
					.findByCustomerIdForPage(customerId,
							HgSpecialNumbers.BLACKLIST, offSet, pageSize);

			// 取得该用户白名单的数量
			Integer whiteNum = hgSpecialNumbersDao.findCountByCustomerId(
					customerId, HgSpecialNumbers.WHITELIST);

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("blackList", hgSpecialNumbersList);
			result.getModel().put("page", page);
			result.getModel().put("blackNum", totalRecords);
			result.getModel().put("whiteNum", whiteNum);
			result.getModel().put("maxNum", this.getMaxNum());
		} catch (SignaturePersistException e) {
			logger.error("Unable to get black list", e);
			throw new SignatureServiceException("Unable to get black list", e);
		}

		return result;
	}

	public Result createWhiteList(List<HgSpecialNumbers> hgSpecialNumbersList)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 客户ID
			Integer customerId = hgSpecialNumbersList.get(0).getCustomerId();

			// 判断已有的黑白名单数量是否已经超过的最大数量，如果超过，则返回
			Integer blackNum = hgSpecialNumbersDao.findCountByCustomerId(
					customerId, HgSpecialNumbers.BLACKLIST);
			Integer whiteNum = hgSpecialNumbersDao.findCountByCustomerId(
					customerId, HgSpecialNumbers.WHITELIST);
			if ((blackNum + whiteNum) >= this.getMaxNum()) {
				result.setRemark("失败：您的黑白名单设置总数量已经超过了" + this.getMaxNum() + "个");

				return result;
			}

			// 取得设置白名单的所有号码
			List<HgSpecialNumbers> hgSpecialNumbersLoad = hgSpecialNumbersDao
					.findByCustomerId(customerId, HgSpecialNumbers.WHITELIST);
			String numbersLoad = "";
			Iterator<HgSpecialNumbers> itLoad = hgSpecialNumbersLoad.iterator();
			while (itLoad.hasNext()) {
				HgSpecialNumbers hgSpecialNumberLoad = itLoad.next();
				numbersLoad += hgSpecialNumberLoad.getSpecialNumber();
			}

			// 循环设置白名单标识和设置时间,并保存
			Iterator<HgSpecialNumbers> it = hgSpecialNumbersList.iterator();
			String message = "";
			while (it.hasNext()) {
				HgSpecialNumbers hgSpecialNumber = it.next();

				// 判断是否已经保存某号码,如果已经保存则无需保存
				String number = hgSpecialNumber.getSpecialNumber();
				if (numbersLoad.indexOf(number) >= 0) {
					message += number + " ";
				} else {
					hgSpecialNumber
							.setSpecialNumberType(HgSpecialNumbers.WHITELIST);
					Date currentTime = new Date();
					hgSpecialNumber.setSpecialNumberCeratedate(currentTime);
					hgSpecialNumber.setShieldPeriod(shieldPeriod);

					hgSpecialNumbersDao.save(hgSpecialNumber);
				}

			}

			// 返回的结果
			result.setSuccess(true);
			if (message.length() > 0) {
				result.getModel().put("message", message);
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to create white list", e);
			throw new SignatureServiceException("Unable to create white list",
					e);
		}

		return result;
	}

	public Result getWhiteList(User user, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer customerId = user.getCustomerId();

		try {
			// 取得该用户白名单的数量,并新生成Page对象
			Integer totalRecords = hgSpecialNumbersDao.findCountByCustomerId(
					customerId, HgSpecialNumbers.WHITELIST);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<HgSpecialNumbers> hgSpecialNumbersList = hgSpecialNumbersDao
					.findByCustomerIdForPage(customerId,
							HgSpecialNumbers.WHITELIST, offSet, pageSize);

			// 取得该用户黑名单的数量
			Integer blackNum = hgSpecialNumbersDao.findCountByCustomerId(
					customerId, HgSpecialNumbers.BLACKLIST);

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("whiteList", hgSpecialNumbersList);
			result.getModel().put("page", page);
			result.getModel().put("whiteNum", totalRecords);
			result.getModel().put("blackNum", blackNum);
			result.getModel().put("maxNum", this.getMaxNum());
		} catch (SignaturePersistException e) {
			logger.error("Unable to get white list", e);
			throw new SignatureServiceException("Unable to get white list", e);
		}

		return result;
	}

	public Result createRefuseList(User user, HgSpecialNumbers hgSpecialNumbers)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 登录用户账号（手机号）
		String loginName = user.getLoginName();

		// 特殊号码
		String specialNumber = hgSpecialNumbers.getSpecialNumber();

		try {
			HgCustomer hgCustomer = hgCustomerDao
					.getByCustomerName(specialNumber);

			if (hgCustomer != null) {
				Integer specialNumberId = hgCustomer.getId();

				// 用户已有的拒绝签名
				List<HgSpecialNumbers> hgSpecialNumbersLoad = hgSpecialNumbersDao
						.findByNumber(loginName, HgSpecialNumbers.REFUSELIST);
				String specialNumberIds = "";
				Iterator<HgSpecialNumbers> itLoad = hgSpecialNumbersLoad
						.iterator();
				while (itLoad.hasNext()) {
					HgSpecialNumbers hgSpecialNumberLoad = itLoad.next();
					specialNumberIds += hgSpecialNumberLoad.getCustomerId()
							.toString();
				}

				// 如果拒绝签名中已有则不保存，否则进行保存
				if (specialNumberIds.indexOf(specialNumberId.toString()) >= 0) {
					result.setSuccess(false);
					result.setRemark("失败：号码 "+specialNumber+" 已经添加过");

				} else {
					hgSpecialNumbers.setCustomerId(specialNumberId);
					hgSpecialNumbers
							.setSpecialNumberType(HgSpecialNumbers.REFUSELIST);
					Date currentTime = new Date();
					hgSpecialNumbers.setSpecialNumberCeratedate(currentTime);
					hgSpecialNumbers.setShieldPeriod(shieldPeriod);
					hgSpecialNumbers.setSpecialNumber(loginName);
					hgSpecialNumbersDao.save(hgSpecialNumbers);
					
					result.setSuccess(true);
				}

			} else {
				result.setSuccess(false);
				result.setRemark("失败：号码 "+specialNumber+" 尚未开通业务");
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to create refuse list", e);
			throw new SignatureServiceException("Unable to create refuse list", e);
		}

		return result;
	}

	public Result getRefuseList(User user, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		// 用户手机号码
		String loginName = user.getLoginName();

		try {
			// 取得该用户白名单的数量,并新生成Page对象
			Integer totalRecords = hgSpecialNumbersDao.findCountByNumber(
					loginName, HgSpecialNumbers.REFUSELIST);

			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<HgSpecialNumbers> hgSpecialNumbersList = hgSpecialNumbersDao
					.findByNumberForPage(loginName,
							HgSpecialNumbers.REFUSELIST, offSet, pageSize);
			
			//由于没有设置外键，所以不得不遍历查询CustomerName，太操蛋了
			Iterator<HgSpecialNumbers> it = hgSpecialNumbersList.iterator();
			while(it.hasNext()){
				HgSpecialNumbers hgSpecialNumbers = it.next();
				Integer customerId = hgSpecialNumbers.getCustomerId();
				HgCustomer hgCustomer = hgCustomerDao.getById(customerId);
				if(hgCustomer != null){
					hgSpecialNumbers.setCustomerName(hgCustomer.getCustomerName());
				}
			}

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("refuseList", hgSpecialNumbersList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to get refuse list", e);
			throw new SignatureServiceException("Unable to get refuse list", e);
		}

		return result;
	}

	public Result deleteList(List<Integer> hgSpecialNumbersIdList)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 循环删除
		Iterator<Integer> it = hgSpecialNumbersIdList.iterator();
		while (it.hasNext()) {
			Integer hgSpecialNumbersId = it.next();

			try {
				hgSpecialNumbersDao.delete(hgSpecialNumbersId);

				// 返回的结果
				result.setSuccess(true);
			} catch (SignaturePersistException e) {
				logger.error("Unable to delete black list", e);
				throw new SignatureServiceException(
						"Unable to delete black list", e);
			}
		}

		return result;
	}

	/**
	 * 检查是否有相同的手机号码(尚未实现,程序有问题)
	 * 
	 * @param hgSpecialNumbersList
	 * @return Result实例对象
	 * @deprecated
	 */
	private Result checkList(List<HgSpecialNumbers> hgSpecialNumbersList) {
		Result result = Result.createRestult();

		String message = "";
		int i, j;
		boolean isSame = false;
		List<HgSpecialNumbers> hgList = new ArrayList<HgSpecialNumbers>();
		for (i = 0; i < hgSpecialNumbersList.size(); i++) {
			HgSpecialNumbers specialNumber1 = hgSpecialNumbersList.get(i);

			isSame = false;
			for (j = i + 1; j < hgSpecialNumbersList.size(); j++) {
				HgSpecialNumbers specialNumber2 = hgSpecialNumbersList.get(j);

				if (specialNumber1.getSpecialNumber().trim()
						.equals(specialNumber2.getSpecialNumber().trim())) {
					isSame = true;
					hgSpecialNumbersList.remove(j);
					break;
				}

			}

			if (isSame) {
				message = specialNumber1.getSpecialNumber() + " ";
			}

		}

		return result;
	}

	public HgSpecialNumbersDao getHgSpecialNumbersDao() {
		return hgSpecialNumbersDao;
	}

	public void setHgSpecialNumbersDao(HgSpecialNumbersDao hgSpecialNumbersDao) {
		this.hgSpecialNumbersDao = hgSpecialNumbersDao;
	}

	public Integer getMaxNum() throws SignatureServiceException {
		
		Portal portal = (Portal) parameterUtil.getParameter("portal");

		if (portal != null) {
			return portal.getMaxNum();
		} else {
		return maxNum;
	}

		
		
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}

	public HgCustomerDao getHgCustomerDao() {
		return hgCustomerDao;
	}

	public void setHgCustomerDao(HgCustomerDao hgCustomerDao) {
		this.hgCustomerDao = hgCustomerDao;
	}

	public Integer getShieldPeriod() {
		return shieldPeriod;
	}

	public void setShieldPeriod(Integer shieldPeriod) {
		this.shieldPeriod = shieldPeriod;
	}

	public ParameterUtil getParameterUtil() {
		return parameterUtil;
}

	public void setParameterUtil(ParameterUtil parameterUtil) {
		this.parameterUtil = parameterUtil;
	}
	
	

}
