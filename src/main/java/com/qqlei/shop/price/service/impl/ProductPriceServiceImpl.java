package com.qqlei.shop.price.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qqlei.shop.price.mapper.ProductPriceMapper;
import com.qqlei.shop.price.model.ProductPrice;
import com.qqlei.shop.price.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

	@Autowired
	private ProductPriceMapper productPriceMapper;

	@Autowired
	private JedisCluster jedisCluster;
	
	public void add(ProductPrice productPrice) {
		productPriceMapper.add(productPrice);
		jedisCluster.set("product_price_" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
	}

	public void update(ProductPrice productPrice) {
		productPriceMapper.update(productPrice);
		jedisCluster.set("product_price_" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
	}

	public void delete(Long id) {
		ProductPrice productPrice = findById(id);
		productPriceMapper.delete(id);
		jedisCluster.del("product_price_" + productPrice.getProductId());
	}

	public ProductPrice findById(Long id) {
		return productPriceMapper.findById(id);
	}

}
