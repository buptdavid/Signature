/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.action.base.AuditManageBaseAction;
import com.juicy.signature.persist.po.HgKeyWord;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 内容审核管理Action
 *
 * @author 路卫杰
 * @version <p>Nov 23, 2011 创建</p>
 */
public class AuditManageAction extends AuditManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 敏感词List */
	private List<HgKeyWord> keywords;
	
	/** 分页信息对象 */
	private Page page;
	
	/** 敏感词 */
	private HgKeyWord keyword;
	
	/** 原创签名List */
	private List<SignatureOriginal> originals;
	
	/** 原创签名ID */
	private Integer originalId;
	
	/** 审核状态 */
	private Byte auditStatus;
	
	/** 操作结果信息 */
	private String message;
	
	/**
	 * 显示所有敏感词
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if(page == null){
			page = new Page();
		}
		
		page.setEveryPage(15);
		
		Result result = auditManage.viewKeyWord(null, page);
		
		if(result.isSuccess()){
			keywords = (List<HgKeyWord>)result.getModel().get("keyWordList");
			page = (Page)result.getModel().get("page");
		}
		
		return SUCCESS;
	}
	
	/**
	 * 显示添加敏感词
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String viewAdd() throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 添加敏感词
	 * 	
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String add() throws Exception{
		
		Result result = auditManage.createKeyWord(keyword);
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.addKeyword.success"));
		}else{
			this.setMessage(result.getRemark());
		}
		
		return SUCCESS;
	}
	
	/**
	 * 显示修改敏感词
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String viewUpdate() throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 更新敏感词
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String update() throws Exception{
		
		Result result = auditManage.modifyKeyWord(keyword);
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.updateKeyword.success"));
		}else{
			this.setMessage(result.getRemark());
		}
		
		return SUCCESS;
	}
	
	/**
	 * 删除敏感词
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String delete() throws Exception{
		List<HgKeyWord> deleteKeyword = new ArrayList<HgKeyWord>();
		deleteKeyword.add(keyword);
		
		Result result = auditManage.deleteKeyWord(deleteKeyword);
		if(result.isSuccess()){
			this.setMessage(getText("manage.deleteKeyword.success"));
		}else{
			this.setMessage(getText("manage.deleteKeyword.fail"));
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 显示原创签名
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String viewAuditOriginal() throws Exception{
		if(page == null){
			page = new Page();
		}
		
		page.setEveryPage(15);
		
		Result result = auditManage.viewOriginal(auditStatus, page);
		if(result.isSuccess()){
			originals = (List<SignatureOriginal>)result.getModel().get("originalList");
			page = (Page)result.getModel().get("page");
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 审核原创签名
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String setAuditStatus() throws Exception{
		List<Integer> originalIds = new ArrayList<Integer>();
		originalIds.add(originalId);
		
		Result result = auditManage.setAuditStatus(originalIds, auditStatus);
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.setAuditStatus.success"));
		}else{
			this.setMessage(getText("manage.setAuditStatus.fail"));
		}
		
		return SUCCESS;
	}
	

	public List<HgKeyWord> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<HgKeyWord> keywords) {
		this.keywords = keywords;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HgKeyWord getKeyword() {
		return keyword;
	}

	public void setKeyword(HgKeyWord keyword) {
		this.keyword = keyword;
	}

	public List<SignatureOriginal> getOriginals() {
		return originals;
	}

	public void setOriginals(List<SignatureOriginal> originals) {
		this.originals = originals;
	}

	public Byte getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getOriginalId() {
		return originalId;
	}

	public void setOriginalId(Integer originalId) {
		this.originalId = originalId;
	}
	
	
	

}
