package py.com.cvs2.controller;

import py.com.cvs2.dao.NotaRemisionDao;
import py.com.cvs2.dao.PedidoCompraDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.NotaRemision;
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

    public NotaRemision cancelNotaRemision(NotaRemision notaRemision) throws Exception {
        NotaRemisionDao notaRemisionDao = new NotaRemisionDao();
        Estado estado = new Estado(2, "ANULADO");
        notaRemision.setEstadoNotaRemision(estado);

        return notaRemisionDao.update(notaRemision);
    }
}
