package py.com.cvs2.controller;

import py.com.cvs2.dao.DepositoDao;
import py.com.cvs2.dao.StockDao;
import py.com.cvs2.model.Articulo;
import py.com.cvs2.model.Deposito;
import py.com.cvs2.model.Stock;

import java.util.List;

public class StockController {

    public List<Stock> listStockByDeposito(Integer idDeposito){
        StockDao stockDao = new StockDao();
        return stockDao.listStockByDeposito(idDeposito);
    }

    public List<Stock> listStockByArticulo(Integer idArticulo){
        StockDao stockDao = new StockDao();
        return stockDao.listStockByArticulo(idArticulo);
    }

    public Stock updateStock(Integer idDeposito, Articulo articulo, Integer cantidad, String tipoOperacion) throws Exception {
        StockDao stockDao = new StockDao();
        Stock stock = stockDao.getByArticuloAndDeposito(articulo.getId(), idDeposito);
        if(stock != null){
            if(tipoOperacion == "AUMENTO"){
                stock.setExistencia(stock.getExistencia() + cantidad);
            } else if(tipoOperacion == "DESCUENTO") {
                stock.setExistencia(stock.getExistencia() - cantidad);
            }
            stockDao.update(stock);
        } else {
            stock = new Stock();
            stock.setExistencia(cantidad);
            Deposito deposito = new Deposito();
            deposito.setId(idDeposito);
            stock.setDeposito(deposito);
            stock.setArticulo(articulo);
            stock.setEstado("ACTIVO");
            stockDao.save(stock);
        }

        return stock;
    }
}
