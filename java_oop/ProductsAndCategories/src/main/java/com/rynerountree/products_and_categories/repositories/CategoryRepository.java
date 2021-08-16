package com.rynerountree.products_and_categories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.rynerountree.products_and_categories.models.Category;
import com.rynerountree.products_and_categories.models.Product;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	Optional<Category> findById(Long id);
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
	void deleteById(Long id);
}
