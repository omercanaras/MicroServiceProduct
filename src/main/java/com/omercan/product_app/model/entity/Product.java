package com.omercan.product_app.model.entity;

import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;
import java.util.Date;

@Data
@SequenceGenerator(name = "PRODUCTS_SEQUENCE", sequenceName = "OMERCAN_PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "PRODUCTS")
@Entity
public class Product
{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTS_SEQUENCE")
    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    private String name;

    private String category;

    private String description;

    private Double price;

    private Date created;
}
