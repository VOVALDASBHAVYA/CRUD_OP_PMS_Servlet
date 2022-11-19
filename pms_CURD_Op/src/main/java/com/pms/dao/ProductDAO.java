package com.pms.dao;

import java.util.List;

import com.ojas.model.Product;

public interface ProductDAO {
	public String createProduct(Product product);
	public Product viewProduct(int pid);
	public List<Product> viewAllProducts();
	public String updateProduct(int pid,Product updateProduct);
	public String deleteProduct(int pid);
	

}
