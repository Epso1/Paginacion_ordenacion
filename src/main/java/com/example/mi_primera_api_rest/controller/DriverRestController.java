package com.example.mi_primera_api_rest.controller;

import com.example.mi_primera_api_rest.dto.DriverDTO;
import com.example.mi_primera_api_rest.projections.DriverDetails;
import com.example.mi_primera_api_rest.model.Driver;
import com.example.mi_primera_api_rest.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class DriverRestController {

    private final DriverService driverService;

    @Autowired
    public DriverRestController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> getAll() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @GetMapping("/drivers/{code}")
    public ResponseEntity<DriverDTO> getDriverDTOByCode(@PathVariable String code) {
        return this.driverService.getDriverByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/driversid/{id}")
    public ResponseEntity<Optional<DriverDetails>> getDriverByDriverId(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.getDriverByDriverId(id));
    }

    @GetMapping("/drivers/sorted")
    public ResponseEntity<List<Driver>> getAllDriversSorted(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "driverId") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection)
    {
        Page<Driver> list = driverService.getAllDriversSorted(page, size, sortBy, sortDirection);
        return ResponseEntity.ok(list.getContent());
    }


    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver) {
        if(driver.getDriverId() != null){
            return ResponseEntity.badRequest().build();
        }
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);

    }

    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver) {
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }


    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> deleteByCode(@PathVariable String code) {
        this.driverService.deleteDriverByCode(code);
        return ResponseEntity.noContent().build();
    }
}
