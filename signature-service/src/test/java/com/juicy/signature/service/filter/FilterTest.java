/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.filter;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.juicy.signature.service.BaseServiceTest;

/**
 * 敏感词过滤测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-10 创建
 *          </p>
 */
public class FilterTest extends BaseServiceTest {
	Filter target;
	
	@Before
	public void prepare(){
		target = (Filter) super.getCtx().getBean("filter");
	}
	
	@Test
	public void testIfContain(){
		String content = "打倒江泽民，打倒胡锦涛，法轮功万岁";
		String result = "江泽民,胡锦涛,法轮功";
		
		String result2 = target.contain(content);
		Assert.assertEquals(result, result2);
	}
}
