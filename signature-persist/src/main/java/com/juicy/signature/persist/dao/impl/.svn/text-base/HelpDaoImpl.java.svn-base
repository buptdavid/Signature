/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.juicy.signature.persist.dao.HelpDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.Help;

/**
 * HelpDao接口实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-7-29 创建
 *          </p>
 */
public class HelpDaoImpl extends JuicyHibernateDaoSupport implements HelpDao {

	public synchronized Integer save(Help help) throws SignaturePersistException {
		Integer id = super.getMaxId(Help.class.getName());
		help.setId(++id);
		return (Integer) getHibernateTemplate().save(help);
	}

	public Help getHelp() throws SignaturePersistException {
		List<Help> list = getHibernateTemplate().find("from Help");
		Iterator<Help> it = list.iterator();

		Help help = null;
		if (it.hasNext()) {
			help = it.next();
		}

		return help;
	}

	public void saveOrUpdate(String content) throws SignaturePersistException {
		Help help = this.getHelp();

		// 如果help为空则进行保存，否则进行更新
		if (help == null) {
			Help newHelp = new Help();
			newHelp.setHelpContent(content);
			this.save(newHelp);
		} else {
			help.setHelpContent(content);
			getHibernateTemplate().update(help);
		}

	}

}
