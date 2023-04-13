
package com.tienda.repository;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
      public interface PersonaRepository extends CrudRepository<Persona,Long>{
        
       @Query("SELECT p FROM Persona p WHERE"
               + " CONCAT(p.apellido1,p.apellido2)"
               + " LIKE %?1%"   )
       public List<Persona> findAll(String Apellido);

       Persona findByNombre (String nombre);
}