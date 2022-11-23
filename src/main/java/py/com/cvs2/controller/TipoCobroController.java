package py.com.cvs2.controller;

import py.com.cvs2.dao.TipoCobroDao;
import py.com.cvs2.model.TipoCobro;

import java.util.List;

public class TipoCobroController {

    public List<TipoCobro> listTipoCobros(Boolean all) {
        TipoCobroDao tipoCobroDAO = new TipoCobroDao();
        return tipoCobroDAO.list(all);
    }

    public TipoCobro getTipoCobroById(Integer id) {
        TipoCobroDao tipoCobroDAO = new TipoCobroDao();
        return tipoCobroDAO.findById(id);
    }

    public TipoCobro saveTipoCobro(TipoCobro tipoCobro) throws Exception {
        TipoCobroDao tipoCobroDao = new TipoCobroDao();
        tipoCobro.setEstado("ACTIVO");
        return tipoCobroDao.save(tipoCobro);
    }

    public TipoCobro updateTipoCobro(TipoCobro tipoCobro) throws Exception {
        TipoCobroDao tipoCobroDao = new TipoCobroDao();
        return tipoCobroDao.update(tipoCobro);
    }

    public void deleteTipoCobro(Integer id) throws Exception {
        TipoCobroDao tipoCobroDao = new TipoCobroDao();
        TipoCobro tipoCobro = tipoCobroDao.findById(id);
        tipoCobro.setEstado("INACTIVO");
        tipoCobroDao.update(tipoCobro);
        //tipoCobroDao.delete(id);
    }
}
