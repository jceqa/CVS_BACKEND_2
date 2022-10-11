package py.com.cvs2.controller;

import py.com.cvs2.dao.NotaCreditoCompraDao;
import py.com.cvs2.dao.NotaDebitoCompraDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.NotaCreditoCompra;
import py.com.cvs2.model.NotaDebitoCompra;

import java.util.List;

public class NotaCreditoCompraController {
    public NotaCreditoCompra saveNotaCreditoCompra(NotaCreditoCompra notaCreditoCompra) throws Exception {
        NotaCreditoCompraDao notaCreditoCompraDao = new NotaCreditoCompraDao();
        notaCreditoCompra = notaCreditoCompraDao.save(notaCreditoCompra);

        return notaCreditoCompra;
    }

    public List<NotaCreditoCompra> listNotasCreditoCompra(Boolean all) {
        NotaCreditoCompraDao notaCreditoCompraDao = new NotaCreditoCompraDao();
        return notaCreditoCompraDao.list(all);
    }

    public List<NotaCreditoCompra> listNotasCreditoCompraPendientes() {
        NotaCreditoCompraDao notaCreditoCompraDao = new NotaCreditoCompraDao();
        return notaCreditoCompraDao.listPendientes();
    }

    public NotaCreditoCompra cancelNotaCreditoCompra(NotaCreditoCompra notaCreditoCompra) throws Exception {
        NotaCreditoCompraDao notaCreditoCompraDao = new NotaCreditoCompraDao();
        Estado estado = new Estado(2, "ANULADO");
        notaCreditoCompra.setEstadoNotaCreditoCompra(estado);

        return notaCreditoCompraDao.update(notaCreditoCompra);
    }
}
