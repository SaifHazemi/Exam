package tn.inetum.blm.example.exam.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.inetum.blm.example.exam.Entities.Projet;
import tn.inetum.blm.example.exam.Service.Projet.ProjetImpl;

import java.util.List;

@RestController
@RequestMapping("/projet")
@RequiredArgsConstructor
public class ProjetController {
    private final ProjetImpl projetimp;
    @PostMapping()
    public Projet addProjet(@RequestBody Projet projet) {
        return projetimp.addProject(projet);
    }
    @PostMapping("{projet-id}/{user-id}")
    public void assignProjectToUser(@PathVariable("projet-id") Integer projectid , @PathVariable("user-id") Integer userid ) {
        projetimp.assignProjectToUser( projectid, userid);
    }
    @PostMapping("{projet-id}/{useriname}/{userlname}")
    public void assignProjectToClient(@PathVariable("projet-id") Integer projectid , @PathVariable("useriname") String useriname,@PathVariable("userlname") String userlname ) {
        projetimp.assignProjectToClient( projectid, useriname,userlname);
    }
    @GetMapping("{projet-id}")
    public Projet getProjectById(@PathVariable("projet-id") Integer projectid) {
        return projetimp.getProjectById( projectid);
    }
    @GetMapping()
    public List<Projet> getAllCurrentProject() {
        return projetimp.getAllCurrentProject();
    }
    @GetMapping("{fName}/{lName}")
    public List<Projet> getProjectsByScrumMaster(@PathVariable("fName") String fName, @PathVariable("lName") String lName) {
        return projetimp.getProjectsByScrumMaster(fName,lName);
    }
}
