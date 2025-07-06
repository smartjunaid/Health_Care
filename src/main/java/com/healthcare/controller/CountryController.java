package com.healthcare.controller;

import com.healthcare.entity.Country;
import com.healthcare.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepo;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepo.findAll();
    }

    @GetMapping("/{name}")
    public Country getCountry(@PathVariable String name) {
        return countryRepo.findById(name).orElse(null);
    }

    @PostMapping
    public String addCountry(@RequestBody Country country) {
        if (countryRepo.existsById(country.getName())) {
            return "Country already exists!";
        }
        countryRepo.save(country);
        return "Country added successfully!";
    }

    @PutMapping("/{name}")
    public String updateCountry(@PathVariable String name, @RequestBody Country updatedCountry) {
        if (!countryRepo.existsById(name)) {
            return "Country not found!";
        }
        updatedCountry.setName(name);
        countryRepo.save(updatedCountry);
        return "Country updated successfully!";
    }

    @DeleteMapping("/{name}")
    public String deleteCountry(@PathVariable String name) {
        if (!countryRepo.existsById(name)) {
            return "Country not found!";
        }
        countryRepo.deleteById(name);
        return "Country deleted successfully!";
    }
}
