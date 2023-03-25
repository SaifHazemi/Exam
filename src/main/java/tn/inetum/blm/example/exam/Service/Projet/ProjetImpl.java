package tn.inetum.blm.example.exam.Service.Projet;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tn.inetum.blm.example.exam.Entities.Projet;
import tn.inetum.blm.example.exam.Entities.Sprint;
import tn.inetum.blm.example.exam.Entities.User;
import tn.inetum.blm.example.exam.Repository.ProjetRepository;
import tn.inetum.blm.example.exam.Repository.SprintRepository;
import tn.inetum.blm.example.exam.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetImpl implements IProjetService{
    private  final ProjetRepository projetRepository;
    private  final UserRepository userRepository;

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

    @Override
    @Transactional
    public void assignProjectToUser(int projectId, int userId) {
        Projet project = projetRepository.findById(projectId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        List<Projet> projetList = new ArrayList<>();
        projetList.add(project);
        user.setProjetList(projetList);
    }

    @Override
    public Projet getProjectById(int projetid) {
        return projetRepository.findById(projetid).orElse(null);
    }

    @Override
    @Transactional
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
        Projet project = projetRepository.findById(projectId).orElse(null);
        User user = userRepository.findByFnameAndIname(firstName,lastName);
        List<Projet> projetList = new ArrayList<>();
        projetList.add(project);
        user.setProjetList(projetList);
    }

    @Override
    public List<Projet> getAllCurrentProject() {
        return projetRepository.findByAndSprintListStartDateAfter();
    }

    @Override
    public List<Projet> getProjectsByScrumMaster(String fName, String lName) {
        User user = userRepository.findByFnameAndIname(fName,lName);
        return user.getProjetList();
    }

    @Override
    @Scheduled(cron = "*/30 * * * * *" )
    public List<Projet> getNbrSprintByCurrentProject() {
        return projetRepository.findByAndSprintListStartDateAfterOrderById();
    }
}
