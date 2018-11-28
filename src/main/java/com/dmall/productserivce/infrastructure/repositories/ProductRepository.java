package com.dmall.productserivce.infrastructure.repositories;

import com.dmall.productserivce.domain.Product;
import com.dmall.productserivce.infrastructure.repositories.dataentity.ProductDataEntity;
import com.dmall.productserivce.infrastructure.repositories.persistence.ProductJpaPersistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


}
