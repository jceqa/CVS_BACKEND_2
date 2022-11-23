package py.com.cvs2.dao;

import py.com.cvs2.model.Cobro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class CobroDao extends GenericDao<Cobro>{

    public List<Cobro> filterByDate(Date fechaInicio, Date fechaFin) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT p FROM Cobro p "
                + " WHERE p.estado = " + "'ACTIVO' ";

        if(fechaInicio != null){
            query += "AND p.fecha > :fechaInicio ";
        }

        if(fechaFin != null){
            query += "AND p.fecha < :fechaFin ";
        }

        query += " ORDER BY p.id ";

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
