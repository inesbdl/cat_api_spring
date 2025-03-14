package com.security.controller;

import com.security.catInterface.BreedsService;
import com.security.catInterface.CatsService;
import com.security.dto.BreedsDTO;
import com.security.dto.CatsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping(path = "/scrap")
public class ScrapperController {

    private final RestClient restClient;
    private final CatsService catsService;
    private final BreedsService breedsService;

    @Value("${API_KEY}")
    private String key;

    @Value("${COMPLETE_URL}")
    private String url;

    public ScrapperController(RestClient restClient, CatsService catsService, BreedsService breedsService) {
        this.restClient = restClient;
        this.catsService = catsService;
        this.breedsService = breedsService;
    }

    @GetMapping
    public String scrap() {
        return "scrap";
    }


    @GetMapping(path="/start")
    public String startScrapping(){

        List<CatsDTO> catsResponse = catsService.getCatsToScrap();
        List<BreedsDTO> breedsResponse = breedsService.getBreedsToScrap();

        // enregistrer les breeds en bdd
        for (BreedsDTO breed : breedsResponse) {
            breedsService.postBreed(breed);
        }

        //enregistrer les cars
        for (CatsDTO cat : catsResponse){
          catsService.postCat(cat);
        }

        return "Scrap completed successfully";
    }
}
