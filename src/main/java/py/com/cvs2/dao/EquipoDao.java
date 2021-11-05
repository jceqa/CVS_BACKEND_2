package py.com.cvs2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import py.com.cvs2.model.Equipo;

public class EquipoDao {
	
	public List<Equipo> list() {
		List<Equipo> equipos;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT e FROM Equipo e ORDER BY e.id");

		equipos = q.getResultList();

		return equipos;
	}

	public Equipo findById(Integer id) {
		Equipo equipo;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT e FROM Equipo e WHERE e.id=:id");

		q.setParameter("id", id);

		equipo = (Equipo) q.getResultList().get(0);

		return equipo;
	}

	public Equipo save(Equipo equipo) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(equipo);

		et.commit();
		return equipo;

	}

	public Equipo update(Equipo equipo) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(equipo);

		et.commit();
		return equipo;

	}

	public void delete(Integer idEquipo) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		Equipo equipo = em.find(Equipo.class, idEquipo);

		em.getTransaction().begin();
		em.remove(equipo);
		em.getTransaction().commit();

	}

}
