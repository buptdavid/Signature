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
import com.juicy.signature.persist.po.HgDiyInfo;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * HgDiyInfoDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-27 创建
 *          </p>
 */
public class HgDiyInfoDaoTest {
	HgDiyInfoDao target;

	ApplicationContext ctx;

	Integer customerIdSave;

	public HgDiyInfoDaoTest() {
		ctx = BaseDaoTest.getInstance();
	}

	@Before
	public void prepare() throws SignaturePersistException {
		target = (HgDiyInfoDao) ctx.getBean("hgDiyInfoDao");

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
		HgDiyInfo hgDiyInfo = this.save();
		Integer id = hgDiyInfo.getId();
		Integer customerId = hgDiyInfo.getCustomerId();

		HgDiyInfo hgDiyInfo2 = target.getById(id);
		Integer customerId2 = hgDiyInfo2.getCustomerId();

		Assert.assertEquals(customerId, customerId2);
	}

	@Test
	public void testSave() throws SignaturePersistException {
		HgDiyInfo hgDiyInfo = this.save();
		Integer id = hgDiyInfo.getId();

		HgDiyInfo hgDiyInfo2 = target.getById(id);
		Integer id2 = hgDiyInfo2.getId();

		Assert.assertEquals(id, id2);

	}

	@Test
	public void testUpdate() throws SignaturePersistException {
		HgDiyInfo hgDiyInfo = this.save();
		Integer id = hgDiyInfo.getId();

		Integer customerId = customerIdSave;
		hgDiyInfo.setCustomerId(customerId);

		target.update(hgDiyInfo);

		HgDiyInfo hgDiyInfo2 = target.getById(id);
		Integer customerId2 = hgDiyInfo2.getCustomerId();

		Assert.assertEquals(customerId, customerId2);
	}

	@Test
	public void testDeleteParaHgDiyInfo() throws SignaturePersistException {
		HgDiyInfo hgDiyInfo = this.save();
		Integer id = hgDiyInfo.getId();

		target.delete(hgDiyInfo);

		HgDiyInfo hgDiyInfo2 = target.getById(id);

		Assert.assertEquals(null, hgDiyInfo2);
	}

	@Test
	public void testDeleteParaId() throws SignaturePersistException {
		HgDiyInfo hgDiyInfo = this.save();
		Integer id = hgDiyInfo.getId();

		target.delete(id);

		HgDiyInfo hgDiyInfo2 = target.getById(id);

		Assert.assertEquals(null, hgDiyInfo2);
	}

	@Test
	public void testFindAll() throws SignaturePersistException {
		HgDiyInfo hgDiyInfo = this.save();
		Integer id = hgDiyInfo.getId();

		List<HgDiyInfo> list = target.findAll();
		Iterator<HgDiyInfo> it = list.iterator();

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
		HgDiyInfo hgDiyInfo = this.save();
		Integer id = hgDiyInfo.getId();
		Integer customerId = hgDiyInfo.getCustomerId();

		List<HgDiyInfo> list = target.findByCustomerId(customerId);
		Iterator<HgDiyInfo> it = list.iterator();

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

		Integer customerId = customerIdSave;

		for (int i = 0; i < N; i++) {
			HgDiyInfo hgDiyInfo = new HgDiyInfo();
			hgDiyInfo.setMessageTypeId(HgDiyInfo.FLASH);
			hgDiyInfo.setCustomerId(customerId);

			// 是否使用标志
			hgDiyInfo.setDiyInfoCurType(HgDiyInfo.UNUSED);

			target.save(hgDiyInfo);
		}

		Integer N2 = target.findCountByCustomerId(customerId);

		Assert.assertEquals(N, N2);

	}

	@Test
	public void testFindByCustomerIdForPage() throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;

		Integer customerId = customerIdSave;

		for (int i = 0; i < N; i++) {
			HgDiyInfo hgDiyInfo = new HgDiyInfo();
			hgDiyInfo.setMessageTypeId(HgDiyInfo.FLASH);
			hgDiyInfo.setCustomerId(customerId);
			hgDiyInfo.setDiyInfoContent(String.valueOf(i));

			// 是否使用标志
			hgDiyInfo.setDiyInfoCurType(HgDiyInfo.UNUSED);

			target.save(hgDiyInfo);
		}
		
		Integer offSet = 2;
		Integer pageSize = 10;
		
		List<HgDiyInfo> list = target.findByCustomerIdForPage(customerId, offSet, pageSize);
		Integer pageSize2 = list.size();
		
		Assert.assertEquals(pageSize, pageSize2);
		
		Integer offSet2 = Integer.valueOf(list.get(0).getDiyInfoContent());

		Assert.assertEquals(offSet, offSet2);
		
	}

	/**
	 * 保存一条记录
	 * 
	 * @return
	 * @throws SignaturePersistException 
	 */
	public HgDiyInfo save() throws SignaturePersistException {
		HgDiyInfo hgDiyInfo = new HgDiyInfo();
		hgDiyInfo.setMessageTypeId(HgDiyInfo.FLASH);

		Integer customerId = customerIdSave;
		hgDiyInfo.setCustomerId(customerId);

		// 是否使用标志
		hgDiyInfo.setDiyInfoCurType(HgDiyInfo.UNUSED);

		Integer id = target.save(hgDiyInfo);

		HgDiyInfo hgDiyInfo2 = target.getById(id);

		return hgDiyInfo2;
	}

}
