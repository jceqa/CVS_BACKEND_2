package py.com.cvs2.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.*;

public class GenericDao<T> {

    private final Class<T> type;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public GenericDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    public List<T> list(Boolean all) {
        List<T> tL;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        String tableName = type.toString().substring(type.toString().lastIndexOf(".") + 1);

        String query = "SELECT t FROM " + tableName + " t ";

        if(!all){
            query+= " WHERE t.estado = " + "'ACTIVO'";
        }

        query += " ORDER BY t.id ";

        Query q = em.createQuery(query);

        tL = q.getResultList();

        return tL;
    }

    public T findById(Integer id) {
        T t;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        t = (T) em.find(type, id);

        return t;
    }

    public T save(T t) throws Exception {

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
            EntityManager em = emf.createEntityManager();

            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(t);

            et.commit();
        } catch (RollbackException e) {
            //System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage() + " fin message");

            if (e.getMessage().contains("Ya existe la llave")) {
                if (e.getMessage().contains("descripcion")) {
                    throw new Exception("La descripción ya existe.");
                }
            }
            // System.out.println("Localized Message: " + e.getLocalizedMessage());
            throw new Exception("Error al insertar.");
        }
        return t;

    }

    public T update(T t) throws Exception {

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
            EntityManager em = emf.createEntityManager();

            EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(t);

            et.commit();
        }  catch (RollbackException e) {
            //System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage() + " fin message");

            if (e.getMessage().contains("Ya existe la llave")) {
                if (e.getMessage().contains("descripcion")) {
                    throw new Exception("La descripción ya existe.");
                }
            }
            // System.out.println("Localized Message: " + e.getLocalizedMessage());
            throw new Exception("Error al actualizar.");
        }
        return t;


    }

    public void delete(Integer id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.getReference(type, id));
        em.getTransaction().commit();

    }

}
