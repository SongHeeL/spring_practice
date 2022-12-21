package com.example.spring_practice.controller;

import com.example.spring_practice.dto.request.ProductRequestDTO;
import com.example.spring_practice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        productService.addProduct(productRequestDTO);
        //productService.addProductTransactional(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
