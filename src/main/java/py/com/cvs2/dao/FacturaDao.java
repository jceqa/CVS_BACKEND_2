package py.com.cvs2.dao;

import py.com.cvs2.model.Factura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FacturaDao extends GenericDao<Factura> {

    public List<Factura> listProcesadas(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT fc FROM Factura fc "
                + " WHERE fc.estado = " + "'ACTIVO'"
                + " AND fc.estadoFactura.id = 4"
                + " ORDER BY fc.id ";

        Query q = em.createQuery(query);

        return q.getResultList();
    }
}
