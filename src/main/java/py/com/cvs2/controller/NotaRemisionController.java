package py.com.cvs2.controller;

import py.com.cvs2.dao.NotaRemisionDao;
import py.com.cvs2.dao.PedidoCompraDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.NotaRemision;
import py.com.cvs2.model.NotaRemisionDetalle;
import py.com.cvs2.model.PedidoCompra;

import java.util.List;

public class NotaRemisionController {

    public NotaRemision saveNotaRemision(NotaRemision notaRemision) throws Exception {
        NotaRemisionDao notaRemisionDao = new NotaRemisionDao();
        notaRemision = notaRemisionDao.save(notaRemision);

        return notaRemision;
    }

    public List<NotaRemision> listNotasRemision(Boolean all) {
        NotaRemisionDao notaRemisionDao = new NotaRemisionDao();
        return notaRemisionDao.list(all);
    }

    public List<NotaRemision> listNotasRemisionPendientes() {
        NotaRemisionDao notaRemisionDao = new NotaRemisionDao();
        return notaRemisionDao.listPendientes();
    }

    public NotaRemision  processNotaRemision(NotaRemision notaRemision) throws Exception {
        NotaRemisionDao notaRemisionDao = new NotaRemisionDao();
        StockController stockController = new StockController();

        for(NotaRemisionDetalle notaRemisionDetalle : notaRemision.getNotaRemisionDetalle()) {
            stockController.updateStock(notaRemision.getOrigen().getId(), notaRemisionDetalle.getArticulo(), notaRemisionDetalle.getCantidad(), "DESCUENTO");
            stockController.updateStock(notaRemision.getDestino().getId(), notaRemisionDetalle.getArticulo(), notaRemisionDetalle.getCantidad(), "AUMENTO");
        }
        notaRemision.setEstadoNotaRemision(new Estado(4, "PROCESADO"));

        return  notaRemisionDao.update(notaRemision);
    }

    public NotaRemision cancelNotaRemision(NotaRemision notaRemision) throws Exception {
        NotaRemisionDao notaRemisionDao = new NotaRemisionDao();
        Estado estado = new Estado(2, "ANULADO");
        notaRemision.setEstadoNotaRemision(estado);

        return notaRemisionDao.update(notaRemision);
    }
}
