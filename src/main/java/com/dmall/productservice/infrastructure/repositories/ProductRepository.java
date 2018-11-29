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
        //TODO: implement this
        return 10L;
    }


    public Product findById(Long productId) {
        Optional<ProductDataEntity> product = repository.findById(productId);
        return product.map(productDataEntity -> mapper.map(productDataEntity, Product.class)).orElse(null);
    }

    public List<Product> findAll() {
        List<Product> result = Lists.newArrayList();

        //TODO: implement this

        return result;
    }
}
