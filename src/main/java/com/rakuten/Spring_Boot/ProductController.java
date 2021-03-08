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
	
	
	@RequestMapping(value="/id/{pid}",produces = {"application/xml","application/json"})
	public Product getProductById(@PathVariable int pid) {
		List<Product> list=service.getProducts();
		Product product=list.stream().filter(p->p.getProductId()==pid).findFirst().get();
		return product;
	}
	@RequestMapping(method = RequestMethod.POST,consumes= {"application/xml","application/json"},
	produces = {"application/xml","application/json"})
	public List<Product> addProduct(@RequestBody Product p){
		List<Product> list=service.getProducts();
		list.add(p);
		return list;
		
	}
	
	@RequestMapping(produces = "application/xml")
	public ProductEntity getAllProducts(){
		ProductEntity pe=new ProductEntity();
		
		pe.setList(service.getProducts());
		return pe;
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
