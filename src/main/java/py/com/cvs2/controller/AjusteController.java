package py.com.cvs2.controller;

import py.com.cvs2.dao.AjusteDao;
import py.com.cvs2.model.Ajuste;
import py.com.cvs2.model.Estado;

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

    public List<Ajuste> listAjustesPendientes() {
        AjusteDao ajusteDao = new AjusteDao();
        return ajusteDao.listPendientes();
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

    public Ajuste cancelAjuste(Ajuste ajuste) throws Exception {
        AjusteDao ajusteDao = new AjusteDao();
        Estado estado = new Estado(2, "ANULADO");
        ajuste.setEstadoAjuste(estado);

        return ajusteDao.update(ajuste);
    }

    public Ajuste  processAjuste(Ajuste ajuste) throws Exception {
        AjusteDao ajusteDao = new AjusteDao();
        StockController stockController = new StockController();

        stockController.updateStock( ajuste.getStock().getDeposito().getId(), ajuste.getStock().getArticulo(), ajuste.getCantidad(), ajuste.getTipo());
        //stockController.updateStock(ajuste.getDestino().getId(), ajusteDetalle.getArticulo(), ajusteDetalle.getCantidad(), "AUMENTO");

        ajuste.setEstadoAjuste(new Estado(4, "PROCESADO"));

        return  ajusteDao.update(ajuste);
    }

}
