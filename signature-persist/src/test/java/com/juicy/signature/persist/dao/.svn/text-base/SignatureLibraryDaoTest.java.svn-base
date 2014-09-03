/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.SignatureClass;
import com.juicy.signature.persist.po.SignatureLibrary;
import com.juicy.signature.persist.util.RandomUtil;

/**
 * SignatureLibraryDao测试类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-28 创建
 *          </p>
 */
public class SignatureLibraryDaoTest {

	SignatureLibraryDao target;

	ApplicationContext ctx;

	Integer classIdSave;

	public SignatureLibraryDaoTest() {
		ctx = BaseDaoTest.getInstance();
	}

	@Before
	public void prepare() throws SignaturePersistException {
		target = (SignatureLibraryDao) ctx.getBean("signatureLibraryDao");

		// 保存一个SignatureClass对象
		SignatureClassDao signatureClassDao = (SignatureClassDao) ctx
				.getBean("signatureClassDao");

		String first = RandomUtil.getFirstCLass();
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setBasis(SignatureClass.LIBRARY);
		signatureClass.setName(first);
		signatureClass.setParentId(0);
		signatureClassDao.save(signatureClass);

		Integer firstId = signatureClass.getId();

		// 保存二级分类
		String second = RandomUtil.getSecondCLass();
		SignatureClass signatureClass2 = new SignatureClass();
		signatureClass2.setBasis(SignatureClass.LIBRARY);
		signatureClass2.setName(second);
		signatureClass2.setParentId(firstId);

		classIdSave = signatureClassDao.save(signatureClass2);

	}

	@Test
	public void testGetById() throws SignaturePersistException {
		SignatureLibrary signatureLibrary = this.save();
		Integer id = signatureLibrary.getId();
		String content = signatureLibrary.getContent();

		SignatureLibrary signatureLibrary2 = target.getById(id);
		String content2 = signatureLibrary2.getContent();

		Assert.assertEquals(content, content2);
	}

	@Test
	public void testSave() throws SignaturePersistException {
		Integer classId = classIdSave;
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setId(classId);

		String content = RandomUtil.getRandomSignature();

		SignatureLibrary signatureLibrary = new SignatureLibrary();
		signatureLibrary.setSignatureClass(signatureClass);
		signatureLibrary.setContent(content);

		Integer id = target.save(signatureLibrary);

		SignatureLibrary signatureLibrary2 = target.getById(id);
		String content2 = signatureLibrary2.getContent();

		Assert.assertEquals(content, content2);
	}

	@Test
	public void testUpdate() throws SignaturePersistException {
		SignatureLibrary signatureLibrary = this.save();

		Integer id = signatureLibrary.getId();
		String content = RandomUtil.getRandomSignature();
		signatureLibrary.setContent(content);

		target.update(signatureLibrary);

		SignatureLibrary signatureLibrary2 = target.getById(id);
		String content2 = signatureLibrary2.getContent();

		Assert.assertEquals(content, content2);
	}

	@Test
	public void testDeleteParaSignatureLibrary()
			throws SignaturePersistException {
		SignatureLibrary signatureLibrary = this.save();

		Integer id = signatureLibrary.getId();

		target.delete(signatureLibrary);

		SignatureLibrary signatureLibrary2 = target.getById(id);

		Assert.assertEquals(null, signatureLibrary2);
	}

	@Test
	public void testDeleteParaId() throws SignaturePersistException {
		SignatureLibrary signatureLibrary = this.save();

		Integer id = signatureLibrary.getId();
		target.delete(id);

		SignatureLibrary signatureLibrary2 = target.getById(id);

		Assert.assertEquals(null, signatureLibrary2);
	}

	@Test
	public void testFindAll() throws SignaturePersistException {
		this.save();

		List<SignatureLibrary> list = target.findAll();
		Iterator<SignatureLibrary> it = list.iterator();

		boolean isNext = it.hasNext();

		Assert.assertEquals(true, isNext);
	}

	@Test
	public void testFindByClassId() throws SignaturePersistException {
		SignatureLibrary signatureLibrary = this.save();

		Integer id = signatureLibrary.getId();
		Integer classId = signatureLibrary.getSignatureClass().getId();

		List<SignatureLibrary> list = target.findByClassId(classId);
		Iterator<SignatureLibrary> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			if (id.equals(it.next().getId())) {
				isHas = true;
			}
		}

