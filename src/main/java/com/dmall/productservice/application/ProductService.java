package com.dmall.productservice.application;

import com.dmall.productservice.domain.Product;
import com.dmall.productservice.infrastructure.repositories.ProductRepository;
import com.dmall.productservice.viewmodel.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Component
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public List<ProductViewModel> getProducts() {
    return Arrays.asList(
        new ProductViewModel("p001", "Iphone 6s"),
        new ProductViewModel("p002", "Xiaomi"),
        new ProductViewModel("p003", "Oppo R11"));
  }

  public ProductViewModel getProductsById(Object productId) {

    final List<ProductViewModel> productViewModels = getProducts();

    return productViewModels.stream().filter(c -> Objects.equals(c.getProductId(), productId)).findAny().orElse(null);
  }

  public Long save(Product product) {

    return repository.save(product);
  }
}
