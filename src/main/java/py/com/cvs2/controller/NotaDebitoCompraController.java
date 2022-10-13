package py.com.cvs2.controller;

import py.com.cvs2.dao.NotaDebitoCompraDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.NotaDebitoCompra;
import py.com.cvs2.model.NotaDebitoCompraDetalle;

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

    public List<NotaDebitoCompra> listNotasDebitoCompraPendientes() {
        NotaDebitoCompraDao notaDebitoCompraDao = new NotaDebitoCompraDao();
        return notaDebitoCompraDao.listPendientes();
    }

    public NotaDebitoCompra cancelNotaDebitoCompra(NotaDebitoCompra notaDebitoCompra) throws Exception {
        NotaDebitoCompraDao notaDebitoCompraDao = new NotaDebitoCompraDao();
        Estado estado = new Estado(2, "ANULADO");
        notaDebitoCompra.setEstadoNotaDebitoCompra(estado);

        return notaDebitoCompraDao.update(notaDebitoCompra);
    }

    public NotaDebitoCompra processNotaDebitoCompra(NotaDebitoCompra notaDebitoCompra) throws Exception {
        NotaDebitoCompraDao notaDebitoCompraDao = new NotaDebitoCompraDao();

        notaDebitoCompra.setEstadoNotaDebitoCompra(new Estado(4, "PROCESADO"));
        notaDebitoCompra.getCuentaAPagar().setEstadoCuentaAPagar(new Estado(4, "PROCESADO"));

        return  notaDebitoCompraDao.update(notaDebitoCompra);
    }
}
