package com.dmall.productserivce.viewmodel;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Date;

public class ProductViewModel {

  private String prodcutId;

  private String name;

  public ProductViewModel() {
    super();

  }

  public ProductViewModel(String prodcutId, String name) {
    super();
    this.prodcutId = prodcutId;
    this.name = name;
  }

  public String getProdcutId() {
    return prodcutId;
  }

  public void setProdcutId(String prodcutId) {
    this.prodcutId = prodcutId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


}


