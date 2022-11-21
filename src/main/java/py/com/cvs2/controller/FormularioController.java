package py.com.cvs2.controller;

import py.com.cvs2.dao.FormularioDao;
import py.com.cvs2.model.Formulario;

import java.util.List;

public class FormularioController {

    public List<Formulario> listFormularios(Boolean all) {
        FormularioDao formularioDAO = new FormularioDao();
        return formularioDAO.list(all);
    }

    public Formulario getFormularioById(Integer id) {
        FormularioDao formularioDAO = new FormularioDao();
        return formularioDAO.findById(id);
    }

    public Formulario saveFormulario(Formulario formulario) throws Exception {
        FormularioDao formularioDao = new FormularioDao();
        formulario.setEstado("ACTIVO");
        return formularioDao.save(formulario);
    }

    public Formulario updateFormulario(Formulario formulario) throws Exception {
        FormularioDao formularioDao = new FormularioDao();
        return formularioDao.update(formulario);
    }

    public void deleteFormulario(Integer id) throws Exception {
        FormularioDao formularioDao = new FormularioDao();
        Formulario formulario = formularioDao.findById(id);
        formulario.setEstado("INACTIVO");
        formularioDao.update(formulario);
        //formularioDao.delete(id);
    }
}
