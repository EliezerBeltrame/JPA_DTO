package com.example.jpaClass.Services;

import com.example.jpaClass.Entity.Professor;
import com.example.jpaClass.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfessorServices {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor fromDTO(ProfessorDTO professorDTO){
        Professor professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setCpf(professorDTO.getCpf());
        return professor;
    }
    public Professor save(ProfessorDTO professorDTO){
        Professor professor = this.fromDTO(professorDTO);
        Professor professorBd = professorRepository.save(professor);
        return professorBd;
    }

}
