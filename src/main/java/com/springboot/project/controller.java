package com.springboot.project;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class controller {

	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public String saveProduct(@RequestBody Product product) throws InterruptedException, ExecutionException 
	{
		return productService.saveProduct(product);
	}
	
	
	
	@GetMapping("/products/{name}")
	public Product getProduct(@PathVariable String name) throws InterruptedException, ExecutionException 
	{
		return productService.getProductDetailsByName(name);
	}
	
	
	@PutMapping("/products")
	public String update(@RequestBody Product product) throws InterruptedException, ExecutionException 
	{
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/products/{name}")
	public String deleteProduct(@PathVariable String name) throws InterruptedException, ExecutionException 
	{
		return productService.deleteProduct(name);
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() throws InterruptedException, ExecutionException 
	{
		return productService.getProductDetails();
	}
	
}
