package py.com.cvs2.controller;

import py.com.cvs2.dao.CajaDao;
import py.com.cvs2.model.Caja;

import java.util.List;

public class CajaController {

    public List<Caja> listCajas(Boolean all) {
        CajaDao cajaDAO = new CajaDao();
        return cajaDAO.list(all);
    }

    public List<Caja> listCajasBySucursal(List<Integer> id){
        CajaDao cajaDao = new CajaDao();
        return cajaDao.listBySucursal(id);
    }

    public Caja getCajaById(Integer id) {
        CajaDao cajaDAO = new CajaDao();
        return cajaDAO.findById(id);
    }

    public Caja saveCaja(Caja caja) throws Exception {
        CajaDao cajaDao = new CajaDao();
        caja.setEstado("ACTIVO");
        return cajaDao.save(caja);
    }

    public Caja updateCaja(Caja caja) throws Exception {
        CajaDao cajaDao = new CajaDao();
        return cajaDao.update(caja);
    }

    public void deleteCaja(Integer id) throws Exception {
        CajaDao cajaDao = new CajaDao();
        Caja caja = cajaDao.findById(id);
        caja.setEstado("INACTIVO");
        cajaDao.update(caja);
        //cajaDao.delete(id);
    }
}
