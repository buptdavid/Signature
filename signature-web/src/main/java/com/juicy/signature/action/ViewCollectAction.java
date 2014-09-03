/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.persist.po.SignatureCollect;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * 显示签名收藏Action
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-24 创建
 *          </p>
 */
public class ViewCollectAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 6637520838645857277L;

	/** 签名收藏List */
	private List<SignatureCollect> collects;

	/** 分页信息对象 */
	private Page page;

	/**
	 * 显示签名收藏方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并获取Session中User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 如果page对象为空，则new一个对象
		if (page == null) {
			page = new Page();
		}

		// 进行业务逻辑处理
		Result result = signatureService.getCollect(user, null, page);

		// 设置结果
		collects = (List<SignatureCollect>) result.getModel().get(
				"signatureCollectList");
		page = (Page) result.getModel().get("page");

		// 返回
		return SUCCESS;
	}

	public List<SignatureCollect> getCollects() {
		return collects;
	}

	public void setCollects(List<SignatureCollect> collects) {
		this.collects = collects;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
