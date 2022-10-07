package py.com.cvs2.controller;

import py.com.cvs2.dao.AperturaCierreCajaDao;
import py.com.cvs2.model.AperturaCierreCaja;

import java.util.List;

public class AperturaCierreCajaController {

    public List<AperturaCierreCaja> listAperturaCierreCajas(Boolean all) {
        AperturaCierreCajaDao aperturaCierreCajaDAO = new AperturaCierreCajaDao();
        return aperturaCierreCajaDAO.list(all);
    }

    public AperturaCierreCaja getAperturaCierreCajaById(Integer id) {
        AperturaCierreCajaDao aperturaCierreCajaDAO = new AperturaCierreCajaDao();
        return aperturaCierreCajaDAO.findById(id);
    }

    public AperturaCierreCaja saveAperturaCierreCaja(AperturaCierreCaja aperturaCierreCaja) throws Exception {
        AperturaCierreCajaDao aperturaCierreCajaDao = new AperturaCierreCajaDao();
        aperturaCierreCaja.setEstado("ACTIVO");
        return aperturaCierreCajaDao.save(aperturaCierreCaja);
    }

    public AperturaCierreCaja updateAperturaCierreCaja(AperturaCierreCaja aperturaCierreCaja) throws Exception {
        AperturaCierreCajaDao aperturaCierreCajaDao = new AperturaCierreCajaDao();
        return aperturaCierreCajaDao.update(aperturaCierreCaja);
    }

    public void deleteAperturaCierreCaja(Integer id) throws Exception {
        AperturaCierreCajaDao aperturaCierreCajaDao = new AperturaCierreCajaDao();
        AperturaCierreCaja aperturaCierreCaja = aperturaCierreCajaDao.findById(id);
        aperturaCierreCaja.setEstado("INACTIVO");
        aperturaCierreCajaDao.update(aperturaCierreCaja);
        //aperturaCierreCajaDao.delete(id);
    }
}
