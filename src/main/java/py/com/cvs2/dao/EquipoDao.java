package py.com.cvs2.dao;

import py.com.cvs2.model.Equipo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EquipoDao extends GenericDao<Equipo> {

    public List<Equipo> listByCliente(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT e FROM Equipo e "
                + " WHERE e.estado = " + "'ACTIVO'"
                + " AND e.cliente.id = :id"
                + " ORDER BY e.id ";

        Query q = em.createQuery(query);

        q.setParameter("id", id);

        return q.getResultList();
    }

}