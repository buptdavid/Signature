/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.List;

import com.juicy.signature.action.base.SignatureBaseAction;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;

/**
 * 签名搜索Action
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-9-13 创建
 *          </p>
 */
public class SearchAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -7024084610737002811L;

	/** 搜索标识，1表示搜索原创签名，2表示搜索签名宝库签名 */
	private Byte searchFlag;

	/** 搜索关键字 */
	private String keyWord;

	/** 原创签名 */
	private List<SignatureOriginal> originals;

	/** 签名宝库签名 */
	private List<SignatureLibrary> librarys;

	/** 分页基本信息 */
	private Page page;

	/**
	 * 原创签名搜索方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if (page == null) {
			page = new Page();
			page.setEveryPage(10);
		}

		Result result = null;
		if (searchFlag == 2) {
			// 签名宝库签名搜索
			result = signatureService.getLibrary(keyWord, page);
			if (result.isSuccess()) {
				librarys = (List<SignatureLibrary>) result.getModel().get(
						"signatureLibraryList");
				page = (Page) result.getModel().get("page");
			}
		} else {
			// 原创签名搜索
			result = signatureService.getOriginal(keyWord, true,
					SignatureOriginal.PASSAUDIT, page);
			if (result.isSuccess()) {
				originals = (List<SignatureOriginal>) result.getModel().get(
						"signatureOriginalList");
				page = (Page) result.getModel().get("page");
			}
			// 将其赋值为1
			searchFlag = 1;
		}

		return SUCCESS;
	}

	/**
	 * 签名宝库签名搜索方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String searchLibrary() throws Exception {

		return SUCCESS;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public List<SignatureOriginal> getOriginals() {
		return originals;
	}

	public void setOriginals(List<SignatureOriginal> originals) {
		this.originals = originals;
	}

	public List<SignatureLibrary> getLibrarys() {
		return librarys;
	}

	public void setLibrarys(List<SignatureLibrary> librarys) {
		this.librarys = librarys;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Byte getSearchFlag() {
		return searchFlag;
	}

	public void setSearchFlag(Byte searchFlag) {
		this.searchFlag = searchFlag;
	}

}
