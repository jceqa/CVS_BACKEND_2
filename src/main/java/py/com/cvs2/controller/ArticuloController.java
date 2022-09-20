package py.com.cvs2.controller;

import py.com.cvs2.dao.ArticuloDao;
import py.com.cvs2.model.Articulo;

import java.util.List;

public class ArticuloController {

    public List<Articulo> listArticulos(Boolean all) {
        ArticuloDao articuloDAO = new ArticuloDao();
        return articuloDAO.list(all);
    }

    public Articulo getArticuloById(Integer id) {
        ArticuloDao articuloDAO = new ArticuloDao();
        return articuloDAO.findById(id);
    }

    public Articulo saveArticulo(Articulo articulo) throws Exception {
        ArticuloDao articuloDao = new ArticuloDao();
        articulo.setEstado("ACTIVO");
        return articuloDao.save(articulo);
    }

    public Articulo updateArticulo(Articulo articulo) throws Exception {
        ArticuloDao articuloDao = new ArticuloDao();
        return articuloDao.update(articulo);
    }

    public void deleteArticulo(Integer id) throws Exception{
        ArticuloDao articuloDao = new ArticuloDao();

        Articulo articulo = articuloDao.findById(id);
        articulo.setEstado("INACTIVO");

        articuloDao.update(articulo);

        //articuloDao.delete(id);
    }
}
