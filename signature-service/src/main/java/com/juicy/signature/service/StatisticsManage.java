/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.Date;

import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * ͳ�ƹ���Service�ӿ�
 * 
 * @author ·����
 * @version <p>
 *          Oct 27, 2011 ����
 *          </p>
 */
public interface StatisticsManage {

	/**
	 * ����ʱ���״̬��ʾ���пͻ�
	 * 
	 * @param startTime ��ʼʱ��
	 * @param endTime ����ʱ��
	 * @param customerStat ҵ��״̬
	 * @param loginName �û���¼�˺��ֻ���
	 * @param cityCode ���б��
	 * @param page ��ҳ����
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result handleViewAllCustomer(Date startTime, Date endTime,
			Integer customerStat,String loginName,String cityCode, Page page) throws SignatureServiceException;

	/**
	 * ��ʾ�û���¼���
	 * 
	 * @param loginName �û��˺�
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewUserLogin(String loginName)
			throws SignatureServiceException;

	/**
	 * ��ʾ�ͻ�״̬ͳ��
	 * 
	 * @param startTime ��ʼʱ��
	 * @param endTime ����ʱ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result handleViewCustomerStatistics(Date startTime,Date endTime) throws SignatureServiceException;
	
	/**
	 * ���û���ҵ��״̬
	 * 
	 * @param customerName �û��˺�
	 * @param customerStat �û�״̬
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result setCustomerStat(String customerName, Integer customerStat) throws SignatureServiceException;

}
