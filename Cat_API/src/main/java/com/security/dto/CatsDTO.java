package com.security.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CatsDTO(
        String id,
        String url,
        int width,
        int height,
        List<BreedsDTO> breeds
) {
}