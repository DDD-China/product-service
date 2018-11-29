package com.dmall.productservice.infrastructure.repositories;

import com.dmall.productservice.domain.Product;
import com.dmall.productservice.infrastructure.repositories.dataentity.ProductDataEntity;
import com.dmall.productservice.infrastructure.repositories.persistence.ProductJpaPersistence;
import com.google.common.collect.Lists;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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


    public Product findById(Long productId) {
        Optional<ProductDataEntity> product = repository.findById(productId);
        if (product.isPresent()) {
            return mapper.map(product, Product.class);
        } else {
            return null;
        }
    }

    public List<Product> findAll() {
        List<Product> result = Lists.newArrayList();

        for (ProductDataEntity product : repository.findAll()) {
            result.add(mapper.map(product, Product.class));
        }

        return result;
    }
}
