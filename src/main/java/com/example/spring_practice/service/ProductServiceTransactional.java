package com.example.spring_practice.service;

import com.example.spring_practice.dao.ProductDao;
import com.example.spring_practice.dto.request.ProductRequestDTO;
import com.example.spring_practice.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceTransactional {
    private final ProductMapper productMapper;

    @Transactional
    public void addProductRequired(ProductRequestDTO productRequestDTO) {
        ProductDao product = ProductDao.builder()
                   .name(productRequestDTO.getName())
                   .info(productRequestDTO.getInfo())
                   .build();
        productMapper.addProduct(product);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void addProductSupports(ProductRequestDTO productRequestDTO) {
        ProductDao product = ProductDao.builder()
                .name(productRequestDTO.getName())
                .info(productRequestDTO.getInfo())
                .build();
        productMapper.addProduct(product);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addProductRequiredNew(ProductRequestDTO productRequestDTO) {
        ProductDao product = ProductDao.builder()
                .name(productRequestDTO.getName())
                .info(productRequestDTO.getInfo())
                .build();
        productMapper.addProduct(product);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void addProductMandatory(ProductRequestDTO productRequestDTO) {
        ProductDao product = ProductDao.builder()
                .name(productRequestDTO.getName())
                .info(productRequestDTO.getInfo())
                .build();
        productMapper.addProduct(product);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addProductNotSupported(ProductRequestDTO productRequestDTO) {
        ProductDao product = ProductDao.builder()
                .name(productRequestDTO.getName())
                .info(productRequestDTO.getInfo())
                .build();
        productMapper.addProduct(product);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void addProductNever(ProductRequestDTO productRequestDTO) {
        ProductDao product = ProductDao.builder()
                .name(productRequestDTO.getName())
                .info(productRequestDTO.getInfo())
                .build();
        productMapper.addProduct(product);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void addProductNested(ProductRequestDTO productRequestDTO) {
        ProductDao product = ProductDao.builder()
                .name(productRequestDTO.getName())
                .info(productRequestDTO.getInfo())
                .build();
        productMapper.addProduct(product);
        throw new RuntimeException();
    }
}
