package py.com.cvs2.controller;

import py.com.cvs2.dao.TimbradoDao;
import py.com.cvs2.model.Timbrado;

import java.util.List;

public class TimbradoController {

    public List<Timbrado> listTimbrados(Boolean all) {
        TimbradoDao timbradoDAO = new TimbradoDao();
        return timbradoDAO.list(all);
    }

    public Timbrado getTimbradoById(Integer id) {
        TimbradoDao timbradoDAO = new TimbradoDao();
        return timbradoDAO.findById(id);
    }

    public Timbrado saveTimbrado(Timbrado timbrado) throws Exception {
        TimbradoDao timbradoDao = new TimbradoDao();
        timbrado.setEstado("ACTIVO");
        return timbradoDao.save(timbrado);
    }

    public Timbrado updateTimbrado(Timbrado timbrado) throws Exception {
        TimbradoDao timbradoDao = new TimbradoDao();
        return timbradoDao.update(timbrado);
    }

    public void deleteTimbrado(Integer id) throws Exception {
        TimbradoDao timbradoDao = new TimbradoDao();
        Timbrado timbrado = timbradoDao.findById(id);
        timbrado.setEstado("INACTIVO");
        timbradoDao.update(timbrado);
        //timbradoDao.delete(id);
    }
}
