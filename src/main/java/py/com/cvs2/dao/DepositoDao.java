package py.com.cvs2.dao;


import py.com.cvs2.model.Deposito;
import py.com.cvs2.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DepositoDao extends GenericDao<Deposito>{

    public List<Deposito> listDepositosBySucursal(Integer idSucursal){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT d FROM Deposito d "
            + " WHERE d.sucursal.id = :idSucursal "
            + " AND d.estado = 'ACTIVO'");

        q.setParameter("idSucursal", idSucursal);

        return q.getResultList();
    }
}