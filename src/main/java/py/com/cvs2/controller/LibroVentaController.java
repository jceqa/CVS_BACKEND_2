package py.com.cvs2.controller;

import py.com.cvs2.dao.LibroVentaDao;
import py.com.cvs2.model.LibroVenta;

import java.util.List;

public class LibroVentaController {

    public LibroVenta saveLibroVenta(LibroVenta libroVenta) throws Exception {
        LibroVentaDao libroVentaDao = new LibroVentaDao();
        libroVenta = libroVentaDao.save(libroVenta);

        return libroVenta;
    }

    public List<LibroVenta> listLibrosVenta(Boolean all) {
        LibroVentaDao libroVentaDao = new LibroVentaDao();
        return libroVentaDao.list(all);
    }

    public LibroVenta cancelLibroVenta(LibroVenta libroVenta) throws Exception {
        LibroVentaDao libroVentaDao = new LibroVentaDao();
        //Estado estado = new Estado(2, "ANULADO");
        libroVenta.setEstado("INACTIVO");

        return libroVentaDao.update(libroVenta);
    }
}
