package py.com.cvs2.controller;

import py.com.cvs2.dao.PagoDao;
import py.com.cvs2.model.Pago;

import java.util.List;

public class PagoController {

    public List<Pago> listPagos(Boolean all) {
        PagoDao pagoDAO = new PagoDao();
        return pagoDAO.list(all);
    }
}
