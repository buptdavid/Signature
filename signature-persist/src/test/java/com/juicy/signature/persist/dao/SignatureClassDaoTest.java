/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
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
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * SignatureClassDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-27 创建
 *          </p>
 */
public class SignatureClassDaoTest {

	SignatureClassDao target;
	
	ApplicationContext ctx;
	
	public SignatureClassDaoTest(){
		ctx = BaseDaoTest.getInstance();
	}

	@Before
	public void prepare() {
		target = (SignatureClassDao) ctx.getBean("signatureClassDao");
	}

	@Test
	public void testGetById() throws SignaturePersistException {
		SignatureClass signatureClass = this.save(SignatureClass.ORIGINAL, false);
		Integer id = signatureClass.getId();
		String name = signatureClass.getName();
		
		SignatureClass signatureClass2 = target.getById(id);
		String name2 = signatureClass2.getName();
		
		Assert.assertEquals(name, name2);
		
	}
	
	@Test
	public void testSave() throws SignaturePersistException{
		SignatureClass signatureClass = this.save(SignatureClass.LIBRARY, true);
		Integer id = signatureClass.getId();
		String name = signatureClass.getName();
		
		SignatureClass signatureClass2 = target.getById(id);
		String name2 = signatureClass2.getName();
		
		Assert.assertEquals(name, name2);
	}

	@Test
	public void testUpdate() throws SignaturePersistException{
		SignatureClass signatureClass = this.save(SignatureClass.ORIGINAL, false);
		
		Integer id = signatureClass.getId();
		String name = RandomUtil.getFirstCLass();
		signatureClass.setName(name);
		
		target.update(signatureClass);
		
		SignatureClass signatureClass2 = target.getById(id);
		String name2 = signatureClass2.getName();
		
		Assert.assertEquals(name, name2);
	}
	
	@Test
	public void testDeleteParaSignatureClass() throws SignaturePersistException{
		SignatureClass signatureClass = this.save(SignatureClass.ORIGINAL, false);
		Integer id = signatureClass.getId();
		target.delete(signatureClass);
		
		SignatureClass signatureClass2 = target.getById(id);
		Assert.assertEquals(null, signatureClass2);
	}
	
	@Test
	public void testDeleteParaId() throws SignaturePersistException{
		SignatureClass signatureClass = this.save(SignatureClass.LIBRARY, false);
		Integer id = signatureClass.getId();
		
		target.delete(id);
		
		SignatureClass signatureClass2 = target.getById(id);
		
		Assert.assertEquals(null, signatureClass2);
	}
	
	@Test
	public void testFindAll() throws SignaturePersistException{
		SignatureClass signatureClass = this.save(SignatureClass.LIBRARY, false);
		
		List<SignatureClass> list = target.findAll();
		Iterator<SignatureClass> it = list.iterator();
		
		boolean isNext = it.hasNext();
		
		Assert.assertEquals(true, isNext);
	}
	
	@Test 
	public void testFindAllFirstByBasis() throws SignaturePersistException{
		Byte basis = SignatureClass.LIBRARY;
		
		SignatureClass signatureClass = this.save(basis, false);
		
		Iterator<SignatureClass> it = target.findAllFirstByBasis(basis).iterator();
		
		boolean isNext = it.hasNext();
		
		Assert.assertEquals(true, isNext);
	}
	
	@Test
	public void testFindAllSecondByBasis() throws SignaturePersistException{
		Byte basis = SignatureClass.ORIGINAL;
		
		SignatureClass signatureClass = this.save(basis, true);
		
		Iterator<SignatureClass> it = target.findAllSecondByBasis(basis).iterator();
		
		boolean isNext = it.hasNext();
		
		Assert.assertEquals(true, isNext);
	}
	
	@Test
	public void testFindSecondForFirst() throws SignaturePersistException{
		Byte basis = SignatureClass.LIBRARY;
		
		SignatureClass signatureClass = this.save(basis, true);
		Integer id = signatureClass.getId();
		Integer firstId = signatureClass.getParentId();
		
		List<SignatureClass> list = target.findSecondForFirst(firstId);
		Iterator<SignatureClass> it = list.iterator();
		
		Integer id2 = 0;
		if(it.hasNext()){
			id2 = it.next().getId();
		}
		
		Assert.assertEquals(id, id2);
		
	}
	
	@Test
	public void testFindSecondCountByFirstId() throws SignaturePersistException{
		Integer totalNum = target.findSecondCountByFirstId(SignatureClass.LIBRARY, null, null);
		
		Assert.assertNotNull(totalNum);
	}
	
	/**
	 * 保存一条记录
	 * 
	 * @param basis
	 *            分类依据
	 * @param isSecond
	 *            是否二级分类 1:是；0：不是
	 * 
	 * @return 保存的记录SignatureClass对象实例
	 * @throws SignaturePersistException 
	 */
	public SignatureClass save(Byte basis, boolean isSecond) throws SignaturePersistException {
		// 首先保存一个一级分类
		String first = RandomUtil.getFirstCLass();
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setBasis(basis);
		signatureClass.setName(first);
		signatureClass.setParentId(0);

		Integer firstId = target.save(signatureClass);
		
		SignatureClass result = target.getById(firstId);
				
		if (isSecond) {
			String second = RandomUtil.getSecondCLass();
			SignatureClass signatureClass2 = new SignatureClass();
			signatureClass2.setBasis(basis);
			signatureClass2.setName(second);
			signatureClass2.setParentId(firstId);
			Integer secondId = target.save(signatureClass2);
			
			result = target.getById(secondId);
		} 

		return result;
	}
}
