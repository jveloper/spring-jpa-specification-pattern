package dev.jveloper.springjavaspecifications.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;


@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String brand;
    String model;
    Date date;
    Double price;
    Boolean isElectric;
    Boolean isHybrid;

}
