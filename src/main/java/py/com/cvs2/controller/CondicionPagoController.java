/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.controller;


import java.util.List;

import py.com.cvs2.dao.CondicionPagoDao;
import py.com.cvs2.model.CondicionPago;

public class CondicionPagoController {

	public List<CondicionPago> listCondicionPagos() {
		CondicionPagoDao condicionpagoDAO = new CondicionPagoDao();
		return condicionpagoDAO.list();
	}

	public CondicionPago getCondicionPagoById(Integer id) {
		CondicionPagoDao condicionpagoDAO = new CondicionPagoDao();
		return condicionpagoDAO.findById(id);
	}

	public CondicionPago saveCondicionPago(CondicionPago condicionpago) throws Exception {
		CondicionPagoDao condicionpagoDao = new CondicionPagoDao();
		condicionpago.setEstado("ACTIVO");
		return condicionpagoDao.save(condicionpago);
	}

	public CondicionPago updateCondicionPago(CondicionPago condicionpago) throws Exception {
		CondicionPagoDao condicionpagoDao = new CondicionPagoDao();
		return condicionpagoDao.update(condicionpago);
	}

	public void deleteCondicionPago(Integer id) throws Exception {
		CondicionPagoDao condicionpagoDao = new CondicionPagoDao();
		CondicionPago condicionPago = condicionpagoDao.findById(id);
		condicionPago.setEstado("INACTIVO");
		condicionpagoDao.update(condicionPago);
		//condicionpagoDao.delete(id);
	}

}
