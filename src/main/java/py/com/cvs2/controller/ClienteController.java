package py.com.cvs2.controller;

import py.com.cvs2.dao.ClienteDao;
import py.com.cvs2.model.Cliente;

import java.util.List;

public class ClienteController {

    public List<Cliente> listClientes() {
        ClienteDao clienteDAO = new ClienteDao();
        return clienteDAO.list();
    }

    public Cliente getClienteById(Integer id) {
        ClienteDao clienteDAO = new ClienteDao();
        return clienteDAO.findById(id);
    }

    public Cliente saveCliente(Cliente cliente) throws Exception {
        ClienteDao clienteDao = new ClienteDao();
        cliente.setEstado("ACTIVO");
        return clienteDao.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente) throws Exception {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.update(cliente);
    }

    public void deleteCliente(Integer id) throws Exception {
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.findById(id);
        cliente.setEstado("INACTIVO");
        clienteDao.update(cliente);

        //clienteDao.delete(id);
    }
}