package com.example.mi_primera_api_rest.repository;

import com.example.mi_primera_api_rest.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {


}
