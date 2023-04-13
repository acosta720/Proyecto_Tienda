
package com.tienda.controller;


import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.IPaisService;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PersonaController {
     
    @Autowired
    private IPersonaService personaservice;
    
    @Autowired
    private IPaisService paisservice;
    
    @GetMapping("/persona")
    public String index(Model model,@Param("Apellido")String Apellido){
      List<Persona> listaPersona =  personaservice.getAllPersona(Apellido);
      model.addAttribute("titulo", "Tabla Personas");
      model.addAttribute("personas", listaPersona);
       model.addAttribute("Apellido", Apellido);
      return "personas";
    }
    @GetMapping("/personaN")
    public String crearPersona(Model model){
      List<Pais> listaPaises = paisservice.listCountry();
      model.addAttribute("personas", new Persona());
      model.addAttribute("paises", listaPaises);
      return "crear";
    }
    @GetMapping("/delete/{id}")
   public String deletePersona(@PathVariable Long id){
       personaservice.delete(id);
       return "redirect:/persona";
   }
   @PostMapping("/save")
   public String guardarpersona(@ModelAttribute Persona persona){
      personaservice.savePersona(persona);
      return "redirect:/persona";
   }
   
   @GetMapping("/editPersona/{id}")
   public String editarpersona(@PathVariable("id") Long idPersona, Model model){
       Persona persona= personaservice.getPersonaById(idPersona);
        List<Pais> listaPaises = paisservice.listCountry();
       model.addAttribute("personas", new Persona());
      model.addAttribute("paises", listaPaises);
       return "crear";
   }
   
}
