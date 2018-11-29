package com.dmall.productservice.infrastructure.repositories;

import com.dmall.productservice.domain.Product;
import com.dmall.productservice.infrastructure.repositories.dataentity.ProductDataEntity;
import com.dmall.productservice.infrastructure.repositories.persistence.ProductJpaPersistence;

import com.google.common.collect.Lists;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepository {

  protected static final ModelMapper mapper = new ModelMapper();

  @Autowired
  private ProductJpaPersistence repository;

  public Long save(Product product) {
    final ProductDataEntity dataEntity = mapper.map(product, ProductDataEntity.class);

    repository.save(dataEntity);

    return dataEntity.getId();
  }


  public ProductDataEntity findById(Long productId) {
    return repository.findById(productId).orElse(null);
  }

  public List<ProductDataEntity> finndAll() {
    List<ProductDataEntity> result = Lists.newArrayList();

    repository.findAll().forEach(result::add);

    return result;
  }
}
