/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
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
 * �ͻ���ص�Serviceʵ����
 * 
 * @author ·����
 * @version <p>
 *          2011-9-26 ����
 *          </p>
 */
public class CustomerServiceImpl implements CustomerService {

	/** ���������ҵ�������,Ĭ��Ϊ30�� */
	private Integer experienceDay;

	HgCustomerDao hgCustomerDao;

	private ParameterUtil parameterUtil;

	/** ��־��¼ */
	private static Log logger = LogFactory.getLog(CustomerServiceImpl.class);

	public Result checkExperience() throws SignatureServiceException {
		Result result = Result.createRestult();

		logger.info("Timer start:��ʱ�����������û���Ч�ڼ��ҵ���߼���ʼ......");

		try {
			// ȡ�����������û�
			List<HgCustomer> hgCustomerList = hgCustomerDao
					.findByStat(HgCustomer.EXPERIENCE);
			Iterator<HgCustomer> it = hgCustomerList.iterator();

			// ͳ�Ƹ���״̬�Ŀͻ�����
			int num = 0;
			
			//��long�ͣ���ֹ��ֵ���������
			long dayLong = this.getExperienceDay();
			
			// ���������ĺ�����
			long experienceMilliSeconds = dayLong * 24	* 60 * 60 * 1000L;
			
			// ��ǰʱ��
			Date currentTime = new Date();
			long currentMilliSeconds = currentTime.getTime();

			// ������������Ƿ����
			while (it.hasNext()) {
				HgCustomer hgCustomer = it.next();
				// ��Чʱ��
				Date effectiveDate = hgCustomer.getEffectiveDate();
				long effectiveMilliSeconds = effectiveDate.getTime();

				// ����������������������¶���״̬
				if ((effectiveMilliSeconds + experienceMilliSeconds) < currentMilliSeconds) {
					hgCustomer.setCustomerStat(HgCustomer.EXPERIENCE_END);
					// ����״̬����ʱ��
					hgCustomer.setUpdateTime(new Date());
					hgCustomerDao.update(hgCustomer);
					num++;
					logger.info("Timer customer: �ͻ�ID�� " + hgCustomer.getId() + " �ͻ��绰�� "
							+ hgCustomer.getCustomerName());
				}

			}

			logger.info("Timer total: ����״̬�Ŀͻ�����Ϊ�� " + num);
			logger.info("Timer end: ��ʱ�����������û���Ч�ڼ��ҵ���߼�����");

			result.setSuccess(true);

		} catch (SignaturePersistException e) {
			logger.error("Timer fail: ��ʱ�����������û���Ч�ڼ��ҵ���߼�ִ��ʧ��,ִ��ʱ��: " + new Date(), e);
			throw new SignatureServiceException(
					"��ʱ�����������û���Ч�ڼ��ҵ���߼�ִ��ʧ��,ִ��ʱ��: " + new Date(), e);
		}

		// ����
		return result;
	}

	public Result view(Date startTime, Date endTime, Integer customerStat,
			Page page) throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// ������
			Integer totalRecords = hgCustomerDao.findCountByStat(startTime,
					endTime, customerStat, null);
			page = PageUtil.createPage(page, totalRecords);

			// ��һ����¼������ÿҳ�ļ�¼����
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			// ��ѯ���
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

			// ����״̬�û�ͳ��
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.ORDERED, null);
			statisticMap.put("�����û�", count);

			// �˶�״̬�û�ͳ��
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.QUIT_ORDERED, null);
			statisticMap.put("�˶��û�", count);

			// ��ͣ״̬�û�ͳ��
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.PAUSE_ORDERED, null);
			statisticMap.put("��ͣ�û�", count);

			// ҵ�����״̬�û�ͳ��
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.EXPIRED_ORDERED, null);
			statisticMap.put("ҵ������û�", count);

			// �������״̬�û�ͳ��
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.EXPERIENCE, null);
			statisticMap.put("��������û�", count);

			// ����������״̬�û�ͳ��
			count = hgCustomerDao.findCountByStat(startTime, endTime,
					HgCustomer.EXPERIENCE_END, null);
			statisticMap.put("�����������û�", count);

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
