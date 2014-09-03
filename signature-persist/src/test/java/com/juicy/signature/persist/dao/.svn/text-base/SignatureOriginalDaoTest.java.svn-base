/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * SignatureOriginalDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-28 创建
 *          </p>
 */
public class SignatureOriginalDaoTest {

	SignatureOriginalDao target;

	ApplicationContext ctx;

	Integer customerIdSave;

	Integer classIdSave;

	public SignatureOriginalDaoTest() {
		ctx = BaseDaoTest.getInstance();
	}

	@Before
	public void prepare() throws SignaturePersistException {
		target = (SignatureOriginalDao) ctx.getBean("signatureOriginalDao");

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

		// 保存一个SignatureClass对象
		SignatureClassDao signatureClassDao = (SignatureClassDao)ctx.getBean("signatureClassDao");
		
		String first = RandomUtil.getFirstCLass();
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setBasis(SignatureClass.ORIGINAL);
		signatureClass.setName(first);
		signatureClass.setParentId(0);		
		signatureClassDao.save(signatureClass);
		
		Integer firstId = signatureClass.getId();
		
		//保存二级分类
		String second = RandomUtil.getSecondCLass();
		SignatureClass signatureClass2 = new SignatureClass();
		signatureClass2.setBasis(SignatureClass.ORIGINAL);
		signatureClass2.setName(second);
		signatureClass2.setParentId(firstId);
		signatureClassDao.save(signatureClass2);
		
		classIdSave = signatureClass2.getId();

	}

	@Test
	public void testGetById() throws SignaturePersistException {
		SignatureOriginal signatureOriginal = this.save(true,
				SignatureOriginal.UNAUDITED);
		Integer id = signatureOriginal.getId();
		String content = signatureOriginal.getContent();

		SignatureOriginal signatureOriginal2 = target.getById(id);
		String content2 = signatureOriginal2.getContent();

		Assert.assertEquals(content, content2);
	}

	@Test
	public void testSave() throws SignaturePersistException {
		Integer customerId = customerIdSave;
		HgCustomer hgCustomer = new HgCustomer();
		hgCustomer.setId(customerId);

		Integer classId = classIdSave;
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setId(classId);

		String content = RandomUtil.getRandomSignature();

		SignatureOriginal signatureOriginal = new SignatureOriginal();
		signatureOriginal.setCustomer(hgCustomer);
		signatureOriginal.setSignatureClass(signatureClass);
		signatureOriginal.setPublish(true);
		signatureOriginal.setAuditStatus(SignatureOriginal.UNAUDITED);
		signatureOriginal.setContent(content);
		signatureOriginal.setGmtTime(new Date());
		signatureOriginal.setRecommend(true);

		Integer id = target.save(signatureOriginal);

		SignatureOriginal signatureOriginal2 = target.getById(id);
		String content2 = signatureOriginal2.getContent();

		Assert.assertEquals(content, content2);
	}

	@Test
	public void testUpdate() throws SignaturePersistException {
		String content = RandomUtil.getRandomSignature();

		SignatureOriginal signatureOriginal = this.save(false,
				SignatureOriginal.PASSAUDIT);
		signatureOriginal.setContent(content);

		Integer id = signatureOriginal.getId();

		target.update(signatureOriginal);

		SignatureOriginal signatureOriginal2 = target.getById(id);
		String content2 = signatureOriginal2.getContent();

		Assert.assertEquals(content, content2);

	}

	@Test
	public void testDeleteParaSignatureOriginal() throws SignaturePersistException {
		SignatureOriginal signatureOriginal = this.save(true,
				SignatureOriginal.UNPASSAUDIT);
		Integer id = signatureOriginal.getId();

		target.delete(signatureOriginal);

		SignatureOriginal signatureOriginal2 = target.getById(id);

		Assert.assertEquals(null, signatureOriginal2);
	}

	@Test
	public void testDeleteParaId() throws SignaturePersistException {
		SignatureOriginal signatureOriginal = this.save(true,
				SignatureOriginal.UNPASSAUDIT);
		Integer id = signatureOriginal.getId();

		target.delete(id);

		SignatureOriginal signatureOriginal2 = target.getById(id);

		Assert.assertEquals(null, signatureOriginal2);
	}

	@Test
	public void testFindAll() throws SignaturePersistException {
		SignatureOriginal signatureOriginal = this.save(false,
				SignatureOriginal.UNAUDITED);

		List<SignatureOriginal> list = target.findAll();
		Iterator<SignatureOriginal> it = list.iterator();

		boolean isNext = it.hasNext();

		Assert.assertEquals(true, isNext);
	}

