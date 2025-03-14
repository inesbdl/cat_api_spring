package com.security.controller;

import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RequestMapping(path = "/boing")
@RestController()
public class BoingController {

    private final RestClient restClient;

    @Value("${API_SCHEME}")
    private String scheme;

    @Value("${API_HOST}")
    private String host;

    @Value("${API_PATH}")
    private String path;

    @Value("${API_KEY}")
    private String key;

    public BoingController(RestClient restClient) {this.restClient = restClient;}

    @GetMapping
    public String boing() {
        return "Boing";
    }

    @GetMapping(path="/cats")
    public String cats(@RequestParam int limit) {
        return restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .scheme(scheme)
                        .host(host)
                        .path(path)
                        .queryParam("limit", limit)
                        .build())
                .header("x-api-key" , key)
                .retrieve()
                .body(String.class);
    }

    @GetMapping(path="/cats/race")
    public String getByrace(@RequestParam String race) {
        return restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .scheme(scheme)
                        .host(host)
                        .path(path)
                        .queryParam("breed_ids", race)
                        .build())
                .header("x-api-key" , key)
                .retrieve()
                .body(String.class);
    }
}
