package com.example.spring_practice.mapper;

import com.example.spring_practice.dao.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    void addProduct(ProductDao product);
}