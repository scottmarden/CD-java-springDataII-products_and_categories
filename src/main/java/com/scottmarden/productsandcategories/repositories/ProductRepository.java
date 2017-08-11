package com.scottmarden.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scottmarden.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
