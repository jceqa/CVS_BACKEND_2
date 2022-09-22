package py.com.cvs2.dao;


import py.com.cvs2.model.Sucursal;
import py.com.cvs2.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class SucursalDao extends GenericDao<Sucursal>{

    public List<Sucursal> getByUserId(Integer userId){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        Usuario usuario =  em.find(Usuario.class, userId);

        String query = "SELECT s FROM Sucursal s ";

        if(usuario.getSucursal() != null){
            query += " WHERE s.id = " + usuario.getSucursal().getId();
        }

        query += " ORDER BY s.id ";

        Query q = em.createQuery(query);

        return q.getResultList();
    }
}
