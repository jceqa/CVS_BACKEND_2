package py.com.cvs2.dao;

import py.com.cvs2.model.Factura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FacturaDao extends GenericDao<Factura> {

    public Integer getNumeroActual(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT f FROM Factura f "
                + " ORDER BY f.id DESC ";

        Query q = em.createQuery(query);

        List<Factura> facturas = q.getResultList();

        if(facturas != null && facturas.size() > 0) {
            return facturas.get(0).getId() + 1;
        }

        return 1;
    }

    public List<Factura> listProcesadas(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT f FROM Factura f "
                + " WHERE f.estado = 'ACTIVO' "
                + " AND f.estadoFactura.id = 4 "
                + " ORDER BY f.id ";

        Query q = em.createQuery(query);

        return q.getResultList();
    }
}
