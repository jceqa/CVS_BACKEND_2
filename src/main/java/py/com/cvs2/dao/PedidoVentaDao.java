package py.com.cvs2.dao;

import py.com.cvs2.model.PedidoVenta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PedidoVentaDao extends GenericDao<PedidoVenta>{

    public List<PedidoVenta> listPendientesByCliente(Integer idCliente){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT pv FROM PedidoVenta pv "
                + " WHERE pv.estado = " + "'ACTIVO' "
                + " AND pv.estadoPedidoVenta.id = 1 "
                + " AND pv.cliente.id = :idCliente "
                + " ORDER BY pv.id ";

        Query q = em.createQuery(query);
        q.setParameter("idCliente", idCliente);

        return q.getResultList();
    }


}