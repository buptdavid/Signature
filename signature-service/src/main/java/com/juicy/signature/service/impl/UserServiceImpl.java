/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.rmi.RemoteException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.HgCustomerDao;
import com.juicy.signature.persist.dao.StUsersDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.StUsers;
import com.juicy.signature.service.UserService;
import com.juicy.signature.service.encryption.Encrypt;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.message.factory.WSFactory;
import com.juicy.signature.service.message.southinter.SmsReq;
import com.juicy.signature.service.message.southinter.WebControlPortType;
import com.juicy.signature.service.random.RandomCode;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * UserService�ӿ�ʵ����
 * 
 * @author ·����
 * @version <p>
 *          2011-7-29 ����
 *          </p>
 */
public class UserServiceImpl implements UserService {

	/** ������֤��ʧЧʱ��(����) */
	private Integer invalideMinute = 1;

	String frontMessage;

	String rearMessage;

	/** �����㷨���� */
	private Encrypt encrypt;

	/** StUsersDao���� */
	private StUsersDao stUsersDao;

	/** HgCustomerDao���� */
	HgCustomerDao hgCustomerDao;

	/** ��־��¼ */
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);

	public Result loginByPassword(String loginName, String password)
			throws SignatureServiceException {
		// �������ؽ��
		Result result = Result.createRestult();

		try {
			// ����loginNameȡ�ø��û�
			StUsers stUsers = stUsersDao.getByLoginName(loginName);

			// �жϸ��û��Ƿ����,���������Ƿ�Ϊ��
			if (stUsers == null || stUsers.getPassword() == null
					|| stUsers.getPassword().length() == 0) {
				result.setRemark(LOGINPASSWORDFAIL);
			} else {
				String password2 = stUsers.getPassword();

				// �ж������Ƿ�һ��
				if (encrypt.check(password, password2)) {
					result.setSuccess(true);
					result.setRemark(LOGINSUCCESS);

					// ȡ��HgCustomer����
					Integer userId = stUsers.getId();
					HgCustomer hgCustomer = hgCustomerDao.getByUserId(userId);
					Integer customerId = hgCustomer.getId();
					Integer specialNumberType = hgCustomer
							.getSpecialNumberType();
					Integer customerStat = hgCustomer.getCustomerStat();

					// ��������¼ʱ��
					Date lastLoginTime = stUsers.getLastLoginTime();
					Date currentTime = new Date();
					stUsers.setLastLoginTime(currentTime);

					// ���õ�¼����
					Integer loginCount = stUsers.getLoginCount();
					if (loginCount == null) {
						loginCount = 0;
					}
					Integer count = ++loginCount;
					stUsers.setLoginCount(count);

					// ����û��ǳ�Ϊ�գ����ʼ��ΪloginName
					String userNick = stUsers.getName();

					// �������ݿ��е�StUsers����
					stUsersDao.update(stUsers);

					// ��װ���ڱ��浽Session�е�User����
					User user = new User();
					user.setCustomerId(customerId);
					user.setLoginName(loginName);
					user.setUserId(userId);
					user.setLastLoginTime(lastLoginTime);
					user.setLoginCount(loginCount);
					user.setSpecialNumberType(specialNumberType);
					user.setUserNick(userNick);
					user.setCustomerStat(customerStat);
					user.setUserType(stUsers.getUserType());

					result.getModel().put("user", user);

				} else {
					result.setRemark(LOGINPASSWORDFAIL);
				}
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to login by password for user:" + loginName, e);
			throw new SignatureServiceException(
					"Unable to login by password for user: " + loginName, e);
		}

		// ���ؽ��
		return result;
	}

	public Result loginByVerfityCode(String loginName, String verfityCode)
			throws SignatureServiceException {
		// �������ؽ��
		Result result = Result.createRestult();

		try {
			// ����loginNameȡ�ø��û�
			StUsers stUsers = stUsersDao.getByLoginName(loginName);

			// �жϸ��û��Ƿ����
			if (stUsers == null) {
				result.setRemark("�û��������벻��!");
			} else {
				// ȡ�ö�����֤��ʧЧʱ��͵�ǰʱ��
				Date invalideTime = stUsers.getVerifyInvalideTime();
				Date currentTime = new Date();

				// ����û��Ѿ������˶�����֤�룬�������֤
				if (invalideTime != null) {
					// �ж϶�����֤���Ƿ����
					if (currentTime.after(invalideTime)) {
						result.setRemark(LOGINCODEOUT);
					} else {
						// �ж϶�����֤���Ƿ���ȷ
						String verfityCode2 = stUsers.getVerifyCode();
						if (encrypt.check(verfityCode, verfityCode2)) {
							result.setSuccess(true);
							result.setRemark(LOGINSUCCESS);

							// ȡ��HgCustomer����
							Integer userId = stUsers.getId();
							HgCustomer hgCustomer = hgCustomerDao
									.getByUserId(userId);
							Integer customerId = hgCustomer.getId();
							Integer specialNumberType = hgCustomer
									.getSpecialNumberType();
							Integer customerStat = hgCustomer.getCustomerStat();

							// ��������¼ʱ��
							Date lastLoginTime = stUsers.getLastLoginTime();
							stUsers.setLastLoginTime(currentTime);

							// ���õ�¼����
							Integer loginCount = stUsers.getLoginCount();
							if (loginCount == null) {
								loginCount = 0;
							}
							Integer count = ++loginCount;
							stUsers.setLoginCount(count);

							// ����û��ǳ�Ϊ�գ����ʼ��ΪloginName
							String userNick = stUsers.getName();

							// �������ݿ��е�StUsers����
							stUsersDao.update(stUsers);

							// ��װ���ڱ��浽Session�е�User����
							User user = new User();
							user.setCustomerId(customerId);
							user.setLoginName(loginName);
							user.setUserId(userId);
							user.setLoginCount(loginCount);
							user.setSpecialNumberType(specialNumberType);
							user.setLastLoginTime(lastLoginTime);
							user.setUserNick(userNick);
							user.setCustomerStat(customerStat);
							user.setUserType(stUsers.getUserType());

							result.getModel().put("user", user);
						} else {
							result.setRemark(LOGINCODEFAIL);
						}
					}
				} else {
					result.setRemark(UNSETCODE);
				}

			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to login by verfity code for user: ", e);
			throw new SignatureServiceException(
					"Unable to login by verfity code for user: " + loginName, e);
		}

		// ���ؽ��
		return result;
	}

	public Result createVerfityCode(String loginName)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// ����loginNameȡ�ø��û�
			StUsers stUsers = stUsersDao.getByLoginName(loginName);

			// �жϸ��û��Ƿ����
			if (stUsers == null) {
				result.setRemark(USERUNEXIST);
			} else {
				// ȡ���������ʧЧʱ��͵�ǰʱ��
				Date invalideTimeSave = stUsers.getVerifyInvalideTime();
				if (invalideTimeSave != null) {
					Date currentTime = new Date();
					// �����ǰʱ�����������ʧЧʱ��֮ǰ���򷵻�
					if (currentTime.before(invalideTimeSave)) {
						result.setRemark(HAVESENDCODE);
						// ����
						return result;
					}
				}

				// ���ɶ�����֤��
				String verfityCode = RandomCode.getRandomCode();

				// ����
				String verfityCodeEncode = encrypt.encode(verfityCode);

				// ������֤��ʧЧʱ��
				Date invalideTime = new Date();
				long currentMs = invalideTime.getTime();
				long invalidMs = currentMs + this.invalideMinute * 60 * 1000;
				invalideTime.setTime(invalidMs);

				// ����
				stUsers.setVerifyCode(verfityCodeEncode);
				stUsers.setVerifyInvalideTime(invalideTime);
				stUsersDao.update(stUsers);

				// ���û����Ͷ��������,������δͨ��
				String message = frontMessage + verfityCode + rearMessage;
				WebControlPortType client = WSFactory.getClient();
				SmsReq smsReq = new SmsReq();
				smsReq.setMsdn(loginName);
				smsReq.setCode(WSFactory.smsChannel);
				smsReq.setContent(message);
				try {
					client.sendsms(smsReq);
				} catch (RemoteException e) {
					logger.error("Unable to send verfity code for user: "
							+ loginName, e);
				}

				result.setSuccess(true);
				result.setRemark(SAVECODESUCCESS);
			}
		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to create verfity code for user: " + loginName, e);
			throw new SignatureServiceException(
					"Unable to create verfity code for user: " + loginName, e);
		}

		return result;
	}

	public Result modifyInformation(StUsers user)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// String loginName = user.getLoginName();
		Integer userId = user.getId();
		String name = user.getName();
		String email = user.getEmail();
		String remark = user.getRemark();

		try {
			StUsers stUsers = stUsersDao.getById(userId);
			stUsers.setName(name);
			stUsers.setEmail(email);
			stUsers.setRemark(remark);

			// ����
			stUsersDao.update(stUsers);

			// ���ؽ��
			result.setSuccess(true);
			result.getModel().put("user", stUsers);
		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to modify information for user: "
							+ user.getLoginName(), e);
			throw new SignatureServiceException(
					"Unable to modify information for user: "
							+ user.getLoginName(), e);
		}

		return result;
	}

	public Result modifyPassword(String loginName, String newPassword)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// ȡ�ø��û���Ϣ
			StUsers stUsers = stUsersDao.getByLoginName(loginName);

			if (stUsers == null) {
				result.setRemark(USERUNEXIST);
			} else {
				// ���ܵ�����
				String ciphertext = encrypt.encode(newPassword);

				// ��������
				stUsers.setPassword(ciphertext);
				stUsersDao.update(stUsers);

				result.setSuccess(true);
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to modify password for user: " + loginName, e);
			throw new SignatureServiceException(
					"Unable to modify password for user: " + loginName, e);
		}

		return result;
	}

	public Result modifyList(User user, Integer specialNumberType)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer customerId = user.getCustomerId();

		try {
			HgCustomer hgCustomer = hgCustomerDao.getById(customerId);
			hgCustomer.setSpecialNumberType(specialNumberType);

			// ����
			hgCustomerDao.update(hgCustomer);

			// ���صĽ��
			result.setSuccess(true);
			// �û�����Session�е��û�������Ϣ����
			user.setSpecialNumberType(specialNumberType);
			result.getModel().put("user", user);

		} catch (SignaturePersistException e) {
			logger.error("Unable to modify black or white list for user: "
					+ user.getLoginName(), e);
			throw new SignatureServiceException(
					"Unable to modify black or white list for user: "
							+ user.getLoginName(), e);
		}

		return result;
	}

	public Result getUser(User user) throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer userId = user.getUserId();

		try {
			StUsers stUsers = stUsersDao.getById(userId);

			result.setSuccess(true);
			result.getModel().put("user", stUsers);
		} catch (SignaturePersistException e) {
			logger.error("Unable to get user for user: " + user.getLoginName(),
					e);
			throw new SignatureServiceException("Unable to get user for user: "
					+ user.getLoginName(), e);

		}

		return result;
	}

	public Result modifyBusiness(User user, Integer customerStat)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		Integer customerId = user.getCustomerId();

		try {
			HgCustomer hgCustomer = hgCustomerDao.getById(customerId);

			// ���ݿ��е�ҵ��״̬
			Integer customerStatOld = hgCustomer.getCustomerStat();

			// ֻ�е�customerStatOld��Ϊ�� ���� Ϊ����������ͣʱ���ܽ��в���
			if (customerStatOld != null
					&& (customerStatOld.equals(HgCustomer.ORDERED) || customerStatOld
							.equals(HgCustomer.PAUSE_ORDERED))) {
				hgCustomer.setCustomerStat(customerStat);
				// ����״̬����ʱ��
				hgCustomer.setUpdateTime(new Date());

				// ����
				hgCustomerDao.update(hgCustomer);

				// ���ý��
				result.setSuccess(true);
			}

		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to modify business for user: "
							+ user.getLoginName(), e);
			throw new SignatureServiceException(
					"Unable to modify business for user: "
							+ user.getLoginName(), e);
		}

		return result;
	}

	public Result getCustomer(User user) throws SignatureServiceException {
		Result result = Result.createRestult();

		Integer customerId = user.getCustomerId();

		try {
			HgCustomer hgCustomer = hgCustomerDao.getById(customerId);

			result.setSuccess(true);
			result.getModel().put("hgCustomer", hgCustomer);
		} catch (SignaturePersistException e) {
			logger.error(
					"Unable to get customer for user: " + user.getLoginName(),
					e);
			throw new SignatureServiceException(
					"Unable to get customer for user: " + user.getLoginName(),
					e);
		}

		return result;
	}

	public Result loginForManager(String loginName, String password)
			throws SignatureServiceException {
		// �������ؽ��
		Result result = Result.createRestult();

		try {
			// ����loginNameȡ�ø��û�
			StUsers stUsers = stUsersDao.getByLoginNameForType(loginName, StUsers.MANAGER);

			// �жϸ��û��Ƿ����,���������Ƿ�Ϊ��
			if (stUsers == null || stUsers.getPassword() == null
					|| stUsers.getPassword().length() == 0) {
				result.setRemark(LOGINPASSWORDFAIL);
			} else {
				String password2 = stUsers.getPassword();

				// �ж������Ƿ�һ��
				if (encrypt.check(password, password2)) {
					result.setSuccess(true);
					result.setRemark(LOGINSUCCESS);

					// ȡ��HgCustomer����
					Integer userId = stUsers.getId();
					HgCustomer hgCustomer = hgCustomerDao.getByUserId(userId);
					Integer customerId = hgCustomer.getId();
					Integer specialNumberType = hgCustomer
							.getSpecialNumberType();
					Integer customerStat = hgCustomer.getCustomerStat();

					// ��������¼ʱ��
					Date lastLoginTime = stUsers.getLastLoginTime();
					Date currentTime = new Date();
					stUsers.setLastLoginTime(currentTime);

					// ���õ�¼����
					Integer loginCount = stUsers.getLoginCount();
					if (loginCount == null) {
						loginCount = 0;
					}
					Integer count = ++loginCount;
					stUsers.setLoginCount(count);

					// ����û��ǳ�Ϊ�գ����ʼ��ΪloginName
					String userNick = stUsers.getName();

					// �������ݿ��е�StUsers����
					stUsersDao.update(stUsers);

					// ��װ���ڱ��浽Session�е�User����
					User user = new User();
					user.setCustomerId(customerId);
					user.setLoginName(loginName);
					user.setUserId(userId);
					user.setLastLoginTime(lastLoginTime);
					user.setLoginCount(loginCount);
					user.setSpecialNumberType(specialNumberType);
					user.setUserNick(userNick);
					user.setCustomerStat(customerStat);
					user.setUserType(stUsers.getUserType());

					result.getModel().put("user", user);

				} else {
					result.setRemark(LOGINPASSWORDFAIL);
				}
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to login by password for user:" + loginName, e);
			throw new SignatureServiceException(
					"Unable to login by password for user: " + loginName, e);
		}

		// ���ؽ��
		return result;
	}

	public StUsersDao getStUsersDao() {
		return stUsersDao;
	}

	public void setStUsersDao(StUsersDao stUsersDao) {
		this.stUsersDao = stUsersDao;
	}

	public Encrypt getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(Encrypt encrypt) {
		this.encrypt = encrypt;
	}

	public HgCustomerDao getHgCustomerDao() {
		return hgCustomerDao;
	}

	public void setHgCustomerDao(HgCustomerDao hgCustomerDao) {
		this.hgCustomerDao = hgCustomerDao;
	}

	public Integer getInvalideMinute() {
		return invalideMinute;
	}

	public void setInvalideMinute(Integer invalideMinute) {
		this.invalideMinute = invalideMinute;
	}

	public String getFrontMessage() {
		return frontMessage;
	}

	public void setFrontMessage(String frontMessage) {
		this.frontMessage = frontMessage;
	}

	public String getRearMessage() {
		return rearMessage;
	}

	public void setRearMessage(String rearMessage) {
		this.rearMessage = rearMessage;
	}

	/** ��¼�ɹ���Ϣ */
	public static final String LOGINSUCCESS = "��¼�ɹ�!";

	/** �����¼ʧ����Ϣ */
	public static final String LOGINPASSWORDFAIL = "�û��������벻��!";

	/** ������֤����� */
	public static final String LOGINCODEOUT = "������������!";

	/** ������֤���¼ʧ����Ϣ */
	public static final String LOGINCODEFAIL = "�û�������Ų���!";

	/** �û���������Ϣ */
	public static final String USERUNEXIST = "�û�������!";

	/** ��������뱣��ɹ� */
	public static final String SAVECODESUCCESS = "��������뱣��ɹ�!";

	/** ��δ�������������ʾ */
	public static final String UNSETCODE = "����δ���ö��������";

	/** ��������Ѿ�������ʾ */
	public static final String HAVESENDCODE = "��������Ѿ����ͣ�����3���Ӻ����µ����ȡ";

	/** ������ŷ��ͳɹ���ʾ */
	public static final String SENDCODESUCCESS = "����������Ѿ����ͳɹ�����ע�����!�����������Чʱ��Ϊ3����";

}
