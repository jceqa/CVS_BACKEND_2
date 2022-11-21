package py.com.cvs2.dao;

import py.com.cvs2.model.Articulo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ArticuloDao extends GenericDao<Articulo> {

    public List<Articulo> listByTipoArticulo(Integer idTipoArticulo){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT a FROM Articulo a "
                + " WHERE a.estado = " + "'ACTIVO'"
                + " AND a.tipoArticulo.id = :idTipoArticulo "
                + " ORDER BY a.id ";

        Query q = em.createQuery(query);
        q.setParameter("idTipoArticulo", idTipoArticulo);

        return q.getResultList();
    }
}
