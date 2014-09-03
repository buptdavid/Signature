/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.action.base.SystemManageBaseAction;
import com.juicy.signature.persist.po.HgSysSpecialNumbers;
import com.juicy.signature.persist.po.Suggest;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 系统反馈管理，包括意见反馈，特殊号码设置
 * 
 * @author 路卫杰
 * @version <p>
 *          Dec 29, 2011 创建
 *          </p>
 */
public class FeedbackManageAction extends SystemManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * 特殊号码对象
	 */
	private HgSysSpecialNumbers specialNumber;

	/**
	 * 系统特殊号码列表
	 */
	private List<HgSysSpecialNumbers> specialNumbers;

	/**
	 * 用户建议
	 */
	private Suggest suggest;

	/**
	 * 用户建议列表
	 */
	private List<Suggest> suggests;

	/**
	 * 分页对象
	 */
	private Page page;
	
	/**
	 * 搜索的手机号码
	 */
	private String searchNumber;
	
	/**
	 * 搜索的意见标题
	 */
	private String title;

	/**
	 * 显示系统特殊号码
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if (page == null) {
			page = new Page();
			page.setEveryPage(15);
		}

		// 要搜索的手机号码		
		if(specialNumber != null && specialNumber.getSysSpecialNumber() != null){
			searchNumber = specialNumber.getSysSpecialNumber();
			if(searchNumber.startsWith("86")){
				searchNumber = searchNumber.substring(2, searchNumber.length());
				specialNumber.setSysSpecialNumber(searchNumber);
			}
		}else{
			searchNumber = "";
		}

		Result result = systemManage.viewSysSpecialNumbers(searchNumber, page);

		if (result.isSuccess()) {
			specialNumbers = (List<HgSysSpecialNumbers>) result.getModel().get(
					"specialList");
			page = (Page) result.getModel().get("page");
		}

		return SUCCESS;
	}

	/**
	 * 添加系统特殊号码
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String add() throws Exception {

		Result result = systemManage.saveSysSpecialNumbers(specialNumber);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.addSysSpecialNumber.success"));
		} else {
			this.setMessage(result.getRemark());
		}

		return SUCCESS;
	}

	/**
	 * 删除系统特殊号码
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String delete() throws Exception {

		specialNumbers = new ArrayList<HgSysSpecialNumbers>();
		specialNumbers.add(specialNumber);

		Result result = systemManage.deleteSysSpecialNumbers(specialNumbers);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.deleteSysSpecialNumber.success"));
		} else {
			this.setMessage(getText("manage.deleteSysSpecialNumber.fail"));
		}

		return SUCCESS;
	}

	/**
	 * 显示建议
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String viewSuggest() throws Exception {
		if (page == null) {
			page = new Page();
			page.setEveryPage(10);
		}
		
		if(suggest != null && suggest.getTitle() != null){
			title = suggest.getTitle();
		}else{
			title = "";
		}

		Result result = suggestService.viewSuggest(title, page);

		if(result.isSuccess()){
			suggests = (List<Suggest>)result.getModel().get("suggestList");
			page = (Page)result.getModel().get("page");
		}
		
		return SUCCESS;
	}

	/**
	 * 删除建议
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String deleteSuggest() throws Exception {
		suggests = new ArrayList<Suggest>();
		suggests.add(suggest);
		
		Result result = suggestService.deleteSuggest(suggests);
		
		if(result.isSuccess()){
			this.setMessage(getText("manage.deleteSuggest.success"));
		}else{
			this.setMessage(getText("manage.deleteSuggest.fail"));
		}
		return SUCCESS;
	}

	public HgSysSpecialNumbers getSpecialNumber() {
		return specialNumber;
	}

	public void setSpecialNumber(HgSysSpecialNumbers specialNumber) {
		this.specialNumber = specialNumber;
	}

	public List<HgSysSpecialNumbers> getSpecialNumbers() {
		return specialNumbers;
	}

	public void setSpecialNumbers(List<HgSysSpecialNumbers> specialNumbers) {
		this.specialNumbers = specialNumbers;
	}

	public Suggest getSuggest() {
		return suggest;
	}

	public void setSuggest(Suggest suggest) {
		this.suggest = suggest;
	}

	public List<Suggest> getSuggests() {
		return suggests;
	}

	public void setSuggests(List<Suggest> suggests) {
		this.suggests = suggests;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getSearchNumber() {
		return searchNumber;
	}

	public void setSearchNumber(String searchNumber) {
		this.searchNumber = searchNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

}
