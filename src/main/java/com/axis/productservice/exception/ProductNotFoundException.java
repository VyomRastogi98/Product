package com.axis.productservice.exception;

public class ProductNotFoundException  extends RuntimeException {


	private static final long serialVersionUID = -465322L;

	public ProductNotFoundException() {
		super();
		
	}

	public ProductNotFoundException(String message) {
		super(message);
		
	}


}
