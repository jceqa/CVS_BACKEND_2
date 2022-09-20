package py.com.cvs2.controller;

import py.com.cvs2.dao.UsuarioRolDao;
import py.com.cvs2.dto.UsuarioRolDto;

import java.util.List;

public class UsuarioRolController {

	public List<UsuarioRolDto> getByIdUsuario(Integer idUsuario) {

		UsuarioRolDao urDAO = new UsuarioRolDao();
		List<UsuarioRolDto> ur = urDAO.findByIdUsuario(idUsuario);

		return ur;
	}

}
