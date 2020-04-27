package edu.whut.web.dao.impl;

import edu.whut.web.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements
        BaseDao<T> {
	@SuppressWarnings({ "rawtypes" })
	private final Class paramType;	
	
	protected static SessionFactory sessionFactory;
	protected Session session;
	protected Transaction transaction;
	
	static{
		Resource resource=new ClassPathResource("bean.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		sessionFactory=(SessionFactory)factory.getBean("sessionFactory");
	}
	@SuppressWarnings({ "rawtypes" })
	public BaseDaoImpl() {
		super();
		paramType = (Class) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Session getSession(){
		return this.session;
	}

	@Override
	public T insert(T object) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(object);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return object;
	}

	@Override
	public T update(T object) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(object);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return object;
	}

	@Override
	public T delete(T object) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(object);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return object;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(long id) {
		T object = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			object = (T) this.getSession().load(paramType, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return object;
	}
	
	@Override
	public T merge(T object) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			this.getSession().merge(object);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return object;
	}

	@Override
	public List<T> findAllOnes() {
		List<T> ones = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			ones = (List<T>)this.getSession().createCriteria(paramType).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return ones;
	}
	
	

}
