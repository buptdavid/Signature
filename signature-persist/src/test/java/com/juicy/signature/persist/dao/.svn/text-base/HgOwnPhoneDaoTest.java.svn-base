/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.HgOwnPhone;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * HgOwnPhoneDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public class HgOwnPhoneDaoTest {

	HgOwnPhoneDao target;

	ApplicationContext ctx;

	Integer customerIdSave;

	public HgOwnPhoneDaoTest() {
		ctx = BaseDaoTest.getInstance();
	}

	@Before
	public void prepare() throws SignaturePersistException {
		target = (HgOwnPhoneDao) ctx.getBean("hgOwnPhoneDao");

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
		HgOwnPhone hgOwnPhone = this.save();
		Integer id = hgOwnPhone.getId();
		String phone = hgOwnPhone.getOwnPhone();

		HgOwnPhone hgOwnPhone2 = target.getById(id);
		String phone2 = hgOwnPhone2.getOwnPhone();

		Assert.assertEquals(phone, phone2);
	}

	@Test
	public void testSave() throws SignaturePersistException {
		HgOwnPhone hgOwnPhone = this.save();
		Integer id = hgOwnPhone.getId();
		String phone = hgOwnPhone.getOwnPhone();

		HgOwnPhone hgOwnPhone2 = target.getById(id);
		String phone2 = hgOwnPhone2.getOwnPhone();

		Assert.assertEquals(phone, phone2);
	}

	@Test
	public void testUpdate() throws SignaturePersistException {
		HgOwnPhone hgOwnPhone = this.save();
		Integer id = hgOwnPhone.getId();

		String phone = RandomUtil.getRandomMobile();
		hgOwnPhone.setOwnPhone(phone);

		target.update(hgOwnPhone);

		HgOwnPhone hgOwnPhone2 = target.getById(id);
		String phone2 = hgOwnPhone2.getOwnPhone();

		Assert.assertEquals(phone, phone2);

	}

	@Test
	public void testDeleParaHgOwnPhone() throws SignaturePersistException {
		HgOwnPhone hgOwnPhone = this.save();
		Integer id = hgOwnPhone.getId();

		target.delete(hgOwnPhone);

		HgOwnPhone hgOwnPhone2 = target.getById(id);

		Assert.assertEquals(null, hgOwnPhone2);
	}

	@Test
	public void testDeleParaId() throws SignaturePersistException {
		HgOwnPhone hgOwnPhone = this.save();
		Integer id = hgOwnPhone.getId();

		target.delete(id);

		HgOwnPhone hgOwnPhone2 = target.getById(id);

		Assert.assertEquals(null, hgOwnPhone2);
	}

	@Test
	public void testFindAll() throws SignaturePersistException {
		HgOwnPhone hgOwnPhone = this.save();
		Integer id = hgOwnPhone.getId();

		List<HgOwnPhone> list = target.findAll();
		Iterator<HgOwnPhone> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			if (id.equals(it.next().getId())) {
				isHas = true;
			}
		}

		Assert.assertEquals(true, isHas);
	}

	@Test
	public void testFindByCustomerId() throws SignaturePersistException {
		HgOwnPhone hgOwnPhone = this.save();
		Integer customerId = hgOwnPhone.getCustomerId();
		String phone = hgOwnPhone.getOwnPhone();

		HgOwnPhone hgOwnPhone2 = target.findByCustomerId(customerId);
		String phone2 = hgOwnPhone2.getOwnPhone();

		Assert.assertEquals(phone, phone2);
	}

	@Test
	public void testFindByZone() throws SignaturePersistException {
		HgOwnPhone hgOwnPhone = this.save();
		Integer id = hgOwnPhone.getId();
		String zone = hgOwnPhone.getOwnPhoneZone();

		List<HgOwnPhone> list = target.findByZone(zone);
		Iterator<HgOwnPhone> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			if (id.equals(it.next().getId())) {
				isHas = true;
			}
		}

		Assert.assertEquals(true, isHas);
	}

	@Test
	public void testFindByPhone() throws SignaturePersistException {
		HgOwnPhone hgOwnPhone = this.save();
		String phone = hgOwnPhone.getOwnPhone();
		Integer id = hgOwnPhone.getId();

		HgOwnPhone hgOwnPhone2 = target.findByPhone(phone);
		Integer id2 = hgOwnPhone2.getId();

		Assert.assertEquals(id, id2);

	}

	/**
	 * @throws SignaturePersistException 
	 * 
	 */
	public HgOwnPhone save() throws SignaturePersistException {
		Integer customerId = customerIdSave;

		String phone = RandomUtil.getRandomMobile();
		HgOwnPhone hgOwnPhone = new HgOwnPhone();
		hgOwnPhone.setOwnPhone(phone);
		hgOwnPhone.setCustomerId(customerId);
		hgOwnPhone.setOwnPhoneZone("101");
		hgOwnPhone.setOwnPhoneType(1);

		Integer id = target.save(hgOwnPhone);

		return target.getById(id);
	}

}
