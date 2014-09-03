/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.base;

import com.juicy.signature.service.IndexManage;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 推荐签名基类Action
 *
 * @author 路卫杰
 * @version <p>Nov 16, 2011 创建</p>
 */
public class IndexManageBaseAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = 707073385111904722L;
	
	/** 注入IndexManage对象 */
	protected IndexManage indexManage;
	
	public IndexManage getIndexManage() {
		return indexManage;
	}

	public void setIndexManage(IndexManage indexManage) {
		this.indexManage = indexManage;
	}

}
