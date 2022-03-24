package com.dogrestapi.service;

import com.dogrestapi.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogById(Long id);
    List<String> retrieveDogNames();


}

