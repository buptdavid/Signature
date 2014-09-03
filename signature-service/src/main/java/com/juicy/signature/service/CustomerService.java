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
 * �ͻ���صĹ���Service
 * 
 * @author ·����
 * @version <p>
 *          2011-9-26 ����
 *          </p>
 */
public interface CustomerService {

	/**
	 * ��ʱ���ͻ��������Ƿ���ڣ������������λΪ�ѹ��ڡ�
	 * 
	 * @return  Resultʵ������
	 * @throws SignatureServiceException
	 */
	public Result checkExperience() throws SignatureServiceException;

	/**
	 * ��ҳ��ʾ�ͻ�
	 * 
	 * @param startTime ��ʼʱ��,���Ϊnull��ʾû�п�ʼʱ��
	 * @param endTime ����ʱ�䣬���Ϊnull��ʾû�н���ʱ��
	 * @param customerStat �ͻ�����״̬�����Ϊnull��ʾ���пͻ�
	 * @param page ��ҳ��Ϣ����
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result view(Date startTime, Date endTime,Integer customerStat, Page page)
			throws SignatureServiceException;
	
	/**
	 * ͳ��һ��ʱ�������Ч�Ŀͻ�����
	 * 
	 * @param startTime ��ʼʱ��,���Ϊnull��ʾû�п�ʼʱ��
	 * @param endTime ����ʱ�䣬���Ϊnull��ʾû�н���ʱ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result statistic(Date startTime, Date endTime) throws SignatureServiceException;

}
