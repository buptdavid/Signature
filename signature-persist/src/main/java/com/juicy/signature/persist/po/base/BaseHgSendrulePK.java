package com.juicy.signature.persist.po.base;

import java.io.Serializable;


public abstract class BaseHgSendrulePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.Integer sendruleId;
	private java.lang.Integer customerId;


	public BaseHgSendrulePK () {}
	
	public BaseHgSendrulePK (
		java.lang.Integer sendruleId,
		java.lang.Integer customerId) {

		this.setSendruleId(sendruleId);
		this.setCustomerId(customerId);
	}


	/**
	 * Return the value associated with the column: SENDRULE_ID
	 */
	public java.lang.Integer getSendruleId () {
		return sendruleId;
	}

	/**
	 * Set the value related to the column: SENDRULE_ID
	 * @param sendruleId the SENDRULE_ID value
	 */
	public void setSendruleId (java.lang.Integer sendruleId) {
		this.sendruleId = sendruleId;
	}



	/**
	 * Return the value associated with the column: CUSTOMER_ID
	 */
	public java.lang.Integer getCustomerId () {
		return customerId;
	}

	/**
	 * Set the value related to the column: CUSTOMER_ID
	 * @param customerId the CUSTOMER_ID value
	 */
	public void setCustomerId (java.lang.Integer customerId) {
		this.customerId = customerId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.juicy.signature.persist.po.HgSendrulePK)) return false;
		else {
			com.juicy.signature.persist.po.HgSendrulePK mObj = (com.juicy.signature.persist.po.HgSendrulePK) obj;
			if (null != this.getSendruleId() && null != mObj.getSendruleId()) {
				if (!this.getSendruleId().equals(mObj.getSendruleId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getCustomerId() && null != mObj.getCustomerId()) {
				if (!this.getCustomerId().equals(mObj.getCustomerId())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getSendruleId()) {
				sb.append(this.getSendruleId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getCustomerId()) {
				sb.append(this.getCustomerId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


}