package com.example.spring_practice.service;

import com.example.spring_practice.dao.*;
import com.example.spring_practice.dto.request.ProductRequestDTO;
import com.example.spring_practice.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductServiceTransactional productServiceTransactional;

    @Transactional
    public void addProduct(ProductRequestDTO productRequestDTO){
        try {
            ProductDao product = ProductDao.builder()
                    .name(productRequestDTO.getName())
                    .info(productRequestDTO.getInfo())
                    .build();
            productMapper.addProduct(product);
            //productServiceTransactional.addProductRequired(productRequestDTO);     // REQUIRED
            //productServiceTransactional.addProductSupports(productRequestDTO);     // SUPPORTS
            //productServiceTransactional.addProductRequiredNew(productRequestDTO);  // REQUIRED_NEW
            //productServiceTransactional.addProductNotSupported(productRequestDTO); // NOT_SUPPORTED
            //productServiceTransactional.addProductNever(productRequestDTO);        // NEVER
            //productServiceTransactional.addProductNested(productRequestDTO);       // NESTED
            productMapper.addProduct(product);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProductTransactional(ProductRequestDTO productRequestDTO){
        ProductDao product = ProductDao.builder()
                .name(productRequestDTO.getName())
                .info(productRequestDTO.getInfo())
                .build();
        productMapper.addProduct(product);
        //productServiceTransactional.addProductSupports(productRequestDTO);     // SUPPORTS
        //productServiceTransactional.addProductMandatory(productRequestDTO);    // MANDATORY
        productMapper.addProduct(product);
    }
}
