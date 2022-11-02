package py.com.cvs2.controller;

import org.apache.commons.codec.digest.DigestUtils;

import py.com.cvs2.dao.UsuarioDao;
import py.com.cvs2.dao.UsuarioDao;
import py.com.cvs2.dto.TokenDto;
import py.com.cvs2.model.Usuario;
import py.com.cvs2.model.Usuario;
import py.com.cvs2.util.Configuracion;

import java.util.List;

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

	public List<Usuario> listUsuarios(Boolean all) {
		UsuarioDao usuarioDAO = new UsuarioDao();
		return usuarioDAO.list(all);
	}

	public Usuario getUsuarioById(Integer id) {
		UsuarioDao usuarioDAO = new UsuarioDao();
		return usuarioDAO.findById(id);
	}

	public Usuario saveUsuario(Usuario usuario) throws Exception {
		UsuarioDao usuarioDao = new UsuarioDao();
		usuario.setEstado("ACTIVO");
		return usuarioDao.save(usuario);
	}

	public Usuario updateUsuario(Usuario usuario) throws Exception {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.update(usuario);
	}

	public void deleteUsuario(Integer id) throws Exception {
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.findById(id);
		usuario.setEstado("INACTIVO");
		usuarioDao.update(usuario);
		//usuarioDao.delete(id);
	}

}
