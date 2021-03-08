package com.rakuten.Spring_Boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
    @RequestMapping(method = RequestMethod.POST)
	public List<Product> AddProduct(@RequestBody Product p) {
		List<Product> list=service.getProducts();
		list.add(p);
		return service.getProducts();
	}
	
	@RequestMapping(value="/id/{pid}",produces = "application/json")
	public Product displayById(@PathVariable int pid) {
		List<Product> list=service.getProducts();
		Product product=list.stream().
				filter(p->p.getProductId()==pid).findFirst().get();
		return product;
	}
	@RequestMapping("/id/{pid}/reviews")
	public List<Review> getReviewsForProduct(@PathVariable int pid) {
		List<Product> list=service.getProducts();
		Product product=list.stream().filter(p->p.getProductId()==pid).findFirst().get();
		return product.getReviewList();
	}
	@RequestMapping("/id/{pid}/reviews/review/{rid}")
	public Review getReviewsById(@PathVariable int pid, @PathVariable("rid") int reviewId) {
		List<Product> list=service.getProducts();
		Product product=list.stream().filter(p->p.getProductId()==pid).findFirst().get();
		List<Review> reviews= product.getReviewList();
		Review review=reviews.stream().filter(r->r.getRevId()==reviewId).findFirst().get();
		return review;
	}
	
	

}
