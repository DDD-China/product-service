package com.dmall.productservice.apis;

import com.dmall.productservice.apis.assembler.ProductAssembler;
import com.dmall.productservice.apis.dto.ProductCreationRequest;
import com.dmall.productservice.apis.dto.ProductResponse;
import com.dmall.productservice.application.ProductService;
import com.dmall.productservice.domain.Product;
import com.dmall.productservice.infrastructure.repositories.dataentity.ProductDataEntity;
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
public class ProductController {

  private ProductService productService;

  private ProductAssembler productAssembler;

  @Autowired
  public ProductController(ProductService productService, ProductAssembler productAssembler) {
    this.productService = productService;
    this.productAssembler = productAssembler;
  }

  @GetMapping
  @ApiOperation("Get all products")
  public List<ProductResponse> getAllProducts() {

    final List<ProductDataEntity> products = productService.getProducts();
    return productAssembler.toProductResponseList(products);
  }

  @ApiOperation("Get product by id")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "productId", required = true, defaultValue = "1")
  })
  @RequestMapping(value = "/{productId}", method = RequestMethod.GET, headers = "Accept=application/json")
  public ProductResponse getProductById(@PathVariable("productId") final Long productId) {

    final ProductDataEntity entity = productService.getProductsById(productId);
    return productAssembler.toProductResponse(entity);
  }


  @ApiOperation("Create new product")
  @PostMapping
  public Long createProduct(ProductCreationRequest request) {

    Product product = productAssembler.toDomainObject(request);

    return productService.save(product);
  }
}
