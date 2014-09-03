/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.juicy.signature.persist.dao.HgCustomerDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.HgSpecialNumbers;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * ListService测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-8 创建
 *          </p>
 */
public class ListServiceTest extends BaseServiceTest {

	ListService target;

	Integer customerIdSave;

	@Before
	public void prepare() throws SignaturePersistException {
		target = (ListService) super.getCtx().getBean("listService");

		// 保存一个Customer
		HgCustomerDao hgCustomerDao = (HgCustomerDao) super.getCtx().getBean(
				"hgCustomerDao");

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
	public void testCreateBlackList() throws SignatureServiceException {
		// 创建N个
		int N = 3;
		String specialNumber = "13426082242";

		List<HgSpecialNumbers> hgSpecialNumbersList = new ArrayList<HgSpecialNumbers>();
		for (int i = 0; i < N; i++) {
			HgSpecialNumbers hgSpecialNumbers = new HgSpecialNumbers();
			hgSpecialNumbers.setCustomerId(customerIdSave);
			hgSpecialNumbers.setRemark("混蛋");
			hgSpecialNumbers.setShieldPeriod(10000);
			hgSpecialNumbers.setSpecialNumber(specialNumber);

			hgSpecialNumbersList.add(hgSpecialNumbers);
		}

		Result result = target.createBlackList(hgSpecialNumbersList);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);
	}

	// 不可重复测试
	// @Test
	public void testCreateBlackList1() throws SignatureServiceException {
		Integer customerId = 1014;
		List<HgSpecialNumbers> hgSpecialnumbers = new ArrayList<HgSpecialNumbers>();

		HgSpecialNumbers hgSpecialnumber = new HgSpecialNumbers();
		hgSpecialnumber.setCustomerId(customerId);
		hgSpecialnumber.setSpecialNumber("12345678912");

		hgSpecialnumbers.add(hgSpecialnumber);

		Result result = target.createBlackList(hgSpecialnumbers);

		Boolean isSuccess = result.isSuccess();

		Assert.assertEquals(true, isSuccess);
	}

	@Test
	public void testGetBlackList() throws SignatureServiceException {
		// 创建N个
		int N = 13;
		String specialNumber = "13426082242";

		List<HgSpecialNumbers> hgSpecialNumbersList = new ArrayList<HgSpecialNumbers>();
		for (int i = 0; i < N; i++) {
			HgSpecialNumbers hgSpecialNumbers = new HgSpecialNumbers();
			hgSpecialNumbers.setCustomerId(customerIdSave);
			hgSpecialNumbers.setRemark(String.valueOf(i));
			hgSpecialNumbers.setShieldPeriod(10000);
			hgSpecialNumbers.setSpecialNumber(specialNumber);

			hgSpecialNumbersList.add(hgSpecialNumbers);
		}

		target.createBlackList(hgSpecialNumbersList);

		// 新User实例对象
		User user = new User();
		user.setCustomerId(customerIdSave);

		// Page对象设置
		Integer currentPage = 1;
		Integer everyPage = 10;
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setEveryPage(everyPage);

		Result result = target.getBlackList(user, page);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		List<HgSpecialNumbers> hgSpecialNumbersList2 = (List<HgSpecialNumbers>) result
				.getModel().get("blackList");

		Integer currentPage2 = Integer.valueOf(hgSpecialNumbersList2.get(0)
				.getRemark());
		currentPage2++;

		Assert.assertEquals(currentPage, currentPage2);

	}

	@Test
	public void testCreateWhiteList() throws SignatureServiceException {
		// 创建N个
		int N = 3;
		String specialNumber = "13426082242";

		List<HgSpecialNumbers> hgSpecialNumbersList = new ArrayList<HgSpecialNumbers>();
		for (int i = 0; i < N; i++) {
			HgSpecialNumbers hgSpecialNumbers = new HgSpecialNumbers();
			hgSpecialNumbers.setCustomerId(customerIdSave);
			hgSpecialNumbers.setRemark("混蛋");
			hgSpecialNumbers.setShieldPeriod(10000);
			hgSpecialNumbers.setSpecialNumber(specialNumber);

			hgSpecialNumbersList.add(hgSpecialNumbers);
		}

		Result result = target.createWhiteList(hgSpecialNumbersList);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);
	}

	@Test
	public void testDeleteList() throws SignaturePersistException,
			SignatureServiceException {
		// 创建N个
		int N = 3;
		String specialNumber = "13426082242";

		List<HgSpecialNumbers> hgSpecialNumbersList = new ArrayList<HgSpecialNumbers>();
		for (int i = 0; i < N; i++) {
			HgSpecialNumbers hgSpecialNumbers = new HgSpecialNumbers();
			hgSpecialNumbers.setCustomerId(customerIdSave);
			hgSpecialNumbers.setRemark("混蛋");
			hgSpecialNumbers.setShieldPeriod(10000);
			hgSpecialNumbers.setSpecialNumber(specialNumber);

			hgSpecialNumbersList.add(hgSpecialNumbers);
		}

		target.createWhiteList(hgSpecialNumbersList);
		
		List<Integer> hgSpecialNumbersIdList = new ArrayList<Integer>();
		Iterator<HgSpecialNumbers>  it = hgSpecialNumbersList.iterator();
		while(it.hasNext()){
			hgSpecialNumbersIdList.add(it.next().getId());
		}

		Result result = target.deleteList(hgSpecialNumbersIdList);
		

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);
	}

	@Test
	public void testGetWhiteList() throws SignatureServiceException {
		// 创建N个
		int N = 13;
		String specialNumber = "13426082242";

		List<HgSpecialNumbers> hgSpecialNumbersList = new ArrayList<HgSpecialNumbers>();
		for (int i = 0; i < N; i++) {
			HgSpecialNumbers hgSpecialNumbers = new HgSpecialNumbers();
			hgSpecialNumbers.setCustomerId(customerIdSave);
			hgSpecialNumbers.setRemark(String.valueOf(i));
			hgSpecialNumbers.setShieldPeriod(10000);
			hgSpecialNumbers.setSpecialNumber(specialNumber);

			hgSpecialNumbersList.add(hgSpecialNumbers);
		}

		target.createWhiteList(hgSpecialNumbersList);

		// 新User实例对象
		User user = new User();
		user.setCustomerId(customerIdSave);

		// Page对象设置
		Integer currentPage = 1;
		Integer everyPage = 10;
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setEveryPage(everyPage);

		Result result = target.getWhiteList(user, page);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		List<HgSpecialNumbers> hgSpecialNumbersList2 = (List<HgSpecialNumbers>) result
				.getModel().get("whiteList");

		Integer currentPage2 = Integer.valueOf(hgSpecialNumbersList2.get(0)
				.getRemark());
		currentPage2++;

		Assert.assertEquals(currentPage, currentPage2);
	}

}
