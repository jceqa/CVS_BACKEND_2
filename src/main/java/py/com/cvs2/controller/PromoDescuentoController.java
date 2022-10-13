package py.com.cvs2.controller;

import py.com.cvs2.dao.PromoDescuentoDao;
import py.com.cvs2.model.PromoDescuento;

import java.util.List;

public class PromoDescuentoController {

    public List<PromoDescuento> listPromoDescuentos(Boolean all) {
        PromoDescuentoDao promoDescuentoDAO = new PromoDescuentoDao();
        return promoDescuentoDAO.list(all);
    }

    public PromoDescuento getPromoDescuentoById(Integer id) {
        PromoDescuentoDao promoDescuentoDAO = new PromoDescuentoDao();
        return promoDescuentoDAO.findById(id);
    }

    public PromoDescuento savePromoDescuento(PromoDescuento articulo) throws Exception {
        PromoDescuentoDao promoDescuentoDao = new PromoDescuentoDao();
        articulo.setEstado("ACTIVO");
        return promoDescuentoDao.save(articulo);
    }

    public PromoDescuento updatePromoDescuento(PromoDescuento promoDescuento) throws Exception {
        PromoDescuentoDao promoDescuentoDao = new PromoDescuentoDao();
        return promoDescuentoDao.update(promoDescuento);
    }

    public void deletePromoDescuento(Integer id) throws Exception{
        PromoDescuentoDao promoDescuentoDao = new PromoDescuentoDao();

        PromoDescuento promoDescuento = promoDescuentoDao.findById(id);
        promoDescuento.setEstado("INACTIVO");

        promoDescuentoDao.update(promoDescuento);

        //promoDescuentoDao.delete(id);
    }
}
