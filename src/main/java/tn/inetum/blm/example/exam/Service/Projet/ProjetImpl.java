package tn.inetum.blm.example.exam.Service.Projet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.inetum.blm.example.exam.Entities.Projet;
import tn.inetum.blm.example.exam.Entities.Sprint;
import tn.inetum.blm.example.exam.Repository.ProjetRepository;
import tn.inetum.blm.example.exam.Repository.SprintRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetImpl implements IProjetService{
    private  final ProjetRepository projetRepository;
    private  final SprintRepository sprintRepository;

    @Override
    @Transactional
    public Projet addProject(Projet project) {
        if(project.getSprintList()!=null) {
            projetRepository.saveAndFlush(project);
            project.getSprintList().forEach(sprint -> {
                sprint.setProjet(project);
            });
        }
        return project;
    }
}
