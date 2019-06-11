package pe.isil.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.web.model.Policia;
import pe.isil.web.service.PoliciaService;

@Controller
public class PoliciaController {

    @Autowired
    PoliciaService policiaService;

    @GetMapping( {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/policia")
    public String getPersonaslist(Model model){
        model.addAttribute("policias", policiaService.getAll());
        return "policia";
    }

    @GetMapping("/policias/add")
    public String addPolicia(Model model){
        model.addAttribute("policia", new Policia());
        return "policia-add";
    }

    @PostMapping("/policias/save")
    public String savePolicia(Policia policia, Model model){

        policiaService.savePolicia(policia);

        model.addAttribute("policia", policiaService.getAll());

        return "policia";
    }

    @GetMapping("/policias/edit/{dni}")
    public String getPoliciaForEdit(@PathVariable Integer dni,
                                    Model model){
        model.addAttribute("policia",
                policiaService.findById(dni));
        return "policia-edit";
    }

    @PostMapping("/policias/{dni}")
    public String updatePolicia(@PathVariable Integer dni,
                                Policia policia,
                                Model model){
        policiaService.updatePolicia(dni, policia);
        model.addAttribute("policias",
                policiaService.getAll());
        return "policia";
    }

    @GetMapping("/policias/delete/{dni}")
    public String deletePolicias(@PathVariable Integer dni,
                                Model model){
        policiaService.deletePolicia(dni);
        model.addAttribute("policias",
                policiaService.getAll());
        return "policia";
    }
}
