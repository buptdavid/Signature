/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */

package com.juicy.signature.service.filter;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.juicy.signature.service.BaseServiceTest;

/**
 * ���дʹ��˲�����
 * 
 * @author ·����
 * @version <p>
 *          2011-8-10 ����
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
		String content = "�򵹽����񣬴򵹺����Σ����ֹ�����";
		String result = "������,������,���ֹ�";
		
		String result2 = target.contain(content);
		Assert.assertEquals(result, result2);
	}
}
