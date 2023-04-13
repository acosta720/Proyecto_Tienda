
package com.tienda.service;

import com.tienda.entity.Pais;
import com.tienda.repository.PaisRepository;
import com.tienda.service.IPaisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaisService implements IPaisService{
    
    @Autowired 
    private PaisRepository paisrepository;
    
    
    @Override
    public List<Pais> listCountry() {
      return (List<Pais>)paisrepository.findAll();
    }
    
}
