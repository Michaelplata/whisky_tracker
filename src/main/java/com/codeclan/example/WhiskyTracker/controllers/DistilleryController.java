package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codeclan.example.WhiskyTracker.*;
import java.util.List;
import java.util.Optional;

@RestController
public class DistilleryController {
    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distillery/getbyregion")
    public ResponseEntity<List<Distillery>> getDistilleryByRegion(@RequestParam(name = "region") String region){
        return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
    }

    @GetMapping(value = "/distillery/getwhiskeyolderthan")
    public ResponseEntity <List<Distillery>> getWhiskeyOlderThan(){
        return new ResponseEntity<>(distilleryRepository.findByWhiskiesAge(12),HttpStatus.OK);
    }

}
