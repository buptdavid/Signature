/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgManager;

/**
 * HgManagerDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-22 创建
 *          </p>
 */
public class HgManagerDaoTest {
	HgManagerDao target;

	@Before
	public void prepare() {
		ApplicationContext ctx = BaseDaoTest.getInstance();
		target = (HgManagerDao) ctx.getBean("hgManagerDao");
	}

	@Test
	public void testGetById() throws SignaturePersistException {
		Integer id = 1;
		HgManager hgManager = target.getById(id);
		String managerName = hgManager.getManagerName();

		Assert.assertEquals("admin", managerName);

	}

	@Test
	public void testSave() throws SignaturePersistException {
		String managerName = "david";

		HgManager hgManager = new HgManager();
		hgManager.setManagerType(HgManager.MANAGER);
		hgManager.setManagerEmail("luwj@zctt.com");
		hgManager.setManagerMobilenumber("13426082242");
		hgManager.setManagerName(managerName);
		hgManager.setRegionId(1);
		hgManager.setUserId(1);

		Integer id = target.save(hgManager);

		HgManager hgManager2 = target.getById(id);
		String managerName2 = hgManager2.getManagerName();

		Assert.assertEquals(managerName, managerName2);
	}

	@Test
	public void testUpdate() throws SignaturePersistException {
		// 首先保存一个记录
		String managerName = "david";

		HgManager hgManager = new HgManager();
		hgManager.setManagerType(HgManager.MANAGER);
		hgManager.setManagerEmail("luwj@zctt.com");
		hgManager.setManagerMobilenumber("13426082242");
		hgManager.setManagerName(managerName);
		hgManager.setRegionId(1);
		hgManager.setUserId(2);

		Integer id = target.save(hgManager);

		// 获取本记录
		HgManager hgManager2 = target.getById(id);

		// managerName翻转
		managerName = hgManager2.getManagerName();
		StringBuffer sb = new StringBuffer(managerName);
		managerName = sb.reverse().toString();

		hgManager2.setManagerName(managerName);

		// 更新
		target.update(hgManager2);

		// 再次获取
		HgManager hgManager3 = target.getById(id);
		String managerName2 = hgManager3.getManagerName();

		// 验证
		Assert.assertEquals(managerName, managerName2);
	}

	@Test
	public void testDeleteParaHgManager() throws SignaturePersistException {
		// 首先保存一个记录
		String managerName = "david";

		HgManager hgManager = new HgManager();
		hgManager.setManagerType(HgManager.MANAGER);
		hgManager.setManagerEmail("luwj@zctt.com");
		hgManager.setManagerMobilenumber("13426082242");
		hgManager.setManagerName(managerName);
		hgManager.setRegionId(1);
		hgManager.setUserId(2);

		Integer id = target.save(hgManager);

		// 再次获取
		HgManager hgManager2 = target.getById(id);

		// 删除
		target.delete(hgManager2);

		// 再次获取
		HgManager hgManager3 = target.getById(id);

		// 验证
		Assert.assertEquals(null, hgManager3);
	}

	@Test
	public void testDeleteParaId() throws SignaturePersistException {
		// 首先保存一个记录
		String managerName = "david";

		HgManager hgManager = new HgManager();
		hgManager.setManagerType(HgManager.MANAGER);
		hgManager.setManagerEmail("luwj@zctt.com");
		hgManager.setManagerMobilenumber("13426082242");
		hgManager.setManagerName(managerName);
		hgManager.setRegionId(1);
		hgManager.setUserId(2);

		Integer id = target.save(hgManager);

		// 再次获取
		HgManager hgManager2 = target.getById(id);

		// 删除
		target.delete(id);

		// 再次获取
		HgManager hgManager3 = target.getById(id);

		// 验证
		Assert.assertEquals(null, hgManager3);
	}

}
