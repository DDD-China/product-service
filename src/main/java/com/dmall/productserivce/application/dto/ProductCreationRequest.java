package com.dmall.productserivce.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductCreationRequest {
  private Long id;

  private String name = null;

  private String description = null;

  private Integer quantity = null;

  private BigDecimal price = null;

  private Boolean isOnSale = null;
}
