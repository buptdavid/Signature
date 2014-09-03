/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
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
 * ϵͳ��������������������������������
 * 
 * @author ·����
 * @version <p>
 *          Dec 29, 2011 ����
 *          </p>
 */
public class FeedbackManageAction extends SystemManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * ����������
	 */
	private HgSysSpecialNumbers specialNumber;

	/**
	 * ϵͳ��������б�
	 */
	private List<HgSysSpecialNumbers> specialNumbers;

	/**
	 * �û�����
	 */
	private Suggest suggest;

	/**
	 * �û������б�
	 */
	private List<Suggest> suggests;

	/**
	 * ��ҳ����
	 */
	private Page page;
	
	/**
	 * �������ֻ�����
	 */
	private String searchNumber;
	
	/**
	 * �������������
	 */
	private String title;

	/**
	 * ��ʾϵͳ�������
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if (page == null) {
			page = new Page();
			page.setEveryPage(15);
		}

		// Ҫ�������ֻ�����		
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
	 * ���ϵͳ�������
	 * 
	 * @return ����ַ���
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
	 * ɾ��ϵͳ�������
	 * 
	 * @return ����ַ���
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
	 * ��ʾ����
	 * 
	 * @return ����ַ���
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
	 * ɾ������
	 * 
	 * @return ����ַ���
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
