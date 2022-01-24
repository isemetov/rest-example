package com.example.restexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RandNumbers {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private short number;

    public int getNumber() {
        return number;
    }

    public RandNumbers() {
    }

    public RandNumbers(short number, int id) {
        this.number = number;
        this.id = id;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
