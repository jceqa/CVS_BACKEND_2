package py.com.cvs2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import py.com.cvs2.model.UsuarioRol;

public class UsuarioRolDao {

	public UsuarioRol getById(Integer id) {

		UsuarioRol ur;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT ur FROM UsuarioRol ur WHERE ur.id=:id");

		q.setParameter("id", id);

		ur = (UsuarioRol) q.getResultList().get(0);

		return ur;
	}

}
