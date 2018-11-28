package com.dmall.productservice.application;

<<<<<<< HEAD:src/main/java/com/dmall/productservice/application/ProductFactory.java
import com.dmall.productservice.domain.Product;
=======
import com.dmall.productserivce.domain.Product;
>>>>>>> product add feature.:src/main/java/com/dmall/productserivce/application/ProductFactory.java
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class ProductFactory {

  protected static final ModelMapper mapper = new ModelMapper();

  public Product create(String name, String description, BigDecimal price, Boolean isOnSale) {
    return Product.builder()
        .name(name)
        .description(description)
        .price(price)
        .isOnSale(isOnSale)
        .build();
  }
}
