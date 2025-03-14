package com.security.mapping;

import com.security.dto.BreedsDTO;
import com.security.dto.CatsDTO;
import com.security.entity.Breeds;
import com.security.entity.Cats;
import com.security.repository.BreedRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatMapping {

    BreedRepository breedRepository;

    public CatMapping(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }


    public Cats dtoToEntity(CatsDTO catsDTO) {
        List<Breeds> breedsList = new ArrayList<>();

        for (BreedsDTO breed : catsDTO.breeds() ){
            Breeds breedReturned = breedRepository.findByIdBreed(breed.id()).orElseThrow();

                breedsList.add(breedReturned);
        }
        return Cats.builder()
                .idCat(catsDTO.id())
                .url(catsDTO.url())
                .width(catsDTO.width())
                .height(catsDTO.height())
                .breeds(breedsList)
                .build();
    }

    public CatsDTO entityToDto(Cats cats) {
        return CatsDTO.builder()
                .id(cats.getIdCat())
                .url(cats.getUrl())
                .width(cats.getWidth())
                .height(cats.getHeight())
                .build();
    }
}