package py.com.cvs2.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import py.com.cvs2.model.Marca;

public class MarcaDao {

	public List<Marca> list() {
		List<Marca> marcas;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT m FROM Marca m " + "ORDER BY m.id");

		marcas = q.getResultList();

		return marcas;
	}

	public Marca findById(Integer id) {
		Marca m;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT m FROM Marca m " + "WHERE m.id=:id");

		q.setParameter("id", id);

		m = (Marca) q.getResultList().get(0);

		return m;
	}

	public Marca save(Marca marca) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(marca);

		et.commit();
		return marca;

	}

	public Marca update(Marca marca) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(marca);

		et.commit();
		return marca;

	}

	public void delete(Integer idMarca) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		Marca marca = em.find(Marca.class, idMarca);

		em.getTransaction().begin();
		em.remove(marca);
		em.getTransaction().commit();

	}
}
