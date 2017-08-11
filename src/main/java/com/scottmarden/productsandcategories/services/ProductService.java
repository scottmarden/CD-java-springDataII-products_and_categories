package com.scottmarden.productsandcategories.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scottmarden.productsandcategories.models.Category;
import com.scottmarden.productsandcategories.models.Product;
import com.scottmarden.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> findAll(){
		return (List<Product>) productRepository.findAll();
	}
	
	public List<Product> findAvailProducts(Category category){
		List<Product> allProducts = (List<Product>) productRepository.findAll();
		List<Product> availProducts = new ArrayList<Product>();
		for(int i = 0; i < allProducts.size(); i++) {
			System.out.println(allProducts.get(i).getName());
			if(category.getProducts().contains(allProducts.get(i))) {
				System.out.println("In product categories!");
			}else {
				System.out.println("Not in product categories!");
				availProducts.add(allProducts.get(i));
			}
		}
		return availProducts;
	}
	
	public void createProduct(Product product) {
		productRepository.save(product);
	}
	
	public Product findOneProduct(Long id) {
		return productRepository.findOne(id);
	}
	
	public void destroyProduct(Long id) {
		productRepository.delete(id);
	}
	
	public void updateProduct(Product product) {
		productRepository.save(product);
	}
	
}
