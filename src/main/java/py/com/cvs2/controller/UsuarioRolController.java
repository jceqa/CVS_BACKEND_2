package py.com.cvs2.controller;

import py.com.cvs2.dao.UsuarioRolDao;
import py.com.cvs2.model.UsuarioRol;

public class UsuarioRolController {

	public UsuarioRol getById(Integer id) {

		UsuarioRolDao urDAO = new UsuarioRolDao();
		UsuarioRol ur = urDAO.findById(id);

		return ur;
	}

}
