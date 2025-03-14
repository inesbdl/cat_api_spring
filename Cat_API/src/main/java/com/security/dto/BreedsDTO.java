package com.security.dto;

import lombok.Builder;

@Builder
public record BreedsDTO(
        String id,
        String name,
        String life_span,
        String origin,
        String country_code,
        String wikipedia_url
) {
}