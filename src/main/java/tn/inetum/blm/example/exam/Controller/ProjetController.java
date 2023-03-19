package tn.inetum.blm.example.exam.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.inetum.blm.example.exam.Entities.Projet;
import tn.inetum.blm.example.exam.Service.Projet.ProjetImpl;

@RestController
@RequestMapping("/projet")
@RequiredArgsConstructor
public class ProjetController {
    private final ProjetImpl projetimp;
    @PostMapping()
    public Projet addProjet(@RequestBody Projet projet) {
        return projetimp.addProject(projet);
    }
}
