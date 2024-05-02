package com.omercan.product_app.controller;

import com.omercan.product_app.model.entity.Product;
import com.omercan.product_app.model.service.AbstractProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/product")
@RestController()
public class ProductController
{
    //Serverside rendering ön yüzün render edilmesi - MVC
    //clientside rendering işlerin çoğu
    //farkları nelerdir
    //CRM uygulaması clientside render ı kullanırsın
    //JDk 11 e göre configurasyona
    //SEO
    //Tüm önyüz tasarlama araçlarına uygun olucak
    @Autowired
    private AbstractProductService productService;


    //deleteByid
    //first found


    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product)
    {

      product.setCreated(new Date());

      Product savedProduct = productService.save(product);

      return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllSortByPrice()
    {
        List<Product> productList = productService.findAllByOrderByPriceDesc();

        return ResponseEntity.ok(productList);

    }

    @GetMapping("{id}")
    public  ResponseEntity<Product> findById(@PathVariable Integer id )
    {

        Product foundProduct = productService.findById(id);

        return foundProduct!=null ? new ResponseEntity<>(foundProduct,HttpStatus.FOUND) : new ResponseEntity<>(HttpStatus.NOT_FOUND) ;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id)
    {
      /*   Optional<Product> existingProduct = Optional.ofNullable(productService.findById(id));
        if(existingProduct.isPresent()){
            this.productService.deleteById(existingProduct.get().getProductId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;*/

        Product productFound = productService.findById(id);

        if(productFound!=null)
        {
            productService.deleteById(id);
            return ResponseEntity.ok("Product that have productId: " + id + "has been deleted");


        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
