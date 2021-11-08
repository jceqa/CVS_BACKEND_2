package py.com.cvs2.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import py.com.cvs2.dao.UsuarioDao;
import py.com.cvs2.model.Usuario;

public class Configuracion {

	public static final int REGISTROS_POR_PAGINA = 5; // Constante statica (No hace falta instanciar)

	public static java.sql.Date convertirStringASqlDate(String fecha) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date parsed = null;
		try {
			parsed = format.parse(fecha);
		} catch (ParseException ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
		return sqlDate;
	}

	public static java.util.Date convertirStringAJavaDate(String fecha) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date javaDate = null;
		try {
			javaDate = format.parse(fecha);
		} catch (ParseException ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		return javaDate;
	}

	public static java.sql.Date convertirJavaDateASqlDate(java.util.Date fecha) {
		java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
		return sqlDate;
	}

	public static Usuario getUsuarioJWT(String token) {
		int idUsuario = 0;
		Usuario usuario;
		DecodedJWT jwt = JWT.decode(token);
		idUsuario = Integer.parseInt(jwt.getIssuer());

		UsuarioDao usuarioDAO = new UsuarioDao();
		usuario = usuarioDAO.getUserById(idUsuario);

		return usuario;
	}

	public static java.sql.Date getHoy() {
		return new java.sql.Date(new java.util.Date().getTime());
	}

	public static java.sql.Date convertirStringASqlDate2(String fecha) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsed = null;
		try {
			parsed = format.parse(fecha);
		} catch (ParseException ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
		return sqlDate;
	}
}
