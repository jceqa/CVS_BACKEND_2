package py.com.cvs2.dao;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import py.com.cvs2.dto.TokenDto;
import py.com.cvs2.model.Usuario;

public class UsuarioDao extends GenericDao<Usuario>{

	public TokenDto validarAcceso(Usuario usuario) {
		boolean ok = false;
		String token = "";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Usuario u " + "WHERE u.usuario=:usuario " + "AND u.clave=:clave");

		q.setParameter("usuario", usuario.getUsuario());
		q.setParameter("clave", usuario.getClave());

		Usuario u = (Usuario) q.getResultList().get(0);

		System.out.println(u.toString());

		try {
			token = JWT.create().withIssuer(u.getId().toString()).sign(Algorithm.HMAC256("sat"));
			ok = true;
		} catch (JWTCreationException | IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}

		TokenDto datos = new TokenDto();
		datos.setOk(ok);
		datos.setToken(token);
		return datos;
	}

	public Usuario getUserById(int id) {

		Usuario u;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT u FROM Usuario u " + "WHERE u.id=:id");

		q.setParameter("id", id);

		u = (Usuario) q.getResultList().get(0);

		return u;
	}

}
