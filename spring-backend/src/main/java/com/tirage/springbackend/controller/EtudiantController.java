package com.tirage.springbackend.controller;

import com.tirage.springbackend.exception.ResourceNotFoundException;
import com.tirage.springbackend.model.Etudiant;
import com.tirage.springbackend.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;

    //get all students
    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    //Create student rest api
    @PostMapping("/etudiants")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    // get student by id rest api
    @GetMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Etudiant not exist with id:"+id));
        return ResponseEntity.ok(etudiant);
    }

    // Update student rest api
    @PutMapping("/etudiants/{id} ")
    public  ResponseEntity<Etudiant> updateEtudiant(@PathVariable  Long id, @RequestBody Etudiant etudiantDetails){

        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Etudiant not exist with id:"+id));

        etudiant.setPrenom(etudiantDetails.getPrenom());
        etudiant.setNom(etudiantDetails.getNom());
        etudiant.setEmail(etudiantDetails.getEmail());

        Etudiant updatedEtudiant =  etudiantRepository.save(etudiant);
        return  ResponseEntity.ok(updatedEtudiant);
    }

    // delete student rest api
    public ResponseEntity <Map<String, Boolean>> deleteEtudiant(@PathVariable Long id){
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Etudiant not exist with id:"+id));
        etudiantRepository.delete(etudiant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);

    }
}
