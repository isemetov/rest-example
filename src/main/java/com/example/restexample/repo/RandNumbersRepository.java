package com.example.restexample.repo;

import com.example.restexample.model.RandNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RandNumbersRepository extends JpaRepository<RandNumbers, Long> {

}
