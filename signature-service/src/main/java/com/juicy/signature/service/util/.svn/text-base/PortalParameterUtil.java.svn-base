/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.service.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.juicy.signature.persist.dao.PortalDao;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Portal;
import com.juicy.signature.service.exception.SignatureServiceException;
import com.whirlycott.cache.Cache;
import com.whirlycott.cache.CacheException;
import com.whirlycott.cache.CacheManager;

/**
 * 
 * 
 * @author 路卫杰
 * @version <p>
 *          Nov 28, 2011 创建
 *          </p>
 */
public class PortalParameterUtil implements ParameterUtil {

	private PortalDao portalDao;

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(PortalParameterUtil.class);

	public Object getParameter(String parameterName) throws SignatureServiceException {
		Portal portal = null;
		try {
			// 缓存
			Cache cache = CacheManager.getInstance().getCache();

			portal = (Portal) cache.retrieve(parameterName);

			if (portal == null) {
				// 从数据库中取得
				portal = portalDao.findPortal();

				// 放入缓存
				cache.store(parameterName, portal);
			}

		} catch (CacheException e) {
			logger.error("Unable to get parameter from Cache for " + parameterName);
			throw new SignatureServiceException("Unable to get parameter from Cache for " + parameterName, e);
		} catch (SignaturePersistException e1) {
			logger.error("Unable to get parameter from DB for " + parameterName);
			throw new SignatureServiceException("Unable to get parameter from DB for " + parameterName, e1);
		}

		return portal;
	}

	public PortalDao getPortalDao() {
		return portalDao;
	}

	public void setPortalDao(PortalDao portalDao) {
		this.portalDao = portalDao;
	}

}
