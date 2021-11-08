package py.com.cvs2.controller;

import java.util.List;

import py.com.cvs2.dao.PermisoDao;
import py.com.cvs2.model.Permiso;

public class PermisoController {

	public List<Permiso> listByRol(Integer id) {

		PermisoDao permisoDAO = new PermisoDao();
		List<Permiso> permisos = permisoDAO.findById(id);

		return permisos;

	}

}
