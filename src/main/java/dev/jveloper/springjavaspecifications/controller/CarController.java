package dev.jveloper.springjavaspecifications.controller;

import dev.jveloper.springjavaspecifications.dto.CarDto;
import dev.jveloper.springjavaspecifications.entities.Car;
import dev.jveloper.springjavaspecifications.service.CarService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
public class CarController {

    private final CarService carService;
    private final ModelMapper modelMapper;

    public CarController(CarService carService, ModelMapper modelMapper) {
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/car")
    public ResponseEntity<List<CarDto>> getCars(@RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam(required = false) String brand){

        return new ResponseEntity<>(carService.getAllCars(fromDate, toDate, brand).stream().map(c -> modelMapper.map(c, CarDto.class)).collect(Collectors.toList()), HttpStatus.OK);

    }

    @PostMapping("/car")
    public ResponseEntity<Car> saveCar(@RequestBody CarDto carDto){

        Car car = modelMapper.map(carDto, Car.class);
        return new ResponseEntity<>(carService.saveCar(car), HttpStatus.OK);

    }

}
