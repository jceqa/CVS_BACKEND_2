package py.com.cvs2.dao;

import py.com.cvs2.model.FacturaCompra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FacturaCompraDao extends GenericDao<FacturaCompra>{

    public List<FacturaCompra> listProcesadas(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT fc FROM FacturaCompra fc "
                + " WHERE fc.estado = " + "'ACTIVO'"
                + " AND fc.estadoFacturaCompra.id = 4"
                + " ORDER BY fc.id ";

        Query q = em.createQuery(query);

        return q.getResultList();
    }
}
