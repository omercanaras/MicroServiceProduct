package com.omercan.product_app.model.service;

import com.omercan.product_app.model.entity.Product;

import com.omercan.product_app.utility.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends AbstractProductService
{

    @Override
    public List<Product> findAllByOrderByPriceDesc() {
        try {
            return productRepository.findAllByOrderByPriceDesc();
        }
        catch (Exception e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(Double price) {
        try
        {
            return productRepository.findAllByPriceGreaterThan(price);
        }
        catch (Exception e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }

    }

    @Override
    public List<Product> findAllByPriceLessThanEqual(Double price) {
        try {
            return productRepository.findAllByPriceLessThanEqual(price);
        }
        catch (Exception e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public void deleteById(Integer ID) {
        try{
            productRepository.deleteById(ID);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);

        }
    }

    @Override
    public Product findById(Integer ID) {
        try {
            return productRepository.findById(ID).orElseThrow(() -> new RuntimeException("Entity is not found"));

        } catch (Exception e) {
            Util.showGeneralExceptionInfo(e);
            return null;
        }



    }
    @Override
    public Product save(Product entity) {
        try {
            return productRepository.save(entity);
        }
        catch(IllegalArgumentException e)
        {

            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
