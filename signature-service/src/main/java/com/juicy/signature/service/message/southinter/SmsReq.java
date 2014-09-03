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
public class SmsReq implements java.io.Serializable {
	private java.lang.String msdn;

	private java.lang.String code;

	private java.lang.String content;

	public SmsReq() {
	}

	public SmsReq(java.lang.String msdn, java.lang.String code,
			java.lang.String content) {
		this.msdn = msdn;
		this.code = code;
		this.content = content;
	}

	/**
	 * Gets the msdn value for this SmsReq.
	 * 
	 * @return msdn
	 */
	public java.lang.String getMsdn() {
		return msdn;
	}

	/**
	 * Sets the msdn value for this SmsReq.
	 * 
	 * @param msdn
	 */
	public void setMsdn(java.lang.String msdn) {
		this.msdn = msdn;
	}

	/**
	 * Gets the code value for this SmsReq.
	 * 
	 * @return code
	 */
	public java.lang.String getCode() {
		return code;
	}

	/**
	 * Sets the code value for this SmsReq.
	 * 
	 * @param code
	 */
	public void setCode(java.lang.String code) {
		this.code = code;
	}

	/**
	 * Gets the content value for this SmsReq.
	 * 
	 * @return content
	 */
	public java.lang.String getContent() {
		return content;
	}

	/**
	 * Sets the content value for this SmsReq.
	 * 
	 * @param content
	 */
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof SmsReq))
			return false;
		SmsReq other = (SmsReq) obj;
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
				&& ((this.msdn == null && other.getMsdn() == null) || (this.msdn != null && this.msdn
						.equals(other.getMsdn())))
				&& ((this.code == null && other.getCode() == null) || (this.code != null && this.code
						.equals(other.getCode())))
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
		if (getMsdn() != null) {
			_hashCode += getMsdn().hashCode();
		}
		if (getCode() != null) {
			_hashCode += getCode().hashCode();
		}
		if (getContent() != null) {
			_hashCode += getContent().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			SmsReq.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"http://zctt.com/hangup/webControl.wsdl", "smsReq"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("msdn");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://zctt.com/hangup/webControl.wsdl", "msdn"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("code");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"http://zctt.com/hangup/webControl.wsdl", "code"));
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
