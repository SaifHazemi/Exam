package tn.inetum.blm.example.exam.Service.Sprint;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.inetum.blm.example.exam.Entities.Projet;
import tn.inetum.blm.example.exam.Entities.Sprint;
import tn.inetum.blm.example.exam.Repository.ProjetRepository;
import tn.inetum.blm.example.exam.Repository.SprintRepository;

import javax.swing.*;

@Service
@RequiredArgsConstructor
public class SprintImpl implements ISprintService {
    private  final SprintRepository sprintRepository;

    @Override
    public Sprint addSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }
}
