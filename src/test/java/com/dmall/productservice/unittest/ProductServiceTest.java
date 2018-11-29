package com.dmall.productservice.unittest;

import com.dmall.productservice.application.ProductService;
import com.dmall.productservice.domain.Product;
import com.dmall.productservice.infrastructure.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository repository;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCallRepositoryToFindProductById() {
        Long productId = 100L;
        Product expected = new Product(productId, "iPhone", "newest iPhone", new BigDecimal(1000.00));

        when(repository.findById(productId)).thenReturn(expected);

        productService.getProductsById(productId);
        verify(repository, atLeastOnce()).findById(productId);
    }
}
