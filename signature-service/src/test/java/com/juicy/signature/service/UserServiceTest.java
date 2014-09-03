/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.juicy.signature.persist.dao.HgCustomerDao;
import com.juicy.signature.persist.dao.StUsersDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.HgSpecialNumbers;
import com.juicy.signature.persist.po.StUsers;
import com.juicy.signature.service.encryption.impl.Md5Encrypt;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * UserService测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-1 创建
 *          </p>
 */
public class UserServiceTest extends BaseServiceTest {

	UserService target;

	String loginName = RandomUtil.getRandomMobile();;
	String password = "123456";
	Integer customerId;

	@Before
	public void prepare() throws SignaturePersistException {
		target = (UserService) super.getCtx().getBean("userService");

		// 保存一个StUsers
		StUsersDao stUsersDao = (StUsersDao) super.getCtx().getBean(
				"stUsersDao");

		// 随机手机号码
		// 初始化用户对象
		StUsers stUsers = new StUsers();
		stUsers.setLoginName(loginName);
		stUsers.setPassword(new Md5Encrypt().encode(password));
		stUsers.setIfIniUser(false);
		stUsers.setUserPeriodOfValidity(11);
		stUsers.setUserType(0);

		Integer userId = stUsersDao.save(stUsers);

		// 更新ID为120的HgCustomer，（不能增加，因为HG_CUSTOMER表中有触发器）
		HgCustomerDao hgCustomerDao = (HgCustomerDao) super.getCtx().getBean(
				"hgCustomerDao");
		customerId = 120;
		HgCustomer hgCustomer = hgCustomerDao.getById(customerId);

		hgCustomer.setUserId(userId);
		hgCustomer.setCustomerName(loginName);

		hgCustomerDao.update(hgCustomer);
	}

	@Test
	public void testLoginByPassword() throws Exception {
		String loginName2 ="13134741148";
		String password2 = "123456";
		Result result = target.loginByPassword(loginName2, password2);
		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);
	}

	@Test
	public void testLoginByVerfityCode() throws Exception {
		Result result = target.createVerfityCode(loginName);
		String verfityCode = (String) result.getModel().get("verfityCode");

		Result result2 = target.loginByVerfityCode(loginName, verfityCode);

		boolean isSuccess = result2.isSuccess();

		Assert.assertEquals(true, isSuccess);

	}

	@Test
	public void testModifyInformation() throws Exception {
		StUsers user = new StUsers();
		user.setLoginName(loginName);

		String name = "buptdavid";
		user.setName(name);

		Result result = target.modifyInformation(user);

		StUsers stUsers = (StUsers) result.getModel().get("user");

		String name2 = stUsers.getName();

		Assert.assertEquals(name, name2);
	}

	@Test
	public void testModifyPassword() throws Exception {
		String newPassword = "654321";

		Result result = target.modifyPassword(loginName, newPassword);
		boolean isSuccess = result.isSuccess();

		Assert.assertEquals(true, isSuccess);

		//改回来
		target.modifyPassword(loginName, password);

	}

	@Test
	public void testModifyList() throws SignatureServiceException {
		User user = new User();
		user.setCustomerId(customerId);
		Integer specialNumberType = HgSpecialNumbers.WHITELIST;

		Result result = target.modifyList(user, specialNumberType);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		User user2 = (User) result.getModel().get("user");
		Integer specialNumberType2 = user2.getSpecialNumberType();

		Assert.assertEquals(specialNumberType, specialNumberType2);
	}

}
