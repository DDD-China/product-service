package com.dmall.productserivce.apis.assembler;

import com.dmall.productserivce.apis.dto.ProductCreationRequest;
import com.dmall.productserivce.application.ProductFactory;
import com.dmall.productserivce.domain.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class ProductAssembler {


  protected static final ModelMapper mapper = new ModelMapper();

  @Autowired
  private ProductFactory productFactory;
  private final boolean isOnSale = false;

  public Product toDomainObject(ProductCreationRequest creationRequest) {
    return productFactory.create(creationRequest.getId(), creationRequest.getName(),
        creationRequest.getDescription(), creationRequest.getPrice(), isOnSale);
  }

  public ProductCreationRequest toDto(Product product) {
    return mapper.map(product, ProductCreationRequest.class);
  }
}
