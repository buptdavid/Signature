/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.message.southinter;

/**
 * 
 *
 * @author 路卫杰
 * @version <p>2011-8-9 创建</p>
 */
public class WebControl_BindingImpl implements WebControlPortType{
    public int sendsms(SmsReq req) throws java.rmi.RemoteException {
        return -3;
    }

    public int stopTask(TaskReq req) throws java.rmi.RemoteException {
        return -3;
    }

}
