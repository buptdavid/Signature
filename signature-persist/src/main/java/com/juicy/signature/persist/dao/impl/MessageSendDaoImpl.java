/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
 * All right reserved.
 */

package com.juicy.signature.persist.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.juicy.signature.persist.dao.MessageSendDao;
import com.juicy.signature.persist.dao.support.JuicyHibernateDaoSupport;
import com.juicy.signature.persist.exception.SignaturePersistException;
import com.juicy.signature.persist.po.MessageSend;

/**
 * MessageSendDao接口实现类
 *
 * @author 路卫杰
 * @version <p>Nov 25, 2011 创建</p>
 */
public class MessageSendDaoImpl extends JuicyHibernateDaoSupport implements
		MessageSendDao {

	public MessageSend getById(Integer id) throws SignaturePersistException {
		return (MessageSend)getHibernateTemplate().get(MessageSend.class, id);
	}

	public Integer save(MessageSend messageSend)
			throws SignaturePersistException {
		Integer id = super.getMaxId(MessageSend.class.getName());
		messageSend.setId(++id);

		return (Integer) getHibernateTemplate().save(messageSend);
	}

	public void update(MessageSend messageSend)
			throws SignaturePersistException {
		getHibernateTemplate().update(messageSend);

	}

	public void delete(MessageSend messageSend)
			throws SignaturePersistException {
		getHibernateTemplate().delete(messageSend);

	}

	public void delete(Integer id) throws SignaturePersistException {
		getHibernateTemplate().delete(this.getById(id));

	}

	public MessageSend findMessageSend() throws SignaturePersistException {
		List<MessageSend> messageSends = (List<MessageSend>) getHibernateTemplate().find(
				"from MessageSend");
		Iterator<MessageSend> it = messageSends.iterator();
		//如果有则返回第一个（也只有一个）
		while(it.hasNext()){
			return it.next();
		}
		
		//如果没有则返回null
		return null;
	}

}
