/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgKeyWord;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * HgKeyWordDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-10 创建
 *          </p>
 */
public class HgKeyWordDaoTest {
	HgKeyWordDao target;

	ApplicationContext ctx;

	public HgKeyWordDaoTest() {
		ctx = BaseDaoTest.getInstance();
	}

	@Before
	public void prepare() {
		target = (HgKeyWordDao) ctx.getBean("hgKeyWordDao");
	}

	@Test
	public void testFindCountByContent() throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;
		String content = RandomUtil.getRandomMobile();

		for (int i = 0; i < N; i++) {
			HgKeyWord hgKeyWord = new HgKeyWord();
			hgKeyWord.setKeyWordName(content + String.valueOf(i));
			hgKeyWord.setKeyWordContent(content + String.valueOf(i));
			target.save(hgKeyWord);
		}

		Integer N2 = target.findCountByContent(content);
		Assert.assertEquals(N, N2);
	}

	@Test
	public void testFindByContentForPage() throws SignaturePersistException {
		// 保存N条记录
		Integer N = 14;
		String content = RandomUtil.getRandomMobile();

		for (int i = 0; i < N; i++) {
			HgKeyWord hgKeyWord = new HgKeyWord();
			hgKeyWord.setKeyWordName(content + String.valueOf(i));
			hgKeyWord.setKeyWordContent(content + String.valueOf(i));
			target.save(hgKeyWord);
		}

		Integer offSet = 2;
		Integer pageSize = 10;

		List<HgKeyWord> hgKeyWordList = target.findByContentForPage(content,
				offSet, pageSize);

		Integer pageSize2 = hgKeyWordList.size();
//		Assert.assertEquals(pageSize, pageSize2);

		String content2 = hgKeyWordList.get(0).getKeyWordContent();
		content2 = content2.substring(content2.length()-1, content2.length());
		Integer offSet2 = Integer.valueOf(content2);
		Assert.assertEquals(offSet, offSet2);
	}
}
