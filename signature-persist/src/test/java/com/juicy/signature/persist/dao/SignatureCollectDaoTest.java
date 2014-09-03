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

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.SignatureCollect;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * SignatureCollectDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-28 创建
 *          </p>
 */
public class SignatureCollectDaoTest {

	SignatureCollectDao target;

	ApplicationContext ctx;

	Integer customerIdSave;

	public SignatureCollectDaoTest() {
		ctx = BaseDaoTest.getInstance();
	}

	@Before
	public void prepare() throws SignaturePersistException {
		target = (SignatureCollectDao) ctx.getBean("signatureCollectDao");

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
		SignatureCollect signatureCollect = this.save();
		Integer id = signatureCollect.getId();
		String content = signatureCollect.getContent();

		SignatureCollect signatureCollect2 = target.getById(id);
		String content2 = signatureCollect2.getContent();

		Assert.assertEquals(content, content2);
	}

	@Test
	public void testSave() throws SignaturePersistException {
		Integer classId = 12;
		String className = "感悟篇";
		String content = RandomUtil.getRandomSignature();

		Integer libraryId = 10;

		Integer customerId = customerIdSave;
		HgCustomer hgCustomer = new HgCustomer();
		hgCustomer.setId(customerId);

		SignatureCollect signatureCollect = new SignatureCollect();
		signatureCollect.setCustomer(hgCustomer);
		signatureCollect.setClassId(classId);
		signatureCollect.setClassName(className);
		signatureCollect.setContent(content);
		signatureCollect.setLibraryId(libraryId);
		signatureCollect.setCollectTime(new Date());

		Integer id = target.save(signatureCollect);

		SignatureCollect signatureCollect2 = target.getById(id);
		String content2 = signatureCollect2.getContent();

		Assert.assertEquals(content, content2);
	}

	@Test
	public void testUpdate() throws SignaturePersistException {
		SignatureCollect signatureCollect = this.save();

		Integer id = signatureCollect.getId();

		String content = RandomUtil.getRandomSignature();
		signatureCollect.setContent(content);

		target.update(signatureCollect);

		SignatureCollect signatureCollect2 = target.getById(id);
		String content2 = signatureCollect2.getContent();

		Assert.assertEquals(content, content2);
	}

	@Test
	public void testDeleteParaSignatureCollect()
			throws SignaturePersistException {
		SignatureCollect signatureCollect = this.save();
		Integer id = signatureCollect.getId();

		target.delete(signatureCollect);

		SignatureCollect signatureCollect2 = target.getById(id);

		Assert.assertEquals(null, signatureCollect2);
	}

	@Test
	public void testDeleteParaId() throws SignaturePersistException {
		SignatureCollect signatureCollect = this.save();
		Integer id = signatureCollect.getId();

		target.delete(id);

		SignatureCollect signatureCollect2 = target.getById(id);

		Assert.assertEquals(null, signatureCollect2);
	}

	@Test
	public void testFindAll() throws SignaturePersistException {
		SignatureCollect signatureCollect = this.save();

		Integer id = signatureCollect.getId();

		List<SignatureCollect> list = target.findAll();
		Iterator<SignatureCollect> it = list.iterator();

		boolean isNext = false;
		while (it.hasNext()) {
			if (id.equals(it.next().getId())) {
				isNext = true;
			}
		}

		Assert.assertEquals(true, isNext);
	}

	@Test
	public void testFindLibraryByCustomerId() throws SignaturePersistException {
		SignatureCollect signatureCollect = this.save();
		Integer customerId = signatureCollect.getCustomer().getId();
		Integer id = signatureCollect.getId();

		List<SignatureCollect> list = target
				.findOriginalByCustomerId(customerId);
		Iterator<SignatureCollect> it = list.iterator();

		boolean isNext = false;
		while (it.hasNext()) {
			if (id.equals(it.next().getId())) {
				isNext = true;
			}
		}

		Assert.assertEquals(true, isNext);
	}

	@Test
	public void testFindLibraryCountByCustomerId()
			throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;

		Integer classId = 12;
		String className = "感悟篇";
		String content = RandomUtil.getRandomSignature();

		Integer libraryId = 10;
		Date collectTime = new Date();

		Integer customerId = customerIdSave;

