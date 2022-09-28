package py.com.cvs2.dao;
import py.com.cvs2.model.Recepcion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class RecepcionDao extends GenericDao<Recepcion>{

    public List<Recepcion> listPendientes(){
        List<Recepcion> recepcionList;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT pc FROM Recepcion pc "
                + " WHERE pc.estado = " + "'ACTIVO'"
                + " AND pc.estadoRecepcion.id = 1"
                + " ORDER BY pc.id ";

        Query q = em.createQuery(query);

        return q.getResultList();
    }
}