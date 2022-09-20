/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.controller;


import java.util.List;

import py.com.cvs2.dao.EstadoDao;
import py.com.cvs2.model.Estado;

public class EstadoController {

	public List<Estado> listEstados(Boolean all) {
		EstadoDao estadoDAO = new EstadoDao();
		return estadoDAO.list(all);
	}

	public Estado getEstadoById(Integer id) {
		EstadoDao estadoDAO = new EstadoDao();
		return estadoDAO.findById(id);
	}

	public Estado saveEstado(Estado estado) throws Exception {
		EstadoDao estadoDao = new EstadoDao();
		estado.setEstado("ACTIVO");
		return estadoDao.save(estado);
	}

	public Estado updateEstado(Estado estado) throws Exception {
		EstadoDao estadoDao = new EstadoDao();
		return estadoDao.update(estado);
	}

	public void deleteEstado(Integer id) throws Exception {
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.findById(id);
		estado.setEstado("INACTIVO");
		estadoDao.update(estado);
		//estadoDao.delete(id);
	}

}