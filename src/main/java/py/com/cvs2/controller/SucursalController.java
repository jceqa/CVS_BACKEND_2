package py.com.cvs2.controller;


import py.com.cvs2.dao.SucursalDao;
import py.com.cvs2.model.Sucursal;

import java.util.List;

public class SucursalController {

    public List<Sucursal> listSucursales() {
        SucursalDao sucursalDAO = new SucursalDao();
        return sucursalDAO.list();
    }

    public Sucursal getSucursalById(Integer id) {
        SucursalDao sucursalDAO = new SucursalDao();
        return sucursalDAO.findById(id);
    }

    public Sucursal saveSucursal(Sucursal sucursal) throws Exception {
        SucursalDao sucursalDao = new SucursalDao();
        sucursal.setEstado("ACTIVO");
        return sucursalDao.save(sucursal);
    }

    public Sucursal updateSucursal(Sucursal sucursal) throws Exception {
        SucursalDao sucursalDao = new SucursalDao();
        return sucursalDao.update(sucursal);
    }

    public void deleteSucursal(Integer id) throws Exception {
        SucursalDao sucursalDao = new SucursalDao();
        Sucursal sucursal = sucursalDao.findById(id);
        sucursal.setEstado("INACTIVO");
        sucursalDao.update(sucursal);
        //sucursalDao.delete(id);
    }
}
