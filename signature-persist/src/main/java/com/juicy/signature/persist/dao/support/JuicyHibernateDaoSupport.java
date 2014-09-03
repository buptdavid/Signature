/**
 * Copyright @ 2011 Beijing 北京佳信汇通科技有限公司.
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
 * 实现Spring支持的DAO
 * 
 * @author 路卫杰
 * @version <p>
 *          2011.07.20 创建
 *          </p>
 *          <p>
 *          2011.07.21 增加获得最大的主键ID的方法
 *          </p>
 *          <p>
 *          2011-08-03 增加分页查询的功能
 *          </p>
 */
public class JuicyHibernateDaoSupport extends HibernateDaoSupport {

	/**
	 * 查询记录数量
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @return 记录数量
	 */
	public Integer getCount(final String hql) {
		// 通过一个HibernateCallback对象来执行查询
		List<Long> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					// 实现HibernateCallback接口必须实现的方法
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						List result = session.createQuery(hql).list();
						return result;
					}
				});

		return list.get(0).intValue();
	}

	/**
	 * 使用hql语句进行分页查询
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	public List findByPage(final String hql, final int offSet,
			final int pageSize) {
		// 通过一个HibernateCallback对象来执行查询
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallback接口必须实现的方法
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// 执行Hibernate分页查询
				List result = session.createQuery(hql).setFirstResult(offSet)
						.setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	/**
	 * 查询记录数量
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param value
	 *            如果hql有一个参数需要传入，value就是传入hql语句的参数
	 * @return 记录数量
	 */
	public Integer getCount(final String hql, final Object value) {
		// 通过一个HibernateCallback对象来执行查询
		List<Long> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					// 实现HibernateCallback接口必须实现的方法
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						List result = session.createQuery(hql)
						// 为hql语句传入参数
								.setParameter(0, value).list();
						return result;
					}
				});
		return list.get(0).intValue();
	}

	/**
	 * 使用hql语句进行分页查询
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param value
	 *            如果hql有一个参数需要传入，value就是传入hql语句的参数
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	public List findByPage(final String hql, final Object value,
			final int offSet, final int pageSize) {
		// 通过一个HibernateCallback对象来执行查询
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallback接口必须实现的方法
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// 执行Hibernate分页查询
				List result = session.createQuery(hql)
						// 为hql语句传入参数
						.setParameter(0, value).setFirstResult(offSet)
						.setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	/**
	 * 查询记录数量
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param values
	 *            如果hql有多个个参数需要传入，values就是传入hql的参数数组
	 * @return 记录数量
	 */
	public Integer getCount(final String hql, final Object[] values) {
		// 通过一个HibernateCallback对象来执行查询
		List<Long> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					// 实现HibernateCallback接口必须实现的方法
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						// 为hql语句传入参数
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
	 * 使用hql语句进行分页查询
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param values
	 *            如果hql有多个个参数需要传入，values就是传入hql的参数数组
	 * @param offSet
	 *            第一条记录索引
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	public List findByPage(final String hql, final Object[] values,
			final int offSet, final int pageSize) {
		// 通过一个HibernateCallback对象来执行查询
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallback接口必须实现的方法
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// 执行Hibernate分页查询
				Query query = session.createQuery(hql);
				// 为hql语句传入参数
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
	 * 获得最大的主键ID
	 * 
	 * @param className
	 *            类全名
	 * @return 最大的主键ID
	 */
	public Integer getMaxId(final String className) {
		Integer maxId = 0;
		List<Integer> maxIdList = (List<Integer>) getHibernateTemplate()
				.executeFind(new HibernateCallback() {
					// 实现HibernateCallback接口必须实现的方法
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

		// 返回
		return maxId;

	}

	/**
	 * 使用hql语句进行查询
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param values
	 *            如果hql有多个个参数需要传入，values就是传入hql的参数数组
	 * @return 符合查询条件的所有记录
	 */
	public List findByHql(final String hql, final Object[] values) {
		// 通过一个HibernateCallback对象来执行查询
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallback接口必须实现的方法
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// 执行Hibernate分页查询
				Query query = session.createQuery(hql);
				// 为hql语句传入参数
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
	 * 根据values参数执行hql语句
	 * 
	 * @param hql
	 *            需要执行的hql语句
	 */
	public void executeUpdate(final String hql) {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);

				// 执行
				query.executeUpdate();

				return null;
			}
		});
	}

	/**
	 * 根据values参数执行hql语句
	 * 
	 * @param hql
	 *            需要执行的hql语句
	 * @param value
	 *            如果hql有一个参数需要传入，value就是传入hql语句的参数
	 */
	public void executeUpdate(final String hql, final Object value) {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);

				// 为hql语句传入参数
				query.setParameter(0, value);
				// 执行
				query.executeUpdate();

				return null;
			}
		});
	}
	
	/**
	 * 根据values参数执行hql语句
	 * 
	 * @param hql
	 *            需要执行的hql语句
	 * @param values
	 *            参数数组
	 */
	public void executeUpdate(final String hql, final Object[] values) {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);

				// 为hql语句传入参数
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
				
				// 执行
				query.executeUpdate();

				return null;
			}
		});
	}
	
}
