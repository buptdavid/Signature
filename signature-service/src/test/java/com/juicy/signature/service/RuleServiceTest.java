/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgDiyInfo;
import com.juicy.signature.persist.po.HgSendrule;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * RuleService������
 * 
 * @author ·����
 * @version <p>
 *          2011-8-2 ����
 *          </p>
 */
public class RuleServiceTest extends BaseServiceTest{

	RuleService target;

	Integer customerIdSave;

	String loginNameSave;
	
	public RuleServiceTest(){
		
	}

	@Before
	public void prepare() throws SignaturePersistException {
		target = (RuleService)super.getCtx().getBean("ruleService");

		// ����һ��Customer
//		HgCustomerDao hgCustomerDao = (HgCustomerDao) super.getCtx()
//				.getBean("hgCustomerDao");
//
//		// ������ֻ�����
//		loginNameSave = RandomUtil.getRandomMobile();
//
//		HgCustomer hgCustomer = new HgCustomer();
//
//		hgCustomer.setCustomerManagerId(HgCustomer.UNUSEDID);
//		hgCustomer.setComboId(HgCustomer.UNUSEDID);
//		hgCustomer.setUserId(HgCustomer.UNUSEDID);
//		hgCustomer.setRegionId(1);
//		hgCustomer.setCustomerName(loginNameSave);
//		hgCustomer.setCustomerType(1);
//
//		Integer id = hgCustomerDao.save(hgCustomer);
//
//		HgCustomer hgCustomer2 = hgCustomerDao.getById(id);
//
//		customerIdSave = hgCustomer2.getId();
	}

	@Test
	public void testCreateDefaultRule() throws SignatureServiceException {
		User user = new User();
		user.setLoginName(loginNameSave);
		user.setCustomerId(customerIdSave);

		Result result = target.createDefaultRule(user);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		HgSendrule hgSendrule = (HgSendrule) result.getModel().get(
				"defaultRule");
		Integer sendruleId = hgSendrule.getId();
		Integer customerId2 = hgSendrule.getCustomerId();

		Assert.assertNotNull(sendruleId);
		Assert.assertNotSame(0, sendruleId);
		Assert.assertNotSame(-1, sendruleId);

		Assert.assertEquals(customerIdSave, customerId2);

	}

	@Test
	public void testGetPersonalizedRule() throws SignatureServiceException {
		HgSendrule hgSendrule = this.savePersonalizedRule();
		Integer cuId = hgSendrule.getCustomerId();
		Integer id = hgSendrule.getId();

		User u = new User();
		u.setCustomerId(cuId);

		Result result = target.getPersonalizedRule(u);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		List<HgSendrule> list = (List<HgSendrule>) result.getModel().get(
				"personalizedRuleList");
		Iterator<HgSendrule> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			if (id.equals(it.next().getId())) {
				isHas = true;
			}
		}

