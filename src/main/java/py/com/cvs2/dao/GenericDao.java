package py.com.cvs2.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDao<T> {

	private Class<T> type;

	public GenericDao() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public List<T> list() {
		List<T> tL;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		String tableName = type.toString().substring(type.toString().lastIndexOf(".") +1 );

		Query q = em.createQuery("SELECT t FROM " + tableName + " t ORDER BY t.id");

		tL = q.getResultList();

		return tL;
	}

	public T findById(Integer id) {
		T t;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		t = (T) em.find(type, id);

		return t;
	}

	public T save(T t) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(t);

		et.commit();
		return t;

	}

	public T update(T t) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(t);

		et.commit();
		return t;

	}

	public void delete(Integer id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.remove(em.getReference(type, id));
		em.getTransaction().commit();

	}

}
