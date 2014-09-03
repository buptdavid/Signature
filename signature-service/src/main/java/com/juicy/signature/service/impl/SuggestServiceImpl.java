/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
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
 * @author ·����
 * @version <p>
 *          2011-8-11 ����
 *          </p>
 */
public class SuggestServiceImpl implements SuggestService {
	SuggestDao suggestDao;

	/** ��־��¼ */
	private static Log logger = LogFactory.getLog(SuggestServiceImpl.class);

	public Result createSuggest(User user, Suggest suggest)
			throws SignatureServiceException {
		Result result = Result.createRestult();

		// ����loginName
		String loginName = user.getLoginName();
		suggest.setLoginName(loginName);
		// ����ʱ��
		Date currentTime = new Date();
		suggest.setTime(currentTime);

		try {
			suggestDao.save(suggest);

			// ���صĽ��
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

		// ѭ��ɾ��
		Iterator<Suggest> it = suggestList.iterator();
		while (it.hasNext()) {
			Suggest suggest = it.next();
			try {
				suggestDao.delete(suggest.getId());

				// ���صĽ��
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
			// ȡ��������,��������Page����
			Integer totalRecords = suggestDao.findCountByTitle(title);
			page = PageUtil.createPage(page, totalRecords);

			// ��һ����¼������ÿҳ�ļ�¼����
			Integer offSet = page.getBeginIndex();
			Integer pageSize = page.getEveryPage();

			// ��ҳ����
			List<Suggest> suggestList = suggestDao.findByTitleForPage(title,
					offSet, pageSize);

			// ���صĽ��
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
