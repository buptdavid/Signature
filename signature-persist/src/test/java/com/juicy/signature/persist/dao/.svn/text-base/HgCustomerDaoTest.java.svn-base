/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */
package com.juicy.signature.persist.dao;

import java.util.Date;
import java.util.Iterator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * HgCustomerDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-25 创建
 *          </p>
 */
public class HgCustomerDaoTest {
	HgCustomerDao target;

	Integer unUsedId = -1;

	@Before
	public void prepare() {
		ApplicationContext ctx = BaseDaoTest.getInstance();
		target = (HgCustomerDao) ctx.getBean("hgCustomerDao");
	}

	 @Test
	public void testGetById() throws SignaturePersistException {
		// 首先保存一个记录
		HgCustomer m = this.save();
		Integer id = m.getId();
		String customerName = m.getCustomerName();

		HgCustomer hgCustomer2 = target.getById(id);

		String customerName2 = hgCustomer2.getCustomerName();

		// 验证
		Assert.assertEquals(customerName, customerName2);
	}

	@Test
	public void testSave() throws SignaturePersistException {
		// 随机的手机号码
		String customerName = RandomUtil.getRandomMobile();

		HgCustomer hgCustomer = new HgCustomer();

		hgCustomer.setCustomerManagerId(HgCustomer.UNUSEDID);
		hgCustomer.setUserId(51);
		hgCustomer.setComboId(HgCustomer.UNUSEDID);
		hgCustomer.setRegionId(1);
		hgCustomer.setCustomerName(customerName);
		hgCustomer.setCustomerType(1);

		Integer id = target.save(hgCustomer);

		HgCustomer hgCustomer2 = target.getById(id);

		String customerName2 = hgCustomer2.getCustomerName();

		// 验证
		Assert.assertEquals(customerName, customerName2);
	}

	@Test
	public void testUpdate() throws SignaturePersistException {
		// 首先保存一个记录
		HgCustomer m = this.save();
		Integer id = m.getId();

		HgCustomer hgCustomer = target.getById(id);

		// 获得一个随机手机号码
		String customerName = RandomUtil.getRandomMobile();

		hgCustomer.setCustomerName(customerName);

		// 更新
		target.update(hgCustomer);

		HgCustomer hgCustomer2 = target.getById(id);
		String customerName2 = hgCustomer2.getCustomerName();

		Assert.assertEquals(customerName, customerName2);
	}

	@Test
	public void testDeleteParaHgCustomer() throws SignaturePersistException {
		// 首先保存一个记录
		HgCustomer m = this.save();
		Integer id = m.getId();

		HgCustomer hgCustomer = target.getById(id);

		// 删除
		target.delete(hgCustomer);

		HgCustomer hgCustomer2 = target.getById(id);

		Assert.assertEquals(null, hgCustomer2);
	}

	@Test
	public void testDeleteParaId() throws SignaturePersistException {
		// 首先保存一个记录
		HgCustomer m = this.save();
		Integer id = m.getId();

		target.delete(id);

		HgCustomer hgCustomer2 = target.getById(id);

		Assert.assertEquals(null, hgCustomer2);
	}

	@Test
	public void testFindAll() throws SignaturePersistException {
		// 首先保存一个记录
		this.save();

		Iterator it = target.findAll().iterator();

		boolean isNext = it.hasNext();

		Assert.assertEquals(true, isNext);
	}

	@Test
	public void testGetByUserId() throws SignaturePersistException {
		// 首先保存一个记录
		HgCustomer m = this.save();
		
		String customerName = m.getCustomerName();
		Integer userId = m.getUserId();
		
		HgCustomer hgCustomer = target.getByUserId(userId);
		String customerName2 = hgCustomer.getCustomerName();
		
		Assert.assertEquals(customerName, customerName2);
	}

	@Test
	public void testfindCountByStat() throws SignaturePersistException{
		Integer count = target.findCountByStat(null, null, null, null);
		Assert.assertEquals(new Integer(1095), count);
	}

	/**
	 * 保存一条记录
	 * 
	 * @return HashMap,保存的ID和cutomerName
	 * @throws SignaturePersistException 
	 */
	public HgCustomer save() throws SignaturePersistException {
		// 随机的手机号码
		String customerName = RandomUtil.getRandomMobile();

		HgCustomer hgCustomer = new HgCustomer();

		hgCustomer.setCustomerManagerId(HgCustomer.UNUSEDID);
		hgCustomer.setComboId(HgCustomer.UNUSEDID);
		hgCustomer.setUserId(HgCustomer.UNUSEDID);
		hgCustomer.setRegionId(1);
		hgCustomer.setCustomerName(customerName);
		hgCustomer.setCustomerType(1);

		Integer id = target.save(hgCustomer);
		
		HgCustomer hgCustomer2 = target.getById(id);
		
		return hgCustomer2;
		
	}
}
