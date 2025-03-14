package com.security.mapping;

import com.security.dto.BreedsDTO;
import com.security.entity.Breeds;
import org.springframework.stereotype.Component;

@Component
public class BreedMapping {

    public Breeds dtoToEntity(BreedsDTO breedsDTO) {
        return Breeds.builder()
                .idBreed(breedsDTO.id())
                .name(breedsDTO.name())
                .lifespan(breedsDTO.life_span())
                .origin(breedsDTO.origin())
                .country_code(breedsDTO.country_code())
                .wikipedia_url(breedsDTO.wikipedia_url())
                .build();
    }

    public BreedsDTO entityToDto(Breeds breeds) {
        return BreedsDTO.builder()
                .id(breeds.getIdBreed())
                .name(breeds.getName())
                .life_span(breeds.getLifespan())
                .origin(breeds.getOrigin())
                .country_code(breeds.getCountry_code())
                .wikipedia_url(breeds.getWikipedia_url())
                .build();
    }
}