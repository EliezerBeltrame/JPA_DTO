package com.example.jpaClass.Controller;


import com.example.jpaClass.Entity.Professor;
import com.example.jpaClass.Services.ProfessorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProfessorController {
    @Autowired
    private ProfessorServices professorServices;

    @PostMapping
    public ResponseEntity<Professor> created(@RequestBody ProfessorDTO professorDTO){
        Professor professorBd = professorServices.save(professorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorBd);
    }
    @GetMapping

}