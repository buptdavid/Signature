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
import com.juicy.signature.persist.po.Suggest;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * SuggestDao������
 * 
 * @author ·����
 * @version <p>
 *          2011-8-11 ����
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
		// ����N����¼
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
		// ����N����¼
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
