/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.HgDiyInfoDao;
import com.juicy.signature.persist.dao.HgOwnPhoneDao;
import com.juicy.signature.persist.dao.HgSendruleDao;
import com.juicy.signature.persist.dao.SignatureClassDao;
import com.juicy.signature.persist.dao.SignatureLibraryDao;
import com.juicy.signature.persist.dao.SignatureOriginalDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgDiyInfo;
import com.juicy.signature.persist.po.HgOwnPhone;
import com.juicy.signature.persist.po.HgSendrule;
import com.juicy.signature.persist.po.Portal;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.RuleService;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.filter.Filter;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;
import com.juicy.signature.service.util.ParameterUtil;

/**
 * RuleService实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-2 创建
 *          </p>
 */
public class RuleServiceImpl implements RuleService {

	/** 用户每天可设置的默认签名最大数量,默认为10(在配置文件中配置) */
	private Integer maxDefaultCount;

	/** 可设置的个性化签名规则的最大数量,默认为20(在配置文件中配置) */
	private Integer maxPersonalizeCount;

	/** 是否流量控制1表示控制，0表示不控制(已经无用) */
	private Integer ifFlowcontrol;

	/** 每天发送量限制值(已经无用，后台判断的值从表MESSAGE_SEND取得) */
	private Integer flowcontrol;

	/** 重发间隔，单位：秒(已经无用，后台判断的值从表MESSAGE_SEND取得) */
	private Integer smInterval;

	private HgSendruleDao hgSendruleDao;

	private HgDiyInfoDao hgDiyInfoDao;

	private HgOwnPhoneDao hgOwnPhoneDao;

	private SignatureClassDao signatureClassDao;

	private SignatureLibraryDao signatureLibraryDao;

	private SignatureOriginalDao signatureOriginalDao;

	private Filter filter;

	private ParameterUtil parameterUtil;

	/** 已经创建默认签名策略时的信息 */
	public static final String DEFAULT_HAVED = "您已创建默认签名，请勿重复创建!";

	/** 设置默认签名策略时的主叫号码 */
	private String defaultCallingNumbers;

	/** 设置默认签名策略时的时间段 */
	private String defaultSendPeriodTime;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(RuleServiceImpl.class);

	public Result createDefaultRule(User user) throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer customerId = user.getCustomerId();

