/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
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
 * 更新个性化签名规则
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-27 创建
 *          </p>
 */
public class UpdatePersonalizedAction extends RuleBaseAction {

	/** serialVersionUID */
	private static final long serialVersionUID = -868120739135319637L;

	/** 要更新的个性化签名规则ID */
	private Integer id;

	/** 执行结果信息 */
	private String message;

	/** 要显示和更新的个性化签名 */
	private HgSendrule personalize;

	/** 签名盒ID */
	private Integer libraryId;

	/** 原创签名ID */
	private Integer originalId;

	/** 要显示的开始时间 */
	private String startTime;

	/** 要显示的结束时间 */
	private String endTime;

	/** 要显示的星期设置数组 */
	private String[] weeks;

	/** 要显示的时间设置类型：1表示按天设置，2表示按周设置 */
	private Byte setTime;

	/** 内容来源标识：1表示来源于签名宝库，2表示用户自己输入 */
	private Byte contentType;
	
	/** 如果是按天发送，是否是按全天发送，1表示按全天发送，2表示自定义发送时间 */
	private Byte allDayOrSelf;
	
	/** 签名盒分类ID */
	private Integer classId;

	/**
	 * 更新个性化签名规则方法
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 创建ActionContext实例,并从Session中取得用户基本信息User对象
		ActionContext ctx = ActionContext.getContext();
		User user = (User) ctx.getSession().get("user");

		// 用户的CustomerId和loginName,进行设置
		Integer customerId = user.getCustomerId();
		personalize.setCustomerId(customerId);
		
		// 签名宝库（盒）对象
		if(classId != null){
			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(classId);

			// 签名宝库SignatureLibrary对象
			SignatureLibrary library = new SignatureLibrary();
			library.setId(libraryId);
			library.setSignatureClass(signatureClass);
			personalize.getDiyInfo().setLibrary(library);
		}
		

//		// 设置library
//		if (libraryId != null) {
//			SignatureLibrary library = new SignatureLibrary();
//			library.setId(libraryId);
//			personalize.getDiyInfo().setLibrary(library);
//		}

		// 设置original
		if (originalId != null) {
			SignatureOriginal original = new SignatureOriginal();
			original.setId(originalId);
			personalize.getDiyInfo().setOriginal(original);
		}

		// 进行业务逻辑更新
		Result result = ruleService.modifyPersonalizedRule(personalize);

		if (result.isSuccess()) {
			// 创建成功
			this.setMessage(getText("updatePersonalized.success"));
		} else {
			// 创建失败
			this.setMessage(result.getRemark());
		}

		return SUCCESS;
	}

	/**
	 * 显示要更新的个性化签名规则
	 * 
	 * @return 结果字符串
	 * @throws Exception
	 */
	public String view() throws Exception {

		// 进行业务逻辑查询
		Result result = ruleService.getPersonalizedRule(id);

		// 对结果进行赋值
		personalize = (HgSendrule) result.getModel().get("personalizedRule");

		// 设置用于显示的开始时间结束时间和星期设置以及时间设置方式标识
		String ruleName = personalize.getSendruleName();
		if (ruleName.equals(HgSendrule.WEEKRULE)) {
			String ruleWeeks = personalize.getSendruleWeeks();

			if (ruleWeeks != null) {
				weeks = new String[ruleWeeks.length()];
				for (int i = 0; i < ruleWeeks.length(); i++) {
					weeks[i] = ruleWeeks.substring(i, i + 1);
				}
			}

			// 时间设置时间标识
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

			// 时间设置时间标识
			setTime = 1;
		}

		// 设置内容来源标识
		if (personalize.getDiyInfo().getLibrary() != null || personalize.getDiyInfo().getLibraryClassId() != null) {
			contentType = 1;
		} else {
			contentType = 2;
		}

		// 返回
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
