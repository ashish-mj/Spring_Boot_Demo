package com.rakuten.Spring_Boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/test")
	public String test() {
		return "Welcome Client";
	}
	
	@RequestMapping("/sample")
	public Product sample() {
		
		Product p=new Product();
		p.setProductId(1);
		p.setProductName("Phone");
		p.setPrice(10000f);
		return p;
		
	}
	
	@RequestMapping
	public List<Product> display() {
		return service.getProducts();
	}
	
	

}
