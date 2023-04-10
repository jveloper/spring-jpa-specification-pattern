package dev.jveloper.springjavaspecifications.service;

import dev.jveloper.springjavaspecifications.entities.Car;
import dev.jveloper.springjavaspecifications.repositories.CarRepository;
import dev.jveloper.springjavaspecifications.specifications.CarSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CarService {

    private CarRepository  carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(String startDate, String endDate, String brand){
        return carRepository.findAll(Specification
                .where(CarSpecification.yearSpec(startDate,endDate))
                .and(CarSpecification.brandFSpec(brand)));

    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }
}
