package com.rakuten.Spring_Boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
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

}
