package com.example.mi_primera_api_rest.service;

import com.example.mi_primera_api_rest.model.Result;
import com.example.mi_primera_api_rest.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    private final ResultRepository repository;

    @Autowired
    public ResultServiceImpl(ResultRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Result> getAll() {
        return repository.findAll();
    }


}
