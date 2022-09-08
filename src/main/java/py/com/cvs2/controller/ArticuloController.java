package py.com.cvs2.controller;

import py.com.cvs2.dao.ArticuloDao;
import py.com.cvs2.model.Articulo;

import java.util.List;

public class ArticuloController {

    public List<Articulo> listArticulos() {
        ArticuloDao articuloDAO = new ArticuloDao();
        return articuloDAO.list();
    }

    public Articulo getArticuloById(Integer id) {
        ArticuloDao articuloDAO = new ArticuloDao();
        return articuloDAO.findById(id);
    }

    public Articulo saveArticulo(Articulo articulo) {
        ArticuloDao articuloDao = new ArticuloDao();
        return articuloDao.save(articulo);
    }

    public Articulo updateArticulo(Articulo articulo) {
        ArticuloDao articuloDao = new ArticuloDao();
        return articuloDao.update(articulo);
    }

    public void deleteArticulo(Integer id) {
        ArticuloDao articuloDao = new ArticuloDao();
        articuloDao.delete(id);
    }
}
