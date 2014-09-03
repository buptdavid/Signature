/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.HgComboDetailDao;
import com.juicy.signature.persist.dao.HgDefruleContentDao;
import com.juicy.signature.persist.dao.HgDiyInfoDao;
import com.juicy.signature.persist.dao.HgFirmParameterDao;
import com.juicy.signature.persist.dao.HgSysSpecialNumbersDao;
import com.juicy.signature.persist.dao.MessageSendDao;
import com.juicy.signature.persist.dao.PortalDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgComboDetail;
import com.juicy.signature.persist.po.HgDefruleContent;
import com.juicy.signature.persist.po.HgFirmParameter;
import com.juicy.signature.persist.po.HgSysSpecialNumbers;
import com.juicy.signature.persist.po.MessageSend;
import com.juicy.signature.persist.po.Portal;
import com.juicy.signature.service.SystemManage;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;
import com.whirlycott.cache.Cache;
import com.whirlycott.cache.CacheException;
import com.whirlycott.cache.CacheManager;

/**
 * 系统管理业务逻辑实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          Nov 28, 2011 创建
 *          </p>
 */
public class SystemManageImpl implements SystemManage {

	private MessageSendDao messageSendDao;

	private PortalDao portalDao;

	private HgComboDetailDao hgComboDetailDao;

	private HgFirmParameterDao hgFirmParameterDao;

	private HgSysSpecialNumbersDao hgSysSpecialNumbersDao;

	private HgDefruleContentDao hgDefruleContentDao;

	private HgDiyInfoDao hgDiyInfoDao;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(SystemManageImpl.class);

	public Result viewPortalParameter() throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Portal portal = portalDao.findPortal();

