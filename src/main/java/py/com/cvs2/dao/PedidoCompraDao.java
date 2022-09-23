package py.com.cvs2.dao;

import py.com.cvs2.model.PedidoCompra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PedidoCompraDao extends GenericDao<PedidoCompra>{

    public List<PedidoCompra> listPendientes(){
        List<PedidoCompra> pedidoCompraList;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT pc FROM PedidoCompra pc "
                + " WHERE pc.estado = " + "'ACTIVO'"
                + " AND pc.estadoPedido.id = 1"
                + " ORDER BY pc.id ";

        Query q = em.createQuery(query);

        return q.getResultList();
    }
}
