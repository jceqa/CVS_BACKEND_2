package py.com.cvs2.dao;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import py.com.cvs2.model.Marca;
import py.com.cvs2.model.Usuario;

public class UsuarioDao {

	public HashMap validarAcceso(Usuario usuario) {
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
			ok = true;
			token = JWT.create().withIssuer(u.getId().toString()).sign(Algorithm.HMAC256("sat"));
			ok = true;
		} catch (JWTCreationException | IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}

		HashMap datos = new HashMap();
		datos.put("ok", ok);
		datos.put("token", token);
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

	/*
	 * public Usuario buscarId(int id) { Usuario usuario = new Usuario();
	 * usuario.setId(0); usuario.setNombre(""); usuario.setUsuario("");
	 * usuario.setClave("");
	 * 
	 * Conexion conexion = new Conexion(); if (conexion.conectar()) { try { String
	 * sql = "select * from usuario " + "where id=?"; try (PreparedStatement ps =
	 * conexion.getCon().prepareStatement(sql)) { ps.setInt(1, id); ResultSet rs =
	 * ps.executeQuery(); if (rs.next()) { usuario.setId(rs.getInt("id"));
	 * usuario.setNombre(rs.getString("nombre"));
	 * usuario.setUsuario(rs.getString("usuario"));
	 * //usuario.setClave(rs.getString("clave_usuario")); } ps.close(); } } catch
	 * (SQLException ex) { System.out.println("--> " + ex.getLocalizedMessage()); }
	 * conexion.cerrar(); } return usuario; }
	 * 
	 * public boolean agregar(Usuario usuario) { boolean agregado = false; Conexion
	 * conexion = new Conexion(); if (conexion.conectar()) { try { String sql =
	 * "insert into usuario (" + "nombre," + "usuario," + "clave " + ") " +
	 * "values (?,?,(select md5(?)))"; try (PreparedStatement ps =
	 * conexion.getCon().prepareStatement(sql)) { ps.setString(1,
	 * usuario.getNombre()); ps.setString(2, usuario.getUsuario()); ps.setString(3,
	 * usuario.getClave()); int cr = ps.executeUpdate(); if (cr > 0) { agregado =
	 * true; conexion.getCon().commit(); } ps.close(); } } catch (SQLException ex) {
	 * System.out.println("--->" + ex.getLocalizedMessage()); try {
	 * conexion.getCon().rollback(); } catch (SQLException ex1) {
	 * System.out.println("-->" + ex.getLocalizedMessage()); } } }
	 * conexion.cerrar(); return agregado; }
	 * 
	 * public boolean modificar(Usuario usuario) { boolean modificado = false;
	 * Conexion conexion = new Conexion(); if (conexion.conectar()) { try { String
	 * sql = "update usuario set " + "nombre=?," + "usuario=?," +
	 * "clave=(select md5(?)) " + "where id=?"; try (PreparedStatement ps =
	 * conexion.getCon().prepareStatement(sql)) { ps.setString(1,
	 * usuario.getNombre()); ps.setString(2, usuario.getUsuario()); ps.setString(3,
	 * usuario.getClave()); ps.setInt(4, usuario.getId()); int cr =
	 * ps.executeUpdate(); if (cr > 0) { modificado = true;
	 * conexion.getCon().commit(); } ps.close(); } } catch (SQLException ex) {
	 * System.out.println("--->" + ex.getLocalizedMessage()); try {
	 * conexion.getCon().rollback(); } catch (SQLException ex1) {
	 * System.out.println("-->" + ex.getLocalizedMessage()); } } }
	 * conexion.cerrar(); return modificado; }
	 * 
	 * public boolean eliminar(int id) { boolean eliminado = false; Conexion
	 * conexion = new Conexion(); if (conexion.conectar()) { try { String sql =
	 * "delete from usuario " + "where id=?"; try (PreparedStatement ps =
	 * conexion.getCon().prepareStatement(sql)) { ps.setInt(1, id); int cr =
	 * ps.executeUpdate(); if (cr > 0) { eliminado = true;
	 * conexion.getCon().commit(); } ps.close(); } } catch (SQLException ex) {
	 * System.out.println("--->" + ex.getLocalizedMessage()); try {
	 * conexion.getCon().rollback(); } catch (SQLException ex1) {
	 * System.out.println("-->" + ex.getLocalizedMessage()); } } }
	 * conexion.cerrar(); return eliminado; }
	 * 
	 * public Map buscarNombre(String texto, int registrosPagina, int pagina) { int
	 * limit = registrosPagina; int offset = (pagina - 1) * registrosPagina; Map
	 * datos = new HashMap(); ArrayList cantidad = new ArrayList(); ArrayList
	 * usuarios = new ArrayList(); Conexion conexion = new Conexion(); if
	 * (conexion.conectar()) { try { String query =
	 * "select count(*) as cantidad from usuario " +
	 * "where upper(id || nombre || usuario) like ? "; String sql =
	 * "select * from usuario " + "where upper(nombre) like ? " + "order by id " +
	 * "limit ? offset ?"; try (PreparedStatement pst =
	 * conexion.getCon().prepareStatement(query)) { pst.setString(1, "%" +
	 * texto.toUpperCase() + "%"); ResultSet rset = pst.executeQuery(); while
	 * (rset.next()) { cantidad.add(rset.getInt("cantidad")); } pst.close(); } try
	 * (PreparedStatement ps = conexion.getCon().prepareStatement(sql)) {
	 * ps.setString(1, "%" + texto.toUpperCase() + "%"); ps.setInt(2, limit);
	 * ps.setInt(3, offset); ResultSet rs = ps.executeQuery(); while (rs.next()) {
	 * usuarios.add(new Usuario( rs.getInt("id"), rs.getString("nombre"),
	 * rs.getString("usuario"), rs.getString("clave") ) ); } ps.close(); } } catch
	 * (SQLException ex) { System.out.println("--> " + ex.getLocalizedMessage()); }
	 * conexion.cerrar(); } datos.put("cantidad", cantidad); datos.put("usuarios",
	 * usuarios); System.out.println(datos); return datos; }
	 * 
	 * public ArrayList listar(int desde_id, int hasta_id) { ArrayList usuarios =
	 * new ArrayList(); Conexion conexion = new Conexion(); if (conexion.conectar())
	 * { try { String sql = "select * from usuario " + "where id>=? " + "and id<=? "
	 * + "order by id"; try (PreparedStatement ps =
	 * conexion.getCon().prepareStatement(sql)) { ps.setInt(1, desde_id);
	 * ps.setInt(2, hasta_id); ResultSet rs = ps.executeQuery(); while (rs.next()) {
	 * usuarios.add(new Usuario( rs.getInt("id"), rs.getString("nombre"),
	 * rs.getString("usuario"), "" ) ); } ps.close(); } } catch (SQLException ex) {
	 * System.out.println("--> " + ex.getLocalizedMessage()); } conexion.cerrar(); }
	 * System.out.println(usuarios); return usuarios; }
	 */
}
