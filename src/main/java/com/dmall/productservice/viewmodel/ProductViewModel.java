package com.dmall.productservice.viewmodel;

public class ProductViewModel {

  private String productId;

  private String name;

  public ProductViewModel() {
    super();

  }

  public ProductViewModel(String productId, String name) {
    super();
    this.productId = productId;
    this.name = name;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


}


