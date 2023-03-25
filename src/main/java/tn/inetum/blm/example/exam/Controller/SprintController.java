package tn.inetum.blm.example.exam.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.inetum.blm.example.exam.Entities.Projet;
import tn.inetum.blm.example.exam.Entities.Sprint;
import tn.inetum.blm.example.exam.Service.Projet.ProjetImpl;
import tn.inetum.blm.example.exam.Service.Sprint.SprintImpl;

@RestController
@RequestMapping("/sprint")
@RequiredArgsConstructor
public class SprintController {
    private final SprintImpl sprintimp;
    @PostMapping()
    public void addSprint(@RequestBody Sprint sprint) {
        sprintimp.addSprint(sprint);
    }
    @PostMapping("{idProject}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable("idProject") int idProject ) {
        sprintimp.addSprintAndAssignToProject( sprint,idProject);
    }
}
