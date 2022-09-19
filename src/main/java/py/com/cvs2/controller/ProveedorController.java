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

    public Proveedor saveProveedor(Proveedor proveedor) throws Exception {
        ProveedorDao proveedorDao = new ProveedorDao();
        proveedor.setEstado("ACTIVO");
        return proveedorDao.save(proveedor);
    }

    public Proveedor updateProveedor(Proveedor proveedor) throws Exception {
        ProveedorDao proveedorDao = new ProveedorDao();
        return proveedorDao.update(proveedor);
    }

    public void deleteProveedor(Integer id) throws Exception {
        ProveedorDao proveedorDao = new ProveedorDao();
        Proveedor proveedor = proveedorDao.findById(id);
        proveedor.setEstado("INACTIVO");
        proveedorDao.update(proveedor);

        //proveedorDao.delete(id);
    }
}
