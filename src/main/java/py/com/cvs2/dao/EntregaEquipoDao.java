package py.com.cvs2.dao;

import py.com.cvs2.model.Factura;
import py.com.cvs2.model.EntregaEquipo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EntregaEquipoDao extends GenericDao<EntregaEquipo> {

    public List<EntregaEquipo> listBySucursal(Integer idSucursal){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT pc FROM EntregaEquipo pc "
                + " WHERE pc.estado = " + "'ACTIVO'"
                + " AND pc.factura.deposito.sucursal.id = :idSucursal"
                + " ORDER BY pc.id ";

        Query q = em.createQuery(query);
        q.setParameter("idSucursal", idSucursal);

        return q.getResultList();
    }
}