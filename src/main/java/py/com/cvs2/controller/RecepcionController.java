package py.com.cvs2.controller;


import py.com.cvs2.dao.MarcaDao;
import py.com.cvs2.dao.RecepcionDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.Marca;
import py.com.cvs2.model.Recepcion;

import java.util.List;

public class RecepcionController {

    public Recepcion saveRecepcion(Recepcion recepcion) throws Exception {
        RecepcionDao recepcionDao = new RecepcionDao();
        recepcion = recepcionDao.save(recepcion);

        return recepcion;
    }

    public List<Recepcion> listRecepcion(Boolean all) {
        RecepcionDao recepcionDao = new RecepcionDao();
        return recepcionDao.list(all);
    }

    public List<Recepcion> listRecepcionPendientes() {
        RecepcionDao recepcionDao = new RecepcionDao();
        return recepcionDao.listPendientes();
    }

    public Recepcion cancelRecepcion(Recepcion recepcion) throws Exception {
        RecepcionDao recepcionDao = new RecepcionDao();
        Estado estado = new Estado(2, "ANULADO");
        recepcion.setEstadoRecepcion(estado);

        return recepcionDao.update(recepcion);
    }
}