package com.scottmarden.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scottmarden.productsandcategories.models.Category;
import com.scottmarden.productsandcategories.models.Product;
import com.scottmarden.productsandcategories.services.CategoryService;
import com.scottmarden.productsandcategories.services.ProductService;


@Controller
public class MainCtrl {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public MainCtrl(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value="/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/products/new")
	public String addProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping(value="/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}else {
			productService.createProduct(product);
			return "redirect:/products";
		}
	}
	
	@RequestMapping(value="/products")
	public String showProducts(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "allProducts.jsp";
	}
	
	@RequestMapping(value="categories/new")
	public String addCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@PostMapping(value="categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}else {
			System.out.println("Category: " + category);
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="products/{product_id}")
	public String product(@PathVariable("product_id") Long id, Model model, @ModelAttribute("newCategory") Category newCategory) {
		Product product = productService.findOneProduct(id);
		List<Category> availCategories = categoryService.findAvailCategories(product);
		model.addAttribute("product", product);
		model.addAttribute("availCategories", availCategories);
		return "productDetail.jsp";
		
	}
	
	@PostMapping(value="/products/{product_id}/add_category")
	public String categoryToProduct(@PathVariable("product_id") Long product_id, @Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result) {
		if(result.hasErrors()) {
			return "productDetail.jsp";
		}else {
			System.out.println("Product id: " + product_id);
			System.out.println("New Category: " + newCategory.getId());
			Product product = productService.findOneProduct(product_id);
			Category category = categoryService.findOneCategory(newCategory.getId());
			List<Category> productCategories = product.getCategories();
			productCategories.add(category);
			product.setCategories(productCategories);
			productService.updateProduct(product);
			
			return "redirect:/products/" + product_id;
		}

	}
	
	@RequestMapping(value="/categories")
	public String allCategories(Model model) {
		List<Category> categories = categoryService.findCategories();
		model.addAttribute("categories", categories);
		return "allCategories.jsp";
	}
	
	@RequestMapping(value="/categories/{category_id}")
	public String category(@PathVariable("category_id") Long category_id, Model model, @ModelAttribute("newProduct") Product newProduct) {
		Category category = categoryService.findOneCategory(category_id);
		List<Product> availProducts = productService.findAvailProducts(category);
		model.addAttribute("category", category);
		model.addAttribute("availProducts", availProducts);
		return "categoryDetail.jsp";
	}
	
	@PostMapping(value="/categories/{category_id}/add_product")
	public String productToCategory(@PathVariable("category_id") Long category_id, @Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result) {
		if(result.hasErrors()) {
			return "categoryDetail.jsp";
		}else {
			Category category = categoryService.findOneCategory(category_id);
			Product product = productService.findOneProduct(newProduct.getId());
			List<Product> categoryProducts = category.getProducts();
			categoryProducts.add(product);
			category.setProducts(categoryProducts);
			categoryService.updateCategory(category);
			return "redirect:/categories/" + category.getId();
		}
	}
	
	
	
	@RequestMapping(value="products/delete/{id}")
	public String product(@PathVariable("id") Long id) {
		productService.destroyProduct(id);
		return "redirect:/products";
	}
	
}
