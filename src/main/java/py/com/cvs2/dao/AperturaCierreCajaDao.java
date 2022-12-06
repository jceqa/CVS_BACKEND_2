package py.com.cvs2.dao;

import py.com.cvs2.model.AperturaCierreCaja;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AperturaCierreCajaDao extends GenericDao<AperturaCierreCaja>{

    public List<AperturaCierreCaja> findAbiertaBySucursal(Integer idSucursal){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT acc FROM AperturaCierreCaja acc "
                + " WHERE acc.estado = 'ACTIVO' "
                + " AND acc.fechaHoraCierre is Null "
                + " AND acc.caja.sucursal.id = :idSucursal "
                + " ORDER BY acc.id ";

        Query q = em.createQuery(query);

        q.setParameter("idSucursal", idSucursal);

        return q.getResultList();
    }
}
