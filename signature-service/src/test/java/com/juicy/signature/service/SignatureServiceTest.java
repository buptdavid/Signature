/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.juicy.signature.persist.dao.HgCustomerDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureCollect;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * SignatureService测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-5 创建
 *          </p>
 */
public class SignatureServiceTest extends BaseServiceTest {

	SignatureService target;

	SignatureClass firstLibraryClass;

	SignatureClass secondLibraryClass;

	SignatureClass firstOriginalClass;

	SignatureClass secondOriginalClass;

	HgCustomer hgCustomer;

	@Before
	public void prepare() throws SignatureServiceException,
			SignaturePersistException {
		target = (SignatureService) super.getCtx().getBean("signatureService");

		// 保存一个签名宝库一级分类
		firstLibraryClass = new SignatureClass();
		firstLibraryClass.setBasis(SignatureClass.LIBRARY);
		firstLibraryClass.setName(RandomUtil.getFirstCLass());
		firstLibraryClass.setParentId(0);
		target.createClasses(firstLibraryClass);

		// 保存一个签名宝库二级分类
		secondLibraryClass = new SignatureClass();
		secondLibraryClass.setBasis(SignatureClass.LIBRARY);
		secondLibraryClass.setName(RandomUtil.getSecondCLass());
		secondLibraryClass.setParentId(firstLibraryClass.getId());
		target.createClasses(secondLibraryClass);

		// 保存一个原创情景一级分类
		firstOriginalClass = new SignatureClass();
		firstOriginalClass.setBasis(SignatureClass.ORIGINAL);
		firstOriginalClass.setName(RandomUtil.getFirstCLass());
		firstOriginalClass.setParentId(0);
		target.createClasses(firstOriginalClass);

		// 保存一个原创情景二级分类
		secondOriginalClass = new SignatureClass();
		secondOriginalClass.setBasis(SignatureClass.ORIGINAL);
		secondOriginalClass.setName(RandomUtil.getSecondCLass());
		secondOriginalClass.setParentId(firstOriginalClass.getId());
		target.createClasses(secondOriginalClass);

		// 保存一个HgCustomer对象
		HgCustomerDao hgCustomerDao = (HgCustomerDao) super.getCtx().getBean(
				"hgCustomerDao");
		// 随机的手机号码
		String customerName = RandomUtil.getRandomMobile();
		hgCustomer = new HgCustomer();
		hgCustomer.setCustomerManagerId(HgCustomer.UNUSEDID);
		hgCustomer.setComboId(HgCustomer.UNUSEDID);
		hgCustomer.setUserId(HgCustomer.UNUSEDID);
		hgCustomer.setRegionId(1);
		hgCustomer.setCustomerName(customerName);
		hgCustomer.setCustomerType(1);
		hgCustomerDao.save(hgCustomer);
	}

