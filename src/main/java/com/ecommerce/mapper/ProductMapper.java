package com.ecommerce.mapper;

import com.ecommerce.dtos.ProductDto;
import com.ecommerce.models.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    //@Mapping(target="id", source="id")
    @Mapping(target="name", source="name")
    @Mapping(target="description", source="description")
    @Mapping(target="category", source="category")
    ProductDto entityToDto(Product product);

    @Mapping(target="id", source="id")
    @Mapping(target="name", source="name")
    @Mapping(target="description", source="description")
    @Mapping(target="category", source="category")
    Product dtoToEntity(ProductDto productDto);

    List<ProductDto> entityListToDtoList(List<Product> list);

  //  Page<ProductDto> entityPageToDtoPage(Page<Product> list);

}
