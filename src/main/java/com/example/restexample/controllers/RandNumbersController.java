package com.example.restexample.controllers;

import com.example.restexample.model.RandNumbers;
import com.example.restexample.repo.RandNumbersRepository;
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


    @GetMapping("/RandNumbers")
    public ResponseEntity<Iterable<RandNumbers>> read() {
        List<RandNumbers> randNumbers = new ArrayList<RandNumbers>();

        randNumbersRepository.deleteAll();

        for (int i=1; i<1000000; i++) {
            short randInt = (short) ((Math.random() * (9999 - 2)) + 2);
            RandNumbers randNumber = new RandNumbers(randInt, i);
            randNumbers.add(randNumber);
        }
        randNumbersRepository.saveAll(randNumbers);

        //randNumbers = randNumbersRepository.findAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
