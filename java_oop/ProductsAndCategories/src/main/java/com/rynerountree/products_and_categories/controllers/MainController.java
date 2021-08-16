package com.rynerountree.products_and_categories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rynerountree.products_and_categories.models.Product;
import com.rynerountree.products_and_categories.models.Category;
import com.rynerountree.products_and_categories.services.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/")
	public String index(
			Model model
	) {
		// GRAB ALL CATEGORIES FROM DB
		List<Category> allCategories = mainService.allCategories();
		// PASS THE CATEGORIES TO JSP
		model.addAttribute("categories", allCategories);
		// GRAB ALL Products FROM DB
		List<Product> allProducts = mainService.allProducts();
		// PASS THE CATEGORIES TO JSP
		model.addAttribute("products", allProducts);
		return "index.jsp";
	}
	
	
	@GetMapping("/products/new")
	public String newProduct(
			@ModelAttribute("productObj") Product emptyObj
	) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String newProd(
			@ModelAttribute("productObj") Product filledObj
	) {
		mainService.saveProduct(filledObj);
		return "redirect:/";
	}
	
	
	@GetMapping("/categories/new")
	public String newCat(
			@ModelAttribute("categoryObj") Category emptyCategory
	) {
		return "category.jsp";
	}
	
	@PostMapping("/categories/new")
	public String newProd(
			@ModelAttribute("categoryObj") Category filledCategory
	) {
		mainService.saveCategory(filledCategory);
		return "redirect:/";
	}
	
	// -------------------- CREATING THE RELATINOSHP --------------//
	@GetMapping("/products/{id}")
	public String oneProduct(
			@PathVariable("id") Long prod_id, Model model
	) {
		model.addAttribute("product", mainService.findProduct(prod_id));
		model.addAttribute("categories", mainService.allCategories());
		
		return "product.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String addCategoryToProduct(
			@PathVariable("id") Long prod_id,
			@RequestParam("category_id") Long cat_id
	) {
		// USING THE IDS, FIND PRODUCT AND CATEGORY OBJ
		Category oneCat = mainService.findCategory(cat_id);
		Product oneProd = mainService.findProduct(prod_id);
		
		// ADD THE RELATIONSHIP TO THE OBJECTS
		oneCat.getProducts().add(oneProd);
//		oneProd.getCategories().add(oneCat);
		
		// SAVE THE NEW INFORMATION IN THE DB
		mainService.saveCategory(oneCat);
//		mainServ.saveProduct(oneProd);
		
		return "redirect:/products/" + prod_id;
		
	}
	
	@GetMapping("/categories/{id}")
	public String oneCategory(
			@PathVariable("id") Long cat_id, Model model
	) {
//		model.addAttribute("product", mainService.findProduct(prod_id));
		model.addAttribute("category", mainService.findCategory(cat_id));
//		model.addAttribute("categories", mainService.allCategories());
		model.addAttribute("products", mainService.allProducts());
		
		return "categoryProducts.jsp";
	}	
	
	@PostMapping("/categories/{id}")
	public String addProductToCategory(
//			@PathVariable("id") Long prod_id,
			@PathVariable("id") Long cat_id,
//			@RequestParam("category_id") Long cat_id
			@RequestParam("product_id") Long prod_id
	) {
		// USING THE IDS, FIND PRODUCT AND CATEGORY OBJ
		Category oneCat = mainService.findCategory(cat_id);
		Product oneProd = mainService.findProduct(prod_id);
		
		// ADD THE RELATIONSHIP TO THE OBJECTS
//		oneCat.getProducts().add(oneProd);
		oneProd.getCategories().add(oneCat);
		
		// SAVE THE NEW INFORMATION IN THE DB
//		mainService.saveCategory(oneCat);
		mainService.saveProduct(oneProd);
		
		return "redirect:/categories/" + cat_id;
		
	}
	
	
	
	
}
