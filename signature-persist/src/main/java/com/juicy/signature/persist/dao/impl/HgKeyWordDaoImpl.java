/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.juicy.signature.persist.dao.HgKeyWordDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.HgKeyWord;

/**
 * HgKeyWordDao实现类
 * 
 * @author 路卫杰
 * @version <p>
 *          2011-8-10 创建
 *          </p>
 */
public class HgKeyWordDaoImpl extends JuicyHibernateDaoSupport implements
		HgKeyWordDao {

	public HgKeyWord getById(Integer id) throws SignaturePersistException {
		return (HgKeyWord) getHibernateTemplate().get(HgKeyWord.class, id);
	}

	public synchronized Integer save(HgKeyWord hgKeyWord) throws SignaturePersistException {
		Integer id = super.getMaxId(HgKeyWord.class.getName());
		hgKeyWord.setId(++id);
		return (Integer) getHibernateTemplate().save(hgKeyWord);
	}

	public void update(HgKeyWord hgKeyWord) throws SignaturePersistException {
		getHibernateTemplate().update(hgKeyWord);
	}

	public void delete(HgKeyWord hgKeyWord) throws SignaturePersistException {
		getHibernateTemplate().delete(hgKeyWord);
	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));
	}

	public List<HgKeyWord> findAll() throws SignaturePersistException {
		return (List<HgKeyWord>) getHibernateTemplate().find("from HgKeyWord");
	}

	public Integer findCountByContent(String content)
			throws SignaturePersistException {
		String sql = "select count(id) from HgKeyWord";

		if (content != null && content.length() > 0) {
			sql += " where KEY_WORD_CONTENT like ?";
			content = "%" + content + "%";
			return super.getCount(sql, content);
		} else {
			return super.getCount(sql);
		}
	}

	public List<HgKeyWord> findByContentForPage(String content, int offSet,
			int pageSize) throws SignaturePersistException {
		String sql = "from HgKeyWord";

		if (content != null && content.length() > 0) {
			sql += " where KEY_WORD_CONTENT like ?";
			content = "%" + content + "%";
			
			sql += " order by KEY_WORD_ID desc";
			return super.findByPage(sql, content, offSet, pageSize);
		} else {
			sql += " order by KEY_WORD_ID desc";
			return super.findByPage(sql, offSet, pageSize);
		}
	}

	public List<HgKeyWord> findBycontent(String content)
			throws SignaturePersistException {
		if(content == null || content.trim().length() == 0){
			return new ArrayList<HgKeyWord>();
}
		
		String sql = "from HgKeyWord where KEY_WORD_CONTENT = ?";
		
		Object[] values = {content};
		
		return super.findByHql(sql, values);	
	}

}
