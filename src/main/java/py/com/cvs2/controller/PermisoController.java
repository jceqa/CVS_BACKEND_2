package py.com.cvs2.controller;

import java.util.List;

import py.com.cvs2.dao.PermisoDao;
import py.com.cvs2.model.Permiso;

public class PermisoController {

	public List<Permiso> listByRol(Integer id) {
		PermisoDao permisoDAO = new PermisoDao();
		List<Permiso> permisos = permisoDAO.findByRolId(id);

		return permisos;
	}

	public List<Permiso> listPermisos(Boolean all) {
		PermisoDao permisoDAO = new PermisoDao();
		return permisoDAO.list(all);
	}

	public Permiso getPermisoById(Integer id) {
		PermisoDao permisoDAO = new PermisoDao();
		return permisoDAO.findById(id);
	}

	public Permiso savePermiso(Permiso permiso) throws Exception {
		PermisoDao permisoDao = new PermisoDao();
		permiso.setEstado("ACTIVO");
		return permisoDao.save(permiso);
	}

	public Permiso updatePermiso(Permiso permiso) throws Exception {
		PermisoDao permisoDao = new PermisoDao();
		return permisoDao.update(permiso);
	}

	public void deletePermiso(Integer id) throws Exception {
		PermisoDao permisoDao = new PermisoDao();
		Permiso permiso = permisoDao.findById(id);
		permiso.setEstado("INACTIVO");
		permisoDao.update(permiso);
		//permisoDao.delete(id);
	}

}
