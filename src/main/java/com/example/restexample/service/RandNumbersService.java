package com.example.restexample.service;

import com.example.restexample.model.RandNumbers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class RandNumbersService {

    public List<RandNumbers> createRandNum() {
        List<RandNumbers> randNumbers = new ArrayList<RandNumbers>();

        for (int i=1; i<=2000000; i++) {
            short randInt = (short) ((Math.random() * (9999 - 2)) + 2);
            RandNumbers randNumber = new RandNumbers(randInt);
            randNumbers.add(randNumber);
        }

        return randNumbers;
    }

    public List<RandNumbers> findPrimeNumbers(List<RandNumbers> randNumbers) {

        List<RandNumbers> primeNumbers = new ArrayList<RandNumbers>();
        for (RandNumbers num: randNumbers) {
            if (isPrime(num.getNumber())) primeNumbers.add(num);
        }

        return primeNumbers;
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
