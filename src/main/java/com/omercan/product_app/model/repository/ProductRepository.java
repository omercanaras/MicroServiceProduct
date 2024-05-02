package com.omercan.product_app.model.repository;

import com.omercan.product_app.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    //Select * from products order by price desc;
    //Select * from products where price > ? ;
    //Select * from products where price <= ? ;
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findAllByPriceGreaterThan(Double price);
    List<Product> findAllByPriceLessThanEqual(Double price);

}
