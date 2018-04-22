package com.example.demo.repository;

import com.example.demo.domain.Data;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Data, Integer> {
}
