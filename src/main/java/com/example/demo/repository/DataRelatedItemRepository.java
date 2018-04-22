package com.example.demo.repository;

import com.example.demo.domain.DataRelatedItem;
import org.springframework.data.repository.CrudRepository;

public interface DataRelatedItemRepository extends CrudRepository<DataRelatedItem, Integer> {
}
