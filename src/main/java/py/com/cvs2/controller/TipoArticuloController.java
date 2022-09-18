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

	public TipoArticulo saveTipoArticulo(TipoArticulo tipoarticulo) throws Exception {
		TipoArticuloDao tipoarticuloDao = new TipoArticuloDao();
		tipoarticulo.setEstado("ACTIVO");
		return tipoarticuloDao.save(tipoarticulo);
	}

	public TipoArticulo updateTipoArticulo(TipoArticulo tipoarticulo) throws Exception {
		TipoArticuloDao tipoarticuloDao = new TipoArticuloDao();
		return tipoarticuloDao.update(tipoarticulo);
	}

	public void deleteTipoArticulo(Integer id) throws Exception {
		TipoArticuloDao tipoarticuloDao = new TipoArticuloDao();
		TipoArticulo tipoArticulo = tipoarticuloDao.findById(id);
		tipoArticulo.setEstado("INACTIVO");
		tipoarticuloDao.update(tipoArticulo);
		//tipoarticuloDao.delete(id);
	}

}
