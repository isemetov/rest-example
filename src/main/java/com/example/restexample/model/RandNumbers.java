package com.example.restexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RandNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;

    public int getNumber() {
        return number;
    }

    public RandNumbers() {
    }

    public RandNumbers(int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
