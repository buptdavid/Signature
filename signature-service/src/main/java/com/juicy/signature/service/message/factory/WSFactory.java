/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.message.factory;

/**
 * WebService�ͻ��˹���Factory
 *
 * @author ·����
 * @version <p>2011-8-9 ����</p>
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.rpc.ServiceException;

import com.juicy.signature.service.message.southinter.SmsReq;
import com.juicy.signature.service.message.southinter.WebControlPortType;
import com.juicy.signature.service.message.southinter.WebControl_ServiceLocator;

public class WSFactory {

	private static WebControlPortType client = null;

	public static String WSDLADDRESS = "";

	public static String smsChannel = "";

	public static WebControlPortType getClient() {
		WSDLADDRESS = getWsdlAddress();
		if (client == null) {
			try {
				client = new WebControl_ServiceLocator(WSDLADDRESS).getwebControl();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		System.out.println("��ȡλ��ƽ̨WebService�ӿڿͻ��˳ɹ�.");
		return client;
	}

	public static String getWsdlAddress() {
		String addr = "";
		InputStream input = null;
		try {			
			input = WSFactory.class.getResourceAsStream("/HGSMSInfo.properties");
			Properties p = new Properties();
			p.load(input);
			addr = p.getProperty("webserviceaddress");
			smsChannel = p.getProperty("smschannel");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return addr;
	}
	
	public static void main(String[] args){
		String loginName = "13146895241";
		String message = "haha";
		
		WebControlPortType client = WSFactory.getClient();
		SmsReq smsReq = new SmsReq();
		smsReq.setMsdn(loginName);
		smsReq.setCode(WSFactory.smsChannel);
		smsReq.setContent(message);
		System.out.println("OK");
	}
}
