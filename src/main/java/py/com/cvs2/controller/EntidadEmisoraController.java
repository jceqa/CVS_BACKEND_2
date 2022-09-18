/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.controller;


import java.util.List;

import py.com.cvs2.dao.EntidadEmisoraDao;
import py.com.cvs2.model.EntidadEmisora;

public class EntidadEmisoraController {

	public List<EntidadEmisora> listEntidadEmisoras() {
		EntidadEmisoraDao entidademisoraDAO = new EntidadEmisoraDao();
		return entidademisoraDAO.list();
	}

	public EntidadEmisora getEntidadEmisoraById(Integer id) {
		EntidadEmisoraDao entidademisoraDAO = new EntidadEmisoraDao();
		return entidademisoraDAO.findById(id);
	}

	public EntidadEmisora saveEntidadEmisora(EntidadEmisora entidademisora) throws Exception {
		EntidadEmisoraDao entidademisoraDao = new EntidadEmisoraDao();
		entidademisora.setEstado("ACTIVO");
		return entidademisoraDao.save(entidademisora);
	}

	public EntidadEmisora updateEntidadEmisora(EntidadEmisora entidademisora) throws Exception {
		EntidadEmisoraDao entidademisoraDao = new EntidadEmisoraDao();
		return entidademisoraDao.update(entidademisora);
	}

	public void deleteEntidadEmisora(Integer id) throws Exception {
		EntidadEmisoraDao entidademisoraDao = new EntidadEmisoraDao();
		EntidadEmisora entidadEmisora = entidademisoraDao.findById(id);
		entidadEmisora.setEstado("INACTIVO");
		entidademisoraDao.update(entidadEmisora);
		//entidademisoraDao.delete(id);
	}

}