		for (int i = 0; i < N; i++) {
			HgCustomer hgCustomer = new HgCustomer();
			hgCustomer.setId(customerId);

			SignatureCollect signatureCollect = new SignatureCollect();
			signatureCollect.setCustomer(hgCustomer);
			signatureCollect.setClassId(classId);
			signatureCollect.setClassName(className);
			signatureCollect.setContent(content);
			signatureCollect.setLibraryId(libraryId);
			signatureCollect.setCollectTime(collectTime);

			target.save(signatureCollect);
		}

		Integer N2 = target.findLibraryCountByCustomerId(customerId);
		Assert.assertEquals(N, N2);

	}

	@Test
	public void testFindLibraryByCustomerIdForPage()
			throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;

		Integer classId = 12;
		String className = "感悟篇";

		Integer libraryId = 10;
		Date collectTime = new Date();

		Integer customerId = customerIdSave;

		for (int i = 0; i < N; i++) {
			HgCustomer hgCustomer = new HgCustomer();
			hgCustomer.setId(customerId);

			SignatureCollect signatureCollect = new SignatureCollect();
			signatureCollect.setCustomer(hgCustomer);
			signatureCollect.setClassId(classId);
			signatureCollect.setClassName(className);
			signatureCollect.setContent(String.valueOf(i));
			signatureCollect.setLibraryId(libraryId);
			signatureCollect.setCollectTime(collectTime);

			target.save(signatureCollect);
		}

		Integer offSet = 2;
		Integer pageSize = 10;

		List<SignatureCollect> list = target.findLibraryByCustomerIdForPage(
				customerId, offSet, pageSize);

		Integer pageSize2 = list.size();

		Assert.assertEquals(pageSize, pageSize2);

		Integer offSet2 = Integer.valueOf(list.get(0).getContent());

		Assert.assertEquals(offSet, offSet2);
	}

	@Test
	public void testFindOriginalCountByCustomerId()
			throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;

		Integer classId = 12;
		String className = "感悟篇";
		String content = RandomUtil.getRandomSignature();

		Integer originalId = 10;
		Date collectTime = new Date();

		Integer customerId = customerIdSave;

		for (int i = 0; i < N; i++) {
			HgCustomer hgCustomer = new HgCustomer();
			hgCustomer.setId(customerId);

			SignatureCollect signatureCollect = new SignatureCollect();
			signatureCollect.setCustomer(hgCustomer);
			signatureCollect.setClassId(classId);
			signatureCollect.setClassName(className);
			signatureCollect.setContent(content);
			signatureCollect.setOriginalId(originalId);
			signatureCollect.setCollectTime(collectTime);

			target.save(signatureCollect);
		}

		Integer N2 = target.findOriginalCountByCustomerId(customerId);
		Assert.assertEquals(N, N2);
	}

	@Test
	public void testFindOriginalByCustomerIdForPage()
			throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;

		Integer classId = 12;
		String className = "感悟篇";

		Integer originalId = 10;
		Date collectTime = new Date();

		Integer customerId = customerIdSave;

		for (int i = 0; i < N; i++) {
			HgCustomer hgCustomer = new HgCustomer();
			hgCustomer.setId(customerId);

			SignatureCollect signatureCollect = new SignatureCollect();
			signatureCollect.setCustomer(hgCustomer);
			signatureCollect.setClassId(classId);
			signatureCollect.setClassName(className);
			signatureCollect.setContent(String.valueOf(i));
			signatureCollect.setOriginalId(originalId);
			signatureCollect.setCollectTime(collectTime);

			target.save(signatureCollect);
		}

		Integer offSet = 2;
		Integer pageSize = 10;

		List<SignatureCollect> list = target.findOriginalByCustomerIdForPage(
				customerId, offSet, pageSize);

		Integer pageSize2 = list.size();

		Assert.assertEquals(pageSize, pageSize2);

		Integer offSet2 = Integer.valueOf(list.get(0).getContent());

		Assert.assertEquals(offSet, offSet2);
	}

	@Test
	public void testFindOriginalByCustomerId() throws SignaturePersistException {
		Integer classId = 12;
		String className = "感悟篇";
		String content = RandomUtil.getRandomSignature();

		Integer libraryId = 10;

		Integer customerId = customerIdSave;
		HgCustomer hgCustomer = new HgCustomer();
		hgCustomer.setId(customerId);

		SignatureCollect signatureCollect = new SignatureCollect();
		signatureCollect.setCustomer(hgCustomer);
		signatureCollect.setClassId(classId);
		signatureCollect.setClassName(className);
		signatureCollect.setContent(content);
		signatureCollect.setLibraryId(libraryId);
		signatureCollect.setCollectTime(new Date());

		Integer id = target.save(signatureCollect);

		List<SignatureCollect> list = target
				.findLibraryByCustomerId(customerId);
		Iterator<SignatureCollect> it = list.iterator();

		boolean isNext = false;
		while (it.hasNext()) {
			if (id.equals(it.next().getId())) {
				isNext = true;
			}
		}

		Assert.assertEquals(true, isNext);
	}

	@Test
	public void testFindCountByCustomerIdAndClassId()
			throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;

		Integer classId = 12;
		String className = "感悟篇";

		Integer originalId = 10;
		Date collectTime = new Date();

		Integer customerId = customerIdSave;

		for (int i = 0; i < N; i++) {
			HgCustomer hgCustomer = new HgCustomer();
			hgCustomer.setId(customerId);

			SignatureCollect signatureCollect = new SignatureCollect();
			signatureCollect.setCustomer(hgCustomer);
			signatureCollect.setClassId(classId);
			signatureCollect.setClassName(className);
			signatureCollect.setContent(String.valueOf(i));
			signatureCollect.setOriginalId(originalId);
			signatureCollect.setCollectTime(collectTime);

			target.save(signatureCollect);
		}

		Integer N2 = target
				.findCountByCustomerIdAndClassId(customerId, classId);
		Assert.assertEquals(N, N2);

	}

	@Test
	public void testFindByCustomerIdAndClassIdForPage()
			throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;

		Integer classId = 12;
		String className = "感悟篇";

		Integer originalId = 10;
		Date collectTime = new Date();

		Integer customerId = customerIdSave;

		for (int i = 0; i < N; i++) {
			HgCustomer hgCustomer = new HgCustomer();
			hgCustomer.setId(customerId);

			SignatureCollect signatureCollect = new SignatureCollect();
			signatureCollect.setCustomer(hgCustomer);
			signatureCollect.setClassId(classId);
			signatureCollect.setClassName(className);
			signatureCollect.setContent(String.valueOf(i));
			signatureCollect.setOriginalId(originalId);
			signatureCollect.setCollectTime(collectTime);

			target.save(signatureCollect);
		}

		Integer offSet = 2;
		Integer pageSize = 10;

		List<SignatureCollect> list = target.findByCustomerIdAndClassIdForPage(
				customerId, classId, offSet, pageSize);

		Integer pageSize2 = list.size();

		Assert.assertEquals(pageSize, pageSize2);

		Integer offSet2 = Integer.valueOf(list.get(0).getContent());

		Assert.assertEquals(offSet, offSet2);
	}

	//不可重复测试
