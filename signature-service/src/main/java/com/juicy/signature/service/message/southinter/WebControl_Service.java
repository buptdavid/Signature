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
public interface WebControl_Service extends javax.xml.rpc.Service {

/**
 * service
 */
    public java.lang.String getwebControlAddress();

    public WebControlPortType getwebControl() throws javax.xml.rpc.ServiceException;

    public WebControlPortType getwebControl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

