package com.rakuten.Spring_Boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@RequestMapping("/test")
	public String test() {
		return "Welcome Client";
	}
	
	

}
