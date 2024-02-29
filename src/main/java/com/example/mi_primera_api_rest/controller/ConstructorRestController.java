package com.example.mi_primera_api_rest.controller;

import com.example.mi_primera_api_rest.model.Constructor;
import com.example.mi_primera_api_rest.model.Driver;
import com.example.mi_primera_api_rest.projections.ConstructorDetails;
import com.example.mi_primera_api_rest.service.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ConstructorRestController {

    private final ConstructorService constructorService;

    @Autowired
    public ConstructorRestController(ConstructorService constructorService) {
        this.constructorService = constructorService;
    }

    @GetMapping("/constructors")
    public ResponseEntity<List<Constructor>> getAll() {
        return ResponseEntity.ok(constructorService.getAllConstructors());
    }

    @GetMapping("/constructors/{constructorref}")
    public ResponseEntity<Constructor> getConstructorByConstructorref(@PathVariable String constructorref) {
        return this.constructorService.getConstructorByConstructorref(constructorref)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/constructors")
    public ResponseEntity<Constructor> create(@RequestBody Constructor constructor) {
        if(constructor.getConstructorid() != null){
            return ResponseEntity.badRequest().build();
        }
        this.constructorService.saveConstructor(constructor);
        return ResponseEntity.ok(constructor);

    }

    @PutMapping("/constructors")
    public ResponseEntity<Constructor> update(@RequestBody Constructor constructor) {
        this.constructorService.saveConstructor(constructor);
        return ResponseEntity.ok(constructor);
    }


    @DeleteMapping("/constructors/{name}")
    public ResponseEntity<Constructor> deleteByName(@PathVariable String constructorref) {
        this.constructorService.deleteConstructorByConstructorref(constructorref);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/constructorsid/{id}")
    public ResponseEntity<ConstructorDetails> getConstructorByConstructorId(@PathVariable Long id) {
        return this.constructorService.getConstructorByConstructorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
