/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
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
import com.juicy.signature.persist.po.HgDiyInfo;
import com.juicy.signature.persist.po.HgSendrule;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * HgSendruleDao������
 * 
 * @author ·����
 * @version <p>
 *          2011-7-26 ����
 *          </p>
 */
public class HgSendruleDaoTest {

	HgSendruleDao target;

	ApplicationContext ctx;

	/**
	 * Ĭ�Ϲ��췽��
	 */
	public HgSendruleDaoTest() {
		ctx = BaseDaoTest.getInstance();
	}

	@Before
	public void prepare() {
		target = (HgSendruleDao) ctx.getBean("hgSendruleDao");
	}

	 @Test
	public void testGetById() throws SignaturePersistException {
		HgSendrule hgSendrule = this.save();
		Integer customerId = hgSendrule.getCustomerId();

		Integer id = hgSendrule.getId();

		HgSendrule hgSendrule2 = target.getById(id);
		Integer customerId2 = hgSendrule2.getCustomerId();

		Assert.assertEquals(customerId, customerId2);
	}

	 @Test
	public void testSave() throws SignaturePersistException {
		Integer customerId = RandomUtil.getRandomInteger();
		String sendruleSendperiodtime = "00:00-23:59";
		Integer diyInfoId = 100;

		HgSendrule hgSendrule = new HgSendrule();
		hgSendrule.setCustomerId(customerId);
		hgSendrule.setSendruleName(HgSendrule.DEFAULTRULE);
		hgSendrule.setSendruleIfFlowcontrol(0);
		hgSendrule.setSendruleCallState(1);
		hgSendrule.setSendruleSendperiodtime(sendruleSendperiodtime);
		HgDiyInfo diyInfo = new HgDiyInfo();
		diyInfo.setId(diyInfoId);
		hgSendrule.setDiyInfo(diyInfo);

		Integer id = target.save(hgSendrule);

		HgSendrule hgSendrule2 = target.getById(id);
		Integer customerId2 = hgSendrule2.getCustomerId();
		Integer diyInfoId2 = hgSendrule2.getDiyInfo().getId();

		Assert.assertEquals(diyInfoId, diyInfoId2);

	}

	 @Test
	public void testUpdate() throws SignaturePersistException {
		HgSendrule hgSendrule = this.save();

		Integer id = hgSendrule.getId();

		Integer customerId = RandomUtil.getRandomInteger();
		hgSendrule.setCustomerId(customerId);

		target.update(hgSendrule);

		HgSendrule hgSendrule2 = target.getById(id);
		Integer customerId2 = hgSendrule2.getCustomerId();

		Assert.assertEquals(customerId, customerId2);
	}

	 @Test
	public void testDeleteParaHgSendrule() throws SignaturePersistException {
		HgSendrule hgSendrule = this.save();
		Integer id = hgSendrule.getId();

		target.delete(hgSendrule);

		HgSendrule hgSendrule2 = target.getById(id);

		Assert.assertEquals(null, hgSendrule2);
	}

	 @Test
	public void testDeleteParaId() throws SignaturePersistException {
		HgSendrule hgSendrule = this.save();
		Integer id = hgSendrule.getId();

		target.delete(id);

		HgSendrule hgSendrule2 = target.getById(id);

		// ��֤
		Assert.assertEquals(null, hgSendrule2);
	}

	// @Test (lazy=false�󣬸÷������Իᱨ���������)
	public void testFindAll() throws SignaturePersistException {
		// ���ȱ���һ����¼
		this.save();

		List<HgSendrule> list = target.findAll();
		Iterator<HgSendrule> it = list.iterator();

		boolean isHasNext = it.hasNext();

		Assert.assertEquals(true, isHasNext);
	}

	 @Test
	public void testGetDefaultByCalledNumbers() throws SignaturePersistException {
		// ����һ����¼
		HgSendrule hgSendrule = this.save();
		Integer id = hgSendrule.getId();
		String calledNumbers = hgSendrule.getCalledNumbers();

		HgSendrule hgSendrule2 = target
				.getDefaultByCalledNumbers(calledNumbers);
		Integer id2 = hgSendrule2.getId();

		Assert.assertEquals(id, id2);
	}

