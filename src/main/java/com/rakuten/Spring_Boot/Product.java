package com.rakuten.Spring_Boot;

public class Product {
private int productId;
private String productName;
private float price;
private float ratings;

Product(){
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
public float getRatings() {
	return ratings;
}
public void setRatings(float ratings) {
	this.ratings = ratings;
}
}