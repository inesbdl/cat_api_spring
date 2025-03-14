package com.security.repository;

import com.security.entity.Breeds;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BreedRepository extends CrudRepository<Breeds,Long> {

    Optional<Breeds> findByIdBreed(String idBreed);


}
