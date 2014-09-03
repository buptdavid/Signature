/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.SuggestDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Suggest;
import com.juicy.signature.service.SuggestService;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.page.Page;
import com.juicy.signature.service.page.PageUtil;
import com.juicy.signature.service.result.Result;
import com.juicy.signature.service.session.User;

/**
 * 
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-11 创建
 *          </p>
 */
public class SuggestServiceImpl implements SuggestService {
	SuggestDao suggestDao;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(SuggestServiceImpl.class);

	public Result createSuggest(User user, Suggest suggest)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 设置loginName
		String loginName = user.getLoginName();
		suggest.setLoginName(loginName);
		// 设置时间
		Date currentTime = new Date();
		suggest.setTime(currentTime);

		try {
			suggestDao.save(suggest);

			// 返回的结果
			result.setSuccess(true);
		} catch (SignaturePersistException e) {
			logger.error("Unable to create suggest for user: " + loginName, e);
			throw new SignatureServiceException(
					"Unable to create suggest for user: " + loginName, e);
		}

		return result;
	}

	public Result deleteSuggest(List<Suggest> suggestList)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// 循环删除
		Iterator<Suggest> it = suggestList.iterator();
		while (it.hasNext()) {
			Suggest suggest = it.next();
			try {
				suggestDao.delete(suggest.getId());

				// 返回的结果
				result.setSuccess(true);
			} catch (SignaturePersistException e) {
				logger.error("Unable to delete suggest", e);
				throw new SignatureServiceException("Unable to delete suggest",
						e);
			}
		}

		return result;
	}

	public Result viewSuggest(String title, Page page)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		try {
			// 取得总数量,并新生成Page对象
			Integer totalRecords = suggestDao.findCountByTitle(title);
			page = PageUtil.createPage(page, totalRecords);

			// 第一条记录索引和每页的记录数量
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			// 分页查找
			List<Suggest> suggestList = suggestDao.findByTitleForPage(title,
					offSet, pageSize);

			// 返回的结果
			result.setSuccess(true);
			result.getModel().put("suggestList", suggestList);
			result.getModel().put("page", page);
		} catch (SignaturePersistException e) {
			logger.error("Unable to get suggess", e);
			throw new SignatureServiceException("Unable to get suggess", e);
		}

		return result;
	}

	public SuggestDao getSuggestDao() {
		return suggestDao;
	}

	public void setSuggestDao(SuggestDao suggestDao) {
		this.suggestDao = suggestDao;
	}

}
