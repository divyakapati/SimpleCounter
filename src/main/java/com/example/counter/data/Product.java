package com.example.counter.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "@BeanType")
@JsonTypeName("ProductBean")
public class Product implements BaseResource {
	private String key;
	private String name;
	private String label;
	private Category category;
	private float price;
	private float taxAmount;

	public Product() {
	}

	public Product(final String key, final String name, final String label, final float price, final Category category) {
		this.key = key;
		this.name = name;
		this.label = label;
		this.price = price;
		this.category = category;
		this.category.getProducts().add(this);
		this.taxAmount = this.price * this.category.getTax() / 100;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}


}
