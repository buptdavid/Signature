/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action.base;

import com.juicy.signature.service.IndexService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ҳ����Action
 *
 * @author ·����
 * @version <p>Nov 1, 2011 ����</p>
 */
public class IndexBaseAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = -2469997623726854906L;

	protected IndexService indexService;
	
	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}
	
	
	
	
}
