/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.message.util;

import com.juicy.signature.service.message.factory.WSFactory;
import com.juicy.signature.service.message.southinter.SmsReq;
import com.juicy.signature.service.message.southinter.TaskReq;

/**
 * 
 * 
 * @author ·����
 * @version <p>
 *          2011-8-9 ����
 *          </p>
 */
public class CreateReqUtil {
	/**
	 * @desc ���ɲ���������ʾ����
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
				content.append("����, �ͻ�");
				content.append("(" + customerName + ")�ύ�µĲ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(". ������.");
				break;
			case 2:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")���������Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".����δͨ��,��֪.");
				break;
			case 3:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")���������Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".����ͨ������Ӧ��,��֪.");
				break;
			case 4:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")�Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".�Ѿ���ͣӦ��,��֪.");
				break;
			case 5:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")�Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".�Ѿ���������,��֪.");
				break;
			case 6:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")�Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".תΪ��ֹ״̬,��֪.");
				break;
			default:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")�Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".���ڷ�����״̬,����ϵ����Ա.");
				break;
			}
		} else if (ruleType == 0) {
			switch (ruleState) {
			case 1:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")�ύ�µĲ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(". ������.");
				break;
			case 2:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")���������Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".����δͨ��,��֪.");
				break;
			case 3:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")���������Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".��������,��֪.");
				break;
			case 4:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")���������Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".�ѱ���ֹ,��֪.");
				break;
			case 5:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")���������Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".��������,��֪.");
				break;
			case 6:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")���������Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".��������״̬��������,��֪.");
				break;
			case 7:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")���������Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".����ͨ���ȴ�����,��֪.");
				break;
			default:
				content.append("����, �ͻ�:");
				content.append("(" + customerName + ")�Ĳ���ID:");
				content.append(ruleId + "(" + ruleName + "),");
				content.append(".���ڷ�����״̬,����ϵ����Ա.");
				break;
			}
		} else {
			System.out.println("��Ч�Ĳ�������!");
		}
		smsReq.setMsdn(managerMSDN);
		smsReq.setCode(WSFactory.smsChannel);
		smsReq.setContent(content.toString());
		return smsReq;
	}

	/**
	 * @desc ��������״̬�ı�֪ͨ
	 * @param ruleId
	 * @param ruleType
	 *            0:Ⱥ������1�һ�����
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