//	@Test
//	public void testFindLibraryCountByCustomerIdAndParent()
//			throws SignaturePersistException {
//		Integer count = target.findLibraryCountByCustomerIdAndParent(
//				1014, null, null);
//		Assert.assertEquals(new Integer(2), count);
//	}
	
	//不可重复测试
//	@Test
//	public void testFindLibraryCountByCustomerIdAndParentForPage()
//			throws SignaturePersistException {
//		List<SignatureCollect> list = target.findLibraryByCustomerIdAndParentForPage(1014, 14, null,  0, 10);
//		Assert.assertNotNull(list);
//		
//		Integer size = list.size();
//		Assert.assertEquals(new Integer(3), size);
//	}

	/**
	 * @throws SignaturePersistException
	 * 
	 */
	public SignatureCollect save() throws SignaturePersistException {
		Integer classId = 12;
		String className = "感悟篇";
		String content = RandomUtil.getRandomSignature();

		Date collectTime = new Date();

		Integer originalId = 10;

		Integer customerId = customerIdSave;
		HgCustomer hgCustomer = new HgCustomer();
		hgCustomer.setId(customerId);

		SignatureCollect signatureCollect = new SignatureCollect();
		signatureCollect.setCustomer(hgCustomer);
		signatureCollect.setClassId(classId);
		signatureCollect.setClassName(className);
		signatureCollect.setContent(content);
		signatureCollect.setOriginalId(originalId);
		signatureCollect.setCollectTime(collectTime);
		signatureCollect.setParentClassId(14);
		signatureCollect.setParentClassName("商务彩印");

		Integer id = target.save(signatureCollect);
		return target.getById(id);
	}

}
