package com.tirage.springbackend.controller;

import com.tirage.springbackend.exception.ResourceNotFoundException;
import com.tirage.springbackend.model.Sujet;
import com.tirage.springbackend.repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class SujetController {
    @Autowired
    private SujetRepository sujetRepository;

    //get all students
    @GetMapping("/sujets")
    public List<Sujet> getAllEtudiants() {
        return sujetRepository.findAll();
    }

    //Create student rest api
    @PostMapping("/sujets")
    public Sujet createSujet(@RequestBody Sujet sujet) {
        return sujetRepository.save(sujet);
    }

    // get student by id rest api
    @GetMapping("/sujets/{id}")
    public ResponseEntity<Sujet> getSujetById(@PathVariable Long id) {
        Sujet sujet = sujetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sujet not exist with id:"+id));
        return ResponseEntity.ok(sujet);
    }

    // Update student rest api
    @PutMapping("/sujets/{id} ")
    public  ResponseEntity<Sujet> updateSujet(@PathVariable  Long id, @RequestBody Sujet sujetDetails){

        Sujet sujet = sujetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sujet not exist with id:"+id));

        sujet.setNom(sujetDetails.getNom());

        Sujet updatedSujet =  sujetRepository.save(sujet);
        return  ResponseEntity.ok(updatedSujet);
    }

    // delete student rest api
    public ResponseEntity <Map<String, Boolean>> deleteSujet(@PathVariable Long id){
        Sujet sujet = sujetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sujet not exist with id:"+id));
        sujetRepository.delete(sujet);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);

    }
}
