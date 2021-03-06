package com.rakuten.Spring_Boot;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
private int productId;
private String productName;
private float price;


Product(){
}

Product(int id,String name,float price){
	this.productId=id;
	this.productName=name;
	this.price=price;
}

public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

}