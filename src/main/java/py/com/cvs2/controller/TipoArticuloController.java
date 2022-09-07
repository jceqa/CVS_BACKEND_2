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

import py.com.cvs2.dao.TipoArticuloDao;
import py.com.cvs2.model.TipoArticulo;

public class TipoArticuloController {

	public List<TipoArticulo> listTipoArticulos() {
		TipoArticuloDao tipoarticuloDAO = new TipoArticuloDao();
		return tipoarticuloDAO.list();
	}

	public TipoArticulo getTipoArticuloById(Integer id) {
		TipoArticuloDao tipoarticuloDAO = new TipoArticuloDao();
		return tipoarticuloDAO.findById(id);
	}

	public TipoArticulo saveTipoArticulo(TipoArticulo tipoarticulo) {
		TipoArticuloDao tipoarticuloDao = new TipoArticuloDao();
		return tipoarticuloDao.save(tipoarticulo);
	}

	public TipoArticulo updateTipoArticulo(TipoArticulo tipoarticulo) {
		TipoArticuloDao tipoarticuloDao = new TipoArticuloDao();
		return tipoarticuloDao.update(tipoarticulo);
	}

	public void deleteTipoArticulo(Integer id) {
		TipoArticuloDao tipoarticuloDao = new TipoArticuloDao();
		tipoarticuloDao.delete(id);
	}

}
