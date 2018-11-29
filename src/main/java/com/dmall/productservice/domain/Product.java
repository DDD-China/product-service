
package com.dmall.productservice.domain;

import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Boolean isOnSale;

    public Product(Long id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}