		Assert.assertEquals(true, isHas);

	}

	@Test
	public void testFindCountByClassId() throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;

		Integer classId = classIdSave;

		for (int i = 0; i < N; i++) {

			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(classId);

			String content = "aa";

			SignatureLibrary signatureLibrary = new SignatureLibrary();
			signatureLibrary.setSignatureClass(signatureClass);
			signatureLibrary.setContent(content);
			target.save(signatureLibrary);
		}

		Integer N2 = target.findCountByClassId(classId, null);
		Assert.assertEquals(N, N2);
	}

	@Test
	public void testFindByClassIdForPage() throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;

		Integer classId = classIdSave;

		for (int i = 0; i < N; i++) {

			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(classId);

			SignatureLibrary signatureLibrary = new SignatureLibrary();
			signatureLibrary.setSignatureClass(signatureClass);
			signatureLibrary.setContent(String.valueOf(i));
			target.save(signatureLibrary);
		}

		Integer offSet = 2;
		Integer pageSize = 10;

		List<SignatureLibrary> list = target.findByClassIdForPage(classId,
				offSet, pageSize, null);
		Integer pageSize2 = list.size();

		Assert.assertEquals(pageSize, pageSize2);

		Integer offSet2 = Integer.valueOf(list.get(0).getContent());

		Assert.assertEquals(offSet, offSet2);

	}

	@Test
	public void testFindByClassIdList() throws SignaturePersistException {
		SignatureLibrary signatureLibrary = this.save();
		Integer id = signatureLibrary.getId();
		Integer classId = signatureLibrary.getSignatureClass().getId();

		List<Integer> classIdList = new ArrayList<Integer>();
		classIdList.add(classId);
		classIdList.add(12);

		List<SignatureLibrary> list = target.findByClassIdList(classIdList);
		Iterator<SignatureLibrary> it = list.iterator();

		boolean isHas = false;
		while (it.hasNext()) {
			if (id.equals(it.next().getId())) {
				isHas = true;
			}
		}

		Assert.assertEquals(true, isHas);

	}

	@Test
	public void testFindCount() throws SignaturePersistException {
		// 保存N条记录
		Integer N = 13;

		Integer classId = classIdSave;
		String content = RandomUtil.getRandomMobile();

		for (int i = 0; i < N; i++) {

			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(classId);
			SignatureLibrary signatureLibrary = new SignatureLibrary();
			signatureLibrary.setSignatureClass(signatureClass);
			signatureLibrary.setContent(content + String.valueOf(i));
			target.save(signatureLibrary);
		}

		Integer N2 = target.findCount(content);
		Assert.assertEquals(N, N2);
	}

	@Test
	public void testFindForPage() throws SignaturePersistException {
		// 保存N条记录
		Integer N = 14;

		Integer classId = classIdSave;
		String content = RandomUtil.getRandomMobile();

		for (int i = 0; i < N; i++) {

			SignatureClass signatureClass = new SignatureClass();
			signatureClass.setId(classId);

			SignatureLibrary signatureLibrary = new SignatureLibrary();
			signatureLibrary.setSignatureClass(signatureClass);
			signatureLibrary.setContent(content + String.valueOf(i));
			target.save(signatureLibrary);
		}

		Integer offSet = 2;
		Integer pageSize = 10;

		List<SignatureLibrary> list = target.findForPage(offSet, pageSize,
				content );
		Integer pageSize2 = list.size();

		// Assert.assertEquals(pageSize, pageSize2);

		String content2 = list.get(0).getContent();
		Integer offSet2 = Integer.valueOf(content2.substring(
				content2.length() - 1, content2.length()));

		Assert.assertEquals(offSet, offSet2);

	}

	/**
	 * 保存一条记录
	 * 
	 * @return 保存的SignatureLibrary实例
	 * @throws SignaturePersistException
	 */
	public SignatureLibrary save() throws SignaturePersistException {
		Integer classId = classIdSave;
		SignatureClass signatureClass = new SignatureClass();
		signatureClass.setId(classId);

		String content = RandomUtil.getRandomSignature();

		SignatureLibrary signatureLibrary = new SignatureLibrary();
		signatureLibrary.setSignatureClass(signatureClass);
		signatureLibrary.setContent(content);

		Integer id = target.save(signatureLibrary);

		SignatureLibrary signatureLibrary2 = target.getById(id);
		return signatureLibrary2;
	}
}
