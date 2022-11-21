package py.com.cvs2.dao;

import py.com.cvs2.model.Pago;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class PagoDao extends GenericDao<Pago>{

    public List<Pago> filterByDate(Date fechaInicio, Date fechaFin) {
        List<Pago> tL;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT p FROM Pago p "
                + " WHERE p.estado = " + "'ACTIVO' ";

        if(fechaInicio != null){
            query += "AND p.fecha > :fechaInicio ";
        }

        if(fechaFin != null){
            query += "AND p.fecha < :fechaFin ";
        }

        query += " ORDER BY t.id ";

        Query q = em.createQuery(query);

        if(fechaInicio != null){
            q.setParameter("fechaInicio", fechaInicio);
        }

        if(fechaFin != null){
            q.setParameter("fechaFin", fechaFin);
        }

        return q.getResultList();
    }
}
