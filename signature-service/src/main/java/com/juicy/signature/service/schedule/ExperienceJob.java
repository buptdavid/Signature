/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.schedule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.juicy.signature.service.CustomerService;
import com.juicy.signature.service.exception.SignatureServiceException;

/**
 * 体验用户定时检查状态任务类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-26 创建
 *          </p>
 */
public class ExperienceJob extends QuartzJobBean {

	/** 判断检查任务是否正在执行 */
	private boolean isRunning = false;

	/** CustomerService实例对象 */
	private CustomerService customerService;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(ExperienceJob.class);
	
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		logger.info("任务开始......");
		if (!isRunning) {
			logger.info("开始运行......");
			try {
				isRunning = true;
				
				customerService.checkExperience();
				
				isRunning = false;
			} catch (SignatureServiceException e) {
				//下层已经处理此异常
			}
		}else{
			logger.info("任务已经启动，或前一次任务还未执行完毕");
		}

	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
