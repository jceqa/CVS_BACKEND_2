package py.com.cvs2.dao;

import py.com.cvs2.model.NotaVenta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class NotaVentaDao extends GenericDao<NotaVenta> {

    public List<NotaVenta> listPendientesByCliente(Integer idCliente){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT pc FROM NotaVenta pc "
                + " WHERE pc.estado = " + "'ACTIVO' "
                + " AND pc.estadoNotaVenta.id = 1 "
                + " AND pc.cliente.id = :idCliente "
                + " ORDER BY pc.id ";

        Query q = em.createQuery(query);

        q.setParameter("idCliente", idCliente);

        return q.getResultList();
    }
}