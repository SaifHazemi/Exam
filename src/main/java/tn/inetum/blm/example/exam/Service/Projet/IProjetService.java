package tn.inetum.blm.example.exam.Service.Projet;

import tn.inetum.blm.example.exam.Entities.Projet;

import java.util.List;

public interface IProjetService {
    public Projet addProject (Projet project);
    public void assignProjectToUser(int projectId,int userId);
    public Projet getProjectById (int projetid);
    public void assignProjectToClient(int projectId, String firstName, String lastName);
    public List<Projet> getAllCurrentProject() ;
    public List<Projet> getProjectsByScrumMaster(String fName, String lName);
    public List<Projet> getNbrSprintByCurrentProject();

}
