/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.controller;

/**
 *
 * @author PC-DTIC
 */
import java.util.List;

import py.com.cvs2.dao.CiudadDao;
import py.com.cvs2.model.Ciudad;

public class CiudadController {

	public List<Ciudad> listCiudades(Boolean all) {
		CiudadDao ciudadDAO = new CiudadDao();
		return ciudadDAO.list(all);
	}

	public Ciudad getCiudadById(Integer id) {
		CiudadDao ciudadDAO = new CiudadDao();
		return ciudadDAO.findById(id);
	}

	public Ciudad saveCiudad(Ciudad ciudad) throws Exception {
		CiudadDao ciudadDao = new CiudadDao();
		ciudad.setEstado("ACTIVO");
		return ciudadDao.save(ciudad);
	}

	public Ciudad updateCiudad(Ciudad ciudad) throws Exception {
		CiudadDao ciudadDao = new CiudadDao();
		return ciudadDao.update(ciudad);
	}

	public void deleteCiudad(Integer id) throws Exception {
		CiudadDao ciudadDao = new CiudadDao();
		Ciudad ciudad = ciudadDao.findById(id);
		ciudad.setEstado("INACTIVO");
		ciudadDao.update(ciudad);

		//ciudadDao.delete(id);
	}

}
