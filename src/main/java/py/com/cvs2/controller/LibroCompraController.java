package py.com.cvs2.controller;

import py.com.cvs2.dao.LibroCompraDao;
import py.com.cvs2.model.LibroCompra;

import java.util.List;

public class LibroCompraController {

    public LibroCompra saveLibroCompra(LibroCompra libroCompra) throws Exception {
        LibroCompraDao libroCompraDao = new LibroCompraDao();
        libroCompra = libroCompraDao.save(libroCompra);

        return libroCompra;
    }

    public List<LibroCompra> listLibrosCompra(Boolean all) {
        LibroCompraDao libroCompraDao = new LibroCompraDao();
        return libroCompraDao.list(all);
    }

    public LibroCompra cancelLibroCompra(LibroCompra libroCompra) throws Exception {
        LibroCompraDao libroCompraDao = new LibroCompraDao();
        //Estado estado = new Estado(2, "ANULADO");
        libroCompra.setEstado("INACTIVO");

        return libroCompraDao.update(libroCompra);
    }
}
