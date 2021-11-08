package py.com.cvs2.controller;

import org.apache.commons.codec.digest.DigestUtils;

import py.com.cvs2.dao.UsuarioDao;
import py.com.cvs2.dto.TokenDto;
import py.com.cvs2.model.Usuario;
import py.com.cvs2.util.Configuracion;

public class UsuarioController {

	public TokenDto validar(Usuario usuario) {
		usuario.setClave(DigestUtils.md5Hex(usuario.getClave()));

		UsuarioDao usuariosDAO = new UsuarioDao();
		TokenDto datos = usuariosDAO.validarAcceso(usuario);

		return datos;
	}

	public Usuario getByToken(String token) {

		return Configuracion.getUsuarioJWT(token);
	}

}
