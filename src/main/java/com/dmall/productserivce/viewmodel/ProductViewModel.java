package com.dmall.productserivce.viewmodel;

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


