/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
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
 * UserService接口实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public class UserServiceImpl implements UserService {

	/** 短信验证码失效时间(分钟) */
	private Integer invalideMinute = 1;

	String frontMessage;

	String rearMessage;

	/** 加密算法对象 */
	private Encrypt encrypt;

	/** StUsersDao对象 */
	private StUsersDao stUsersDao;

	/** HgCustomerDao对象 */
	HgCustomerDao hgCustomerDao;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);

	public Result loginByPassword(String loginName, String password)
			throws SignatureServiceException {
		// 创建返回结果
		Result result = Result.createRestult();

		try {
			// 根据loginName取得该用户
			StUsers stUsers = stUsersDao.getByLoginName(loginName);

			// 判断该用户是否存在,或者密码是否为空
			if (stUsers == null || stUsers.getPassword() == null
					|| stUsers.getPassword().length() == 0) {
				result.setRemark(LOGINPASSWORDFAIL);
			} else {
				String password2 = stUsers.getPassword();

				// 判断密码是否一致
				if (encrypt.check(password, password2)) {
					result.setSuccess(true);
					result.setRemark(LOGINSUCCESS);

					// 取得HgCustomer对象
					Integer userId = stUsers.getId();
					HgCustomer hgCustomer = hgCustomerDao.getByUserId(userId);
					Integer customerId = hgCustomer.getId();
					Integer specialNumberType = hgCustomer
							.getSpecialNumberType();
					Integer customerStat = hgCustomer.getCustomerStat();

					// 设置最后登录时间
					Date lastLoginTime = stUsers.getLastLoginTime();
					Date currentTime = new Date();
					stUsers.setLastLoginTime(currentTime);

					// 设置登录次数
					Integer loginCount = stUsers.getLoginCount();
					if (loginCount == null) {
						loginCount = 0;
					}
					Integer count = ++loginCount;
					stUsers.setLoginCount(count);

					// 如果用户昵称为空，则初始化为loginName
					String userNick = stUsers.getName();

					// 更新数据库中的StUsers对象
					stUsersDao.update(stUsers);

					// 封装用于保存到Session中的User对象
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

		// 返回结果
		return result;
	}

	public Result loginByVerfityCode(String loginName, String verfityCode)
			throws SignatureServiceException {
		// 创建返回结果
		Result result = Result.createRestult();

		try {
			// 根据loginName取得该用户
			StUsers stUsers = stUsersDao.getByLoginName(loginName);

			// 判断该用户是否存在
			if (stUsers == null) {
				result.setRemark("用户名或密码不对!");
			} else {
				// 取得短信验证码失效时间和当前时间
				Date invalideTime = stUsers.getVerifyInvalideTime();
				Date currentTime = new Date();

				// 如果用户已经设置了短信验证码，则进行验证
				if (invalideTime != null) {
					// 判断短信验证码是否过期
					if (currentTime.after(invalideTime)) {
						result.setRemark(LOGINCODEOUT);
					} else {
						// 判断短信验证码是否正确
						String verfityCode2 = stUsers.getVerifyCode();
						if (encrypt.check(verfityCode, verfityCode2)) {
							result.setSuccess(true);
							result.setRemark(LOGINSUCCESS);

							// 取得HgCustomer对象
							Integer userId = stUsers.getId();
							HgCustomer hgCustomer = hgCustomerDao
									.getByUserId(userId);
							Integer customerId = hgCustomer.getId();
							Integer specialNumberType = hgCustomer
									.getSpecialNumberType();
							Integer customerStat = hgCustomer.getCustomerStat();

							// 设置最后登录时间
							Date lastLoginTime = stUsers.getLastLoginTime();
							stUsers.setLastLoginTime(currentTime);

							// 设置登录次数
							Integer loginCount = stUsers.getLoginCount();
							if (loginCount == null) {
								loginCount = 0;
							}
							Integer count = ++loginCount;
							stUsers.setLoginCount(count);

							// 如果用户昵称为空，则初始化为loginName
							String userNick = stUsers.getName();

							// 更新数据库中的StUsers对象
							stUsersDao.update(stUsers);

							// 封装用于保存到Session中的User对象
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

		// 返回结果
		return result;
	}

	public Result createVerfityCode(String loginName)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 根据loginName取得该用户
			StUsers stUsers = stUsersDao.getByLoginName(loginName);

			// 判断该用户是否存在
			if (stUsers == null) {
				result.setRemark(USERUNEXIST);
			} else {
				// 取得随机短信失效时间和当前时间
				Date invalideTimeSave = stUsers.getVerifyInvalideTime();
				if (invalideTimeSave != null) {
					Date currentTime = new Date();
					// 如果当前时间在随机短信失效时间之前，则返回
					if (currentTime.before(invalideTimeSave)) {
						result.setRemark(HAVESENDCODE);
						// 返回
						return result;
					}
				}

				// 生成短信验证码
				String verfityCode = RandomCode.getRandomCode();

				// 加密
				String verfityCodeEncode = encrypt.encode(verfityCode);

				// 生成验证码失效时间
				Date invalideTime = new Date();
				long currentMs = invalideTime.getTime();
				long invalidMs = currentMs + this.invalideMinute * 60 * 1000;
				invalideTime.setTime(invalidMs);

				// 更新
				stUsers.setVerifyCode(verfityCodeEncode);
				stUsers.setVerifyInvalideTime(invalideTime);
				stUsersDao.update(stUsers);

				// 向用户发送短信随机码,测试尚未通过
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

			// 更新
			stUsersDao.update(stUsers);

			// 返回结果
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
			// 取得该用户信息
			StUsers stUsers = stUsersDao.getByLoginName(loginName);

			if (stUsers == null) {
				result.setRemark(USERUNEXIST);
			} else {
				// 加密得密文
				String ciphertext = encrypt.encode(newPassword);

				// 更新密码
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

			// 更新
			hgCustomerDao.update(hgCustomer);

			// 返回的结果
			result.setSuccess(true);
			// 用户更新Session中的用户基本信息对象
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

			// 数据库中的业务状态
			Integer customerStatOld = hgCustomer.getCustomerStat();

			// 只有当customerStatOld不为空 并且 为订购或者暂停时才能进行操作
			if (customerStatOld != null
					&& (customerStatOld.equals(HgCustomer.ORDERED) || customerStatOld
							.equals(HgCustomer.PAUSE_ORDERED))) {
				hgCustomer.setCustomerStat(customerStat);
				// 订购状态更新时间
				hgCustomer.setUpdateTime(new Date());

				// 更新
				hgCustomerDao.update(hgCustomer);

				// 设置结果
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
		// 创建返回结果
		Result result = Result.createRestult();

		try {
			// 根据loginName取得该用户
			StUsers stUsers = stUsersDao.getByLoginNameForType(loginName, StUsers.MANAGER);

			// 判断该用户是否存在,或者密码是否为空
			if (stUsers == null || stUsers.getPassword() == null
					|| stUsers.getPassword().length() == 0) {
				result.setRemark(LOGINPASSWORDFAIL);
			} else {
				String password2 = stUsers.getPassword();

				// 判断密码是否一致
				if (encrypt.check(password, password2)) {
					result.setSuccess(true);
					result.setRemark(LOGINSUCCESS);

					// 取得HgCustomer对象
					Integer userId = stUsers.getId();
					HgCustomer hgCustomer = hgCustomerDao.getByUserId(userId);
					Integer customerId = hgCustomer.getId();
					Integer specialNumberType = hgCustomer
							.getSpecialNumberType();
					Integer customerStat = hgCustomer.getCustomerStat();

					// 设置最后登录时间
					Date lastLoginTime = stUsers.getLastLoginTime();
					Date currentTime = new Date();
					stUsers.setLastLoginTime(currentTime);

					// 设置登录次数
					Integer loginCount = stUsers.getLoginCount();
					if (loginCount == null) {
						loginCount = 0;
					}
					Integer count = ++loginCount;
					stUsers.setLoginCount(count);

					// 如果用户昵称为空，则初始化为loginName
					String userNick = stUsers.getName();

					// 更新数据库中的StUsers对象
					stUsersDao.update(stUsers);

					// 封装用于保存到Session中的User对象
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

		// 返回结果
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

	/** 登录成功信息 */
	public static final String LOGINSUCCESS = "登录成功!";

	/** 密码登录失败信息 */
	public static final String LOGINPASSWORDFAIL = "用户名或密码不对!";

	/** 短信验证码过期 */
	public static final String LOGINCODEOUT = "短信随机码过期!";

	/** 短信验证码登录失败信息 */
	public static final String LOGINCODEFAIL = "用户名或短信不对!";

	/** 用户不存在信息 */
	public static final String USERUNEXIST = "用户不存在!";

	/** 短信随机码保存成功 */
	public static final String SAVECODESUCCESS = "短信随机码保存成功!";

	/** 尚未设置随机短信提示 */
	public static final String UNSETCODE = "您尚未设置短信随机码";

	/** 随机短信已经发送提示 */
	public static final String HAVESENDCODE = "随机短信已经发送，请在3分钟后重新点击获取";

	/** 随机短信发送成功提示 */
	public static final String SENDCODESUCCESS = "短信随机码已经发送成功，请注意查收!短信随机码有效时间为3分钟";

}
