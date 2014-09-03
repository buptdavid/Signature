/**
 * Copyright @ 2011 Beijing �������Ż�ͨ�Ƽ����޹�˾.
 * All right reserved.
 */
package com.juicy.signature.persist.dao.support;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * ʵ��Spring֧�ֵ�DAO
 * 
 * @author ·����
 * @version <p>
 *          2011.07.20 ����
 *          </p>
 *          <p>
 *          2011.07.21 ���ӻ����������ID�ķ���
 *          </p>
 *          <p>
 *          2011-08-03 ���ӷ�ҳ��ѯ�Ĺ���
 *          </p>
 */
public class JuicyHibernateDaoSupport extends HibernateDaoSupport {

	/**
	 * ��ѯ��¼����
	 * 
	 * @param hql
	 *            ��Ҫ��ѯ��hql���
	 * @return ��¼����
	 */
	public Integer getCount(final String hql) {
		// ͨ��һ��HibernateCallback������ִ�в�ѯ
		List<Long> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						List result = session.createQuery(hql).list();
						return result;
					}
				});

		return list.get(0).intValue();
	}

	/**
	 * ʹ��hql�����з�ҳ��ѯ
	 * 
	 * @param hql
	 *            ��Ҫ��ѯ��hql���
	 * @param offSet
	 *            ��һ����¼����
	 * @param pageSize
	 *            ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	public List findByPage(final String hql, final int offSet,
			final int pageSize) {
		// ͨ��һ��HibernateCallback������ִ�в�ѯ
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// ִ��Hibernate��ҳ��ѯ
				List result = session.createQuery(hql).setFirstResult(offSet)
						.setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	/**
	 * ��ѯ��¼����
	 * 
	 * @param hql
	 *            ��Ҫ��ѯ��hql���
	 * @param value
	 *            ���hql��һ��������Ҫ���룬value���Ǵ���hql���Ĳ���
	 * @return ��¼����
	 */
	public Integer getCount(final String hql, final Object value) {
		// ͨ��һ��HibernateCallback������ִ�в�ѯ
		List<Long> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						List result = session.createQuery(hql)
						// Ϊhql��䴫�����
								.setParameter(0, value).list();
						return result;
					}
				});
		return list.get(0).intValue();
	}

	/**
	 * ʹ��hql�����з�ҳ��ѯ
	 * 
	 * @param hql
	 *            ��Ҫ��ѯ��hql���
	 * @param value
	 *            ���hql��һ��������Ҫ���룬value���Ǵ���hql���Ĳ���
	 * @param offSet
	 *            ��һ����¼����
	 * @param pageSize
	 *            ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	public List findByPage(final String hql, final Object value,
			final int offSet, final int pageSize) {
		// ͨ��һ��HibernateCallback������ִ�в�ѯ
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// ִ��Hibernate��ҳ��ѯ
				List result = session.createQuery(hql)
						// Ϊhql��䴫�����
						.setParameter(0, value).setFirstResult(offSet)
						.setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	/**
	 * ��ѯ��¼����
	 * 
	 * @param hql
	 *            ��Ҫ��ѯ��hql���
	 * @param values
	 *            ���hql�ж����������Ҫ���룬values���Ǵ���hql�Ĳ�������
	 * @return ��¼����
	 */
	public Integer getCount(final String hql, final Object[] values) {
		// ͨ��һ��HibernateCallback������ִ�в�ѯ
		List<Long> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						// Ϊhql��䴫�����
						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}
						List result = query.list();
						return result;
					}
				});
		return list.get(0).intValue();
	}

	/**
	 * ʹ��hql�����з�ҳ��ѯ
	 * 
	 * @param hql
	 *            ��Ҫ��ѯ��hql���
	 * @param values
	 *            ���hql�ж����������Ҫ���룬values���Ǵ���hql�Ĳ�������
	 * @param offSet
	 *            ��һ����¼����
	 * @param pageSize
	 *            ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	public List findByPage(final String hql, final Object[] values,
			final int offSet, final int pageSize) {
		// ͨ��һ��HibernateCallback������ִ�в�ѯ
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// ִ��Hibernate��ҳ��ѯ
				Query query = session.createQuery(hql);
				// Ϊhql��䴫�����
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
				List result = query.setFirstResult(offSet)
						.setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	/**
	 * �����������ID
	 * 
	 * @param className
	 *            ��ȫ��
	 * @return ��������ID
	 */
	public Integer getMaxId(final String className) {
		Integer maxId = 0;
		List<Integer> maxIdList = (List<Integer>) getHibernateTemplate()
				.executeFind(new HibernateCallback() {
					// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "select max(p.Id) from " + className
								+ " as p";
						Query query = session.createQuery(hql);
						List<Integer> maxList = query.list();

						return maxList;
					}
				});

		for (Iterator<Integer> it = maxIdList.iterator(); it.hasNext();) {
			Integer max = it.next();
			if (max != null) {
				maxId = max;
			}
		}

		// ����
		return maxId;

	}

	/**
	 * ʹ��hql�����в�ѯ
	 * 
	 * @param hql
	 *            ��Ҫ��ѯ��hql���
	 * @param values
	 *            ���hql�ж����������Ҫ���룬values���Ǵ���hql�Ĳ�������
	 * @return ���ϲ�ѯ���������м�¼
	 */
	public List findByHql(final String hql, final Object[] values) {
		// ͨ��һ��HibernateCallback������ִ�в�ѯ
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// ִ��Hibernate��ҳ��ѯ
				Query query = session.createQuery(hql);
				// Ϊhql��䴫�����
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
				List result = query.list();
				return result;
			}
		});
		return list;
	}
	
	/**
	 * ����values����ִ��hql���
	 * 
	 * @param hql
	 *            ��Ҫִ�е�hql���
	 */
	public void executeUpdate(final String hql) {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);

				// ִ��
				query.executeUpdate();

				return null;
			}
		});
	}

	/**
	 * ����values����ִ��hql���
	 * 
	 * @param hql
	 *            ��Ҫִ�е�hql���
	 * @param value
	 *            ���hql��һ��������Ҫ���룬value���Ǵ���hql���Ĳ���
	 */
	public void executeUpdate(final String hql, final Object value) {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);

				// Ϊhql��䴫�����
				query.setParameter(0, value);
				// ִ��
				query.executeUpdate();

				return null;
			}
		});
	}
	
	/**
	 * ����values����ִ��hql���
	 * 
	 * @param hql
	 *            ��Ҫִ�е�hql���
	 * @param values
	 *            ��������
	 */
	public void executeUpdate(final String hql, final Object[] values) {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);

				// Ϊhql��䴫�����
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
				
				// ִ��
				query.executeUpdate();

				return null;
			}
		});
	}
	
}