	 @Test
	public void testGetPersonalizeByCalledNumbers() throws SignaturePersistException {
		// ����һ�����Ի����Լ�¼
		HgSendrule hgSendrule = this.savePersonalization();
		Integer id = hgSendrule.getId();
		String calledNumbers = hgSendrule.getCalledNumbers();

		List<HgSendrule> list = target
				.getPersonalizeByCalledNumbers(calledNumbers);
		Iterator<HgSendrule> it = list.iterator();

		Integer id2 = 0;
		if (it.hasNext()) {
			HgSendrule hgSendrule2 = it.next();
			id2 = hgSendrule2.getId();
		}

		Assert.assertEquals(id, id2);
	}

	@Test
	public void testGetPersonalizeCountByCalledNumbers() throws SignaturePersistException {
		//�ظ�����N����¼
		Integer N = 12;
		Integer customerId = RandomUtil.getRandomInteger();
		String sendruleSendperiodtime = "11:00-19:23";
		String calledNumbers = RandomUtil.getRandomMobile();

		for (int i = 0; i < N; i++) {
			HgSendrule hgSendrule = new HgSendrule();
			hgSendrule.setCustomerId(customerId);
			hgSendrule.setIsDefault(0);
			hgSendrule.setSendruleName(HgSendrule.DAYRULE);
			hgSendrule.setSendruleIfFlowcontrol(0);
			hgSendrule.setSendruleCallState(1);
			hgSendrule.setSendruleSendperiodtime(sendruleSendperiodtime);
			hgSendrule.setCalledNumbers(calledNumbers);

			target.save(hgSendrule);
		}
		
		Integer N2 = target.getPersonalizeCountByCalledNumbers(calledNumbers);
		Assert.assertEquals(N, N2);
	}

	 @Test
	public void testGetPersonalizeByCalledNumbersForPage() throws SignaturePersistException {
		// �ظ�����13�����Ի����Լ�¼
		Integer customerId = RandomUtil.getRandomInteger();
		String sendruleSendperiodtime = "11:00-19:23";
		String calledNumbers = RandomUtil.getRandomMobile();

		for (int i = 0; i < 13; i++) {
			HgSendrule hgSendrule = new HgSendrule();
			hgSendrule.setCustomerId(customerId);
			hgSendrule.setIsDefault(0);
			hgSendrule.setSendruleName(HgSendrule.DAYRULE);
			hgSendrule.setSendruleIfFlowcontrol(0);
			hgSendrule.setSendruleCallState(1);
			hgSendrule.setSendruleSendperiodtime(sendruleSendperiodtime);
			hgSendrule.setCalledNumbers(calledNumbers);
			hgSendrule.setCallingNumbers(String.valueOf(i));

			target.save(hgSendrule);
		}

		Integer pageSize = 10;
		int offSet = 2;

		List<HgSendrule> list = target.getPersonalizeByCalledNumbersForPage(
				calledNumbers, offSet, pageSize);
		Integer pageSize2 = list.size();

		Assert.assertEquals(pageSize, pageSize2);

		String callingNumbers = list.get(0).getCallingNumbers();

		Assert.assertEquals(String.valueOf(offSet), callingNumbers);

	}

	 @Test
	public void testGetDefaultByCustomerId() throws SignaturePersistException {
		HgSendrule hgSendrule = this.save();
		Integer customerId = hgSendrule.getCustomerId();
		String calledNumbers = hgSendrule.getCalledNumbers();

		HgSendrule hgSendrule2 = target.getDefaultByCustomerId(customerId);
		String calledNumbers2 = hgSendrule2.getCalledNumbers();

		Assert.assertEquals(calledNumbers, calledNumbers2);

	}
	
	@Test
	public void testGetPersonalizeCountByCustomerId() throws SignaturePersistException {
		//�ظ�����N����¼
		Integer N = 12;
		Integer customerId = RandomUtil.getRandomInteger();
		String sendruleSendperiodtime = "11:00-19:23";
		String calledNumbers = RandomUtil.getRandomMobile();

		for (int i = 0; i < N; i++) {
			HgSendrule hgSendrule = new HgSendrule();
			hgSendrule.setCustomerId(customerId);
			hgSendrule.setIsDefault(0);
			hgSendrule.setSendruleName(HgSendrule.DAYRULE);
			hgSendrule.setSendruleIfFlowcontrol(0);
			hgSendrule.setSendruleCallState(1);
			hgSendrule.setSendruleSendperiodtime(sendruleSendperiodtime);
			hgSendrule.setCalledNumbers(calledNumbers);

			target.save(hgSendrule);
		}
		
		Integer N2 = target.getPersonalizeCountByCustomerId(customerId);
		Assert.assertEquals(N, N2);
	}