	@Test
	public void testFindByCustomerId() throws SignaturePersistException {
		boolean publish = true;
		Byte auditStatus = SignatureOriginal.UNAUDITED;
		SignatureOriginal signatureOriginal = this.save(publish, auditStatus);

		// 产生时间
		Date gmtTime = signatureOriginal.getGmtTime();
		Integer customerId = signatureOriginal.getCustomer().getId();
		String content = signatureOriginal.getContent();

		List<SignatureOriginal> list = target.findByCustomerId(customerId,
				publish, auditStatus, "");

		Iterator<SignatureOriginal> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			SignatureOriginal s = it.next();
			if (gmtTime.equals(s.getGmtTime())) {
				isHas = true;
			}
		}

		// 验证
		Assert.assertEquals(true, isHas);

	}

	@Test
	public void testFindCountByCustomerId() throws SignaturePersistException {
		// 保存N个记录
		Integer N = 12;

		boolean publish = true;
		Byte auditStatus = SignatureOriginal.UNAUDITED;

		Integer customerId = customerIdSave;
		String content = RandomUtil.getRandomSignature();

		for (int i = 0; i < N; i++) {
			HgCustomer hgCustomer = new HgCustomer();
			hgCustomer.setId(customerId);

			Integer classId = classIdSave;
			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(classId);
			SignatureOriginal signatureOriginal = new SignatureOriginal();
			signatureOriginal.setCustomer(hgCustomer);
			signatureOriginal.setSignatureClass(signatureClass);
			signatureOriginal.setPublish(publish);
			signatureOriginal.setAuditStatus(auditStatus);
			signatureOriginal.setContent(content);
			signatureOriginal.setGmtTime(new Date());
			signatureOriginal.setRecommend(true);

			target.save(signatureOriginal);
		}

		Integer N2 = target.findCountByCustomerId(customerId, publish,
				auditStatus, content);

		Assert.assertEquals(N, N2);

	}

	@Test
	public void testFindByCustomerIdForPage() throws SignaturePersistException {
		// 保存N个记录
		Integer N = 13;

		boolean publish = true;
		Byte auditStatus = SignatureOriginal.UNAUDITED;

		Integer customerId = customerIdSave;

		for (int i = 0; i < N; i++) {
			HgCustomer hgCustomer = new HgCustomer();
			hgCustomer.setId(customerId);
			Integer classId = classIdSave;
			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(classId);

			// String content = RandomUtil.getRandomSignature();

			SignatureOriginal signatureOriginal = new SignatureOriginal();
			signatureOriginal.setCustomer(hgCustomer);
			signatureOriginal.setSignatureClass(signatureClass);
			signatureOriginal.setPublish(publish);
			signatureOriginal.setAuditStatus(auditStatus);
			// signatureOriginal.setContent(content);
			signatureOriginal.setGmtTime(new Date());
			signatureOriginal.setRecommend(true);

			signatureOriginal.setContent(String.valueOf(i));
			target.save(signatureOriginal);
		}

		Integer offSet = 2;
		Integer pageSize = 10;

		List<SignatureOriginal> list = target.findByCustomerIdForPage(
				customerId, publish, auditStatus, null, offSet, pageSize);

		Integer pageSize2 = list.size();
		Assert.assertEquals(pageSize, pageSize2);

		Integer offSet2 = Integer.valueOf(list.get(0).getContent());
		Assert.assertEquals(offSet, offSet2);

	}

	@Test
	public void testFindByClassId() throws SignaturePersistException {
		boolean publish = false;
		Byte auditStatus = SignatureOriginal.PASSAUDIT;
		SignatureOriginal signatureOriginal = this.save(publish, auditStatus);

		// 产生时间
		Date gmtTime = signatureOriginal.getGmtTime();
		Integer classId = signatureOriginal.getSignatureClass().getId();

		List<SignatureOriginal> list = target.findByClassId(classId, publish,
				auditStatus);

		Iterator<SignatureOriginal> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			SignatureOriginal s = it.next();
			if (gmtTime.equals(s.getGmtTime())) {
				isHas = true;
			}
		}

		// 验证
		Assert.assertEquals(true, isHas);
	}

	@Test
	public void testFindCountByClassId() throws SignaturePersistException {
		// 保存N个记录
		Integer N = 12;

		boolean publish = true;
		Integer classId = classIdSave;
		Byte auditStatus = SignatureOriginal.UNAUDITED;

		for (int i = 0; i < N; i++) {

			Integer customerId = customerIdSave;
			HgCustomer hgCustomer = new HgCustomer();
			hgCustomer.setId(customerId);

			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(classId);

			String content = RandomUtil.getRandomSignature();

			SignatureOriginal signatureOriginal = new SignatureOriginal();
			signatureOriginal.setCustomer(hgCustomer);
			signatureOriginal.setSignatureClass(signatureClass);
			signatureOriginal.setPublish(publish);
			signatureOriginal.setAuditStatus(auditStatus);
			signatureOriginal.setContent(content);
			signatureOriginal.setGmtTime(new Date());
			signatureOriginal.setRecommend(true);
			target.save(signatureOriginal);
		}

		Integer N2 = target.findCountByClassId(classId, publish, auditStatus);

		Assert.assertEquals(N, N2);

	}

	@Test
	public void testFindByClassIdForPage() throws SignaturePersistException {
		// 保存N个记录
		Integer N = 13;

		boolean publish = true;
		Byte auditStatus = SignatureOriginal.UNAUDITED;

		Integer customerId = customerIdSave;
		HgCustomer hgCustomer = new HgCustomer();
		hgCustomer.setId(customerId);

		Integer classId = classIdSave;
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setId(classId);

		// String content = RandomUtil.getRandomSignature();

		SignatureOriginal signatureOriginal = new SignatureOriginal();
		signatureOriginal.setCustomer(hgCustomer);
		signatureOriginal.setSignatureClass(signatureClass);
		signatureOriginal.setPublish(publish);
		signatureOriginal.setAuditStatus(auditStatus);
		// signatureOriginal.setContent(content);
		signatureOriginal.setGmtTime(new Date());
		signatureOriginal.setRecommend(true);

		for (int i = 0; i < N; i++) {
			signatureOriginal.setContent(String.valueOf(i));
			target.save(signatureOriginal);
		}

		Integer offSet = 2;
		Integer pageSize = 10;

		List<SignatureOriginal> list = target.findByCustomerIdForPage(
				customerId, publish, auditStatus, null, offSet, pageSize);

		Integer pageSize2 = list.size();
		Assert.assertEquals(pageSize, pageSize2);

		Integer offSet2 = Integer.valueOf(list.get(0).getContent());
		Assert.assertEquals(offSet, offSet2);

	}

	@Test
	public void testFindByClassIdList() throws SignaturePersistException {
		boolean publish = false;
		Byte auditStatus = SignatureOriginal.PASSAUDIT;
		SignatureOriginal signatureOriginal = this.save(publish, auditStatus);

		// 产生时间
		Date gmtTime = signatureOriginal.getGmtTime();
		Integer classId = signatureOriginal.getSignatureClass().getId();

		List<Integer> classIdList = new ArrayList<Integer>();
		classIdList.add(classId);
		classIdList.add(12);

		List<SignatureOriginal> list = target.findByClassIdList(classIdList,
				publish, auditStatus);

		Iterator<SignatureOriginal> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			SignatureOriginal s = it.next();
			if (gmtTime.equals(s.getGmtTime())) {
				isHas = true;
			}
		}

		// 验证
		Assert.assertEquals(true, isHas);
	}

	@Test
	public void testFindByContent() throws SignaturePersistException {
		boolean publish = false;
		Byte auditStatus = SignatureOriginal.UNPASSAUDIT;
		SignatureOriginal signatureOriginal = this.save(publish, auditStatus);

		// 产生时间
		Date gmtTime = signatureOriginal.getGmtTime();
		Integer classId = signatureOriginal.getSignatureClass().getId();
		String content = signatureOriginal.getContent();

		List<SignatureOriginal> list = target.findByContent(content);

		Iterator<SignatureOriginal> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			SignatureOriginal s = it.next();
			if (gmtTime.equals(s.getGmtTime())) {
				isHas = true;
			}
		}

		// 验证
		Assert.assertEquals(true, isHas);
	}

	/**
	 * 保存一条记录
	 * 
	 * @param isPublish
	 *            是否公开
	 * @param auditStatus
	 *            审核状态
	 * @return 保存的SignatureOriginal实例
	 * @throws SignaturePersistException 
	 */
	public SignatureOriginal save(boolean publish, Byte auditStatus) throws SignaturePersistException {
		Integer customerId = customerIdSave;
		HgCustomer hgCustomer = new HgCustomer();
		hgCustomer.setId(customerId);

		Integer classId = classIdSave;
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setId(classId);

		String content = RandomUtil.getRandomSignature();

		SignatureOriginal signatureOriginal = new SignatureOriginal();
		signatureOriginal.setCustomer(hgCustomer);
		signatureOriginal.setSignatureClass(signatureClass);
		signatureOriginal.setPublish(publish);
		signatureOriginal.setAuditStatus(auditStatus);
		signatureOriginal.setContent(content);
		signatureOriginal.setGmtTime(new Date());
		signatureOriginal.setRecommend(true);

		Integer id = target.save(signatureOriginal);

		SignatureOriginal signatureOriginal2 = target.getById(id);
		return signatureOriginal2;
	}

}
