package com.dmall.productservice.apis;

import com.dmall.productservice.apis.assembler.ProductAssembler;
import com.dmall.productservice.apis.dto.ProductCreationRequest;
import com.dmall.productservice.application.ProductService;
import com.dmall.productservice.domain.Product;
import com.dmall.productservice.viewmodel.ProductViewModel;
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

  @Autowired
  private ProductAssembler productAssembler;

  @GetMapping
  @ApiOperation("Get all products")
  public List<ProductViewModel> getAllProducts() {

    return productService.getProducts();
  }

  @ApiOperation("Get product by id")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "productId", required = true, defaultValue = "p001")
  })
  @RequestMapping(value = "/{productId}", method = RequestMethod.GET, headers = "Accept=application/json")
  public ProductViewModel getProductById(@PathVariable("productId") final String productId) {

    return productService.getProductsById(productId);
  }


  @ApiOperation("add product")
  @PostMapping
  public Long createProduct(ProductCreationRequest request) {

    Product product = productAssembler.toDomainObject(request);

    return productService.save(product);
  }
}
