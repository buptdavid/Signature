/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action.manage;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.action.base.SignatureManageBaseAction;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * ǩ����ǩ������Action
 * 
 * @author ·����
 * @version <p>
 *          Nov 18, 2011 ����
 *          </p>
 */
public class LibraryManageAction extends SignatureManageBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** ǩ����ǩ��List */
	private List<SignatureLibrary> libraries;

	/** ��ҳ��Ϣ�� */
	private Page page;

	/** ���� */
	List<SignatureClass> classes;

	/** Ҫ���ҵķ���ID */
	private Integer classId;

	/** ǩ����ǩ��ID */
	private Integer libraryId;

	/** ǩ������ */
	private String content;

	/** ���������Ϣ */
	private String message;

	/**
	 * ��ʾǩ����ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if (page == null) {
			page = new Page();
		}

		SignatureClass signatureClass = null;
		if (classId != null && classId != 0) {
			signatureClass = new SignatureClass();
			signatureClass.setId(classId);
		}

		Result result = libraryManage.viewLibrary(signatureClass, page);

		if (result.isSuccess()) {
			classes = (List<SignatureClass>) result.getModel().get(
					"firstClassList");
			libraries = (List<SignatureLibrary>) result.getModel().get(
					"libraryList");
			page = (Page) result.getModel().get("page");
		}

		return SUCCESS;
	}

	/**
	 * ��ʾ���ǩ����ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String viewAdd() throws Exception {

		Result result = libraryManage.viewClass();

		if (result.isSuccess()) {
			classes = (List<SignatureClass>) result.getModel().get(
					"firstClassList");
		}

		return SUCCESS;
	}

	/**
	 * ���ǩ����ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String add() throws Exception {
		SignatureLibrary library = new SignatureLibrary();

		library.setContent(content);

		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setId(classId);
		library.setSignatureClass(signatureClass);

		Result result = libraryManage.createLibrary(library);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.addLibrary.success"));
		} else {
			this.setMessage(getText("manage.addLibrary.fail"));
		}

		return SUCCESS;
	}

	/**
	 * ��ʾ����ǩ����ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String viewUpdate() throws Exception {
		Result result = libraryManage.viewClass();

		if (result.isSuccess()) {
			classes = (List<SignatureClass>) result.getModel().get(
					"firstClassList");
		}

		return SUCCESS;
	}

	/**
	 * ����ǩ����ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String update() throws Exception {
		SignatureLibrary library = new SignatureLibrary();

		library.setId(libraryId);
		library.setContent(content);

		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setId(classId);
		library.setSignatureClass(signatureClass);

		Result result = libraryManage.modifyLibrary(library);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.updateLibrary.success"));
		} else {
			this.setMessage(getText("manage.updateLibrary.fail"));
		}

		return SUCCESS;
	}

	/**
	 * ɾ��ǩ����ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String delete() throws Exception {
		List<Integer> libraryIds = new ArrayList<Integer>();
		libraryIds.add(libraryId);

		Result result = libraryManage.deleteLibrary(libraryIds);

		if (result.isSuccess()) {
			this.setMessage(getText("manage.deleteLibrary.success"));
		} else {
			this.setMessage(getText("manage.deleteLibrary.fail"));
		}

		return SUCCESS;
	}

	/**
	 * �Ƽ�ǩ����ǩ��
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String recommend() throws Exception {
		// ����ActionContextʵ��,����Session��ȡ���û�������ϢUser����
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");
		Integer customerId = user.getCustomerId();

		Result result = libraryManage.recommendLibrary(libraryId, customerId);

		if(result.isSuccess()){
			this.setMessage(getText("manage.recommend.success"));
		}else{
			this.setMessage(getText("manage.recommend.fail"));
		}

		
		return SUCCESS;
	}

	public List<SignatureLibrary> getLibraries() {
		return libraries;
	}

	public void setLibraries(List<SignatureLibrary> libraries) {
		this.libraries = libraries;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<SignatureClass> getClasses() {
		return classes;
	}

	public void setClasses(List<SignatureClass> classes) {
		this.classes = classes;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
