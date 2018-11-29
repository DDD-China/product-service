package com.dmall.productservice.application;

import com.dmall.productservice.domain.Product;
import com.dmall.productservice.infrastructure.repositories.ProductRepository;
import com.dmall.productservice.infrastructure.repositories.dataentity.ProductDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public List<ProductDataEntity> getProducts() {
    return repository.findAll();
  }

  public ProductDataEntity getProductsById(Long productId) {

    return repository.findById(productId);

  }

  public Long save(Product product) {

    return repository.save(product);
  }
}
