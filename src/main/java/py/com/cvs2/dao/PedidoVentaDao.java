package py.com.cvs2.dao;

import py.com.cvs2.model.PedidoVenta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PedidoVentaDao extends GenericDao<PedidoVenta>{

    public List<PedidoVenta> listPendientes(){
        List<PedidoVenta> pedidoVentaList;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT pc FROM PedidoVenta pc "
                + " WHERE pc.estado = " + "'ACTIVO'"
                + " AND pc.estadoPedido.id = 1"
                + " ORDER BY pc.id ";

        Query q = em.createQuery(query);

        return q.getResultList();
    }
}