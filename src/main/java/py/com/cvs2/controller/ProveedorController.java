package py.com.cvs2.controller;

import py.com.cvs2.dao.ArticuloDao;
import py.com.cvs2.dao.ProveedorDao;
import py.com.cvs2.model.Articulo;
import py.com.cvs2.model.Proveedor;

import java.util.List;
public class ProveedorController {

    public List<Proveedor> listProveedores() {
        ProveedorDao proveedorDAO = new ProveedorDao();
        return proveedorDAO.list();
    }

    public Proveedor getProveedorById(Integer id) {
        ProveedorDao proveedorDAO = new ProveedorDao();
        return proveedorDAO.findById(id);
    }

    public Proveedor saveProveedor(Proveedor proveedor) {
        ProveedorDao proveedorDao = new ProveedorDao();
        return proveedorDao.save(proveedor);
    }

    public Proveedor updateProveedor(Proveedor proveedor) {
        ProveedorDao proveedorDao = new ProveedorDao();
        return proveedorDao.update(proveedor);
    }

    public void deleteProveedor(Integer id) {
        ProveedorDao proveedorDao = new ProveedorDao();
        proveedorDao.delete(id);
    }
}
