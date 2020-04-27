package edu.whut.web.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.whut.web.dao.BaseDao;
import edu.whut.web.domain.Organization;

public class BaseDaoImpl<T> implements
		BaseDao<T> {
	@SuppressWarnings({ "rawtypes" })
	private final Class paramType;	
	
	protected static SessionFactory sessionFactory;
	protected Session session;
	protected Transaction transaction;
	
	static{
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
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
