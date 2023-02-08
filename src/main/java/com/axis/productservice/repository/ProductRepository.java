package com.axis.productservice.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axis.productservice.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Modifying
	@Query("update Product set productName=?1, productType=?2, imageUrl=?3, description=?4 where productId=?5")
	void updateProductInfo(String productName, String productType, String imageUrl,
			String description, int productId);
}