		Assert.assertEquals(true, isHas);
	}

	@Test
	public void testGetDefaultRule() throws SignatureServiceException {
		User user = new User();
		user.setLoginName(loginNameSave);
		user.setCustomerId(customerIdSave);

		Result result = target.createDefaultRule(user);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		Result result2 = target.getDefaultRule(user);

		boolean isSuccess2 = result2.isSuccess();
		Assert.assertEquals(true, isSuccess2);

		HgSendrule hgSendrule2 = (HgSendrule) result2.getModel().get(
				"defaultRule");
		Integer customerId2 = hgSendrule2.getCustomerId();

		Assert.assertEquals(customerIdSave, customerId2);
	}

	@Test
	public void testModifyDefaultRule() throws SignatureServiceException {
		User user = new User();
		user.setLoginName(loginNameSave);
		user.setCustomerId(customerIdSave);

		// ������һ��HgDiyInfo���������޸ĵ�����
		String content = RandomUtil.getRandomSignature();

		HgDiyInfo hgDiyInfo = new HgDiyInfo();
		hgDiyInfo.setMessageTypeId(HgDiyInfo.FLASH);
		hgDiyInfo.setDiyInfoContent(content);
		hgDiyInfo.setCustomerId(customerIdSave);

		// �Ƿ�ʹ�ñ�־
		hgDiyInfo.setDiyInfoCurType(HgDiyInfo.UNUSED);

		// ����Ĭ��ǩ��
		Result result = target.createDefaultRule(user);
		boolean isSuccess = result.isSuccess();

		Assert.assertEquals(true, isSuccess);

		HgSendrule hgSendrule = (HgSendrule) result.getModel().get(
				"defaultRule");

		hgSendrule.setDiyInfo(hgDiyInfo);

		// ����Ĭ��ǩ������
		Result result2 = target.modifyDefaultRule(hgSendrule);

		boolean isSuccess2 = result2.isSuccess();
		Assert.assertEquals(true, isSuccess2);

		HgSendrule hgSendrule2 = (HgSendrule) result2.getModel().get(
				"defaultRule");
		String content2 = hgSendrule2.getDiyInfo().getDiyInfoContent();

		Assert.assertEquals(content, content2);

	}

	//�����ظ�������
	//@Test
	public void testCreatePersonalizedRule() throws SignatureServiceException {
		// ������һ��HgDiyInfo����
		String content = RandomUtil.getRandomSignature();

		HgDiyInfo hgDiyInfo = new HgDiyInfo();
		hgDiyInfo.setMessageTypeId(HgDiyInfo.FLASH);
		hgDiyInfo.setDiyInfoContent(content);
		hgDiyInfo.setCustomerId(1014);
		// �Ƿ�ʹ�ñ�־
		hgDiyInfo.setDiyInfoCurType(HgDiyInfo.UNUSED);

		// ������һ��HgSendrule����
		//String sendruleSendperiodtime = "11:00-19:23";
//		String sendruleSendperiodtime = "19:23-20:00";
//		String weeks = "0110001";
		String weeks = "0000010";
		
		String calledNumbers = "13135649919";
//		String callingNumbers = "13426082242";
//		callingNumbers += "," + "13426082241";
		String callingNumbers = "*";

		HgSendrule hgSendrule = new HgSendrule();
		hgSendrule.setCustomerId(1014);
		hgSendrule.setIsDefault(0);
//		hgSendrule.setSendruleName(HgSendrule.DAYRULE);
		hgSendrule.setSendruleIfFlowcontrol(0);
		hgSendrule.setSendruleCallState(1);
//		hgSendrule.setSendruleSendperiodtime(sendruleSendperiodtime);
		hgSendrule.setSendruleWeeks(weeks);
		hgSendrule.setCalledNumbers(calledNumbers);
		hgSendrule.setCallingNumbers(callingNumbers);
		hgSendrule.setDiyInfo(hgDiyInfo);

		Result result = target.createPersonalizedRule(hgSendrule);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);
		
		String message = result.getRemark();

	}

	@Test
	public void testModifyPersonalizedRule() throws SignatureServiceException {
		HgSendrule hgSendrule = this.savePersonalizedRule();
		Integer cuId = hgSendrule.getCustomerId();
		Integer id = hgSendrule.getId();

		// ������һ��HgDiyInfo����,���ڸ���
		String content = RandomUtil.getRandomSignature();

		HgDiyInfo hgDiyInfo = new HgDiyInfo();
		hgDiyInfo.setMessageTypeId(HgDiyInfo.FLASH);
		hgDiyInfo.setDiyInfoContent(content);
		hgDiyInfo.setCustomerId(cuId);
		// �Ƿ�ʹ�ñ�־
		hgDiyInfo.setDiyInfoCurType(HgDiyInfo.UNUSED);

		hgSendrule.setDiyInfo(hgDiyInfo);

		// ����
		Result result = target.modifyPersonalizedRule(hgSendrule);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		HgSendrule hgSendrule2 = (HgSendrule) result.getModel().get(
				"personalizedRule");
		String content2 = hgSendrule2.getDiyInfo().getDiyInfoContent();

		Assert.assertEquals(content, content2);

	}

	@Test
	public void testDeletePersonalizedRule() throws SignatureServiceException {
		HgSendrule hgSendrule = this.savePersonalizedRule();
		HgSendrule hgSendrule2 = this.savePersonalizedRule();

		List<Integer> list = new ArrayList<Integer>();
		list.add(hgSendrule.getId());
		list.add(hgSendrule2.getId());

		// ɾ��
		target.deletePersonalizedRule(list);

		// ����User����
		Integer cuId = hgSendrule.getCustomerId();
		User user = new User();
		user.setCustomerId(cuId);

		// ��ѯ
		Result result = target.getPersonalizedRule(user);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		List<HgSendrule> list2 = (List<HgSendrule>) result.getModel().get(
				"personalizedRuleList");

		Iterator<HgSendrule> it = list2.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			if (cuId.equals(it.next().getCustomerId())) {
				isHas = true;
			}
		}

		Assert.assertEquals(false, isHas);

	}

	/**
	 * ����һ��Ĭ��ǩ������
	 * 
	 * @return
	 * @throws SignatureServiceException
	 */
	public HgSendrule saveDefaultRule() throws SignatureServiceException {
		User user = new User();
		user.setLoginName(loginNameSave);
		user.setCustomerId(customerIdSave);

		target.createDefaultRule(user);
		Result result = target.getDefaultRule(user);
		return (HgSendrule) result.getModel().get("defaultRule");
	}
	
	//��ʱ���ԣ������ظ�����
//	@Test
//	public void testModifyDefaultRule2() throws SignatureServiceException{
//		Integer libId = 15;
//		SignatureLibrary library = new SignatureLibrary();
//		library.setId(libId);
//		
//		// �����û��Զ�����ϢHgDiyInfo����
//		Integer cusId = 1014;
//		String libraryContent = "˭Ҫ�ɰ�ֽ��д������һ�У�����˵����׾���Ͳ�Ӧ�þ��Ȼ��߶�����";
//		HgDiyInfo diyInfo = new HgDiyInfo();
//		diyInfo.setCustomerId(cusId);
//		diyInfo.setDiyInfoContent(libraryContent);
//		diyInfo.setLibrary(library);
//
//		// ����HgSendrule����
//		String logName = "13134741148";
//		HgSendrule hgSendrule = new HgSendrule();
//		hgSendrule.setCustomerId(cusId);
//		hgSendrule.setCalledNumbers(logName);
//		hgSendrule.setDiyInfo(diyInfo);
//
//		Result result = target.modifyDefaultRule(hgSendrule);
//		boolean isSuccess = result.isSuccess();
//		Assert.assertEquals(true, isSuccess);
//		
//		User user = new User();
//		user.setCustomerId(cusId);
//		Page page = new Page();
//		target.getDefaultRule(user,page);
//	}

	/**
	 * ����һ�����Ի�ǩ��
	 * 
	 * @return
	 * @throws SignatureServiceException
	 */
	public HgSendrule savePersonalizedRule() throws SignatureServiceException {
		// ������һ��HgDiyInfo����
		String content = RandomUtil.getRandomSignature();

		HgDiyInfo hgDiyInfo = new HgDiyInfo();
		hgDiyInfo.setMessageTypeId(HgDiyInfo.FLASH);
		hgDiyInfo.setDiyInfoContent(content);
		hgDiyInfo.setCustomerId(customerIdSave);
		// �Ƿ�ʹ�ñ�־
		hgDiyInfo.setDiyInfoCurType(HgDiyInfo.UNUSED);

		// ������һ��HgSendrule����
		String sendruleSendperiodtime = "11:00-19:23";
		String calledNumbers = this.loginNameSave;
		String callingNumbers = RandomUtil.getRandomMobile();
		callingNumbers += "," + RandomUtil.getRandomMobile();

		HgSendrule hgSendrule = new HgSendrule();
		hgSendrule.setCustomerId(customerIdSave);
		hgSendrule.setIsDefault(0);
		hgSendrule.setSendruleName(HgSendrule.WEEKRULE);
		hgSendrule.setSendruleIfFlowcontrol(0);
		hgSendrule.setSendruleCallState(1);
		hgSendrule.setSendruleSendperiodtime(sendruleSendperiodtime);
		hgSendrule.setCalledNumbers(calledNumbers);
		hgSendrule.setCallingNumbers(callingNumbers);
		hgSendrule.setDiyInfo(hgDiyInfo);

		// ����
		Result result = target.createPersonalizedRule(hgSendrule);

		HgSendrule hgSendrule2 = (HgSendrule) result.getModel().get(
				"personalizedRule");

		return hgSendrule2;
	}
	
	//�����ظ�����
	//@Test
	public void testModifyPersonalizedRule2() throws SignatureServiceException{
		
		HgDiyInfo hgDiyInfo = new HgDiyInfo();
		hgDiyInfo.setDiyInfoContent("�۹���������");
		
		HgSendrule hgSendrule = new HgSendrule();
		hgSendrule.setId(1092);
		hgSendrule.setCustomerId(1014);
		hgSendrule.setCalledNumbers("13134741148");
		hgSendrule.setCallingNumbers("13426089999");
		hgSendrule.setSendruleWeeks("0000010");
		hgSendrule.setDiyInfo(hgDiyInfo);
		
		target.modifyPersonalizedRule(hgSendrule);
	}
}
