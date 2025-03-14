package com.security.repository;

import com.security.entity.Cats;
import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cats,Long> {

    
}
