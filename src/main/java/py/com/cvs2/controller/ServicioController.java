package py.com.cvs2.controller;
import py.com.cvs2.dao.ServicioDao;
import py.com.cvs2.model.Servicio;

import java.util.List;

public class ServicioController {

    public List<Servicio> listServicios(Boolean all) {
        ServicioDao servicioDAO = new ServicioDao();
        return servicioDAO.list(all);
    }

    public Servicio getServicioById(Integer id) {
        ServicioDao servicioDAO = new ServicioDao();
        return servicioDAO.findById(id);
    }

    public Servicio saveServicio(Servicio servicio) throws Exception {
        ServicioDao servicioDao = new ServicioDao();
        servicio.setEstado("ACTIVO");
        return servicioDao.save(servicio);
    }

    public Servicio updateServicio(Servicio servicio) throws Exception {
        ServicioDao servicioDao = new ServicioDao();
        return servicioDao.update(servicio);
    }

    public void deleteServicio(Integer id) throws Exception{
        ServicioDao servicioDao = new ServicioDao();

        Servicio servicio = servicioDao.findById(id);
        servicio.setEstado("INACTIVO");

        servicioDao.update(servicio);

        //servicioDao.delete(id);
    }
}