/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
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
 * ǩ������Action
 * 
 * @author ·����
 * @version <p>
 *          2011-9-13 ����
 *          </p>
 */
public class SearchAction extends SignatureBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -7024084610737002811L;

	/** ������ʶ��1��ʾ����ԭ��ǩ����2��ʾ����ǩ������ǩ�� */
	private Byte searchFlag;

	/** �����ؼ��� */
	private String keyWord;

	/** ԭ��ǩ�� */
	private List<SignatureOriginal> originals;

	/** ǩ������ǩ�� */
	private List<SignatureLibrary> librarys;

	/** ��ҳ������Ϣ */
	private Page page;

	/**
	 * ԭ��ǩ����������
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if (page == null) {
			page = new Page();
			page.setEveryPage(10);
		}

		Result result = null;
		if (searchFlag == 2) {
			// ǩ������ǩ������
			result = signatureService.getLibrary(keyWord, page);
			if (result.isSuccess()) {
				librarys = (List<SignatureLibrary>) result.getModel().get(
						"signatureLibraryList");
				page = (Page) result.getModel().get("page");
			}
		} else {
			// ԭ��ǩ������
			result = signatureService.getOriginal(keyWord, true,
					SignatureOriginal.PASSAUDIT, page);
			if (result.isSuccess()) {
				originals = (List<SignatureOriginal>) result.getModel().get(
						"signatureOriginalList");
				page = (Page) result.getModel().get("page");
			}
			// ���丳ֵΪ1
			searchFlag = 1;
		}

		return SUCCESS;
	}

	/**
	 * ǩ������ǩ����������
	 * 
	 * @return ����ַ���
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
