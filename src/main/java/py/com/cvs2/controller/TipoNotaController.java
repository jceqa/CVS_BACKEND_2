package py.com.cvs2.controller;
import java.util.List;

import py.com.cvs2.dao.TipoNotaDao;
import py.com.cvs2.model.TipoNota; 

public class TipoNotaController {
    
    public List<TipoNota> listTipoNotas(Boolean all) {
        TipoNotaDao tipoNotaDAO = new TipoNotaDao();
        return tipoNotaDAO.list(all);
    }

    public TipoNota getTipoNotaById(Integer id) {
        TipoNotaDao tipoNotaDAO = new TipoNotaDao();
        return tipoNotaDAO.findById(id);
    }

    public TipoNota saveTipoNota(TipoNota tipoNota) throws Exception {
        TipoNotaDao tipoNotaDao = new TipoNotaDao();
        tipoNota.setEstado("ACTIVO");
        return tipoNotaDao.save(tipoNota);
    }

    public TipoNota updateTipoNota(TipoNota tipoNota) throws Exception {
        TipoNotaDao tipoNotaDao = new TipoNotaDao();
        return tipoNotaDao.update(tipoNota);
    }

    public void deleteTipoNota(Integer id) throws Exception {
        TipoNotaDao tipoNotaDao = new TipoNotaDao();
        TipoNota tipoNota = tipoNotaDao.findById(id);
        tipoNota.setEstado("INACTIVO");
        tipoNotaDao.update(tipoNota);

        //tipoNotaDao.delete(id);
    }
}
