package py.com.cvs2.dao;

import py.com.cvs2.model.PedidoCompra;
import py.com.cvs2.model.Reclamo;
import py.com.cvs2.model.PresupuestoCompra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ReclamoDao extends GenericDao<Reclamo> {

    public List<Reclamo> listBySucursal(Integer idSucursal){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT pc FROM Reclamo pc "
                + " WHERE pc.estado = " + "'ACTIVO'"
                + " AND pc.entregaEquipo.sucursal.id = :idSucursal"
                + " ORDER BY pc.id ";

        Query q = em.createQuery(query);
        q.setParameter("idSucursal", idSucursal);

        return q.getResultList();
    }
}

