package py.com.cvs2.controller;

import py.com.cvs2.dao.PagoDao;
import py.com.cvs2.dto.FiltroDto;
import py.com.cvs2.model.Pago;

import java.util.Date;
import java.util.List;

public class PagoController {

    public List<Pago> listPagos(Boolean all) {
        PagoDao pagoDAO = new PagoDao();
        return pagoDAO.list(all);
    }

    public List<Pago> filterPagosByDate(FiltroDto filtroDto){
        PagoDao pagoDao = new PagoDao();
        return pagoDao.filterByDate(filtroDto.getFechaInicio(), filtroDto.getFechaFin());
    }
}
