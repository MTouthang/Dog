package com.dogrestapi.web;

import com.dogrestapi.entity.Dog;
import com.dogrestapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    /**
     * @return list of dogs
     */
    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDog(){
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    /**
     * @return list of dog breed
     */
    @GetMapping("/dogs/breeds")
    public ResponseEntity<List<String>> getAllBreed(){
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    /**
     * @param id
     * @return breed id
     */
    @GetMapping("/{id}/breed/")
    public ResponseEntity<String> getBreedById(@PathVariable Long id){
        String breed = dogService.retrieveDogById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    /**
     * @return dog names
     */
    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogName(){
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
}
