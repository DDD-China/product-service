package com.dmall.productservice.apis.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductCreationRequest {

  private String name = null;

  private String description = null;

  private BigDecimal price = null;
}
