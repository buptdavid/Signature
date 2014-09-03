/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.juicy.signature.action.base.RuleBaseAction;
import com.juicy.signature.persist.po.HgDiyInfo;
import com.juicy.signature.persist.po.HgSendrule;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * �������Ի�ǩ��,����ͨ���û�����ǩ����ͨ��ǩ���У����⣩
 * 
 * @author ·����
 * @version <p>
 *          2011-8-25 ����
 *          </p>
 */
public class CreatePersonalizedAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = 478981149884488687L;

	/** HgSendruleʵ������ */
	private HgSendrule sendrule;

	/** �û���ǩ������ */
	private String content;

	/** ǩ�����⣨�У�ID */
	private Integer classId;

	/** ǩ������ǩ������ID */
	private Integer libraryId;

	/** ԭ��ǩ��ID */
	private Integer originalId;

	/** ǩ������ǩ�������� */
	private String libraryContent;

	/*** json���л����ص���Ϣ,�����Ƿ�AJAX���󷵻ص���Ϣ */
	private String message;

	/** Pattern��������������ʽ���ֻ������еĻس��������Ϊ���� */
	private final Pattern pattern = Pattern.compile("\r\n");

	/**
	 * ͨ���û��Լ������ǩ���������Ի�ǩ������
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// ����ActionContextʵ��,����Session��ȡ���û�������ϢUser����
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// �û���CustomerId��loginName,��������
		Integer customerId = user.getCustomerId();
		sendrule.setCustomerId(customerId);

		HgDiyInfo diyInfo = new HgDiyInfo();
		// ǩ����������customerId
		diyInfo.setCustomerId(customerId);
		// ����ǩ��
		diyInfo.setDiyInfoContent(content);

		// �Ƿ���Դ��ԭ��ǩ��
		if (originalId != null) {
			SignatureOriginal original = new SignatureOriginal();
			original.setId(originalId);
			diyInfo.setOriginal(original);
		}
		
		//����HgDiyInfo����
		sendrule.setDiyInfo(diyInfo);

		// �������ֻ������еĻس�����ת��Ϊ����
		String callingNumbers = sendrule.getCallingNumbers();
		Matcher m = pattern.matcher(callingNumbers);
		callingNumbers = m.replaceAll(",");
		sendrule.setCallingNumbers(callingNumbers);

		// ִ��ҵ���߼�����
		Result result = ruleService.createPersonalizedRule(sendrule);

		if (result.isSuccess()) {
			// �����ɹ�
			this.setMessage(getText("createPersonalized.success"));
		} else {
			// ����ʧ��
			this.setMessage(result.getRemark());
		}
		
		// ����
		return SUCCESS;
	}

	/**
	 * ͨ��ǩ�����ⴴ�����Ի�ǩ������
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String createByLibrary() throws Exception {
		// ����ActionContextʵ��,����Session��ȡ���û�������ϢUser����
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// �û���CustomerId��loginName,��������
		Integer customerId = user.getCustomerId();

		// ǩ�����⣨�У�����
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setId(classId);

		// ǩ������SignatureLibrary����
		SignatureLibrary library = new SignatureLibrary();
		library.setId(libraryId);
		library.setSignatureClass(signatureClass);

		// �����û��Զ�����ϢHgDiyInfo����
		HgDiyInfo diyInfo = new HgDiyInfo();
		diyInfo.setCustomerId(customerId);
		diyInfo.setDiyInfoContent(libraryContent);
		diyInfo.setLibrary(library);

		// ����HgSendrule�������Ӧ����
		sendrule.setCustomerId(customerId);
		sendrule.setDiyInfo(diyInfo);

		// �������ֻ������еĻس�����ת��Ϊ����
		String callingNumbers = sendrule.getCallingNumbers();
		Matcher m = pattern.matcher(callingNumbers);
		callingNumbers = m.replaceAll(",");
		sendrule.setCallingNumbers(callingNumbers);

		// ִ��ҵ���߼�����
		Result result = ruleService.createPersonalizedRule(sendrule);

		if (result.isSuccess()) {
			// �����ɹ�
			this.setMessage(getText("createPersonalized.success"));
		} else {
			// ����ʧ��
			this.setMessage(result.getRemark());
		}

		// ����
		return SUCCESS;
	}

	public String getLibraryContent() {
		return libraryContent;
	}

	public void setLibraryContent(String libraryContent) {
		this.libraryContent = libraryContent;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HgSendrule getSendrule() {
		return sendrule;
	}

	public void setSendrule(HgSendrule sendrule) {
		this.sendrule = sendrule;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Integer getOriginalId() {
		return originalId;
	}

	public void setOriginalId(Integer originalId) {
		this.originalId = originalId;
	}

}
