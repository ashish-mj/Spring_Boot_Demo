package com.rakuten.Spring_Boot;

public class ProductNotFoundException  extends RuntimeException{
	public ProductNotFoundException(){
		
	}
	public ProductNotFoundException(String s) {
		super(s);
	}
}

