package py.com.cvs2.dao;

import py.com.cvs2.model.OrdenServicio;
import py.com.cvs2.model.PedidoCompra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class OrdenServicioDao extends GenericDao<OrdenServicio> {

    public List<OrdenServicio> listBySucursal(Integer idSucursal){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT os FROM OrdenServicio os "
                + " WHERE os.estado = " + "'ACTIVO'"
                + " AND os.deposito.sucursal.id = :idSucursal"
                + " ORDER BY os.id ";

        Query q = em.createQuery(query);
        q.setParameter("idSucursal", idSucursal);

        return q.getResultList();
    }

    public List<OrdenServicio> listByPendientesSucursal(Integer idSucursal){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT os FROM OrdenServicio os "
                + " WHERE os.estado = " + "'ACTIVO'"
                + " AND os.estadoOrdenServicio.id = 1 "
                + " AND os.deposito.sucursal.id = :idSucursal"
                + " ORDER BY os.id ";

        Query q = em.createQuery(query);
        q.setParameter("idSucursal", idSucursal);

        return q.getResultList();
    }
}