/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.message.southinter;

/**
 * 
 *
 * @author ·����
 * @version <p>2011-8-9 ����</p>
 */
public interface WebControl_Service extends javax.xml.rpc.Service {

/**
 * service
 */
    public java.lang.String getwebControlAddress();

    public WebControlPortType getwebControl() throws javax.xml.rpc.ServiceException;

    public WebControlPortType getwebControl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

