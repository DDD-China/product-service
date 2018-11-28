package com.dmall.productserivce.application;

import com.dmall.productserivce.application.dto.ProductCreationRequest;
import com.dmall.productserivce.domain.Product;
import com.dmall.productserivce.infrastructure.repositories.ProductRepository;
import com.dmall.productserivce.viewmodel.ProductViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Component
public class ProductService {

  protected static final ModelMapper mapper = new ModelMapper();

  private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

  @Autowired
  private ProductRepository repository;

  @Autowired
  private ProductFactory productFactory;

  public List<ProductViewModel> getProducts() {
    return Arrays.asList(
        new ProductViewModel("p001", "Iphone 6s"),
        new ProductViewModel("p002", "Xiaomi"),
        new ProductViewModel("p003", "Oppo R11"));
  }

  public ProductViewModel getProductsById(Object productId) {

    final List<ProductViewModel> productViewModels = getProducts();

    return productViewModels.stream().filter(c -> Objects.equals(c.getProdcutId(), productId)).findAny().orElse(null);
  }

  public Long save(ProductCreationRequest request) {

    final Product product = productFactory.create(request);
    return repository.save(product);
  }
}
