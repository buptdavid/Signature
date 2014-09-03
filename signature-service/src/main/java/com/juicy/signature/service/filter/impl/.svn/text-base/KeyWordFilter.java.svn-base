/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.filter.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.HgKeyWordDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgKeyWord;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.juicy.signature.service.filter.Filter;
import com.whirlycott.cache.Cache;
import com.whirlycott.cache.CacheException;
import com.whirlycott.cache.CacheManager;

/**
 * 关键字过滤实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-10 创建
 *          </p>
 *          <p>
 *          2011-11-24 增加缓存
 *          </p>
 */
public class KeyWordFilter implements Filter {
	/** 敏感字列表 */
	private List<String> keyWords;

	private HgKeyWordDao hgKeyWordDao;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(KeyWordFilter.class);

	public String contain(String content) {
		return this.check(keyList(), content);
	}

	/**
	 * 检查content中是否含有keyList中的词
	 * 
	 * @param keyList
	 *            敏感词列表
	 * @param content
	 *            要检查的内容
	 * @return 检查的结果。如果有返回包含的敏感词，否则返回null
	 */
	public String check(List<String> keyList, String content) {
		String containKeys = "";
		String key = "";
		for (int i = 0, j = keyList.size(); i < j; i++) {
			key = keyList.get(i);
			key.trim();
			if (content.indexOf(key) >= 0) {
				containKeys = containKeys + key;
				containKeys += ",";
			}
		}

		// 如果含有敏感词，则去掉最后的逗号
		if (containKeys.length() > 0) {
			containKeys = containKeys.substring(0, containKeys.length() - 1);
		}else{
			containKeys = null;
		}

		// 返回所包含的敏感词
		return containKeys;
	}

	public synchronized List<String> keyList() {

		try {
			// 取得敏感词缓存
			Cache cache = CacheManager.getInstance().getCache();
			keyWords = (List<String>) cache.retrieve("keyWord_content");

		if (keyWords == null) {
				if (keyWords == null) {
			keyWords = new ArrayList<String>();
			try {
				// 数据库中取得敏感词列表
				List<HgKeyWord> hgKeyWordList = hgKeyWordDao.findAll();
				Iterator<HgKeyWord> it = hgKeyWordList.iterator();

				// 循环加入
				while (it.hasNext()) {
					HgKeyWord hgKeyWord = it.next();
					keyWords.add(hgKeyWord.getKeyWordContent());
				}

			} catch (SignaturePersistException e) {
						logger.error("Unable to get keyword from DB", e);
			}
		}

				// 放入缓存
				cache.store("keyWord_content", keyWords);
			}
		} catch (CacheException e1) {
			logger.error("Unable to get keyWord_content from cache ", e1);
		}

		// 返回
		return keyWords;
	}

	public void addKeyWords(List<String> keyWordList) throws SignatureServiceException {
		// 如果敏感词列表为null，则从数据库中取得
		if (keyWords == null) {
			keyWords = this.keyList();
		}

		// 添加敏感词
		keyWords.addAll(keyWordList);

		// 更新缓存
		try {
			Cache cache = CacheManager.getInstance().getCache();
			cache.store("keyWord_content", keyWords);
		} catch (CacheException e) {
			logger.error("Unable to update keyWord_content from cache ", e);
			throw new SignatureServiceException("Unable to update keyWord_content from cache ", e);
	}
	}

	public void deleteKeyWords(List<String> keyWordList) throws SignatureServiceException {
		// 如果敏感词列表为null，则从数据库中取得
		if (keyWords == null) {
			keyWords = this.keyList();
		}

		// 删除敏感词
		keyWords.removeAll(keyWordList);

		// 更新缓存
		try {
			Cache cache = CacheManager.getInstance().getCache();
			cache.store("keyWord_content", keyWords);
		} catch (CacheException e) {
			logger.error("Unable to update keyWord_content from cache ", e);
			throw new SignatureServiceException("Unable to update keyWord_content from cache ", e);
	}
	}

	public HgKeyWordDao getHgKeyWordDao() {
		return hgKeyWordDao;
	}

	public void setHgKeyWordDao(HgKeyWordDao hgKeyWordDao) {
		this.hgKeyWordDao = hgKeyWordDao;
	}

	/**
	 * 对本类进行测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Filter filter = new KeyWordFilter();
		String content = "打倒江泽民，打倒胡锦涛，法轮功万岁";
		System.out.println(filter.contain(content));
	}

}