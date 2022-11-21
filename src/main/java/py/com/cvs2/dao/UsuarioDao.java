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

	public TokenDto validarAcceso(Usuario usuario) throws Exception {
		boolean ok = false;
		String token = "";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Usuario u "
				+ " WHERE u.usuario=:usuario "
				+ " AND u.clave=:clave "
				+ " AND u.estado='ACTIVO'");

		q.setParameter("usuario", usuario.getUsuario());
		q.setParameter("clave", usuario.getClave());

		if(q.getResultList() != null && q.getResultList().size() > 0) {
			Usuario u = (Usuario) q.getResultList().get(0);
			u.setIntentosFallidos(0);
			u = update(u);
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

		} else {
			Query q2 = em.createQuery("SELECT u FROM Usuario u "
					+ " WHERE u.usuario=:usuario ");

			q2.setParameter("usuario", usuario.getUsuario());
			if(q2.getResultList() != null && q2.getResultList().size() > 0) {
				Usuario user = (Usuario) q2.getResultList().get(0);
				user.setIntentosFallidos(user.getIntentosFallidos()+1);
				if(user.getIntentosFallidos() >=3){
					user.setEstado("INACTIVO");
				}
				user = update(user);
				if(user.getEstado() == "INACTIVO"){
					throw new Exception("Usuario bloqueado. Contacte con un Administrador.");
				}
				throw new Exception("Datos incorrectos. Le quedan " + (3 - user.getIntentosFallidos())
						+ " intentos antes que su cuenta sea bloqueada.");
			}
			throw new Exception("Usuario o contraseña incorrectos.");
		}
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
