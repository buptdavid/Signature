/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
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
 * RuleServiceʵ����
 * 
 * @author ·����
 * @version <p>
 *          2011-8-2 ����
 *          </p>
 */
public class RuleServiceImpl implements RuleService {

	/** �û�ÿ������õ�Ĭ��ǩ���������,Ĭ��Ϊ10(�������ļ�������) */
	private Integer maxDefaultCount;

	/** �����õĸ��Ի�ǩ��������������,Ĭ��Ϊ20(�������ļ�������) */
	private Integer maxPersonalizeCount;

	/** �Ƿ���������1��ʾ���ƣ�0��ʾ������(�Ѿ�����) */
	private Integer ifFlowcontrol;

	/** ÿ�췢��������ֵ(�Ѿ����ã���̨�жϵ�ֵ�ӱ�MESSAGE_SENDȡ��) */
	private Integer flowcontrol;

	/** �ط��������λ����(�Ѿ����ã���̨�жϵ�ֵ�ӱ�MESSAGE_SENDȡ��) */
	private Integer smInterval;

	private HgSendruleDao hgSendruleDao;

	private HgDiyInfoDao hgDiyInfoDao;

	private HgOwnPhoneDao hgOwnPhoneDao;

	private SignatureClassDao signatureClassDao;

	private SignatureLibraryDao signatureLibraryDao;

	private SignatureOriginalDao signatureOriginalDao;

	private Filter filter;

	private ParameterUtil parameterUtil;

	/** �Ѿ�����Ĭ��ǩ������ʱ����Ϣ */
	public static final String DEFAULT_HAVED = "���Ѵ���Ĭ��ǩ���������ظ�����!";

	/** ����Ĭ��ǩ������ʱ�����к��� */
	private String defaultCallingNumbers;

	/** ����Ĭ��ǩ������ʱ��ʱ��� */
	private String defaultSendPeriodTime;

	/** ��־��¼ */
	private static Log logger = LogFactory.getLog(RuleServiceImpl.class);

	public Result createDefaultRule(User user) throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer customerId = user.getCustomerId();

		try {
			// ȡ��HgOwnPhone
			HgOwnPhone hgOwnPhone = hgOwnPhoneDao.findByCustomerId(customerId);

			// ���Ϊ�գ�����뱣��
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

		// ����û��Ŀͻ�ID
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

		// ���ؽ��
		return result;
	}

