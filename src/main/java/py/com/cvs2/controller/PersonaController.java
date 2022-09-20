package py.com.cvs2.controller;

import py.com.cvs2.dao.PersonaDao;
import py.com.cvs2.model.Persona;

import java.util.List;

public class PersonaController {

    public List<Persona> listPersonas(Boolean all) {
        PersonaDao personaDAO = new PersonaDao();
        return personaDAO.list(all);
    }

    public Persona getPersonaById(Integer id) {
        PersonaDao personaDAO = new PersonaDao();
        return personaDAO.findById(id);
    }

    public Persona savePersona(Persona persona) throws Exception {
        PersonaDao personaDao = new PersonaDao();
        persona.setEstado("ACTIVO");
        return personaDao.save(persona);
    }

    public Persona updatePersona(Persona persona) throws Exception {
        PersonaDao personaDao = new PersonaDao();
        return personaDao.update(persona);
    }

    public void deletePersona(Integer id) throws Exception {
        PersonaDao personaDao = new PersonaDao();
        Persona persona = personaDao.findById(id);
        persona.setEstado("INACTIVO");
        personaDao.update(persona);
        //personaDao.delete(id);
    }
}
