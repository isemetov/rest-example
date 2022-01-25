package com.example.restexample.model;

import javax.persistence.*;

@Entity
public class RandNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="foo_sequence")
    @SequenceGenerator(name="emp_sequence", sequenceName = "emp_id_seq", allocationSize = 100)
    private Long id;

    private short number;

    public int getNumber() {
        return number;
    }

    public RandNumbers() {
    }

    public RandNumbers(short number) {
        this.number = number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
