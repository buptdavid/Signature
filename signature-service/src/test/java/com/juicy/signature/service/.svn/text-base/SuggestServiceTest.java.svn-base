/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.juicy.signature.persist.po.Suggest;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * SuggestService测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-11 创建
 *          </p>
 */
public class SuggestServiceTest extends BaseServiceTest {
	SuggestService target;

	@Before
	public void prepare() {
		target = (SuggestService) super.getCtx().getBean("suggestService");
	}

	@Test
	public void testCreateSuggest() throws SignatureServiceException {
		String loginName = RandomUtil.getRandomMobile();
		User user = new User();
		user.setLoginName(loginName);

		String title = RandomUtil.getRandomMobile();

		Suggest suggest = new Suggest();
		suggest.setTitle(title);

		Result result = target.createSuggest(user, suggest);
		boolean isSuccess = result.isSuccess();

		Assert.assertEquals(true, isSuccess);
	}

	@Test
	public void testDeleteSuggest() throws SignatureServiceException {
		// 保存N个
		int N = 10;
		List<Suggest> suggestList = new ArrayList<Suggest>();

		for (int i = 0; i < N; i++) {
			String loginName = RandomUtil.getRandomMobile();
			User user = new User();
			user.setLoginName(loginName);

			String title = RandomUtil.getRandomMobile();

			Suggest suggest = new Suggest();
			suggest.setTitle(title);

			target.createSuggest(user, suggest);

			suggestList.add(suggest);
		}

		Result result = target.deleteSuggest(suggestList);
		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);
	}

	@Test
	public void testViewSuggest() throws SignatureServiceException {
		// 保存N个
		int N = 14;
		String title = RandomUtil.getRandomMobile();

		for (int i = 0; i < N; i++) {
			String loginName = RandomUtil.getRandomMobile();
			User user = new User();
			user.setLoginName(loginName);

			Suggest suggest = new Suggest();
			suggest.setTitle(title + String.valueOf(i));

			target.createSuggest(user, suggest);
		}

		// Page对象设置
		Integer currentPage = 1;
		Integer everyPage = 10;
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setEveryPage(everyPage);

		Result result = target.viewSuggest(title, page);

		boolean isSuccess = result.isSuccess();
		Assert.assertEquals(true, isSuccess);

		List<Suggest> suggestList = (List<Suggest>) result.getModel().get(
				"suggestList");

		Integer everyPage2 = suggestList.size();
		Assert.assertEquals(everyPage, everyPage2);

		String title2 = suggestList.get(0).getTitle();
		title2 = title2.substring(title2.length() - 1, title2.length());
		Integer currentPage2 = Integer.valueOf(title2);
		currentPage2++;

		Assert.assertEquals(currentPage, currentPage);

	}

}
