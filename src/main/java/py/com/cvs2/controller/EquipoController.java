package py.com.cvs2.controller;

import java.util.List;

import py.com.cvs2.dao.EquipoDao;
import py.com.cvs2.model.Equipo;

public class EquipoController {

	public List<Equipo> listEquipos(Boolean all) {
		EquipoDao equipoDao = new EquipoDao();
		return equipoDao.list(all);
	}

	public Equipo getEquipoById(Integer id) {
		EquipoDao equipoDao = new EquipoDao();
		return equipoDao.findById(id);
	}

	public Equipo saveEquipo(Equipo equipo) throws Exception {
		EquipoDao equipoDao = new EquipoDao();
		equipo.setEstado("ACTIVO");
		return equipoDao.save(equipo);
	}

	public Equipo updateEquipo(Equipo equipo) throws Exception {
		EquipoDao equipoDao = new EquipoDao();
		return equipoDao.update(equipo);
	}

	public void deleteEquipo(Integer id) throws Exception {
		EquipoDao equipoDao = new EquipoDao();
		Equipo equipo = equipoDao.findById(id);
		equipo.setEstado("INACTIVO");
		equipoDao.update(equipo);
		//equipoDao.delete(id);
	}

}
