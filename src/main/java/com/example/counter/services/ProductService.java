package com.example.counter.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.counter.data.Product;
import com.example.counter.data.dao.CounterDAO;

@Service("products")
public class ProductService {

	public List<Product> lookup(String term) {
		final List<Product> products = CounterDAO.INSTANCE.findProductByName(term);
		return products;
	}

}
