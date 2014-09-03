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
public class TaskReq implements java.io.Serializable {
	private int taskID;

	private java.lang.String msdn;

	private java.lang.String content;

	public TaskReq() {
	}

	public TaskReq(int taskID, java.lang.String msdn, java.lang.String content) {
		this.taskID = taskID;
		this.msdn = msdn;
		this.content = content;
	}

	/**
	 * Gets the taskID value for this TaskReq.
	 * 
	 * @return taskID
	 */
	public int getTaskID() {
		return taskID;
	}

	/**
	 * Sets the taskID value for this TaskReq.
	 * 
	 * @param taskID
	 */
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	/**
	 * Gets the msdn value for this TaskReq.
	 * 
	 * @return msdn
	 */
	public java.lang.String getMsdn() {
		return msdn;
	}

	/**
	 * Sets the msdn value for this TaskReq.
	 * 
	 * @param msdn
	 */
	public void setMsdn(java.lang.String msdn) {
		this.msdn = msdn;
	}

	/**
	 * Gets the content value for this TaskReq.
	 * 
	 * @return content
	 */
	public java.lang.String getContent() {
		return content;
	}

	/**
	 * Sets the content value for this TaskReq.
	 * 
	 * @param content
	 */
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof TaskReq))
			return false;
		TaskReq other = (TaskReq) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& this.taskID == other.getTaskID()
				&& ((this.msdn == null && other.getMsdn() == null) || (this.msdn != null && this.msdn
						.equals(other.getMsdn())))
				&& ((this.content == null && other.getContent() == null) || (this.content != null && this.content
						.equals(other.getContent())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		_hashCode += getTaskID();
		if (getMsdn() != null) {
			_hashCode += getMsdn().hashCode();
		}
		if (getContent() != null) {
			_hashCode += getContent().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			TaskReq.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"http://zctt.com/hangup/webControl.wsdl", "taskReq"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("taskID");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://zctt.com/hangup/webControl.wsdl", "taskID"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "int"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("msdn");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://zctt.com/hangup/webControl.wsdl", "msdn"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("content");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://zctt.com/hangup/webControl.wsdl", "content"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType,
				_xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType,
				_xmlType, typeDesc);
	}

}