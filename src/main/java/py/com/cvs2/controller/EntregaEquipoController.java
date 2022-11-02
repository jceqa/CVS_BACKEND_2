package py.com.cvs2.controller;

import py.com.cvs2.dao.FacturaDao;
import py.com.cvs2.dao.EntregaEquipoDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.Factura;
import py.com.cvs2.model.EntregaEquipo;

import java.util.List;

public class EntregaEquipoController {

    public EntregaEquipo saveEntregaEquipo(EntregaEquipo entregaEquipo) throws Exception {
        EntregaEquipoDao entregaEquipoDao = new EntregaEquipoDao();
        FacturaDao facturaDao = new FacturaDao();

        Factura factura = entregaEquipo.getFactura();
        factura.setEstadoFactura(new Estado(4, "PROCESADO"));
        facturaDao.update(factura);

        entregaEquipo = entregaEquipoDao.save(entregaEquipo);

        return entregaEquipo;
    }

    public List<EntregaEquipo> listEntregaEquipos(Boolean all) {
        EntregaEquipoDao entregaEquipoDao = new EntregaEquipoDao();
        return entregaEquipoDao.list(all);
    }

    public List<EntregaEquipo> listEntregaEquiposBySucursal(Integer idSucursal) {
        EntregaEquipoDao entregaEquipoDao = new EntregaEquipoDao();
        return entregaEquipoDao.listBySucursal(idSucursal);
    }

    public List<EntregaEquipo> listEntregaEquipoPendientes() {
        EntregaEquipoDao entregaEquipoDao = new EntregaEquipoDao();
        return entregaEquipoDao.listPendientes();
    }


    public EntregaEquipo cancelEntregaEquipo(EntregaEquipo entregaEquipo) throws Exception {
        EntregaEquipoDao entregaEquipoDao = new EntregaEquipoDao();
        FacturaDao facturaDao = new FacturaDao();

        Factura factura = factura.getFactura();
        factura.setEstadoFactura(new Estado(1, "PENDIENTE"));
        facturaDao.update(factura);

        entregaEquipo.setEstadoEntregaEquipo(new Estado(2, "ANULADO"));

        return entregaEquipoDao.update(entregaEquipo);
    }
}