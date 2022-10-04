package py.com.cvs2.controller;

import py.com.cvs2.dao.NotaDebitoCompraDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.NotaDebitoCompra;

import java.util.List;

public class NotaDebitoCompraController {

    public NotaDebitoCompra saveNotaDebitoCompra(NotaDebitoCompra notaDebitoCompra) throws Exception {
        NotaDebitoCompraDao notaDebitoCompraDao = new NotaDebitoCompraDao();
        notaDebitoCompra = notaDebitoCompraDao.save(notaDebitoCompra);

        return notaDebitoCompra;
    }

    public List<NotaDebitoCompra> listNotasDebitoCompra(Boolean all) {
        NotaDebitoCompraDao notaDebitoCompraDao = new NotaDebitoCompraDao();
        return notaDebitoCompraDao.list(all);
    }

    public NotaDebitoCompra cancelNotaDebitoCompra(NotaDebitoCompra notaDebitoCompra) throws Exception {
        NotaDebitoCompraDao notaDebitoCompraDao = new NotaDebitoCompraDao();
        Estado estado = new Estado(2, "ANULADO");
        notaDebitoCompra.setEstadoNotaDebitoCompra(estado);

        return notaDebitoCompraDao.update(notaDebitoCompra);
    }


}
