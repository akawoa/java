package com.rynerountree.products_and_categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rynerountree.products_and_categories.models.Category;
import com.rynerountree.products_and_categories.models.Product;
import com.rynerountree.products_and_categories.repositories.CategoryRepository;
import com.rynerountree.products_and_categories.repositories.ProductRepository;


@Service
public class MainService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	// --------------------  CRUD FOR CATEGORIES ------------------//
	//finds all Categories
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	//creates a category
	public Category saveCategory(Category c) {
		return categoryRepo.save(c);
	}
	
	public Category findCategory(Long cat_id) {
		return categoryRepo.findById(cat_id).orElse(null);
	}
	
	
//	// retrieves a category by their id
//	public Category findCategory(Long id) {
//        Optional<Category> optionalCategory = categoryRepo.findById(id);
//        if(optionalCategory.isPresent()) {
//            return optionalCategory.get();
//        } else {
//            return null;
//        }
//	}
	
	
	//deletes a category by their id
	public void deleteCategory(Long category_id) {
		categoryRepo.deleteById(category_id);
	}
	
	// --------------------  CRUD FOR PRODUCTS ------------------//
	
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	public Product findProduct(Long prod_id) {
		return productRepo.findById(prod_id).orElse(null);
	}
	
	//saves a product
	public Product saveProduct(Product p) {
		return productRepo.save(p);
	}
	//deletes a product
	public void deleteProduct(Long product_id) {
		productRepo.deleteById(product_id);
	}
	
}
