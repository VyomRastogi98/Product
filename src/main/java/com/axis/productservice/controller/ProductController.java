package com.axis.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.productservice.entity.Product;
import com.axis.productservice.service.ProductService;

@CrossOrigin("http://localhost:3000/")
@RestController
public class ProductController {
	
	  @Autowired
	    private ProductService productService;
	    
	    public ProductController() {
			
		}
	    
		public ProductService getProductService() {
			return productService;
		}

		public void setProductService(ProductService productService) {
			this.productService = productService;
		}

		@GetMapping("/product/{productId}")
	    public Product getProductById(@PathVariable int productId){
	        return productService.getProductById(productId);
	    }
		
		@GetMapping("/products")
	    public List<Product> getAllProducts() {
	       return productService.getAllProducts();
	    }

	    @PostMapping("/product")
	    public ResponseEntity<String> addProduct(@RequestBody Product product){
	        productService.addProduct(product);
	        return new ResponseEntity<String>("Product Added to DB.", HttpStatus.OK);
	    }

	    @PutMapping("/product/update/{productId}")
	    public ResponseEntity<String> updateProductInfo(@PathVariable int productId,@RequestBody Product product){
	        productService.updateProduct(productId, product);
	        return new ResponseEntity<String>("Product Updated.", HttpStatus.OK);
	    }
	    
	    @DeleteMapping("/product/{productId}")
	    public ResponseEntity<String> deleteProduct(@PathVariable int productId){
	        productService.deleteProduct(productId);
	        return new ResponseEntity<String>("Product Deleted.", HttpStatus.OK);
	    }

}