	@Test
	public void testCreateClasses() throws SignatureServiceException {
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setBasis(SignatureClass.LIBRARY);
		signatureClass.setName(RandomUtil.getFirstCLass());
		signatureClass.setParentId(0);

		Result result = target.createClasses(signatureClass);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);
	}

	@Test
	public void testModifyClasses() throws SignatureServiceException {
		Byte basis = SignatureClass.LIBRARY;

		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setBasis(basis);
		signatureClass.setName(RandomUtil.getFirstCLass());
		signatureClass.setParentId(0);

		target.createClasses(signatureClass);

		String name = RandomUtil.getFirstCLass();
		signatureClass.setName(name);

		Result result = target.modifyClasses(signatureClass);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		SignatureClass signatureClass2 = (SignatureClass) result.getModel()
				.get("signatureClass");
		String name2 = signatureClass2.getName();
		Assert.assertEquals(name, name2);
	}

	@Test
	public void testDeleteClasses() throws SignatureServiceException {
		// 保存一个一级分类
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setBasis(SignatureClass.LIBRARY);
		signatureClass.setName(RandomUtil.getFirstCLass());
		signatureClass.setParentId(0);
		target.createClasses(signatureClass);

		SignatureClass signatureClass2 = new SignatureClass();
		signatureClass2.setBasis(SignatureClass.LIBRARY);
		signatureClass2.setName(RandomUtil.getSecondCLass());
		signatureClass2.setParentId(signatureClass.getId());
		target.createClasses(signatureClass2);

		Result result = target.deleteClasses(signatureClass);
		Result result2 = target.deleteClasses(signatureClass2);

		boolean isSuccess = result.isSuccess();
		boolean isSuccess2 = result2.isSuccess();

		Assert.assertEquals(false, isSuccess);
		Assert.assertEquals(true, isSuccess2);
	}

	@Test
	public void testGetClassesByBasis() throws SignatureServiceException {
		// 保存一个
		Byte basis = SignatureClass.ORIGINAL;

		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setBasis(basis);
		signatureClass.setName(RandomUtil.getFirstCLass());
		signatureClass.setParentId(0);

		target.createClasses(signatureClass);

		Integer classId = signatureClass.getId();

		Result result = target.getClassesByBasis(basis,SignatureService.ALL);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		List<SignatureClass> firstClassList = (List<SignatureClass>) result
				.getModel().get("firstClassList");

		Iterator<SignatureClass> it = firstClassList.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			if (classId.equals(it.next().getId())) {
				isHas = true;
			}
		}

		Assert.assertEquals(true, isHas);

	}

	@Test
	public void testCreateOriginal() throws SignatureServiceException {
		SignatureOriginal signatureOriginal = new SignatureOriginal();
		// signatureOriginal.s
		String content = RandomUtil.getRandomSignature();
		signatureOriginal.setCustomer(hgCustomer);
		signatureOriginal.setSignatureClass(secondOriginalClass);
		signatureOriginal.setPublish(true);
		signatureOriginal.setContent(content);

		Result result = target.createOriginal(signatureOriginal);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);
	}

	@Test
	public void testModifyOriginal() throws SignatureServiceException {
		SignatureOriginal signatureOriginal = new SignatureOriginal();
		// signatureOriginal.s
		signatureOriginal.setCustomer(hgCustomer);
		signatureOriginal.setSignatureClass(secondOriginalClass);
		signatureOriginal.setPublish(true);
		signatureOriginal.setContent(RandomUtil.getRandomSignature());

		target.createOriginal(signatureOriginal);

		String content = RandomUtil.getRandomSignature();
		signatureOriginal.setContent(content);

		Result result = target.modifyOriginal(signatureOriginal);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		SignatureOriginal signatureOriginal2 = (SignatureOriginal) result
				.getModel().get("signatureOriginal");
		String content2 = signatureOriginal2.getContent();
		Assert.assertEquals(content, content2);
	}

	@Test
	public void testDeleteOriginal() throws SignatureServiceException {
		// 首先保存一个原创签名
		SignatureOriginal signatureOriginal = new SignatureOriginal();
		// signatureOriginal.s
		String content = RandomUtil.getRandomSignature();
		signatureOriginal.setCustomer(hgCustomer);
		signatureOriginal.setSignatureClass(secondOriginalClass);
		signatureOriginal.setPublish(true);
		signatureOriginal.setContent(content);

		List<Integer> signatureOriginalIdList = new ArrayList<Integer>();
		signatureOriginalIdList.add(signatureOriginal.getId());

		Result result = target.deleteOriginal(signatureOriginalIdList);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);
	}

	@Test
	public void testGetOriginal() throws SignatureServiceException {
		// 创建N个SignatureOriginal对象并保存
		Integer N = 13;

		boolean publish = true;
		Byte auditStatus = SignatureOriginal.UNAUDITED;

		Integer customerId = hgCustomer.getId();
		Integer classId = secondOriginalClass.getId();
		String content = RandomUtil.getRandomMobile();

		for (int i = 0; i < N; i++) {
			HgCustomer hgCustomer = new HgCustomer();
			hgCustomer.setId(customerId);
			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(classId);
			SignatureOriginal signatureOriginal = new SignatureOriginal();
			signatureOriginal.setCustomer(hgCustomer);
			signatureOriginal.setSignatureClass(signatureClass);
			signatureOriginal.setPublish(publish);
			signatureOriginal.setAuditStatus(auditStatus);
			signatureOriginal.setGmtTime(new Date());
			signatureOriginal.setRecommend(true);
			signatureOriginal.setContent(content + String.valueOf(i));

			// 创建
			target.createOriginal(signatureOriginal);
		}

		// 新User对象
		User user = new User();
		user.setCustomerId(customerId);

		// Page对象设置
		Integer currentPage = 1;
		Integer everyPage = 10;
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setEveryPage(everyPage);

		Result result = target.getOriginal(user, content,SignatureOriginal.PASSAUDIT, page);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		List<SignatureOriginal> list = (List<SignatureOriginal>) result
				.getModel().get("signatureOriginalList");

		String content2 = list.get(0).getContent();
		Integer currentPage2 = Integer.valueOf(content2.substring(
				content2.length() - 1, content2.length()));
		currentPage2++;

		Assert.assertEquals(currentPage, currentPage2);
	}

	@Test
	public void testCreateLibrary() throws SignatureServiceException {
		SignatureLibrary signatureLibrary = new SignatureLibrary();
		// signatureOriginal.s
		String content = RandomUtil.getRandomSignature();
		signatureLibrary.setSignatureClass(secondLibraryClass);
		signatureLibrary.setContent(content);

		Result result = target.createLibrary(signatureLibrary);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		Integer id = signatureLibrary.getId();
		Assert.assertNotNull(id);
	}

	@Test
	public void testModifyLibrary() throws SignatureServiceException {
		// 保存一条记录
		SignatureLibrary signatureLibrary = new SignatureLibrary();
		// signatureOriginal.s
		String content = RandomUtil.getRandomSignature();
		signatureLibrary.setSignatureClass(secondLibraryClass);
		signatureLibrary.setContent(content);
		target.createLibrary(signatureLibrary);

		content = RandomUtil.getRandomSignature();
		signatureLibrary.setContent(content);

		Result result = target.modifyLibrary(signatureLibrary);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		SignatureLibrary signatureLibrary2 = (SignatureLibrary) result
				.getModel().get("signatureLibrary");

		String content2 = signatureLibrary2.getContent();
		Assert.assertEquals(content, content2);
	}

	@Test
	public void testDeleteLibrary() throws SignatureServiceException {
		// 保存一条记录
		SignatureLibrary signatureLibrary = new SignatureLibrary();
		// signatureOriginal.s
		String content = RandomUtil.getRandomSignature();
		signatureLibrary.setSignatureClass(secondLibraryClass);
		signatureLibrary.setContent(content);
		target.createLibrary(signatureLibrary);

		List<SignatureLibrary> signatureLibraryList = new ArrayList<SignatureLibrary>();
		signatureLibraryList.add(signatureLibrary);

		Result result = target.deleteLibrary(signatureLibraryList);
		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

	}

	@Test
	public void testGetLibrary() throws SignatureServiceException {
		// 创建N个SignatureOriginal对象并保存
		Integer N = 13;

		Integer classId = secondLibraryClass.getId();
		String content = RandomUtil.getRandomMobile();

		for (int i = 0; i < N; i++) {
			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(classId);

			SignatureLibrary signatureLibrary = new SignatureLibrary();
			signatureLibrary.setSignatureClass(signatureClass);
			signatureLibrary.setContent(content + String.valueOf(i));

			// 创建
			target.createLibrary(signatureLibrary);
		}

		// Page对象设置
		Integer currentPage = 1;
		Integer everyPage = 10;
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setEveryPage(everyPage);

		Result result = target.getLibrary(content, page);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		List<SignatureLibrary> list = (List<SignatureLibrary>) result
				.getModel().get("signatureLibraryList");

		String content2 = list.get(0).getContent();
		Integer currentPage2 = Integer.valueOf(content2.substring(
				content2.length() - 1, content2.length()));
		currentPage2++;

		Assert.assertEquals(currentPage, currentPage2);
	}

	@Test
	public void testCreateCollect() throws SignatureServiceException {
		Integer classId = secondLibraryClass.getId();
		String className = secondLibraryClass.getName();
		HgCustomer customer = hgCustomer;

		String content = RandomUtil.getRandomSignature();

		SignatureCollect signatureCollect = new SignatureCollect();
		signatureCollect.setClassId(classId);
		signatureCollect.setClassName(className);
		signatureCollect.setContent(content);
		signatureCollect.setCustomer(customer);

		Result result = target.createCollect(signatureCollect);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);
	}

	@Test
	public void testModifyCollect() throws SignatureServiceException {
		Integer classId = secondLibraryClass.getId();
		String className = secondLibraryClass.getName();
		HgCustomer customer = hgCustomer;

		SignatureCollect signatureCollect = new SignatureCollect();
		signatureCollect.setClassId(classId);
		signatureCollect.setClassName(className);
		signatureCollect.setContent(RandomUtil.getRandomSignature());
		signatureCollect.setCustomer(customer);

		target.createCollect(signatureCollect);

		String content = RandomUtil.getRandomSignature();
		signatureCollect.setContent(content);

		Result result = target.modifyCollect(signatureCollect);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		SignatureCollect signatureCollect2 = (SignatureCollect) result
				.getModel().get("signatureCollect");
		String content2 = signatureCollect2.getContent();
		Assert.assertEquals(content, content2);
	}

	@Test
	public void testDeleteCollect() throws SignatureServiceException {
		// 保存一个对象
		Integer classId = secondLibraryClass.getId();
		String className = secondLibraryClass.getName();
		HgCustomer customer = hgCustomer;

		String content = RandomUtil.getRandomSignature();

		SignatureCollect signatureCollect = new SignatureCollect();
		signatureCollect.setClassId(classId);
		signatureCollect.setClassName(className);
		signatureCollect.setContent(content);
		signatureCollect.setCustomer(customer);
		target.createCollect(signatureCollect);

		List<Integer> signatureCollectIdList = new ArrayList<Integer>();
		signatureCollectIdList.add(signatureCollect.getId());

		Result result = target.deleteCollect(signatureCollectIdList);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);
	}

	@Test
	public void testGetCollect() throws SignatureServiceException {
		// 创建N个SignatureOriginal对象并保存
		Integer N = 13;

		Integer classId = secondLibraryClass.getId();
		String className = secondLibraryClass.getName();
		HgCustomer customer = hgCustomer;

		String content = RandomUtil.getRandomSignature();

		for (int i = 0; i < N; i++) {
			SignatureCollect signatureCollect = new SignatureCollect();
			signatureCollect.setClassId(classId);
			signatureCollect.setClassName(className);
			signatureCollect.setContent(content + String.valueOf(i));
			signatureCollect.setCustomer(customer);
			target.createCollect(signatureCollect);
		}

		// Page对象设置
		Integer currentPage = 1;
		Integer everyPage = 10;
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setEveryPage(everyPage);

		User user = new User();
		user.setCustomerId(customer.getId());

		Result result = target.getCollect(user, secondLibraryClass, page);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		List<SignatureCollect> list = (List<SignatureCollect>) result
				.getModel().get("signatureCollectList");

		String content2 = list.get(0).getContent();
		Integer currentPage2 = Integer.valueOf(content2.substring(
				content2.length() - 1, content2.length()));
		currentPage2++;

		Assert.assertEquals(currentPage, currentPage2);
	}
	
	@Test
	public void testgetCollectLibrary() throws SignatureServiceException{
		User user = new User();
		user.setCustomerId(1014);
		
		Page page = new Page();
		target.getCollectLibrary(user, null, null, page);
	}
	
		
}
