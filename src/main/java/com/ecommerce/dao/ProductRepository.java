package com.ecommerce.dao;

import com.ecommerce.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;


public  interface ProductRepository extends PagingAndSortingRepository<Product, Long> {


}
