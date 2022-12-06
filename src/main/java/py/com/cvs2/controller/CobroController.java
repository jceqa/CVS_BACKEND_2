package py.com.cvs2.controller;

import py.com.cvs2.dao.CobroDao;
import py.com.cvs2.dto.FiltroDto;
import py.com.cvs2.model.Cobro;

import java.util.List;

public class CobroController {

    public List<Cobro> listCobros(Boolean all) {
        CobroDao cobroDAO = new CobroDao();
        return cobroDAO.list(all);
    }

    public List<Cobro> filterCobrosByDate(FiltroDto filtroDto){
        CobroDao cobroDao = new CobroDao();
        return cobroDao.filterByDate(filtroDto.getFechaInicio(), filtroDto.getFechaFin());
    }
}
