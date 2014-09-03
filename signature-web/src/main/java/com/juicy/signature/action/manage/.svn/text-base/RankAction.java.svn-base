/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.action.base.IndexManageBaseAction;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 排行榜管理Action
 *
 * @author 路卫杰
 * @version <p>Nov 16, 2011 创建</p>
 */
public class RankAction extends IndexManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 排行榜 */
	private List<SignatureOriginal> originalRanks;
	
	/** 分页对象 */
	private Page page;
	
	/** 要处理的排行榜ID */
	private Integer rankId;
	
	/** 处理后的消息 */
	private String message;
	
	/**
	 * 今日排行榜处理操作
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		List<Integer> originalIds = new ArrayList<Integer>();
		originalIds.add(rankId);
		
		Result result = indexManage.deleteRank(originalIds);
		if(result.isSuccess()){
			this.setMessage(getText("manage.deleteRank.success"));
		}else{
			this.setMessage(getText("manage.deleteRank.fail"));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 显示今日排行榜
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception{
		if(page == null){
			page = new Page();
		}
		
		Result result = indexManage.viewRank(page);
		
		if(result.isSuccess()){
			originalRanks = ( List<SignatureOriginal>)result.getModel().get("originalRankList");
			page = (Page)result.getModel().get("page");
		}
		
		return SUCCESS;
	}


	public List<SignatureOriginal> getOriginalRanks() {
		return originalRanks;
	}

	public void setOriginalRanks(List<SignatureOriginal> originalRanks) {
		this.originalRanks = originalRanks;
	}

	public Integer getRankId() {
		return rankId;
	}

	public void setRankId(Integer rankId) {
		this.rankId = rankId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
