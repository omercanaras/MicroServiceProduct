package com.omercan.product_app.model.service;

import javax.persistence.Entity;
import java.util.List;

public interface EntityService<E , ID>

{
    void deleteById(Integer ID);

    E findById(Integer ID);

    E save(E entity);

    List<E> getAll();


}
