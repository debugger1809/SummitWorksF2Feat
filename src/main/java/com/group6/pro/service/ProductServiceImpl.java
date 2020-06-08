package com.group6.pro.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group6.pro.model.Product;
import com.group6.pro.repository.ProductRepository;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(Product product) 
    {
    	productRepository.save(product);
    }

	@Override
//	public Optional<Product> findById(long id)
	public Product findById(long id)
	{
		Optional<Product> p = productRepository.findById(id);
		if(p.isPresent())
			return p.get();
		return null;
	}
}
