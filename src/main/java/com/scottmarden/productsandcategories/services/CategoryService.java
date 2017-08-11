package com.scottmarden.productsandcategories.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scottmarden.productsandcategories.models.Category;
import com.scottmarden.productsandcategories.models.Product;
import com.scottmarden.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> findCategories(){
		return (List<Category>) categoryRepository.findAll();
	}
	
	public List<Category> findAvailCategories(Product product){
		List<Category> allCategories = (List<Category>) categoryRepository.findAll();
		List<Category> availCategories = new ArrayList<Category>();
		for(int i = 0; i < allCategories.size(); i++) {
			System.out.println(allCategories.get(i).getName());
			if(product.getCategories().contains(allCategories.get(i))) {
				System.out.println("In product categories!");
			}else {
				System.out.println("Not in product categories!");
				availCategories.add(allCategories.get(i));
			}
		}
		return availCategories;
	}
	
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public Category findOneCategory(Long id) {
		return categoryRepository.findOne(id);
	}
	
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}
}
