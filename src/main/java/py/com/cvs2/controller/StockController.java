package py.com.cvs2.controller;

import py.com.cvs2.dao.StockDao;
import py.com.cvs2.model.Articulo;
import py.com.cvs2.model.Deposito;
import py.com.cvs2.model.Stock;

import java.util.List;

public class StockController {

    public List<Stock> listStocks(Boolean all) {
        StockDao stockDao = new StockDao();
        return stockDao.list(all);
    }

    public List<Stock> listStockByDeposito(Integer idDeposito){
        StockDao stockDao = new StockDao();
        return stockDao.listStockByDeposito(idDeposito);
    }

    public List<Stock> listStockByArticulo(Integer idArticulo){
        StockDao stockDao = new StockDao();
        return stockDao.listStockByArticulo(idArticulo);
    }

    public Stock getStockByArticuloAndDeposito(Integer idArticulo, Integer idDeposito){
        StockDao stockDao = new StockDao();
        return stockDao.getByArticuloAndDeposito(idArticulo, idDeposito);
    }

    public Stock updateStock(Integer idDeposito, Articulo articulo, Integer cantidad, String tipoOperacion) throws Exception {
        StockDao stockDao = new StockDao();
        Stock stock = stockDao.getByArticuloAndDeposito(articulo.getId(), idDeposito);
        if(stock != null){
            if(tipoOperacion.equals("AUMENTO")){
                stock.setExistencia(stock.getExistencia() + cantidad);
            } else if(tipoOperacion.equals("DESCUENTO")) {
                if(stock.getExistencia() - cantidad < 0){
                    throw new Exception("No hay existencia para realizar esta operación");
                }
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
