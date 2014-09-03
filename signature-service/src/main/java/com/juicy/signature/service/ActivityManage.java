/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.Date;
import java.util.List;

import com.juicy.signature.persist.po.Activity;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * �Żݻ����Service�ӿ�
 *
 * @author ·����
 * @version <p>Oct 27, 2011 ����</p>
 */
public interface ActivityManage {
	
	/**
	 * ��ʾ�
	 * 
	 * @param startTime ���ʼʱ�䣬���Ϊnull��ʾû�п�ʼʱ��
	 * @param endTime �����ʱ�䣬���Ϊnull��ʾû�н���ʱ��
	 * @param isDelete �Ƿ�ɾ����0��ʾδɾ����1��ʾɾ��,null��ʾȫ��
	 * @param page ��ҳ����
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewActivity(Date startTime, Date endTime, Boolean isDelete,Page page) throws SignatureServiceException;
	
	/**
	 * �����
	 * 
	 * @param activity Activity�ʵ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result createActivity(Activity activity) throws SignatureServiceException;
	
	/**
	 * ɾ���
	 * 
	 * @param activities Ҫɾ���ĻID��List
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result deleteActivity(List<Integer> activities) throws SignatureServiceException;
	
	/**
	 * ȡ��ɾ���
	 * 
	 * @param activities Ҫȡ��ɾ���ĻID��List
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result undeleteActivity(List<Integer> activities) throws SignatureServiceException;
	
	/**
	 * ��ʾ�޸Ļ
	 * 
	 * @param activityId �ID
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result viewModify(Integer activityId) throws SignatureServiceException;
	
	/**
	 * �޸Ļ
	 * 
	 * @param activity Ҫ�޸ĵ�Activity�ʵ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result modifyActivity(Activity activity) throws SignatureServiceException;
	
	/**
	 * ����Ϊ��ҳչʾ
	 * 
	 * @param activity Ҫ����Ϊ��ҳչʾ��Activity�ʵ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result setIndex(Activity activity) throws SignatureServiceException;
	
	/**
	 * ȡ����ҳչʾ
	 * 
	 * @param activity Ҫȡ����ҳ��ʾ��Activity�ʵ��
	 * @return Result���ʵ��
	 * @throws SignatureServiceException
	 */
	public Result cancelIndex(Activity activity) throws SignatureServiceException;
	
	

}
