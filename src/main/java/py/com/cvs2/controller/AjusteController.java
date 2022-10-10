package py.com.cvs2.controller;

import py.com.cvs2.dao.AjusteDao;
import py.com.cvs2.model.Ajuste;

import java.util.List;

public class AjusteController {

    public List<Ajuste> listAjustes(Boolean all) {
        AjusteDao ajusteDAO = new AjusteDao();
        return ajusteDAO.list(all);
    }

    public Ajuste getAjusteById(Integer id) {
        AjusteDao ajusteDAO = new AjusteDao();
        return ajusteDAO.findById(id);
    }

    public Ajuste saveAjuste(Ajuste ajuste) throws Exception {
        AjusteDao ajusteDao = new AjusteDao();
        ajuste.setEstado("ACTIVO");
        return ajusteDao.save(ajuste);
    }

    public Ajuste updateAjuste(Ajuste ajuste) throws Exception {
        AjusteDao ajusteDao = new AjusteDao();
        return ajusteDao.update(ajuste);
    }

    public void deleteAjuste(Integer id) throws Exception {
        AjusteDao ajusteDao = new AjusteDao();
        Ajuste ajuste = ajusteDao.findById(id);
        ajuste.setEstado("INACTIVO");
        ajusteDao.update(ajuste);
        //ajusteDao.delete(id);
    }

}
