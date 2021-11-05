package py.com.cvs2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import py.com.cvs2.model.Permiso;

public class PermisoDao {

	public List<Permiso> findById(Integer idRol) {

		List<Permiso> permisos;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT p FROM Permiso p " + 
				"WHERE p.rol.id=:idRol "
				+ " ORDER BY p.formulario.sistema.id, "
				+ " p.formulario.subMenu.id, "
				+ " p.formulario.id");

		q.setParameter("idRol", idRol);

		permisos = q.getResultList();

		return permisos;
	}

}
