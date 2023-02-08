package com.axis.productservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.productservice.entity.Product;
import com.axis.productservice.exception.ProductNotFoundException;
import com.axis.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductById(int productId) {
		Optional<Product> productOpt = productRepository.findById(productId);
		if(!productOpt.isPresent())
			throw new ProductNotFoundException("Product Not Found by Id "+productId);
		return  productOpt.get();
	}
	
	@Override
	public List<Product> getAllProducts() {
		
		return (List<Product>) productRepository.findAll(); 
	}

	@Override
	public void addProduct(Product product) {
		 productRepository.save(product);

	}

	@Transactional
	@Override
	public void updateProduct(int productId, Product product) {
		productRepository.updateProductInfo(product.getProductName(),
											product.getProductType(),
											product.getImageUrl(),
											product.getDescription(),
											product.getProductId());

	}
	@Override
	public void deleteProduct(int productId) {
		Optional<Product> productOpt = productRepository.findById(productId);
		if(!productOpt.isPresent())
			throw new ProductNotFoundException("Product Not Found by Id "+productId);
		productRepository.deleteById(productId);

	}
}
