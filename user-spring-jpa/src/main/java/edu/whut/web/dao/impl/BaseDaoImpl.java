package edu.whut.web.dao.impl;

import edu.whut.web.dao.BaseDao;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public class BaseDaoImpl<T> implements BaseDao<T> {
	@SuppressWarnings({ "rawtypes" })
	private final Class paramType;

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings({ "rawtypes" })
	public BaseDaoImpl() {
		super();
		paramType = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T insert(T object) {
		em.persist(object);
		return object;
	}

	@Override
	public T update(T object) {
		return em.merge(object);
	}

	@Override
	public T merge(T object) {
		return em.merge(object);
	}

	@Override
	public T delete(T object) {
		em.remove(em.merge(object));
		return object;
	}

	@Override
	public T findById(long id) {
		T object = (T)em.find(paramType, id);
		return object;
	}
	
	@Override
	public List<T> findAllOnes() {
		String className = paramType.getSimpleName();
		StringBuffer jpql = new StringBuffer("select o from ");
		jpql.append(className).append(" o ");
		return em.createQuery(jpql.toString()).getResultList();
	}
	
}
