
package com.dmall.productserivce.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class Product {

  private Long id;

  private String name = null;

  private String description = null;

  private Integer quantity = null;

  private BigDecimal price = null;

  private Boolean isOnSale = null;

  public Product(Long id, String name, String description, Integer quantity, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.price = price;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

