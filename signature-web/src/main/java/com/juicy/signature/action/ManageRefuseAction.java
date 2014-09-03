/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.action.base.ListBaseAction;
import com.juicy.signature.persist.po.HgSpecialNumbers;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * ����ܾ�ǩ��Action��������ӣ�ɾ�����鿴
 * 
 * @author ·����
 * @version <p>
 *          2011-9-1 ����
 *          </p>
 */
public class ManageRefuseAction extends ListBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 3744764717906822383L;

	/** ��ѯ���ľܾ�ǩ�������б� */
	private List<HgSpecialNumbers> specialNumbers;

	/** ������ҳ��ϢPage���� */
	private Page page;

	/** Ҫɾ���ľܾ�ǩ��ID�б� */
	private List<Integer> cb;

	/** Ҫ���ӵľܾ�ǩ������ */
	private HgSpecialNumbers specialNumber;

	/** ���������Ϣ */
	private String message;

	/**
	 * ���Ӿܾ�ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// ����ActionContextʵ��,����Session��ȡ���û�������ϢUser����
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// ���в���
		Result result = listService.createRefuseList(user,specialNumber);

		// ���ý��
		if (result.isSuccess()) {
			message = getText("createResult.success1");			
		}else{
			message = result.getRemark();
		}

		return SUCCESS;
	}

	/**
	 * ��ʾ�ܾ�ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String view() throws Exception {
		// ����ActionContextʵ��,����Session��ȡ���û�������ϢUser����
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		if (page == null) {
			page = new Page();
		}

		// ��ѯ
		Result result = listService.getRefuseList(user, page);

		// ���ý��
		specialNumbers = (List<HgSpecialNumbers>) result.getModel().get(
				"refuseList");
		page = (Page) result.getModel().get("page");

		return SUCCESS;
	}

	/**
	 * ɾ���ܾ�ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String delete() throws Exception {
		// ִ��ɾ������
		Result result = listService.deleteList(cb);

		if (result.isSuccess()) {
			message = getText("deleteRefuse.success");
		}

		return SUCCESS;
	}

	public List<HgSpecialNumbers> getSpecialNumbers() {
		return specialNumbers;
	}

	public void setSpecialNumbers(List<HgSpecialNumbers> specialNumbers) {
		this.specialNumbers = specialNumbers;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Integer> getCb() {
		return cb;
	}

	public void setCb(List<Integer> cb) {
		this.cb = cb;
	}

	public HgSpecialNumbers getSpecialNumber() {
		return specialNumber;
	}

	public void setSpecialNumber(HgSpecialNumbers specialNumber) {
		this.specialNumber = specialNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
