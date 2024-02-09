package com.example.mi_primera_api_rest.service;

import com.example.mi_primera_api_rest.projections.DriverDetails;
import com.example.mi_primera_api_rest.dto.DriverDTO;
import com.example.mi_primera_api_rest.model.Driver;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> getAllDrivers();
    Optional<DriverDTO> getDriverByCode(String code);

    void saveDriver(Driver driver);

    void deleteDriverByCode(String code);

    Optional<DriverDetails> getDriverByDriverId(Long id);

    Page<Driver> getAllDriversSorted(Integer page, Integer size, String sortBy, String sortDirection);
}
