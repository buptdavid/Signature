/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.po.Recommend;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * RecommendDao������
 *
 * @author ·����
 * @version <p>Oct 28, 2011 ����</p>
 */
public class RecommendDaoTest {
	
	RecommendDao target;
	
	ApplicationContext ctx;

	// ���ڵ�CustomerId
	Integer customerId = 1095;
	HgCustomer customer = new HgCustomer();
	
	public RecommendDaoTest() {
		ctx = BaseDaoTest.getInstance();
		customer.setId(customerId);
	}
	
	@Before
	public void prepare() throws SignaturePersistException {
		target = (RecommendDao) ctx.getBean("recommendDao");
		customer.setId(customerId);
	}
	
	@Test
	public void testSave() throws SignaturePersistException{
		Integer classId = RandomUtil.getRandomInteger();
		String content = RandomUtil.getRandomString(10);
		Recommend recommend = new Recommend();
		recommend.setClassId(classId);
		recommend.setContent(content);
		recommend.setClassName("����");
		recommend.setTime(new Date());
		recommend.setCustomer(customer);
		recommend.setParentId(0);
		recommend.setSource(Recommend.SOURCE_LIBRARY);
		
		target.save(recommend);
		
		Recommend recommend_1 = target.getById(recommend.getId());
		
		String content_1 = recommend_1.getContent();
		Assert.assertEquals(content, content_1);
	}
	
	//@Test
	public void testFindCount() throws SignaturePersistException{
		Recommend recommend = this.saveRecommend();
		Integer classId = recommend.getClassId();
		Integer parentId = recommend.getParentId();
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setId(classId);
		signatureClass.setParentId(parentId);
		
		Integer count = target.findCount(signatureClass, Recommend.SOURCE_ORIGINAL, false);
		
		Assert.assertEquals(new Integer(1), count);
	}
	
	//@Test
	public void testFindBySource() throws SignaturePersistException{
		Integer count = 4;
		List<Recommend> recommend = target.findBySource(Recommend.SOURCE_ORIGINAL, count);
		
		Integer count_1 = recommend.size();
		Assert.assertEquals(count, count_1);
		
	}
	
	/**
	 * ����Recommend
	 * 
	 * @return
	 * @throws SignaturePersistException
	 */
	private Recommend saveRecommend() throws SignaturePersistException{
		Integer classId = RandomUtil.getRandomInteger();
		String content = RandomUtil.getRandomString(10);
		Recommend recommend = new Recommend();
		recommend.setClassId(classId);
		recommend.setContent(content);
		recommend.setClassName("����");
		recommend.setTime(new Date());
		recommend.setCustomer(customer);
		recommend.setParentId(0);
		recommend.setSource(Recommend.SOURCE_ORIGINAL);
		
		target.save(recommend);
		
		return recommend;
	}
	
}
