/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.action;

import com.juicy.signature.action.base.RuleBaseAction;
import com.juicy.signature.persist.po.HgSendrule;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.opensymphony.xwork2.ActionContext;

/**
 * ���¸��Ի�ǩ������
 * 
 * @author ·����
 * @version <p>
 *          2011-8-27 ����
 *          </p>
 */
public class UpdatePersonalizedAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -868120739135319637L;

	/** Ҫ���µĸ��Ի�ǩ������ID */
	private Integer id;

	/** ִ�н����Ϣ */
	private String message;

	/** Ҫ��ʾ�͸��µĸ��Ի�ǩ�� */
	private HgSendrule personalize;

	/** ǩ����ID */
	private Integer libraryId;

	/** ԭ��ǩ��ID */
	private Integer originalId;

	/** Ҫ��ʾ�Ŀ�ʼʱ�� */
	private String startTime;

	/** Ҫ��ʾ�Ľ���ʱ�� */
	private String endTime;

	/** Ҫ��ʾ�������������� */
	private String[] weeks;

	/** Ҫ��ʾ��ʱ���������ͣ�1��ʾ�������ã�2��ʾ�������� */
	private Byte setTime;

	/** ������Դ��ʶ��1��ʾ��Դ��ǩ�����⣬2��ʾ�û��Լ����� */
	private Byte contentType;
	
	/** ����ǰ��췢�ͣ��Ƿ��ǰ�ȫ�췢�ͣ�1��ʾ��ȫ�췢�ͣ�2��ʾ�Զ��巢��ʱ�� */
	private Byte allDayOrSelf;
	
	/** ǩ���з���ID */
	private Integer classId;

	/**
	 * ���¸��Ի�ǩ�����򷽷�
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
		personalize.setCustomerId(customerId);
		
		// ǩ�����⣨�У�����
		if(classId != null){
			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(classId);

			// ǩ������SignatureLibrary����
			SignatureLibrary library = new SignatureLibrary();
			library.setId(libraryId);
			library.setSignatureClass(signatureClass);
			personalize.getDiyInfo().setLibrary(library);
		}
		

//		// ����library
//		if (libraryId != null) {
//			SignatureLibrary library = new SignatureLibrary();
//			library.setId(libraryId);
//			personalize.getDiyInfo().setLibrary(library);
//		}

		// ����original
		if (originalId != null) {
			SignatureOriginal original = new SignatureOriginal();
			original.setId(originalId);
			personalize.getDiyInfo().setOriginal(original);
		}

		// ����ҵ���߼�����
		Result result = ruleService.modifyPersonalizedRule(personalize);

		if (result.isSuccess()) {
			// �����ɹ�
			this.setMessage(getText("updatePersonalized.success"));
		} else {
			// ����ʧ��
			this.setMessage(result.getRemark());
		}

		return SUCCESS;
	}

	/**
	 * ��ʾҪ���µĸ��Ի�ǩ������
	 * 
	 * @return ����ַ���
	 * @throws Exception
	 */
	public String view() throws Exception {

		// ����ҵ���߼���ѯ
		Result result = ruleService.getPersonalizedRule(id);

		// �Խ�����и�ֵ
		personalize = (HgSendrule) result.getModel().get("personalizedRule");

		// ����������ʾ�Ŀ�ʼʱ�����ʱ������������Լ�ʱ�����÷�ʽ��ʶ
		String ruleName = personalize.getSendruleName();
		if (ruleName.equals(HgSendrule.WEEKRULE)) {
			String ruleWeeks = personalize.getSendruleWeeks();

			if (ruleWeeks != null) {
				weeks = new String[ruleWeeks.length()];
				for (int i = 0; i < ruleWeeks.length(); i++) {
					weeks[i] = ruleWeeks.substring(i, i + 1);
				}
			}

			// ʱ������ʱ���ʶ
			setTime = 2;

		} else {
			String periodTime = personalize.getSendruleSendperiodtime();
			if (periodTime != null) {								
				String[] times = periodTime.split("-");
				startTime = times[0] + ":00";
				endTime = times[1] + ":00";
				
				if(periodTime.trim().equals("00:00-23:59")){
					allDayOrSelf = 1;
				}else{
					allDayOrSelf = 2;
				}
				
			}

			// ʱ������ʱ���ʶ
			setTime = 1;
		}

		// ����������Դ��ʶ
		if (personalize.getDiyInfo().getLibrary() != null || personalize.getDiyInfo().getLibraryClassId() != null) {
			contentType = 1;
		} else {
			contentType = 2;
		}

		// ����
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HgSendrule getPersonalize() {
		return personalize;
	}

	public void setPersonalize(HgSendrule personalize) {
		this.personalize = personalize;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String[] getWeeks() {
		return weeks;
	}

	public void setWeeks(String[] weeks) {
		this.weeks = weeks;
	}

	public Byte getSetTime() {
		return setTime;
	}

	public void setSetTime(Byte setTime) {
		this.setTime = setTime;
	}

	public Byte getContentType() {
		return contentType;
	}

	public void setContentType(Byte contentType) {
		this.contentType = contentType;
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

	public Byte getAllDayOrSelf() {
		return allDayOrSelf;
	}

	public void setAllDayOrSelf(Byte allDayOrSelf) {
		this.allDayOrSelf = allDayOrSelf;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	
	
	
}
