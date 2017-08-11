package com.scottmarden.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scottmarden.productsandcategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
