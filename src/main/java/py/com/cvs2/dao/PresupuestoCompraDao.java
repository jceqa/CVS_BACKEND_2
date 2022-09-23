package py.com.cvs2.dao;

import py.com.cvs2.model.PresupuestoCompra;
import py.com.cvs2.model.PresupuestoCompra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PresupuestoCompraDao extends GenericDao<PresupuestoCompra> {

    public List<PresupuestoCompra> listPendientes(){
        List<PresupuestoCompra> presupuestoCompraList;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT pc FROM PresupuestoCompra pc "
                + " WHERE pc.estado = " + "'ACTIVO'"
                + " AND pc.estadoPresupuesto.id = 1"
                + " ORDER BY pc.id ";

        Query q = em.createQuery(query);

        return q.getResultList();
    }
}
