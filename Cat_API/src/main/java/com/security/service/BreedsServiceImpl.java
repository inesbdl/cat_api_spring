package com.security.service;

import com.security.catInterface.BreedsService;
import com.security.dto.BreedsDTO;
import com.security.entity.Breeds;
import com.security.entity.Cats;
import com.security.mapping.BreedMapping;
import com.security.repository.BreedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BreedsServiceImpl implements BreedsService {


    private final BreedRepository breedRepository;
    private final BreedMapping breedMapping;
    private final RestClient restClient;

    @Value("${API_KEY}")
    private String key;

    @Value("${COMPLETE_URL}")
    private String url;

    public BreedsDTO postBreed(@RequestBody BreedsDTO breedsDTO) {

        Breeds breedsEntity = breedMapping.dtoToEntity(breedsDTO);
        Breeds savedBreeds = breedRepository.save(breedsEntity);

        return breedMapping.entityToDto(savedBreeds);
    }


    public List<BreedsDTO> getBreedsToScrap(){
        return restClient
                .get()
                .uri(url +"breeds")
                .header("x-api-key", key)
                .retrieve()
                .body(new ParameterizedTypeReference<List<BreedsDTO>>() {});

    }

    @Override
    public List<Breeds> getAllBreeds() {

        List<Breeds> breeds = new ArrayList<Breeds>();
        Iterable<Breeds> breedsIterable = breedRepository.findAll();
        breedsIterable.forEach(breeds::add);

        return breeds;
    }

    @Override
    public Optional<Breeds> getBreedById(int id) {

        Optional<Breeds> breed = breedRepository.findById((long) id);
        return breed;
    }

    @Override
    public BreedsDTO updateBreed(int id, BreedsDTO breedDTO) {
        Optional<Breeds> optionalBreed = breedRepository.findById((long) id);

        Breeds breedToUpdate = optionalBreed.get();

        breedToUpdate.setName(breedDTO.name());
        breedToUpdate.setLifespan(breedDTO.life_span());
        breedToUpdate.setOrigin(breedDTO.origin());
        breedToUpdate.setCountry_code(breedDTO.country_code());
        breedToUpdate.setWikipedia_url(breedDTO.wikipedia_url());
        breedToUpdate.setIdBreed(breedDTO.id());


        Breeds savedBreed = breedRepository.save(breedToUpdate);

        return breedMapping.entityToDto(savedBreed);
    }

    @Override
    public boolean deleteBreed(int id){
        Optional<Breeds> breed = breedRepository.findById((long) id);
        breed.ifPresent(breedRepository::delete);
        return true;
    }
}
