package com.dmall.productserivce.application;

import com.dmall.productserivce.application.dto.ProductCreationRequest;
import com.dmall.productserivce.domain.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ProductFactory {

  protected static final ModelMapper mapper = new ModelMapper();

  public Product create(ProductCreationRequest request) {
    return mapper.map(request, Product.class);
  }
}
