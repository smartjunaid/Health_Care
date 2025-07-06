package com.healthcare.controller;

import com.healthcare.entity.State;
import com.healthcare.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateRepository stateRepo;

    @GetMapping
    public List<State> getAllStates() {
        return stateRepo.findAll();
    }

    @GetMapping("/{name}")
    public State getState(@PathVariable String name) {
        return stateRepo.findById(name).orElse(null);
    }

    @PostMapping
    public String addState(@RequestBody State state) {
        if (stateRepo.existsById(state.getName())) {
            return "State already exists!";
        }
        stateRepo.save(state);
        return "State added successfully!";
    }

    @PutMapping("/{name}")
    public String updateState(@PathVariable String name, @RequestBody State updatedState) {
        if (!stateRepo.existsById(name)) {
            return "State not found!";
        }
        updatedState.setName(name);
        stateRepo.save(updatedState);
        return "State updated successfully!";
    }

    @DeleteMapping("/{name}")
    public String deleteState(@PathVariable String name) {
        if (!stateRepo.existsById(name)) {
            return "State not found!";
        }
        stateRepo.deleteById(name);
        return "State deleted successfully!";
    }
}