			result.setSuccess(true);
			result.getModel().put("portal", portal);

		} catch (SignaturePersistException e) {
			logger.error("Unable to view portal parameter");
			throw new SignatureServiceException(
					"Unable to view portal parameter", e);
		}

		return result;
	}

	public Result savePortalParameter(Portal portal)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer portalId = portal.getId();

		try {
			// 数据库中只保存一行portal数据
			if (portalId == null) {
				// 第一次保存
				portal.setGmtTime(new Date());
				portal.setMdfTime(new Date());

				portalDao.save(portal);

			} else {
				// 修改
				Portal portal_1 = portalDao.getById(portalId);

				portal_1.setExperienceDay(portal.getExperienceDay());
				portal_1.setManagerId(portal.getManagerId());
				portal_1.setMaxCountOriginal(portal.getMaxCountOriginal());
				portal_1.setMaxDefaultCount(portal.getMaxDefaultCount());
				portal_1.setMaxNum(portal.getMaxNum());
				portal_1.setMaxPersonalizeCount(portal.getMaxPersonalizeCount());
				portal_1.setMdfTime(new Date());

				portalDao.update(portal_1);
			}

			// 清除缓存
			Cache cache = CacheManager.getInstance().getCache();
			cache.remove("portal");

			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to save portal parameter");
			throw new SignatureServiceException(
					"Unable to save portal parameter", e);
		} catch (CacheException e) {
			logger.error("Unable to update portal from Cache");
			throw new SignatureServiceException(
					"Unable to update portal from Cache", e);
		}

		return result;
	}

	public Result viewMessageSend() throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			MessageSend messageSend = messageSendDao.findMessageSend();
			HgComboDetail hgComboDetail = hgComboDetailDao.findHgComboDetail();
			HgFirmParameter hgFirmParameter = hgFirmParameterDao
					.findHgFirmParameter();

			result.setSuccess(true);
			result.getModel().put("messageSend", messageSend);
			result.getModel().put("hgComboDetail", hgComboDetail);
			result.getModel().put("hgFirmParameter", hgFirmParameter);

		} catch (SignaturePersistException e) {
			logger.error("Unable to view message send");
			throw new SignatureServiceException("Unable to view message send",
					e);
		}

		return result;
	}

	public Result saveMessageSend(MessageSend messageSend,
			HgComboDetail hgComboDetail, HgFirmParameter hgFirmParameter)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 保存hgComboDetail
		try {
			Integer messageSendId = messageSend.getId();
			if (messageSendId == null) {
				// 第一次保存
				messageSend.setGmtTime(new Date());
				messageSend.setMdfTime(new Date());

				messageSendDao.save(messageSend);

			} else {
				// 修改
				MessageSend messageSend_1 = messageSendDao
						.getById(messageSendId);

				messageSend_1.setControlNum(messageSend.getControlNum());
				messageSend_1.setFlowControl(messageSend.getFlowControl());
				messageSend_1.setSmInterval(messageSend.getSmInterval());

				messageSend_1.setManagerId(messageSend.getManagerId());
				messageSend_1.setMdfTime(new Date());

				messageSendDao.update(messageSend_1);

			}

			// 保存hgComboDetail
			Integer hgComboDetailId = hgComboDetail.getId();
			if (hgComboDetailId == null) {
				// 第一次保存
				// 没用且不能为空的字段暂时写死，如果以后用上再修改
				hgComboDetail.setMessageTypeId(3);
				hgComboDetail.setComboRuleType(1);

				hgComboDetailDao.save(hgComboDetail);

			} else {
				// 修改
				HgComboDetail hgComboDetail_1 = hgComboDetailDao
						.getById(hgComboDetailId);
				hgComboDetail_1.setComboMsgNumber(hgComboDetail
						.getComboMsgNumber());

				hgComboDetailDao.update(hgComboDetail_1);

			}

			// 保存hgFirmParameter
			Integer hgFirmParameterId = hgFirmParameter.getId();
			if (hgFirmParameterId == null) {
				// 第一次保存
				// 没用且不能为空的字段暂时写死，如果以后用上再修改
				hgFirmParameter.setCustomerId(0);
				hgFirmParameter.setFirmParameterName("超限控制");
				hgFirmParameter.setFirmParameterString("OVERLIMITCONTROL");

				hgFirmParameterDao.save(hgFirmParameter);

			} else {
				// 修改
				HgFirmParameter hgFirmParameter_1 = hgFirmParameterDao
						.getById(hgFirmParameterId);

				hgFirmParameter_1.setFirmParameterValue(hgFirmParameter
						.getFirmParameterValue());

				hgFirmParameterDao.update(hgFirmParameter_1);

			}

			result.setSuccess(true);

		} catch (SignaturePersistException e) {
			logger.error("Unable to save message send ");
			throw new SignatureServiceException("Unable to save message send ",
					e);
		}

		return result;
	}

	public Result viewSysSpecialNumbers(String number, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 取得总数量,并新生成Page对象
		Integer totalRecords;
		try {
			totalRecords = hgSysSpecialNumbersDao.findCountByNumber(number);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			// 分页查找
			List<HgSysSpecialNumbers> specialList = hgSysSpecialNumbersDao
					.findByNumberForPage(number, offSet, pageSize);

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("specialList", specialList);
			result.getModel().put("page", page);

		} catch (SignaturePersistException e) {
			logger.error("Unable to view system special numbers ");
			throw new SignatureServiceException(
					"Unable to view system special numbers ", e);
		}

		return result;
	}

	public Result saveSysSpecialNumbers(HgSysSpecialNumbers hgSysSpecialNumbers)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {

			// 判断其是否已经存在
			String specialNumber = hgSysSpecialNumbers.getSysSpecialNumber();

			if (specialNumber.startsWith("86")) {
				specialNumber = specialNumber.substring(2,
						specialNumber.length());
				hgSysSpecialNumbers.setSysSpecialNumber(specialNumber);
			}

			Integer count = hgSysSpecialNumbersDao
					.findCountByNumber(specialNumber);
			if (count > 0) {
				result.setSuccess(false);
				result.setRemark(specialNumber + " 已经存在，请勿重复添加！");

				// 返回
				return result;
			}

			// 有效时间默认1000个月
			hgSysSpecialNumbers.setShieldPeriod(1000);
			hgSysSpecialNumbers.setSpecialNumberCeratedate(new Date());

			// 保存
			hgSysSpecialNumbersDao.save(hgSysSpecialNumbers);

			result.setSuccess(true);

		} catch (SignaturePersistException e) {
			logger.error("Unable to save system special numbers ");
			throw new SignatureServiceException(
					"Unable to save system special numbers ", e);
		}

		return result;
	}

	public Result deleteSysSpecialNumbers(List<HgSysSpecialNumbers> numbers)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 循环删除
		Iterator<HgSysSpecialNumbers> it = numbers.iterator();
		while (it.hasNext()) {
			HgSysSpecialNumbers number = it.next();

			try {
				hgSysSpecialNumbersDao.delete(number.getId());

				result.setSuccess(true);
			} catch (SignaturePersistException e) {
				logger.error("Unable to save system special numbers ");
				throw new SignatureServiceException(
						"Unable to save system special numbers ", e);
			}
		}

		return result;
	}

	public Result viewDefaultContent() throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			HgDefruleContent hgDefruleContent = hgDefruleContentDao
					.getDefruleContent();

			result.setSuccess(true);
			result.getModel().put("defaultContent", hgDefruleContent);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view default content");
			throw new SignatureServiceException(
					"Unable to view default content", e);
		}

		return result;
	}

	public Result saveDefaultContent(HgDefruleContent hgDefruleContent)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			String content = hgDefruleContent.getDefcontent();

			if (content != null) {
				// 替代回车换行
				content = content.replace("\r\n", "");
				hgDefruleContent.setDefcontent(content);
			}

			hgDefruleContentDao.saveOrUpdate(content);

			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to save default content");
			throw new SignatureServiceException(
					"Unable to save default content", e);
		}

		return result;
	}

	public Result modifyGroupContent(String content)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			HgDefruleContent hgDefruleContent = hgDefruleContentDao
					.getDefruleContent();

			if (hgDefruleContent != null) {
				String preContent = hgDefruleContent.getPreContent();
				if (preContent != null && preContent.trim().length() > 0) {

					if (content != null && content.trim().length() > 0) {

						// 替代回车换行
						content = content.replace("\r\n", "");

						Integer amount = hgDiyInfoDao.updateContent(preContent,
								content);

						// 更新前一个签名记录
						hgDefruleContent.setPreContent(content);
						hgDefruleContentDao.update(hgDefruleContent);

						result.setSuccess(true);
						result.getModel().put("amount", amount);

					} else {
						result.setRemark("失败--新签名不能为空！");
					}

				} else {
					result.setRemark("失败--原来签名不存在！");
				}

			} else {
				result.setRemark("失败--原来签名不存在!");
			}

		} catch (SignaturePersistException e) {
			logger.error("Unable to modify default content for group");
			throw new SignatureServiceException(
					"Unable to modify default content for group", e);
		}

		return result;
	}

	public MessageSendDao getMessageSendDao() {
		return messageSendDao;
	}

	public void setMessageSendDao(MessageSendDao messageSendDao) {
		this.messageSendDao = messageSendDao;
	}

	public PortalDao getPortalDao() {
		return portalDao;
	}

	public void setPortalDao(PortalDao portalDao) {
		this.portalDao = portalDao;
	}

	public HgComboDetailDao getHgComboDetailDao() {
		return hgComboDetailDao;
	}

	public void setHgComboDetailDao(HgComboDetailDao hgComboDetailDao) {
		this.hgComboDetailDao = hgComboDetailDao;
	}

	public HgFirmParameterDao getHgFirmParameterDao() {
		return hgFirmParameterDao;
	}

	public void setHgFirmParameterDao(HgFirmParameterDao hgFirmParameterDao) {
		this.hgFirmParameterDao = hgFirmParameterDao;
	}

	public HgSysSpecialNumbersDao getHgSysSpecialNumbersDao() {
		return hgSysSpecialNumbersDao;
	}

	public void setHgSysSpecialNumbersDao(
			HgSysSpecialNumbersDao hgSysSpecialNumbersDao) {
		this.hgSysSpecialNumbersDao = hgSysSpecialNumbersDao;
	}

	public HgDefruleContentDao getHgDefruleContentDao() {
		return hgDefruleContentDao;
	}

	public void setHgDefruleContentDao(HgDefruleContentDao hgDefruleContentDao) {
		this.hgDefruleContentDao = hgDefruleContentDao;
	}

	public HgDiyInfoDao getHgDiyInfoDao() {
		return hgDiyInfoDao;
	}

	public void setHgDiyInfoDao(HgDiyInfoDao hgDiyInfoDao) {
		this.hgDiyInfoDao = hgDiyInfoDao;
	}

}
