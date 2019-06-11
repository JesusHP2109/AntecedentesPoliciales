package pe.isil.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.web.model.Persona;
import pe.isil.web.service.PersonaService;

@Controller
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping( {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/personas")
    public String getPersonaslist(Model model){
        model.addAttribute("personas", personaService.getAll());
        return "persona";
    }

    @GetMapping("/personas/add")
    public String addPersona(Model model){
        model.addAttribute("persona", new Persona());
        return "persona-add";
    }

    @PostMapping("/personas/save")
    public String savePersona(Persona persona, Model model){

        personaService.savePersona(persona);

        model.addAttribute("personas", personaService.getAll());

        return "persona";
    }

    @GetMapping("/personas/edit/{dni}")
    public String getPersonaForEdit(@PathVariable Integer dni,
                                    Model model){
        model.addAttribute("persona",
                personaService.findById(dni));
        return "persona-edit";
    }

    @PostMapping("/personas/{dni}")
    public String updatePersona(@PathVariable Integer dni,
                                Persona persona,
                                Model model){
        personaService.updatePersona(dni, persona);
        model.addAttribute("personas",
                personaService.getAll());
        return "persona";
    }

    @GetMapping("/personas/delete/{dni}")
    public String deletePersona(@PathVariable Integer dni,
                                Model model){
        personaService.deletePersona(dni);
        model.addAttribute("personas",
                personaService.getAll());
        return "persona";
    }
}
