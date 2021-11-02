package com.ecommerce.controllers;

import com.ecommerce.dtos.ProductDto;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.models.Product;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;

@Controller
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathParam("id") Long id) {
        Product product = productService.findById(id);
        if (product == null)
            return ResponseEntity.notFound().build();

        ProductDto productDto = productMapper.entityToDto(product);

        return ResponseEntity.ok(productDto);

    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        Product productToInsert = productMapper.dtoToEntity(productDto);
        Product product = productService.save(productToInsert);
        ProductDto result = productMapper.entityToDto(product);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> getProducts(Pageable pageable) {
        Page<Product> productPage = productService.findAll(pageable);
        Page<ProductDto> productPageDto = productMapper.entityPageToDtoPage(productPage);

        return ResponseEntity.ok(productPageDto);

    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@PathParam("id") Long id, @RequestBody ProductDto productDto) {
        Product productToUpdate = productMapper.dtoToEntity(productDto);
        Product product = productService.update(id, productToUpdate);
        if (product == null)
            return ResponseEntity.notFound().build();
        ProductDto result = productMapper.entityToDto(product);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);


    }

    @DeleteMapping
    public ResponseEntity deleteProduct(@PathParam("id") Long id) {

        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
