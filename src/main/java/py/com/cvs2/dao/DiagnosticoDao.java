package py.com.cvs2.dao;


import py.com.cvs2.model.Recepcion;
import py.com.cvs2.model.Diagnostico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DiagnosticoDao extends GenericDao<Diagnostico> {

    public List<Diagnostico> listBySucursal(Integer idSucursal) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT dc FROM Diagnostico dc "
                + " WHERE dc.estado = " + "'ACTIVO'"
                + " AND dc.recepcion.deposito.sucursal.id = :idSucursal"
                + " ORDER BY dc.id ";

        Query q = em.createQuery(query);
        q.setParameter("idSucursal", idSucursal);

        return q.getResultList();
    }

    public List<Diagnostico> listPendientesBySucursal(Integer idSucursal) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT dc FROM Diagnostico dc "
                + " WHERE dc.estado = " + "'ACTIVO'"
                + " AND dc.estadoDiagnostico.id = 1 "
                + " AND dc.recepcion.deposito.sucursal.id = :idSucursal"
                + " ORDER BY dc.id ";

        Query q = em.createQuery(query);
        q.setParameter("idSucursal", idSucursal);

        return q.getResultList();
    }

}