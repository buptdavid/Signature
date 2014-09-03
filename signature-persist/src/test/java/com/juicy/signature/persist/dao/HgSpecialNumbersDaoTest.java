/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.HgSpecialNumbers;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * HgSpecialNumbersDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public class HgSpecialNumbersDaoTest {
	HgSpecialNumbersDao target;

	ApplicationContext ctx;

	Integer customerIdSave;

	public HgSpecialNumbersDaoTest() {
		ctx = BaseDaoTest.getInstance();
	}

	@Before
	public void prepare() throws SignaturePersistException {
		target = (HgSpecialNumbersDao) ctx.getBean("hgSpecialNumbersDao");

		// 保存一个HgCustomer对象
		HgCustomerDao hgCustomerDao = (HgCustomerDao) ctx
				.getBean("hgCustomerDao");

		// 随机的手机号码
		String customerName = RandomUtil.getRandomMobile();

		HgCustomer hgCustomer = new HgCustomer();
		hgCustomer.setCustomerManagerId(HgCustomer.UNUSEDID);
		hgCustomer.setComboId(HgCustomer.UNUSEDID);
		hgCustomer.setUserId(HgCustomer.UNUSEDID);
		hgCustomer.setRegionId(1);
		hgCustomer.setCustomerName(customerName);
		hgCustomer.setCustomerType(1);

		hgCustomerDao.save(hgCustomer);
		customerIdSave = hgCustomer.getId();
	}

	@Test
	public void testGetById() throws SignaturePersistException {
		HgSpecialNumbers hgSpecialNumbers = this
				.save(HgSpecialNumbers.BLACKLIST);
		Integer id = hgSpecialNumbers.getId();
		String number = hgSpecialNumbers.getSpecialNumber();

		HgSpecialNumbers hgSpecialNumbers2 = target.getById(id);
		String number2 = hgSpecialNumbers2.getSpecialNumber();

		Assert.assertEquals(number, number2);
	}

	@Test
	public void testSave() throws SignaturePersistException {
		HgSpecialNumbers hgSpecialNumbers = this
				.save(HgSpecialNumbers.WHITELIST);
		Integer id = hgSpecialNumbers.getId();
		String number = hgSpecialNumbers.getSpecialNumber();

		HgSpecialNumbers hgSpecialNumbers2 = target.getById(id);
		String number2 = hgSpecialNumbers2.getSpecialNumber();

		Assert.assertEquals(number, number2);
	}

	@Test
	public void testUpdate() throws SignaturePersistException {
		HgSpecialNumbers hgSpecialNumbers = this
				.save(HgSpecialNumbers.REFUSELIST);
		Integer id = hgSpecialNumbers.getId();

		String number = RandomUtil.getRandomMobile();
		hgSpecialNumbers.setSpecialNumber(number);

		target.update(hgSpecialNumbers);

		HgSpecialNumbers hgSpecialNumbers2 = target.getById(id);
		String number2 = hgSpecialNumbers2.getSpecialNumber();

		Assert.assertEquals(number, number2);
	}

	@Test
	public void deleteParaHgSpecialNumbers() throws SignaturePersistException {
		HgSpecialNumbers hgSpecialNumbers = this
				.save(HgSpecialNumbers.BLACKLIST);
		Integer id = hgSpecialNumbers.getId();

		target.delete(hgSpecialNumbers);

		HgSpecialNumbers hgSpecialNumbers2 = target.getById(id);

		Assert.assertEquals(null, hgSpecialNumbers2);
	}

	@Test
	public void deleteParaId() throws SignaturePersistException {
		HgSpecialNumbers hgSpecialNumbers = this
				.save(HgSpecialNumbers.BLACKLIST);
		Integer id = hgSpecialNumbers.getId();

		target.delete(id);

		HgSpecialNumbers hgSpecialNumbers2 = target.getById(id);

		Assert.assertEquals(null, hgSpecialNumbers2);
	}

	@Test
	public void testFindAll() throws SignaturePersistException {
		HgSpecialNumbers hgSpecialNumbers = this
				.save(HgSpecialNumbers.WHITELIST);
		Integer id = hgSpecialNumbers.getId();

		List<HgSpecialNumbers> list = target.findAll();
		Iterator<HgSpecialNumbers> it = list.iterator();

		boolean isNext = false;
		while (it.hasNext()) {
			if (id.equals(it.next().getId())) {
				isNext = true;
			}
		}

		Assert.assertEquals(true, isNext);
	}

	@Test
	public void testFindByCustomerId() throws SignaturePersistException {
		Integer numberType = HgSpecialNumbers.BLACKLIST;
		HgSpecialNumbers hgSpecialNumbers = this.save(numberType);
		Integer id = hgSpecialNumbers.getId();
		Integer customerId = hgSpecialNumbers.getCustomerId();

		List<HgSpecialNumbers> list = target.findByCustomerId(customerId,
				numberType);
		Iterator<HgSpecialNumbers> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			if (id.equals(it.next().getId())) {
				isHas = true;
			}
		}

		Assert.assertEquals(true, isHas);
	}

	@Test
	public void testFindByNumber() throws SignaturePersistException {
		Integer numberType = HgSpecialNumbers.BLACKLIST;
		HgSpecialNumbers hgSpecialNumbers = this.save(numberType);

		Integer id = hgSpecialNumbers.getId();
		String number = hgSpecialNumbers.getSpecialNumber();

		List<HgSpecialNumbers> list = target.findByNumber(number, numberType);
		Iterator<HgSpecialNumbers> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			if (id.equals(it.next().getId())) {
				isHas = true;
			}
		}

		Assert.assertEquals(true, isHas);
	}

	@Test
	public void testFindCountByCustomerId() throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;
		Integer numberType = HgSpecialNumbers.BLACKLIST;
		Integer customerId = customerIdSave;

		for (int i = 0; i < N; i++) {
			this.save(numberType);
		}

		Integer N2 = target.findCountByCustomerId(customerId, numberType);
		Assert.assertEquals(N, N2);

	}

	@Test
	public void testFindByCustomerIdForPage() throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;
		Integer numberType = HgSpecialNumbers.BLACKLIST;
		Integer customerId = customerIdSave;

		for (int i = 0; i < N; i++) {
			String specialNumber = RandomUtil.getRandomMobile();

			HgSpecialNumbers hgSpecialNumbers = new HgSpecialNumbers();
			hgSpecialNumbers.setCustomerId(customerId);
			hgSpecialNumbers.setSpecialNumber(specialNumber);
			hgSpecialNumbers.setSpecialNumberType(numberType);
			hgSpecialNumbers.setSpecialNumberCeratedate(new Date());
			hgSpecialNumbers.setRemark(String.valueOf(i));

			target.save(hgSpecialNumbers);
		}

		Integer offSet = 2;
		Integer pageSize = 10;

		List<HgSpecialNumbers> list = target.findByCustomerIdForPage(
				customerId, numberType, offSet, pageSize);
		
		Integer pageSize2 = list.size();
		Assert.assertEquals(pageSize, pageSize2);
		
		Integer offSet2 = Integer.valueOf(list.get(0).getRemark());
		Assert.assertEquals(offSet, offSet2);

	}

	/**
	 * 保存一条记录
	 * 
	 * @param numberType
	 *            特殊号码类型
	 * @return 保存的HgSpecialNumbers实例
	 * @throws SignaturePersistException
	 */
	public HgSpecialNumbers save(Integer numberType)
			throws SignaturePersistException {
		Integer customerId = customerIdSave;
		String specialNumber = RandomUtil.getRandomMobile();
		String remark = "讨厌的号码";

		HgSpecialNumbers hgSpecialNumbers = new HgSpecialNumbers();
		hgSpecialNumbers.setCustomerId(customerId);
		hgSpecialNumbers.setSpecialNumber(specialNumber);
		hgSpecialNumbers.setSpecialNumberType(numberType);
		hgSpecialNumbers.setSpecialNumberCeratedate(new Date());
		hgSpecialNumbers.setRemark(remark);

		Integer id = target.save(hgSpecialNumbers);

		return target.getById(id);

	}

}
