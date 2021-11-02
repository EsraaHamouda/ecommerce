package com.ecommerce.mapper;

import com.ecommerce.dtos.ProductDto;
import com.ecommerce.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto entityToDto(Product car);

    Product dtoToEntity(ProductDto carDto);

    List<ProductDto> entityListToDtoList(List<Product> list);

    Page<ProductDto> entityPageToDtoPage(Page<Product> list);

}
