package com.dmall.productservice.apis;

import com.dmall.productservice.apis.assembler.ProductAssembler;
import com.dmall.productservice.apis.dto.ProductCreationRequest;
import com.dmall.productservice.apis.dto.ProductResponse;
import com.dmall.productservice.application.ProductService;
import com.dmall.productservice.domain.Product;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collections;
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
        final List<Product> products = productService.getProducts();
        return productAssembler.toProductResponseList(products);
    }

    @ApiOperation("Get product by id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", required = true, defaultValue = "1")
    })
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ProductResponse getProductById(@PathVariable("productId") final Long productId) {

        final Product product = productService.getProductsById(productId);
        return productAssembler.toProductResponse(product);
    }


    @ApiOperation("Create new product")
    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductCreationRequest request) {
        Product product = productAssembler.toDomainObject(request);
        return productAssembler.toProductResponse(productService.save(product));
    }

    @ApiOperation("update product info")
    @RequestMapping(value = "/{productId}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateProduct(@PathVariable("productId") final Long productId,
                              @RequestBody ProductCreationRequest request){
        Product newProduct = productAssembler.toDomainObject(request);
        Product oldProduct = productService.getProductsById(productId);
        if(newProduct.getName() != null){
            oldProduct.setName(newProduct.getName());
        }
        if(newProduct.getDescription() != null){
            oldProduct.setDescription(newProduct.getDescription());

        }
        if (newProduct.getPrice() != null) {
            oldProduct.setPrice(newProduct.getPrice());
        }
        productService.save(oldProduct);
    }
}
