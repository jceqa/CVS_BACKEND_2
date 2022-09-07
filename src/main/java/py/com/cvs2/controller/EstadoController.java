/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.controller;


import java.util.List;

import py.com.cvs2.dao.EstadoDao;
import py.com.cvs2.model.Estado;

public class EstadoController {

	public List<Estado> listEstados() {
		EstadoDao estadoDAO = new EstadoDao();
		return estadoDAO.list();
	}

	public Estado getEstadoById(Integer id) {
		EstadoDao estadoDAO = new EstadoDao();
		return estadoDAO.findById(id);
	}

	public Estado saveEstado(Estado estado) {
		EstadoDao estadoDao = new EstadoDao();
		return estadoDao.save(estado);
	}

	public Estado updateEstado(Estado estado) {
		EstadoDao estadoDao = new EstadoDao();
		return estadoDao.update(estado);
	}

	public void deleteEstado(Integer id) {
		EstadoDao estadoDao = new EstadoDao();
		estadoDao.delete(id);
	}

}