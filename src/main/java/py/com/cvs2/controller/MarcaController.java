package py.com.cvs2.controller;

import java.util.List;

import py.com.cvs2.dao.MarcaDao;
import py.com.cvs2.model.Marca;

public class MarcaController {

    public List<Marca> listMarcas() {
        MarcaDao marcaDAO = new MarcaDao();
        return marcaDAO.list();
    }

    public Marca getMarcaById(Integer id) {
        MarcaDao marcaDAO = new MarcaDao();
        return marcaDAO.findById(id);
    }

    public Marca saveMarca(Marca marca) throws Exception {
        MarcaDao marcaDao = new MarcaDao();
        return marcaDao.save(marca);
    }

    public Marca updateMarca(Marca marca) {
        MarcaDao marcaDao = new MarcaDao();
        return marcaDao.update(marca);
    }

    public void deleteMarca(Integer id) {
        MarcaDao marcaDao = new MarcaDao();
        marcaDao.delete(id);
    }

}
