package com.rakuten.Spring_Boot;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

//import javax.xml.bind.annotation.XmlRootElement;

@Service
public class ProductService {
private List<Product> product=new ArrayList<Product>();
{
	Product p1=new Product(1,"Fastrack",2000);
	Product p2=new Product(2,"TV",40000);
	Product p3=new Product(3,"Shoe",5000);
	Product p4=new Product(4,"Trimmer",1000);
	Product p5=new Product(5,"One Plus",25000);
	product.add(p1);
	product.add(p2);
	product.add(p3);
	product.add(p4);
	product.add(p5);
	
}

public List <Product> getProducts(){
  return this.product;
}
}