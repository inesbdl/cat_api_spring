package com.security.catInterface;

import com.security.dto.CatsDTO;
import com.security.entity.Cats;

import java.util.List;
import java.util.Optional;

public interface CatsService {

    public CatsDTO postCat(CatsDTO catsDTO);

    public CatsDTO updateCat(int id, CatsDTO catsDTO);

    public List<Cats> getAllCats();

    Optional<Cats> getCatById(int id);

    boolean deleteCat(int id);

    List<CatsDTO> getCatsToScrap();
}