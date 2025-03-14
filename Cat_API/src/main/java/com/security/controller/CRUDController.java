package com.security.controller;

import com.security.catInterface.BreedsService;
import com.security.catInterface.CatsService;
import com.security.dto.BreedsDTO;
import com.security.dto.CatsDTO;
import com.security.entity.Breeds;
import com.security.entity.Cats;
import com.security.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RequestMapping(path = "/crud")
@RestController()
public class CRUDController {

    private final CatsService catsService;
    private final BreedsService breedsService;

    public CRUDController(CatsService catsService, BreedsService breedsService) {
        this.catsService=catsService;
        this.breedsService = breedsService;
    }


    @GetMapping
    public String crud() {
        return "cruded";
    }

    @GetMapping(path="/cats")
    public List<Cats> getAllCats(){
        List<Cats> cats = catsService.getAllCats();
        return cats;
    }

    @GetMapping(path="/cat")
    public Optional<Cats> getCatById(@RequestParam int id){
        Optional<Cats> cat = catsService.getCatById(id);
        return cat;
    }

    @PostMapping(path="/cat")
    public String addCat(@RequestBody CatsDTO catDTO) {
        catsService.postCat(catDTO);

        return "Your car has been added";
    }

    @PatchMapping(path = "/cat")
    public String updateCat(@RequestParam int id, @RequestBody CatsDTO catDTO) {
        catsService.updateCat(id, catDTO);
        return "Car updated";
    }

    @DeleteMapping(path = "/cat")
    public String deleteCat(@RequestParam int id) {
        catsService.deleteCat(id);
        return "Car deleted";
    }

    @GetMapping(path="/breeds")
    public List<Breeds> getAllBreeds(){
        List<Breeds> breeds = breedsService.getAllBreeds();
        return breeds;
    }

    @GetMapping(path="/breed")
    public Optional<Breeds> getBreedById(@RequestParam int id){
        Optional<Breeds> breed = breedsService.getBreedById(id);
        return breed;
    }

    @PostMapping(path="/breed")
    public String addBreed(@RequestBody BreedsDTO breedDTO) {
        breedsService.postBreed(breedDTO);

        return "Your breed has been added";
    }

    @PatchMapping(path = "/breed")
    public String updateBreed(@RequestParam int id, @RequestBody BreedsDTO breedDTO) {
        breedsService.updateBreed(id, breedDTO);
        return "Breed updated";
    }

    @DeleteMapping(path = "/breed")
    public String deleteBreed(@RequestParam int id) {
        breedsService.deleteBreed(id);
        return "Breed deleted";
    }


}
