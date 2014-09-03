/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.message.southinter;

/**
 * 
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-9 创建
 *          </p>
 */
public class WebControl_ServiceLocator extends org.apache.axis.client.Service implements WebControl_Service {

/**
 * service
 */
	 // Use to get a proxy class for webControl
    private java.lang.String webControl_address = "http://192.168.3.33:8083/webControl.cgi";

    public WebControl_ServiceLocator() {
    }
    
    public WebControl_ServiceLocator(String address){
    	this.webControl_address = "http://"+address+"/webControl.cgi";
    }


    public WebControl_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebControl_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

   

    public java.lang.String getwebControlAddress() {
        return webControl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String webControlWSDDServiceName = "webControl";

    public java.lang.String getwebControlWSDDServiceName() {
        return webControlWSDDServiceName;
    }

    public void setwebControlWSDDServiceName(java.lang.String name) {
        webControlWSDDServiceName = name;
    }

    public WebControlPortType getwebControl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(webControl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwebControl(endpoint);
    }

    public WebControlPortType getwebControl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            WebControl_BindingStub _stub = new WebControl_BindingStub(portAddress, this);
            _stub.setPortName(getwebControlWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwebControlEndpointAddress(java.lang.String address) {
        webControl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (WebControlPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                WebControl_BindingStub _stub = new WebControl_BindingStub(new java.net.URL(webControl_address), this);
                _stub.setPortName(getwebControlWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("webControl".equals(inputPortName)) {
            return getwebControl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://zctt.com/hangup/webControl.wsdl", "webControl");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://zctt.com/hangup/webControl.wsdl", "webControl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("webControl".equals(portName)) {
            setwebControlEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

	public java.lang.String getWebControl_address() {
		return webControl_address;
	}

	public void setWebControl_address(java.lang.String webControl_address) {
		this.webControl_address = webControl_address;
	}
    
    

}
