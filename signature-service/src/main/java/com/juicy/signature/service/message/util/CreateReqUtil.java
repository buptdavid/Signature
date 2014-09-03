/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.message.util;

import com.juicy.signature.service.message.factory.WSFactory;
import com.juicy.signature.service.message.southinter.SmsReq;
import com.juicy.signature.service.message.southinter.TaskReq;

/**
 * 
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-9 创建
 *          </p>
 */
public class CreateReqUtil {
	/**
	 * @desc 生成策略审批提示短信
	 * @param customerName
	 * @param ruleId
	 * @param ruleName
	 * @param ruleType
	 * @param ruleState
	 * @param managerCSDN
	 * @return
	 */
	public static SmsReq createSmsReq(String customerName, int ruleId,
			String ruleName, int ruleType, int ruleState, String managerMSDN) {
		SmsReq smsReq = new SmsReq();
		StringBuffer content = new StringBuffer();
		if (ruleType == 1) {
			switch (ruleState) {
			case 1:
				content.append("您好, 客户");
				content.append("(" + customerName + ")提交新的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(". 请审批.");
				break;
			case 2:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")申请审批的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".审批未通过,敬知.");
				break;
			case 3:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")申请审批的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".审批通过正在应用,敬知.");
				break;
			case 4:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".已经暂停应用,敬知.");
				break;
			case 5:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".已经正常结束,敬知.");
				break;
			case 6:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".转为终止状态,敬知.");
				break;
			default:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".处于非正常状态,请联系管理员.");
				break;
			}
		} else if (ruleType == 0) {
			switch (ruleState) {
			case 1:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")提交新的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(". 请审批.");
				break;
			case 2:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")申请审批的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".审批未通过,敬知.");
				break;
			case 3:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")申请审批的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".正常发送,敬知.");
				break;
			case 4:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")申请审批的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".已被终止,敬知.");
				break;
			case 5:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")申请审批的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".正常结束,敬知.");
				break;
			case 6:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")申请审批的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".处于锁定状态即将发送,敬知.");
				break;
			case 7:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")申请审批的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".审批通过等待发送,敬知.");
				break;
			default:
				content.append("您好, 客户:");
				content.append("(" + customerName + ")的策略ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".处于非正常状态,请联系管理员.");
				break;
			}
		} else {
			System.out.println("无效的策略类型!");
		}
		smsReq.setMsdn(managerMSDN);
		smsReq.setCode(WSFactory.smsChannel);
		smsReq.setContent(content.toString());
		return smsReq;
	}

	/**
	 * @desc 生成任务状态改变通知
	 * @param ruleId
	 * @param ruleType
	 *            0:群发任务；1挂机任务
	 * @param ruleState
	 * @return
	 */
	public static TaskReq createTaskReq(int ruleId, int ruleType, int ruleState) {
		TaskReq taskReq = new TaskReq();
		taskReq.setMsdn("");
		taskReq.setTaskID(ruleId);
		String content = ruleType + "," + ruleState;
		taskReq.setContent(content);
		return taskReq;
	}
}