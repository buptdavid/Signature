/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.HgKeyWordDao;
import com.juicy.signature.persist.dao.SignatureOriginalDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgKeyWord;
import com.juicy.signature.persist.po.SignatureOriginal;
import com.juicy.signature.service.AuditManage;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.filter.Filter;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;

/**
 * AuditManage接口实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          Oct 31, 2011 创建
 *          </p>
 */
public class AuditManageImpl implements AuditManage {

	private HgKeyWordDao hgKeyWordDao;

	private SignatureOriginalDao signatureOriginalDao;
	
	private Filter filter;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(AuditManageImpl.class);

	public Result viewKeyWord(String content, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 总数量
			Integer totalRecords = hgKeyWordDao.findCountByContent(content);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			// 分页查询结果
			List<HgKeyWord> keyWordList = hgKeyWordDao.findByContentForPage(
					content, offSet, pageSize);

			result.setSuccess(true);
			result.getModel().put("keyWordList", keyWordList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to view keyWord");
			throw new SignatureServiceException("Unable to view keyWord", e);
		}

		return result;
	}

	public Result createKeyWord(HgKeyWord keyword)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			String content = keyword.getKeyWordContent();
			List<HgKeyWord> keyWordList = hgKeyWordDao.findBycontent(content);

			Integer count = keyWordList.size();
			if (count > 0) {
				result.setRemark(content + " 已经存在！");
				return result;
			}

			// 保存
			hgKeyWordDao.save(keyword);
			
			// 增加缓存中的敏感词
			List<String> keyWords = new ArrayList<String>();
			keyWords.add(keyword.getKeyWordContent());
			filter.addKeyWords(keyWords);

			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to create keyWord");
			throw new SignatureServiceException("Unable to create keyWord", e);
		}

		return result;
	}

	public Result deleteKeyWord(List<HgKeyWord> keyWords)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Iterator<HgKeyWord> it = keyWords.iterator();
			while (it.hasNext()) {
				HgKeyWord deleteKeyword = it.next();
				hgKeyWordDao.delete(deleteKeyword.getId());

				//删除缓存中的敏感词
				List<String> keyWordList = new ArrayList<String>();
				keyWordList.add(deleteKeyword.getKeyWordContent());
				filter.deleteKeyWords(keyWordList);
				
				result.setSuccess(true);
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to delete keyWord");
			throw new SignatureServiceException("Unable to delete keyWord", e);
		}

		return result;
	}

	public Result modifyKeyWord(HgKeyWord keyword)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 取得该关键字
			HgKeyWord keyWord_1 = hgKeyWordDao.getById(keyword.getId());
			String content = keyword.getKeyWordContent();
			// 如果修改内容，则判断是否已经存在修改后的内容
			if (!keyWord_1.getKeyWordContent().equals(content)) {
				List<HgKeyWord> keyWordList = hgKeyWordDao
						.findBycontent(content);

				Integer count = keyWordList.size();
				if (count > 0) {
					result.setRemark(content + " 已经存在！");
					return result;
				}
			}

			// 更新
			String content_1 = keyWord_1.getKeyWordContent();
			keyWord_1.setKeyWordContent(content);
			keyWord_1.setKeyWordName(keyword.getKeyWordName());
			hgKeyWordDao.update(keyWord_1);
			
			
			//更新缓存中的敏感词
			List<String> deleteKeyWordList = new ArrayList<String>();
			deleteKeyWordList.add(content_1);			
			filter.deleteKeyWords(deleteKeyWordList);			
			List<String> addKeyWordList = new ArrayList<String>();
			addKeyWordList.add(content);			
			filter.addKeyWords(addKeyWordList);

			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to modify keyWord");
			throw new SignatureServiceException("Unable to modify keyWord", e);
		}

		return result;
	}

	public Result viewOriginal(Byte auditStatus, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			Integer totalRecords = signatureOriginalDao.findCountByClassId(
					null, null, auditStatus);

			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			List<SignatureOriginal> originalList = (List<SignatureOriginal>) signatureOriginalDao
					.findByClassIdForPage(null, null, auditStatus, offSet,
							pageSize);

			result.setSuccess(true);
			result.getModel().put("originalList", originalList);
			result.getModel().put("page", page);

		} catch (SignaturePersistException e) {
			logger.error("Unable to view original by auditStatus");
			throw new SignatureServiceException(
					"Unable to view original by auditStatus", e);
		}

		return result;
	}

	public Result setAuditStatus(List<Integer> originalIds, Byte auditStatus)
			throws SignatureServiceException {
		Result result = Result.createRestult();
		try {
			Iterator<Integer> it = originalIds.iterator();
			while (it.hasNext()) {
				Integer originalId = it.next();

				// 取得该对象
				SignatureOriginal original = signatureOriginalDao
						.getById(originalId);

				// 设置审核状态和修改时间
				original.setAuditStatus(auditStatus);
				original.setMdfTime(new Date());

				// 更新
				signatureOriginalDao.update(original);

				result.setSuccess(true);
			}
		} catch (SignaturePersistException e) {
			logger.error("Unable to set auditStatus by original");
			throw new SignatureServiceException(
					"Unable to set auditStatus by original", e);
		}

		return result;
	}

	public HgKeyWordDao getHgKeyWordDao() {
		return hgKeyWordDao;
	}

	public void setHgKeyWordDao(HgKeyWordDao hgKeyWordDao) {
		this.hgKeyWordDao = hgKeyWordDao;
	}

	public SignatureOriginalDao getSignatureOriginalDao() {
		return signatureOriginalDao;
	}

	public void setSignatureOriginalDao(
			SignatureOriginalDao signatureOriginalDao) {
		this.signatureOriginalDao = signatureOriginalDao;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}
	
	

}
