package com.ecommerce.service;

import com.ecommerce.dao.ProductRepository;
import com.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id).orElseGet(null);
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long productId, Product product) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent())
            return productRepository.save(product);
        else return null;
    }
}
