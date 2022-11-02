package py.com.cvs2.controller;

import py.com.cvs2.dao.UsuarioRolDao;
import py.com.cvs2.dto.UsuarioRolDto;
import py.com.cvs2.model.UsuarioRol;

import java.util.List;

public class UsuarioRolController {

	public List<UsuarioRolDto> getByIdUsuario(Integer idUsuario) {
		UsuarioRolDao urDAO = new UsuarioRolDao();
		List<UsuarioRolDto> ur = urDAO.findByIdUsuario(idUsuario);

		return ur;
	}

	public List<UsuarioRol> listUsuariosRol(Boolean all) {
		UsuarioRolDao usuarioRolDAO = new UsuarioRolDao();
		return usuarioRolDAO.list(all);
	}

	public UsuarioRol getUsuarioRolById(Integer id) {
		UsuarioRolDao usuarioRolDAO = new UsuarioRolDao();
		return usuarioRolDAO.findById(id);
	}

	public UsuarioRol saveUsuarioRol(UsuarioRol usuarioRol) throws Exception {
		UsuarioRolDao usuarioRolDao = new UsuarioRolDao();
		usuarioRol.setEstado("ACTIVO");
		return usuarioRolDao.save(usuarioRol);
	}

	public UsuarioRol updateUsuarioRol(UsuarioRol usuarioRol) throws Exception {
		UsuarioRolDao usuarioRolDao = new UsuarioRolDao();
		return usuarioRolDao.update(usuarioRol);
	}

	public void deleteUsuarioRol(Integer id) throws Exception {
		UsuarioRolDao usuarioRolDao = new UsuarioRolDao();
		UsuarioRol usuarioRol = usuarioRolDao.findById(id);
		usuarioRol.setEstado("INACTIVO");
		usuarioRolDao.update(usuarioRol);
		//usuarioRolDao.delete(id);
	}

}
