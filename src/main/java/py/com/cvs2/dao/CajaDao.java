package py.com.cvs2.dao;

import py.com.cvs2.model.Caja;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CajaDao extends GenericDao<Caja>{

    public List<Caja> listBySucursal(List<Integer> idSucursal){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String in = new String();

        for(Integer id : idSucursal){
            in = in.concat(id.toString());
            in = in.concat(",");
        }

        in = in.substring(0, in.length()-1);

        Query q = em.createQuery("SELECT c FROM Caja c "
                + " WHERE c.sucursal.id IN (" + in + ")"
                + " AND c.estado = 'ACTIVO'");


        return q.getResultList();
    }
}