	public Result getDefaultRule(User user, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// �û��Ŀͻ�ID
		Integer customerId = user.getCustomerId();

		try {
			// ȡ�ø��û�Ĭ��ǩ��������,��������Page����
			Integer totalRecords = hgDiyInfoDao.findCountByCustomerId(
					customerId, HgDiyInfo.DEFAULT);
			page = PageUtil.createPage(page, totalRecords);

			// ��һ����¼������ÿҳ�ļ�¼����
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<HgDiyInfo> hgDiyInfoList = hgDiyInfoDao
					.findByCustomerIdForPage(customerId, HgDiyInfo.DEFAULT,
							offSet, pageSize);

			// ��װ��HgSendrule����
			List<HgSendrule> hgSendruleList = new ArrayList<HgSendrule>();

			// ���ݿ���ȡ�øÿͻ���Ĭ��ǩ������
			HgSendrule hgSendruleLoad = hgSendruleDao
					.getDefaultByCustomerId(customerId);
			// ȡ�õ�ǰ��ǩ��
			HgDiyInfo currentDiyInfo = hgSendruleLoad.getDiyInfo();
			SignatureLibrary library = currentDiyInfo.getLibrary();
			// ����signatureClass,�Ѿ�����lazy=false
			// if(library != null){
			// //ȡ��signatureClass
			// SignatureClass signatureClass = library.getSignatureClass();
			// Integer classId = signatureClass.getId();
			// library.setSignatureClass(signatureClassDao.getById(classId));
			// }

			Iterator<HgDiyInfo> it = hgDiyInfoList.iterator();
			while (it.hasNext()) {
				// ��¡HgSendrule����
				HgSendrule hgSendrule = hgSendruleLoad.clone();
				hgSendrule.setDiyInfo(it.next());

				hgSendruleList.add(hgSendrule);
			}

			// ���صĽ��
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

		// �����Ҫ��ǩ������,������
		HgDiyInfo hgDiyInfo = hgSendrule.getDiyInfo();

		// ��ǩ�����ݽ������дʹ���
		String content = hgDiyInfo.getDiyInfoContent();

		// ���дʹ���
		if (content != null && content.trim().length() > 0) {
			String keyWord = filter.contain(content);
			if (keyWord != null) {
				logger.info("�������дʣ�+ " + keyWord);
				result.setRemark("-->ǩ���������д�:" + keyWord);
				// ����
				return result;
			}
			
			//����س�����
			content = content.replace("\r\n", "");
			hgDiyInfo.setDiyInfoContent(content);
		}

		// ����û��Ŀͻ�ID
		Integer customerId = hgSendrule.getCustomerId();

		try {
			// ��õ�����ʱ��ʱ��
			Calendar calender = Calendar.getInstance();
			calender.set(calender.get(Calendar.YEAR),
					calender.get(Calendar.MONTH),
					calender.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			Date date = calender.getTime();
			Integer defaultCount = hgDiyInfoDao.findCountDefaultForTime(
					customerId, date);

			// ����������õ�Ĭ��ǩ���������������õ����ֵ���򷵻�
			if (defaultCount >= this.getMaxDefaultCount()) {
				logger.info("������Ĭ��ǩ��ÿ���������ֵ");
				result.setRemark("-->�������Ĭ��ǩ������������" + this.getMaxDefaultCount()
						+ "��");
				return result;
			}

			// �����Զ�����Ϣ����ʱ��
			Date currentTime = new Date();
			hgDiyInfo.setDiyInfoCreatetime(currentTime);
			// ����ǩ�����
			hgDiyInfo.setIsDefault(HgDiyInfo.DEFAULT);

			// ����ǩ�����⣨�У���ID
			SignatureLibrary library = hgSendrule.getDiyInfo().getLibrary();

			if (library != null) {
				// ǩ�����⣨�У���ǩ��ID
				Integer libraryId = library.getId();

				// ���ǩ�����⣨�У���ǩ��ID��Ϊ�գ�������libraryId����Flag�ñ�־λΪHgDiyInfo.USESINGLE,���Ҫ��libraryClassId��libraryClassName
				// ����������libraryClassId��libraryClassName����Flag�ñ�־λΪHgDiyInfo.USELIBRARY,���Ҫ��LibraryΪnull
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

			// �������ŷ��ͺ�δ�õ��ֶ�
			hgDiyInfo.setMessageTypeId(HgDiyInfo.FLASH);
			hgDiyInfo.setDiyInfoCurType(HgDiyInfo.USED);

			// ����
			hgDiyInfoDao.save(hgDiyInfo);

			HgSendrule hgSendrule2 = hgSendruleDao
					.getDefaultByCustomerId(customerId);
			hgSendrule2.setDiyInfo(hgDiyInfo);
			hgSendrule2.setSendruleCreatetime(currentTime);

			// ����
			hgSendruleDao.update(hgSendrule2);

			// ���ؽ��
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
		// ֻ��Ҫ���ؿ����õĸ��Ի�ǩ��������������
		Result result = Result.createRestult();

		result.setSuccess(true);
		result.getModel().put("maxPersonalizeCount",
				this.getMaxPersonalizeCount());
		return result;
	}

	public Result createPersonalizedRule(HgSendrule hgSendrule)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// �����Ҫǩ�������ݣ�������
		HgDiyInfo hgDiyInfo = hgSendrule.getDiyInfo();

		// ��ǩ�����ݽ������дʹ���
		String content = hgDiyInfo.getDiyInfoContent();
		if (content != null && content.trim().length() > 0) {
			String keyWord = filter.contain(content);
			if (keyWord != null) {
				result.setRemark(keyWord);
				logger.info("�������дʣ�+ " + keyWord);
				return result;
			}
			
			//����س�����
			content = content.replace("\r\n", "");
			hgDiyInfo.setDiyInfoContent(content);
		}

		try {
			// ���й����ͻ����
			Integer customerId = hgSendrule.getCustomerId();

			// ��ѯ����
			Integer count = hgSendruleDao
					.getPersonalizeCountByCustomerId(customerId);
			// ��������������õ����ֵ�򷵻�
			if (count >= this.getMaxPersonalizeCount()) {
				result.setRemark("ʧ�ܣ�ǩ�����������Ѿ�����"
						+ this.getMaxPersonalizeCount() + "��");
				return result;
			}

			// ȡ���ÿͻ������и��Ի�����
			List<HgSendrule> hgSendrulesLoad = hgSendruleDao
					.getPersonalizeByCustomerId(customerId);

			// �������ͷ�ʽ,true��ʾ������ʱ������ã�false��ʾ������������
			boolean typeFlag;
			String priodTime = hgSendrule.getSendruleSendperiodtime();
			String weeks = hgSendrule.getSendruleWeeks();
			if (priodTime == null || priodTime.length() == 0) {
				// ��������
				typeFlag = false;
				// sendperiodtime�ÿ�
				priodTime = null;
				hgSendrule.setSendruleSendperiodtime(priodTime);
				hgSendrule.setSendruleName(HgSendrule.WEEKRULE);
			} else {
				// ��������
				typeFlag = true;
				// sendruleWeeks�ÿ�
				weeks = null;
				hgSendrule.setSendruleWeeks(weeks);
				hgSendrule.setSendruleName(HgSendrule.DAYRULE);
			}

			// ȡ�����õ��ֻ���
			String callingNumbers = hgSendrule.getCallingNumbers();

			String[] callingNumber = callingNumbers.split(",");

			// ���ڱȽ�ʱ���SimpleDateFormat����
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			// �������
			Iterator<HgSendrule> it = hgSendrulesLoad.iterator();
			while (it.hasNext()) {
				HgSendrule hgSendruleLoad = it.next();

				// ���ȼ���Ƿ�����ͬ���ֻ��ţ�������������������ļ�⣬����continue
				String callingNumbersLoad = hgSendruleLoad.getCallingNumbers();
				String callingNumbersCompare = callingNumbersLoad + "*";
				// �Ƿ�����ͬ�ֻ�����ı�ʶ
				boolean isHas = false;
				for (int i = 0; i < callingNumber.length; i++) {
					if (callingNumbersCompare.indexOf(callingNumber[i]) >= 0) {
						isHas = true;
						break;
					}
				}

				// ���û����ͬ�ĺ��룬��continue
				if (!isHas) {
					continue;
				}

				// ��ʼ���
				if (typeFlag) {
					// ������ʱ��μ��
					// ������ݿ��к��д˺���İ������ã����г�ͻ������
					String ruleNameLoad = hgSendruleLoad.getSendruleName();
					if (ruleNameLoad.trim().equals(HgSendrule.WEEKRULE)) {
						result.setRemark("ʧ�ܣ�������ǩ�������ʱ��γ�ͻ");
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
							// ���ݿ������ݵĿ�ʼʱ��ͽ���ʱ��
							startTimeLoad = sdf.parse(timeLoad[0]);
							endTimeLoad = sdf.parse(timeLoad[1]);

							// Ҫ�����Ĺ���Ŀ�ʼʱ��ͽ���ʱ��
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

						// ���ʱ���û�н��棬��continue�����򷵻�
						if (endTime.before(startTimeLoad)
								|| endTimeLoad.before(startTime)) {
							continue;
						} else {
							result.setRemark("ʧ�ܣ�������ǩ�������ʱ��γ�ͻ");
							return result;
						}
					}
				} else {
					// �������ü��
					// ������ݿ��к��д˺���İ������ã����г�ͻ������
					String ruleNameLoad = hgSendruleLoad.getSendruleName();
					if (ruleNameLoad.trim().equals(HgSendrule.DAYRULE)) {
						result.setRemark("ʧ�ܣ�������ǩ�������ʱ��γ�ͻ");
						return result;
					}

					String weeksLoad = hgSendruleLoad.getSendruleWeeks();
					if (weeksLoad != null) {
						char[] weeksCharLoad = weeksLoad.toCharArray();
						char[] weeksChar = weeks.toCharArray();

						// ѭ���ж��Ƿ�����ͬ��1
						for (int i = 0; i < weeksCharLoad.length; i++) {
							// �������ͬ��1,�򷵻�
							if (weeksChar[i] == '1' && weeksCharLoad[i] == '1') {
								result.setRemark("ʧ�ܣ�������ǩ������������ó�ͻ");
								return result;
							}
						}
					}

				}
			}

			// �����Զ�����Ϣ����ʱ��
			Date currentTime = new Date();
			hgDiyInfo.setDiyInfoCreatetime(currentTime);
			// ����ǩ�����
			hgDiyInfo.setIsDefault(HgDiyInfo.PERSONALIZED);
			// ��������
			hgDiyInfo.setMessageTypeId(HgDiyInfo.FLASH);
			// �Ƿ�ʹ�ñ�־
			hgDiyInfo.setDiyInfoCurType(HgDiyInfo.USED);
			// ������Ӧ�������Ϊnull

			// ����ǩ�����⣨�У���ID
			SignatureLibrary library = hgSendrule.getDiyInfo().getLibrary();
			if (library != null) {
				// ǩ�����⣨�У���ǩ��ID
				Integer libraryId = library.getId();

				// ���ǩ�����⣨�У���ǩ��ID��Ϊ�գ�������libraryId����Flag�ñ�־λΪHgDiyInfo.USESINGLE,���Ҫ��libraryClassId��libraryClassName
				// ����������libraryClassId��libraryClassName����Flag�ñ�־λΪHgDiyInfo.USELIBRARY,���Ҫ��LibraryΪnull
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

			// ������Ի�ǩ������
			hgSendrule.setDiyInfo(hgDiyInfo);
			hgSendrule.setIsDefault(HgSendrule.PERSONALIZED);
			// ����������
			hgSendrule.setSendruleIfFlowcontrol(0);
			// ��������
			// �Ƿ���������
			hgSendrule.setSendruleCallState(ifFlowcontrol);
			// ����������ֵ
			hgSendrule.setSendruleFlowcontrol(flowcontrol);
			// �ط����(��Ϊ��λ)
			hgSendrule.setSendruleSmInterval(smInterval);
			// ���ô���ʱ��
			hgSendrule.setSendruleCreatetime(currentTime);
			// ����״̬
			hgSendrule.setSendruleState(3);
			// �������ڵ���ʾ�ֶ�
			String sendruleWeeks = hgSendrule.getSendruleWeeks();
			if (sendruleWeeks != null) {
				char[] sendruleWeeksChar = sendruleWeeks.toCharArray();
				String weeksShow = "���ڣ�";
				for (int i = 0; i < sendruleWeeksChar.length; i++) {
					if (sendruleWeeksChar[i] == '1') {
						String week = "";
						switch (i) {
						case 1:
							week = "һ";
							break;
						case 2:
							week = "��";
							break;
						case 3:
							week = "��";
							break;
						case 4:
							week = "��";
							break;
						case 5:
							week = "��";
							break;
						case 6:
							week = "��";
							break;
						default:
							week = "��";
						}
						weeksShow += week;
					}
				}
				hgSendrule.setWeeksShow(weeksShow);
			}

			// ȡ��HgOwnPhone
			HgOwnPhone hgOwnPhone = hgOwnPhoneDao.findByCustomerId(customerId);

			Integer ownPhoneId = null;
			if (hgOwnPhone != null) {
				ownPhoneId = hgOwnPhone.getId();
			}
			hgSendrule.setCalledNumbers(String.valueOf(ownPhoneId));

			// ����
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

			// Ϊǩ�������õ�һ������
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

			// ���ؽ��
			result.setSuccess(true);
			result.getModel().put("personalizedRule", hgSendrule);
		} catch (SignaturePersistException e) {
			logger.error("Unable to get personalized rule for id: " + id, e);
			throw new SignatureServiceException(
					"Unable to get personalized rule for id: " + id, e);
		}

		// ����
		return result;
	}

	public Result modifyPersonalizedRule(HgSendrule hgSendrule)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// �����Ҫǩ�������ݽ��������ֹ���
		HgDiyInfo hgDiyInfo = hgSendrule.getDiyInfo();

		// ��ǩ�����ݽ������дʹ���
		String content = hgDiyInfo.getDiyInfoContent();

		if (content != null && content.trim().length() > 0) {
			String keyWord = filter.contain(content);
			if (keyWord != null) {
				result.setRemark(keyWord);
				logger.info("�������дʣ�+ " + keyWord);
				return result;
			}
			
			//����س�����
			content = content.replace("\r\n", "");
			hgDiyInfo.setDiyInfoContent(content);
		}

		try {

			// ���ݿ���ȡ����ǩ������
			Integer ruleId = hgSendrule.getId();
			HgSendrule hgSendruleOld = hgSendruleDao.getById(ruleId);

			// ************************** �������Ϊ����������ʾ��ʽ *********************
			// ����������ʾ��ʽ,true��ʾ������ʱ������ã�false��ʾ������������
			boolean typeFlag;
			String priodTime = hgSendrule.getSendruleSendperiodtime();
			String weeks = hgSendrule.getSendruleWeeks();
			if (priodTime == null || priodTime.length() == 0) {
				// ��������
				typeFlag = false;
				// sendperiodtime�ÿ�
				priodTime = null;
				hgSendruleOld.setSendruleSendperiodtime(priodTime);
				hgSendruleOld.setSendruleWeeks(weeks);
				hgSendruleOld.setSendruleName(HgSendrule.WEEKRULE);
			} else {
				// ��������
				typeFlag = true;
				// sendruleWeeks�ÿ�
				weeks = null;
				hgSendruleOld.setSendruleWeeks(weeks);
				hgSendruleOld.setSendruleSendperiodtime(priodTime);
				hgSendruleOld.setSendruleName(HgSendrule.DAYRULE);
				// ��������ʾΪnull
				hgSendruleOld.setWeeksShow(null);
			}
			// ************************** ����������ʾ��ʽ���� *********************

			// ************************** �������Ϊ�����ͻ�Լ��� *********************
			// ȡ�����õ��ֻ���
			String callingNumbers = hgSendruleOld.getCallingNumbers();
			String[] callingNumber = callingNumbers.split(",");

			// ���ڱȽ�ʱ���SimpleDateFormat����
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

			// ȡ���ÿͻ������и��Ի�����
			Integer customerId = hgSendrule.getCustomerId();
			List<HgSendrule> hgSendrulesLoad = hgSendruleDao
					.getPersonalizeByCustomerId(customerId);

			// �������
			Iterator<HgSendrule> it = hgSendrulesLoad.iterator();
			while (it.hasNext()) {
				HgSendrule hgSendruleLoad = it.next();
				// �������Ҫ���µĹ�������м��
				if (!hgSendruleOld.getId().equals(hgSendruleLoad.getId())) {
					// ���ȼ���Ƿ�����ͬ���ֻ��ţ�������������������ļ�⣬����continue
					String callingNumbersLoad = hgSendruleLoad
							.getCallingNumbers();
					String callingNumbersCompare = callingNumbersLoad + "*";
					// �Ƿ�����ͬ�ֻ�����ı�ʶ
					boolean isHas = false;
					for (int i = 0; i < callingNumber.length; i++) {
						if (callingNumbersCompare.indexOf(callingNumber[i]) >= 0) {
							isHas = true;
							break;
						}
					}

					// ���û����ͬ�ĺ��룬��continue
					if (!isHas) {
						continue;
					}

					// ��ʼ���
					if (typeFlag) {
						// ������ʱ��μ��
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
								// ���ݿ������ݵĿ�ʼʱ��ͽ���ʱ��
								startTimeLoad = sdf.parse(timeLoad[0]);
								endTimeLoad = sdf.parse(timeLoad[1]);

								// Ҫ�����Ĺ���Ŀ�ʼʱ��ͽ���ʱ��
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

							// ���ʱ���û�н��棬��continue�����򷵻�
							if (endTime.before(startTimeLoad)
									|| endTimeLoad.before(startTime)) {
								continue;
							} else {
								result.setRemark("ʧ�ܣ�������ǩ�������ʱ��γ�ͻ");
								return result;
							}
						}
					} else {
						// �������ü��
						String weeksLoad = hgSendruleLoad.getSendruleWeeks();
						if (weeksLoad != null) {
							char[] weeksCharLoad = weeksLoad.toCharArray();
							char[] weeksChar = weeks.toCharArray();

							// ѭ���ж��Ƿ�����ͬ��1
							for (int i = 0; i < weeksCharLoad.length; i++) {
								// �������ͬ��1,�򷵻�
								if (weeksChar[i] == '1'
										&& weeksCharLoad[i] == '1') {
									result.setRemark("ʧ�ܣ�������ǩ������������ó�ͻ");
									return result;
								}
							}
						}

					}
				}

			}
			// ************************** ��ͻ�Լ��������� *********************

			// ��HgDiyInfo������Ӧ���ò�����
			Integer diyInfoId = hgSendruleOld.getDiyInfo().getId();
			HgDiyInfo hgDiyInfoOld = hgDiyInfoDao.getById(diyInfoId);
			hgDiyInfoOld.setDiyInfoContent(hgDiyInfo.getDiyInfoContent());

			// ����original
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

			// // ����library
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

			// ����ǩ�����⣨�У���ID
			SignatureLibrary library = hgSendrule.getDiyInfo().getLibrary();
			if (library != null) {
				// ǩ�����⣨�У���ǩ��ID
				Integer libraryId = library.getId();

				// ���ǩ�����⣨�У���ǩ��ID��Ϊ�գ�������libraryId����Flag�ñ�־λΪHgDiyInfo.USESINGLE,���Ҫ��libraryClassId��libraryClassName
				// ����������libraryClassId��libraryClassName����Flag�ñ�־λΪHgDiyInfo.USELIBRARY,���Ҫ��LibraryΪnull
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

			// ����HgSendrule������
			// �������ڵ���ʾ�ֶ�
			String sendruleWeeks = hgSendruleOld.getSendruleWeeks();
			if (sendruleWeeks != null) {
				char[] sendruleWeeksChar = sendruleWeeks.toCharArray();
				String weeksShow = "���ڣ�";
				for (int i = 0; i < sendruleWeeksChar.length; i++) {
					if (sendruleWeeksChar[i] == '1') {
						String week = "";
						switch (i) {
						case 1:
							week = "һ";
							break;
						case 2:
							week = "��";
							break;
						case 3:
							week = "��";
							break;
						case 4:
							week = "��";
							break;
						case 5:
							week = "��";
							break;
						case 6:
							week = "��";
							break;
						default:
							week = "��";
						}
						weeksShow += week;
					}
				}
				hgSendruleOld.setWeeksShow(weeksShow);
			}

			hgSendruleOld.setDiyInfo(hgDiyInfoOld);

			hgSendruleDao.update(hgSendruleOld);

			// ���ؽ��
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

		// ȡ��customerId��������customerId��ѯ
		Integer customerId = user.getCustomerId();
		try {
			List<HgSendrule> list = (List<HgSendrule>) hgSendruleDao
					.getPersonalizeByCustomerId(customerId);

			// ����
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

		// �û���customerId
		Integer customerId = user.getCustomerId();

		try {
			// ȡ�ø��û����Ի�ǩ��������,��������Page����
			Integer totalRecords = hgSendruleDao
					.getPersonalizeCountByCustomerId(customerId);
			page = PageUtil.createPage(page, totalRecords);

			// ��һ����¼������ÿҳ�ļ�¼����
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<HgSendrule> list = hgSendruleDao
					.getPersonalizeByCustomerIdForPage(customerId, offSet,
							pageSize);

			// ���ؽ��
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
			// ѭ��ɾ��
			while (it.hasNext()) {
				Integer sendruleId = it.next();

				// ɾ������,�˴�û��ɾ��sendrule��Ӧ��HgDiyInfo
				hgSendruleDao.delete(sendruleId);

			}

			// ���ؽ��
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
