package py.com.cvs2.dao;

import py.com.cvs2.model.NotaCreditoCompra;
import py.com.cvs2.model.NotaCreditoCompra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class NotaCreditoCompraDao extends GenericDao<NotaCreditoCompra> {

    public List<NotaCreditoCompra> listPendientesByProveedor(Integer idProveedor){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT pc FROM NotaCreditoCompra pc "
                + " WHERE pc.estado = " + "'ACTIVO' "
                + " AND pc.estadoNotaCreditoCompra.id = 1 "
                + " AND pc.proveedor.id = :idProveedor "
                + " ORDER BY pc.id ";

        Query q = em.createQuery(query);

        q.setParameter("idProveedor", idProveedor);

        return q.getResultList();
    }
}
