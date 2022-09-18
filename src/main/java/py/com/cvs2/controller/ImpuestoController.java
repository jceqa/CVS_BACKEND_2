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

import py.com.cvs2.dao.ImpuestoDao;
import py.com.cvs2.model.Impuesto;

public class ImpuestoController {

	public List<Impuesto> listImpuestos() {
		ImpuestoDao impuestoDAO = new ImpuestoDao();
		return impuestoDAO.list();
	}

	public Impuesto getImpuestoById(Integer id) {
		ImpuestoDao impuestoDAO = new ImpuestoDao();
		return impuestoDAO.findById(id);
	}

	public Impuesto saveImpuesto(Impuesto impuesto) throws Exception {
		ImpuestoDao impuestoDao = new ImpuestoDao();
		impuesto.setEstado("ACTIVO");
		return impuestoDao.save(impuesto);
	}

	public Impuesto updateImpuesto(Impuesto impuesto) throws Exception {
		ImpuestoDao impuestoDao = new ImpuestoDao();
		return impuestoDao.update(impuesto);
	}

	public void deleteImpuesto(Integer id) throws Exception {
		ImpuestoDao impuestoDao = new ImpuestoDao();
		Impuesto impuesto = impuestoDao.findById(id);
		impuesto.setEstado("INACTIVO");
		impuestoDao.update(impuesto);
		//impuestoDao.delete(id);
	}

}
