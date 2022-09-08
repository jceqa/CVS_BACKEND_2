package py.com.cvs2.controller;

import py.com.cvs2.dao.PersonaDao;
import py.com.cvs2.model.Persona;

import java.util.List;

public class PersonaController {

    public List<Persona> listPersonas() {
        PersonaDao personaDAO = new PersonaDao();
        return personaDAO.list();
    }

    public Persona getPersonaById(Integer id) {
        PersonaDao personaDAO = new PersonaDao();
        return personaDAO.findById(id);
    }

    public Persona savePersona(Persona persona) {
        PersonaDao personaDao = new PersonaDao();
        return personaDao.save(persona);
    }

    public Persona updatePersona(Persona persona) {
        PersonaDao personaDao = new PersonaDao();
        return personaDao.update(persona);
    }

    public void deletePersona(Integer id) {
        PersonaDao personaDao = new PersonaDao();
        personaDao.delete(id);
    }
}
