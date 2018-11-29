package com.dmall.productservice.contractTest;

import com.dmall.productservice.apis.ProductController;
import com.dmall.productservice.apis.assembler.ProductAssembler;
import com.dmall.productservice.apis.dto.ProductCreationRequest;
import com.dmall.productservice.application.ProductService;
import com.dmall.productservice.domain.Product;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
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

        Product product = new Product(10L, "Mac mini", "Mac mini computer", new BigDecimal(9888.00));
        when(productAssembler.toDomainObject(any(ProductCreationRequest.class))).thenReturn(product);
        when(productService.save(any(Product.class))).thenReturn(10L);

        RestAssuredMockMvc.standaloneSetup(new ProductController(productService, productAssembler));
    }
}

