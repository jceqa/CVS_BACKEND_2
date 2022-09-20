package py.com.cvs2.controller;

import java.util.List;

import py.com.cvs2.dao.MarcaDao;
import py.com.cvs2.model.Marca;

public class MarcaController {

	public List<Marca> listMarcas(Boolean all) {
		MarcaDao marcaDAO = new MarcaDao();
		return marcaDAO.list(all);
	}

	public Marca getMarcaById(Integer id) {
		MarcaDao marcaDAO = new MarcaDao();
		return marcaDAO.findById(id);
	}

	public Marca saveMarca(Marca marca) throws Exception {
		MarcaDao marcaDao = new MarcaDao();
		marca.setEstado("ACTIVO");
		return marcaDao.save(marca);
	}

	public Marca updateMarca(Marca marca) throws Exception {
		MarcaDao marcaDao = new MarcaDao();
		return marcaDao.update(marca);
	}

	public void deleteMarca(Integer id) throws Exception {
		MarcaDao marcaDao = new MarcaDao();
		Marca marca = marcaDao.findById(id);
		marca.setEstado("INACTIVO");
		marcaDao.update(marca);
		//marcaDao.delete(id);
	}
}
