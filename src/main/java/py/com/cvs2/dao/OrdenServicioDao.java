package py.com.cvs2.dao;

import py.com.cvs2.model.OrdenServicio;
import py.com.cvs2.model.PedidoCompra;
import py.com.cvs2.model.PedidoVenta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class OrdenServicioDao extends GenericDao<OrdenServicio> {

    public List<OrdenServicio> listPendientesByCliente(Integer idCliente){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT os FROM OrdenServicio os "
                + " WHERE os.estado = 'ACTIVO' "
                + " AND os.estadoOrdenServicio.id = 1 "
                + " AND os.presupuestoServicio.diagnostico.recepcion.cliente.id = :idCliente "
                + " ORDER BY os.id ";

        Query q = em.createQuery(query);
        q.setParameter("idCliente", idCliente);

        return q.getResultList();
    }
}