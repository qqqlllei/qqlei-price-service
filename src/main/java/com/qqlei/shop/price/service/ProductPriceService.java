package com.qqlei.shop.price.service;

import com.qqlei.shop.price.model.ProductPrice;

public interface ProductPriceService {
	
	public void add(ProductPrice productPrice);
	
	public void update(ProductPrice productPrice);
	
	public void delete(Long id);
	
	public ProductPrice findById(Long id);
	
}
