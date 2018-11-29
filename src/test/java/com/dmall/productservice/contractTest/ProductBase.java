package com.dmall.productservice.contractTest;

import com.dmall.productservice.apis.ProductController;
import com.dmall.productservice.apis.assembler.ProductAssembler;
import com.dmall.productservice.apis.dto.ProductCreationRequest;
import com.dmall.productservice.apis.dto.ProductResponse;
import com.dmall.productservice.application.ProductService;
import com.dmall.productservice.domain.Product;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Ignore
@AutoConfigureMockMvc
public class ProductBase {
    @Autowired
    WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        final ProductService productService = mock(ProductService.class);
        final ProductAssembler productAssembler = mock(ProductAssembler.class);

        Product product1 = new Product(10L, "Mac mini", "Mac mini computer", new BigDecimal(9888.00));
        Product product2 = new Product(20L, "iPhone X", "iPhone 2018 new fashion", new BigDecimal(8888.00));
        List<Product> products = Arrays.asList(product1, product2);
        ProductResponse response = new ProductResponse();
        response.setId(10L);
        response.setName("Mac mini");
        response.setDescription("Mac mini computer");
        response.setPrice(new BigDecimal(9888.00));

        when(productService.getProducts()).thenReturn(products);
        when(productService.getProductsById(anyLong())).thenReturn(product1);
        when(productService.save(any(Product.class))).thenReturn(product1);


        when(productAssembler.toDomainObject(any(ProductCreationRequest.class))).thenReturn(product1);
        when(productAssembler.toProductResponse(any(Product.class))).thenReturn(response);
        when(productAssembler.toProductResponseList(anyList())).thenReturn(Arrays.asList(response));

        RestAssuredMockMvc.standaloneSetup(new ProductController(productService, productAssembler));
    }
}

