package py.com.cvs2.controller;

import java.util.List;

import py.com.cvs2.dao.EquipoDao;
import py.com.cvs2.model.Equipo;

public class EquipoController {

	public List<Equipo> listEquipos() {
		EquipoDao equipoDao = new EquipoDao();
		return equipoDao.list();
	}

	public Equipo getEquipoById(Integer id) {
		EquipoDao equipoDao = new EquipoDao();
		return equipoDao.findById(id);
	}

	public Equipo saveEquipo(Equipo equipo) {
		EquipoDao equipoDao = new EquipoDao();
		return equipoDao.save(equipo);
	}

	public Equipo updateEquipo(Equipo equipo) {
		EquipoDao equipoDao = new EquipoDao();
		return equipoDao.update(equipo);
	}

	public void deleteEquipo(Integer id) {
		EquipoDao equipoDao = new EquipoDao();
		equipoDao.delete(id);
	}

}
