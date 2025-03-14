package com.security.dto;


import lombok.Builder;

import java.util.List;

@Builder
public record DataCatDTO (
        List<CatsDTO> dataCatsDTO
){

}
