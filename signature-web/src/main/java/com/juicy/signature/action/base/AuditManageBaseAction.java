/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action.base;

import com.juicy.signature.service.AuditManage;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��˹������Action
 *
 * @author ·����
 * @version <p>Nov 23, 2011 ����</p>
 */
public class AuditManageBaseAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	protected AuditManage auditManage;

	public AuditManage getAuditManage() {
		return auditManage;
	}

	public void setAuditManage(AuditManage auditManage) {
		this.auditManage = auditManage;
	}
	

}
