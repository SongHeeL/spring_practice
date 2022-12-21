package com.example.spring_practice.dto.response;

import lombok.*;

public class ProductResponseDTO {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDTO{
        private String name;
        private String info;
    }
}
