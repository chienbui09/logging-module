package com.example.loggingmodule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("test/api/v1")
public class TestController {
    @GetMapping
    public ResponseEntity<?> getTest(){
        return ResponseEntity.of(Optional.of("tesst"));
    }
    @GetMapping("test/{id}")
    public ResponseEntity<?> getTest(@PathVariable("id") String id){
        return ResponseEntity.of(Optional.of("tesst" + id));
    }
}
