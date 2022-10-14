package py.com.cvs2.dao;


import py.com.cvs2.model.Recepcion;
import py.com.cvs2.model.PresupuestoServicio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PresupuestoServicioDao extends GenericDao<PresupuestoServicio> {

    public List<PresupuestoServicio> listBySucursal(Integer idSucursal){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT psc FROM PresupuestoServicio psc "
                + " WHERE psc.estado = " + "'ACTIVO'"
                + " AND psc.diagnostico.recepcion.deposito.sucursal.id = :idSucursal"
                + " ORDER BY psc.id ";

        Query q = em.createQuery(query);
        q.setParameter("idSucursal", idSucursal);

        return q.getResultList();
    }

    public List<PresupuestoServicio> listPendientesBySucursal(Integer idSucursal){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT psc FROM PresupuestoServicio psc "
                + " WHERE psc.estado = " + "'ACTIVO'"
                + " AND psc.estadoPresupuestoServicio.id = 1 "
                + " AND psc.diagnostico.recepcion.deposito.sucursal.id = :idSucursal"
                + " ORDER BY psc.id ";

        Query q = em.createQuery(query);
        q.setParameter("idSucursal", idSucursal);

        return q.getResultList();
    }

}