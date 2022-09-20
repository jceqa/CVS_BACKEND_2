/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.controller;


import java.util.List;

import py.com.cvs2.dao.TipoTarjetaDao;
import py.com.cvs2.model.TipoTarjeta;

public class TipoTarjetaController {

	public List<TipoTarjeta> listTipoTarjetas(Boolean all) {
		TipoTarjetaDao tipoTarjetaDAO = new TipoTarjetaDao();
		return tipoTarjetaDAO.list(all);
	}

	public TipoTarjeta getTipoTarjetaById(Integer id) {
		TipoTarjetaDao tipoTarjetaDAO = new TipoTarjetaDao();
		return tipoTarjetaDAO.findById(id);
	}

	public TipoTarjeta saveTipoTarjeta(TipoTarjeta tipoTarjeta) throws Exception {
		TipoTarjetaDao tipoTarjetaDao = new TipoTarjetaDao();
		tipoTarjeta.setEstado("ACTIVO");
		return tipoTarjetaDao.save(tipoTarjeta);
	}

	public TipoTarjeta updateTipoTarjeta(TipoTarjeta tipoTarjeta) throws Exception {
		TipoTarjetaDao tipoTarjetaDao = new TipoTarjetaDao();
		return tipoTarjetaDao.update(tipoTarjeta);
	}

	public void deleteTipoTarjeta(Integer id) throws Exception {
		TipoTarjetaDao tipoTarjetaDao = new TipoTarjetaDao();
		TipoTarjeta tipoTarjeta = tipoTarjetaDao.findById(id);
		tipoTarjeta.setEstado("INACTIVO");
		tipoTarjetaDao.update(tipoTarjeta);
		//tipoTarjetaDao.delete(id);
	}

}
