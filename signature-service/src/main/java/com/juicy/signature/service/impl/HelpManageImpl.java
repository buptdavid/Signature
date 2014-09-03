/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.HelpDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Help;
import com.juicy.signature.service.HelpManage;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.result.Result;

/**
 * 帮助管理HelpManage接口实现类
 *
 * @author 路卫杰
 * @version <p>Oct 31, 2011 创建</p>
 */
public class HelpManageImpl implements HelpManage {

	private HelpDao helpDao;
	
	/** 日志记录 */
	private static Log logger = LogFactory.getLog(HelpManageImpl.class);
	
	public Result view() throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {
			Help help = helpDao.getHelp();
			
			result.setSuccess(true);
			result.getModel().put("help", help);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view help");
			throw new SignatureServiceException("Unable to view help", e);
		}
		
		return result;
	}

	public Result modify(String content) throws SignatureServiceException {
		Result result = Result.createRestult();
		
		try {
			helpDao.saveOrUpdate(content);
			
			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to modify help");
			throw new SignatureServiceException("Unable to modify help", e);
		}
		
		return result;
	}

	public HelpDao getHelpDao() {
		return helpDao;
	}

	public void setHelpDao(HelpDao helpDao) {
		this.helpDao = helpDao;
	}
	
	

}