	 @Test
	public void testGetPersonalizeByCustomerId() throws SignaturePersistException {
		HgSendrule hgSendrule = this.savePersonalization();
		Integer customerId = hgSendrule.getCustomerId();
		String calledNumbers = hgSendrule.getCalledNumbers();

		List<HgSendrule> list = target.getPersonalizeByCustomerId(customerId);
		Iterator<HgSendrule> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			if (calledNumbers.equals(it.next().getCalledNumbers())) {
				isHas = true;
			}
		}

		Assert.assertEquals(true, isHas);
	}

	 @Test
	public void testGetPersonalizeByCustomerIdForPage() throws SignaturePersistException {
		// �ظ�����13�����Ի����Լ�¼
		Integer customerId = RandomUtil.getRandomInteger();
		String sendruleSendperiodtime = "11:00-19:23";
		String calledNumbers = RandomUtil.getRandomMobile();

		for (int i = 0; i < 13; i++) {
			HgSendrule hgSendrule = new HgSendrule();
			hgSendrule.setCustomerId(customerId);
			hgSendrule.setIsDefault(0);
			hgSendrule.setSendruleName(HgSendrule.DAYRULE);
			hgSendrule.setSendruleIfFlowcontrol(0);
			hgSendrule.setSendruleCallState(1);
			hgSendrule.setSendruleSendperiodtime(sendruleSendperiodtime);
			hgSendrule.setCalledNumbers(calledNumbers);
			hgSendrule.setCallingNumbers(String.valueOf(i));

			target.save(hgSendrule);
		}

		Integer pageSize = 10;
		int offSet = 2;

		List<HgSendrule> list = target.getPersonalizeByCustomerIdForPage(
				customerId, offSet, pageSize);
		Integer pageSize2 = list.size();

		Assert.assertEquals(pageSize, pageSize2);

		String callingNumbers = list.get(0).getCallingNumbers();

		Assert.assertEquals(String.valueOf(offSet), callingNumbers);

	}

	/**
	 * ����һ��Ĭ�ϲ��Լ�¼
	 * 
	 * @return ������ϢMap����
	 * @throws SignaturePersistException 
	 */
	public HgSendrule save() throws SignaturePersistException {
		Integer customerId = RandomUtil.getRandomInteger();
		String sendruleSendperiodtime = "00:00-23:59";
		String calledNumbers = RandomUtil.getRandomMobile();

		HgSendrule hgSendrule = new HgSendrule();
		hgSendrule.setCustomerId(customerId);
		hgSendrule.setIsDefault(1);
		hgSendrule.setSendruleName(HgSendrule.DEFAULTRULE);
		hgSendrule.setSendruleIfFlowcontrol(0);
		hgSendrule.setSendruleCallState(1);
		hgSendrule.setSendruleSendperiodtime(sendruleSendperiodtime);
		hgSendrule.setCalledNumbers(calledNumbers);

		Integer id = target.save(hgSendrule);

		HgSendrule hgSendrule2 = target.getById(id);

		return hgSendrule2;
	}

	/**
	 * ����һ�����Ի����Լ�¼
	 * 
	 * @return ������ϢMap����
	 * @throws SignaturePersistException 
	 */
	public HgSendrule savePersonalization() throws SignaturePersistException {
		Integer customerId = RandomUtil.getRandomInteger();
		String sendruleSendperiodtime = "11:00-19:23";
		String calledNumbers = RandomUtil.getRandomMobile();

		HgSendrule hgSendrule = new HgSendrule();
		hgSendrule.setCustomerId(customerId);
		hgSendrule.setIsDefault(0);
		hgSendrule.setSendruleName(HgSendrule.DAYRULE);
		hgSendrule.setSendruleIfFlowcontrol(0);
		hgSendrule.setSendruleCallState(1);
		hgSendrule.setSendruleSendperiodtime(sendruleSendperiodtime);
		hgSendrule.setCalledNumbers(calledNumbers);

		Integer id = target.save(hgSendrule);

		HgSendrule hgSendrule2 = target.getById(id);

		return hgSendrule2;
	}
}
