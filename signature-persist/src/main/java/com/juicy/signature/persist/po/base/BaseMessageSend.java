package com.juicy.signature.persist.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MESSAGE_SEND table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MESSAGE_SEND"
 */

public abstract class BaseMessageSend  implements Serializable {

	public static String REF = "MessageSend";
	public static String PROP_MANAGER_ID = "ManagerId";
	public static String PROP_CONTROL_NUM = "ControlNum";
	public static String PROP_GMT_TIME = "GmtTime";
	public static String PROP_SM_INTERVAL = "SmInterval";
	public static String PROP_ID = "Id";
	public static String PROP_MDF_TIME = "MdfTime";
	public static String PROP_FLOW_CONTROL = "FlowControl";


	// constructors
	public BaseMessageSend () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMessageSend (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer flowControl;
	private java.lang.Integer smInterval;
	private java.lang.Integer controlNum;
	private java.lang.Integer managerId;
	private java.util.Date mdfTime;
	private java.util.Date gmtTime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: flow_control
	 */
	public java.lang.Integer getFlowControl () {
		return flowControl;
	}

	/**
	 * Set the value related to the column: flow_control
	 * @param flowControl the flow_control value
	 */
	public void setFlowControl (java.lang.Integer flowControl) {
		this.flowControl = flowControl;
	}



	/**
	 * Return the value associated with the column: sm_interval
	 */
	public java.lang.Integer getSmInterval () {
		return smInterval;
	}

	/**
	 * Set the value related to the column: sm_interval
	 * @param smInterval the sm_interval value
	 */
	public void setSmInterval (java.lang.Integer smInterval) {
		this.smInterval = smInterval;
	}



	/**
	 * Return the value associated with the column: control_num
	 */
	public java.lang.Integer getControlNum () {
		return controlNum;
	}

	/**
	 * Set the value related to the column: control_num
	 * @param controlNum the control_num value
	 */
	public void setControlNum (java.lang.Integer controlNum) {
		this.controlNum = controlNum;
	}



	/**
	 * Return the value associated with the column: manager_id
	 */
	public java.lang.Integer getManagerId () {
		return managerId;
	}

	/**
	 * Set the value related to the column: manager_id
	 * @param managerId the manager_id value
	 */
	public void setManagerId (java.lang.Integer managerId) {
		this.managerId = managerId;
	}



	/**
	 * Return the value associated with the column: mdf_time
	 */
	public java.util.Date getMdfTime () {
		return mdfTime;
	}

	/**
	 * Set the value related to the column: mdf_time
	 * @param mdfTime the mdf_time value
	 */
	public void setMdfTime (java.util.Date mdfTime) {
		this.mdfTime = mdfTime;
	}



	/**
	 * Return the value associated with the column: gmt_time
	 */
	public java.util.Date getGmtTime () {
		return gmtTime;
	}

	/**
	 * Set the value related to the column: gmt_time
	 * @param gmtTime the gmt_time value
	 */
	public void setGmtTime (java.util.Date gmtTime) {
		this.gmtTime = gmtTime;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.MessageSend)) return false;
		else {
			com.juicy.signature.persist.po.MessageSend messageSend = (com.juicy.signature.persist.po.MessageSend) obj;
			if (null == this.getId() || null == messageSend.getId()) return false;
			else return (this.getId().equals(messageSend.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}