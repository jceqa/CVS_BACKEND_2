package py.com.cvs2.dao;

import py.com.cvs2.model.Deposito;
import py.com.cvs2.model.Stock;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class StockDao extends GenericDao<Stock>{

    public Stock getByArticuloAndDeposito(Integer idArticulo, Integer idDeposito) {
        List<Stock> stock;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT s FROM Stock s "
                + " WHERE s.estado = " + "'ACTIVO' "
                + " AND s.articulo.id = :idArticulo "
                + " AND s.deposito.id = :idDeposito "
                + " ORDER BY s.id ";

        Query q = em.createQuery(query);
        q.setParameter("idArticulo", idArticulo);
        q.setParameter("idDeposito", idDeposito);

        if(q.getResultList().size() != 0){
            return (Stock) q.getResultList().get(0);
        }

        return null;
    }
    public List<Stock> listStockByDeposito(Integer idDeposito){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT s FROM Stock s "
                + " WHERE s.deposito.id = :idDeposito");

        q.setParameter("idDeposito", idDeposito);

        return q.getResultList();
    }

    public List<Stock> listStockByArticulo(Integer idArticulo){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT s FROM Stock s "
                + " WHERE s.articulo.id = :idArticulo");

        q.setParameter("idArticulo", idArticulo);

        return q.getResultList();
    }
}