		try {
			// 取得HgOwnPhone
			HgOwnPhone hgOwnPhone = hgOwnPhoneDao.findByCustomerId(customerId);

			// 如果为空，则插入保存
			if (hgOwnPhone == null) {
				hgOwnPhone = new HgOwnPhone();
				hgOwnPhone.setCustomerId(customerId);
				hgOwnPhone.setOwnPhone(user.getLoginName());
				hgOwnPhone.setOwnPhoneType(HgOwnPhone.MOBILEPHONE);

				hgOwnPhoneDao.save(hgOwnPhone);
			}

			Integer ownPhoneId = hgOwnPhone.getId();

			HgSendrule hgSendrule = hgSendruleDao
					.getDefaultByCustomerId(customerId);
			if (hgSendrule != null) {
				result.setRemark(DEFAULT_HAVED);
				logger.info("The default rule has existed for user: "
						+ user.getLoginName());
			} else {
				HgSendrule hgSendrule2 = new HgSendrule();
				hgSendrule2.setCustomerId(customerId);
				hgSendrule2.setCallingNumbers(this.defaultCallingNumbers);
				hgSendrule2
						.setSendruleSendperioddate(this.defaultSendPeriodTime);
				hgSendrule2.setIsDefault(1);
				hgSendrule2.setSendruleName(HgSendrule.DEFAULTRULE);
				hgSendrule2.setSendruleIfFlowcontrol(0);
				hgSendrule2.setSendruleCallState(1);
				hgSendrule2.setCalledNumbers(String.valueOf(ownPhoneId));

				hgSendruleDao.save(hgSendrule2);

				result.setSuccess(true);
				result.getModel().put("defaultRule", hgSendrule2);

			}
		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to create default rule for user: "
							+ user.getLoginName(), e);
			throw new SignatureServiceException(
					"Unable to create default rule for user: "
							+ user.getLoginName(), e);
		}

		return result;
	}

	public Result getDefaultRule(User user) throws SignatureServiceException {
		Result result = Result.createRestult();

		// 获得用户的客户ID
		Integer customerId = user.getCustomerId();

		try {
			HgSendrule hgSendrule = hgSendruleDao
					.getDefaultByCustomerId(customerId);

			result.setSuccess(true);
			result.getModel().put("defaultRule", hgSendrule);
		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to get the default rule for user: "
							+ user.getLoginName(), e);
			throw new SignatureServiceException(
					"Unable to get the default rule for user: "
							+ user.getLoginName(), e);
		}

		// 返回结果
		return result;
	}

	public Result getDefaultRule(User user, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 用户的客户ID
		Integer customerId = user.getCustomerId();

		try {
			// 取得该用户默认签名的数量,并新生成Page对象
			Integer totalRecords = hgDiyInfoDao.findCountByCustomerId(
					customerId, HgDiyInfo.DEFAULT);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<HgDiyInfo> hgDiyInfoList = hgDiyInfoDao
					.findByCustomerIdForPage(customerId, HgDiyInfo.DEFAULT,
							offSet, pageSize);

			// 封装成HgSendrule对象
			List<HgSendrule> hgSendruleList = new ArrayList<HgSendrule>();

			// 数据库中取得该客户的默认签名规则
			HgSendrule hgSendruleLoad = hgSendruleDao
					.getDefaultByCustomerId(customerId);
			// 取得当前的签名
			HgDiyInfo currentDiyInfo = hgSendruleLoad.getDiyInfo();
			SignatureLibrary library = currentDiyInfo.getLibrary();
			// 设置signatureClass,已经设置lazy=false
			// if(library != null){
			// //取出signatureClass
			// SignatureClass signatureClass = library.getSignatureClass();
			// Integer classId = signatureClass.getId();
			// library.setSignatureClass(signatureClassDao.getById(classId));
			// }

			Iterator<HgDiyInfo> it = hgDiyInfoList.iterator();
			while (it.hasNext()) {
				// 克隆HgSendrule对象
				HgSendrule hgSendrule = hgSendruleLoad.clone();
				hgSendrule.setDiyInfo(it.next());

				hgSendruleList.add(hgSendrule);
			}

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("defaultRuleList", hgSendruleList);
			result.getModel().put("currentDiyInfo", currentDiyInfo);
			result.getModel().put("maxDefaultCount", this.getMaxDefaultCount());
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to get default rule by page for user: "
					+ customerId, e);
			throw new SignatureServiceException(
					"Unable to get default rule by page for user: "
							+ customerId, e);
		}

		return result;
	}

	public Result modifyDefaultRule(HgSendrule hgSendrule)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 获得需要的签名内容,并保存
		HgDiyInfo hgDiyInfo = hgSendrule.getDiyInfo();

		// 对签名内容进行敏感词过滤
		String content = hgDiyInfo.getDiyInfoContent();

		// 敏感词过滤
		if (content != null && content.trim().length() > 0) {
			String keyWord = filter.contain(content);
			if (keyWord != null) {
				logger.info("含有敏感词：+ " + keyWord);
				result.setRemark("-->签名包含敏感词:" + keyWord);
				// 返回
				return result;
			}
			
			//替代回车换行
			content = content.replace("\r\n", "");
			hgDiyInfo.setDiyInfoContent(content);
		}

		// 获得用户的客户ID
		Integer customerId = hgSendrule.getCustomerId();

		try {
			// 获得当天零时的时间
			Calendar calender = Calendar.getInstance();
			calender.set(calender.get(Calendar.YEAR),
					calender.get(Calendar.MONTH),
					calender.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			Date date = calender.getTime();
			Integer defaultCount = hgDiyInfoDao.findCountDefaultForTime(
					customerId, date);

			// 如果今日设置的默认签名数量超过了设置的最大值，则返回
			if (defaultCount >= this.getMaxDefaultCount()) {
				logger.info("超过了默认签名每日设置最大值");
				result.setRemark("-->您今天的默认签名数量超过了" + this.getMaxDefaultCount()
						+ "条");
				return result;
			}

			// 设置自定义信息创建时间
			Date currentTime = new Date();
			hgDiyInfo.setDiyInfoCreatetime(currentTime);
			// 设置签名类别
			hgDiyInfo.setIsDefault(HgDiyInfo.DEFAULT);

			// 设置签名宝库（盒）的ID
			SignatureLibrary library = hgSendrule.getDiyInfo().getLibrary();

			if (library != null) {
				// 签名宝库（盒）中签名ID
				Integer libraryId = library.getId();

				// 如果签名宝库（盒）中签名ID不为空，则设置libraryId，且Flag置标志位为HgDiyInfo.USESINGLE,最后要置libraryClassId和libraryClassName
				// 否则，则设置libraryClassId和libraryClassName，且Flag置标志位为HgDiyInfo.USELIBRARY,最后要置Library为null
				if (libraryId != null) {
					hgDiyInfo.setLibrary(library);
					hgDiyInfo.setFlag(HgDiyInfo.USESINGLE);
					
					hgDiyInfo.setLibraryClassId(null);
					hgDiyInfo.setLibraryClassName(null);
				} else {
					Integer classId = library.getSignatureClass().getId();
					hgDiyInfo.setLibraryClassId(classId);

					SignatureClass signatureClass = signatureClassDao
							.getById(classId);
					hgDiyInfo.setLibraryClassName(signatureClass.getName());
					hgDiyInfo.setFlag(HgDiyInfo.USELIBRARY);

					hgDiyInfo.setLibrary(null);
				}
			} else {
				hgDiyInfo.setFlag(HgDiyInfo.USESINGLE);
			}

			// 设置闪信发送和未用的字段
			hgDiyInfo.setMessageTypeId(HgDiyInfo.FLASH);
			hgDiyInfo.setDiyInfoCurType(HgDiyInfo.USED);

			// 保存
			hgDiyInfoDao.save(hgDiyInfo);

			HgSendrule hgSendrule2 = hgSendruleDao
					.getDefaultByCustomerId(customerId);
			hgSendrule2.setDiyInfo(hgDiyInfo);
			hgSendrule2.setSendruleCreatetime(currentTime);

			// 更新
			hgSendruleDao.update(hgSendrule2);

			// 返回结果
			result.setSuccess(true);
			result.getModel().put("defaultRule", hgSendrule2);
		} catch (SignaturePersistException e) {
			logger.error("Unable to modify default rule for CustomerId: "
					+ hgSendrule.getCustomerId(), e);
			throw new SignatureServiceException(
					"Unable to modify default rule for CustomerId: "
							+ hgSendrule.getCustomerId(), e);
		}

		return result;
	}

	public Result viewCreatePersonalizedRule() throws SignatureServiceException {
		// 只需要返回可设置的个性化签名规则的最大数量
		Result result = Result.createRestult();

		result.setSuccess(true);
		result.getModel().put("maxPersonalizeCount",
				this.getMaxPersonalizeCount());
		return result;
	}

	public Result createPersonalizedRule(HgSendrule hgSendrule)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 获得需要签名的内容，并保存
		HgDiyInfo hgDiyInfo = hgSendrule.getDiyInfo();

		// 对签名内容进行敏感词过滤
		String content = hgDiyInfo.getDiyInfoContent();
		if (content != null && content.trim().length() > 0) {
			String keyWord = filter.contain(content);
			if (keyWord != null) {
				result.setRemark(keyWord);
				logger.info("含有敏感词：+ " + keyWord);
				return result;
			}
			
			//替代回车换行
			content = content.replace("\r\n", "");
			hgDiyInfo.setDiyInfoContent(content);
		}

		try {
			// 进行规则冲突检验
			Integer customerId = hgSendrule.getCustomerId();

			// 查询数量
			Integer count = hgSendruleDao
					.getPersonalizeCountByCustomerId(customerId);
			// 如果数量大于设置的最大值则返回
			if (count >= this.getMaxPersonalizeCount()) {
				result.setRemark("失败：签名规则数量已经超过"
						+ this.getMaxPersonalizeCount() + "个");
				return result;
			}

			// 取出该客户的所有个性化规则
			List<HgSendrule> hgSendrulesLoad = hgSendruleDao
					.getPersonalizeByCustomerId(customerId);

			// 设置类型方式,true表示按照天时间段设置，false表示按照星期设置
			boolean typeFlag;
			String priodTime = hgSendrule.getSendruleSendperiodtime();
			String weeks = hgSendrule.getSendruleWeeks();
			if (priodTime == null || priodTime.length() == 0) {
				// 按周设置
				typeFlag = false;
				// sendperiodtime置空
				priodTime = null;
				hgSendrule.setSendruleSendperiodtime(priodTime);
				hgSendrule.setSendruleName(HgSendrule.WEEKRULE);
			} else {
				// 按天设置
				typeFlag = true;
				// sendruleWeeks置空
				weeks = null;
				hgSendrule.setSendruleWeeks(weeks);
				hgSendrule.setSendruleName(HgSendrule.DAYRULE);
			}

			// 取得设置的手机号
			String callingNumbers = hgSendrule.getCallingNumbers();

			String[] callingNumber = callingNumbers.split(",");

			// 用于比较时间的SimpleDateFormat对象
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			// 遍历检测
			Iterator<HgSendrule> it = hgSendrulesLoad.iterator();
			while (it.hasNext()) {
				HgSendrule hgSendruleLoad = it.next();

				// 首先检测是否有相同的手机号，如果有则继续进行下面的检测，否则continue
				String callingNumbersLoad = hgSendruleLoad.getCallingNumbers();
				String callingNumbersCompare = callingNumbersLoad + "*";
				// 是否有相同手机号码的标识
				boolean isHas = false;
				for (int i = 0; i < callingNumber.length; i++) {
					if (callingNumbersCompare.indexOf(callingNumber[i]) >= 0) {
						isHas = true;
						break;
					}
				}

				// 如果没有相同的号码，则continue
				if (!isHas) {
					continue;
				}

				// 开始检测
				if (typeFlag) {
					// 天设置时间段检测
					// 如果数据库中含有此号码的按周设置，则有冲突，返回
					String ruleNameLoad = hgSendruleLoad.getSendruleName();
					if (ruleNameLoad.trim().equals(HgSendrule.WEEKRULE)) {
						result.setRemark("失败：与已有签名规则的时间段冲突");
						return result;
					}

					String periodTimeLoad = hgSendruleLoad
							.getSendruleSendperiodtime();
					if (periodTimeLoad != null) {
						String[] timeLoad = periodTimeLoad.split("-");
						String[] time = priodTime.split("-");

						Date startTimeLoad = null;
						Date endTimeLoad = null;
						Date startTime = null;
						Date endTime = null;
						try {
							// 数据库中数据的开始时间和结束时间
							startTimeLoad = sdf.parse(timeLoad[0]);
							endTimeLoad = sdf.parse(timeLoad[1]);

							// 要创建的规则的开始时间和结束时间
							startTime = sdf.parse(time[0]);
							endTime = sdf.parse(time[1]);
						} catch (ParseException e) {
							logger.error(
									"Unable to parse time with SimpleDateFormat",
									e);
							throw new SignatureServiceException(
									"Unable to parse time with SimpleDateFormat",
									e);
						}

						// 如果时间段没有交叉，则continue，否则返回
						if (endTime.before(startTimeLoad)
								|| endTimeLoad.before(startTime)) {
							continue;
						} else {
							result.setRemark("失败：与已有签名规则的时间段冲突");
							return result;
						}
					}
				} else {
					// 星期设置检测
					// 如果数据库中含有此号码的按天设置，则有冲突，返回
					String ruleNameLoad = hgSendruleLoad.getSendruleName();
					if (ruleNameLoad.trim().equals(HgSendrule.DAYRULE)) {
						result.setRemark("失败：与已有签名规则的时间段冲突");
						return result;
					}

					String weeksLoad = hgSendruleLoad.getSendruleWeeks();
					if (weeksLoad != null) {
						char[] weeksCharLoad = weeksLoad.toCharArray();
						char[] weeksChar = weeks.toCharArray();

						// 循环判断是否有相同的1
						for (int i = 0; i < weeksCharLoad.length; i++) {
							// 如果有相同的1,则返回
							if (weeksChar[i] == '1' && weeksCharLoad[i] == '1') {
								result.setRemark("失败：与已有签名规则的周设置冲突");
								return result;
							}
						}
					}

				}
			}

			// 设置自定义信息创建时间
			Date currentTime = new Date();
			hgDiyInfo.setDiyInfoCreatetime(currentTime);
			// 设置签名类别
			hgDiyInfo.setIsDefault(HgDiyInfo.PERSONALIZED);
			// 设置闪信
			hgDiyInfo.setMessageTypeId(HgDiyInfo.FLASH);
			// 是否使用标志
			hgDiyInfo.setDiyInfoCurType(HgDiyInfo.USED);
			// 设置相应外键依赖为null

			// 设置签名宝库（盒）的ID
			SignatureLibrary library = hgSendrule.getDiyInfo().getLibrary();
			if (library != null) {
				// 签名宝库（盒）中签名ID
				Integer libraryId = library.getId();

				// 如果签名宝库（盒）中签名ID不为空，则设置libraryId，且Flag置标志位为HgDiyInfo.USESINGLE,最后要置libraryClassId和libraryClassName
				// 否则，则设置libraryClassId和libraryClassName，且Flag置标志位为HgDiyInfo.USELIBRARY,最后要置Library为null
				if (libraryId != null) {
					hgDiyInfo.setLibrary(library);
					hgDiyInfo.setFlag(HgDiyInfo.USESINGLE);
					
					hgDiyInfo.setLibraryClassId(null);
					hgDiyInfo.setLibraryClassName(null);
				} else {
					Integer classId = library.getSignatureClass().getId();
					hgDiyInfo.setLibraryClassId(classId);

					SignatureClass signatureClass = signatureClassDao
							.getById(classId);
					hgDiyInfo.setLibraryClassName(signatureClass.getName());
					hgDiyInfo.setFlag(HgDiyInfo.USELIBRARY);

					hgDiyInfo.setLibrary(null);
				}
			} else {
				hgDiyInfo.setFlag(HgDiyInfo.USESINGLE);
			}

			hgDiyInfoDao.save(hgDiyInfo);

			// 保存个性化签名规则
			hgSendrule.setDiyInfo(hgDiyInfo);
			hgSendrule.setIsDefault(HgSendrule.PERSONALIZED);
			// 总流量控制
			hgSendrule.setSendruleIfFlowcontrol(0);
			// 呼叫振铃
			// 是否流量控制
			hgSendrule.setSendruleCallState(ifFlowcontrol);
			// 发送量限制值
			hgSendrule.setSendruleFlowcontrol(flowcontrol);
			// 重发间隔(秒为单位)
			hgSendrule.setSendruleSmInterval(smInterval);
			// 设置创建时间
			hgSendrule.setSendruleCreatetime(currentTime);
			// 策略状态
			hgSendrule.setSendruleState(3);
			// 设置星期的显示字段
			String sendruleWeeks = hgSendrule.getSendruleWeeks();
			if (sendruleWeeks != null) {
				char[] sendruleWeeksChar = sendruleWeeks.toCharArray();
				String weeksShow = "星期：";
				for (int i = 0; i < sendruleWeeksChar.length; i++) {
					if (sendruleWeeksChar[i] == '1') {
						String week = "";
						switch (i) {
						case 1:
							week = "一";
							break;
						case 2:
							week = "二";
							break;
						case 3:
							week = "三";
							break;
						case 4:
							week = "四";
							break;
						case 5:
							week = "五";
							break;
						case 6:
							week = "六";
							break;
						default:
							week = "日";
						}
						weeksShow += week;
					}
				}
				hgSendrule.setWeeksShow(weeksShow);
			}

			// 取得HgOwnPhone
			HgOwnPhone hgOwnPhone = hgOwnPhoneDao.findByCustomerId(customerId);

			Integer ownPhoneId = null;
			if (hgOwnPhone != null) {
				ownPhoneId = hgOwnPhone.getId();
			}
			hgSendrule.setCalledNumbers(String.valueOf(ownPhoneId));

			// 保存
			hgSendruleDao.save(hgSendrule);

			result.setSuccess(true);
			result.getModel().put("personalizedRule", hgSendrule);
		} catch (SignaturePersistException e) {
			logger.error("Unable to create personalized rule for CustomerId: "
					+ hgSendrule.getCustomerId(), e);
			throw new SignatureServiceException(
					"Unable to create personalized rule for CustomerId: "
							+ hgSendrule.getCustomerId(), e);
		}

		return result;
	}

	public Result getPersonalizedRule(Integer id)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			HgSendrule hgSendrule = hgSendruleDao.getById(id);

			// 为签名盒设置第一级分类
			// SignatureLibrary library = hgSendrule.getDiyInfo().getLibrary();
			// if (library != null) {
			// SignatureClass signatureClass = library.getSignatureClass();
			// if (signatureClass != null) {
			// Integer parentId = signatureClass.getParentId();
			// SignatureClass firstClass = signatureClassDao
			// .getById(parentId);
			// signatureClass.setFirstClass(firstClass);
			// }
			// }

			// 返回结果
			result.setSuccess(true);
			result.getModel().put("personalizedRule", hgSendrule);
		} catch (SignaturePersistException e) {
			logger.error("Unable to get personalized rule for id: " + id, e);
			throw new SignatureServiceException(
					"Unable to get personalized rule for id: " + id, e);
		}

		// 返回
		return result;
	}

	public Result modifyPersonalizedRule(HgSendrule hgSendrule)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 获得需要签名的内容进行敏感字过滤
		HgDiyInfo hgDiyInfo = hgSendrule.getDiyInfo();

		// 对签名内容进行敏感词过滤
		String content = hgDiyInfo.getDiyInfoContent();

		if (content != null && content.trim().length() > 0) {
			String keyWord = filter.contain(content);
			if (keyWord != null) {
				result.setRemark(keyWord);
				logger.info("含有敏感词：+ " + keyWord);
				return result;
			}
			
			//替代回车换行
			content = content.replace("\r\n", "");
			hgDiyInfo.setDiyInfoContent(content);
		}

		try {

			// 数据库中取出该签名规则
			Integer ruleId = hgSendrule.getId();
			HgSendrule hgSendruleOld = hgSendruleDao.getById(ruleId);

			// ************************** 下面代码为设置类型显示方式 *********************
			// 设置类型显示方式,true表示按照天时间段设置，false表示按照星期设置
			boolean typeFlag;
			String priodTime = hgSendrule.getSendruleSendperiodtime();
			String weeks = hgSendrule.getSendruleWeeks();
			if (priodTime == null || priodTime.length() == 0) {
				// 按周设置
				typeFlag = false;
				// sendperiodtime置空
				priodTime = null;
				hgSendruleOld.setSendruleSendperiodtime(priodTime);
				hgSendruleOld.setSendruleWeeks(weeks);
				hgSendruleOld.setSendruleName(HgSendrule.WEEKRULE);
			} else {
				// 按天设置
				typeFlag = true;
				// sendruleWeeks置空
				weeks = null;
				hgSendruleOld.setSendruleWeeks(weeks);
				hgSendruleOld.setSendruleSendperiodtime(priodTime);
				hgSendruleOld.setSendruleName(HgSendrule.DAYRULE);
				// 设置周显示为null
				hgSendruleOld.setWeeksShow(null);
			}
			// ************************** 设置类型显示方式结束 *********************

			// ************************** 下面代码为规则冲突性检验 *********************
			// 取得设置的手机号
			String callingNumbers = hgSendruleOld.getCallingNumbers();
			String[] callingNumber = callingNumbers.split(",");

			// 用于比较时间的SimpleDateFormat对象
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

			// 取出该客户的所有个性化规则
			Integer customerId = hgSendrule.getCustomerId();
			List<HgSendrule> hgSendrulesLoad = hgSendruleDao
					.getPersonalizeByCustomerId(customerId);

			// 遍历检测
			Iterator<HgSendrule> it = hgSendrulesLoad.iterator();
			while (it.hasNext()) {
				HgSendrule hgSendruleLoad = it.next();
				// 如果不是要更新的规则，则进行检测
				if (!hgSendruleOld.getId().equals(hgSendruleLoad.getId())) {
					// 首先检测是否有相同的手机号，如果有则继续进行下面的检测，否则continue
					String callingNumbersLoad = hgSendruleLoad
							.getCallingNumbers();
					String callingNumbersCompare = callingNumbersLoad + "*";
					// 是否有相同手机号码的标识
					boolean isHas = false;
					for (int i = 0; i < callingNumber.length; i++) {
						if (callingNumbersCompare.indexOf(callingNumber[i]) >= 0) {
							isHas = true;
							break;
						}
					}

					// 如果没有相同的号码，则continue
					if (!isHas) {
						continue;
					}

					// 开始检测
					if (typeFlag) {
						// 天设置时间段检测
						String periodTimeLoad = hgSendruleLoad
								.getSendruleSendperiodtime();
						if (periodTimeLoad != null) {
							String[] timeLoad = periodTimeLoad.split("-");
							String[] time = priodTime.split("-");

							Date startTimeLoad = null;
							Date endTimeLoad = null;
							Date startTime = null;
							Date endTime = null;
							try {
								// 数据库中数据的开始时间和结束时间
								startTimeLoad = sdf.parse(timeLoad[0]);
								endTimeLoad = sdf.parse(timeLoad[1]);

								// 要创建的规则的开始时间和结束时间
								startTime = sdf.parse(time[0]);
								endTime = sdf.parse(time[1]);
							} catch (ParseException e) {
								logger.error(
										"Unable to parse time with SimpleDateFormat",
										e);
								throw new SignatureServiceException(
										"Unable to parse time with SimpleDateFormat",
										e);
							}

							// 如果时间段没有交叉，则continue，否则返回
							if (endTime.before(startTimeLoad)
									|| endTimeLoad.before(startTime)) {
								continue;
							} else {
								result.setRemark("失败：与已有签名规则的时间段冲突");
								return result;
							}
						}
					} else {
						// 星期设置检测
						String weeksLoad = hgSendruleLoad.getSendruleWeeks();
						if (weeksLoad != null) {
							char[] weeksCharLoad = weeksLoad.toCharArray();
							char[] weeksChar = weeks.toCharArray();

							// 循环判断是否有相同的1
							for (int i = 0; i < weeksCharLoad.length; i++) {
								// 如果有相同的1,则返回
								if (weeksChar[i] == '1'
										&& weeksCharLoad[i] == '1') {
									result.setRemark("失败：与已有签名规则的周设置冲突");
									return result;
								}
							}
						}

					}
				}

			}
			// ************************** 冲突性检验代码结束 *********************

			// 对HgDiyInfo进行相应设置并更新
			Integer diyInfoId = hgSendruleOld.getDiyInfo().getId();
			HgDiyInfo hgDiyInfoOld = hgDiyInfoDao.getById(diyInfoId);
			hgDiyInfoOld.setDiyInfoContent(hgDiyInfo.getDiyInfoContent());

			// 设置original
			SignatureOriginal original = hgDiyInfo.getOriginal();
			if (original != null) {
				SignatureOriginal originalOld = hgDiyInfoOld.getOriginal();
				if (originalOld == null
						|| !originalOld.getId().equals(original.getId())) {
					SignatureOriginal originalLoad = signatureOriginalDao
							.getById(original.getId());
					hgDiyInfoOld.setOriginal(originalLoad);
				}

			}

			// // 设置library
			// SignatureLibrary library = hgDiyInfo.getLibrary();
			// if (library != null) {
			// SignatureLibrary libraryOld = hgDiyInfoOld.getLibrary();
			// if (libraryOld == null
			// || !libraryOld.getId().equals(library.getId())) {
			// SignatureLibrary libraryLoad = signatureLibraryDao
			// .getById(library.getId());
			// hgDiyInfoOld.setLibrary(libraryLoad);
			// }
			//
			// }

			// 设置签名宝库（盒）的ID
			SignatureLibrary library = hgSendrule.getDiyInfo().getLibrary();
			if (library != null) {
				// 签名宝库（盒）中签名ID
				Integer libraryId = library.getId();

				// 如果签名宝库（盒）中签名ID不为空，则设置libraryId，且Flag置标志位为HgDiyInfo.USESINGLE,最后要置libraryClassId和libraryClassName
				// 否则，则设置libraryClassId和libraryClassName，且Flag置标志位为HgDiyInfo.USELIBRARY,最后要置Library为null
				if (libraryId != null) {
					hgDiyInfoOld.setLibrary(library);
					hgDiyInfoOld.setFlag(HgDiyInfo.USESINGLE);
					
					hgDiyInfoOld.setLibraryClassId(null);
					hgDiyInfoOld.setLibraryClassName(null);
				} else {
					Integer classId = library.getSignatureClass().getId();
					hgDiyInfoOld.setLibraryClassId(classId);

					SignatureClass signatureClass = signatureClassDao
							.getById(classId);
					hgDiyInfoOld.setLibraryClassName(signatureClass.getName());
					hgDiyInfoOld.setFlag(HgDiyInfo.USELIBRARY);

					hgDiyInfoOld.setLibrary(null);
				}
			} else {
				hgDiyInfoOld.setFlag(HgDiyInfo.USESINGLE);
			}

			hgDiyInfoDao.update(hgDiyInfoOld);

			// 设置HgSendrule并更新
			// 设置星期的显示字段
			String sendruleWeeks = hgSendruleOld.getSendruleWeeks();
			if (sendruleWeeks != null) {
				char[] sendruleWeeksChar = sendruleWeeks.toCharArray();
				String weeksShow = "星期：";
				for (int i = 0; i < sendruleWeeksChar.length; i++) {
					if (sendruleWeeksChar[i] == '1') {
						String week = "";
						switch (i) {
						case 1:
							week = "一";
							break;
						case 2:
							week = "二";
							break;
						case 3:
							week = "三";
							break;
						case 4:
							week = "四";
							break;
						case 5:
							week = "五";
							break;
						case 6:
							week = "六";
							break;
						default:
							week = "日";
						}
						weeksShow += week;
					}
				}
				hgSendruleOld.setWeeksShow(weeksShow);
			}

			hgSendruleOld.setDiyInfo(hgDiyInfoOld);

			hgSendruleDao.update(hgSendruleOld);

			// 返回结果
			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to modify personalized rule for customerId: "
					+ hgSendrule.getCustomerId(), e);
			throw new SignatureServiceException(
					"Unable to modify personalized rule for customerId: "
							+ hgSendrule.getCustomerId(), e);
		}

		return result;
	}

	public Result getPersonalizedRule(User user)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 取得customerId，并根据customerId查询
		Integer customerId = user.getCustomerId();
		try {
			List<HgSendrule> list = (List<HgSendrule>) hgSendruleDao
					.getPersonalizeByCustomerId(customerId);

			// 返回
			result.setSuccess(true);
			result.getModel().put("personalizedRuleList", list);
		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to get Personalized rule for user: "
							+ user.getLoginName(), e);
			throw new SignatureServiceException(
					"Unable to get Personalized rule for user: "
							+ user.getLoginName(), e);
		}

		return result;
	}

	public Result getPersonalizedRule(User user, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 用户的customerId
		Integer customerId = user.getCustomerId();

		try {
			// 取得该用户个性化签名的数量,并新生成Page对象
			Integer totalRecords = hgSendruleDao
					.getPersonalizeCountByCustomerId(customerId);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<HgSendrule> list = hgSendruleDao
					.getPersonalizeByCustomerIdForPage(customerId, offSet,
							pageSize);

			// 返回结果
			result.setSuccess(true);
			result.getModel().put("hgSendruleList", list);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to get personalized rule page for user: "
					+ user.getLoginName(), e);
			throw new SignatureServiceException(
					"Unable to get personalized rule page for user: "
							+ user.getLoginName(), e);
		}

		return result;
	}

	public Result deletePersonalizedRule(List<Integer> sendruleIdList)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Iterator<Integer> it = sendruleIdList.iterator();

		try {
			// 循环删除
			while (it.hasNext()) {
				Integer sendruleId = it.next();

				// 删除规则,此处没有删除sendrule对应的HgDiyInfo
				hgSendruleDao.delete(sendruleId);

			}

			// 返回结果
			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to delete personalized rule for user", e);
			throw new SignatureServiceException(
					"Unable to delete personalized rule for user", e);
		}

		return result;
	}

	public HgSendruleDao getHgSendruleDao() {
		return hgSendruleDao;
	}

	public void setHgSendruleDao(HgSendruleDao hgSendruleDao) {
		this.hgSendruleDao = hgSendruleDao;
	}

	public HgDiyInfoDao getHgDiyInfoDao() {
		return hgDiyInfoDao;
	}

	public void setHgDiyInfoDao(HgDiyInfoDao hgDiyInfoDao) {
		this.hgDiyInfoDao = hgDiyInfoDao;
	}

	public String getDefaultCallingNumbers() {
		return defaultCallingNumbers;
	}

	public void setDefaultCallingNumbers(String defaultCallingNumbers) {
		this.defaultCallingNumbers = defaultCallingNumbers;
	}

	public String getDefaultSendPeriodTime() {
		return defaultSendPeriodTime;
	}

	public void setDefaultSendPeriodTime(String defaultSendPeriodTime) {
		this.defaultSendPeriodTime = defaultSendPeriodTime;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public SignatureClassDao getSignatureClassDao() {
		return signatureClassDao;
	}

	public void setSignatureClassDao(SignatureClassDao signatureClassDao) {
		this.signatureClassDao = signatureClassDao;
	}

	public Integer getMaxPersonalizeCount() throws SignatureServiceException {

		Portal portal = (Portal) parameterUtil.getParameter("portal");

		if (portal != null) {
			return portal.getMaxPersonalizeCount();
		} else {
			return maxPersonalizeCount;
		}

	}

	public void setMaxPersonalizeCount(Integer maxPersonalizeCount) {
		this.maxPersonalizeCount = maxPersonalizeCount;
	}

	public SignatureLibraryDao getSignatureLibraryDao() {
		return signatureLibraryDao;
	}

	public void setSignatureLibraryDao(SignatureLibraryDao signatureLibraryDao) {
		this.signatureLibraryDao = signatureLibraryDao;
	}

	public SignatureOriginalDao getSignatureOriginalDao() {
		return signatureOriginalDao;
	}

	public void setSignatureOriginalDao(
			SignatureOriginalDao signatureOriginalDao) {
		this.signatureOriginalDao = signatureOriginalDao;
	}

	public HgOwnPhoneDao getHgOwnPhoneDao() {
		return hgOwnPhoneDao;
	}

	public void setHgOwnPhoneDao(HgOwnPhoneDao hgOwnPhoneDao) {
		this.hgOwnPhoneDao = hgOwnPhoneDao;
	}

	public Integer getIfFlowcontrol() {
		return ifFlowcontrol;
	}

	public void setIfFlowcontrol(Integer ifFlowcontrol) {
		this.ifFlowcontrol = ifFlowcontrol;
	}

	public Integer getFlowcontrol() {
		return flowcontrol;
	}

	public void setFlowcontrol(Integer flowcontrol) {
		this.flowcontrol = flowcontrol;
	}

	public Integer getSmInterval() {
		return smInterval;
	}

	public void setSmInterval(Integer smInterval) {
		this.smInterval = smInterval;
	}

	public Integer getMaxDefaultCount() throws SignatureServiceException {
		Portal portal = (Portal) parameterUtil.getParameter("portal");

		if (portal != null) {
			return portal.getMaxDefaultCount();
		} else {
			return maxDefaultCount;
		}

	}

	public void setMaxDefaultCount(Integer maxDefaultCount) {
		this.maxDefaultCount = maxDefaultCount;
	}

	public ParameterUtil getParameterUtil() {
		return parameterUtil;
	}

	public void setParameterUtil(ParameterUtil parameterUtil) {
		this.parameterUtil = parameterUtil;
	}

}
