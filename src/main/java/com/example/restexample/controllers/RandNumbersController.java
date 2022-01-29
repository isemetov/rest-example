package com.example.restexample.controllers;

import com.example.restexample.model.RandNumbers;
import com.example.restexample.repo.RandNumbersRepository;
import com.example.restexample.service.RandNumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RandNumbersController {

    @Autowired
    private RandNumbersRepository randNumbersRepository;
    @Autowired
    private RandNumbersService randNumbersService;


    @GetMapping("/createRandNumbers")
    public ResponseEntity<Iterable<RandNumbers>> createRandNumbers(){

        randNumbersRepository.deleteAll();
        randNumbersRepository.saveAll(randNumbersService.createRandNum());

        //randNumbers = randNumbersRepository.findAll();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findPrimeNumbers")
    public ResponseEntity<Iterable<RandNumbers>> findPrimeNumbers() {
        List<RandNumbers> randNumbers, primeNumbers;
        randNumbers = randNumbersRepository.findAll();
        primeNumbers = randNumbersService.findPrimeNumbers(randNumbers);

        return primeNumbers.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(primeNumbers, HttpStatus.OK);
    }

}
