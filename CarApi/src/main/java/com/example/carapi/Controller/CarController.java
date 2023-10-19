package com.example.carapi.Controller;

import com.example.carapi.Model.CarModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class CarController {
    List<CarModel> cars = new ArrayList<>();

    public CarController() {
        cars.add(new CarModel(1, "Toyota", "Yaris", "Red"));
        cars.add(new CarModel(2, "Seat", "Leon", "White"));
        cars.add(new CarModel(3, "Mazda", "6", "Black"));

    }

    @GetMapping
    public List<CarModel> getAllCars() {
        return cars;
    }

    @GetMapping("/{id}")
    public CarModel getCarById(@PathVariable int id) {
        return cars.stream().filter(CarModel -> CarModel.getId() == id).findFirst().orElse(null);
    }

    @GetMapping(params = "color")
    public List<CarModel> getCarByColor(@RequestParam String color) {
        return cars.stream().filter(CarModel -> CarModel.getColor()
                .equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }
}
