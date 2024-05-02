package com.omercan.product_app.model.service;

import com.omercan.product_app.model.entity.Product;
import com.omercan.product_app.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractProductService implements  EntityService<Product, Integer> {

    @Autowired
    protected ProductRepository productRepository;

    public abstract List<Product> findAllByOrderByPriceDesc();
    public abstract List<Product> findAllByPriceGreaterThan(Double price);
    public abstract List<Product> findAllByPriceLessThanEqual(Double price);
}
