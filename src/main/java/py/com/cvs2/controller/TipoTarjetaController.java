/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.controller;


import java.util.List;

import py.com.cvs2.dao.TipoTarjetaDao;
import py.com.cvs2.model.TipoTarjeta;

public class TipoTarjetaController {

	public List<TipoTarjeta> listTipoTarjetas() {
		TipoTarjetaDao tipotarjetaDAO = new TipoTarjetaDao();
		return tipotarjetaDAO.list();
	}

	public TipoTarjeta getTipoTarjetaById(Integer id) {
		TipoTarjetaDao tipotarjetaDAO = new TipoTarjetaDao();
		return tipotarjetaDAO.findById(id);
	}

	public TipoTarjeta saveTipoTarjeta(TipoTarjeta tipotarjeta) throws Exception {
		TipoTarjetaDao tipotarjetaDao = new TipoTarjetaDao();
		return tipotarjetaDao.save(tipotarjeta);
	}

	public TipoTarjeta updateTipoTarjeta(TipoTarjeta tipotarjeta) {
		TipoTarjetaDao tipotarjetaDao = new TipoTarjetaDao();
		return tipotarjetaDao.update(tipotarjeta);
	}

	public void deleteTipoTarjeta(Integer id) {
		TipoTarjetaDao tipotarjetaDao = new TipoTarjetaDao();
		tipotarjetaDao.delete(id);
	}

}
