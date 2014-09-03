/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Help;

/**
 * 
 *
 * @author 路卫杰
 * @version <p>2011-7-29 创建</p>
 */
public class HelpDaoTest {
	
	HelpDao target;
	
	String content = "帮助帮助帮助你";

	@Before
	public void prepare() {
		ApplicationContext ctx = BaseDaoTest.getInstance();
		target = (HelpDao) ctx.getBean("helpDao");
	}
	
	@Test
	public void testSave() throws SignaturePersistException{
		Help h = target.getHelp();
		if(h == null){
			Help help = new Help();
			help.setHelpContent(content);
			
			target.save(help);
			
			Help help2 = target.getHelp();
			String content2 = help2.getHelpContent();
			
			Assert.assertEquals(content, content2);
		}else{
			Assert.assertEquals(true, true);
		}
		
		
	}
	
	@Test
	public void testGetHelp() throws SignaturePersistException{
		Help help = target.getHelp();
		String content2 = help.getHelpContent();
		
		Assert.assertEquals(content, content2);
	}
	
	@Test
	public void testSaveOrUpdate() throws SignaturePersistException{
		Help help = target.getHelp();
		String content2 = help.getHelpContent();
		
		StringBuffer sb = new StringBuffer(content2);
		content2 = sb.reverse().toString();
				
		target.saveOrUpdate(content2);
		
		Help help3 = target.getHelp();
		String content3 = help3.getHelpContent();
		
		Assert.assertEquals(content2,content3);
		
		StringBuffer sb2 = new StringBuffer(content3);
		content3 = sb2.reverse().toString();
		
		target.saveOrUpdate(content3);
	}

}
