/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Activity;
import com.juicy.signature.persist.po.HgCustomer;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * ActivityDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 28, 2011 创建
 *          </p>
 */
public class ActivityDaoTest {

	ActivityDao target;

	ApplicationContext ctx;

	// 存在的CustomerId
	Integer customerId = 1095;
	HgCustomer customer = new HgCustomer();

	public ActivityDaoTest() {
		ctx = BaseDaoTest.getInstance();
	}

	@Before
	public void prepare() throws SignaturePersistException {
		target = (ActivityDao) ctx.getBean("activityDao");
		customer.setId(customerId);
	}

	// @Test
	public void testSave() throws SignaturePersistException {
		String name = RandomUtil.getRandomString(10);
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_MONTH, 10);

		Activity activity = new Activity();
		activity.setCustomer(customer);
		activity.setStartTime(new Date());
		activity.setEndTime(now.getTime());
		activity.setTime(new Date());
		activity.setName(name);
		Integer targetId = target.save(activity);

		Activity activity_1 = target.getById(targetId);
		String name_1 = activity_1.getName();

		Assert.assertEquals(name, name_1);
	}

	//@Test
	public void testDeleteFlag() throws SignaturePersistException {
		Activity activity = this.saveActivity();
		
		//置删除标志位
		target.deleteFlag(activity);
		
		Activity activity_1 = target.getById(activity.getId());
		boolean isDelete = activity_1.isIsDelete();
		
		Assert.assertEquals(true, isDelete);
		
		//再次置成未删除
		activity.setIsDelete(false);
		target.update(activity);

	}
	
	//@Test
	public void testFindCount() throws SignaturePersistException{
		Activity activity = this.saveActivity();
		
		//置删除
		target.deleteFlag(activity);
		
		//
		Integer count = target.findCount(null, null, true);
		Assert.assertEquals(new Integer(1), count);
		
		activity.setIsDelete(false);
		target.update(activity);
	}
	
	
	
	/**
	 * 保存一个Activity
	 * 
	 * @return 保存的Activity实例
	 * @throws SignaturePersistException
	 */
	private Activity saveActivity() throws SignaturePersistException{
		String name = RandomUtil.getRandomString(10);
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_MONTH, 10);

		Activity activity = new Activity();
		activity.setCustomer(customer);
		activity.setStartTime(new Date());
		activity.setEndTime(now.getTime());
		activity.setTime(new Date());
		activity.setName(name);
		Integer targetId = target.save(activity);
		
		return activity;
	}

}
