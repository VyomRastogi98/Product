package com.axis.productservice.service;

import java.util.List;

import com.axis.productservice.entity.Product;

public interface ProductService {
	
	 	Product getProductById(int productId);
	    List<Product> getAllProducts();
	    void addProduct(Product product);
	    void updateProduct(int productId ,Product product);
	    void deleteProduct(int productId);
}
