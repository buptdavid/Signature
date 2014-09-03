/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.StUsers;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * StUserDao测试类
 * 
 * @author 路卫杰
 * @version 2011.07.21 创建
 * 
 */
public class StUsersDaoTest {
	StUsersDao target;

	@Before
	public void prepare() {
		ApplicationContext ctx = BaseDaoTest.getInstance();
		target = (StUsersDao) ctx.getBean("stUsersDao");
	}

	 @Test
	public void testSave() throws SignaturePersistException {
		String loginName = RandomUtil.getRandomMobile();

		// 初始化用户对象
		StUsers stUsers = new StUsers();
		stUsers.setLoginName(loginName);
		stUsers.setPassword("123456");
		stUsers.setIfIniUser(false);
		stUsers.setUserPeriodOfValidity(11);
		stUsers.setUserType(0);

		// 保存返回主键ID
		Integer id = target.save(stUsers);

		// 根据主键ID查询
		StUsers user = target.getById(id);
		String loginName2 = user.getLoginName();

		// 判断插入的loginName是否正确
		Assert.assertEquals(loginName, loginName2);

	}

	 @Test
	public void testGetById() throws SignaturePersistException {
		// 首先保存一个记录

		// 获得一个随机的手机号码
		String loginName = RandomUtil.getRandomMobile();

		// 初始化用户对象
		StUsers stUsers = new StUsers();
		stUsers.setLoginName(loginName);
		stUsers.setPassword("123456");
		stUsers.setIfIniUser(false);
		stUsers.setUserPeriodOfValidity(11);
		stUsers.setUserType(0);

		// 保存并返回主键ID
		Integer id = target.save(stUsers);

		StUsers stUsers2 = target.getById(id);
		String loginName2 = stUsers2.getLoginName();

		// 验证登录名是否正确
		Assert.assertEquals(loginName, loginName2);
	}

	 @Test
	public void testUpdate() throws SignaturePersistException {
		String loginName = RandomUtil.getRandomMobile();

		// 初始化用户对象
		StUsers stUsers = new StUsers();
		stUsers.setLoginName(loginName);
		stUsers.setPassword("123456");
		stUsers.setIfIniUser(false);
		stUsers.setUserPeriodOfValidity(11);
		stUsers.setUserType(0);

		// 保存返回主键ID
		Integer id = target.save(stUsers);

		StUsers user = target.getById(id);

		String password = user.getPassword();

		// 密码翻转
		StringBuffer sb = new StringBuffer(password);
		password = sb.reverse().toString();
		user.setPassword(password);

		// 更新
		target.update(user);

		StUsers user2 = target.getById(id);
		String password2 = user2.getPassword();

		// 验证是否保存成功
		Assert.assertEquals(password, password2);

	}

	 @Test
	public void testDeleteParaStUsers() throws SignaturePersistException {
		// 首先保存一个记录
		String loginName = RandomUtil.getRandomMobile();
		// 初始化用户对象
		StUsers stUsers = new StUsers();
		stUsers.setLoginName(loginName);
		stUsers.setPassword("123456");
		stUsers.setIfIniUser(false);
		stUsers.setUserPeriodOfValidity(11);
		stUsers.setUserType(0);

		// 保存返回主键ID
		Integer id = target.save(stUsers);

		// 获得保存的这个记录的持久化对象
		StUsers stUsers2 = target.getById(id);

		// 根据持久化对象删除这个记录
		target.delete(stUsers2);

		StUsers user = target.getById(id);

		// 测试是否被删除
		Assert.assertEquals(null, user);
	}

	 @Test
	public void testDeleteParaId() throws SignaturePersistException {
		// 首先保存一个记录
		String loginName = RandomUtil.getRandomMobile();
		// 初始化用户对象
		StUsers stUsers = new StUsers();
		stUsers.setLoginName(loginName);
		stUsers.setPassword("123456");
		stUsers.setIfIniUser(false);
		stUsers.setUserPeriodOfValidity(11);
		stUsers.setUserType(0);

		// 保存返回主键ID
		Integer id = target.save(stUsers);

		// 根据id删除此记录
		target.delete(id);

		StUsers user = target.getById(id);

		// 测试是否被删除
		Assert.assertEquals(null, user);
	}

	 @Test
	public void testFindAll() throws SignaturePersistException {
		List<StUsers> list = target.findAll();
		boolean isNext = list.iterator().hasNext();

		// 验证
		Assert.assertTrue(isNext);
	}

	 @Test
	public void testGetByLoginName() throws SignaturePersistException {
		Map map = this.save();
		
		String loginName = (String)map.get("loginName");
		
		StUsers stUsers = target.getByLoginName(loginName);
		String loginName2 = stUsers.getLoginName();
		Assert.assertEquals(loginName, loginName2);
	}

	/**
	 * 保存一条记录
	 * 
	 * @return map值
	 * @throws SignaturePersistException 
	 */
	public Map save() throws SignaturePersistException {
		// 随机手机号码
		String loginName = RandomUtil.getRandomMobile();
		// 初始化用户对象
		StUsers stUsers = new StUsers();
		stUsers.setLoginName(loginName);
		stUsers.setPassword("123456");
		stUsers.setIfIniUser(false);
		stUsers.setUserPeriodOfValidity(11);
		stUsers.setUserType(0);

		// 保存返回主键ID
		Integer id = target.save(stUsers);
		
		Map map = new HashMap();
		map.put("id", id);
		map.put("loginName", loginName);
		return map;
	}
}
