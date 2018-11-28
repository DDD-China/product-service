package com.dmall.productserivce.apis;

import com.dmall.productserivce.application.ProductService;
import com.dmall.productserivce.application.dto.ProductCreationRequest;
import com.dmall.productserivce.viewmodel.ProductViewModel;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductApi {

  @Autowired
  private ProductService productService;

  @GetMapping
  @ApiOperation("Get all products")
  public List<ProductViewModel> getCommentsByTaskId() {

    return productService.getProducts();
  }

  @ApiOperation("Get product by id")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "productId", required = true, defaultValue = "o001")
  })
  @RequestMapping(value = "/{productId}", method = RequestMethod.GET, headers = "Accept=application/json")
  public ProductViewModel getProductbyId(@PathVariable("productId") final String productId) {

    return productService.getProductsById(productId);
  }


  @PostMapping
  public Long createProduct(ProductCreationRequest request) {

    return productService.save(request);
  }
}
