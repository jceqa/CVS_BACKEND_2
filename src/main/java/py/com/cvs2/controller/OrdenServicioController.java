package py.com.cvs2.controller;

import py.com.cvs2.dao.DepositoDao;
import py.com.cvs2.dao.OrdenServicioDao;
import py.com.cvs2.dao.PedidoVentaDao;
import py.com.cvs2.dao.PresupuestoServicioDao;
import py.com.cvs2.model.*;

import java.util.List;

public class OrdenServicioController {

    public OrdenServicio saveOrdenServicio(OrdenServicio ordenServicio) throws Exception {
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        PresupuestoServicioDao presupuestoServicioDao = new PresupuestoServicioDao();
        DepositoDao depositoDao = new DepositoDao();

        StockController stockController = new StockController();

        PresupuestoServicio presupuestoServicio = ordenServicio.getPresupuestoServicio();
        presupuestoServicio.setEstadoPresupuestoServicio(new Estado(4, "PROCESADO"));

        Boolean descuento = false;
        for(OrdenServicioDetalle ordenServicioDetalle : ordenServicio.getOrdenServicioDetalles()){
            for(Servicio servicio : ordenServicioDetalle.getPresupuestoServicioDetalle().getDiagnosticoDetalle().getServicios()) {
                if(servicio.getArticulo() != null) {
                    List<Deposito> depositos = depositoDao.listDepositosBySucursal(ordenServicio.getPresupuestoServicio().getDiagnostico().getRecepcion().getSucursal().getId());
                    for(Deposito deposito : depositos){
                        Stock stock = stockController.getStockByArticuloAndDeposito(servicio.getArticulo().getId(), deposito.getId());
                        if(stock != null && stock.getExistencia() > 0){
                            stockController.updateStock(deposito.getId(), servicio.getArticulo(), 1, "DESCUENTO");
                            descuento = true;
                            break;
                        }
                        if(!descuento){
                            throw new Exception("No hay existencia para realizar esta operación");
                        }
                    }
                }
            }
        }
        presupuestoServicioDao.update(presupuestoServicio);

        return ordenServicioDao.save(ordenServicio);
    }

    public List<OrdenServicio> listOrdenServicioPendientes() {
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        return ordenServicioDao.listPendientes();
    }

    public List<OrdenServicio> listOrdenServicioPendientesByCliente(Integer idCliente) {
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        return ordenServicioDao.listPendientesByCliente(idCliente);
    }

    public List<OrdenServicio> listOrdenServicio(Boolean all) {
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        return ordenServicioDao.list(all);
    }

    public OrdenServicio cancelOrdenServicio(OrdenServicio ordenServicio) throws Exception {
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        PresupuestoServicioDao presupuestoServicioDao = new PresupuestoServicioDao();
        DepositoDao depositoDao = new DepositoDao();

        StockController stockController = new StockController();

        PresupuestoServicio presupuestoServicio = ordenServicio.getPresupuestoServicio();
        presupuestoServicio.setEstadoPresupuestoServicio(new Estado(1, "PENDIENTE"));
        presupuestoServicioDao.update(presupuestoServicio);

        ordenServicio.setEstadoOrdenServicio(new Estado(2, "ANULADO"));

        for(OrdenServicioDetalle ordenServicioDetalle : ordenServicio.getOrdenServicioDetalles()){
            for(Servicio servicio : ordenServicioDetalle.getPresupuestoServicioDetalle().getDiagnosticoDetalle().getServicios()) {
                if(servicio.getArticulo() != null) {
                    List<Deposito> depositos = depositoDao.listDepositosBySucursal(ordenServicio.getPresupuestoServicio().getDiagnostico().getRecepcion().getSucursal().getId());
                    for(Deposito deposito : depositos){
                        Stock stock = stockController.getStockByArticuloAndDeposito(servicio.getArticulo().getId(), deposito.getId());
                        if(stock != null){
                            stockController.updateStock(deposito.getId(), servicio.getArticulo(), 1, "AUMENTO");
                            break;
                        }
                    }
                }
            }
        }
        ordenServicioDao.update(ordenServicio);

        return ordenServicioDao.update(ordenServicio);
    }
}