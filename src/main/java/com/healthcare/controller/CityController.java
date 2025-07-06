package com.healthcare.controller;

import com.healthcare.entity.City;
import com.healthcare.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepo;

    @GetMapping
    public List<City> getAllCities() {
        return cityRepo.findAll();
    }

    @GetMapping("/{name}")
    public City getCity(@PathVariable String name) {
        return cityRepo.findById(name).orElse(null);
    }

    @PostMapping
    public String addCity(@RequestBody City city) {
        if (cityRepo.existsById(city.getName())) {
            return "City already exists!";
        }
        cityRepo.save(city);
        return "City added successfully!";
    }

    @PutMapping("/{name}")
    public String updateCity(@PathVariable String name, @RequestBody City updatedCity) {
        if (!cityRepo.existsById(name)) {
            return "City not found!";
        }
        updatedCity.setName(name);
        cityRepo.save(updatedCity);
        return "City updated successfully!";
    }

    @DeleteMapping("/{name}")
    public String deleteCity(@PathVariable String name) {
        if (!cityRepo.existsById(name)) {
            return "City not found!";
        }
        cityRepo.deleteById(name);
        return "City deleted successfully!";
    }
}
