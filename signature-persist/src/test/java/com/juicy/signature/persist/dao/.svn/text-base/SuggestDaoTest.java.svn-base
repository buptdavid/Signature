/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
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
import com.juicy.signature.persist.po.Suggest;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * SuggestDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-11 创建
 *          </p>
 */
public class SuggestDaoTest {
	SuggestDao target;

	ApplicationContext ctx;

	public SuggestDaoTest() {
		ctx = BaseDaoTest.getInstance();
	}

	@Before
	public void prepare() {
		target = (SuggestDao) ctx.getBean("suggestDao");

	}

	@Test
	public void testFindCountByTitle() throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;
		String loginName = RandomUtil.getRandomMobile();
		String title = RandomUtil.getRandomMobile();
		String content = RandomUtil.getRandomSignature();
		Date time = new Date();

		for (int i = 0; i < N; i++) {
			Suggest suggest = new Suggest();
			suggest.setLoginName(loginName);
			suggest.setTitle(title);
			suggest.setContent(content);
			suggest.setTime(time);
			
			target.save(suggest);
		}

		Integer N2 = target.findCountByTitle(title);

		Assert.assertEquals(N, N2);
	}

	@Test
	public void testFindByTitleForPage() throws SignaturePersistException {
		// 保存N条记录
		Integer N = 14;
		String loginName = RandomUtil.getRandomMobile();
		String title = RandomUtil.getRandomMobile();
		String content = RandomUtil.getRandomSignature();
		Date time = new Date();

		for (int i = 0; i < N; i++) {
			Suggest suggest = new Suggest();
			suggest.setLoginName(loginName);
			suggest.setTitle(title + String.valueOf(i));
			suggest.setContent(content);
			suggest.setTime(time);
			
			target.save(suggest);
		}

		Integer offSet = 2;
		Integer pageSize = 10;

		List<Suggest> suggestList = target.findByTitleForPage(title, offSet,
				pageSize);

		Integer pageSize2 = suggestList.size();
		String title2 = suggestList.get(0).getTitle();
		title2 = title2.substring(title2.length() - 1, title2.length());

		Integer offSet2 = Integer.valueOf(title2);
		Assert.assertEquals(offSet, offSet2);

	}

}
