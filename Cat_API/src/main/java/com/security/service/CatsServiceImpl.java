package com.security.service;

import com.security.catInterface.CatsService;
import com.security.dto.CatsDTO;
import com.security.entity.Cats;
import com.security.mapping.CatMapping;
import com.security.repository.CatRepository;
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
public class CatsServiceImpl implements CatsService {


    private final CatRepository catRepository;
    private final CatMapping catMapping;
    private final RestClient restClient;

    @Value("${API_KEY}")
    private String key;

    @Value("${COMPLETE_URL}")
    private String url;

    @Override
    public CatsDTO postCat(@RequestBody CatsDTO catsDTO) {

        Cats catsEntity = catMapping.dtoToEntity(catsDTO);
        Cats savedCats = catRepository.save(catsEntity);

        return catMapping.entityToDto(savedCats);
    }

    @Override
    public List<Cats> getAllCats() {

        List<Cats> cats = new ArrayList<Cats>();
        Iterable<Cats> catsIterable = catRepository.findAll();
        catsIterable.forEach(cats::add);

        return cats;
    }

    @Override
    public Optional<Cats> getCatById(int id) {

        Optional<Cats> cat = catRepository.findById((long) id);
        return cat;
    }

    @Override
    public CatsDTO updateCat(int id, CatsDTO catDTO) {
        Optional<Cats> optionalCat = catRepository.findById((long) id);

        Cats catToUpdate = optionalCat.get();

        catToUpdate.setUrl(catDTO.url());
        catToUpdate.setHeight(catDTO.height());
        catToUpdate.setWidth(catDTO.width());
        catToUpdate.setIdCat(catDTO.id());

        Cats savedCat = catRepository.save(catToUpdate);

        return catMapping.entityToDto(savedCat);
    }


    @Override
    public boolean deleteCat(int id){
        Optional<Cats> cat = catRepository.findById((long) id);
        cat.ifPresent(catRepository::delete);
        return true;
    }

    public List<CatsDTO> getCatsToScrap(){
        List<CatsDTO> result = restClient
                .get()
                .uri(url +"images/search?limit=20&has_breeds=true")
                .header("x-api-key", key)
                .retrieve()
                .body(new ParameterizedTypeReference<List<CatsDTO>>() {});

        return result ;
    }


}
