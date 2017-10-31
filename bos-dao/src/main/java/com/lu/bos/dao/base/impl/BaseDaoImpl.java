package com.lu.bos.dao.base.impl;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lu.bos.dao.IBaseDao;
import com.lu.bos.domain.User;
import com.lu.bos.utils.PageBean;

import java.lang.reflect.Type;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {
	// 代表的是某个实体的类型
	private Class<T> entityClass;

	@Resource // 根据类型注入spring工厂中的会话工厂对象sessionFactory
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	// 在父类的构造方法中动态获取EntityClass
	public BaseDaoImpl() {
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArgument = superclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArgument[0];

	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);

	}

	@Override
	public List<T> findAll() {
		String hql = "from " + entityClass.getSimpleName();

		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	// 执行更新
	@Override
	public void executeUpdate(String queryname, Object... objects) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery(queryname);
		// 为hql语句的？赋值
		int i = 0;
		for (Object object : objects) {
			query.setParameter(i++, object);
		}
		// 执行更新
		query.executeUpdate();
	}

	//
	@Override
	public void pageQuery(PageBean pagebean) {
		int currentPage = pagebean.getCurrentPage();
		int pageSize = pagebean.getPageSize();
		DetachedCriteria detachedCriteria = pagebean.getDetachedCriteria();
		// 查询total总数据量
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> countList = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long count = countList.get(0);
		pagebean.setTotal(count.intValue());
		// 查询rows 当前页需要展示的数据集合
		detachedCriteria.setProjection(null);
		//指定hibernate封装对象的方式
		detachedCriteria.setResultTransformer(detachedCriteria.ROOT_ENTITY);
		int firstResult = (currentPage - 1) * pageSize;
		int maxResult = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResult);
		pagebean.setRows(rows);
	}

	@Override
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
		
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {

		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

}
