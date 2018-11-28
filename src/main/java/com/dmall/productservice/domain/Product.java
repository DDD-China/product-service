
package com.dmall.productservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@Getter
public class Product {

  private Long id;

  private String name = null;

  private String description = null;

  private BigDecimal price = null;

  private Boolean isOnSale = null;

  public Product(Long id, String name, String description, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

