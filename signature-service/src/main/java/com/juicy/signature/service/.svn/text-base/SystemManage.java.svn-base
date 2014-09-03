/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.List;

import com.juicy.signature.persist.po.HgComboDetail;
import com.juicy.signature.persist.po.HgDefruleContent;
import com.juicy.signature.persist.po.HgFirmParameter;
import com.juicy.signature.persist.po.HgSysSpecialNumbers;
import com.juicy.signature.persist.po.MessageSend;
import com.juicy.signature.persist.po.Portal;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 系统管理业务逻辑接口
 *
 * @author 路卫杰
 * @version <p>Nov 25, 2011 创建</p>
 */
public interface SystemManage {
	
	/**
	 * 显示门户参数
	 * 
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewPortalParameter() throws SignatureServiceException;

	
	/**
	 * 保存门户参数
	 * 
	 * @param portal Portal实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result savePortalParameter(Portal portal) throws SignatureServiceException;
	
	/**
	 * 显示信息发送参数
	 * 
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewMessageSend() throws SignatureServiceException;
	
	/**
	 * 保存信息发送参数
	 * 
	 * @param messageSend
	 * @param hgComboDetail
	 * @param hgFirmParameter
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result saveMessageSend(MessageSend messageSend,
			HgComboDetail hgComboDetail, HgFirmParameter hgFirmParameter) throws SignatureServiceException;
	
	/**
	 * 显示系统特殊号码
	 * 
	 * @param number 电话号码，如果为null或长度为0则表示不考虑
	 * @param page 分页实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewSysSpecialNumbers(String number , Page page) throws SignatureServiceException;
	
	/**
	 * 添加系统特殊号码
	 * 
	 * @param hgSysSpecialNumbers 系统特殊号码实例
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result saveSysSpecialNumbers(HgSysSpecialNumbers hgSysSpecialNumbers) throws SignatureServiceException;
	
	/**
	 * 删除系统特殊号码
	 * 
	 * @param numberIds 要删除的系统特殊号码列表
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result deleteSysSpecialNumbers(List<HgSysSpecialNumbers> numbers) throws SignatureServiceException;
	
	/**
	 * 显示系统默认签名
	 * 
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result viewDefaultContent() throws SignatureServiceException;
	
	/**
	 * 保存系统默认签名
	 * 
	 * @param hgDefruleContent 默认签名实例
	 * @return  Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result saveDefaultContent(HgDefruleContent hgDefruleContent) throws SignatureServiceException;
	
	/**
	 * 统一修改陕西联通内部员工未修改的默认签名
	 * 
	 * @param 要修改的默认签名内容
	 * @return Result结果实例
	 * @throws SignatureServiceException
	 */
	public Result modifyGroupContent(String content) throws SignatureServiceException;
	
	
}
