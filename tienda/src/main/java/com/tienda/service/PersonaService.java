
package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonaRepository personarepository;
            
    @Override
    public List<Persona> getAllPersona() {
       return(List<Persona>)personarepository.findAll();
    }

    @Override
    public Persona getPersonaById(long id) {
        return personarepository.findById(id).orElse(null);
    }

    @Override
    public void savePersona(Persona persona) {
       personarepository.save(persona);
    }

    @Override
    public void delete(long id) {
       personarepository.deleteById(id);
    }
    @Override
    public List<Persona> getAllPersona(String Apellido) {
        if(Apellido != null){
            return personarepository.findAll(Apellido);
        }
       return(List<Persona>)personarepository.findAll();
    }

    @Override
    public Persona findByNombre(String username) {
     return personarepository.findByNombre(username);
    }
}
