package com.example.counter.data.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.counter.data.Category;
import com.example.counter.data.Product;
import com.example.counter.util.Utilities;

/**
 * Mock DAO for the project.
 * 
 * @author ValayiVi
 *
 */
public enum CounterDAO {

	INSTANCE;

	private List<Category> categories = new ArrayList<Category>();

	private List<Product> products = new ArrayList<Product>();

	private CounterDAO() {
		final int categoriesLength = 3;
		final int productsLength = 10;

		for (int index = 0; index < categoriesLength; index++) {
			final String key = "cat-" + index;
			final String name = "Category-" + index;
			categories.add(new Category(key, name, name, 10 * index));
		}

		for (int index = 0; index < productsLength; index++) {
			final String key = "" + (10000 + index);
			final String name = "Product-" + index;
			final float price = Utilities.INSTANCE.round((float) (Math.random() * 100) + 20, 2);
			final int randomCategoryIndex = (int) (Math.random() * categoriesLength);
			final Product product = new Product(key, name, name, price, categories.get(randomCategoryIndex));
			products.add(product);
		}
	}

	public List<Product> findProductByName(String term) {

		final List<Product> searchResults = new ArrayList<Product>();
		if (term != null) {
			for (final Iterator<Product> productsItr = products.iterator(); productsItr.hasNext();) {
				final Product product = productsItr.next();
				if (product.getName().toLowerCase().contains(term.toLowerCase())) {
					searchResults.add(product);
				}
			}
		}

		return searchResults;
	}

}
