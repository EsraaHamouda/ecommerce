package com.ecommerce.dao;

import com.ecommerce.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ProductRepository extends PagingAndSortingRepository<Product, Long> {


}
