package com.example.mi_primera_api_rest.repository;


import com.example.mi_primera_api_rest.projections.DriverDetails;
import com.example.mi_primera_api_rest.model.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByCodeIgnoreCase(String code);
    void deleteByCodeIgnoreCase(String code);

    Optional<DriverDetails> getDriverByDriverId(Long id);

    Page<Driver> findAllProjectedBy(Pageable pageable);
}
