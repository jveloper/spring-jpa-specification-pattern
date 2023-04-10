package dev.jveloper.springjavaspecifications.dto;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class CarDto {

    Integer id;
    String brand;
    String model;
    Date date;
    Double price;
    Boolean isElectric;
    Boolean isHybrid;
}
