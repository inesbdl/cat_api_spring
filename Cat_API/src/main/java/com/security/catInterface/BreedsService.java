package com.security.catInterface;


import com.security.dto.BreedsDTO;
import com.security.dto.CatsDTO;
import com.security.entity.Breeds;
import com.security.entity.Cats;

import java.util.List;
import java.util.Optional;

public interface BreedsService {

    public BreedsDTO postBreed(BreedsDTO breedsDTO);

    List<BreedsDTO> getBreedsToScrap();

    public BreedsDTO updateBreed(int id, BreedsDTO breedsDTO);

    public List<Breeds> getAllBreeds();

    Optional<Breeds> getBreedById(int id);

    boolean deleteBreed(int id);
}