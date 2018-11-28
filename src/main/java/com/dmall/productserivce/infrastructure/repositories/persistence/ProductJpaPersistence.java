package com.dmall.productserivce.infrastructure.repositories.persistence;

import com.dmall.productserivce.infrastructure.repositories.dataentity.ProductDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaPersistence extends CrudRepository<ProductDataEntity, Long> {

}
