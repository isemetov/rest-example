package com.example.restexample.controllers;

import com.example.restexample.model.RandNumbers;
import com.example.restexample.repo.RandNumbersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandNumbersController {

    @Autowired
    private RandNumbersRepository randNumbersRepository;


    @GetMapping("/RandNumbers")
    public ResponseEntity<Iterable<RandNumbers>> read() {
        randNumbersRepository.deleteAll();
        for (int i=0; i<2000000; i++) {
            int randInt = (int) ((Math.random() * (9999 - 2)) + 2);
            RandNumbers randNumber = new RandNumbers(randInt);
            randNumbersRepository.save(randNumber);
        }
        Iterable<RandNumbers> randNumbers = randNumbersRepository.findAll();


        return new ResponseEntity<>(randNumbers, HttpStatus.OK);
    }

}
