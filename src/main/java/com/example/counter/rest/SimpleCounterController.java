package com.example.counter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.counter.data.Product;
import com.example.counter.services.ProductService;

/**
 * Exposes the Checkout resources via this RESTful service. Deals primarily with
 * the Counter and Product related operations.
 * 
 * @author Vinu
 */
@Controller
@RequestMapping("/counter")
public class SimpleCounterController {

	@Autowired
	ProductService service;

	/**
	 * This method will return the json object containing the structure of the
	 * landing page for a specific domain
	 */
	@RequestMapping(value = "/product/lookup/", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List<Product> productLookup(
			@RequestParam(defaultValue = "", required = true, value = "query") String query) {

		final List<Product> results = service.lookup(query);

		return results;
	}

}
